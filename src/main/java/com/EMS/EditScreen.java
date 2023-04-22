package com.EMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditScreen extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);

		// getting writer
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		// out.println("<h1>Hello</h1>");

		// linking bootstrap
		out.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");

		// getting unique Id
		String id = req.getParameter("Id");
		// out.println(id);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/empmanagementsystem?useSSL=false", "root", "root");

			String query = "SELECT Name, Fname, BirthDate, Salary, Address, Number, Email, Qualification, Designation, Aadhar FROM employeeinfo WHERE Id=?";
			PreparedStatement pstmt = conn.prepareStatement(query);

			// set value
			pstmt.setString(1, id);

			// resultSet
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				out.println("<title>Edit Employee Page</title>");
				out.println("<h1 class=\"bg-danger text-yellow card-header text-center\">EDIT\r\n"
						+ "			EMPLOYEE</h1>");
				out.println("<div style='margin:auto;width:500px;margin-top:50px;'>");
				out.println("<form action='edit?Id=" + id + "' method='post'>");
				out.println("<table class='table table-hover table-striped'>");

				out.println("<tr>");
				out.println("<td>NAME</td>");
				out.println("<td><input type='text' name='name' value='" + rs.getString("Name") + "'></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>FATHER NAME</td>");
				out.println("<td><input type='text' name='fname' value='" + rs.getString("Fname") + "'></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>DATE OF BIRTH</td>");
				out.println("<td><input type='date' name='dob' value='" + rs.getString("BirthDate") + "'></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>SALARY</td>");
				out.println("<td><input type='text' name='salary' value='" + rs.getString("Salary") + "'></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>ADDRESS</td>");
				out.println("<td><input type='text' name='address' value='" + rs.getString("Address") + "'></td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>NUMBER</td>");
				out.println("<td><input type='text' name='number' value='" + rs.getString("Number") + "'></td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>EMAIL</td>");
				out.println("<td><input type='email' name='email' value='" + rs.getString("Email") + "'></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>QUALIFICATION</td>");
				out.println("<td><input type='text' name='educ' value='" + rs.getString("Qualification") + "'></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>DESIGNATION</td>");
				out.println("<td><input type='text' name='desg' value='" + rs.getString("Designation") + "'></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>AADHAR</td>");
				out.println("<td><input type='text' name='aadhar' value='" + rs.getString("Aadhar") + "'></td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td><button type='submit' class='btn btn-outline-success'>EDIT</button></td>");
				//out.println("<td></td>");
				out.println("<td style='text-align: left;'><button type='reset' class='btn btn-outline-danger'>CANCEL</button></td>");
				//out.println("<td><button type=\"button\" class=\"center-btn\">Click me</button></td>");
				out.println("<td style='text-align: left;'><button class='btn btn-outline-success'><a href='AddEmp.jsp'>HOME</a></button></td>");
				//out.println("<a href='home.html'><button class='btn btn-outline-success'>HOME</button></a>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</form>");

			}

		} catch (SQLException se) {
			out.println("<h2 class='bg-danger text-light text-center'>" + se.getMessage() + "</h2>");
			se.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// set background image
				out.println("<style type=\"text/css\">\r\n" + "body {\r\n" + " background-image: url(\"images/bg.png\");\r\n"
						+ "}");
		
		out.println("</div>");
		// close the writer
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		doGet(req, resp);
	}
}

//catch (SQLException se) {
//out.println("<h2 class='bg-danger text-light text-center'>" + se.getMessage() + "</h2>");
//se.printStackTrace();
//}
