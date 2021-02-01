<%-- 
    Document   : adminHeaderNav
    Created on : Jan 26, 2021, 12:46:22 PM
    Author     : SleepingLotus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
     <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

         <div class="container">
         
               <ul class="navbar-nav mr-auto">
                  <li class="nav-item active">
                    <a class="nav-link" href="adminHome.jsp">Home</a>
                  </li>
                   <li class="nav-item active">
                         <li class="nav-item dropdown">
                             <a class="nav-link dropdown-toggle" type="button" data-bs-toggle="dropdown" id="navbardrop" data-toggle="dropdown">
                              Report
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbardrop">
                              <a class="dropdown-item" href="chartsAdmin.jsp">Charts</a>
                              <a class="dropdown-item" href="eventAdmin.jsp">Event</a>
                              <a class="dropdown-item" href="sponsorAdmin.jsp">Sponsor</a>
                              <a class="dropdown-item" href="logActivityAdmin.jsp">Log Activity</a>
                              <a class="dropdown-item" href="insertLogActivity.jsp">Edit Log Activity</a>
                            </div>
                          </li>
                    </li>
                  <li class="nav-item active">
                    <a class="nav-link" href="manageAlumni.jsp">Manage Alumni</a>
                  </li>
                    <li class="nav-item active">
                    <a class="nav-link" href="AlumniController?command=ALUMNI-SEARCH">Connect With Alumni</a>
                  </li>
                  
               </ul>

               <ul class="navbar-nav">
                  
                  <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle"  type="button"  id="dropdown07" data-bs-toggle="dropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${admin.getAdminName()}</a>
                        <div class="dropdown-menu dropdown-toggle" aria-labelledby="dropdown07">
                            <a class="dropdown-item" href="LogoutController">Logout</a>
                        </div>
                    </li>                   
               </ul>
            </div>
            
      </nav>    