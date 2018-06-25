package org.cherry.sample;

import org.cherry.sample.model.Movie;
import org.cherry.sample.model.MovieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleApplicationTests {

	@Autowired
	private MovieRepository repository;

	@Test
	public void testGetBooks() {
		repository.findAll().log().then().block();
	}

	@Test
	public void testInsertBook() {
		Flux<Movie> books = Flux.just(new Movie(null, "999", "Test title", "Somebody", "description here"));
		//repository.saveAll(books).log().then().block();
	}

	@Test
	public void testUpdateBook() {
		Flux<Movie> books = 
			repository.findByTitle("Test title")
			.map(item -> {
				item.setDescription("updated");
				return item;
			});
			repository.saveAll(books).log().then().block();
	}

}
