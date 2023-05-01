<%@page import="com.ezen.biz.service.UserService"%>
<%@page import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@page import="com.ezen.biz.DAO.UserDAO"%>
<%@page import="com.ezen.biz.DTO.UserVO"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// ������ �����̳� �ʱ�ȭ
	AbstractApplicationContext container = 
		new GenericXmlApplicationContext("applicationContext.xml");
		
	UserService userService = (UserService) container.getBean("userService");

	//1. ����� �Է� ���� ����
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//2. DB ���� ó��
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserVO user = userService.getUser(vo);
	
	container.close();
	
	//3. ȭ�� ������̼�
	if(user!=null){
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
	

 %>