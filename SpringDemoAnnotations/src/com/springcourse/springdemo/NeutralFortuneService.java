package com.springcourse.springdemo;

public class NeutralFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Life just is what it is";
    }
}
