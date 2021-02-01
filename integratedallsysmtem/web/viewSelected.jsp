<%-- 
    Document   : viewFree
    Created on : Jan 25, 2021, 10:43:20 PM
    Author     : haisw
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Middleware.Event" %>

<%Event event = (Event)request.getAttribute("SELECTED_EVENT");%>
<%String r = (String)request.getAttribute("RESULT");%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= event.getEventName()%></title>
        <link rel="shortcut icon" href="image/utm.ico" />
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="headerNav.jsp" />
        
        <div class="container">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item active" aria-current="page">Home</li>
                </ol>
            </nav>  
            <div class="row">
                <div class="col">
                    <h1 class="val" value="<%= event.getEventID()%>"><%= event.getEventName()%></h1>
                    <hr>
                    <h5> Date: <%= event.getDate() %></h5>
                    <h5> Time: <%= event.getTime() %></h5>
                    <h5> Venue: <%= event.getVenue() %></h5>
                    <h5> Organizer: <%= event.getOrganizer()%></h5>
                    <h5> Fee: <%= event.getFee() %></h5>
                </div>
                
                <div class="col">
                    <% if(session.getAttribute("MESSAGE").equals("joined")){ %>
                        <button value="r" type="button" class="btn btn-info join" disabled>Joined</button>
                    <% }else if(session.getAttribute("MESSAGE").equals("join")){ %>
                        <button value="r" type="button" class="btn btn-info join">Join</button>
                    <% 
                        }
                    %>
                </div>
            
            
            
            </div>
            <hr>
            <h4>Funding Info</h4>

            <%  
                if(event.getFunding() != null){
            %>
                    <p><b>Name: </b><%= event.getFunding().getFundingnName()%> </p>
                    <p><b>Description:</b> <%= event.getFunding().getFundingnDesc()%> </p>

                    <button value="r" type="button" class="btn btn-info fund">Fund</button>

            <%  }else{

            %>
                    <p>Funding option is not available for this event</p> 
            <%
                }                 
            %>
            
           
            
        </div>
    <jsp:include page="footer.jsp" />  
        
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
                var eventName = $(".val").text();
                window.location.href = "makePayment.jsp?eventID="+eventID+"&eventName="+eventName;
//                if (confirm("Are you sure?")) {
//                    window.location.href = "JoinEventPage?event="+eventID;
//                } else {
//                  window.location.href = "JoinEventPage?event="+eventID;
//                }   
                
            });
        });
        
     
    </script>
    
</html>
