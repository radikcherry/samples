package com.epam.wmrobo.integrator.provider.quandl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.epam.wmrobo.integrator.model.DataSetType;
import com.epam.wmrobo.integrator.model.SimpleTickerData;
import com.epam.wmrobo.integrator.model.TickerMetadata;
import com.epam.wmrobo.integrator.model.TickerRequest;
import com.google.common.collect.Lists;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class QuandlTickerProvider {
    
    private static final String DATASET_URL_TEMLATE = 
        "%s/datasets/%s/%s/data.csv?column_index=3&start_date=%s&end_date=%s&api_key=%s";
    
    private static final String DATATAB_URL_TEMLATE =
         "%s/datatables/%s/PRICES.csv?ticker=%s&qopts.columns=ticker,date,close&date.gte=%s&date.lte=%s&api_key=%s";
    
    @Value("${wm-robo.integrator.supplier.quandl.api-url:}")
    public String baseUrl;
    
    @Value("${wm-robo.integrator.supplier.quandl.api-key:}")
    public String apiKey;

    
    public Flux<SimpleTickerData> processRequest(Mono<TickerRequest> task) {
        TickerRequest request = task.block();
        
        Map<String, List<String>> grpTabs =
            request.getTickers().stream()
                .filter(a -> a.getType().equals(DataSetType.TAB))
                .collect(
                    Collectors.groupingBy(TickerMetadata::getDataset, 
                        Collectors.mapping(TickerMetadata::getSymbol, Collectors.toList())
                    )
                 );
        
        return Flux.fromStream(Stream.concat(
            grpTabs.entrySet().stream()
                .flatMap(a -> readDataTableChunked(a.getKey(), a.getValue(), request.getStartDate(), request.getEndDate())),
            request.getTickers().stream()
                .filter(b -> b.getType().equals(DataSetType.SET))
                .flatMap(b -> readDataSet(b.getDataset(), b.getSymbol(), request.getStartDate(), request.getEndDate()))
        ));
    }
    
    
    private Stream<SimpleTickerData> readDataSet(String dataset, String symbol, LocalDate dateStart, LocalDate dateEnd) {
        try {
            Thread.sleep(100);
            URL url = getDataSetUrl(dataset, symbol, dateStart, dateEnd);
            System.out.println("URL: "+url.toString());
                
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = 
                    new BufferedReader(new InputStreamReader(connection.getInputStream()));
                
                return reader.lines()
                        .skip(1) // skip header
                        .map(str -> QuandlDataParser.parseDataSetLine(str, symbol))
                        .filter(a -> a != null);
            }
            else
                throw new IOException("HTTP Request Response Code: " + responseCode);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    private Stream<SimpleTickerData> readDataTableChunked(String dataset, List<String> symbols, LocalDate dateStart, LocalDate dateEnd) {
        int maxChunkSize = (int) Math.max((ChronoUnit.DAYS.between(dateStart, dateEnd) + 1) / 10000, 40);
        return Lists.partition(symbols, maxChunkSize).stream()
                .flatMap(chunk -> readDataTable(dataset, chunk, dateStart, dateEnd));
    }
    
    
    private Stream<SimpleTickerData> readDataTable(String dataset, List<String> symbols, LocalDate dateStart, LocalDate dateEnd) {
        try {
            Thread.sleep(100);
            URL url = getDataTableUrl(dataset, String.join(",",symbols), dateStart, dateEnd);
            System.out.println("URL: "+url.toString());
                
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = 
                    new BufferedReader(new InputStreamReader(connection.getInputStream()));
                
                return reader.lines()
                        .skip(1) // skip header
                        .map(str -> QuandlDataParser.parseDataTableLine(str))
                        .filter(a -> a != null);
            }
            else
                throw new IOException("HTTP Request Response Code: " + responseCode);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    private URL getDataSetUrl(String dataset, String symbol, LocalDate dateStart, LocalDate dateEnd) throws MalformedURLException {
        String s = String.format(DATASET_URL_TEMLATE, 
            baseUrl, dataset, symbol, dateStart, dateEnd, apiKey);
        return new URL(s);
    }
    
    
    private URL getDataTableUrl(String dataset, String symbol, LocalDate dateStart, LocalDate dateEnd) throws MalformedURLException {
        String s = String.format(DATATAB_URL_TEMLATE, 
            baseUrl, dataset, symbol, dateStart, dateEnd, apiKey);
        return new URL(s);
    }
    
}
