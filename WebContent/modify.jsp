<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
	Connection conn;
	Statement stmt;
	ResultSet resultSet;
	
	String id, pw, name;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	id =(String)session.getAttribute("id");
	
String query = "select * from sample where id='"+id+"'";

Class.forName("org.mariadb.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sample","user","1234");

stmt = conn.createStatement();
resultSet= stmt.executeQuery(query);

while (resultSet.next()){
	pw = resultSet.getString("pw");
	name = resultSet.getString("name");
}
%>
<form action="modifyOk" method="post">
		ID : <input type="text" name="id" size="10" value=<%= id  %> readonly="readonly"> <br/>
		PW : <input type="text" name="pw" size="10"> <br/>
		이름 : <input type="text" name="name" size="10" value=<%= name %>> <br/>

<input type="submit" value=수정"> <input type="reset" value="취소">
</form>
</body>
</html>