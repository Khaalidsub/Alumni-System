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
            <h1>Recipient Info</h1>
            <p>Name: Murli</p>
            <p>Payment method: Make online transfer - upload receipt</p>
            <p>Recipient Bank: Bank Islam</p>
            <p>Recipient account.no: 8979768670</p>
            <hr>
            
            <% String eID = request.getParameter("eventID"); %>
            <% String pType = request.getParameter("pType"); %>

            <form action="PaymentController" enctype="multipart/form-data" method="post">

                <label for="name">Name*:</label><br>
                <input type="text" id="name" name="name" required=""><br>
                <label for="fname">Event:</label><br>
                <input type="text" id="fname" name="eventID" readonly placeholder="<%out.print(eID);%>" value="<%=eID%>"><br>
                <label for="fname">Event ID:</label><br>
                <input type="text" id="fname" name="eventID" readonly placeholder="<%out.print(eID);%>" value="<%=eID%>"><br>
            
                <label for="lname">Payment Category (Choose only that applicable)* :</label><br>
                <input type="radio" id="eventFee" name="category" value="fee">
                <label for="eventFee">Event Fee</label><br>
                <input type="radio" id="Fund" name="category" value="fund">
                <label for="Fund">Fund</label><br><br>
<!--            <input type="radio" id="fee_fund" name="category" value="fee_fund">
                <label for="fee_fund">Event Fee + Fund</label><br><br>-->

                Amount*:<input  type="text" name="amount" required=""/><br><br>
                Photo*: <input  type="file" name="photo" size="50" required=""/><br><br>

                <input type="submit" value="Save">


            </form>
        </div>
    </body>
</html>
