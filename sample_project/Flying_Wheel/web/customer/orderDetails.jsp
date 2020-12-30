<%-- 
    Document   : checkout
    Created on : Dec 22, 2019, 3:31:21 AM
    Author     : Bellarina C
--%>

<%@page import="entity.Order"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>View Cart</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>

        <!--navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="CustomerControllerServlet">Flying-Wheel</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01"
                    aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarColor01">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="CustomerControllerServlet">Home<span class="sr-only">(current)</span></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="CustomerControllerServlet?command=VIEW-BOOKING">Booking</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerControllerServlet?command=VIEW-SHOP">Shop</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerControllerServlet?command=VIEW-CART">Cart</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerControllerServlet?command=VIEW-ORDER">Order</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerControllerServlet?command=TOP-UP">Top-Up</a>
                    </li>
                </ul>

                <form action="CustomerControllerServlet" method="GET">
                    <input type="hidden" name="command" value="LOGOUT" />
                    <button class="btn btn-secondary my-2 my-sm-0 rounded-pill text-white" name="logout" style="background-color: rgb(255, 60, 0);" >logout</button>
                </form>
            </div>
        </nav>

        <!--Table-->
        <br>
        <br>
        <div class="container">

            <br>
            <br>

            <form action="CustomerControllerServlet" method="POST">
                <input type="hidden" name="command" value="ADD-ORDER"> 

                <div class="card" style="margin-bottom: 30px;"> 
                    <div class="card-body">
                        <h3 style="color: #78C2AD;">Collection Address</h3>
                        <p><span>UTM Bicycle Shop</span> Student Mall, Jalan Meranti, UTM Skudai</p>
                    </div>
                </div>
                <%
                    Order order = (Order) request.getAttribute("order");
                %> 

                <div class="card" style="margin-bottom: 20px;">
                    <div class="card-header">
                        <img src="ImageLoaderServlet?id=<%= order.getItem().getId()%>&name='item'" class="card-img-top" alt="bicycle" height="300">
                    </div>
                    <div class="card-body">
                        <table class="table table-hover text-center">
                            <tr style="background-color: #78C2AD; width: 100%;">
                                <th></th>
                                <th>Item info</th>
                            </tr>
                            <tr>
                                <td><b>Product:</b> </td>
                                <td><%= order.getItem().getName()%></td>
                            </tr>
                            <tr>
                                <td><b>Brand: </b></td>
                                <td><%= order.getItem().getBrand()%></td>
                            </tr>
                            <tr>
                                <td><b>Cost: </b></td>
                                <td><%= order.getItem().getCost()%></td>
                            </tr>
                            <tr>
                                <td><b>Quantity: </b></td>
                                <td><%= order.getQuantity()%></td>
                            </tr>
                            <tr>
                                <td><b>Total paid: </b></td>
                                <td><%= order.getTotal_cost()%></td>
                            </tr>
                            <tr>
                                <td><b>Status: </b></td>
                                <td><%= order.getStatus()%></td>
                            </tr>
                        </table>
                    </div>                                  
                </div>

                <div class="card" style="margin-bottom: 30px;"> 
                    <div class="card-body" style="width: 100%">
                        <h3 style="color: #78C2AD;">Payment Method:</h3>
                        <p>E-wallet</p>
                        <a href="CustomerControllerServlet?command=VIEW-ORDER" style="width: 100%;" class="btn btn-primary">Go Back </a>


                    </div>
                </div>
            </form>
        </div>        
    </body>

</html>

