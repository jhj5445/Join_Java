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

<h1>loginResult.jsp �����Դϴ�.</h1>

<%
	id = (String)session.getAttribute("id");
	pw = (String)session.getAttribute("pw");
	name = (String)session.getAttribute("name");
	
%>

<%= name %>�� �ȳ��ϼ���<br/>
<a href="modify.jsp">ȸ����������</a>

</body>
</html>