<%-- 
    Document   : home
    Created on : Jan 12, 2021, 7:41:13 AM
    Author     : Muaz Amir
--%>

<%@page  language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="">
      <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
      <meta name="generator" content="Jekyll v4.1.1">
      <title>Alumni FABU</title>

      <!-- Bootstrap core CSS -->
      <link href="CSS/bootstrap.min.css" rel="stylesheet">

      <style>
         .bd-placeholder-img {
           font-size: 1.125rem;
           text-anchor: middle;
           -webkit-user-select: none;
           -moz-user-select: none;
           -ms-user-select: none;
           user-select: none;
         }

         @media (min-width: 768px) {
           .bd-placeholder-img-lg {
             font-size: 3.5rem;
           }
         }
      </style>

      <!-- Custom styles for this template -->
      <link href="css/navbar-top-fixed.css" rel="stylesheet">
   </head>

   <body>

      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

         <div class="container">
         
               <ul class="navbar-nav mr-auto">
                  <li class="nav-item active">
                    <a class="nav-link" href="javascript:;">Home</a>
                  </li>
                     <li class="nav-item active">
                    <a class="nav-link" href="reportHomeUser.jsp">Report</a>
                  </li>
               </ul>

               <ul class="navbar-nav">
                  
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="h#" id="dropdown07" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${signIn.getName()}</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown07">
                      <a class="dropdown-item" href="#">Profile</a>
                      <a class="dropdown-item" href="LogoutController">Logout</a>
                    </div>
                  </li>                  
               </ul>
            </div>
            
      </nav>     

      <main role="main" class="container">

         <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
               <li class="breadcrumb-item active" aria-current="page">Home</li>
            </ol>
         </nav>  

         <!-- Main jumbotron for a primary marketing message or call to action -->
         <div class="jumbotron">
            <div class="container">
               <h1 class="display-3">Hello, world!</h1>
               <p>
                  This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.
               </p>
               <p>
                  <a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a>
               </p>
            </div>
         </div>

         <div class="row">
            <div class="col-md-12">

               <div class="card shadow">
                  <div class="card-body">
                     <h2>Home</h2>
                     <p>Welcome to UTM Alumni System</p>

                  </div>
               </div>
               
            </div>
         </div>

      </main>

      <footer class="container">
         <br />
         <p>&copy; RBK.net 1991-2021</p>
      </footer>
      
      <script src="js/jquery-3.5.1.min.js"></script>
      <script src="js/popper.min.js"></script>      
      <script src="js/bootstrap.min.js"></script>
   </body>   
</html>
