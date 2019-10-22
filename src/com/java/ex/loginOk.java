package com.java.ex;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class joinOk
 */
@WebServlet("/loginOk")
public class loginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection conn;
	private java.sql.Statement stmt;
	private ResultSet resultSet;
	
	private String id, pw, name;
    public loginOk() {
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
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		String query = "select * from sample where id='"+id+"' and pw='"+pw+"'";
	try {
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sample", "root", "1234");
		stmt = conn.createStatement();
		resultSet = stmt.executeQuery(query);

		while (resultSet.next()) {
			
			id= resultSet.getString("id");
			pw= resultSet.getString("pw");
			name = resultSet.getString("name");
			
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("id",  id);
		httpSession.setAttribute("pw", pw);
		httpSession.setAttribute("name", name);
		
		response.sendRedirect("loginResult.jsp");
		}
		if (resultSet.next()==false) {
			request.setAttribute("id", id);
			request.setAttribute("pw", pw);
			RequestDispatcher dispacher = request.getRequestDispatcher("/login.jsp");
			dispacher.forward(request, response);
		}
} catch (Exception e) {
	e.printStackTrace();
}finally {
	try {
		if (null !=resultSet) resultSet.close();
		if (null !=stmt) stmt.close();
		if (null != conn) conn.close();
	} catch (Exception e) {
		e.printStackTrace();}
	}
	}
	}
