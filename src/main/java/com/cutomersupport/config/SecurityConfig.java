package com.cutomersupport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(
        		"http://localhost:7777",
        		"http://localhost:3000",
        		"https://custsupmicroservice.onrender.com",
        		"http://localhost:8080",
        		"https://wave-point-support.vercel.app/"// 
        ));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authz -> authz
                // ✅ Public endpoints - Assistance (includes agent chat)
                .requestMatchers("/api/assistance/**").permitAll()
                
                // Auth endpoints - Public
                .requestMatchers("/api/auth/login").permitAll()
                .requestMatchers("/api/auth/forgot-password").permitAll()
                .requestMatchers("/api/auth/reset-password").permitAll()
                .requestMatchers("/api/auth/logout").permitAll()
                
                // Public support endpoints
                .requestMatchers("/api/myrequests/**").permitAll()
                .requestMatchers("/api/ideas/**").permitAll()
                .requestMatchers("/api/feedback/**").permitAll()
                .requestMatchers("/api/updates/**").permitAll()
                .requestMatchers("/api/support/**").permitAll()
                
                // ✅ FIXED: Let requests reach the AdminController. 
                // The AdminController manually handles the "Bearer" token validation.
                .requestMatchers("/api/admin/**").permitAll()
                
                // Everything else requires authentication
                .anyRequest().authenticated()
            );
        return http.build();
    }
}