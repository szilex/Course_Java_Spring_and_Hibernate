package com.springcourse.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${swimming.poolLength}")
    private String poolLength;

    @Value("${swimming.poolWidth}")
    private String poolWidth;

    public SwimCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 20 pool back and forth";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getDims() {
        return String.format("%d x %d", poolLength, poolWidth);
    }
}
