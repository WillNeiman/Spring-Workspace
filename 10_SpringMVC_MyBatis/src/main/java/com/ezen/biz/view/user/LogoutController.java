package com.ezen.biz.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout.do")
	public String handleRequest(HttpSession session) {
    	System.out.println("�α׾ƿ� ó��");
    	
		session.invalidate();
		return "login.jsp";
		
	}

}
