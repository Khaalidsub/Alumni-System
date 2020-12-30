<%-- 
    Document   : customer-register
    Created on : Oct 12, 2019, 1:37:41 AM
    Author     : Khalid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
        <link href="/Flying_Wheel/css/style.css" rel="stylesheet">
    </head>
    <body>
        <!--navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary sticky-top">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">Flying-Wheel</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01"
                        aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarColor01">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="LoginControllerServlet">Login</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="CustomerControllerServlet?command=REGISTER">Register</a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
        <div class="row mt-5">
            <div class="col-md-5 m-auto">
                <div class="card card-body">

                    <h1 class="text-center mb-3"><i class="fas fa-sign-in-alt"></i> Register</h1>
                    <c:if test="${not empty fail}">
                        <div class="alert alert-dismissible alert-danger">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>${fail}</strong>
                        </div>  
                    </c:if>

                 
                    <form action="/Flying_Wheel/CustomerControllerServlet" method="post">
                        <input type="hidden" name="command" value="ADD-CUSTOMER" />
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input
                                type="name"
                                id="name"
                                name="name"
                                class="form-control"
                                placeholder="Enter name" required
                                />  
                        </div>

                        <div class="form-group">
                            <label for="email">Email</label>
                            <input
                                type="email"
                                id="email"
                                name="email"
                                class="form-control"
                                placeholder="Enter Email" required
                                />  
                        </div>
                        <div class="form-group">
                            <label for="name">IC</label>
                            <input
                                type="IC"
                                id="IC"
                                name="IC"
                                class="form-control"
                                placeholder="Enter IC" required
                                />  
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input
                                type="password"
                                id="password"
                                name="password"
                                class="form-control"
                                placeholder="Enter Password" required
                                />
                        </div>
                        <div class="form-group">
                            <label for="Type">Phone</label>
                            <input
                                type="phone"
                                id="phone"
                                name="phone"
                                class="form-control"
                                placeholder="Enter Phone number" required
                                />
                        </div>
                        <div class="form-group">
                            <label for="DOB">Date of birth</label>
                            <input
                                type="date"
                                id="date"
                                name="DOB"
                                class="form-control"
                                placeholder="Enter your date of birth" required
                                />  
                        </div>
                        <br><p align="center"><button type="submit" class="btn btn-primary btn-lg">Register</button></p>
                    </form>
                    <p align="center" class="lead mt-4">
                        Already have an Account? <a href="/Flying_Wheel/login-user.jsp">Login</a>
                    </p>
                </div>
            </div>   
        </div>
    </body>
</html>
