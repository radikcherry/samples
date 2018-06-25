package org.cherry.sample.web;

import org.cherry.sample.model.Book;
import org.cherry.sample.model.BookRepository;
import org.cherry.sample.model.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BookHandler {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired 
	private BookService service;

	
	public Mono<ServerResponse> getAllBooks(ServerRequest request) { 
		Flux<Book> rxBooks = repository.findAll();
		return ServerResponse.ok().body(rxBooks, Book.class);
	}
	
	
	public Mono<ServerResponse> getBook(ServerRequest request) {
		String bookId = request.pathVariable("id");
		Mono<Book> rxBook = repository.findById(bookId);
		return ServerResponse.ok().body(rxBook, Book.class);
	}

	
	public Mono<ServerResponse> createBooks(ServerRequest request) {
		Flux<Book> rxBooks = request.bodyToFlux(Book.class);
		return ServerResponse.ok().body(service.createMany(rxBooks), Book.class);
	}

	
	public Mono<ServerResponse> updateBook(ServerRequest request) {
		String bookId = request.pathVariable("id");
		Mono<Book> rxBook = request.bodyToMono(Book.class);
		return ServerResponse.ok().body(service.updateOne(bookId, rxBook), Book.class);
	}

	
	public Mono<ServerResponse> updateBooks(ServerRequest request) {
		Flux<Book> rxBooks = request.bodyToFlux(Book.class);
		return ServerResponse.ok().body(service.updateMany(rxBooks), Book.class);
	}
	
	
	public Mono<ServerResponse> deleteBook(ServerRequest request) {
		String bookId = request.pathVariable("id");
		return ServerResponse.ok().body(repository.deleteById(bookId), Void.class);
	}

}
