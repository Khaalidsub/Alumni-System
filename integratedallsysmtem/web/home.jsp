<%-- 
    Document   : home
    Created on : Jan 12, 2021, 7:41:13 AM
    Author     : Muaz Amir
--%>

<%@page  language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v4.1.1">
        <title>Alumni FABU</title>

        <!-- Bootstrap core CSS -->
        <!--<link href="CSS/bootstrap.min.css" rel="stylesheet">-->
        <jsp:include page="bootstrap5.jsp" /> 
        <!--        <style>
                    .bd-placeholder-img {
                        font-size: 1.125rem;
                        text-anchor: middle;
                        -webkit-user-select: none;
                        -moz-user-select: none;
                        -ms-user-select: none;
                        user-select: none;
                    }
        
                    @media (min-width: 768px) {
                        .bd-placeholder-img-lg {
                            font-size: 3.5rem;
                        }
                    }
                </style>-->

        <!-- Custom styles for this template -->
        <link href="CSS/navbar-top-fixed.css" rel="stylesheet">
    </head>

    <body class="d-flex flex-column justify-content-between">

        <jsp:include page="headerNav.jsp" />    

        <main role="main" class=" container">


            <!-- Main jumbotron for a primary marketing message or call to action -->
            <div id="carouselExampleInterval"  class="carousel slide mb-5" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active" data-bs-interval="10000">
                        <img src="images/car_init.png" class="rounded mx-auto d-block w-75" alt="...">
                    </div>
                    <div class="carousel-item" data-bs-interval="2000">
                        <img src="images/car_building.jpg" class="rounded mx-auto d-block w-50" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="images/car_sunset.jpg" class="rounded mx-auto d-block w-50" alt="...">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </a>
            </div>

            <div class="row">
                <div class="col-md-12">

                    <div class="card shadow d-flex flex-column justify-content-start">
                        <div class="card-body text-center">
                           
                            <h2>Welcome to UTM Alumni FABU</h2>

                        </div>
                        <div class="d-flex flex-row justify-content-center m-5">
                            <div class="card mx-2" style="width: 18rem;">
                                <span class="badge bg-warning mb-3">Featured</span>
                                <img
                                    class="card-img-top w-25 rounded mx-auto d-block  "
                                    src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/vector-4@2x.svg"
                                    />
                                <div class="card-body">
                                    <h5 class="card-title">Alumni Name</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <a href="#" class="btn btn-primary">Profile</a>
                                </div>
                            </div>
                             <div class="card mx-2 " style="width: 18rem;">
                                 <span class="badge bg-warning mb-3">Featured</span>
                                <img
                                    class="card-img-top w-25 rounded mx-auto d-block  "
                                    src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/vector-4@2x.svg"
                                    />
                                <div class="card-body">
                                    <h5 class="card-title">Alumni Name</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <a href="#" class="btn btn-primary">Profile</a>
                                </div>
                            </div>
                             <div class="card mx-2" style="width: 18rem;">
                                 <span class="badge bg-warning mb-3">Featured</span>
                                <img
                                    class="card-img-top w-25 rounded mx-auto d-block  "
                                    src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/vector-4@2x.svg"
                                    />
                                <div class="card-body">
                                    <h5 class="card-title">Alumni Name</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <a href="#" class="btn btn-primary">Profile</a>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </main>

        <footer class="footer mt-auto py-3 bg-dark">

        </footer>

        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="js/popper.min.js"></script>      
        <script src="js/bootstrap.min.js"></script>
    </body>   
</html>
