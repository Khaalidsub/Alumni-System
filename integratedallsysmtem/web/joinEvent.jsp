<%-- 
    Document   : joinEvent
    Created on : Jan 21, 2021, 12:58:20 AM
    Author     : haisw
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Middleware.Event" %>

<%Event event = (Event)request.getAttribute("EVENT");%>
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
        <h1 class="val" value="<%= event.getEventID()%>"><%= event.getEventName()%></h1>
        
        
        <button value="r" type="button" class="btn btn-info">Join</button>
        
    </body>
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.js"></script>
    
    <script type="text/javascript">
    
        $(document).ready(function($) {
            $(".btn-info").click(function() {
                
                var eventID = $(".val").attr('value');
                window.location.href = "EventController?action=join&eventID="+eventID;
//                if (confirm("Are you sure?")) {
//                    window.location.href = "JoinEventPage?event="+eventID;
//                } else {
//                  window.location.href = "JoinEventPage?event="+eventID;
//                }   
                
            });
        });
        
        $(document).ready(function(){
            
            var r = $(".btn-info").attr("value");
            
            if(r === "joined"){
                $(".btn-info").attr("class", "btn btn-info");
                
            }    
        });
    </script>
    
</html>
