package com.springcourse.springdemo;

public class SadFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "You're gonna fail";
    }
}
