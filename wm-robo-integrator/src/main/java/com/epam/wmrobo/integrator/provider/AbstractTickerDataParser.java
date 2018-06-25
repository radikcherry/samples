package com.epam.wmrobo.integrator.provider;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.epam.wmrobo.integrator.model.SimpleTickerData;

public abstract class AbstractTickerDataParser {

    protected int[] indexes = new int[7];
    
    
    protected AbstractTickerDataParser(String headLine, String[] template) {
        String[] tokens = headLine.split(",");
        for (int i=0; i<template.length; i++)
            for (int j=0; j<tokens.length; j++)
                if (template[i] != null && tokens[j] != null && template[i].equals(tokens[j]))
                    indexes[i] = j;
    }

    
    public SimpleTickerData parseDataTableLine(String line) {
        String[] tokens = line.split(",");
        if (tokens.length == indexes.length)
            return new SimpleTickerData(
                tokens[indexes[0]], 
                LocalDate.parse(tokens[indexes[1]]), 
                new BigDecimal(tokens[indexes[2]]),
                new BigDecimal(tokens[indexes[3]]),
                new BigDecimal(tokens[indexes[4]]),
                new BigDecimal(tokens[indexes[5]]),
                new BigDecimal(tokens[indexes[6]]));
        else
            return null;
    }

    
    public SimpleTickerData parseDataTableLine(String symbol, String line) {
        String[] tokens = line.split(",");
        if (tokens.length == indexes.length-1)
            return new SimpleTickerData(
                symbol, 
                LocalDate.parse(tokens[indexes[1]]), 
                new BigDecimal(tokens[indexes[2]]),
                new BigDecimal(tokens[indexes[3]]),
                new BigDecimal(tokens[indexes[4]]),
                new BigDecimal(tokens[indexes[5]]),
                new BigDecimal(tokens[indexes[6]]));
        else
            return null;
    }
    
}
