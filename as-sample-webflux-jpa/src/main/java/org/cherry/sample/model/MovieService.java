package org.cherry.sample.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	
	public Mono<Movie> createOne(Mono<Movie> rxMovie) {
		return rxMovie.doOnNext(repository::save);
	}

	
	public Flux<Movie> createMany(Flux<Movie> rxMovie) {
		return rxMovie.doOnNext(repository::save);
	}
	

	public Flux<Movie> updateOne(Long id, Mono<Movie> rxMovie) {
		Mono<Movie> result = 
				rxMovie.flatMap(
				item -> repository.findById(id)
					.map(book -> book.apply(item)));
		return repository.saveAll(result.flux());
	}
	

	public Flux<Movie> updateMany(Flux<Movie> rxMovie) {
		Flux<Movie> result = 
				rxMovie.flatMap(
				item -> repository.findById(item.getId())
					.map(book -> book.apply(item)));
		return repository.saveAll(result);
	}

}
