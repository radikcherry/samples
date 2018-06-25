package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Book;
import com.example.demo.model.BookManager;
import com.example.demo.model.SimpleManager;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReactorSampleApplicationTests {

	@Test
	public void testSimplePublishSubscribe() {
		Flux.just("One", "Two", "Three", "Four", "Five", "Six", "Seven","Eight","Nine","Ten")
			.log()
			//.filter(a -> a.startsWith("S"))
			//.flatMap(a -> Flux.fromIterable(Lists.charactersOf(a)))
			//.subscribeOn(Schedulers.parallel())
			.publishOn(Schedulers.parallel())
			//.log()
			.subscribe(System.out::println);
	}

	
	@Test
	public void testExecuteSyncOperation() {
		Flux.just("One", "Two", "Three", "Four", "Five", "Six", "Seven","Eight","Nine","Ten")
			.log()
			.subscribe(a -> {
				System.out.println("a = " + a);
			});
	}


	@Test
	public void testExecuteSyncOperationMap() {
		SimpleManager manager = new SimpleManager();
		
		Flux.just("One", "Two", "Three", "Four", "Five", "Six", "Seven","Eight","Nine","Ten")
			.log()
			.map(a -> {
				return manager.addQuote(a); 
			})
			.subscribe(System.out::println);
	}


	@Test
	public void testMonoExecuteSyncOperationRet() {
		BookManager manager = new BookManager();
		
		Mono<Book> rxBook = Mono.just(new Book("Lord of The Rings","J.R.Tolkien"));
		rxBook
			.log()
			.map(a -> {
				return manager.setYear(a, 1971); 
			})
			.subscribe(System.out::println);
	}

}