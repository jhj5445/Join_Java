<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> modifyResult.jsp �����Դϴ�.</h1>

<%= session.getAttribute("name")  %>���� ȸ������ ������ ���� ó�� �Ǿ����ϴ�. <br/>
<a href = "Logout.jsp">�α׾ƿ�</a> &nbsp;&nbsp; <a href="modify.jsp">ȸ����������</a>
</body>
</html>