package com.epam.wmrobo.integrator.model;

public class TickerMetadata {
    
    private String dataset;
    private String symbol;
    private DataSetType type;
    

    public TickerMetadata() {
    }
    
        
    public TickerMetadata(String dataset, String symbol, DataSetType type) {
        this.dataset = dataset;
        this.symbol = symbol;
        this.type = type;
    }


    public String getDataset() {
        return dataset;
    }


    public void setDataset(String dataset) {
        this.dataset = dataset;
    }


    public String getSymbol() {
        return symbol;
    }


    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    public DataSetType getType() {
        return type;
    }


    public void setType(DataSetType type) {
        this.type = type;
    }
    
}
