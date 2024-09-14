package com.portfolio.portfoliokevincastillo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PropertiesConfiguration {
    @Value("${path.json.data.projects}")
    private String path;

    @Value("${emailsender.correoDestino}")
    private String emailReceiver;

    @Value("${spring.mail.username}")
    private String emailSender;

    @Bean
    @Primary
    public String jsonFilePathProjects(){
        return path;
    }

    @Bean
    @Primary
    public String getEmailReceiver(){
        return emailReceiver;
    }

    @Bean
    @Primary
    public String getEmailSender(){
        return emailSender;
    }
}
