package org.cherry.sample.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	
	public Mono<Book> createOne(Mono<Book> rxBook) {
		return rxBook.doOnNext(repository::insert);
	}

	
	public Flux<Book> createMany(Flux<Book> rxBooks) {
		return repository.insert(rxBooks);
	}
	

	public Flux<Book> updateOne(String bookId, Mono<Book> rxBook) {
		Mono<Book> result = 
			rxBook.flatMap(
				item -> repository.findById(bookId)
					.map(book -> book.apply(item)));
		return repository.saveAll(result.flux());
	}
	

	public Flux<Book> updateMany(Flux<Book> rxBooks) {
		Flux<Book> result = 
			rxBooks.flatMap(
				item -> repository.findById(item.getId())
					.map(book -> book.apply(item)));
		return repository.saveAll(result);
	}

}
