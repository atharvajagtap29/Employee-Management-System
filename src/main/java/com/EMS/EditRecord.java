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

public class EditRecord extends HttpServlet {
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

		// getting unique id
		String id = req.getParameter("Id");
		// out.println(id);

		// getting values
		String name = req.getParameter("name");
		String fname = req.getParameter("fname");
		String dob = req.getParameter("dob");
		String sal = req.getParameter("salary");
		String addr = req.getParameter("address");
		String number = req.getParameter("number");
		String email = req.getParameter("email");
		String qual = req.getParameter("educ");
		String desg = req.getParameter("desg");
		String aadhar = req.getParameter("aadhar");

//		out.println(name);
//		out.println(fname);
//		out.println(dob);
//		out.println(sal);
//		out.println(addr);
//		out.println(number);
//		out.println(email);
//		out.println(qual);
//		out.println(desg);
//		out.println(aadhar);

		try {

			if (number.length() == 10 && aadhar.length() == 12) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/empmanagementsystem?useSSL=false", "root", "root");
				String query = "update employeeinfo set Name=?,Fname=?,BirthDate=?,Salary=?,Address=?,Number=?,Email=?,Qualification=?,Designation=?,Aadhar=? where Id=?";
				// set values
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, name);
				ps.setString(2, fname);
				ps.setString(3, dob);
				ps.setString(4, sal);
				ps.setString(5, addr);
				ps.setString(6, number);
				ps.setString(7, email);
				ps.setString(8, qual);
				ps.setString(9, desg);
				ps.setString(10, aadhar);
				ps.setString(11, id);

				// executeQuery
				int count = ps.executeUpdate();

				if (count == 1) {
					out.println("<title>Edited Successfully</title>");
					out.println("<h2 class='bg-danger text-light text-center'>RECORD SUCCESSFULLY EDITED</h2>");
				}
			} else if (aadhar.length() != 12) {
				out.println("<title>Failed to edit</title>");
				out.println(
						"<h2 class='bg-danger text-light text-center'>COULD NOT EDIT RECORD. INVALID AADHAR NUMBER</h2>");
			} else if (number.length() != 10) {
				out.println("<title>Failed to edit</title>");
				out.println(
						"<h2 class='bg-danger text-light text-center'>COULD NOT EDIT RECORD. INVALID MOBILE NUMBER</h2>");
			}

		}

		catch (SQLException se) {
			out.println("<h2 class='bg-danger text-light text-center'>" + se.getMessage() + "</h2>");
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		out.println("<a href='AddEmp.jsp'><button class='btn btn-outline-success text-center'>HOME</button></a>");
		out.println("&nbsp; &nbsp;");
		out.println(
				"<a href='showemp'><button class='btn btn-outline-success text-center'>SHOW EMPLOYEES</button></a>");
		out.println("</div>");

		// set background image
		out.println("<style type=\"text/css\">\r\n" + "body {\r\n" + " background-image: url(\"images/bg.png\");\r\n"
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
