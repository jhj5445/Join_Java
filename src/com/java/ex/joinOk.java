package com.java.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

/**
 * Servlet implementation class joinOk
 */
@WebServlet("/joinOk")
public class joinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection conn;
	private Statement stmt;
	
	private String id, pw, name;
    public joinOk() {
    super ();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		actionDo(request, response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		name = request.getParameter("name");
		
		System.out.println("========= GET PARAMETER ============");
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		String query = "insert into sample values('"+id+"', '"+pw+"','"+name+"')";
		System.out.println(query);
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn =DriverManager.getConnection("jdbc:mariadb://localhost:3306/sample","root","1234");
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(query);
			if (1==i) {
				System.out.println("insert success");
				response.sendRedirect("joinResult.jsp");
		} else {
			System.out.println("insert fail");
				response.sendRedirect("join.html");
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != stmt) stmt.close();
				if (null != conn) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
}
}