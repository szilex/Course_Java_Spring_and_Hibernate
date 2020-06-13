package com.springcourse.aopdemo.aspect;

import com.springcourse.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Before("com.springcourse.aopdemo.aspect.PointcutExpressions.forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("Executing @Before advice in dao package");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method signature: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
            else {
                System.out.println(arg);
            }
        }
    }

    @Around("execution(* com.springcourse.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String methodName = proceedingJoinPoint.getSignature().toShortString();
        //System.out.println("@Around - method name: " + methodName);
        logger.info("@Around - method name: " + methodName);

        long startTime = System.currentTimeMillis();

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.warning("Exception caught by @Around advice");
            //result = "Traffic jam was handled by @Around advice";
            throw e;
        }

        long stopTime = System.currentTimeMillis();

        long duration = stopTime - startTime;
        //System.out.println("Method duration: " + duration / 1000.0 + " seconds");
        logger.info("Method duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.springcourse.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFindAccountAdvice(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("@After - method name: " + methodName);
    }

    @AfterThrowing(
            pointcut = "execution(* com.springcourse.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("@AfterThrowing - method name: " + methodName);

        System.out.println("@AfterThrowing - exception: " + exception.getMessage());
    }

    @AfterReturning(
            pointcut = "execution(* com.springcourse.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {

        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("@AfterReturning - method name: " + methodName);

        System.out.println("@AfterReturning - result: " + result);

        convertAccountNamesToUpperCase(result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for(Account account : result) {
            String upperCaseName = account.getName().toUpperCase();
            account.setName(upperCaseName);
        }

    }


}
