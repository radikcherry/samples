package com.epam.wmrobo.integrator.provider.quandl;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.epam.wmrobo.integrator.model.SimpleTickerData;

public class QuandlDataParser {
    
    public static SimpleTickerData parseDataSetLine(String line, String symbol) {
        String[] tokens = line.split(",");
        if (tokens.length == 2)
            return new SimpleTickerData(
                symbol, 
                LocalDate.parse(tokens[0]), 
                new BigDecimal(tokens[4]),
                new BigDecimal(tokens[1]),
                new BigDecimal(tokens[2]),
                new BigDecimal(tokens[3]),
                new BigDecimal(tokens[5]));
        else
            return null;
    }
    
    
    public static SimpleTickerData parseDataTableLine(String line) {
        String[] tokens = line.split(",");
        if (tokens.length == 3)
            return new SimpleTickerData(
                tokens[0], 
                LocalDate.parse(tokens[1]), 
                new BigDecimal(tokens[2]),
                new BigDecimal(tokens[3]),
                new BigDecimal(tokens[4]),
                new BigDecimal(tokens[5]),
                new BigDecimal(tokens[6]));
        else
            return null;
    }

}
