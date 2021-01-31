<%-- 
    Document   : fundingHistory
    Created on : Jan 30, 2021, 2:36:34 PM
    Author     : haisw
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Middleware.Payment" %>

<%ArrayList<Payment> list = (ArrayList<Payment>)request.getAttribute("FUNDING_LIST");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funding History</title>
        <link rel="shortcut icon" href="image/utm.ico" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.css">
        
        <style>
            body {font-family: Arial;}
            .table-row{
                cursor:pointer;
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
        <div class='container'>
            
                <h1>Funding History</h1>

                <table border="1" class="myTable table-hover thead-dark">
                    <thead class="thead-dark">
                        <tr>
                          <th>Index</th>
                          <th>Event Name</th>
                          <th>Funded Amount</th>
                          <th>Status</th>
                          <th>Receipt</th>
                        </tr>
                    </thead>

                    <tbody>
                    
                        <% 
                            int i = 1;
                            for(Payment funds: list){ 
                        %>

                        <tr class='table-row'>
                            <td><% out.print(i); %> </td>                    
                            <td value="<%= funds.getStatus()%>"><%=funds.getEventName() %></td>
                            <td>RM <%=funds.getPaymentAmount()%></td>
                            <td><%=funds.getStatus() %></td>
                            <td><a href="viewImage.jsp?paymentID=<%=funds.getPaymentID() %>">View receipt</a></td>
                        </tr>
                        <% 
                            i++;
                            }
                        %>

                    </tbody>
                </table>     
                
            
                        
            
        </div>

        
        <% 
        
        %>
        
    </body>
    
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.js"></script>
    
    <script type="text/javascript">
     
        $(document).ready(function() {
            var table = $('.myTable').DataTable();
         
            $('#myTable tbody').on( 'click', 'tr', function () {
                if ( $(this).hasClass('selected') ) {
                    $(this).removeClass('selected');
                }
                else {
                    table.$('tr.selected').removeClass('selected');
                    $(this).addClass('selected');
                }
            } );
 
        } );
        
        
        $(document).ready(function($) {
            $(".table-row").click(function() {
                var currentRow=$(this).closest("tr"); 
                
                var eventID = currentRow.find("td:eq(1)").attr('value');
                console.log(eventID);
                
//                if(zone == "danger"){
//                    $(this).children('td, th').css('background-color','red');
//                }
//                
//                var ic = currentRow.find("td:eq(1)").text(); // get current row 1st TD value
//                var enic = encodeURI(ic);
                document.location.href = "EventController?action=selectEvent&eventID="+eventID;
                
             
            });
        });
        $(document).ready(function($) {
            $(".y").click(function() {
                
                window.location.href = "EventController?action=joinedEvents";
            
                
            });
        });
        
         $(document).ready(function($) {
            $(".u").click(function() {
                
                window.location.href = "EventController?action=view";
            
                
            });
        });
        
     

    </script>

</html>
