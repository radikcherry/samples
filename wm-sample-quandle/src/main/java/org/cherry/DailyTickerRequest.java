package org.cherry;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DailyTickerRequest {
    
    private LocalDate fromDate;
    private LocalDate toDate;
    private List<String> symbols = new ArrayList<>();
    
    
    public DailyTickerRequest(LocalDate fromDate, LocalDate toDate, List<String> symbols) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.symbols = symbols;
    }


    public LocalDate getFromDate() {
        return fromDate;
    }


    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }


    public LocalDate getToDate() {
        return toDate;
    }


    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }


    public List<String> getSymbols() {
        return symbols;
    }


    public void setSymbols(List<String> symbols) {
        this.symbols = symbols;
    }

}
