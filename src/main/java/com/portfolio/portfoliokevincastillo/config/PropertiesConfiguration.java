package com.portfolio.portfoliokevincastillo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PropertiesConfiguration {
    @Value("${path.json.data.projects}")
    private String path;

    @Bean
    @Primary
    public String jsonFilePathProjects(){
        return path;
    }
}
