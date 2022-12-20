<!DOCTYPE html>
<html lang="en">
<head>

<!-- Basic Page Needs
  ================================================== -->
<meta charset="utf-8">
<title>Aviato | E-commerce template</title>

<!-- Mobile Specific Metas
  ================================================== -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Construction Html5 Template">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=5.0">
<meta name="author" content="Themefisher">
<meta name="generator" content="Themefisher Constra HTML Template v1.0">

<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href="../assets/images/favicon.png" />

<!-- Themefisher Icon font -->
<link rel="stylesheet"
	href="../assets/plugins/themefisher-font/style.css">
<!-- bootstrap.min css -->
<link rel="stylesheet"
	href="../assets/plugins/bootstrap/css/bootstrap.min.css">

<!-- Animate css -->
<link rel="stylesheet" href="../assets/plugins/animate/animate.css">
<!-- Slick Carousel -->
<link rel="stylesheet" href="../assets/plugins/slick/slick.css">
<link rel="stylesheet" href="../assets/plugins/slick/slick-theme.css">

<!-- Main Stylesheet -->
<link rel="stylesheet" href="../assets/css/style.css">

</head>

<body id="body">

	<section class="signin-page account">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="block text-center">
						<a class="logo" href="/index"> <img src="images/logo.png"
							alt="">
						</a>
						<h2 class="text-center">Create Your Account</h2>
						<%
						String notifi = (String) request.getAttribute("notifi");
						%>
						<%
						if (notifi != null) {
						%>
						<div><%=notifi%></div>
						<%
						}
						%>
						<form class="text-left clearfix" action="register" method="POST">
							<div class="form-group">
								<input type="text" class="form-control" name="fisrtName"
									placeholder="First Name" required="required">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" name="lastName"
									placeholder="Last Name" required="required">
							</div>
							<div class="form-group">
								<input type="email" class="form-control" name="email"
									placeholder="Email" required="required">
							</div>
							<div class="form-group">
								<input type="number" class="form-control" name="phone"
									placeholder="Phone" required="required">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" name="password"
									placeholder="Password" required="required">
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-main text-center">Sign
									In</button>
							</div>
						</form>
						<p class="mt-20">
							Already hava an account ?<a href="/login"> Login</a>
						</p>
						<!-- <p><a href="forget-password.html"> Forgot your password?</a></p> -->
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- 
    Essential Scripts
    =====================================-->

	<!-- Main jQuery -->
	<script src="../assets/plugins/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.1 -->
	<script src="../assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<!-- Bootstrap Touchpin -->
	<script
		src="../assets/plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js"></script>
	<!-- Instagram Feed Js -->
	<script src="../assets/plugins/instafeed/instafeed.min.js"></script>
	<!-- Video Lightbox Plugin -->
	<script src="../assets/plugins/ekko-lightbox/dist/ekko-lightbox.min.js"></script>
	<!-- Count Down Js -->
	<script src="../assets/plugins/syo-timer/build/jquery.syotimer.min.js"></script>

	<!-- slick Carousel -->
	<script src="../assets/plugins/slick/slick.min.js"></script>
	<script src="../assets/plugins/slick/slick-animation.min.js"></script>



	<!-- Main Js File -->
	<script src="../assets/js/script.js"></script>



</body>
</html>