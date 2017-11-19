package org.cherry.sample;

import java.security.KeyPair;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;


@Configuration
@EnableAuthorizationServer
public class SampleAuthServerConfiguration {
	
	@Configuration
	public static class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}

	}

	
	@Configuration
	public static class AuthServerConfiguration extends AuthorizationServerConfigurerAdapter {

		private final AuthenticationManager authenticationManager;
		private final SimpleUserDetailsService userDetailsService;
		
		public AuthServerConfiguration(AuthenticationManager authenticationManager, SimpleUserDetailsService userDetailsService) {
			this.authenticationManager = authenticationManager;
			this.userDetailsService = userDetailsService;
		}
		
		
		@Bean
		public JwtAccessTokenConverter tokenEnhancer() {
			JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
			KeyStoreKeyFactory keyStoreFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "secret".toCharArray());
			KeyPair keyPair = keyStoreFactory.getKeyPair("jwt");
			converter.setKeyPair(keyPair);
			return converter;
		}
		
		
		@Bean
		public JwtTokenStore tokenStore() {
			return new JwtTokenStore(tokenEnhancer());
		}
	
		
		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints
				.authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService)
				.tokenStore(tokenStore())
				.accessTokenConverter(tokenEnhancer());
		}
	
		
		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients
				.inMemory()
				.withClient("sample").secret("{noop}secret")
				.authorizedGrantTypes("authorization_code", "refresh_token", "password", "client_credentials")
				.scopes("openid")
				.autoApprove(true);
		}
	
	
		@Override
		public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
			security
				.tokenKeyAccess("permitAll()")
				.checkTokenAccess("isAuthenticated()")
				.allowFormAuthenticationForClients();
		}
		
	}
	
}
