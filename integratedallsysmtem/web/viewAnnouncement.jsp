<%-- 
    Document   : viewAnnouncement
    Created on : Jan 22, 2021, 12:47:19 AM
    Author     : haisw
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Middleware.Announcement" %>

<%ArrayList<Announcement> list = (ArrayList<Announcement>)request.getAttribute("ANNOUNCEMENT_LIST");%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Announcements</title>
        <link rel="shortcut icon" href="image/utm.ico" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
      
        <!-- Bootstrap core CSS -->
        <link href="CSS/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./css/navbar-top-fixed.css" rel="stylesheet">
        
         <!-- data tables -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" type="text/css" href=" https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
        
        <script src="https://kit.fontawesome.com/43d73fdaf8.js" crossorigin="anonymous"></script>
        
        <style>
            
            .table-row{
                cursor:pointer;
            }
         
            .body{
                padding: 0 10px;
            }
            
            .title{
                padding: 20px 0;
            }
            
       
              
            .table{
                border-radius: 5px;
                box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.1), 0 3px 6px 0 rgba(0, 0, 0, 0.19);
            }
            
        </style>    
    </head>
    <body>
        
        <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item active" aria-current="page">Home</li>
                </ol>
            </nav>  
        
        <jsp:include page="headerNav.jsp" />    
        
        <div class='container a'>
            
            <div class="body">
                <div class="title">
                    <h1><i class="fas fa-bullhorn"></i>  Announcements</h1>
                </div>
                

            <table border="1" class="myTable table table-striped table-bordered table-hover thead-dark">
                <thead class="thead-dark">
                    <tr>
                      <th>Index</th>
                      <th>Name</th>
                      <th>Date</th>
                    </tr>
                </thead>

                <tbody>
                
                    <% 
                        int i = 1;
                        for(Announcement a: list){ 
                    %>

                    <tr class='table-row'>
                        <td><% out.print(i); %> </td>                    
                        <td><%= a.getAnnouncementName()%></td>
                        <td><%= a.getAnnouncementDate()%></td>
                        
                        
                    </tr>
                    <% 
                        i++;
                        }
                    %>

                </tbody>

            </table>     
         </div>
        </div>  
    
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.23/js/dataTables.bootstrap4.min.js"></script>
    
    
    <script type="text/javascript">
     
        $(document).ready(function() {
            var table = $('#myTable').DataTable();
         
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
               
                                          
                 document.location.href = "ViewEvent?command=select&event="+eventID;
                
             
            });
        });
    </script>

  
    </body>
   

</html>
