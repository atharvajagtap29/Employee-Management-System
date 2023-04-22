package com.EMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DataTruncation;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class AddEmp extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);

		try {

			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();

			Random random = new Random();
			int eid = random.nextInt(500) + 1;

			String ename = req.getParameter("username");
			String fname = req.getParameter("fname");
			String dob = req.getParameter("dob");
			String salary = req.getParameter("salary");
			String addr = req.getParameter("addr");
			String number = req.getParameter("phone");
			String email = req.getParameter("email");
			String educ = req.getParameter("educ");
			String desg = req.getParameter("desg");
			String aadhar = req.getParameter("aadhar");
			String id = eid + "";

//			out.println("<h1>" + ename + "</h1>");
//			out.println("<h1>" + fname + "</h1>");
//			out.println("<h1>" + dob + "</h1>");
//			out.println("<h1>" + salary + "</h1>");
//			out.println("<h1>" + addr + "</h1>");
//			out.println("<h1>" + number + "</h1>");
//			out.println("<h1>" + educ + "</h1>");
//			out.println("<h1>" + desg + "</h1>");
//			out.println("<h1>" + aadhar + "</h1>");
//			out.println("<h1>" + id + "</h1>");
//			out.println("<h1>" + email + "</h1>");

			// load the jdbc driver
			RequestDispatcher rd = req.getRequestDispatcher("AddEmp.jsp");

			try {

				int numLength = 10;
				int aadharLength = 12;

				if (number.length() == numLength && aadhar.length() == aadharLength) {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/empmanagementsystem?useSSL=false", "root", "root");
					String query = "insert into employeeinfo(Name, fname, BirthDate, Salary, Address, Number, Email, Qualification, Designation, Aadhar, Id) values(?,?,?,?,?,?,?,?,?,?,?)";

					PreparedStatement pstmt = conn.prepareStatement(query);
					pstmt.setString(1, ename);
					pstmt.setString(2, fname);
					pstmt.setString(3, dob);
					pstmt.setString(4, salary);
					pstmt.setString(5, addr);
					pstmt.setString(6, number);
					pstmt.setString(7, email);
					pstmt.setString(8, educ);
					pstmt.setString(9, desg);
					pstmt.setString(10, aadhar);
					pstmt.setString(11, id);

					int rowCnt = pstmt.executeUpdate();

					if (rowCnt > 0) {
						req.setAttribute("status", "success");
					} else {
						req.setAttribute("status", "failed");
					}

					// req.setAttribute("status", "success");

				}

				if (number.length() != numLength) {
					req.setAttribute("status", "invalidNumber");
				} else if (aadhar.length() != aadharLength) {
					req.setAttribute("status", "invalidAadhar");
				}

			} catch (DataTruncation e) {
				// e.printStackTrace();
				req.setAttribute("status", "invalidAddress");
			}

			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
