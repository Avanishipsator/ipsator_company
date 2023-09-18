package com.ipsator.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;

import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for security settings.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	/**
	 * Bean for AuthenticationManager.
	 *
	 * @param builder AuthenticationConfiguration object.
	 * @return AuthenticationManager object.
	 * @throws Exception if any error occurs.
	 */
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}

	/**
	 * Bean for SecurityFilterChain.
	 *
	 * @param http HttpSecurity object.
	 * @return SecurityFilterChain object.
	 * @throws Exception if any error occurs.
	 */
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/login,/logout").permitAll();
			auth.requestMatchers("/profile", "/AllLogInUser").authenticated();
			auth.anyRequest().authenticated();
		}).oauth2Login(l -> l.defaultSuccessUrl("/profile"))
				.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.decoder(jwtDecoder())));
		return http.build();

	}

	/**
	 * Bean for JwtDecoder.
	 *
	 * @return JwtDecoder object.
	 */
	@Bean
	public JwtDecoder jwtDecoder() {
		return JwtDecoders.fromIssuerLocation("https://accounts.google.com");
	}

}
