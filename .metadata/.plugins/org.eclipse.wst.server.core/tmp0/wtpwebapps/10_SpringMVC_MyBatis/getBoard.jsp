<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
		<a href="logout.do">Log-out</a>
		<hr>
		<form action="updateBoard.do" method="post">
		<input type="hidden" name="seq" value="${board.seq}"/>
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">����</td>
					<td align="left"><input name="title" type="text" value="${board.title}"/></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">�ۼ���</td>
					<td align="left"><input name="writer" type="text" value="${board.writer}"/></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">�ۼ���</td>
					<td align="left"><textarea name="content" cos="40" rows="10">${board.content}</textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">�����</td>
					<td align="left"><input name="regdate" type="text" value="${board.regDate}"/></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">��ȸ��</td>
					<td align="left"><input name="cnt" type="text" value="${board.cnt}"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="�� ����"/>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertBoard.jsp">�� �ۼ�</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do">�� ���</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteBoard.do?seq=${board.seq}">�� ����</a><br>
	</center>
</body>
</html>