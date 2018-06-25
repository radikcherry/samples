package org.cherry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.threeten.bp.LocalDate;

import com.jimmoores.quandl.DataSetRequest;
import com.jimmoores.quandl.Frequency;
import com.jimmoores.quandl.Row;
import com.jimmoores.quandl.SessionOptions;
import com.jimmoores.quandl.TabularResult;
import com.jimmoores.quandl.classic.ClassicQuandlSession;

public class SampleMain {

    public static void main(String[] args) {
        DailyTickerRequest request = 
                new DailyTickerRequest(
                    java.time.LocalDate.parse("2017-12-06"), 
                    java.time.LocalDate.parse("2017-12-08"), 
                    Arrays.asList("SSE/VROS","SSE/N2X1","SSE/DWB"));
            
            processRequest(request);
    }

    public static void processRequest(DailyTickerRequest request) {
        SessionOptions options = SessionOptions.Builder.withAuthToken("YqDHC8u5D4DsVqdBwj1E").build();
        ClassicQuandlSession session = ClassicQuandlSession.create(options);
        LocalDate startDate = LocalDate.of(request.getFromDate().getYear(), request.getFromDate().getMonthValue(), request.getFromDate().getDayOfMonth());
        LocalDate endDate = LocalDate.of(request.getToDate().getYear(), request.getToDate().getMonthValue(), request.getToDate().getDayOfMonth());
        
        for (String symbol : request.getSymbols()) {
            TabularResult tabularResult = session.getDataSet(
                DataSetRequest.Builder
                    .of(symbol)
                    .withStartDate(startDate)
                    .withEndDate(endDate)
                    .withFrequency(Frequency.DAILY)
                    .withColumn(3)
                    .build());

            List<SimpleDailyTickerData> result = new ArrayList<>();
            for (Row row : tabularResult) {
                System.out.println(row.toString());
                result.add(new SimpleDailyTickerData(
                    symbol, java.time.LocalDate.parse(row.getString(0)), BigDecimal.valueOf(row.getDouble(1))));
            } 
        }
    }
}
