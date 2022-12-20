
<%@page import="com.fa.shop.shoes.models.Sizes"%>
<%@page import="com.fa.shop.shoes.models.Category"%>
<%@ page import="com.fa.shop.shoes.models.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="com.fa.shop.shoes.models.ImageProduct"%>
<%@ page import="com.fa.shop.shoes.models.Comment"%>
<%@ page import="com.fa.shop.shoes.models.Category"%>
<%@ page import="com.fa.shop.shoes.models.Sizes"%>
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
	<section class="single-product">
		<div class="container">

			<%
			Product object = (Product) request.getAttribute("product");
			%>
			<div class="row mt-20">
				<div class="col-md-5">
					<div class="single-product-slider">
						<div id='carousel-custom' class='carousel slide'
							data-ride='carousel'>
							<div class='carousel-outer'>
								<!-- me art lab slider -->
								<div class='carousel-inner '>
									<div class='item active'>
										<img src='<%=object.getImages().get(0).getImage()%>' alt=''
											data-zoom-image="images/shop/single-products/product-1.jpg" />
									</div>

									<%
									for (int i = 1; i < object.getImages().size(); i++) {
									%>
									<div class='item'>
										<img src='<%=object.getImages().get(i).getImage()%>' alt=''
											data-zoom-image="images/shop/single-products/product-2.jpg" />
									</div>

									<%
									}
									%>


								</div>

								<!-- sag sol -->
								<a class='left carousel-control' href='#carousel-custom'
									data-slide='prev'> <i class="tf-ion-ios-arrow-left"></i>
								</a> <a class='right carousel-control' href='#carousel-custom'
									data-slide='next'> <i class="tf-ion-ios-arrow-right"></i>
								</a>
							</div>

							<!-- thumb -->
							<ol class='carousel-indicators mCustomScrollbar meartlab'>
								<%
								for (ImageProduct product : object.getImages()) {
								%>
								<li data-target='#carousel-custom' data-slide-to='0'
									class='active'><img src='<%=product.getImage()%>' alt='' />
								</li>
								<%
								}
								%>
							</ol>
						</div>
					</div>
				</div>
				<form action="product-single?id=<%=object.getId_product()%>"
					method="POST">
					<div class="col-md-7">
						<div class="single-product-details">
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
							<h2><%=object.getTitle_product()%></h2>
							<p class="product-price">
								$<%=object.getPrice()%></p>

							<p class="product-description mt-20">
								<%=object.getDescription()%>
							</p>

							<div class="product-size">
								<span>Size:</span> <select class="form-control" name="size"
									required>
									<option value="0">NONE</option>
									<%
									for (Sizes size : object.getSizes()) {
									%>
									<option value="<%=size.getId()%>"><%=size.getSize()%></option>
									<%
									}
									%>
								</select>
							</div>
							<div class="product-quantity">
								<span>Quantity:</span>
								<div class="product-quantity-slider">
									<input id="product-quantity" type="text" value="0"
										name="product-quantity" required>
								</div>
							</div>
							<div class="product-category">
								<span>Categories:</span>
								<ul>
									<%
									for (Category category : object.getCategory()) {
									%>
									<li><%=category.getCategory()%></li>
									<%
									}
									%>
								</ul>
							</div>
							<button type="submit" class="btn btn-main">Add To Cart</button>
						</div>
					</div>

				</form>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<div class="tabCommon mt-20">
						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" href="#reviews"
								aria-expanded="true">Reviews (<%=object.getComment().size()%>)
							</a></li>


						</ul>
						<div class="tab-content patternbg">

							<div id="reviews" class="tab-pane fade active in">
								<div class="post-comments">
									<form action="addRecomment?id=<%=object.getId_product()%>"
										method="POST">

										<textarea class="form-control" name="review" id="description"
											rows="5" required></textarea>

										<button type="submit" class="btn btn-main"
											style="margin: 10px 0 0 0;">Comment</button>
									</form>
									<ul class="media-list comments-list m-bot-50 clearlist">
										<%
										for (Comment comment : object.getComment()) {
										%>
										<!-- Comment Item start-->
										<li class="media">

											<div class="media-body">
												<div class="comment-info">
													<h4 class="comment-author">
														<a href="#!"><%=comment.getFirst_name() + " " + comment.getLast_name()%></a>

													</h4>
													<div><%=comment.getTime()%></div>

												</div>

												<p>
													<%=comment.getContent()%>
												</p>
											</div>

										</li>
										<%
										}
										%>
										<!-- End Comment Item -->
									</ul>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>




	<!-- Modal -->
	<div class="modal product-modal fade" id="product-modal">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<i class="tf-ion-close"></i>
		</button>
		<div class="modal-dialog " role="document">
			<div class="modal-content">
				<div class="modal-body">
					<div class="row">
						<div class="col-md-8">
							<div class="modal-image">
								<img class="img-responsive"
									src="images/shop/products/modal-product.jpg" />
							</div>
						</div>
						<div class="col-md-3">
							<div class="product-short-details">
								<h2 class="product-title">GM Pendant, Basalt Grey</h2>
								<p class="product-price">$200</p>
								<p class="product-short-description">Lorem ipsum dolor sit
									amet, consectetur adipisicing elit. Rem iusto nihil cum. Illo
									laborum numquam rem aut officia dicta cumque.</p>
								<a href="#!" class="btn btn-main">Add To Cart</a> <a href="#!"
									class="btn btn-transparent">View Product Details</a>
							</div>
						</div>
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
    
    const uri = "http://localhost:8080/cart/remove";

    function sendLoginRequest(urlToSend, id) {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/api/search",
            dataType: 'json',
            url: urlToSend + "?id=" + id,

            success: function (result) {
            	console.log("Success: " + result)
            	
            	$("#dev").empty();
            	var tr = '';
            	if(result == ''){
            		$("#checkout").remove();
            	}
            	$.each(result, function(index, element) {
            		console.log("Success: " + element.id)
            		tr = '<tr class="">
            		<td class=""><div class="product-info"><img width="80" src="'+element.image+'" alt="" /><a href="#!">'+element.title+'</a></div></td><td class="">$'+element.price+'</td><td class="">'+element.quantity+'</td><td class=""><a id="btn-remove" class="product-remove" onclick="remove('+element.id+')">Remove</a></td></tr>'+tr;
                });
            	console.log("Success: " + tr)
            	$("#dev").html(tr);
            	
            }, error: function (result) {
                
                console.log("Fail: " + result.responseJSON.message)
            }
        })
    }

    
    function remove(a){
		// e.preventDefault();
        sendLoginRequest(uri, a)
	}
    </script>

</body>
</html>