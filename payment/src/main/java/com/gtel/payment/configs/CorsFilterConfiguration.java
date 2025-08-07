package com.gtel.payment.configs;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@AllArgsConstructor
public class CorsFilterConfiguration {

    private final SystemPropertyConfiguration systemPropertyConfiguration;

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(systemPropertyConfiguration.getCors().allowedOriginPattern());
        corsConfiguration.setAllowedHeaders(systemPropertyConfiguration.getCors().allowedHeader());
        corsConfiguration.setAllowedMethods(systemPropertyConfiguration.getCors().allowedMethods());
        corsConfiguration.setAllowCredentials(systemPropertyConfiguration.getCors().allowCredentials());
        corsConfiguration.addExposedHeader(systemPropertyConfiguration.getCors().exposedHeader());
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration(
                systemPropertyConfiguration.getCors().urlBasedPatternCorsConfigurationSource(),
                corsConfiguration
        );
        return new CorsFilter(corsConfigurationSource);
    }
}
