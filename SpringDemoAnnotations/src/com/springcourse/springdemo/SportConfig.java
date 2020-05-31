package com.springcourse.springdemo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:sports.properties")
//@ComponentScan("com.springcourse.springdemo")
public class SportConfig {

    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    @Bean
    public Coach golfCoach() {
        GolfCoach golfCoach = new GolfCoach(sadFortuneService());
        return golfCoach;
    }
}
