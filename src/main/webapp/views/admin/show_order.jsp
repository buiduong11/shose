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
      <img class="d-block mx-auto mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
      <h2>Add Production</h2>
      <p class="lead">Below is an example form built entirely with Bootstrapâ€™s form controls. Each required form group has a validation state that can be triggered by attempting to submit the form without completing it.</p>
    </div>

    <div class="row g-5">
      <div class="col-md-5 col-lg-4 order-md-last">
        <h4 class="d-flex justify-content-between align-items-center mb-3">
          <span class="text-primary">Your cart</span>
          <!-- <span class="badge bg-primary rounded-pill">3</span> -->
        </h4>
        <form class="card p-2">
            <label for="formFile" class="form-label">Add data use file .exce</label>
            <input class="form-control" type="file" id="formFile" required>
            <hr class="my-4">
            <button class="w-100 btn btn-primary" type="submit">Add data</button>
        </form>
      </div>
      <div class="col-md-7 col-lg-8">
        <h4 class="mb-3">Add Production</h4>
        <form class="needs-validation" method="POST" th:object="${product}" th:action="@{/add_product}" novalidate>
          <div class="row g-3">
            <div class="col-12">
              <label for="address" class="form-label">Title product</label>
              <input type="text" class="form-control" id="title" placeholder="" th:field="*{title_product}" required>
              <div class="invalid-feedback">
                Please enter your shipping address.
              </div>
            </div>

            <div class="col-sm-6">
              <label for="firstName" class="form-label">Quantity</label>
              <input type="text" class="form-control" id="quantity" placeholder="" value="" th:field="*{quantity}" required>
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
            </div>

            <div class="col-sm-6">
              <label for="lastName" class="form-label">Price product</label>
              <input type="text" class="form-control" id="price" placeholder="" value="" th:field="*{price}" required>
              <div class="invalid-feedback">
                Valid last name is required.
              </div>
            </div>

            <div class="col-12">
              <label for="email" class="form-label">Description</label>
              <textarea class="form-control" id="description" rows="5" th:field="*{description}" required></textarea>
            </div>
            <div class="col-sm-6">
              <label for="firstName" class="form-label">Size product</label>
              <input type="text" class="form-control" id="size" placeholder="" value="" required>
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
            </div>
            <div class="col-md-6">
              <label for="country" class="form-label">Category</label>
              <select class="form-select" id="category" th:field="*{category}" required>
                <option value="">Choose...</option>
                <option>United States</option>
              </select>
              <div class="invalid-feedback">
                Please select a valid country.
              </div>
            </div>
          </div>

          <hr class="my-4">

          <div class="col-12">
            <label for="formFile" class="form-label">Add folder image product</label>
            <input class="form-control" type="file" id="formFile" required>
          </div>
          
          <hr class="my-4">

          <button class="w-100 btn btn-primary btn-lg" type="submit">Add data</button>
        </form>
      </div>
    </div>
  </main>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2017 - €“2021 Company Name</p>
    <ul class="list-inline">
      <li class="list-inline-item"><a href="#">Privacy</a></li>
      <li class="list-inline-item"><a href="#">Terms</a></li>
      <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
  </footer>
</div>


    <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

      <script src="../form-validation.js"></script>
  </body>
</html>
