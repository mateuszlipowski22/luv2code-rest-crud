package com.luv2code.rest_application.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.rest_application.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.luv2code.rest_application.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.rest_application.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        myLogger.info(String.format("======> in @Before: calling method: %s", method));

        Object[] args = joinPoint.getArgs();

        for(Object arg : args){
            myLogger.info(String.format("======> argument: %s", arg));
        }
    }

    @AfterReturning(pointcut = "forAppFlow()",
    returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String method = joinPoint.getSignature().getName();
        myLogger.info(String.format("======> in @AfterReturning: calling method: %s", method));

        myLogger.info(String.format("======> result : %s", result));

    }
}
