package com.springcourse.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.support.JstlUtils;

public class BeanScopeDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach secondCoach = context.getBean("myCoach", Coach.class);

        boolean compare = (theCoach == secondCoach);
        System.out.println("Same object: " + compare);

        System.out.println("Memory location for theCoach: " + theCoach);
        System.out.println("Memory location for secondCoach: " + secondCoach);

        context.close();
    }
}
