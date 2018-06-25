package org.cherry.sample.model;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;

public interface BookRepository extends ReactiveMongoRepository<Book, String>{
	
	@Query("{ 'title' : ?0 }")
	public Flux<Book> findByTitle(String title);
	
}
