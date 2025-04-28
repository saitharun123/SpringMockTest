package com.carsim.aspect;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	

	Logger logger = Logger.getLogger(LogAspect.class.getName());
	
	@Around("execution (* com.carsim.service.*.*(..))")
	public Object aroundAspect(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Instant start = Instant.now();
		logger.info("method execution start");
		
		Object result = joinPoint.proceed();
		
		logger.info("method execution end");
		Instant finish = Instant.now();
		
		long timeElapsed = Duration.between(start, finish).toMillis();
		logger.info("Time took to execute the method : "+timeElapsed);
		
		return result;
	}
}
