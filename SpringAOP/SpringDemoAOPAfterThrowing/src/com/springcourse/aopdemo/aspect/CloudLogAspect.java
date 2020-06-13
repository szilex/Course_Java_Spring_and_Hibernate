package com.springcourse.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAspect {

    @Before("com.springcourse.aopdemo.aspect.PointcutExpressions.forDaoPackageNoGetterSetter()")
    public void performAnalysis() {

        System.out.println("Executing @Before cloud logging advice in dao package");
    }
}
