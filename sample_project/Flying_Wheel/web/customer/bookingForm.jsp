<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:if test="${not empty available}">
            <div class="row mt-5">
                <div class="col-md-6 m-auto">
                    <div class="card card-body">
                        <h1 class="text-center mb-3"><i class="fas fa-sign-in-alt"></i>Booking</h1>
                        <form action="CustomerControllerServlet" method="post">
                            <input type="hidden" name="command" value="ADD-BOOKING" />
                            <h5 class="card-title">Success! The number of bicycles You entered are available.</h5>
                            <p>Total Cost : ${cost} RM</p>
                            <button type="submit" class="btn btn-primary btn-lg">Book Bicycles</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${empty available}">
            <div class="row mt-5">
                <div class="col-md-6 m-auto">
                    <div class="card card-body">
                        <c:if test="${not empty fail}">
                            <div class="alert alert-dismissible alert-danger">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                <strong>${fail}</strong>
                            </div>  
                        </c:if>
                        <h1 class="text-center mb-3"><i class="fas fa-sign-in-alt"></i>Booking</h1>
                        <form action="CustomerControllerServlet" method="post">
                            <input type="hidden" name="command" value="CHECK-BOOKING" />
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="inputEmail4">Date-from</label>
                                    <input type="date" name="date-start" class="form-control" id="inputEmail4"
                                           placeholder="dd/mm/yyy">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputEmail4">Date-to</label>
                                    <input type="date" name="date-end" class="form-control" id="inputEmail4"
                                           placeholder="dd/mm/yyy">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputEmail4">Time-Taking</label>
                                    <input type="time" name="time-start" class="form-control" id="inputEmail4"
                                           placeholder="time">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputEmail4">Time-Return</label>
                                    <input type="time" name="time-end" class="form-control" id="inputEmail4" placeholder="time">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="inputEmail4">Number of Bicycles</label>
                                    <input type="text" name="number" class="form-control" id="inputEmail4" placeholder="e.g 4">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputState">type of bicycle</label>
                                    <select id="inputState" class="form-control" name="type">
                                        <option value="electrical">Electrical</option>
                                        <option value="road">Road</option>
                                        <option value="mountain">Mountain</option>
                                    </select>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary btn-lg">Check Availibility</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:if>
    </body>

</html>