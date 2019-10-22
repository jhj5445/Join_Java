<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
	String id, pw, name;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>loginResult.jsp 파일입니다.</h1>

<%
	id = (String)session.getAttribute("id");
	pw = (String)session.getAttribute("pw");
	name = (String)session.getAttribute("name");
	
%>

<%= name %>님 안녕하세요<br/>
<a href="modify.jsp">회원정보수정</a>

</body>
</html>