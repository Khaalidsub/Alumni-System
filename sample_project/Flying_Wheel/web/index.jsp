<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Home</title>
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
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary sticky-top">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">Flying-Wheel</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01"
                        aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarColor01">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="LoginControllerServlet">Login</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="CustomerControllerServlet?command=REGISTER">Register</a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
        <!--- Image Slider -->
        <div id="slides" class="carousel slide" data-ride="carousel">
            <ul class="carousel-indicators">
                <li data-target="#slides" data-slide-to="0" class="active"></li>
                <li data-target="#slides" data-slide-to="1"></li>
                <li data-target="#slides" data-slide-to="2"></li>
            </ul>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div class="banner" style="background-image: url(images/back1.jpg);">
                        <div class="carousel-caption ">
                            <h1 class="display-2 text-white">Flying Wheel</h1>
                            <h3 class="text-white">We sell and rent Bicycles</h3>
                            <a href="LoginControllerServlet"><button type="button" class="btn btn-outline-light btn-lg">Login</button></a>
                            <a href="CustomerControllerServlet?command=REGISTER"><button type="button"  class="btn btn-primary btn-lg">Register Now!</button></a>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="banner" style="background-image: url(images/back2.jpg);">
                        <div class="carousel-caption ">
                            <h1 class="display-2 text-white">Flying Wheel</h1>
                            <h3 class="text-white">We sell and rent Bicycles</h3>
                            <a href="LoginControllerServlet"><button type="button" class="btn btn-outline-light btn-lg">Login</button></a>
                            <a href="CustomerControllerServlet?command=REGISTER"><button type="button"  class="btn btn-primary btn-lg">Register Now!</button></a>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="banner" style="background-image: url(images/back3.jpg);">
                        <div class="carousel-caption ">
                            <h1 class="display-2 text-white">Flying Wheel</h1>
                            <h3 class="text-white">We sell and rent Bicycles</h3>
                            <a href="LoginControllerServlet"><button type="button" class="btn btn-outline-light btn-lg">Login</button></a>
                            <a href="CustomerControllerServlet?command=REGISTER"><button type="button"  class="btn btn-primary btn-lg">Register Now!</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <hr class="my-4">

        <!--- Meet the team -->
        <div class="container-fluid padding">
            <div class="row welcome text-center">
                <div class="col-12">
                    <h1 class="disaply-4">Meet the Team</h1>
                </div>
                <hr>
            </div>
        </div>
        <!--- Cards -->
        <div class="container-fluid padding">
            <div class="row" padding>
                <div class="col-md-6">
                    <div class="card">
                        <img class="card-img-top" src="img/team1.png" alt="">
                        <div class="card-body">
                            <h4 class="card-title">Khaalid Subaan</h4>
                            <p class="card-text">Lorem ipsum dolor sit amet consectetur adipisicing elit. Nam vero similique
                                nihil quisquam debitis amet atque. Vel, tenetur sequi quae nesciunt labore dignissimos atque
                                reprehenderit fuga eos, illum voluptas veritatis.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card">
                        <img class="card-img-top" src="img/team2.png" alt="">
                        <div class="card-body">
                            <h4 class="card-title">Mohammad Mohsin</h4>
                            <p class="card-text">Lorem ipsum dolor sit amet consectetur adipisicing elit. Nam vero similique
                                nihil quisquam debitis amet atque. Vel, tenetur sequi quae nesciunt labore dignissimos atque
                                reprehenderit fuga eos, illum voluptas veritatis.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card">
                        <img class="card-img-top" src="img/team3.png" alt="">
                        <div class="card-body">
                            <h4 class="card-title">Bellarina</h4>
                            <p class="card-text">Lorem ipsum dolor sit amet consectetur adipisicing elit. Nam vero similique
                                nihil quisquam debitis amet atque. Vel, tenetur sequi quae nesciunt labore dignissimos atque
                                reprehenderit fuga eos, illum voluptas veritatis.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card">
                        <img class="card-img-top" src="img/team3.png" alt="">
                        <div class="card-body">
                            <h4 class="card-title">Nadhiful</h4>
                            <p class="card-text">Lorem ipsum dolor sit amet consectetur adipisicing elit. Nam vero similique
                                nihil quisquam debitis amet atque. Vel, tenetur sequi quae nesciunt labore dignissimos atque
                                reprehenderit fuga eos, illum voluptas veritatis.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

     

        <hr class="my-4">
        <!--- Connect -->
        <div class="container-fluid">
            <div class="row text-center padding">
                <div class="col-12">
                    <h2>Connect</h2>
                </div>
                <div class="col-12 social padding">
                    <a href="#"><i class="fab fa-facebook"></i></a>
                    <a href="#"><i class="fab fa-twitter"></i></a>
                    <a href="#"><i class="fab fa-google-plus-g"></i></a>
                    <a href="#"><i class="fab fa-instagram"></i></a>
                    <a href="#"><i class="fab fa-youtube"></i></a>
                </div>
            </div>
        </div>


    </body>
</html>



