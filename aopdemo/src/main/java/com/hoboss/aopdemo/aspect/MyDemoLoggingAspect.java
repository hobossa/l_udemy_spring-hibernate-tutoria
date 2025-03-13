package com.hoboss.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)   // create order for aspect
public class MyDemoLoggingAspect {

    // AspectJ’s pointcut expression language
//    @Before("execution(public void add*())")
    @Before("execution(public * add*())")
//    @Before("execution(public void addAccount())")
//    @Before("execution(* com.hoboss.aopdemo.dao.*.addAccount(..))")
//    @Before("execution(* com.hoboss.aopdemo.dao.AccountDAO.addAccount(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

    @Before("execution(public * add*(..))")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");

        // Display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // Display method argumentsaccountDAO.setName("test")
        Object[] args = joinPoint.getArgs();
        System.out.println("Arguments: ");
        for (Object arg : args) {
            System.out.println(arg);
        }
    }

    // Pointcut Declaration
    @Pointcut("execution(* com.hoboss.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice2() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount() <<<=====");
    }

    // Pointcut for all getter methods
    @Pointcut("execution(public * get*(..))")
    private void allget() {}

    // Pointcut for all getter methods
    @Pointcut("execution(public * set*(..))")
    private void allset() {}

    @Pointcut("allget() || allset()")
    private void allgetAndallset() {}

    @Before("allgetAndallset)")
    public void beforeAllgetAndAllSet() {
        System.out.println("\n=====>>> Executing @Before advice on all get and all set() <<<333333");
    }
}
