package com.ezen.biz.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.ezen.biz.DTO.UserVO;
import com.ezen.biz.service.UserService;
import com.ezen.biz.view.controller.CommonController;

@Controller
public class LoginController implements CommonController{
	
    @Autowired
    private UserService userService;

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		// 컨테이너 초기화
    	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
    	this.userService = (UserService)container.getBean(UserService.class);

		//1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserVO user = userService.getUser(vo);
		container.close();
		
		//3. 화면 내비게이션
		if(user!=null){
			return "getBoardList.do";
		} else {
			return "login.do";
		}
	}

}
