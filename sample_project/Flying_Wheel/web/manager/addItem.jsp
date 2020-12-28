<%-- 
    Document   : addItem
    Created on : Nov 5, 2019, 11:09:01 AM
    Author     : MEGAPRIMASOLUTIONS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


        <div class="row mt-5">
            <div class="col-md-6 m-auto">
                <div class="card card-body">
                    <h1 class="text-center mb-3"><i class="fas fa-sign-in-alt"></i> Add Item</h1>
                    <c:if test="${not empty fail}">
                        <div class="alert alert-dismissible alert-danger">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>${fail}</strong>
                        </div>  
                    </c:if>
                    <form action="ManagerControllerServlet" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="command" value="ADD-ITEM" />
                        <div class="form-group">
                            <label for="Name">Item's name</label>
                            <input type="Name" id="Name" name="name" class="form-control" placeholder="Enter Item's Name" />
                        </div>
                        <div class="form-group">
                            <label for="Brand">brand</label>
                            <input type="brand" id="brand" name="brand" class="form-control" placeholder="Enter Brand" />
                        </div>                        
                        <div class="form-group">
                            <label for="Image">Image</label>
                            <input type="file" name="image" id="image" class="form-control" accept="image/*"/>
                        </div>
                        <div class="form-group">
                            <label for="cost">Cost</label>
                            <input type="number" id="cost" name="cost" class="form-control" placeholder="Enter Cost" />
                        </div>
                        <div class="form-group">
                            <label for="stock">Stock</label>
                            <input type="number" id="stock" name="stock" class="form-control" placeholder="Enter stock" />
                        </div>
                        <button type="submit" class="btn btn-primary btn-lg">Add</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
