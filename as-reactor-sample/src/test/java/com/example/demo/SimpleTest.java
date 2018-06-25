package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

    @Test
    public void testSplitFlux() {
        Flux.just(1,2,3,4,5,6,7,8,9)
            .log()
            .filter(a -> a % 2 == 0)
            .log()
            .subscribe(System.out::println);
    }

    @Test
    public void testSubscribeOn() throws InterruptedException {
        Flux.just(1,2,3,4,5,6,7,8,9)
            .log()
            //.subscribeOn(Schedulers.parallel())
            .publishOn(Schedulers.single())
            .log()
            .subscribe(a -> {
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": " + a);
            });
        Thread.sleep(10000);
    }
}
