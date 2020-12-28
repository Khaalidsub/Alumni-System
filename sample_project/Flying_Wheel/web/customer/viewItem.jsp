<%-- 
    Document   : viewItem
    Created on : Nov 20, 2019, 4:04:13 PM
    Author     : Bellarina C
--%>

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

        <br>
        <br>
        <div class="container">


            <br>
            <br>

            <c:if test="${not empty success}">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>${success}</strong>
                </div>  
            </c:if>

            <c:if test="${not empty fail}">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>${fail}</strong>
                </div>  
            </c:if>

            <div class="card-deck">
                <c:forEach var="tempItem" items="${ITEM_LIST}">

                    <!--  set up a link to delete a student -->
                    <c:url var="orderLink" value="CustomerControllerServlet">
                        <c:param name="command" value="ADD-CART-ITEM" />
                        <c:param name="itemId" value="${tempItem.id}" />
                    </c:url>

                    <div class="col-sm-4">
                        <div class="card" style="max-width: 18rem; margin-bottom: 10px;">                                          

                            <img src="ImageLoaderServlet?id=${tempItem.id}&name='item'" class="card-img-top" alt="item" height="350px"/>
                            <div class="card-body">
                                <h5 class="card-title">${tempItem.name}</h5>
                                <p class="card-text">Id: ${tempItem.id}</p>
                                <p class="card-text">Brand: ${tempItem.brand}</p>
                                <p class="card-text">Cost: RM ${tempItem.cost}</p>
                                <p class="card-text">Stock: ${tempItem.stock}</p>
                                <c:choose>

                                    <c:when test = "${tempItem.stock >0}">
                                        <a href="${orderLink}" class="btn btn-primary">ADD TO CART</a>
                                    </c:when>


                                    <c:otherwise>
                                        <a href="${orderLink}" ><button class="btn btn-primary" disabled style="background-color: grey">ADD TO CART</button></a>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                        </div>
                    </div>

                </c:forEach>
            </div>
        </div>
    </body>
</html>

