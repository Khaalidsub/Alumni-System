<%-- 
    Document   : selectAnnouncement
    Created on : Feb 1, 2021, 7:30:51 AM
    Author     : haisw
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Middleware.Announcement" %>


<%Announcement announcement = (Announcement)request.getAttribute("SELECTED_ANNOUNCEMENT");%>
<%String r = (String)request.getAttribute("RESULT");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= announcement.getAnnouncementName()%></title>
        <link rel="shortcut icon" href="image/utm.ico" />
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        
        <style>
          
            .table-row{
                cursor:pointer;
            }
            
            
/*            .container{
                margin-top: 10px;
            }*/

            .body{
                padding: 0 10px;
            }
            
            .title{
                padding: 20px 0;
            }
            
            .footer {
                margin-top: 20px;
                position: fixed;
                left: 0;
                bottom: 0;
                width: 100%;
                text-align: center;
                margin-top: 20px;
              }
              
       
              
            .table{
                border-radius: 5px;
                box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.1), 0 3px 6px 0 rgba(0, 0, 0, 0.19);
            }
            
            .a{
                box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.19), 0 6px 10px 0 rgba(0, 0, 0, 0.19);
                padding: 30px 60px;
                border-radius: 5px;
                width: 60%;
                margin-top: 20px;
                
            }
            
            hr{
                
                border-top: 2px solid black;

            }
            
            

            
            
         
        </style>    
        
    </head>
    <body>
        <jsp:include page="headerNav.jsp" />
        
        <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item active" aria-current="page">Home</li>
                </ol>
        </nav>  
        
        <div class="container a">
            
            <div class="row">
                <div class="col">
                    <h1 class="val" value="<%= announcement.getAnnouncementID() %>"><%= announcement.getAnnouncementName() %></h1>
                    <hr class="first">
                    <p>  <%= announcement.getDescription() %></p>

                    
                </div>
            </div>  
                <br>
                
    
        
    </body>
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.js"></script>
    
    <script type="text/javascript">
    
        $(document).ready(function($) {
            $(".join").click(function() {
                
                var eventID = $(".val").attr('value');
                window.location.href = "EventController?action=join&eventID="+eventID;
//                if (confirm("Are you sure?")) {
//                    window.location.href = "JoinEventPage?event="+eventID;
//                } else {
//                  window.location.href = "JoinEventPage?event="+eventID;
//                }   
                
            });
        });
        
         $(document).ready(function($) {
            $(".fund").click(function() {
                
                var eventID = $(".val").attr('value');
                window.location.href = "makePayment.jsp?eventID="+eventID;
//                if (confirm("Are you sure?")) {
//                    window.location.href = "JoinEventPage?event="+eventID;
//                } else {
//                  window.location.href = "JoinEventPage?event="+eventID;
//                }   
                
            });
        });
        
     
    </script>
    
</html>
