package com.epam.wmrobo.integrator.provider.quandl;

import com.epam.wmrobo.integrator.provider.AbstractTickerDataParser;

public class QuandlDataSetParser extends AbstractTickerDataParser {

    protected QuandlDataSetParser(String headLine) {
        super(headLine, new String[]{null,"Date","Previous Day Price","High","Low","Last","Volume"});
    }

}
