<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.fa.shop.shoes.models.Product"%>
<%@page import="java.util.List"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.84.0">
<title>Product</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/dashboard/">



<!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>


<!-- Custom styles for this template -->
<link href="../dashboard.css" rel="stylesheet">
</head>
<body>

	<header
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Company
			name</a>
		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="navbar-nav">
			<div class="nav-item text-nowrap">
				<a class="nav-link px-3" href="/admin/sign_out">Sign out</a>
			</div>
		</div>
	</header>

	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="position-sticky pt-3">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link"
							href="/admin/dashboard"> <span data-feather="home"></span>
								Dashboard
						</a></li>
						<li class="nav-item"><a class="nav-link" href="/admin/order">
								<span data-feather="file"></span> Orders
						</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="/admin/product" aria-current="page"> <span
								data-feather="shopping-cart"></span> Products
						</a></li>
						<li class="nav-item"><a class="nav-link" href="/admin/user">
								<span data-feather="users"></span> Customers
						</a></li>
						<li class="nav-item"><a class="nav-link" href="/admin/review">
								<span data-feather="bar-chart-2"></span> Review
						</a></li>
						
					</ul>


				</div>
			</nav>

			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Production</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<a class="btn btn-primary" href="/admin/add_product" role="button">Add
							Product</a>

					</div>
				</div>

				<!-- <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas> -->

				<!-- <h2>Section title</h2> -->
				<div class="table-responsive">
					<table class="table table-striped table-sm">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Title</th>
								<th scope="col">Description</th>
								<th scope="col">Price</th>
								<th scope="col">Quantity</th>
								<th scope="col">Category</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody id="ll">

						</tbody>
					</table>
					<div class="btn-group me-2" id="kk" role="group"
						aria-label="First group"></div>
				</div>
			</main>
		</div>
	</div>

	<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
		integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
		integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
		crossorigin="anonymous"></script>
	<script src="../dashboard.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>
</body>

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
												str = '<tr> <td>'+element.id_product+'</td> <td>'+element.title_product+'</td> <td>'+element.description+'</td> <td>'+element.price+'</td> <td>'+element.quantity+'</td> <td> <a class="btn btn-primary btn-sm" style="font-size: 10px; width: 100%;" href="/admin/delete_product?id='+element.id_product+'" role="button">Delete</a> <a class="btn btn-primary btn-sm" style="font-size: 10px; width: 100%;" href="/admin/show_product?id='+element.id_product+'" role="button">Show</a> </td> </tr>' + str;
				
											});
							//console.log(str);
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
</html>
