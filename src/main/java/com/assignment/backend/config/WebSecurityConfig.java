package com.assignment.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.net.URI;
import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
	@Value("${app.allow.origin}")
	private URI allowOrigin;
	private static final String[] AUTH_WHITELIST = {
	        // -- Swagger UI v3
	        "/v3/api-docs/**",
	        "v3/api-docs/**",
	        "/swagger-ui/**",
	        "swagger-ui/**",
	        // CSA Controllers
	        "/csa/api/token",
	        // Actuators
	        "/actuator/**",
	        "/health/**"
	};

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http
                .csrf(AbstractHttpConfigurer::disable)
				.cors().configurationSource(
						request -> {
							CorsConfiguration config = new CorsConfiguration();
							config.setAllowedHeaders(Collections.singletonList("*"));
							config.addAllowedOriginPattern(allowOrigin.toString());
							config.setAllowedMethods(Collections.singletonList("*"));
							config.setAllowCredentials(true);
							return config;
						}).and()

                .authorizeHttpRequests(auth -> auth
                                .requestMatchers(AUTH_WHITELIST).permitAll()
                                .anyRequest().permitAll()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(withDefaults())
				.cors().and()
                .build();
	}
}