<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="loginOk" method="post">
		ID : <input type="text" name="id"><br/>
		<br/>
		PW : <input type="password" name="pw"><br/>
		<% 
		if (request.getAttribute("id")!=null){
		%>
		<p style="color:red; font-size:12px;">������ �޶� �α��� �� �� �����ϴ�.</p>
		<%
		}
%> 
		<input type="submit" value="login">
	</form>
	
</body>
</html>
