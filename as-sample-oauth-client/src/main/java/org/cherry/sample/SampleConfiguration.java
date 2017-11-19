package org.cherry.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class SampleConfiguration {
	
	@Configuration
	@EnableOAuth2Sso
	@Order(2)
	public static class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
		
	    //@Autowired
	    //private TokenStore tokenStore;
	
		@Override
		public void configure(HttpSecurity http) throws Exception {
			http
				.csrf().disable()
				.antMatcher("/**").authorizeRequests()
				.antMatchers("/", "/error", "/login**", "/webjars/**").permitAll()
				.anyRequest().authenticated();
		}
		
		//@Override
		//public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		//	resources.resourceId("/auth/name").tokenStore(tokenStore);
		//}
	
	}
	
	
	@Configuration
	public static class JwtConfiguration {

		@Autowired
		JwtAccessTokenConverter jwtAccessTokenConverter;
		
		@Bean
		@Qualifier("tokenStore")
		public TokenStore tokenStore() {
			return new JwtTokenStore(jwtAccessTokenConverter);
		}

		@Bean
		protected JwtAccessTokenConverter jwtTokenEnhancer() {
			JwtAccessTokenConverter converter =  new JwtAccessTokenConverter();
//			Resource resource = new ClassPathResource("public.cert");
//			String publicKey = null;
//			try {
//				publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
//			} catch (IOException e) {
//				throw new RuntimeException(e);
//			}
//			converter.setVerifierKey(publicKey);
			return converter;
		}

	}
	
}
