package com.epam.wmrobo.integrator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.wmrobo.integrator.model.TickerRequest;
import com.epam.wmrobo.integrator.provider.quandl.QuandlTickerProvider;
import com.epam.wmrobo.integrator.model.SimpleTickerData;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskService {
    
    @Autowired
    private QuandlTickerProvider quandleHandler;
    
    @Autowired
    private LoadService loadService;
    
    public Flux<SimpleTickerData> executeRetrieveTask(Mono<TickerRequest> task) {
        return quandleHandler.processRequest(task).log();
    }
    
    public boolean executeLoadTask(Mono<TickerRequest> task) {
        return loadService.execute(executeRetrieveTask(task));
    }

}
