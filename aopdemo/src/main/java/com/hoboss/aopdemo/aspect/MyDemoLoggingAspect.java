package com.hoboss.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // AspectJ’s pointcut expression language
//    @Before("execution(public void add*())")
//    @Before("execution(public void addAccount())")
//    @Before("execution(* com.hoboss.aopdemo.dao.*.addAccount(..))")
    @Before("execution(* com.hoboss.aopdemo.dao.AccountDAO.addAccount(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
}
