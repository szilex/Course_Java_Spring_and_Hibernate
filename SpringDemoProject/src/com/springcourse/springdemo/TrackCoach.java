package com.springcourse.springdemo;

public class TrackCoach implements Coach {


    private FortuneService fortuneService;

    public TrackCoach() {
    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a half-marathon";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void startupMethod() {
        System.out.println("TrackCoach: inside startupMethod");
    }

    public void destroyMethod() {
        System.out.println("TrackCoach: inside destroyMethod");
    }

}
