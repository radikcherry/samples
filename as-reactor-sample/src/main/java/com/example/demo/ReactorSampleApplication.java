package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
public class ReactorSampleApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ReactorSampleApplication.class, args);
		
		Flux.just("One", "Two", "Three", "Four", "Five", "Six", "Seven","Eight","Nine","Ten")
			.log()
			//.filter(a -> a.startsWith("S"))
			//.flatMap(a -> Flux.fromIterable(Lists.charactersOf(a)))
			//.subscribeOn(Schedulers.parallel())
			.publishOn(Schedulers.single())
			//.log()
			.subscribe(System.out::println);
	}
}
