<%-- 
    Document   : makePayment
    Created on : Jan 27, 2021, 4:34:53 PM
    Author     : haisw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment</title>
        <link rel="shortcut icon" href="image/utm.ico" />
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upcoming Events</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.css">
        
        <style>
            
            .a{
                box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.19), 0 6px 10px 0 rgba(0, 0, 0, 0.19);
                padding: 30px 60px;
                border-radius: 5px;
                width: 60%;
                margin-top: 20px;
                
            }
            
            h1{
                margin-left: 0;
            }
            
            hr{
                
                border-top: 2px solid black;

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
        <div class="container a">
            <div class="row">
                <div class="col">
            
                    <h1>Recipient Info</h1>
                    <p>Name: Murli</p>
                    <p>Payment method: Make online transfer - upload receipt</p>
                    <p>Recipient Bank: Bank Islam</p>
                    <p>Recipient account.no: 8979768670</p>
                    <hr>

                    <% String eID = request.getParameter("eventID"); %>
                    <% String pType = request.getParameter("pType"); %>
                   
                    
                    
                    <h1>Payment Details</h1><br>
                    
                    <form action="PaymentController" enctype="multipart/form-data" method="post">
                        <table width="350" cellspacing="5" cellpadding="5">
                            <tr>
                              <th width="200" scope="row"><div align="left">Name:</div></th>
                              <td width=""><label>
                                <input type="text" id="name" name="name" required="">
                              </label></td>
                            </tr>
<!--                            <tr>
                              <th scope="row"><div align="left">Event:</div></th>
                              <td><label>
                                 <input type="text" id="fname" name="eventName" readonly placeholder="<%out.print(eID);%>" value="<%=eID%>"><br>
                              </label></td>
                            </tr>-->
                            <tr>
                              <th scope="row"><div align="left">Event ID:</div></th>
                              <td><label>
                                 <input type="text" id="fname" name="eventID" readonly placeholder="<%out.print(eID);%>" value="<%=eID%>"><br>
                              </label></td>
                            </tr>
                           
                            <tr>
                                <th scope="row"><div align="left">Payment Category (Choose only that applicable)* :</div></th>
                                <td><label>
                                    <input type="radio" id="eventFee" name="category" value="fee">
                                    <label for="eventFee">Event Fee</label>&nbsp;
                                    <input type="radio" id="Fund" name="category" value="fund">
                                    <label for="Fund">Fund</label>
                                    </label>
                                </td>
                            </tr>
                            
                            <tr>
                              <th scope="row"><div align="left">Amount (RM):</div></th>
                              <td><label>
                                 <input  type="text" name="amount" required=""/>
                              </label></td>
                            </tr>
                            <tr>
                             <tr>
                              <th scope="row"><div align="left">Receipt (Screenshot):</div></th>
                              <td><label>
                                <input  type="file" name="photo" size="50" required=""/>
                              </label></td>
                            </tr>
                            <tr>
                                
                                
                            <th scope="row"><div align="left"></div></th>
                              <td><label>
                                <button value="r" type="submit" class="btn btn-warning">Submit</button>
                                <button type="reset" class="btn btn-outline-danger">Reset</button>
                               
                              </label></td>
                            </tr>
                        </table>

                    </form>
                </div>
            </div>            
    </body>
</html>

