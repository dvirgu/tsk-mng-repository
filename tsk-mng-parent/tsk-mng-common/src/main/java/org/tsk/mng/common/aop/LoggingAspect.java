package org.tsk.mng.common.aop;

import java.util.Arrays;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	private static final Logger logger = Logger.getLogger(LoggingAspect.class);
	
	@Before("execution(* org.tsk.mng..*(..))")
	public void logBefore(JoinPoint joinPoint){
		
		String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		logger.info(className + "." + methodName + Arrays.toString(args));
		
	}
}
