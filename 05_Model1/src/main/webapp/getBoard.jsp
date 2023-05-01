<%@page import="com.ezen.biz.DTO.BoardVO"%>
<%@page import="com.ezen.biz.service.BoardService"%>
<%@page import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//1. �˻��� �Խù� ��ȣ ����
	int seq = Integer.parseInt(request.getParameter("seq"));
	//2. DB ���� ó��	
	AbstractApplicationContext container = 
		new GenericXmlApplicationContext("applicationContext.xml");
		
	BoardService boardService = (BoardService) container.getBean("boardService");
	BoardVO vo = new BoardVO();
	vo.setSeq(seq);
	BoardVO board = boardService.getBoard(vo);
	//3.���� ȭ�� ����
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTMl 4.01 Transitional//EN"
						"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>�� ��</title>
</head>
<body>
	<center>
		<h1>�� ��</h1>
		<a href="logout_proc.jsp">Log-out</a>
		<hr>
		<form action="updateBoard_proc.jsp" method="post">
		<input type="hidden" name="seq" value="<%= board.getSeq()%>"/>
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">����</td>
					<td align="left"><input name="title" type="text" value="<%= board.getTitle() %>"/></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">�ۼ���</td>
					<td align="left"><input name="writer" type="text" value="<%= board.getWriter() %>"/></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">�ۼ���</td>
					<td align="left"><textarea name="content" cos="40" rows="10"><%= board.getContent()%></textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">�����</td>
					<td align="left"><input name="regdate" type="text" value="<%= board.getRegDate() %>"/></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">��ȸ��</td>
					<td align="left"><input name="cnt" type="text" value="<%= board.getCnt() %>"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="�� ����"/>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertBoard.jsp">�� �ۼ�</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.jsp">�� ���</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteBoard_proc.jsp?seq=<%= board.getSeq() %>">�� ����</a><br>
	</center>
</body>
</html>