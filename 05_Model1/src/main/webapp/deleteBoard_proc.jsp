<%@page import="com.ezen.biz.DTO.BoardVO"%>
<%@page import="com.ezen.biz.service.BoardService"%>
<%@page import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

	AbstractApplicationContext container = 
		new GenericXmlApplicationContext("applicationContext.xml");
		
	BoardService boardService = (BoardService) container.getBean("boardService");
	//1. ����� �Է� ���� ����
	
	request.setCharacterEncoding("UTF-8");
	int seq = Integer.parseInt(request.getParameter("seq"));
	
	//2. DB����ó��
	BoardVO vo = new BoardVO();
	vo.setSeq(seq);
	
	boardService.deleteBoard(vo);
	
	//3.ȭ�� ������̼�
	response.sendRedirect("getBoardList.jsp");
%>