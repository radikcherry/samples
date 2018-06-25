package com.epam.wmrobo.integrator.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SimpleTickerData {
    
    private String symbol;
    private LocalDate date;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal volume;

    public SimpleTickerData() {
    }


    public SimpleTickerData(String symbol, LocalDate date, 
            BigDecimal open, BigDecimal high, BigDecimal low,
            BigDecimal close, BigDecimal volume) {
        this.symbol = symbol;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }


    public String getSymbol() {
        return symbol;
    }


    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }


    public BigDecimal getOpen() {
        return open;
    }


    public void setOpen(BigDecimal open) {
        this.open = open;
    }


    public BigDecimal getHigh() {
        return high;
    }


    public void setHigh(BigDecimal high) {
        this.high = high;
    }


    public BigDecimal getLow() {
        return low;
    }


    public void setLow(BigDecimal low) {
        this.low = low;
    }


    public BigDecimal getClose() {
        return close;
    }


    public void setClose(BigDecimal close) {
        this.close = close;
    }


    public BigDecimal getVolume() {
        return volume;
    }


    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName()+": {"
           + "symbol: "   + symbol
           + ", date: "   + date
           + ", open: "   + open
           + ", high: "   + high
           + ", low: "    + low
           + ", close: "  + close
           + ", volume: " + volume + "}";
    }

}
