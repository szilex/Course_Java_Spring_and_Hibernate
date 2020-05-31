package com.springcourse.springdemo;

public class SwimmingCoach implements Coach {

    private FortuneService fortuneService;

    public SwimmingCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 10 pools";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
