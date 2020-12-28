<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

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

        <!-- display profile --->
        <!--name-->
        <div class="container padding" style="padding-top: 2.5%">
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
            <div class="row padding" style="">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex justify-content-between">

                                <h5 class="display4">Welcome ${user.username}</h5>
                                <button id="{{@index}}" name="button1" type="button" class="viewapp btn btn-secondary"
                                        data-toggle="modal" data-target="#myModal">Edit Profile</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--details-->
            <br>
            <br>
            <div class="row padding" style="">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header"><h5>User Profile</h5></div>
                        <div class="card-body">
                            <div class="d-flex justify-content-between text-center">
                                <p class="display4">Name :<br> ${user.username} </p>
                                <p class="display4">Phone :<br>${user.phone} </p>
                                <p class="display4">  Email :<br>${user.email} </p>
                            </div>
                            <div class="d-flex justify-content-between text-center">
                                <p class="display4">IC   :<br>${user.IC} </p>
                                <p class="display4">Date of Birth :<br>${user.DOB} </p>
                                <p class="display4">Balance :<br> ${balance} RM</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>




        <div class="container">
            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog" >
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <h2 class="modal-title">${user.username} Information</h2>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="CustomerControllerServlet" method="post">
                                <input type="hidden" name="command" value="EDIT-PROFILE" />
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input
                                        type="email"
                                        id="email"
                                        name="email"
                                        class="form-control"
                                        placeholder="Enter Email" required
                                        value=${user.email}
                                        />  
                                </div>

                                <div class="form-group">
                                    <label for="Type">Phone</label>
                                    <input
                                        type="phone"
                                        id="phone"
                                        name="phone"
                                        class="form-control"
                                        placeholder="Enter Phone number" required
                                        value=${user.phone}
                                        />
                                </div>
                                <button type="submit" class="btn btn-primary">Update</button>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            </form>
                        </div>


                    </div>

                </div>
            </div>
        </div>


        <!--display links for functions-->
        <br>
        <br>
        <div class="container padding">
            <div class="row text-center padding">
                <div class="col-xs-12 col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Booking</h5>
                            <p class="card-text">Here you can see the bookings you have made or you can add  a booking</p>
                            <a href="CustomerControllerServlet?command=VIEW-BOOKING" class="btn btn-primary">View</a>
                            <a href="CustomerControllerServlet?command=ADD-BOOKING" class="btn btn-primary">Book</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Shop</h5>
                            <p class="card-text">Browse our Items!</p>
                            <a href="CustomerControllerServlet?command=VIEW-SHOP" class="btn btn-primary">View</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Cart</h5>
                            <p class="card-text">View your items that you have added in your cart!</p>
                            <a href="CustomerControllerServlet?command=VIEW-CART" class="btn btn-primary">View</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Order</h5>
                            <p class="card-text">Check your ordered items if they have arrived!</p>
                            <a href="CustomerControllerServlet?command=VIEW-ORDER" class="btn btn-primary">View</a>
                        </div>
                    </div>
                </div>
                <br/>
                  <div class="col-xs-12 col-md-12">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Top up</h5>
                            <p class="card-text">View your top up transaction History</p>
                            <a href="CustomerControllerServlet?command=VIEW-TRANSACTION" class="btn btn-primary">View</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>

</html>


