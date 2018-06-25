package org.cherry.sample.web;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class BookRouter {

    @Autowired
    private BookHandler handler;
    
	@Bean
    public RouterFunction<ServerResponse> bookRouterFunction() {
        RouterFunction<ServerResponse> router = 
        	route(GET("/book"), handler::getAllBooks)
        	.andRoute(GET("/book/{id}"), handler::getBook)
        	.andRoute(PUT("/book"), handler::createBooks)
        	.andRoute(POST("/book/{id}"), handler::updateBook)
        	.andRoute(POST("/book"), handler::updateBooks)
        	.andRoute(DELETE("/book/{id}"), handler::deleteBook);

        return router;
    }

/*	
	@Bean
	public UserDetailsRepository userDetailsRepository() {
		UserDetails john = User.withUsername("john").roles("USER").password("pass").build();
		UserDetails bill = User.withUsername("bill").roles("ADMIN").password("asap").build();
		return new MapUserDetailsRepository(john, bill);
	}
	
	@Bean
	public SecurityWebFilterChain securityChain(HttpSecurity httpSecurity) {
		return httpSecurity.authorizeExchange()
				//.pathMatchers("/book")
				.pathMatchers(HttpMethod.POST)
					.access((mono, context) -> mono
							.map(auth -> auth.getName().equals("bill"))
							.map(AuthorizationDecision::new))
				.anyExchange().authenticated()
				.and().build();
	}
*/
}
