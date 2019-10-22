<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	String driver= "org.mariadb,jdbc.Driver";
	String url = "jdbc:mariadb://localhost:3306/sample";
	String uid ="user";
	String upw ="1234";
	String query = "select * from member";
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	try {
	
	Class.forName(driver);
	connection= DriverManager.getConnection(url, uid, upw);
	statement = connection.createStatement();
	resultSet = statement.executeQuery(query);
	
	while (resultSet.next()){
	String id = resultSet.getString("id");
	String pw = resultSet.getString("pw");
	String name =resultSet.getString("name");
	
	out.println("<br/>아이디 :" + id +"<br/>");
	out.println("비밀번호 : " + pw + "<br/>");
	out.println("이름 : " + name + "<br/>");
	
	out.println("<br/>=======================");
	}
	}catch (Exception e) {
		e.printStackTrace();
	} finally{
		try{
			if (resultSet != null) resultSet.close();
			if (statement != null) statement.close();
			if (connection !=null) connection.close();
		} catch (Exception e2){
			e2.printStackTrace();
		}
	}

	 
	%>
</body>
</html>