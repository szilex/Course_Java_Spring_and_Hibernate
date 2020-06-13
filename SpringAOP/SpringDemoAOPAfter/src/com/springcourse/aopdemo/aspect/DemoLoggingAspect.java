package com.springcourse.aopdemo.aspect;

import com.springcourse.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

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
