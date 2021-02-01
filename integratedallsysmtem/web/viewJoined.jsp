<%-- 
    Document   : viewJoined
    Created on : Jan 25, 2021, 6:20:27 PM
    Author     : haisw
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Middleware.Event" %>
<%@page import="Business.EventController" %>

<% Event event = (Event)request.getAttribute("JOINED_EVENT");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= event.getEventName()%></title>
        <link rel="shortcut icon" href="image/utm.ico" />
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        
        
        <style>
 
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
                    <h1 class="val" value="<%= event.getEventID()%>"><%= event.getEventName()%></h1>
                    <hr>
                    <h5> Date: <%= event.getDate() %></h5>
                    <h5> Time: <%= event.getTime() %></h5>
                    <h5> Venue: <%= event.getVenue() %></h5>
                    <h5> Organizer: <%= event.getOrganizer()%></h5>
                    <h5> Fee: <%= event.getFee() %></h5>
                </div>
            </div>
           
            

            
            
            <%  
                if(event.getFunding() != null && event.getFee().equals("Free")){
            %>
                    <hr>
                    <br>
                    <h5>Funding Info</h5>
                    <p><b>Name: </b><%= event.getFunding().getFundingnName()%> </p>
                    <p><b>Description:</b> <%= event.getFunding().getFundingnDesc()%> </p>
                    <button value="r" type="button" class="btn btn-warning">Fund</button>

            <%  }else if(event.getFunding() == null && !(event.getFee().equals("Free")) ){

            %>
                    <br>
                    <button value="r" type="button" class="btn btn-warning">Pay </button>
                        
            <%
                }else if(event.getFunding() != null && !(event.getFee().equals("Free")) ){             
            %>
                    <hr>
                    <h5>Funding Info</h5>
                    <p><b>Name: </b><%= event.getFunding().getFundingnName()%> </p>
                    <p><b>Description:</b> <%= event.getFunding().getFundingnDesc()%> </p>
                    <hr>
                    <br>
                    <button value="r" type="button" class="btn btn-warning">Pay/Fund</button>
            
            <%  
                }
            %>
                    
            
          
        </div>
        
        
        
        
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.js"></script>
    
    <script type="text/javascript">
    

        
         $(document).ready(function($) {
            $(".btn").click(function() {
                
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
