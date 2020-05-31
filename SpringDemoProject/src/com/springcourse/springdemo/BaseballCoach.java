package com.springcourse.springdemo;

import java.util.stream.Collectors;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Do 30 push-ups";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
