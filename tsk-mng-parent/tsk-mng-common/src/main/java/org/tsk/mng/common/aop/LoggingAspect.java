package org.tsk.mng.common.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	private static final Logger logger = Logger.getLogger(LoggingAspect.class);
	
	@Before("execution(* *(..))")
	public void logBefore(JoinPoint joinPoint){
		
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		String className = joinPoint.getClass().getSimpleName();
		logger.info(className + "." + methodName + args);
		
	}
}
