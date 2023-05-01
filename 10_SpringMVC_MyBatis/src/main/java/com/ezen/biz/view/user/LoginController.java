package com.ezen.biz.view.user;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.biz.DAO.UserDAO;
import com.ezen.biz.DTO.UserVO;

@Controller
public class LoginController{

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("�α��� ó��");
		if(vo.getId()==null || vo.getId().equals("")) {
			throw new IllegalArgumentException("���̵�� �ݵ�� �Է��ؾ� �մϴ�.");
		}
		
		UserVO user = userDAO.getUser(vo);
		if(user!=null){
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";		
		}
	}

	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user")UserVO vo) {
		System.out.println("�α��� ȭ������ �̵�");
		vo.setId("test");
		vo.setPassword("1234");
		return "login.jsp";
	}

}