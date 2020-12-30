<!DOCTYPE html>
<html lang="en">

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
        <link href="/css/style.css" rel="stylesheet">
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
        <!--display links for functions-->
        <br>
        <br>
        <div class="container-fluid padding">
            <div class="row text-center padding">
                <div class="col-xs-12 col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Bookings</h5>
                            <p class="card-text">Displays all Bookings from the user.</p>
                            <a href="ManagerControllerServlet?command=VIEW-BOOKING" class="btn btn-primary">View</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Ordered items</h5>
                            <p class="card-text">Displays All Ordered Items.</p>
                            <a href="ManagerControllerServlet?command=VIEW-ORDER" class="btn btn-primary">View</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row text-center padding" style="padding-top: 5%;">
                <div class="col-xs-12 col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Bicycles</h5>
                            <p class="card-text">Display All added Bicycles for booking Or add More Bicycles for booking
                            </p>
                            <a href="ManagerControllerServlet?command=VIEW-BICYCLE" class="btn btn-primary">View</a>
                            <a href="ManagerControllerServlet?command=ADD-BICYCLE" class="btn btn-primary">Add</a>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Items</h5>
                            <p class="card-text">Display All added items Or add More items in the shop
                            </p>
                            <a href="ManagerControllerServlet?command=VIEW-ITEM" class="btn btn-primary">View</a>
                            <a href="ManagerControllerServlet?command=ADD-ITEM" class="btn btn-primary">Add</a>
                        </div>
                    </div>
                </div>
            </div>


            <!--data dispay report-->

            <br>
            <br>
            <!--- number of users and stuff -->
            <div class="container-fluid padding">
                <div class="row welcome text-center">
                    <div class="col-xs-12 col-md-6">
                        <h1 class="display4">Bookings : ${bookings}</h1>
                        <hr>


                    </div>
                    <div class="col-xs-12 col-md-6">
                        <h1 class="display4">Ordered Items : ${orders} </h1>
                        <hr>


                    </div>
                    <div class="col-xs-12 col-md-6">
                        <h1 class="display4">Bicycles : ${bicycles}</h1>
                        <hr>


                    </div>
                    <div class="col-xs-12 col-md-6">
                        <h1 class="display4">Items : ${items}</h1>
                        <hr>

                    </div>
                </div>
            </div>

    </body>

</html>