<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin Dashboard</title>
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
                        <a class="nav-link" href="AdminControllerServlet">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminControllerServlet?command=VIEW-MANAGER">Managers</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminControllerServlet?command=VIEW-MEMBER">Members</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminControllerServlet?command=VIEW-BICYCLE">Bicycles</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminControllerServlet?command=VIEW-ITEM">Items</a>
                    </li>
                     <li class="nav-item">
                        <a class="nav-link" href="AdminControllerServlet?command=VIEW-FINANCIAL-REPORT">Financial Report</a>
                    </li>
                </ul>

                <form action="AdminControllerServlet" method="GET">
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
                        <h5 class="card-title">Bicycle Managers</h5>
                        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                        <a href="AdminControllerServlet?command=VIEW-MANAGER" class="btn btn-primary">View</a>
                        <a href="AdminControllerServlet?command=ADD-MANAGER" class="btn btn-primary">Add</a>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Members</h5>
                        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                        <a href="AdminControllerServlet?command=VIEW-MEMBER" class="btn btn-primary">View</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row text-center padding" style="padding-top: 5%;">
            <div class="col-xs-12 col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Bicycles</h5>
                        <p class="card-text">With supporting text below as a natural lead-in to additional content.
                        </p>
                        <a href="AdminControllerServlet?command=VIEW-BICYCLE" class="btn btn-primary">View</a>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Items</h5>
                        <p class="card-text">With supporting text below as a natural lead-in to additional content.
                        </p>
                        <a href="AdminControllerServlet?command=VIEW-ITEM" class="btn btn-primary">View</a>
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
                    <h3 class="display4">Members</h3>
               
                    <p class="lead">${customers}</p>
                    <hr>
                </div>
                <div class="col-xs-12 col-md-6">
                    <h3 class="display4">Bicycle Managers</h3>
           
                    <p class="lead">${managers}</p>
                    <hr>
                </div>
                <div class="col-xs-12 col-md-6">
                    <h3 class="display4">Bicycles for rent</h3>
        
                    <p class="lead">${bicycles}</p>
                    <hr>
                </div>
                <div class="col-xs-12 col-md-6">
                    <h3 class="display4">Items for Sale</h3>
             
                    <p class="lead">${items}</p>
                    <hr>
                </div>
            </div>
        </div>

</body>

</html>


