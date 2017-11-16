package org.cherry.sample.model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
	public List<Movie> findAll() {
		return generateSample().collect(Collectors.toList());
	}
	
	
	public Optional<Movie> findById(String id) {
		return generateSample().filter(a -> a.getId().equals(id)).findFirst();
	}
	
	
	private Stream<Movie> generateSample() {
		return Stream.of(
			new Movie("id0068646", "The Godfather", "Francis Ford Coppola", 1972),
			new Movie("id0110912", "Pulp Fiction", "Quentin Tarantino", 1994),
			new Movie("id0060196", "The Good, the Bad and the Ugly", "Sergio Leone", 1966),
			new Movie("id0109830", "Forrest Gump", "Robert Zemeckis", 1994)
		);
	}

}
