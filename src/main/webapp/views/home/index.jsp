
<%@ page import="com.fa.shop.shoes.models.Product"%>
<%@page import="java.util.List"%>
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
									<form method="get" action="/searchProduct">
										<input type="search" class="form-control" name="search"
											placeholder="Search..." required="required">
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






	<!-- <section class="product-category section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="title text-center">
					<h2>Product Category</h2>
				</div>
			</div>
			<div class="col-md-6">
				<div class="category-box category-box-2">
					<a href="#!">
						<img src="../assets/images/images/image_1_1.jpg" alt="" />
						<div class="content">
							<h3>Shoes man</h3>
							<p>Special Design Comes First</p>
						</div>
					</a>	
				</div>
			</div>
			<div class="col-md-6">
				<div class="category-box category-box-2">
					<a href="#!">
						<img src="../assets/images/images/image_1_1.jpg" alt="" />
						<div class="content">
							<h3>Shoes Women</h3>
							<p>Special Design Comes First</p>
						</div>
					</a>	
				</div>
			</div>
		</div>
	</div>
</section> -->

	<section class="products section bg-gray">
		<div class="container">
			<div class="row">
				<div class="title text-center">
					<h2>Trendy Products</h2>
				</div>
			</div>
			<div class="row" id="ll"></div>

			<div class="btn-group me-2" id="kk" role="group"
				aria-label="First group"></div>

		</div>
	</section>

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
		const uri = "http://localhost:8080/product/page";

		sendRequestAll(0);
		function sendRequestAll(p) {
			$
					.ajax({
						type : "POST",
						contentType : "application/json",
						dataType : 'json',
						url : uri + "?p=" + p,

						success : function(result) {
							console.log("Success: " + result)
							var str = '';
							$("#ll").empty();
							$
									.each(
											result.content,
											function(index, element) {
												str = '<div class="col-md-4"> <div class="product-item"> <div class="product-thumb">  <img class="img-responsive" src="'+element.image+'" alt="product-img" /> </div> <div class="product-content"> <h4> <a href="/product-single?id='
														+ element.id_product
														+ '">'
														+ element.title_product
														+ '</a> </h4> <p class="price">$'
														+ element.price
														+ '</p> </div> </div> </div>'
														+ str;

											});
							console.log(str);
							$("#ll").html(str);

							var strGroupButton = '';
							for (var i = result.totalPages - 1; i >= 0; i--) {
								strGroupButton = '<button type="button" onclick="sendRequestAll('
										+ i
										+ ')" class="btn btn-primary">'
										+ (i + 1)
										+ '</button>'
										+ strGroupButton
							}
							$('#kk').html(strGroupButton)
						},
						error : function(result) {

							console.log("Fail: " + result.responseJSON.message)
						}
					})
		}
	</script>

</body>
</html>