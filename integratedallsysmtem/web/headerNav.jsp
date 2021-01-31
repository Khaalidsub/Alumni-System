<%-- 
    Document   : headerNav
    Created on : Jan 26, 2021, 12:17:11 PM
    Author     : SleepingLotus
--%>

 <script src="https://kit.fontawesome.com/43d73fdaf8.js" crossorigin="anonymous"></script>

 <nav class="navbar  navbar-expand-md navbar-dark fixed-top bg-dark">

            <div class="container">

                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="home.jsp">Home</a>
                    </li>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="AlumniController?command=MY-PROFILE">MyProfile</a>
                    </li>
                    <li class="nav-item active">
                         <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                              Events
                            </a>
                            <div class="dropdown-menu">
                              <a class="dropdown-item" href="EventController?action=view">Upcoming Events</a>
                              <a class="dropdown-item" href="EventController?action=joinedEvents">Your Events</a>
                              <a class="dropdown-item" href="PaymentController?action=fundingList">Funding History</a>
                            </div>
                          </li>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="reportHomeUser.jsp">Report</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="AlumniController?command=ALUMNI-SEARCH">Connect</a>
                    </li>
                </ul>
                

                <ul class="navbar-nav">
                    <li class="nav-item active"></li>
                        <a class="nav-link" href="AnnouncementController?"><div class="icon_wrap"><i class="far fa-bell"></i></div></a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="h#" id="dropdown07" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${signIn.getName()}</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown07">
                            <a class="dropdown-item" href="AlumniController?command=MY-PROFILE">Profile</a>
                            <a class="dropdown-item" href="LogoutController">Logout</a>
                        </div>
                    </li>                  
                </ul>
            </div>

        </nav>     