package com.dj.app.aop;

import java.text.DateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dj.app.HomeController;

public class LogAspect {
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
		Object result=null;
		logger.info("호출하려는 메서드 : "+joinPoint.getSignature().toString());
		result = joinPoint.proceed();
		return result;
	}
}
