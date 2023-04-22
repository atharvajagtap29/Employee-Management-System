package com.EMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		// link bootstrap
		out.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
		
		//getting unique Id
		String id = req.getParameter("Id");
		// out.println(id);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/empmanagementsystem?useSSL=false", "root", "root");

			String query = "delete from employeeinfo where Id = '" + id + "'";
			PreparedStatement pstmt = conn.prepareStatement(query);

			int rowCnt = pstmt.executeUpdate();

			out.println("<div class='card' style='margin:auto;width:400px;margin-top:200px'>");
			if (rowCnt == 1) {
				out.println("<title>Record Successfully Deleted</title>");
				out.println("<h2 class='bg-danger text-light text-center'>RECORD SUCCESSFULLY DELETED</h2>");
			} else {
				out.println("<title>Could not delete record</title>");
				out.println("<h2 class='bg-danger text-light text-center'>UNABLE TO DELETE RECORD</h2>");
			}
		} catch (SQLException se) {
			out.println("<h2 class='bg-danger text-light text-center'>" + se.getMessage() + "</h2>");
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("<a href='AddEmp.jsp'><button class='btn btn-outline-success text-center'>HOME</button></a>");
		out.println("&nbsp; &nbsp;");
		out.println("<a href='showemp'><button class='btn btn-outline-success text-center'>SHOW EMPLOYEES</button></a>");
		out.println("</div>");

		// set background image
		out.println("<style type=\"text/css\">\r\n" + "body {\r\n" + " background-image: url(\"images/del.jpg\");\r\n"
				+ "}");

		// close the writer
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		doGet(req, resp);
	}
}