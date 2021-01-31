<%-- 
    Document   : viewEvent
    Created on : Jan 1, 2021, 12:18:37 PM
    Author     : mrhr10
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Middleware.Event" %>

<%ArrayList<Event> list = (ArrayList<Event>)request.getAttribute("EVENT_LIST");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upcoming Events</title>
        <link rel="shortcut icon" href="image/utm.ico" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.css">
        <!-- Bootstrap core CSS -->
        <link href="CSS/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./css/navbar-top-fixed.css" rel="stylesheet">
       
        <style>
           
            
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
            
            
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
            
            
         
            

        </style>    
    </head>
    <body>
        <jsp:include page="headerNav.jsp" />    

        <main role="main" class="container">
            
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item active" aria-current="page">Home</li>
                </ol>
            </nav>  
        
<!--            <button type="button" class="btn btn-info u">Upcoming Events</button>
            <button type="button" class="btn btn-info y">Your Events</button>
            <button type="button" class="btn btn-info f">Funding History</button>-->
           
            <div class="body">
                <div class="title">
                    <h1>Upcoming Events</h1>
                </div>
            
                
            
            
                <table border="1" class="myTable table-hover thead-dark">
                    <thead class="thead-dark">
                        <tr>
                          <th>Index</th>
                          <th>Name</th>
                          <th>Date</th>
                          <th>Venue</th>
                          <th>Organizer</th>
                        </tr>
                    </thead>

                    <tbody>
<!--                        <% if(list != null){ %>
                            <h1><%=list.isEmpty()%></h1>
                            <h1><c:out value="${sessionScope.count}" /></h1>
                            <h1><c:out value="${sessionScope.c}" /></h1>-->
                        <%    
                                }
                        %>
                        <% 
                            int i = 1;
                            for(Event events: list){ 
                        %>

                        <tr class='table-row'>
                            <td><% out.print(i); %> </td>                    
                            <td value="<%= events.getEventID()%>"><%= events.getEventName()%></td>
                            <td><%= events.getDate()%></td>
                            <td><%= events.getVenue()%></td>
                            <td><%= events.getOrganizer()%></td>
                        </tr>
                        <% 
                            i++;
                            }
                        %>

                    </tbody>
                </table>     
                
            </div>
    
                        
            
        </main>
                        
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

            $(document).ready(function($) {
                $(".f").click(function() {

                    window.location.href = "PaymentController?action=fundingList";


                });
            });



        </script>

        
       
        
    </body>
    
   

</html>
