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
       
            <!--Table-->
            <form method="POST" action="CustomerControllerServlet">
                <input type="hidden" name="command" value="CHECK-OUT">
                <div class="container">
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
                        <th scope="col">Brand</th>
                        <th scope="col" >Quantity</th>
                        <th scope="col">Cost</th>
                        <th scope="col">Stock</th> 
                        <th scope="col">Action</th>
                    </tr>
                </thead>                
                
                <c:forEach var="product" items="${cart}">        

                    <!--  set up a link to delete cart item -->
                    <c:url var="deleteLink" value="CustomerControllerServlet">
                        <c:param name="command" value="DELETE-CART-ITEM" />
                        <c:param name="cartID" value="${product.cartID}" />
                    </c:url>

                    <tr style="margin:2px 5px 2px 5px; border: 1px solid #cccccc;">                  

                        <td max-height="30"><img src="ImageLoaderServlet?id=${product.item.id}&name='item'" class="card-img-top" alt="bicycle"></td>
                        <td align="left">${product.item.name}</td>
                        <td>${product.item.brand}</td>
                        <td><input style="width: 50px; text-align: center;" type="text" name="quantity[]" value="${product.quantity}" pattern="[0-9]" maxlength="2" required></td> 
                        <td>${product.item.cost}</td>                                               
                        <td>${product.item.stock}</td> 
                        <td>
                            <a href="${deleteLink}" 
                               onclick="if (!(confirm('Are you sure you want to delete this item?')))
                                           return false">Delete</a>
                        </td>                        
                    </tr>
                        
                        <!--values to pass-->
                        <input type="hidden" name="item_id[]" value="${product.item.id}">
                        <input type="hidden" name="cost[]" value="${product.item.cost}">
                        
                </c:forEach>
            </table>
                </div>
                <!--check out button div-->
                <div id="totalPrice" style="position:fixed; bottom:0; width:100%; align-content: center">
                    <input type="submit" value="Check out" class="btn btn-primary" id="submitBtn" style="width: 100%;"/>
                </div>
            </form>                  
           
        </div>
    </body>
</html>
