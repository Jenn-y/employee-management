package com.getarrays.employeemanager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
  
  @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins("http://localhost:4200", "https://employee-mngt.netlify.app")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .maxAge(3600L)
                    .allowedHeaders("Origin", "Access-Control-Allow-Origin", "Content-Type",
                    "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                    "Access-Control-Request-Method", "Access-Control-Request-Headers")
                    .exposedHeaders("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                    .allowCredentials(true);
                    
            }
        };
    }
}
