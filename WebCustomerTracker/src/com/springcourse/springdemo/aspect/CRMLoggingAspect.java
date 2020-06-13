package com.springcourse.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private static Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());

    @Pointcut(value = "execution(* com.springcourse.springdemo.controller..*.*(..))")
    private void forControllerPackage() {}

    @Pointcut(value = "execution(* com.springcourse.springdemo.dao..*.*(..))")
    private void forDaoPackage() {}

    @Pointcut(value = "execution(* com.springcourse.springdemo.service..*.*(..))")
    private void forServicePackage() {}

    @Pointcut(value = "forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow() {}

    @Before(value = "forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toString();
        logger.info("Inside @Before advice method: " + methodName);

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            logger.info("Argument: " + arg);
        }
    }

    @AfterReturning(value = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().toString();
        logger.info("Inside @AfterReturning advice method: " + methodName);
        logger.info("Result inside @AfterReturning: " + result);
    }

}
