package com.firstspring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAopAspect {

	private Logger logger = LoggerFactory.getLogger(AfterAopAspect.class);

	@AfterReturning(value = "execution(* com.firstspring.aop.springaop..*.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("{} returned with value {}", joinPoint, result);
	}

	@AfterThrowing(value = "execution(* com.firstspring.aop.springaop..*.*(..))", throwing = "result")
	public void afterThrowing(JoinPoint joinPoint, Exception result) {
		logger.info("{} throw exception {}", joinPoint, result);
	}

	@After(value = "execution(* com.firstspring.aop.springaop..*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("{} completed!", joinPoint);
	}

}
