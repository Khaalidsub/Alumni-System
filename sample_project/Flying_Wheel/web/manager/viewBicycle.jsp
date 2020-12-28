<%-- 
    Document   : viewBicycle
    Created on : Nov 8, 2019, 6:32:32 PM
    Author     : Bellarina C
--%>

<%@page import="java.io.InputStream"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
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
        <link href="css/style.css" rel="stylesheet">
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

            <a href="ManagerControllerServlet?command=ADD-BICYCLE" class="btn btn-primary">Add-Bicycle</a>
            <br>
            <br>

                <c:if test="${not empty success}">
                    <div class="alert alert-dismissible alert-success">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>Well done!</strong> You successfully Added ${success}.
                    </div>  
                </c:if>
                
            <div class="card-deck">
                <c:forEach var="tempBicycle" items="${BICYCLE_LIST}">

                    <!--  set up a link to delete a bicycle -->
                    <c:url var="deleteLink" value="ManagerControllerServlet">
                        <c:param name="command" value="DELETE-BICYCLE" />
                        <c:param name="id" value="${tempBicycle.id}" />
                    </c:url>
                    <div class="col-sm-4">
                    <div class="card" style="max-width: 18rem; margin-bottom: 10px;">                                          
                        
                        <img src="ImageLoaderServlet?id=${tempBicycle.id}&name=bicycle" class="card-img-top" alt="bicycle" width="auto" height="350px">
                        <div class="card-body">
                          <h5 class="card-title">${tempBicycle.name}</h5>
                          <p class="card-text">Id: ${tempBicycle.id}</p>
                          <p class="card-text">type: ${tempBicycle.type}</p>
                          <p class="card-text">rent: RM ${tempBicycle.rent_cost}/hour</p>
                          <a href="${deleteLink}" class="btn btn-primary" 
                             onclick="if (!(confirm('Are you sure you want to delete this bicycle?')))
                                           return false">Delete</a>
                        </div>
                    </div>
                    </div>
                             
                </c:forEach>
            </div>
        </div>
    </body>
</html>

