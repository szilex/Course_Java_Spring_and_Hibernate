package com.springcourse.aopdemo;

import com.springcourse.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class MainDemoApp {

    private static Logger logger = Logger.getLogger(MainDemoApp.class.getName());

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("Call getFortune()");
        boolean shouldThrowException = true;
        String result = null;
        try {
            result = trafficFortuneService.getFortune(shouldThrowException);
        } catch (RuntimeException e) {
            logger.warning("Caught RuntimeException inside mainApp");
        }
        logger.info("Result: " + result);

        context.close();

    }
}
