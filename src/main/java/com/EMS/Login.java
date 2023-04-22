package com.EMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);

		resp.setContentType("text/html");

		String uname = req.getParameter("logname");
		String pass = req.getParameter("userpass");

		PrintWriter out = resp.getWriter();

//		out.println(uname);
//		out.println(pass);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/empmanagementsystem?useSSL=false", "root", "root");
			String query = "select * from login where username = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uname);
			pstmt.setString(2, pass);
			
			ResultSet rs = pstmt.executeQuery();
			
			HttpSession session = req.getSession();
			RequestDispatcher rd;
			if(rs.next()) {
				session.setAttribute("name", rs.getString("username"));
				Thread.sleep(3000);
				rd = req.getRequestDispatcher("AddEmp.jsp");
			} else {
				req.setAttribute("status", "failed");
				rd = req.getRequestDispatcher("login.jsp");
			}
			
			rd.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
