
<%@ page import="com.fa.shop.shoes.models.Cart" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fa.shop.shoes.models.*" %>
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
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=5.0">
  <meta name="author" content="Themefisher">
  <meta name="generator" content="Themefisher Constra HTML Template v1.0">
  
  <!-- Favicon -->
  <link rel="shortcut icon" type="image/x-icon" href="../assets/images/favicon.png" />
  
  <!-- Themefisher Icon font -->
  <link rel="stylesheet" href="../assets/plugins/themefisher-font/style.css">
  <!-- bootstrap.min css -->
  <link rel="stylesheet" href="../assets/plugins/bootstrap/css/bootstrap.min.css">
  
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
					<i class="tf-ion-ios-telephone"></i>
					<span>0129- 12323-123123</span>
				</div>
			</div>
			<div class="col-md-4 col-xs-12 col-sm-4">
				<!-- Site Logo -->
				<div class="logo text-center">
					<a href="/index">
						<!-- replace logo here -->
						<svg width="135px" height="29px" viewBox="0 0 155 29" version="1.1" xmlns="http://www.w3.org/2000/svg"
							xmlns:xlink="http://www.w3.org/1999/xlink">
							<g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" font-size="40"
								font-family="AustinBold, Austin" font-weight="bold">
								<g id="Group" transform="translate(-108.000000, -297.000000)" fill="#000000">
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
				
					<li class="dropdown cart-nav dropdown-slide">
						<a href="/cart" class="dropdown-toggle"><i
								class="tf-ion-android-cart"></i>Cart</a>

					</li><!-- / Cart -->

					<!-- Search -->
					<li class="dropdown search dropdown-slide">
						<a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"><i
								class="tf-ion-ios-search-strong"></i> Search</a>
						<ul class="dropdown-menu search-dropdown">
							<li>
								<form action="post"><input type="search" class="form-control" placeholder="Search..."></form>
							</li>
						</ul>
					</li><!-- / Search -->

					<% User s =  (User)request.getAttribute("user"); %>
					<% if(s != null){ %>
						<li class="dropdown search dropdown-slide">
						<a href="/profile-details" class="dropdown-toggle"><%=s.getFirst_name() %> <%=s.getLast_name() %></a>
						</li>
					<% } else {%>
						<li class="dropdown search dropdown-slide">
						<a href="/login" class="dropdown-toggle">Login</a>
						</li>
						<li class="dropdown search dropdown-slide">
							<a href="/register" class="dropdown-toggle">Register</a>
						</li>
					<% } %>

				</ul><!-- / .nav .navbar-nav .navbar-right -->
			</div>
		</div>
	</div>
</section><!-- End Top Header Bar -->


<!-- Main Menu Section -->
<section class="menu">
	<nav class="navbar navigation">
		<div class="container">
			<div class="navbar-header">
				<h2 class="menu-title">Main Menu</h2>
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
					aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div><!-- / .navbar-header -->
		</div><!-- / .container -->
	</nav>
</section>
<section class="page-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">Checkout</h1>
					
				</div>
			</div>
		</div>
	</div>
</section>
<div class="page-wrapper">
   <div class="checkout shopping">
      <div class="container">
         <div class="row">
            <div class="col-md-8">
               <div class="block billing-details">
                  <h4 class="widget-title">Billing Details</h4>
                  <form class="checkout-form" method="POST" action="/checkout">
                     <div class="form-group">
                        <label for="full_name">Full Name</label>
                        <input type="text" class="form-control" name="fullname" id="full_name" placeholder="" required="required">
                     </div>
                     <div class="form-group">
                        <label for="user_address">Address</label>
                        <input type="text" class="form-control" name="address" id="address" placeholder="" required="required">
                     </div>
                     <div class="checkout-country-code clearfix">
                        <div class="form-group">
                           <label for="user_post_code">Phone</label>
                           <input type="text" class="form-control" id="phone" name="phone" value="" required="required">
                        </div>
                        
                     </div>
                     <div id="submit">
                     	<button type="submit" data-toggle="modal" class="btn btn-main text-center" onclick="checkout()">Check</button>
                     </div>
                     
                  </form>
                 
               </div>
               
            </div>
            <div class="col-md-4">
               <div class="product-checkout-details">
                  <div class="block">
                     <h4 class="widget-title">Order Summary</h4>
                     <div id="dev">
                     	<%  double price   = 0; %>
                     <% List<Cart> list =  (List<Cart>)request.getAttribute("cart"); %>
                     <% if(list != null){ %>
                     <% for (Cart cart : list){ %>
                     <%
                    		 price= (cart.getQuantity() * cart.getPrice()) + price;
             
                     %>
                     <div class="media product-card">
                        <a class="pull-left" href="product-single.html">
                           <img class="media-object" src="<%=cart.getImage() %>" alt="Image" />
                        </a>
                        <div class="media-body">
                           <h4 class="media-heading"><a href="product-single.html"><%=cart.getTitle() %></a></h4>
                           <p class="price"><%=cart.getQuantity() %> x $<%=cart.getPrice() %></p>
                           <a id="btn-remove" class="product-remove" onclick="remove(<%=cart.getId() %>)">Remove</a>
                        </div>
                     </div>
                     <%} %>
                     <%} %>
                     </div>
                     
                     <ul class="summary-prices">
                        <li>
                           <span>Subtotal:</span>
                           <span class="price">
	                           <div id="price">
	                           		$<%=price %>
	                           </div>
                           </span>
                        </li>
                        <li>
                           <span>Shipping:</span>
                           <span>Free</span>
                        </li>
                     </ul>
                     <div class="summary-total">
                        <span>Total</span>
                        <span>
                        	<div id="prices">
	                           	$<%=price %>
	                        </div>
	                    </span>
                     </div>
                     <div class="verified-icon">
                        <img src="../assets/images/shop/verified.png">
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
</div>
   <!-- Modal -->
   <div class="modal fade" id="coupon-modalee" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-body">
				<h2 id="ookok">sdfsdf</h2>
            </div>
         </div>
      </div>
   </div>
   <!-- Modal -->
   <div class="modal fade" id="coupon-modal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-body">
				<h2>sdfsdf</h2>
               <table class="table">
                  <thead>
                    <tr>
                      <th class="">Item Name</th>
                      <th class="">Item Price</th>
                      <th class="">Item Quantity</th>
                      
                    </tr>
                  </thead>
                  <tbody id="devv">
                  
                  </tbody>
                </table>
            </div>
         </div>
      </div>
   </div>
   
