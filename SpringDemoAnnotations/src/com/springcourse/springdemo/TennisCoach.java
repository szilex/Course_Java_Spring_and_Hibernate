package com.springcourse.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    //Field dependency injection using Java Reflection
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("Tennis coach no-arg constructor");
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("Inside TennisCoach initMethod");
    }

    @PreDestroy
    public void preDestroyMethod() {
        System.out.println("Inside TennisCoach preDestroyMethod");
    }

    //Constructor dependency injection
    /*@Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }*/

    //Setter dependency injection
    /*@Autowired
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
        System.out.println("Tennis coach setFortuneService");
    }*/

    //Method dependency injection
    /*@Autowired
    public void method(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
        System.out.println("Tennis coach method");
    }*/

    @Override
    public String getDailyWorkout() {
        return "Practice ball throwing for 20 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
