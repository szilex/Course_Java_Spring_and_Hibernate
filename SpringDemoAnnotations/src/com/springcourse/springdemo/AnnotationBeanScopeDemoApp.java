package com.springcourse.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach secondCoach = context.getBean("tennisCoach", Coach.class);

        boolean location = (theCoach==secondCoach);

        System.out.println("Same location: " + location);

        System.out.println("theCoach location: " + theCoach);
        System.out.println("secondCoach location: " + secondCoach);

        context.close();
    }
}
