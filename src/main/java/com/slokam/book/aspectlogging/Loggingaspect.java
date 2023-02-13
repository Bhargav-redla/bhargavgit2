package com.slokam.book.aspectlogging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class Loggingaspect {
	private final static Logger LOGGER=LoggerFactory.getLogger(Loggingaspect.class);
	@Before("execution(* com.slokam.book.controller.*.*(..))")
	public void before(JoinPoint jp) {
		String methodname=jp.getSignature().getName();
		String classname =jp.getTarget().getClass().toString();
		
		LOGGER.info("entered into the method"+methodname+"of the"+classname);
	}
	@After("execution(* com.slokam.book.controller.*.*(..))")
	public void  after(JoinPoint jp) {
		String methodname=jp.getSignature().getName();
		String classname =jp.getTarget().getClass().toString();
	LOGGER.info("exit into the method"+methodname+"of the"+classname);
	}
	
	
	
}
