package com.ipsator.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class Config {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/login,/logout").permitAll();
			auth.requestMatchers("/profile").permitAll();
			auth.anyRequest().authenticated();
		}).oauth2Login(l -> l.defaultSuccessUrl("/profile")).build();

		// ... existing code here

	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:8080"); // Add the Swagger UI URL
			}
		};
	}

}
//.formLogin(withDefaults())
/*
 * http.cors().and().csrf().disable().authorizeHttpRequests(authorize ->
 * authorize .requestMatchers("/, /login, /signup, /logout").permitAll()
 * .requestMatchers("/api").hasRole("ADMIN")
 * .requestMatchers("/user").hasRole("USER") .anyRequest().authenticated())
 * .logout().logoutUrl("/logout").logoutSuccessUrl("/").and()
 * .formLogin().loginPage("/login").loginProcessingUrl("/login").
 * defaultSuccessUrl("/user").failureUrl("/login?error"); return http.build();
 */