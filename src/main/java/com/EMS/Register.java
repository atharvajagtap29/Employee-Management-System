package com.EMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		String name = req.getParameter("username");
		String email = req.getParameter("useremail");
		String pass = req.getParameter("userpass");
		String uname = req.getParameter("logname");
		String contact = req.getParameter("contact");

//			out.println(name);
//			out.println(email);
//			out.println(pass);
//			out.println(uname);
//			out.println(contact);

		try {
			
			RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
			
			if (!name.equals("") && !email.equals("") && !pass.equals("") && !uname.equals("") && !contact.equals("")) {

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/empmanagementsystem?useSSL=false", "root", "root");
				String query = "insert into login(username, password) values(?,?)";

				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, uname);
				pstmt.setString(2, pass);

				int rowCnt = pstmt.executeUpdate();
				

				if (rowCnt > 0) {
					req.setAttribute("status", "success");
					//Thread.sleep(5000);
					//rd = req.getRequestDispatcher("login.jsp");
				} else {
					req.setAttribute("status", "failed");
				}
			} else if(name.equals("") || email.equals("") || uname.equals("") || contact.equals("") || pass.equals("")){
				req.setAttribute("status", "incomplete");
			}
			
			rd.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
