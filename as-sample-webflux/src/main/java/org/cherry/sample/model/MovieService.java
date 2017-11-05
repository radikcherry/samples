package org.cherry.sample.model;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieService {
	
	public Mono<Movie> findById(String id) {
		return findAll().filter(a -> a.getId().equals(id)).single();
	}

	
	public Flux<Movie> findAll() {
		return Flux.just(
			new Movie("tt0068646", "The Godfather", "Francis Ford Coppola", 1972),
			new Movie("tt0110912", "Pulp Fiction", "Quentin Tarantino", 1994),
			new Movie("tt0060196", "The Good, the Bad and the Ugly", "Sergio Leone", 1966),
			new Movie("tt0109830", "Forrest Gump", "Robert Zemeckis", 1994)
		);
	}

}
