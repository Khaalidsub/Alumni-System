<%-- 
    Document   : orderDetails
    Created on : Dec 7, 2019, 9:37:07 PM
    Author     : Bellarina C
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <!--Table-->
        <br>
        <br>
        <div class="container">

            <br>
            <br>

            <div class="card" style="margin-bottom: 30px;">
                <div class="card-header" style="background-color: #78C2AD;">
                    <h1 style="color: white;">${order.status}</h1>
                    <h3 style="color: white;">Order ID    : ${order.order_id}</h3>
                </div>
                <div class="card-body">
                    <h2>${order.user.username}</h2>
                    <p>User ID  : ${order.user.userid}</p>
                    <p>Email    : ${order.user.email}</p>
                    <p>Contact  : ${order.user.phone}</p>
                </div>
                <div class="card-footer">
                    <h3>Order Information</h3>
                    <p>Item Name   : ${order.item.name}</p>
                    <p>Item ID     : ${order.item.id}</p>
                    <p>Quantity    : X ${order.quantity}</p>                          
                    <!--to update status-->
                    <form action="ManagerControllerServlet" method="post">
                        <input type="hidden" name="command" value="UPDATE-STATUS">
                        <input type="hidden" name="orderID" value="${order.order_id}">
                        <p>Status      : <select name="status" >
                                <c:if test="${order.status=='Order Placed'}">
                                    <option value = "Preparing">Preparing</option>
                                </c:if>
                                <c:if test="${order.status=='Preparing'}">
                                    <option value = "Ready for Collection">Collect Parcel</option>
                                </c:if>
                                <c:if test="${order.status=='Ready for Collection'}">
                                    <option value = "Completed">Completed</option>
                                </c:if>
                                <c:if test="${order.status=='Completed'}">
                                    <option value = "Completed">Completed</option>
                                </c:if>
                            </select>
                        </p><br>
                        <h3 style="color: #78C2AD;">Order Total : RM ${order.total_cost}</h3>
                        <input type="submit" value="UPDATE" class="btn btn-primary">
                    </form>
                </div>
            </div>

        </div>

    </body>

</html>
