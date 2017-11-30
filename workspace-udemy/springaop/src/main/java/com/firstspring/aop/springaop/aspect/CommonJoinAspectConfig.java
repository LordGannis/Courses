package com.firstspring.aop.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CommonJoinAspectConfig {

	@Pointcut(value = "execution(* com.firstspring.aop.springaop.data.*.*(..))")
	public void dataLayerExecution() {
	}

	@Pointcut(value = "execution(* com.firstspring.aop.springaop.business.*.*(..))")
	public void businessLayerExecution() {
	}

	@Pointcut(value = "com.firstspring.aop.springaop.aspect.CommonJoinAspectConfig.dataLayerExecution() && com.firstspring.aop.springaop.aspect.CommonJoinAspectConfig.businessLayerExecution()")
	public void dataAndBusinessLayers() {
	}

	@Pointcut(value = "execution(* com.firstspring.aop.springaop..*.*(..))")
	public void allLayers() {
	}

//	@Pointcut("bean(*DAO*)")
//	public void beanLayers() {
//	}

	@Pointcut(value = "@annotation(com.firstspring.aop.springaop.aspect.annotation.TrackTime)")
	public void trackTimeAnnotation() {
	}

}
