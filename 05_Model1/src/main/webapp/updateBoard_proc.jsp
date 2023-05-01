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
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	int seq = Integer.parseInt(request.getParameter("seq"));
	System.out.println(title);
	System.out.println(writer);
	System.out.println(content);
	System.out.println(seq);
	
	//2. DB����ó��
	BoardVO vo = new BoardVO();
	vo.setSeq(seq);
	vo.setTitle(title);
	vo.setWriter(writer);
	vo.setContent(content);
	
	boardService.updateBoard(vo);
	
	//3.ȭ�� ������̼�
	response.sendRedirect("getBoardList.jsp");
%>