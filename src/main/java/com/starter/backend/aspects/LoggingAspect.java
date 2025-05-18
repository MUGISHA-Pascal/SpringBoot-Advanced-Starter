package com.starter.backend.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* com.starter.backend.controllers..*(..)) || execution( * com.starter.backend.services..*(..))")
    public void LoggingPointcut(){}

    @Before("LoggingPointcut()")
    public void logBefore(JoinPoint joinPoint){
        logger.info("Entering method: {} with arguements : {}",joinPoint.getSignature(),joinPoint.getArgs());
    }
    @AfterReturning(pointcut ="LoggingPointcut()",returning = "result")
    public void logAfterReturning(JoinPoint joinPoint,Object result){
        logger.info("Exiting method: {} with result : {}",joinPoint.getSignature(),result);
    }
    @AfterThrowing(pointcut = "LoggingPointcut()" , throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint,Throwable error){
        logger.info("Exiting method: {} with error : {}",joinPoint.getSignature(),error.getMessage());
    }
}
