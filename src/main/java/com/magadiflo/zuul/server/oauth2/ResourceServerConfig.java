package com.magadiflo.zuul.server.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@EnableResourceServer // Habilitamos la configuración del servidor de recurso
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	// Para el token
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(this.tokenStore());
	}

	// Para las rutas
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/api/security/oauth/**").permitAll()
			.antMatchers(HttpMethod.GET, "/api/products/api/v1/products", "/api/carts/carts", "/api/users/users").permitAll()
			.antMatchers(HttpMethod.GET, 
					"/api/products/api/v1/products/{id}", 
					"/api/carts/carts/product/{id}/quantity/{quantity}",
					"/api/users/users/{id}").hasAnyRole("USER", "ADMIN")
			.antMatchers("/api/products/**", "/api/carts/**", "/api/users/**").hasRole("ADMIN")
			.anyRequest().authenticated();
	}
	
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(this.accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() { // Información, datos por defecto del JWT
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("clave12345");				
		return tokenConverter;
	}

}
