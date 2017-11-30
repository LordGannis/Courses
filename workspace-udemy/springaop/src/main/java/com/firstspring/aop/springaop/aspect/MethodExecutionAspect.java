package com.firstspring.aop.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionAspect {

	private Logger logger = LoggerFactory.getLogger(MethodExecutionAspect.class);

	@Around(value = "com.firstspring.aop.springaop.aspect.CommonJoinAspectConfig.trackTimeAnnotation()")
	public void around(ProceedingJoinPoint joinPoint) {
		long startTime = System.currentTimeMillis();
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		logger.info("Time taken by {} is {}", joinPoint, (endTime - startTime));
	}

}
