<%-- 
    Document   : viewManager
    Created on : Oct 26, 2019, 11:10:38 PM
    Author     : Khalid
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Customer Dashboard</title>
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

            <a href="CustomerControllerServlet?command=ADD-BOOKING" class="btn btn-primary">Book</a>
            <br>
            <br>
            <table class="table table-hover text-center">
                <c:if test="${not empty success}">
                    <div class="alert alert-dismissible alert-success">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>Well done!</strong> You successfully Added ${success}.
                    </div>  
                </c:if>
                <c:if test="${not empty fail}">
                    <div class="alert alert-dismissible alert-danger">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>${fail}</strong>
                    </div>  
                </c:if>
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Date from</th>
                        <th scope="col">Date to</th>
                        <th scope="col">Time from</th>
                        <th scope="col">Time to</th>
                        <th scope="col">Cost</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <c:forEach var="tempBooking" items="${BOOKING_LIST}">



                    <!--  set up a link to delete a student -->
                    <c:url var="deleteLink" value="AdminControllerServlet">
                        <c:param name="command" value="DELETE" />
                        <c:param name="userId" value="${tempBooking.id}" />
                    </c:url>


                    <tr>
                        <th scope="row">${tempBooking.id}</th>
                        <td>${tempBooking.date_start}</td>
                        <td>${tempBooking.date_end}</td>
                        <td>${tempBooking.time_start}</td>
                        <td>${tempBooking.time_end}</td>
                        <td>${tempBooking.cost}</td>
                        <td>
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure you want to cancel this Booking?')))
                                           return false">
                                Cancel</a>	
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
