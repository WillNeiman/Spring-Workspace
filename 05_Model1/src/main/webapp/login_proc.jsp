<%@page import="com.ezen.biz.service.UserService"%>
<%@page import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@page import="com.ezen.biz.DAO.UserDAO"%>
<%@page import="com.ezen.biz.DTO.UserVO"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// 스프링 컨테이너 초기화
	AbstractApplicationContext container = 
		new GenericXmlApplicationContext("applicationContext.xml");
		
	UserService userService = (UserService) container.getBean("userService");

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
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
	

 %>