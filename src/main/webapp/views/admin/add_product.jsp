<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Checkout example · Bootstrap v5.0</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/checkout/">

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

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="../form-validation.css" rel="stylesheet">
  </head>
  <body class="bg-light">
    
<div class="container">
  <main>
    <div class="py-5 text-center">
      <img class="d-block mx-auto mb-4" src="../assets/images/logo.png" alt="" width="72" height="57">
      <h2>Add Production</h2>
     
    </div>

    <div class="row g-5">


      <div class="col-md-12 col-lg-12">
        <h4 class="mb-3">Add Production</h4>
        <form class="needs-validation" id="mainform" enctype="multipart/form-data" method="POST" action="/admin/add_product" novalidate>
          <div class="row g-3">
            <div class="col-12">
              <label for="address" class="form-label">Title product</label>
              <input type="text" class="form-control" id="title" placeholder="" name="title"  required>
              <div class="invalid-feedback">
                Please enter your shipping address.
              </div>
            </div>
            <div class="col-md-6">
              <label for="country" class="form-label">Category</label>
              
              <input type="text" class="form-control" id="category" name="category" placeholder="" value="" required>
             
              <div class="invalid-feedback">
                Please select a valid country.
              </div>
            </div>
            

            <div class="col-sm-6">
              <label for="lastName" class="form-label">Price product</label>
              <input type="text" class="form-control" id="price" placeholder="" value="" name="price" required>
              <div class="invalid-feedback">
                Valid last name is required.
              </div>
            </div>

            <div class="col-12">
              <label for="email" class="form-label">Description</label>
              <textarea class="form-control" id="description" rows="5" name="description" required></textarea>
            </div>
            <div id="dev" class="ll">
           <div class="row g-3">
	            <div class="col-sm-5">
	              <label for="firstName" class="form-label">Size product</label>
	              <input type="number" class="form-control" id="size" placeholder="" name="size" value="" required>
	              <div class="invalid-feedback">
	                Valid first name is required.
	              </div>
	            </div>
	            <div class="col-sm-5">
	              <label for="firstName" class="form-label">Quantity</label>
	              <input type="number" class="form-control" id="quantity" placeholder="" value="" name="quantity" required>
	              <div class="invalid-feedback">
	                Valid first name is required.
	              </div>
	            </div>
	            <div class="col-sm-1">
	              <input class="btn btn-primary" style="margin: 32px 0 0 0;" type="button" onclick="add()" value="Add">
	            </div>
	            <div class="col-sm-1">
	              <input class="btn btn-primary" style="margin: 32px 0 0 0;" type="button" onclick="removeQuantity(0)" value="Remove">
	            </div>
			</div>
            </div>
          </div>

          <hr class="my-4">

          <div class="col-12">
            <label for="formFile" class="form-label">Add folder image product</label>

			<div id="devImage" class="lll">
            <div class="row">
              <div class="row g-3">
                <div class="col-sm-1">
                <input class="btn btn-primary" type="button" onclick="addImage()" value="Add">
                </div>
                <div class="col-sm-2">
                <input class="btn btn-primary" type="button" onclick="removeImage(0)" value="Input">
                </div>
                <div class="col-sm-9">
                  <input class="form-control" onchange="previewFile(this)" type="file" name="file" accept="image/png, image/jpeg, image/jpg" required>
                  <img class="d-block mx-auto mb-4" src="#"  alt="" width="250" height="250" style=" margin: 10px 0 0 0; ">
                </div>
              </div>
            </div>


            
			</div>
            
            
            
          </div>
          
          <hr class="my-4">

          <button class="w-100 btn btn-primary btn-lg" type="submit">Add data</button>
        </form>
      </div>
    </div>
  </main>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2017–2021 Company Name</p>
    <ul class="list-inline">
      <li class="list-inline-item"><a href="#">Privacy</a></li>
      <li class="list-inline-item"><a href="#">Terms</a></li>
      <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
  </footer>
</div>


    <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

      <script src="../form-validation.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
      <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>  </body>
      
      <script>
      
	      var i = 0;
	      var ii = 0;
        function add(){
        	++i;
          $( "#dev" ).append( '<div class="row g-3"> <div class="col-sm-5"> <label for="firstName" class="form-label">Size product</label> <input type="number" class="form-control" id="size" placeholder="" name="size" value="" required> <div class="invalid-feedback"> Valid first name is required. </div> </div> <div class="col-sm-5"> <label for="firstName" class="form-label">Quantity</label> <input type="number" class="form-control" id="quantity" placeholder="" value="" name="quantity" required> <div class="invalid-feedback"> Valid first name is required. </div> </div> <div class="col-sm-1"> <input class="btn btn-primary" style="margin: 32px 0 0 0;" type="button" onclick="add()" value="Add"> </div> <div class="col-sm-1"> <input class="btn btn-primary" style="margin: 32px 0 0 0;" type="button" onclick="removeQuantity('+i+')" value="Remove"> </div> </div>' );
        }
        function addImage(){
        	++ii;
        	$("#devImage").append( '<div class="row g-3"> <div class="col-sm-1"> <input class="btn btn-primary" type="button" onclick="addImage()" value="Add"> </div> <div class="col-sm-2"> <input class="btn btn-primary" type="button" onclick="removeImage('+ii+')" value="Input"> </div> <div class="col-sm-9"> <input class="form-control" onchange="previewFile(this)" type="file" name="file" accept="image/png, image/jpeg, image/jpg" required> <img class="d-block mx-auto mb-4" src="#"  alt="" width="250" height="250" style=" margin: 10px 0 0 0; "> </div> </div>');
        }
        
        var c = document.getElementById("devImage").childElementCount;
        
		function removeImage(itemElement){
        	
        	var list = document.getElementsByClassName("lll")[0];
        	list.getElementsByClassName("row")[itemElement].parentNode.removeChild(list.getElementsByClassName("row")[itemElement])

        }
		
        function removeQuantity(itemElement){
        	
        	var list = document.getElementsByClassName("ll")[0];
        	list.getElementsByClassName("row")[itemElement].parentNode.removeChild(list.getElementsByClassName("row")[itemElement])
        }
        
        console.log(c)
       
        function previewFile(input) {
          var preview = input.nextElementSibling;
          console.log(preview)
          var file = input.files[0];
          var reader = new FileReader();

          reader.onloadend = function() {
            preview.src = reader.result;
          }

          if (file) {
            reader.readAsDataURL(file);
          } else {
            preview.src = "";
          }
        }
        
        
        
      </script>
      
  </body>
</html>
