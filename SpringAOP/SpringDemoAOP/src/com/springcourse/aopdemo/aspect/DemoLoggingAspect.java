package com.springcourse.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    //@Before("execution(public void add*())")
    @Before("execution(* com.springcourse.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("Executing @Before advice on addAccount()");
    }
}
