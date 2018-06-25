package com.epam.wmrobo.integrator.provider.quandl.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuandleDatabaseCollection {
    
    private List<QuandleDatabase> database;

    public List<QuandleDatabase> getDatabase() {
        return database;
    }

    public void setDatabase(List<QuandleDatabase> database) {
        this.database = database;
    }
    
    

}
