package com.springcourse.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class AnalyticsAspect {

    @Before("com.springcourse.aopdemo.aspect.PointcutExpressions.forDaoPackageNoGetterSetter()")
    public void performAnalysis() {

        System.out.println("Executing @Before analysis advice in dao package");
    }
}
