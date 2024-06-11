package com.example.customannotation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * Aspect for logging execution time of methods annotated with @LogExecutionTime.
 */
@Aspect
@Component
@Slf4j
public class LogExecutionTimeAspect {

    /**
     * Around advice that logs execution time of methods annotated with @LogExecutionTime.
     *
     * @param joinPoint the join point representing the method execution
     * @return the result of the method execution
     * @throws Throwable if the method execution fails
     */
    @Around("@annotation(com.example.customannotation.annotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // Proceed with the method execution
        Object proceed = joinPoint.proceed();

        // Calculate the execution time
        long executionTime = System.currentTimeMillis() - start;

        // Log the execution time
        log.info("{} executed in {} ms", joinPoint.getSignature(), executionTime);

        return proceed;
    }
}

