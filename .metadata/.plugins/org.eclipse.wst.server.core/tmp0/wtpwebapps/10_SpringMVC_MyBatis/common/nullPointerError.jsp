<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류 - 예외 발생</title>
<style>
    body {
        font-family: Arial, sans-serif;
    }
    h1 {
        color: red;
    }
    pre {
        background-color: #f5f5f5;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
</style>
</head>
<body>
    <h1>오류가 발생했습니다.</h1>
    <h3>예외 상세 정보:</h3>
    <pre>${exception}</pre>
    <p>홈페이지로 돌아가려면 <a href="index.jsp">여기</a>를 클릭하세요.</p>
</body>
</html>