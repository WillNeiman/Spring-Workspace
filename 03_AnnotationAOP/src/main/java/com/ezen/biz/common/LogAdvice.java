package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Service
//@Aspect
public class LogAdvice {
	
	//핵심 관심
	@Pointcut("execution(* com.ezen.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.ezen.biz..*Impl.get*(..))")
	public void getPointcut() {}

	//횡단 관심
	@Before("allPointcut()")
	public void beforeLog(JoinPoint jp) {
		System.out.println("[@Before] " + jp.getSignature().toShortString() + " 시작");
	}
	
	@After("allPointcut()")
	public void afterLog(JoinPoint jp) {
		System.out.println("[@After] " + jp.getSignature().toShortString() + " 종료");
	}
	
	@AfterReturning("allPointcut()")
	public void afterReturningLog(JoinPoint jp) {
		System.out.println("[@AfterReturning] " + jp.getSignature().toShortString() + " 종료");
	}
	
	@AfterThrowing("allPointcut()")
	public void afterThrowing(JoinPoint jp) {
		System.out.println("[@AfterThrowing] " + jp.getSignature().toShortString() + " 종료");
	}
}
