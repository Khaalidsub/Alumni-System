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
                             <a class="nav-link dropdown-toggle" type="button" data-bs-toggle="dropdown" id="navbardrop" data-toggle="dropdown">
                              Events
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbardrop">
                              <a class="dropdown-item" href="EventController?action=view">Upcoming Events</a>
                              <a class="dropdown-item" href="EventController?action=joinedEvents">Your Events</a>
                              <a class="dropdown-item" href="PaymentController?action=fundingList">Funding History</a>
                            </div>
                          </li>
                    </li>
                    <li class="nav-item active">
                         <li class="nav-item dropdown">
                             <a class="nav-link dropdown-toggle" type="button" data-bs-toggle="dropdown" id="navbardrop" data-toggle="dropdown">
                              Report
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbardrop">
                              <a class="dropdown-item" href="chartsAlumni.jsp">Charts</a>
                              <a class="dropdown-item" href="eventAlumni.jsp">Event</a>
                              <a class="dropdown-item" href="sponsorAlumni.jsp">Sponsor</a>
                              <a class="dropdown-item" href="logActivityAlumni.jsp">Log Activity</a>
                            </div>
                          </li>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="AlumniController?command=ALUMNI-SEARCH">Connect</a>
                    </li>
                </ul>
                

                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="AnnouncementController?command=announcementList" data-toggle="tooltip" title="Announcements"><div class="icon_wrap"><i class="fas fa-bullhorn"></i></div></a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle"  type="button"  id="dropdown07" data-bs-toggle="dropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${signIn.getName()}</a>
                        <div class="dropdown-menu dropdown-toggle" aria-labelledby="dropdown07">
                            <a class="dropdown-item" href="AlumniController?command=MY-PROFILE">Profile</a>
                            <a class="dropdown-item" href="LogoutController">Logout</a>
                        </div>
                    </li>                  
                </ul>
            </div>

        </nav>     