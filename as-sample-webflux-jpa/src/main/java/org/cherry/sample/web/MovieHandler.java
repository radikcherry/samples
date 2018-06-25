package org.cherry.sample.web;

import org.cherry.sample.model.Movie;
import org.cherry.sample.model.MovieRepository;
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
	private MovieRepository repository;
	
	@Autowired 
	private MovieService service;

	
	public Mono<ServerResponse> getAllBooks(ServerRequest request) { 
		Flux<Movie> rxBooks = repository.findAll();
		return ServerResponse.ok().body(rxBooks, Movie.class);
	}
	
	
	public Mono<ServerResponse> getBook(ServerRequest request) {
		String bookId = request.pathVariable("id");
		Mono<Movie> rxBook = repository.findById(bookId);
		return ServerResponse.ok().body(rxBook, Movie.class);
	}

	
	public Mono<ServerResponse> createBooks(ServerRequest request) {
		Flux<Movie> rxBooks = request.bodyToFlux(Movie.class);
		return ServerResponse.ok().body(service.createMany(rxBooks), Movie.class);
	}

	
	public Mono<ServerResponse> updateBook(ServerRequest request) {
		String bookId = request.pathVariable("id");
		Mono<Movie> rxBook = request.bodyToMono(Movie.class);
		return ServerResponse.ok().body(service.updateOne(bookId, rxBook), Movie.class);
	}

	
	public Mono<ServerResponse> updateBooks(ServerRequest request) {
		Flux<Movie> rxBooks = request.bodyToFlux(Movie.class);
		return ServerResponse.ok().body(service.updateMany(rxBooks), Movie.class);
	}
	
	
	public Mono<ServerResponse> deleteBook(ServerRequest request) {
		String bookId = request.pathVariable("id");
		return ServerResponse.ok().body(repository.deleteById(bookId), Void.class);
	}

}
