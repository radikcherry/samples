package com.epam.wmrobo.integrator.provider.quandl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuandleDatasetEnvelope {
    
    private QuandleDataset dataset;

    public QuandleDataset getDataset() {
        return dataset;
    }

    public void setDataset(QuandleDataset dataset) {
        this.dataset = dataset;
    }

}
