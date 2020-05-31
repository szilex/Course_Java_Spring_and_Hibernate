package com.springcourse.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GolfJavaConfigDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);
        //SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
        GolfCoach theCoach = context.getBean("golfCoach", GolfCoach.class);
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getEmail());
        System.out.println(theCoach.getTeam());
        context.close();

    }

}
