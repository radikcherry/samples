package org.cherry.sample.web;

import java.util.List;
import java.util.Optional;

import org.cherry.sample.model.Movie;
import org.cherry.sample.model.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
	
	private MovieService service;

	
	public MovieController(MovieService service) {
		this.service = service;
	}

	
	@GetMapping("/movie/{id}")
	public Optional<Movie> findById(@PathVariable String id) {
		return service.findById(id);
	}

	
	@GetMapping("/movie")
	public List<Movie> findAll() {
		return service.findAll();
	}
	
}
