<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign In Page</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">

<!-- <style type="text/css">
marquee {
	margin-top: 0px;
	color: black;
}
</style> -->

</head>
<body>

	<input type="hidden" id="status"
		value="<%=request.getAttribute("status")%>">

	<div class="main">

		<!-- Sing in  Form -->
		<marquee style="margin-top: -40px;">
			<h2>FOR OFFICE USE ONLY...</h2>
		</marquee>
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="images/signin-image.jpg" alt="sing up image">
						</figure>
						<a href="registration.jsp" class="signup-image-link">Create an
							account</a>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Sign in</h2>
						<form method="Post" action="AddEmployee" class="register-form"
							id="login-form">
							<div class="form-group">
								<label for="username"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="logname" id="username"
									placeholder="Your userame" />
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="userpass" id="password"
									placeholder="Password" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="remember-me" id="remember-me"
									class="agree-term" /> <label for="remember-me"
									class="label-agree-term"><span><span></span></span>Remember
									me</label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Log in" />
							</div>
						</form>
						<div class="social-login">
							<span class="social-label">Or login with</span>
							<ul class="socials">
								<li><a href="https://www.facebook.com/login/"><i
										class="display-flex-center zmdi zmdi-facebook"></i></a></li>
								<li><a href="https://twitter.com/i/flow/login"><i
										class="display-flex-center zmdi zmdi-twitter"></i></a></li>
								<li><a href="https://www.google.com/account/about/"><i
										class="display-flex-center zmdi zmdi-google"></i></a></li>
							</ul>
						</div>

						<!-- Loader class -->
						<!-- <div class="loader center-align"
							style="margin-top: 10px; display: none">

							<div class="progress">
								<div class="indeterminate"></div>
							</div>

							<h6>Please wait...</h6>
						</div> -->


					</div>
				</div>
			</div>
		</section>

	</div>

	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>
	<link rel='stylesheet'
		href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link>

	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "failed") {
			swal("Sorry", "Details Mismatched", "error");
		}
	</script>


</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>