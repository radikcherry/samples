package org.cherry;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SimpleDailyTickerData {
    
    private String symbol;
    private LocalDate date;
    private BigDecimal value;

    public SimpleDailyTickerData(String symbol, LocalDate date, BigDecimal value) {
        this.symbol = symbol;
        this.date = date;
        this.value = value;
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


    public BigDecimal getValue() {
        return value;
    }


    public void setValue(BigDecimal value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName()+": {"
           + "symbol: "   + symbol
           + ", date: "   + date
           + ", value: " + value + "}";
    }

}
