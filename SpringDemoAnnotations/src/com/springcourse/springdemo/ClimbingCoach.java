package com.springcourse.springdemo;

public class ClimbingCoach implements Coach {

    private FortuneService fortuneService;

    public ClimbingCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Climb that tree";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
