package com.EMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;

@WebServlet
public class ShowEmployees extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);

		// getWriter
		PrintWriter out = resp.getWriter();

		try {

			// setting basic html
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Employee Details</title>");
			// link bootstrap
			out.println("<link rel=\'stylesheet\'  href=\'css/bootstrap.css\'></link>");
			out.println("<marquee margin-top: 10px; color: black;><h2>EMPLOYEE DATA...</h2></marquee>");
			out.println("</head>");
			out.println("</html>");
			// set content type
			resp.setContentType("text/html");

			// jdbc connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/empmanagementsystem?useSSL=false", "root", "root");
			String query = "select * from employeeinfo";
			PreparedStatement pstmt = conn.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			out.println("<div style='margin:auto; width:1400px; margin-top:50px;'>");
			out.println("<table class='table table-hover table-striped'>");
			out.println("<tr>");
			out.println("<th>Name</th>");
			out.println("<th>Fname</th>");
			out.println("<th>BirthDate</th>");
			out.println("<th>Salary</th>");
			out.println("<th>Address</th>");
			out.println("<th>Number</th>");
			out.println("<th>Email</th>");
			out.println("<th>Qualification</th>");
			out.println("<th>Designation</th>");
			out.println("<th>Aadhar</th>");
			out.println("<th>Id</th>");
			out.println("<th>Edit</th>");
			out.println("<th>Delete</th>");
			out.println("</tr>");
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getString("Name"));
				out.println("<td>" + rs.getString("Fname"));
				out.println("<td>" + rs.getString("BirthDate"));
				out.println("<td>" + rs.getString("Salary"));
				out.println("<td>" + rs.getString("Address"));
				out.println("<td>" + rs.getString("Number"));
				out.println("<td>" + rs.getString("Email"));
				out.println("<td>" + rs.getString("Qualification"));
				out.println("<td>" + rs.getString("Designation"));
				out.println("<td>" + rs.getString("Aadhar"));
				out.println("<td>" + rs.getString("Id"));
				
				
				
				out.println("<td><button class='btn btn-outline-success'><a href='editurl?Id=" + rs.getString("Id") + "'>EDIT</a></button></td>");
				out.println("<td><button class='btn btn-outline-danger'><a href='deleteurl?Id=" + rs.getString("Id") + "'>DELETE</a></button></td>");
				
				
				
				out.println("</tr>");
			}
			out.println("</table>");
			// out.println("<style type=\"text/css\">\r\n" + "body {\r\n"
			// + " background-image: url(\"images/bg.jpg\");\r\n" + "}");

		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("<button class='btn btn-outline-success d-block'><a href='AddEmp.jsp'>Home</a></button>");
		out.println("</div>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);

		doGet(req, resp);
	}
}
