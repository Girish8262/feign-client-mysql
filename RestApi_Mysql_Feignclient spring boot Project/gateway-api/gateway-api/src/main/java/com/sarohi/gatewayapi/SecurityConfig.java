package com.sarohi.gatewayapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.header.XFrameOptionsServerHttpHeadersWriter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http, ReactiveClientRegistrationRepository reactiveClientRegistrationRepository) {
        http
                .authorizeExchange()
                .pathMatchers("/actuator/**")
                .permitAll()
                .and()
                .authorizeExchange()
                .anyExchange()
                .permitAll();
        //.and()
        //.oauth2Login(); // to redirect to oauth2 login page.
        //.authenticated(); // to redirect to oauth2 login page.
        http.headers().frameOptions().mode(XFrameOptionsServerHttpHeadersWriter.Mode.SAMEORIGIN);
        http.csrf().disable();
        return http.build();
    }
//    @Bean
//    public CorsWebFilter corsFilter() {
//        return new CorsWebFilter(corsConfigurationSource());
//    }
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
//        config.addAllowedMethod( HttpMethod.GET);
//        config.addAllowedMethod( HttpMethod.PUT);
//        config.addAllowedMethod( HttpMethod.POST);
//        config.addAllowedMethod(HttpMethod.DELETE);
//        source.registerCorsConfiguration("/**", config);
//        return source;
//    }
}
