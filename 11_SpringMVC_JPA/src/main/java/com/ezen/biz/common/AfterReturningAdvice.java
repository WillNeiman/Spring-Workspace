package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.ezen.biz.DTO.UserVO;

//@Aspect
//@Service
public class AfterReturningAdvice {

//	@Pointcut("execution(* com.ezen.biz..*Impl.get*(..))")
//	public void getPointcut() {}
	
	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnObj")
	public void afterReturningLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("����")) {
				System.out.println("[afterReturningLog] �̸�, ���� ��ȸ �Ϸ�");
			}
		}
		
		System.out.println("[afterReturningLog] " + method + "() �޼ҵ� ���ϰ� : " + returnObj.toString());
	}
}
