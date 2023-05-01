package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[Around Before 贸府]");
		Object returnObj = pjp.proceed();
		System.out.println("[Around After 贸府]");
		return returnObj;
	}

}
