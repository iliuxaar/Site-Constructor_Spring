package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.web.SignInAdapter;

@Configuration
public class SocialConfig {

    @Bean
    public SignInAdapter authSignInAdapter() {
        return (userId, connection, request) -> {
            System.out.println("kek");
            return null;
        };
    }
}
