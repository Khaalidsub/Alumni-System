<%-- 
    Document   : viewOrder
    Created on : Dec 6, 2019, 8:47:24 PM
    Author     : Bellarina C
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>View Order</title>
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
    
        <br>
        <br>
        <div class="container">
            <a href="ManagerControllerServlet?command=VIEW-ORDER" class="btn btn-primary">New Order</a>
            <a href="ManagerControllerServlet?command=PREPARED-ORDER" class="btn btn-primary">Prepared Order</a>
            <a href="ManagerControllerServlet?command=READY-ORDER" class="btn btn-primary">Ready Order</a>
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
                        <th scope="col" width="10%">Product</th>
                        <th scope="col" width="15%"></th>
                        <th scope="col" width="5%">Quantity</th>
                        <th scope="col" width="8%">Total Paid</th>
                        <th scope="col" width="12%">Status</th>                        
                        <th scope="col" width="10%">Action</th>
                    </tr>
                </thead>
            </table>
                <c:forEach var="customer" items="${CUSTOMERS}">
                    <div class="card" style="margin-bottom: 30px;">
                        
                        <div class="card-header" style="background-color: #78C2AD;">
                            <!--show username-->
                            <h3 style="color: white;">${customer.username}</h3>
                        </div>
                        
                        <div class="card-body">
                            <table class="table table-hover text-center">
                                
                                <c:forEach var="order" items="${ORDER_LIST}">    
                                    <!--only display the customer's order-->
                                    <c:if test="${order.user.email== customer.email}">
                                        <!--  set up a link to view order -->
                                        <c:url var="viewDetailLink" value="ManagerControllerServlet">
                                            <c:param name="command" value="ORDER-DETAIL" />
                                            <c:param name="order_id" value="${order.order_id}" />
                                        </c:url>


                                        <tr>                  
                                            <td max-height="30" width="10%"><img src="ImageLoaderServlet?id=${order.item.id}&name='item'" class="card-img-top" alt="bicycle"></td>
                                            <td align="left" width="19%">${order.item.name}</td>
                                            <td width="9%">${order.quantity}</td>
                                            <td width="10%">RM ${order.total_cost}</td>                                               
                                            <td width="15%">${order.status}</td> 
                                            <td width="10%"><a href="${viewDetailLink}">View</a></td>

                                        </tr>
                                    </c:if>                                    
                                </c:forEach>
                            </table>
                        </div>
                        
                    </div>
                    
                </c:forEach>
            </table>
        </div>
    </body>
</html>

