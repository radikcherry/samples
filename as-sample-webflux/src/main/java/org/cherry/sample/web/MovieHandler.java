package org.cherry.sample.web;

import org.cherry.sample.model.Movie;
import org.cherry.sample.model.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MovieHandler {
	
	@Autowired 
	private MovieService service;

	
	public Mono<ServerResponse> getAllMovies(ServerRequest request) { 
		Flux<Movie> rxMovie = service.findAll();
		return ServerResponse.ok().body(rxMovie, Movie.class);
	}
	
	
	public Mono<ServerResponse> getById(ServerRequest request) {
		String movieId = request.pathVariable("id");
		Mono<Movie> rxMovie = service.findById(movieId);
		return ServerResponse.ok().body(rxMovie, Movie.class);
	}

}
