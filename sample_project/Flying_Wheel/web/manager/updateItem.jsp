<%-- 
    Document   : customerTopup
    Created on : 10-Nov-2019, 21:49:34
    Author     : Muhammad Mohsin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manager Dashboard</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
        <link href="/css/style.css" rel="stylesheet">
    </head>

    <body>
        <!--navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="ManagerControllerServlet">Flying-Wheel</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01"
                    aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarColor01">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="ManagerControllerServlet">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ManagerControllerServlet?command=VIEW-BOOKING">Bookings</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ManagerControllerServlet?command=VIEW-ORDER">Orders</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ManagerControllerServlet?command=VIEW-BICYCLE">Bicycles</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ManagerControllerServlet?command=VIEW-ITEM">Items</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ManagerControllerServlet?command=TOP-UP">Top-Up</a>
                    </li>
                </ul>
                <form action="ManagerControllerServlet" method="GET">
                    <input type="hidden" name="command" value="LOGOUT" />
                    <button class="btn btn-secondary my-2 my-sm-0 rounded-pill text-white" name="logout" style="background-color: rgb(255, 60, 0);" >logout</button>
                </form>
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
                            <strong>${success}</strong>
                        </div>  
                    </c:if>
                    <h1 class="text-center mb-3"><i class="fas fa-sign-in-alt"></i>Item</h1>
                    <form action="ManagerControllerServlet" method="post">
                        <input type="hidden" name="command" value="UPDATE-ITEM" />
                        <div class="form-group">
                            <label for="email">Item name</label>
                            <input
                                type="item"
                                id="email"
                                name="item"
                                class="form-control"
                                value="${item.name}"
                                disabled="true"
                                />  
                        </div>
                        <div class="form-group">
                            <label for="email">Item brand</label>
                            <input
                                type="item"
                                id="email"
                                name="item"
                                class="form-control"
                                value="${item.brand}"
                                disabled="true"
                                />  
                        </div>
                        <div class="form-group">
                            <label for="stock">Update Stock</label>
                            <input
                                type="number"
                                id="stock"
                                name="stock"
                                class="form-control"
                                required
                                />  
                        </div>
                        <br><p align="center"><button type="submit" class="btn btn-primary btn-lg">Update Stock</button></p>
                    </form>
                </div>
            </div>   
        </div>
    </body>
</html>
