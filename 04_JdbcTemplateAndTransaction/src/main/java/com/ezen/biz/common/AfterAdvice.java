package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class AfterAdvice {
	
//	@Pointcut("execution(* com.ezen.biz..*Impl.get*(..))")
//	public void allPointcut() {}
	
	@After("PointcutCommon.allPointcut()")
	public void afterLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		System.out.println("[afterLog] " + method + "() 포인트컷 메소드 실행 후 무조건 출력");
	}

}
