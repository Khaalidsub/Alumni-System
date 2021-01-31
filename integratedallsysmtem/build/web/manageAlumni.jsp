<%-- 
    Document   : manageUser
    Created on : Jan 29, 2021, 4:04:37 PM
    Author     : Muaz Amir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <link href="CSS/navbar-top-fixed.css" rel="stylesheet">
    </head>
    <body>
        
        <jsp:include page="adminHeaderNav.jsp" />    

        
        <div class="row">
            
            <div class="col-md-1">
                
            </div>
            
            <div class="col-md-3">
                <div class="card" >
                 <img src="image/add_user.png" class="card-img-top" alt="addUser" width="200" height="400">
                  <a href="AdminController?command=Add-Alumni-Page" class="btn btn-primary btn-lg">Add Alumni</a>
              </div>
            </div> 
            
            <div class="col-md-3">
                <div class="card">
                    <img src="image/delete_user.png" class="card-img-top" alt="deleteUser" width="200" height="400">
                  <a href="AdminController?command=Delete-Alumni-Page" class="btn btn-danger btn-lg">Delete Alumni</a>
              </div>
            </div> 
            
             <div class="col-md-3">
                <div class="card">
                 <img src="image/view_user.png" class="card-img-top" alt="viewAlumni" >
                  <a href="AdminController?command=View-Alumni-Page" class="btn btn-danger btn-lg">View Alumni</a>
              </div>
            </div>
            
           
            
        </div>
        
        
        
        
        
        
        
    </body>
</html>
