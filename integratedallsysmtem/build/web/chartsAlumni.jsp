<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Charts - SB Admin</title>
        <link href="CSS/style.css" rel="stylesheet" />
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
<jsp:include page="headerNav.jsp" />    

        <main role="main" class="container">

            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item active" aria-current="page">Home</li>
                </ol>
            </nav>  
       
                <main>
                    <div class="container-fluid">
                    <div class="utm"><img src="pic/utm.png" width="600" height="200"> </div>
                    <h1 class="mt-4">Sekolah Senibina Skudai</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="reportHomeAlumni.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Charts</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                This page displayed graph that involved the alumni, sponsorship and event. For more information, do browse
                                <a target="_blank" href="https://builtsurvey.utm.my/">Faculty of Built Environment & Surveying</a>
                                .
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-chart-area mr-1"></i>
                                Qualified Architect
                            </div>
                            <div class="card-body"><canvas id="myAreaChart" width="100" height="30"></canvas></div>
                            <div class="card-footer small text-muted">Viewed on <?php echo date("H:i:sa") . " " .date("Y/m/d") ?></div>
                        </div>
                        
                            <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-chart-area mr-1"></i>
                                Qualified Architect
                            </div>
                            <div class="card-body"><canvas id="myPieChart" width="100" height="30"></canvas></div>
                            <div class="card-footer small text-muted">Viewed on <?php echo date("H:i:sa") . " " .date("Y/m/d") ?></div>
                        </div>
                       
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar mr-1"></i>
                                        Event Participation
                                    </div>
                                    <div class="card-body"><canvas id="eventStat" width="100" height="50"></canvas></div>
                                    <div class="card-footer small text-muted">Viewed on <?php echo date("H:i:sa") . " " .date("Y/m/d") ?></div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="card mb-4">
                                <div class="card-header">
                                    <i class="fas fa-chart-area mr-1"></i>
                                    Alumni Sponsorship Involvement
                                </div>
                                <div class="card-body"><canvas id="sponsor" width="100" height="50"></canvas></div>
                                <div class="card-footer small text-muted">Viewed on <?php echo date("H:i:sa") . " " .date("Y/m/d") ?></div>
                                </div>
                        </div>
                        
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
        <script src="scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="graph/alumni-event-involvment.js"></script>
        <script src="graph/qualified-architect.js"></script>
        <script src="graph/local-international.js"></script>
        <script src="graph/event-stat.js"></script>
        <script src="graph/sponsorship-involvement.js"></script>
    </body>
</html>
