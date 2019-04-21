package org.shahul.aspect;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppLoggerAspect {

	Logger logger=Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* org.shahul.service.*.*(..))")
	public void servicesPointcut() {}
	
	@Pointcut("execution(* org.shahul.controller.*.*(..))")
	public void controllerPointcut() {}
	
	@Pointcut("execution(* org.shahul.dao.*.*(..))")
	public void daoPointcut() {}
	
	@Pointcut("servicesPointcut() || controllerPointcut() || daoPointcut()")
	public void appPointcut() {}
	
	@Before("appPointcut()")
	public void beforeExecutionAdvice(JoinPoint joinPoint) {
		logger.info("Before advice on "+joinPoint.getSignature().toShortString());
		
		Object[] args = joinPoint.getArgs();
		
		List<Object> asList = Arrays.asList(args);
		asList.forEach((el)->{
			logger.info(el.toString());
		});
	}
	
	@AfterReturning(pointcut="appPointcut()",returning="result")
	public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
		
		logger.info("After returning advice on "+joinPoint.getSignature().toShortString());
		
		logger.info(result.toString());
		
	}
}
