package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Aspect
@Service
public class AroundAdvice {
	
//	@Pointcut("execution(* com.ezen.biz..*Impl.*(..))")
//	public void allPointcut() {}
	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		System.out.println("[Around Before : stopWatch.start()]");
		Object returnObj = pjp.proceed();
		stopWatch.stop();
		System.out.println("[Around After : stopWatch.stop()] " + stopWatch.getTotalTimeMillis());
		return returnObj;
	}

}
