
<%@ page import="com.fa.shop.shoes.models.*" %>
<%@ page import="java.util.List" %>

<%@ page import="com.fa.shop.shoes.models.Address_order" %>

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
                  <% Address_order address =  (Address_order)request.getAttribute("address");%>
                  <form class="checkout-form">
                     <div class="form-group">
                        <label for="full_name">Full Name</label>
                        <input type="text" class="form-control" name="fullname" id="full_name" value="<%=address.getFull_name() %>" readonly placeholder="">
                     </div>
                     <div class="form-group">
                        <label for="user_address">Address</label>
                        <input type="text" class="form-control" name="address" value="<%=address.getAddress() %>" id="user_address" readonly placeholder="">
                     </div>
                     <div class="checkout-country-code clearfix">
                        <div class="form-group">
                           <label for="user_post_code">Phone</label>
                           <input type="text" class="form-control" id="user_post_code" value="<%=address.getPhone() %>" name="phone" readonly >
                        </div>
                     </div>
                     <% List<Cart> list =  (List<Cart>)request.getAttribute("cart"); %>
                     <button type="submit" class="btn btn-main text-center" onclick="status(<%=list.get(0).getId()%>, 1)" >Processing</button>
                     <button type="submit" class="btn btn-main text-center" onclick="status(<%=list.get(0).getId()%>, 2)" >Canceled</button>
                     <button type="submit" class="btn btn-main text-center" onclick="status(<%=list.get(0).getId()%>, 3)" >Pending</button>
                     <button type="submit" class="btn btn-main text-center" onclick="status(<%=list.get(0).getId()%>, 4)" >Completed</button>
                  </form>
               </div>
               
            </div>
            <div class="col-md-4">
               <div class="product-checkout-details">
                  <div class="block">
                     <h4 class="widget-title">Order Summary</h4>
                     <div id="dev">
                     <% double price = 0; %>
                     
                     <% if(list != null){ %>
                     <% for (Cart cart : list){ %>
                     <% price= (cart.getQuantity() * cart.getPrice()) + price; %>
                     <div class="media product-card">
                        <a class="pull-left" href="">
                           <img class="media-object" src="<%=cart.getImage() %>" alt="Image" />
                        </a>
                        <div class="media-body">
                           <h4 class="media-heading"><a href="product-single.html"><%=cart.getTitle() %></a></h4>
                           <p class="price"><%=cart.getQuantity() %> x $<%=cart.getPrice() %></p>
                           <!--<span class="remove"><a onclick="remove(<%=cart.getId_pro() %>,<%=cart.getId()%>)">Remove</a></span> -->
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
	                           </div></span>
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
	                           </div></span>
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
   <div class="modal fade" id="coupon-modal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-body">
               <form>
                  <div class="form-group">
                     <input class="form-control" type="text" placeholder="Enter Coupon Code">
                  </div>
                  <button type="submit" class="btn btn-main">Apply Coupon</button>
               </form>
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
    	
    	function check(){
    		event.preventdefault();
    	}
    
    	
    	const uri = "http://localhost:8080/admin/cart/remove";
    	const uriStatus = "http://localhost:8080/checkStatus";

    	
    	function sendStatusRequest(urlToSend, id, status) {
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/api/search",
                dataType: 'json',
                url: urlToSend + "?id=" + id +"&status=" + status,

                success: function (result) {
                	console.log("Success: " + result)
                	
                	if(result == 0){
                		
                	}
               
                	
                }, error: function (result) {
                    
                    console.log("Fail: " + result.responseJSON.message)
                }
            })
        }
    	
        function sendLoginRequest(urlToSend, id,id_bill) {
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/api/search",
                dataType: 'json',
                url: urlToSend + "?id=" + id+"&id_bill="+id_bill,

                success: function (result) {
                	console.log("Success: " + result)
                	
                	$("#dev").empty();
                	$("#price").empty();
                	$("#prices").empty();
                	var tr = '';
                	if(result == ''){
                		$("#checkout").remove();
                	}
                	var price = 0;
                	$.each(result, function(index, element) {
                		
                		price = (element.quantity * element.price) + price;
                		console.log("Success: " + price)
                		tr = '<div class="media product-card"><a class="pull-left" href="product-single.html"><img class="media-object" src="'+element.image+'" alt="Image" /></a><div class="media-body"><h4 class="media-heading"><a href="product-single.html">'+element.title+'</a></h4><p class="price">'+element.quantity+'x $'+element.price+'</p><span class="remove"><a onclick="remove('+element.id+')">Remove</a></span></div></div>'+tr;
                    });
                	console.log("Success: " + price)
                	$("#dev").html(tr);
                	$('#price').html(price);
                	$('#prices').html(price);
                	
                }, error: function (result) {
                    
                    console.log("Fail: " + result.responseJSON.message)
                }
            })
        }

        
        function remove(a, id_bill){
    		// e.preventDefault();
            sendLoginRequest(uri, a, id_bill)
    	}
        function status(a, status){
    		event.preventDefault();
            sendStatusRequest(uriStatus, a, status)
    	}
    </script>

  </body>
  </html>