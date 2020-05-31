package com.springcourse.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClimbConfig {

    @Bean
    public FortuneService neutralFortuneService() {
        return new NeutralFortuneService();
    }

    @Bean
    public Coach climbingCoach() {
        return new ClimbingCoach(neutralFortuneService());
    }
}
