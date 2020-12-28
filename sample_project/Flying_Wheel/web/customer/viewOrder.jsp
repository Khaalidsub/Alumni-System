<%-- 
    Document   : viewCart
    Created on : Dec 21, 2019, 2:31:35 PM
    Author     : Bellarina C
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
        <br>
        <br>
        <div class="container">
        <a href="CustomerControllerServlet?command=COMPLETED-ORDER" class="btn btn-primary">Completed Order</a>
        <br>
        <br>
            <!--Table-->
            <table class="table table-hover text-center">
                
                <!--if order is completed-->
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
                
                <thead>
                    <tr>
                        <th scope="col" width="30">Product</th>
                        <th scope="col" align="left"></th>
                        <th scope="col">Quantity</th>
                        <th scope="col" >Total paid</th>
                        <th scope="col">Status</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>                
                
                <c:forEach var="product" items="${orders}">        

                    <!--  set up a link to delete cart item -->
                    <c:url var="viewLink" value="CustomerControllerServlet">
                        <c:param name="command" value="VIEW-ORDER-DETAIL" />
                        <c:param name="orderID" value="${product.order_id}" />
                    </c:url>

                    <tr style="margin:2px 5px 2px 5px; border: 1px solid #cccccc;">                  

                        <td max-height="30"><img src="ImageLoaderServlet?id=${product.item.id}&name='item'" class="card-img-top" alt="bicycle"></td>
                        <td align="left">${product.item.name}</td>
                        <td>${product.quantity}</td>
                        <td>${product.total_cost}</td>                                               
                        <td>${product.status}</td> 
                        <td>
                            <a href="${viewLink}">View Details</a>
                        </td>                        
                    </tr>
                        
                </c:forEach>
            </table>
        </div>
    </body>
</html>
