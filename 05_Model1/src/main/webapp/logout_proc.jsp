<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	//1. 브라우저와 연결된 세션 객체를 강제 종료한다.
	session.invalidate();

	//2. 세션 종료 후 메인화면으로 이동
	response.sendRedirect("login.jsp");
%>