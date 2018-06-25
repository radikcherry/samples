package com.epam.wmrobo.integrator.provider.quandl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuandleDatabase {
    
    private String name;
    private String database_code;
    private String description;
    private boolean premium;
    private int datasets_count;
    private String image;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDatabase_code() {
        return database_code;
    }
    
    public void setDatabase_code(String database_code) {
        this.database_code = database_code;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean getPremium() {
        return premium;
    }
    
    public void setPremium(boolean premium) {
        this.premium = premium;
    }
    
    public int getDatasets_count() {
        return datasets_count;
    }

    public void setDatasets_count(int datasets_count) {
        this.datasets_count = datasets_count;
    }

    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    
}
