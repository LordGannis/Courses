package com.firstspring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {

	private Logger logger = LoggerFactory.getLogger(UserAccessAspect.class);

	@Before("com.firstspring.aop.springaop.aspect.CommonJoinAspectConfig.dataLayerExecution()")
	public void beforeAll(JoinPoint joinPoint) {
		logger.info("Check for user access...");
		logger.info("User allowed for call - {} ", joinPoint);
	}

}
