package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Aspect
//@Service
public class BeforeAdvice {
	
//	@Pointcut("execution(* com.ezen.biz..*Impl.*(..))")
//	public void allPointcut() {}
	
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();

		if (args != null && args.length > 0) {
	        System.out.println("[BeforeLog] " + method + "() 메소드 ARGS 정보 : " + args[0].toString());
	    } else {
	    	System.out.println("[BeforeLog] " + method + "() 메소드 ARGS 없음");
	    }
	}

}
