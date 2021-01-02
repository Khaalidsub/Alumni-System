<%-- 
    Document   : alumniHome
    Created on : 02-Jan-2021, 17:45:05
    Author     : haisw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
       <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        
        <style>
        h3{
            margin: 10px;
        }
        
        .clock{
            text-shadow: 0.2px 0.2px;
            margin: 20px 0 24px 0;
            padding: 12px;
            border-radius: 25px;
            background-clip: border-box;
            height:100%;
        }
        
        
        .row two{
          
          display: block;
          margin-left: auto;
          margin-right: auto;
          width: 100%;
         
        }
        
        .btn{
            background-color: #62c1cd;
            border: none;
            color: white;
            padding: 12px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            width: 100%;
            height:100%;
            font-size: 20px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            margin-bottom: 30px;
         
        }
        
        body {
          
            background-color: #f5f5f5;
           
        }
        
        .card{
            background-color: rgb(43, 44, 49);
            color: cornsilk;
            margin: 20px 0 24px 0;
            padding: 12px;
            width:100%;
            height:100%;
        }
        
          
        .notification .badge {
            
            top: -10px;
            right: -10px;
            padding: 5px 10px;
            border-radius: 50%;
            background: red;
            color: white;
          }
        
        .col-xl-8{
            height: 100%;
            width: 100%;
        }
        
        b{
            margin: 0 20px;
        }
        
        hr{
            margin: 0;
        }
        
        footer {
            padding-top: 10px;
            padding-bottom: 10px;
            background-color:white;
            margin-top: 40px;
        }
          
        footer p {
            margin-bottom: .25rem;
        }
        
        .img{
            text-align: center
        }
        
        .img img{
            width: 200px;
        
        }
        
        .sidebar-header img{
            width: 70px;   
            display:block;
            margin:auto;
            padding: auto;
        
        }
        
        
        
        body {
            font-family: 'Poppins', sans-serif;
            background: #fafafa;
        }
        
        p {
            font-family: 'Poppins', sans-serif;
            font-size: 1.1em;
            font-weight: 300;
            line-height: 1.7em;
            color: #999;
        }
        
        a, a:hover, a:focus {
            color: inherit;
            text-decoration: none;
            transition: all 0.3s;
        }
        
        .navbar {
            padding: 15px 10px;
            background: #fff;
            border: none;
            border-radius: 0;
            margin-bottom: 30px;
            box-shadow: 0 4px 6px 0 rgba(0, 0, 0, 0.2), 0 6px 10px 0 rgba(0, 0, 0, 0.19);
        }
        
        .navbar-btn {
            box-shadow: none;
            outline: none !important;
            border: none;
        }
        
        .line {
            width: 100%;
            height: 1px;
            border-bottom: 1px dashed #ddd;
            margin: 40px 0;
        }
        
        /* ---------------------------------------------------
            SIDEBAR STYLE
        ----------------------------------------------------- */
        
        .wrapper {
            display: flex;
            width: 100%;
            align-items: stretch;
            perspective: 1500px;
        }
        
        
        #sidebar {
            min-width: 250px;
            max-width: 250px;
            background: rgb(43, 44, 49);
            color: #fff;
            transition: all 0.6s cubic-bezier(0.945, 0.020, 0.270, 0.665);
            transform-origin: bottom left;
        }
        
        #sidebar.active {
            margin-left: -250px;
            transform: rotateY(100deg);
        }
        
        #sidebar .sidebar-header {
            padding: 20px;
            background: rgb(43, 44, 49);
        }
        
        #sidebar ul.components {
            padding: 20px 0;
            border-bottom: 1px solid #62c1cd;
        }
        
        #sidebar ul p {
            color: #fff;
            padding: 10px;
        }
        
        #sidebar ul li a {
            padding: 10px;
            font-size: 1.1em;
            display: block;
        }
        #sidebar ul li a:hover {
            color: #62c1cd;
            background: #fff;
        }
        
        #sidebar ul li.active > a, a[aria-expanded="true"] {
            color: #fff;
            background: #62c1cd;
        }
        
        
        a[data-toggle="collapse"] {
            position: relative;
        }
        
        .dropdown-toggle::after {
            display: block;
            position: absolute;
            top: 50%;
            right: 20px;
            transform: translateY(-50%);
        }
        
        ul ul a {
            font-size: 0.9em !important;
            padding-left: 30px !important;
            background: rgb(43, 44, 49);
        }
        
        ul.CTAs {
            padding: 20px;
        }
        
        ul.CTAs a {
            text-align: center;
            font-size: 0.9em !important;
            display: block;
            border-radius: 5px;
            margin-bottom: 5px;
        }
        
        a.logout {
            margin-top:150px;
            background: #62c1cd;
            color: #fff;
        }
        
        a.article, a.article:hover {
            background: rgb(43, 44, 49) !important;
            color: #fff !important;
        }
        
        
        
        /* ---------------------------------------------------
            CONTENT STYLE
        ----------------------------------------------------- */
        #content {
            width: 100%;
            padding: 20px;
            min-height: 100vh;
            transition: all 0.3s;
        }
        
        #sidebarCollapse {
            width: 40px;
            height: 40px;
            background:rgb(43, 44, 49);
            cursor: pointer;
        }
        
        #sidebarCollapse span {
            width: 80%;
            height: 2px;
            margin: 0 auto;
            display: block;
            background: #fff;
            transition: all 0.8s cubic-bezier(0.810, -0.330, 0.345, 1.375);
            transition-delay: 0.2s;
        }
        
        #sidebarCollapse span:first-of-type {
            transform: rotate(45deg) translate(2px, 2px);
        }
        #sidebarCollapse span:nth-of-type(2) {
            opacity: 0;
        }
        #sidebarCollapse span:last-of-type {
            transform: rotate(-45deg) translate(1px, -1px);
        }
        
        
        #sidebarCollapse.active span {
            transform: none;
            opacity: 1;
            margin: 5px auto;
        }
        
        
        /* ---------------------------------------------------
            MEDIAQUERIES
        ----------------------------------------------------- */
        @media (max-width: 768px) {
            #sidebar {
                margin-left: -250px;
                transform: rotateY(90deg);
                position:fixed;
                 z-index: 1;
            }
            #sidebar.active {
                margin-left: 0;
                transform: none;
            }
            #sidebarCollapse span:first-of-type,
            #sidebarCollapse span:nth-of-type(2),
            #sidebarCollapse span:last-of-type {
                transform: none;
                opacity: 1;
                margin: 5px auto;
            }
            #sidebarCollapse.active span {
                margin: 0 auto;
            }
            #sidebarCollapse.active span:first-of-type {
                transform: rotate(45deg) translate(2px, 2px);
            }
            #sidebarCollapse.active span:nth-of-type(2) {
                opacity: 0;
            }
            #sidebarCollapse.active span:last-of-type {
                transform: rotate(-45deg) translate(1px, -1px);
            }
        
        }


    </style>

    </head>
    <body>
        
    <div class="wrapper">
        <!-- Sidebar Holder -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h1>Alumini</h1>
            </div>

            <ul class="list-unstyled components">
                <li class="active">
                    <a href="#homeSubmenu">Dashboard</a>
                </li>
                <li>
                    <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Actions</a>
                    <ul class="collapse list-unstyled" id="pageSubmenu">
                        <li>
                            <a href="uploadNewsPage.php">Upload News</a>
                        </li>
                        <li>
                            <a href="travelHistory.php">User Travel History</a>
                        </li>
                        <li>
                            <a href="#">Red Flagge Areas</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">Profile</a>
                </li>
                <li>
                    <a href="#">Help</a>
                </li>
            </ul>

            <ul class="list-unstyled CTAs">
                <li>
                    
                    <a class="logout" href="logoutAdmin.php">Sign Out <i class="fas fa-sign-out-alt"></i></a>
                </li>
            </ul>
        </nav>

        <!-- Page Content Holder -->
        <div id="content">

            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">

                    <button type="button" id="sidebarCollapse" class="navbar-btn">
                        <span></span>
                        <span></span>
                        <span></span>
                    </button>
                    <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-align-justify"></i>
                    </button>
                    <div class="title">
                        <ul class="nav navbar-nav ml-auto">
                            <li class="nav-item active">
                                <a class="nav-link" style="display: none;" href="#">Covid-19 Tracker</a>
                            </li>
                        </ul>
                    </div>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="nav navbar-nav ml-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="homePage.php">Dashboard</a>
                            </li>
                            <li class="nav-item">
                                 <a class="nav-link" data-toggle="tooltip" title="Sign Out"href="logoutAdmin.php"><i class="fas fa-sign-out-alt"></i></a>
                            </li>
                         
                        </ul>
                    </div>
                </div>
            </nav>
            
          
            <div class="container">
                <hr>
                <h3>Actions</h3>   

                <div class="row">
                 
                    <div class="col">
                        <a href="ViewEvent" ><button type="button" class="btn btn-primary">Events</button></a>
          
            
                    </div>
                      
                    <div class="col">  
                        <a href="alumniHome.jsp" ><button type="button" class="btn btn-primary"> Make Payment</button></a>
                    </div>
                
                    <div class="col">
                        <button type="button" class="btn btn-primary"><a href="alumniHome.jsp" >Announcements</a></button>
                        
                    </div>
                  
                    
                </div>
            

            </div>
        
          


      
        </div>
    </div>
    <!-- /#page-content-wrapper -->



    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
                $(this).toggleClass('active');
                $('.title').css("display", "");
            });
        });
    </script>
</body>

</html>
