package com.springcourse.springdemo;

import java.util.Arrays;
import java.util.Random;

public class ExtendedFortuneService implements FortuneService {

    private String[] fortunes= new String[]{"bad luck", "good luck", "no luck"};
    private Random random = new Random();

    @Override
    public String getFortune() {
        return fortunes[random.nextInt(3)];
    }
}
