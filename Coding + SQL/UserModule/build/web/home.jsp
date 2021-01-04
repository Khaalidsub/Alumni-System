<%-- 
    Document   : home
    Created on : Jan 5, 2021, 1:37:18 AM
    Author     : Muaz Amir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String email = (String) session.getAttribute("email");
            out.println("<p>Session data extracted from Login Page</p>");
            out.println("<br />Email   : " + email);
           
            %>
        
    </body>
</html>
