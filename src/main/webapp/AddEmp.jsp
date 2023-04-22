
<%
if (session.getAttribute("name") == null) {
	response.sendRedirect("login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Employee Details</title>
<link rel="stylesheet" href="css/bootstrap.css"></link>

<style type="text/css">
body {
	background-image: url("images/addEmp.jpg");
}

#frm {
	width: 500px;
	margin: auto;
	margin-top: 0px;
}

marquee {
	margin-top: 10px;
	color: white;
}
</style>

</head>
<body class="container-fluid">

	<input type="hidden" id="status"
		value="<%=request.getAttribute("status")%>">

	<!-- <h1>Welcome</h1> -->
	<marquee>
		<h2>REGISTER HERE...</h2>
	</marquee>
	<form action="Addemp" method="post" class="form card" id="frm">
		<h2 class="bg-danger text-white card-header center-align">ADD
			EMPLOYEE</h2>
		<table class="table table-hover">

			<tr>
				<td>EMPLOYEE NAME</td>
				<td><input type="text" name="username" required></td>
			</tr>
			<tr>
				<td>FATHER NAME</td>
				<td><input type="text" name="fname" required></td>
			</tr>
			<tr>
				<td>BIRTHDATE</td>
				<td><input type="date" name="dob" required></td>
			</tr>
			<tr>
				<td>SALARY</td>
				<td><input type="text" name="salary" required></td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td><input type="text" name="addr" required></td>
			</tr>
			<tr>
				<td>PHONE NUMBER</td>
				<td><input type="text" name="phone" required></td>
			</tr>
			<tr>
				<td>EMAIL</td>
				<td><input type="email" name="email" required></td>
			</tr>
			<tr>
				<td>QUALIFICATION</td>
				<td><select name="educ">
						<option value="MTECH">M.TECH</option>
						<option value="ME">M.E</option>
						<option value="MSC">M.SC</option>
						<option value="MCA">MCA</option>
						<option value="BTECH">B.TECH</option>
						<option value="BE">B.E</option>
						<option value="BSC">B.SC</option>
						<option value="BCA">BCA</option>
				</select></td>
			</tr>
			<tr>
				<td>DESIGNATION</td>
				<td><input type="text" name="desg" required></td>
			</tr>
			<tr>
				<td>AADHAR</td>
				<td><input type="text" name="aadhar" required></td>
			</tr>
			<tr class="card-footer">
				<td><button type="submit" class="btn btn-outline-success">REGISTER</button></td>
				<td><button type="reset" class="btn btn-outline-danger">CANCEL</button></td>
			</tr>

		</table>
		<button class="btn btn-outline-success d-block">
			<a href="showemp">SHOW USERS</a>
		</button>
	</form>

	<!-- JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>
	<link rel='stylesheet'
		href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link>

	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "success") {
			swal({
				title : "Congrats",
				text : "Employee created successfully",
				type : "success"
			})/*. then(function() {
							window.location.href = "AddEmp.jsp";
						}) */
		} else if (status == "failed") {
			swal("Couldn't Insert", "Unable to create account", "error");
		} else if (status == "invalidNumber") {
			swal("Couldn't Insert", "Number is invalid", "error");
		} else if (status == "invalidAadhar") {
			swal("Couldn't Insert", "Aadhar number is invalid", "error");
		} else if (status == "invalidAddress") {
			swal("Couldn't Insert", "Shorten the address", "error");
		}
	</script>

</body>
</html>