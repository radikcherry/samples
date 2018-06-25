package com.epam.wmrobo.integrator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class WmRoboIntegratorApplication implements CommandLineRunner {

	public static void main(String[] args) {
        SpringApplication.run(WmRoboIntegratorApplication.class, args);
	    //SpringApplication app = new SpringApplication(WmRoboIntegratorApplication.class);
	    //app.run(args);
	}

    @Override
    public void run(String... args) throws Exception {
/*        
        TickerRequest request = 
            new TickerRequest(
                LocalDate.parse("2017-12-06"), 
                LocalDate.parse("2017-12-08"), 
                Arrays.asList("SSE/VROS","SSE/N2X1","SSE/DWB"));
        
        QuandlTickerProvider quandleHandler = new QuandlTickerProvider();
        quandleHandler.processRequest(request).subscribe(System.out::println);
*/
    }
}
