<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.fa.shop.shoes.models.Product" %>
    <%@ page import="com.fa.shop.shoes.models.ImageProduct" %>
     <%@ page import="com.fa.shop.shoes.models.*" %>
    <%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Checkout example Â· Bootstrap v5.0</title>

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


 <% Product object = (Product)request.getAttribute("product"); %>
      <div class="col-md-12 col-lg-12">
        <h4 class="mb-3">Add Production</h4>
        <!-- method="POST" action="/admin/edit_product?id=<%=object.getId_product() %>" -->
        <!-- <form class="needs-validation" enctype="multipart/form-data" id="fileUploadForm" novalidate> -->
          <div class="row g-3">
            <div class="col-12">
              <label for="address" class="form-label">Title product</label>
              <input type="text" class="form-control" id="title_product" placeholder="" name="title" value="<%=object.getTitle_product() %>" required>
              <div class="invalid-feedback">
                Please enter your shipping address.
              </div>
            </div>
            <div class="col-md-6">
              <label for="country" class="form-label">Category</label>
              <% for (Category cate : object.getCategory()){ %>
              	<input type="text" class="form-control" id="category" name="category" placeholder="" value="<%=cate.getCategory() %>" required>
             <% } %>
              <div class="invalid-feedback">
                Please select a valid country.
              </div>
            </div>
            

            <div class="col-sm-6">
              <label for="lastName" class="form-label">Price product</label>
              <input type="text" class="form-control" id="price" placeholder="" value="<%=object.getPrice()%>" name="price" required>
              <div class="invalid-feedback">
                Valid last name is required.
              </div>
            </div>

            <div class="col-12">
              <label for="email" class="form-label">Description</label>
              <textarea class="form-control" id="description" rows="5" name="description" required><%=object.getDescription() %></textarea>
            </div>
            <div id="dev" class="ll">
           <% int i = -1; %>
           <% for (Sizes size : object.getSizes()){ %>
            <% i++; %>
           <div class="row g-3">
            <div class="col-sm-5">
              <label for="firstName" class="form-label">Size product</label>
              <input type="number" class="form-control size" onchange="changeSize(<%=i %>, this.value)" id="size" placeholder="" name="size" value="<%=size.getSize() %>" required>
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
            </div>
            <div class="col-sm-5">
              <label for="firstName" class="form-label">Quantity</label>
              <input type="number" class="form-control quantity" onchange="changeQuantity(<%=i %>, this.value)" id="quantity" placeholder="" value="<%=size.getQuantity() %>" name="quantity" required>
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
            </div>
            <div class="col-sm-1">
              <input class="btn btn-primary" style="margin: 32px 0 0 0;" type="button" onclick="add()" value="Add">
            </div>
            <div class="col-sm-1">
              <input class="btn btn-primary" style="margin: 32px 0 0 0;" type="button" onclick="removeQuantity(<%=i %>)" value="Remove">
            </div>
            </div>
            <% } %>
            </div>
          </div>

          <hr class="my-4">

          <div class="col-12">
            <label for="formFile" class="form-label">Add folder image product</label>
           
         	
            <div id="devImage" class="lll">
              
            <% int ii = -1; %>
         	<% for (ImageProduct product : object.getImages()){ %>
            <% ii++; %>
            <div class="row">
              <div class="row g-3">
                <div class="col-sm-1">
                <input class="btn btn-primary" type="button" onclick="addImage()" value="Add">
                </div>
                <div class="col-sm-2">
                <input class="btn btn-primary" type="button" onclick=" removeImage(<%=ii %>)" value="Remove">
                </div>
                <div class="col-sm-9">
                  <input class="form-control" id="file" onchange="previewFile(<%=ii %>,this)" type="file" name="file" accept="image/png, image/jpeg, image/jpg">
                  <img class="d-block mx-auto mb-4" src="<%=product.getImage() %>" alt="" width="250" height="250" style=" margin: 10px 0 0 0; ">
                </div>
              </div>
            </div>
            <% } %>
            </div>
          </div>
          
          <hr class="my-4">

          <button class="w-100 btn btn-primary btn-lg" onclick="editProduct()" type="submit">Add data</button>
        <!-- </form> -->
      </div>
    </div>
  </main>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2017â??2021 Company Name</p>
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
      var i = <%=i %>
      var ii = <%=ii %>
        function add(){
	       	 i++;
	        console.log(i)
          $( "#dev" ).append( ' <div class="row g-3"> <div class="col-sm-5"> <label for="firstName" class="form-label">Size product</label> <input type="number" class="form-control size" onchange="changeSize('+i+', this.value)" id="size" placeholder="" name="size"  required> <div class="invalid-feedback"> Valid first name is required. </div> </div> <div class="col-sm-5"> <label for="firstName" class="form-label">Quantity</label> <input type="number" class="form-control quantity" onchange="changeQuantity('+i+', this.value)" id="quantity" placeholder="" name="quantity" required> <div class="invalid-feedback"> Valid first name is required. </div> </div> <div class="col-sm-1"> <input class="btn btn-primary" style="margin: 32px 0 0 0;" type="button" onclick="add()" value="Add"> </div> <div class="col-sm-1"> <input class="btn btn-primary" style="margin: 32px 0 0 0;" type="button" onclick="removeQuantity('+i+')" value="Remove"> </div> </div>' );
	        
        }
        function addImage(){
        	++ii;
          $( "#devImage" ).append( '<div class="row"> <div class="row g-3"> <div class="col-sm-1"> <input class="btn btn-primary" type="button" onclick="addImage()" value="Add"> </div> <div class="col-sm-2"> <input class="btn btn-primary" type="button" onclick="removeImage('+ii+')" value="Remove"> </div> <div class="col-sm-9"> <input class="form-control" id="file3" onchange="previewFile('+ii+',this)" type="file" name="file3" accept="image/png, image/jpeg, image/jpg"> <img class="d-block mx-auto mb-4" src="#"  alt="" width="250" height="250" style=" margin: 10px 0 0 0; "> </div> </div> </div>' );
        }
        function removeImage(itemElement){
        	//delete list_id_image[itemElement];
        	list_id_image[itemElement]['image'] = null;
        	var list = document.getElementsByClassName("lll")[0];
        	console.log(itemElement);
        	list.getElementsByClassName("row")[itemElement].parentNode.removeChild(list.getElementsByClassName("row")[itemElement])
        }
        
        function removeQuantity(itemElement){
        	//delete list_id_size[itemElement];
        	list_id_size[itemElement]["size"] = "";
        	list_id_size[itemElement]["quantity"] = 0;
        	console.log("ssss: " + list_id_size.length)
        	var list = document.getElementsByClassName("ll")[0];
        	console.log(list.getElementsByClassName("row")[itemElement])
			    list.getElementsByClassName("row")[itemElement].parentNode.removeChild(list.getElementsByClassName("row")[itemElement])
        }
        
       
        function Sizes(id, id_size_product, size, quantity) {
          	 this.id = id;
          	 this.id_size_product = id_size_product;
          	 this.size = size;
          	 this.quantity = quantity;
        };
        function Image(id_image, id_image_product, image) {
         	 this.id_image = id_image;
         	 this.id_image_product = id_image_product;
         	 this.image = image;
        };
        function Category(id, id_category, category) {
         	 this.id = id;
         	 this.id_category = id_category;
         	 this.category = category;
        };

        var list_id_size = [];
        var list_size = [];
        <% for (int k = 0 ; k < object.getSizes().size() ;k++){ %>
        	var obj_size = new Sizes(<%=object.getSizes().get(k).getId()%>, <%=object.getSizes().get(k).getId_size_product()%>, <%=object.getSizes().get(k).getSize()%> , <%=object.getSizes().get(k).getQuantity()%>);
            list_id_size[<%=k%>] = obj_size;
            list_size[<%=k%>] = obj_size;
        <% } %>
       
        
        var list_id_image = [];
        <% for (int k = 0 ; k < object.getImages().size() ;k++){ %>
        	var obj_image = new Image(<%=object.getImages().get(k).getId_image()%>, <%=object.getImages().get(k).getId_image_product()%>, '<%=object.getImages().get(k).getImage()%>');
        	list_id_image[<%=k%>] = obj_image;
        <% } %>
         
        

       
        function editProduct(){
			var id_product = <%=object.getId_product()%>
	        var title_product = document.getElementById("title_product").value;
	        var description = document.getElementById("description").value;
	        var price = document.getElementById("price").value;
	        var category = document.getElementById("category").value;
	        
        	var data = new FormData();
  			 data.append('id_product', id_product)
  			 data.append('title_product', title_product)
  			 data.append('description', description)
  			 data.append('price', price)
  			 data.append('category', category)
             $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                url: "http://localhost:8080/editProduct",
                data: data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {
                },
                error: function (e) {
                }
             });
        	
        	//list_id_size = list_id_size.filter(function( element ) {
     		   //return element !== undefined;
     		//});
        	
        	//list_id_image = list_id_image.filter(function( element ){
            	//return element !== undefined;
          	//});
        	
        	var list = document.getElementsByClassName("ll")[0];
       	 	var size = list.getElementsByClassName("size");
        	var quantity = list.getElementsByClassName("quantity");

        	console.log(list_id_size.length)
        	console.log(size)
        	if(size.length > list_id_size.length){
        		for(var i = list_id_size.length ; i < size.length ; i++){
            		var obj_size = new Sizes(0, <%=object.getId_product()%>, size[i].value, parseInt(quantity[i].value));
            		list_id_size[i] = obj_size
            	}
        	}

        	for(var i = 0 ; i < list_id_size.length ; i++){
        	
        			var data = new FormData();
        			 data.append('id', list_id_size[i]['id'])
        			 data.append('id_size_product', list_id_size[i]['id_size_product'])
        			 data.append('size', list_id_size[i]['size'])
        			 data.append('quantity', parseInt(list_id_size[i]['quantity']))
                   $.ajax({
                      type: "POST",
                      enctype: 'multipart/form-data',
                      url: "http://localhost:8080/editSize",
                      data: data,
                      processData: false,
                      contentType: false,
                      cache: false,
                      timeout: 600000,
                      success: function (data) {
                      },
                      error: function (e) {
                      }
                   });
        		
        	}

          var listImage = document.getElementsByClassName("lll")[0];
          var image = listImage.getElementsByClassName("form-control");
          console.log("hihi "+image.length)
          console.log("hihi "+list_id_image.length)
          
          if(image.length > list_id_image.length){
      		for(var i = list_id_image.length ; i < image.length ; i++){
          		var obj_image = new Image(0, <%=object.getId_product()%>,image[i].files[0]);
          		list_id_image[i] = obj_image
          	}
      	  }
          
          for(var i = 0 ; i < list_id_image.length ; i++){
         	 
        		  console.log("v1: " + i)
        		  var data = new FormData();
       			 data.append('id_image', list_id_image[i]['id_image'])
       			 data.append('id_image_product', list_id_image[i]['id_image_product'])
       			 data.append('fileImage', list_id_image[i]['image'])
                  $.ajax({
                     type: "POST",
                     enctype: 'multipart/form-data',
                     url: "http://localhost:8080/editImage",
                     data: data,
                     processData: false,
                     contentType: false,
                     cache: false,
                     timeout: 600000,
                     success: function (data) {
                     },
                     error: function (e) {
                     }
                  });

        	  
          }
          	
        }
        function changeSize(i,v){
        	console.log("v1: " + v)
        	console.log("i1: " + i)
          console.log(typeof list_id_size[i]);
          if(typeof list_id_size[i]  === undefined){
            var a = parseInt(v)
            list_id_size[i]['size'] = parseInt(v)
          }
        
        }
        function changeQuantity(i,v){
        	console.log("v2: " + v)
        	console.log("i2: " + i)
          if(typeof list_id_size[i]  === undefined){
            var a = parseInt(v)
        	  list_id_size[i]['quantity'] = parseInt(v)
          }
        }

        function previewFile(i,input) {
        	
            var preview = input.nextElementSibling;
            console.log(preview)
            var file = input.files[0];
            
            

            var reader = new FileReader();
            
            if(typeof list_id_image[i] !== "undefined"){
				list_id_image[i]['image'] = file;
            }

           
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
