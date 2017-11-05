package org.cherry.sample.web;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class MovieRouter {

    @Autowired
    private HelloHandler helloHandler;
	
	@Autowired
    private MovieHandler movieHandler;
    
	@Bean
    public RouterFunction<ServerResponse> bookRouterFunction() {
        RouterFunction<ServerResponse> router = 
           	route(GET("/hello"), helloHandler::getHello)
           	.andRoute(GET("/thanks"), helloHandler::getThankyou)
           	.andRoute(GET("/bye"), helloHandler::getGoodbye)
        	.andRoute(GET("/movie"), movieHandler::getAllMovies)
        	.andRoute(GET("/movie/{id}"), movieHandler::getById);

        return router;
    }

/*
	@Bean
	public UserDetailsRepository userDetailsRepository() {
		UserDetails john = User.withUsername("john").roles("USER").password("pass").build();
		UserDetails bill = User.withUsername("admin").roles("ADMIN").password("pass").build();
		return new MapUserDetailsRepository(john, bill);
	}
	
	@Bean
	public SecurityWebFilterChain securityChain(HttpSecurity httpSecurity) {
		return httpSecurity.authorizeExchange()
				.pathMatchers("/hello","/bye","/thanks").permitAll()
//				.pathMatchers("/movie").access((mono, context) -> mono
//					.map(auth -> auth.getName().equals("admin"))
//					.map(AuthorizationDecision::new))
				.anyExchange().authenticated()
				.and().build();
	}
*/
}
