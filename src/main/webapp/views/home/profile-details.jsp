
<%@ page import="com.fa.shop.shoes.models.User"%>

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
	<!-- Start Top Header Bar -->
	<section class="top-header">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-xs-12 col-sm-4">
					<div class="contact-number">
						<i class="tf-ion-ios-telephone"></i> <span>0129-
							12323-123123</span>
					</div>
				</div>
				<div class="col-md-4 col-xs-12 col-sm-4">
					<!-- Site Logo -->
					<div class="logo text-center">
						<a href="/index"> <!-- replace logo here --> <svg
								width="135px" height="29px" viewBox="0 0 155 29" version="1.1"
								xmlns="http://www.w3.org/2000/svg"
								xmlns:xlink="http://www.w3.org/1999/xlink">
							<g id="Page-1" stroke="none" stroke-width="1" fill="none"
									fill-rule="evenodd" font-size="40"
									font-family="AustinBold, Austin" font-weight="bold">
								<g id="Group" transform="translate(-108.000000, -297.000000)"
									fill="#000000">
									<text id="AVIATO">
										<tspan x="108.94" y="325">AVIATO</tspan>
									</text>
								</g>
							</g>
						</svg>
						</a>
					</div>
				</div>
				<div class="col-md-4 col-xs-12 col-sm-4">
					<!-- Cart -->
					<ul class="top-menu text-right list-inline">
						<li class="dropdown cart-nav dropdown-slide"><a href="/cart"
							class="dropdown-toggle"><i class="tf-ion-android-cart"></i>Cart</a>
						</li>
						<!-- / Cart -->

						<!-- Search -->
						<li class="dropdown search dropdown-slide"><a href="#!"
							class="dropdown-toggle" data-toggle="dropdown"
							data-hover="dropdown"><i class="tf-ion-ios-search-strong"></i>
								Search</a>
							<ul class="dropdown-menu search-dropdown">
								<li>
									<form action="post">
										<input type="search" class="form-control"
											placeholder="Search...">
									</form>
								</li>
							</ul></li>
						<!-- / Search -->

						<%
						User s = (User) request.getAttribute("user");
						%>
						<%
						if (s != null) {
						%>
						<li class="dropdown search dropdown-slide"><a
							href="/profile-details" class="dropdown-toggle"><%=s.getFirst_name()%>
								<%=s.getLast_name()%></a></li>
						<%
						} else {
						%>
						<li class="dropdown search dropdown-slide"><a href="/login"
							class="dropdown-toggle">Login</a></li>
						<li class="dropdown search dropdown-slide"><a
							href="/register" class="dropdown-toggle">Register</a></li>
						<%
						}
						%>

					</ul>
					<!-- / .nav .navbar-nav .navbar-right -->
				</div>
			</div>
		</div>
	</section>
	<!-- End Top Header Bar -->


	<!-- Main Menu Section -->
	<section class="menu">
		<nav class="navbar navigation">
			<div class="container">
				<div class="navbar-header">
					<h2 class="menu-title">Main Menu</h2>
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

				</div>
				<!-- / .navbar-header -->


			</div>
			<!-- / .container -->
		</nav>
	</section>
	<section class="page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="content">
						<h1 class="page-name">Dashboard</h1>

					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="user-dashboard page-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ul class="list-inline dashboard-menu text-center">
						<li><a href="/order">Orders</a></li>
						<li><a class="active" href="/profile-details">Profile
								Details</a></li>
					</ul>
					<div class="dashboard-wrapper dashboard-user-profile">
						<div class="media">

							<div class="media-body">
								<%
								User user = (User) request.getAttribute("user");
								%>
								<ul class="user-profile-list">
									<li><span>Full Name:</span><%=user.getFirst_name()%> <%=user.getLast_name()%></li>
									<li><span>Email:</span><%=user.getEmail()%></li>
									<li><span>Phone:</span><%=user.getPhone()%></li>
									<li><span>PassWord</span><a data-toggle="modal"
										data-target="#coupon-modal" href="#!">Change PassWord</a></li>
									<a href="/sign_out">Sign out</a>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Modal -->
	<div class="modal fade" id="coupon-modal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body">

					<div class="form-group">
						<input type="password" class="form-control" name="password"
							id="password" placeholder="Password">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="password"
							id="passwordNew1" placeholder="Password New">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="password"
							id="passwordNew2" placeholder="Password New">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-main text-center"
							onclick="changePassword()">Change PassWord</button>
					</div>

				</div>
			</div>
		</div>
	</div>

	<footer class="footer section text-center">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ul class="social-media">
						<li><a href="https://www.facebook.com/themefisher"> <i
								class="tf-ion-social-facebook"></i>
						</a></li>
						<li><a href="https://www.instagram.com/themefisher"> <i
								class="tf-ion-social-instagram"></i>
						</a></li>
						<li><a href="https://www.twitter.com/themefisher"> <i
								class="tf-ion-social-twitter"></i>
						</a></li>
						<li><a href="https://www.pinterest.com/themefisher/"> <i
								class="tf-ion-social-pinterest"></i>
						</a></li>
					</ul>
					<ul class="footer-menu text-uppercase">
						<li><a href="contact.html">CONTACT</a></li>
						<li><a href="shop.html">SHOP</a></li>
						<li><a href="pricing.html">Pricing</a></li>
						<li><a href="contact.html">PRIVACY POLICY</a></li>
					</ul>
					<p class="copyright-text">
						Copyright &copy;2021, Designed &amp; Developed by <a
							href="https://themefisher.com/">Themefisher</a>
					</p>
				</div>
			</div>
		</div>
	</footer>
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

	<script type="text/javascript">
		const uri = "http://localhost:8080/changePassword";

		function sendLoginRequest(urlToSend, password, password_new, id_user) {
			$.ajax({
				type : "POST",
				url : urlToSend,
				dataType : 'json',
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify({
					id : id_user,
					password : password,
					password_new : password_new
				}),
				success : function(result) {
					alert(result);
					console.log("Success: " + result)
				},
				error : function(result) {
					//console.log("Fail: " + result.responseJSON.message)
				}
			})
		}

		function changePassword() {

			event.preventDefault();
			var password = document.getElementById("password").value;
			var passwordNew1 = document.getElementById("passwordNew1").value;
			var passwordNew2 = document.getElementById("passwordNew2").value;

			console.log(password);
			if (passwordNew1 == passwordNew2) {
				sendLoginRequest(uri, password, passwordNew1,
	<%=s.getId_user()%>
		);

			} else {

			}
		}
	</script>

</body>
</html>