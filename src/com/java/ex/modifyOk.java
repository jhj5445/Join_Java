package com.java.ex;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class joinOk
 */
@WebServlet("/modifyOk")
public class modifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection conn;
	private java.sql.Statement stmt;
	private String id, pw, name;
	
	HttpSession session;
    public modifyOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		session = request.getSession();
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		name = request.getParameter("name");
		
		if (pwConfirm()) {
			System.out.println("OK");
			String query = " update sample set name='" + name + "'";
	try {
		Class.forName("org.mariadb.jdbc.Driver");
		System.out.println("드라이버 연결 성공");
		conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sample", "root", "1234");
		stmt = conn.createStatement();
		int i = stmt.executeUpdate(query);
		System.out.println("after query");
		System.out.println(i);
		if (1==i) {
			System.out.println("update success");
			session.setAttribute("name", name);
			response.sendRedirect("modifyResult.jsp");
		}else {
			System.out.println("update fail, i="+i);
			response.sendRedirect("modify.jsp");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
	try {
		if (null !=stmt) stmt.close();
		if (null != conn) conn.close();
	} catch (Exception e) {e.printStackTrace();}
	}
} else {
	System.out.println("Wrong PW");
	response.sendRedirect("modify.jsp");
}
	}
	private boolean pwConfirm() {
		boolean rs = false;
		
		String sessionPw = (String) session.getAttribute("pw");
		System.out.println("pw");
		if (sessionPw.equals(pw)) rs = true ;
		
		return rs;
	}
}