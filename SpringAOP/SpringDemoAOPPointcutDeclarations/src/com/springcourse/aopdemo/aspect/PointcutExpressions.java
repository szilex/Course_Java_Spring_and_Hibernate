package com.springcourse.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutExpressions {

    @Pointcut("execution(* com.springcourse.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.springcourse.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.springcourse.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
