<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Reporting Module</title>
        <link href="CSS/style.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
              <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="">
      <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
      <meta name="generator" content="Jekyll v4.1.1">
      <title>Alumni FABU</title>

      <!-- Bootstrap core CSS -->
      <link href="CSS/bootstrap.min.css" rel="stylesheet">

      <style>
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
      </style>

      <!-- Custom styles for this template -->
      <link href="css/navbar-top-fixed.css" rel="stylesheet">
    </head>
    <body class="sb-nav-fixed">

        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="reportingHomeAdmin.html">Report</a>
            <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle"><i class="fas fa-bars"></i></button>
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
            </form>

            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="adminHome.jsp">Homepage</a>
                        <a class="dropdown-item" href="logActivityAdmin.jsp">View Activity Log</a>
                        <a class="dropdown-item" href="insertLogActivity.html">Edit Activity Log</a>
                        <div class="dropdown-divider"></div>
                    </div>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="reportHomeAdmin.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>
                           <a class="nav-link" href="insertLogActivity.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Edit Log Activity
                            </a>
                            <div class="sb-sidenav-menu-heading">Addons</div>
                            <a class="nav-link" href="logActivityAdmin.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Log Activity
                            </a>
                            <a class="nav-link" href="chartsAdmin.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Charts
                            </a>
                             <a class="nav-link" href="sponsorAdmin.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Sponsor
                            </a>
                            
                            <a class="nav-link" href="eventAdmin.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Event
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                
                    <div class="container-fluid">
                    <div class="utm"><img src="pic/utm.png" width="600" height="200"> </div>
                    
                        <h1 class="mt-4">Sekolah Senibina Skudai</h1>
                        <ol class="breadcrumb mb-4">
                            <li>Edit Log Activity </li>
                        </ol>
                        
                         <form method="post" action="reportController">
                    <label>Please enter name:
                    <input name="name" placeholder="The name.." type="text" required/>
                    </label>
                    <br />
                    <br /> 
                    <label>Please Select Event Name:
                  <input type="radio" name="eventName" value="Cabaran Mahasiswa Norma Baharu">Cabaran Mahasiswa Norma Baharu
                  <input type="radio" name="eventName" value="Virtual Streaming Workshop">Virtual Streaming Workshop
                  <input type="radio" name="eventName" value="COMPFAIR21">COMPFAIR21
                    </label>
                    <br />
                    <br />
                     <label>Does he/she sponsor the event?

                  <input type="radio" name="sponsorship" value="Yes">Yes
                  <input type="radio" name="sponsorship" value="No" >No
                    
                    </label>
                    <br />
                    <br />
                     <label>Please enter Qualification
                  <input type="radio" name="qualified" value="Diploma">Diploma
                  <input type="radio" name="qualified" value="Degree">Degree
                  <input type="radio" name="qualified" value="Master">Master
                  <input type="radio" name="qualified" value="Phd">Phd
                    </label>
                    <br />
                    <br />
                     <label>Please enter Nationality
                        <input name="nationality" placeholder="The nationality.." type="text" required/>
                    </label>
                    <br />
                    <br />
                    <label>
                    <input type="submit" name="Submit" value="Submit" />
                    </label>            
                </form>
                      
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; All right and reserve belong to Team 1</div>
                            <div>
                                <a href="https://www.utm.my/privacy-policy/">Privacy Policy</a>
                                &middot;
                                <a href="https://people.utm.my/terms-conditions/">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="graph/qualified-architect.js"></script>
        <script src="graph/local-international.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/datatables-demo.js"></script>
    </body>
</html>

