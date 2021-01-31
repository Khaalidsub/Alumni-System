<%-- 
    Document   : yourEvents
    Created on : Jan 25, 2021, 1:39:35 AM
    Author     : haisw
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Middleware.Event" %>

<%ArrayList<Event> list = (ArrayList<Event>)request.getAttribute("JOINED_EVENT_LIST");%>

<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Events</title>
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
        <div class="container">
            
        <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item active" aria-current="page">Home</li>
                </ol>
            </nav>      

        <h1>Your Events</h1>

                <table border="1" class="myTable">
                    <thead>
                        <tr>
                          <th> Index </th>
                          <th> Name </th>
                          <th> Date</th>
                          <th> Category </th>
                          <th> Payment Status </th>
                          <th> Status </th>
                          
                        </tr>
                    </thead>

                    <tbody>
                    
                        <% 
                            int i = 1;
                            for(Event events: list){ 
                        %>

                        <tr class='table-row'>
                            <td><% out.print(i); %> </td>                    
                            <td value="<%= events.getEventID()%>"><%= events.getEventName()%></td>
                            <td><%= events.getDate()%></td>
                            <td>
                                <%  if(events.getFee().equals("Free")){
                                        out.print("Free");
                                    }else{
                                        out.print("Paid");
                                    }
                                
                                %>
                            
                            </td>
                            
                            <td><% 
                                    if(events.getFee().equals("Free")){
                                        out.print("N/A");
                                    }else{
                                        if(events.getPayment() != null){
                                            out.print("Paid - " + events.getPayment().getStatus());
                                        }else{
                                            out.print("Not paid");
                                        }
                                        
                                    }
                                    
                            
                                %>
                            </td>
                            
                            <td><% 
//                                    if(events.getDate().equals(""))
                                
                                    out.print("UPCOMING");%></td>
                        </tr>
                        <% 
                            i++;
                            }
                        %>

                    </tbody>
                </table>
            </div>
                        
                        
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.js"></script>
    <script>
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
                var category = $.trim(currentRow.find("td:eq(3)").text().toUpperCase());
                var eventID = currentRow.find("td:eq(1)").attr('value');
                console.log(category);
                
//                if(category === 'FREE'){
                          
//                    document.location.href = "viewJoined.jsp?action=selectJoinedEvent&eventID="+eventID;
//                }else{
                      document.location.href = "EventController?action=selectJoinedEvent&eventID="+eventID;
//
//                }
                
//                if(zone == "danger"){
//                    $(this).children('td, th').css('background-color','red');
//                }
//                
//                var ic = currentRow.find("td:eq(1)").text(); // get current row 1st TD value
//                var enic = encodeURI(ic);
                
                
             
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
        
        $(document).ready(function($) {
            $(".p").click(function() {
                
                window.location.href = "PaymentController?action=pay";
            
                
            });
        });
    </script>
    </body>
    
</html>
