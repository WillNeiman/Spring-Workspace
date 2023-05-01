package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[Around Before ó��]");
		Object returnObj = pjp.proceed();
		System.out.println("[Around After ó��]");
		return returnObj;
	}

}
