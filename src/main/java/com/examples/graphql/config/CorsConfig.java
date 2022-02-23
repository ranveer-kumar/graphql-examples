package com.examples.graphql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Deprecated
@Configuration
public class CorsConfig {

//    @Bean
//    public WebMvcConfigurer corsConfigurerNew() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(final CorsRegistry registry) {
//                registry.addMapping("/graphql/**")
//                        .allowedOrigins(CorsConfiguration.ALL)
//                        .allowedHeaders(CorsConfiguration.ALL)
//                        .allowedMethods(CorsConfiguration.ALL);
//            }
//        };
//    }


//    @Bean
//    public CorsFilter corsFilter() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        final CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("http://localhost:3000");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        source.registerCorsConfiguration("/graphql/**", config);
//        return new CorsFilter(source);
//    }
}
