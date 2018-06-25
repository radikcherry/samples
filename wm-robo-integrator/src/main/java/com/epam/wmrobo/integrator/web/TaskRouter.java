package com.epam.wmrobo.integrator.web;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class TaskRouter {

    @Autowired
    private TaskHandler handler;
    
    @Bean
    public RouterFunction<ServerResponse> bookRouterFunction() {
        RouterFunction<ServerResponse> router = 
            route(POST("/retrieve"), handler::getRequestedData)
            .andRoute(POST("/load"), handler::loadRequestedData);

        return router;
    }

}
