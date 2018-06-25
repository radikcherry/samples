package com.epam.wmrobo.integrator.provider.quandl;

import com.epam.wmrobo.integrator.provider.AbstractTickerDataParser;

public class QuandlDataTableParser extends AbstractTickerDataParser {

    protected QuandlDataTableParser(String headLine) {
        super(headLine, new String[]{"ticker","date","open","high","low","close","volume"});
    }

}
