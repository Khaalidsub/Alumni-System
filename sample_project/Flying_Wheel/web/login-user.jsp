<%-- 
    Document   : UserLogin
    Created on : 29-Oct-2019, 23:06:01
    Author     : Muhammad Mohsin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
        <link href="css/style.css" rel="stylesheet">
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
                    <c:if test="${not empty fail}">
                        <div class="alert alert-dismissible alert-danger">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>${fail}</strong>
                        </div>  
                    </c:if>
                   
                    <c:if test="${not empty success}">
                        <div class="alert alert-dismissible alert-success">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>Well done!</strong> You successfully Registered ${success}.
                        </div>  
                    </c:if>
                    <h1 class="text-center mb-3"><i class="fas fa-sign-in-alt"></i>  Login</h1>
                    <form action="LoginControllerServlet" method="post">
                        <input type="hidden" name="command" value="LOGIN" />
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input
                                type="email"
                                id="email"
                                name="email"
                                class="form-control"
                                placeholder="Enter email" required
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
                        <br><p align="center"><button type="submit" class="btn btn-primary btn-lg">Login</button></p>
                    </form>
                    <p align="center" class="lead mt-4">
                        No Account? <a href="CustomerControllerServlet?command=REGISTER">Register</a>
                    </p>
                </div>
            </div>   
        </div>

    </body>
</html>

