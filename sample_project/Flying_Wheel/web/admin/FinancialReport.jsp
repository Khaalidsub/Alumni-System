<%-- 
    Document   : FinancialReport
    Created on : 23-Dec-2019, 19:12:09
    Author     : Muhammad Mohsin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Admin Dashboard</title>
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
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="AdminControllerServlet">Flying-Wheel</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01"
                    aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarColor01">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="AdminControllerServlet">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminControllerServlet?command=VIEW-MANAGER">Managers</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminControllerServlet?command=VIEW-MEMBER">Members</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminControllerServlet?command=VIEW-BICYCLE">Bicycles</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminControllerServlet?command=VIEW-ITEM">Items</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminControllerServlet?command=VIEW-FINANCIAL-REPORT">Financial Report</a>
                    </li>
                </ul>

                <form action="AdminControllerServlet" method="GET">
                    <input type="hidden" name="command" value="LOGOUT" />
                    <button class="btn btn-secondary my-2 my-sm-0 rounded-pill text-white" name="logout" style="background-color: rgb(255, 60, 0);" >logout</button>
                </form>
            </div>
        </nav>

        <!--Table-->
        <br>
        <br>
        <div class="container">
            <table class="table table-hover text-center">
                <c:if test="${not empty BOOKING_LIST}">
                    <thead>
                        <tr>
                            <th scope="col">REPORT ID</th>
                            <th scope="col">DATE</th>
                            <th scope="col">CUSTOMER ID</th>
                            <th scope="col">AMOUNT</th>
                        </tr>
                    </thead>


                    <c:forEach var="tempBooking" items="${BOOKING_LIST}">


                        <tr>
                            <th scope="row">${tempBooking.getId()}</th>
                            <td>${tempBooking.getDate_start()}</td>
                            <td>${tempBooking.getUserid()}</td>
                            <td>RM ${tempBooking.getCost()}.00</td>
                        </tr>

                    </c:forEach>

                    <tr>
                        <th></th>
                        <td></td>
                        <td></td>
                        <c:if test="${not empty TotalCost}">
                            <th>${TotalCost}</th>
                            </c:if>

                    </tr>
                </c:if>
                <c:if test="${not empty TOP_LIST}">
                    <thead>
                        <tr>
                            <th scope="col">REPORT ID</th>
                            <th scope="col">DATE</th>
                            <th scope="col">CUSTOMER ID</th>
                            <th scope="col">CUSTOMER EMAIL</th>
                            <th scope="col">AMOUNT</th>
                        </tr>
                    </thead>


                    <c:forEach var="tempBooking" items="${TOP_LIST}">


                        <tr>
                            <th scope="row">${tempBooking.ID}</th>
                            <td>${tempBooking.date}</td>
                            <td>${tempBooking.userid}</td>
                            <td>${tempBooking.email}</td>
                            <td>RM ${tempBooking.amount}.00</td>
                        </tr>

                    </c:forEach>

                    <tr>
                        <th></th>
                        <td></td>
                        <td></td>
                        <td></td>
                        <c:if test="${not empty TotalCost}">
                            <th>${TotalCost}</th>
                            </c:if>

                    </tr>

                </c:if>
                <c:if test="${not empty ORDER_LIST}">
                    <thead>
                        <tr>
                            <th scope="col">REPORT ID</th>
                            <th scope="col">DATE</th>
                            <th scope="col">CUSTOMER ID</th>
                            <th scope="col">QUANTITY</th>
                            <th scope="col">ITEM ID</th>
                            <th scope="col">COST</th>
                        </tr>
                    </thead>


                    <c:forEach var="tempBooking" items="${ORDER_LIST}">


                        <tr>
                            <th scope="row">${tempBooking.id}</th>
                            <td>${tempBooking.date}</td>
                            <td>${tempBooking.userid}</td>
                            <td>${tempBooking.quantity}</td>
                            <td>${tempBooking.itemid}</td>
                            <td>RM ${tempBooking.total_cost}</td>
                        </tr>

                    </c:forEach>

                    <tr>
                        <th></th>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <c:if test="${not empty TotalCost}">
                            <th>${TotalCost}</th>
                            </c:if>

                    </tr>

                </c:if>
            </table>
        </div>

    </body>
</html>
