package com.hoboss.springcoredemo.config;

import com.hoboss.springcoredemo.common.Coach;
import com.hoboss.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
