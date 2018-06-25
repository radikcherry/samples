package com.epam.wmrobo.integrator.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.epam.wmrobo.integrator.model.TickerRequest;
import com.epam.wmrobo.integrator.model.SimpleTickerData;
import com.epam.wmrobo.integrator.service.TaskService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TaskHandler {
    
    @Autowired 
    private TaskService service;

    
    public Mono<ServerResponse> getRequestedData(ServerRequest request) { 
        Mono<TickerRequest> rxTask = request.bodyToMono(TickerRequest.class);
        Flux<SimpleTickerData> rxData = service.executeRetrieveTask(rxTask);
        return ServerResponse.ok().body(rxData, SimpleTickerData.class);
    }

    
    public Mono<ServerResponse> loadRequestedData(ServerRequest request) { 
        Mono<TickerRequest> rxTask = request.bodyToMono(TickerRequest.class);
        service.executeLoadTask(rxTask);
        return ServerResponse.ok().body(Mono.just("Success"), String.class);
    }

}