<footer class="footer section text-center">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<ul class="social-media">
					<li>
						<a href="https://www.facebook.com/themefisher">
							<i class="tf-ion-social-facebook"></i>
						</a>
					</li>
					<li>
						<a href="https://www.instagram.com/themefisher">
							<i class="tf-ion-social-instagram"></i>
						</a>
					</li>
					<li>
						<a href="https://www.twitter.com/themefisher">
							<i class="tf-ion-social-twitter"></i>
						</a>
					</li>
					<li>
						<a href="https://www.pinterest.com/themefisher/">
							<i class="tf-ion-social-pinterest"></i>
						</a>
					</li>
				</ul>
				<ul class="footer-menu text-uppercase">
					<li>
						<a href="contact.html">CONTACT</a>
					</li>
					<li>
						<a href="shop.html">SHOP</a>
					</li>
					<li>
						<a href="pricing.html">Pricing</a>
					</li>
					<li>
						<a href="contact.html">PRIVACY POLICY</a>
					</li>
				</ul>
				<p class="copyright-text">Copyright &copy;2021, Designed &amp; Developed by <a href="https://themefisher.com/">Themefisher</a></p>
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
    <script src="../assets/plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js"></script>
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
    const uri_check_cart = "http://localhost:8080/checkcart";

    function sendLoginRequest(urlToSend, id) {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            dataType: 'json',
            url: urlToSend + "?id=" + id,

            success: function (result) {
            	console.log("Success: " + result)
            	
            	$("#dev").empty();
				//$("#devv").empty();
            	$("#price").empty();
            	$("#prices").empty();
            	var tr = '';
				var trr = '';
            	var price = 0;
            	$.each(result, function(index, element) {
            		console.log("Success: " + element.id)
            		price = (element.quantity * element.price) + price;
            		tr = '<div class="media product-card"><a class="pull-left" href="product-single.html"><img class="media-object" src="'+element.image+'" alt="Image" /></a><div class="media-body"><h4 class="media-heading"><a href="product-single.html">'+element.title+'</a></h4><p class="price">'+element.quantity+'x $'+element.price+'</p><span class="remove"><a onclick="remove('+element.id+')">Remove</a></span></div></div>'+tr;
					//trr = '<tr class=""><td class=""><div class="product-info"><img width="80" src="'+element.image+'" alt="" /><a href="#!">'+element.title+'</a></div></td><td class="">$'+element.price+'</td><td class="">'+element.quantity+'</td><td class=""><a id="btn-remove" class="product-remove" onclick="remove('+element.id+')">Remove</a></td></tr>'+trr;
                });
            	console.log("Success: " + price)
            	$("#dev").html(tr);
				//$("#devv").html(trr);
            	$('#price').html(price);
            	$('#prices').html(price);
            	
            }, error: function (result) {
                
                console.log("Fail: " + result.responseJSON.message)
            }
        })
        
   	check_cart(uri_check_cart)
    }

    
    function remove(a){
		// e.preventDefault();
        sendLoginRequest(uri, a)
	}
    function checkout(){
    	event.preventDefault();
		check_cart(uri_check_cart);
    }
    
    function check_cart(url){
    	
    	$.ajax({
            type: "POST",
            contentType: "application/json",
            dataType: 'json',
            url: url,
            success: function (result) {
            	console.log("Success: " + result)
            	console.log("status: " + result.status)
				if(result.status == 2){
					console.log("status: " + result.status)
					$("#devv").empty();
	            	var tr = '';
	            	var price = 0;
	            	$.each(result.data, function(index, element) {
	            		console.log("Success: " + element.id)
	            		price = (element.quantity * element.price) + price;
	            		tr = '<tr class=""><td class=""><div class="product-info"><img width="80" src="'+element.image+'" alt="" /><a href="#!">'+element.title+'</a></div></td><td class="">$'+element.price+'</td><td class="">'+element.quantity+'</td><td class=""></td></tr>'+tr;
	                });
	            	$("#devv").html(tr);
					$('#coupon-modal').modal('show')
				}else if(result.status == 1){
					console.log("status: " + result.status)
					$("#ookok").empty();
					var tr = result.message;
	            	$("#ookok").html(tr);
					$('#coupon-modalee').modal('show')
				}else{
					$("#submit").empty();
					var submit = '<button type="submit" class="btn btn-main text-center">Check</button>';
					$("#submit").html(submit);
					//$('#coupon-modal').modal('hide')
				}
            	
            }, error: function (result) {
                
                console.log("Fail: " + result.responseJSON.message)
            }
        })
    }
    </script>

  </body>
  </html>