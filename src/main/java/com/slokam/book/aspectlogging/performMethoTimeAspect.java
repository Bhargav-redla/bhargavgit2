package com.slokam.book.aspectlogging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Aspect
@Component
public class performMethoTimeAspect {
private final static Logger LOGGER=LoggerFactory.getLogger(performMethoTimeAspect.class);
@Around("execution(* com.slokam.book.*.*.*(..))")
public Object around(ProceedingJoinPoint pjp) {
	Object obj=null;
	String methodname=pjp.getSignature().getName();
	String classname=pjp.getTarget().getClass().toString();
	long starttime =System.currentTimeMillis();
	try {
		obj=pjp.proceed();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	long endtime=System.currentTimeMillis();
	long time=endtime-starttime;
	LOGGER.info("Time taken to excute the method"+methodname+"of the class"+classname+"is"+time);
	
	return obj;
}

}
