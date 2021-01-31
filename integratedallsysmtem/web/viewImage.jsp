<%-- 
    Document   : viewImage
    Created on : Jan 30, 2021, 4:46:43 PM
    Author     : haisw
--%>

<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="jdbc.EventDAO"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Receipt</title>
        <link rel="shortcut icon" href="image/utm.ico" />
    </head>
    <body>
        <%
            String pID = request.getParameter("paymentID"); 
            
            EventDAO E = new EventDAO();
            Connection con = E.getConnection();
           
          
            String message = null;  // message will be sent back to client
            PreparedStatement statement;
            ResultSet rs;

            String sql = "SELECT fileName FROM payment WHERE paymentID=?";

            try {
                
                // constructs SQL statement

                statement = con.prepareStatement(sql);

                statement.setString(1, pID);

                rs = statement.executeQuery();


                    // sends the statement to the database server

                    if (rs.next()) {
                        Blob blob = rs.getBlob("filename");
                        byte byteArray[] = blob.getBytes(1, (int) blob.length());
                        response.setContentType("image/gif");
                        OutputStream os = response.getOutputStream();
                        os.write(byteArray);
                        os.flush();
                        os.close();
                    }else{
                        
                        System.out.println("NO IMAGE FOUND");
                    }
                } catch (SQLException ex) {
                    message = "ERROR: " + ex.getMessage();
                    ex.printStackTrace();
                } 
        
        
        
        
        %>
        
      
    </body>
</html>
