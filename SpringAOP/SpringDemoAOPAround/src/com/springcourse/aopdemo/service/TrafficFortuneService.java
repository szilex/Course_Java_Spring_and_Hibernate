package com.springcourse.aopdemo.service;

import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune(boolean shouldThrowException) throws RuntimeException {

        if (shouldThrowException) {
            throw new RuntimeException("Traffic jam :(");
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "The traffic is pretty heavy today";
    }
}
