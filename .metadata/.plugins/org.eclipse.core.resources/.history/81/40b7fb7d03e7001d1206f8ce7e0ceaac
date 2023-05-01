<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTMl 4.01 Transitional//EN"
						"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>글 상세</title>
</head>
<body>
	<center>
		<h1>글 상세</h1>
		<a href="logout.do">Log-out</a>
		<hr>
		<form action="updateBoard.do" method="post">
		<input type="hidden" name="seq" value="${board.seq}"/>
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input name="title" type="text" value="${board.title}"/></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">작성자</td>
					<td align="left"><input name="writer" type="text" value="${board.writer}"/></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">작성자</td>
					<td align="left"><textarea name="content" cos="40" rows="10">${board.content}</textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">등록일</td>
					<td align="left"><input name="regdate" type="text" value="${board.regDate}"/></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">조회수</td>
					<td align="left"><input name="cnt" type="text" value="${board.cnt}"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="글 수정"/>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertBoard.jsp">글 작성</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do">글 목록</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteBoard.do?seq=${board.seq}">글 삭제</a><br>
	</center>
</body>
</html>