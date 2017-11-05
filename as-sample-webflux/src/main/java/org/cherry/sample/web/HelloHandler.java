package org.cherry.sample.web;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class HelloHandler {
	
	public Mono<ServerResponse> getHello(ServerRequest request) { 
		return ServerResponse.ok().body(fromObject("Hello World"));
	}
	
	public Mono<ServerResponse> getGoodbye(ServerRequest request) { 
		return ServerResponse.ok().body(fromObject("Good Bye"));
	}
	
	public Mono<ServerResponse> getThankyou(ServerRequest request) { 
		return ServerResponse.ok().body(fromObject("Thank You"));
	}

}
