<%-- 
    Document   : viewEvent
    Created on : Jan 1, 2021, 12:18:37 PM
    Author     : mrhr10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Application.ViewEvent" %>
<%@page import="java.util.*" %>
<%@page import="Middleware.Event" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of Events</h1>
        
        <table border="1">
          <tr>
            <th>Index</th>
            <th>Name</th>
            <th>Date</th>
            <th>Venue</th>
            <th>Organiser</th>
          </tr>
            
          <%            
             int index = 0;
             int eventList = 1;
             
             List<Event> events = new ArrayList<Event>();
             events = request.getAttribute("EVENT_LIST");
             
             out.println(event);
                       
          %>
            
          
        </table>     
       

        
        <% 
        
        %>
        
    </body>
</html>
