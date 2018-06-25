package com.epam.wmrobo.integrator.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TickerRequest {
    
    private LocalDate startDate;
    private LocalDate endDate;
    private List<TickerMetadata> tickers = new ArrayList<>();
    
    
    public TickerRequest() {
    }

    public TickerRequest(LocalDate startDate, LocalDate endDate, List<TickerMetadata> tickers) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.tickers = tickers;
    }


    public LocalDate getStartDate() {
        return startDate;
    }


    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    public LocalDate getEndDate() {
        return endDate;
    }


    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<TickerMetadata> getTickers() {
        return tickers;
    }

    public void setTickers(List<TickerMetadata> tickers) {
        this.tickers = tickers;
    }

}
