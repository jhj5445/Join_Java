<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> logout.jsp �����Դϴ�. </h1>

<%
session.invalidate();
response.sendRedirect("Login.html");
%>
</body>
</html>