<%-- 
    Document   : eventForm
    Created on : Jan 1, 2021, 2:09:51 AM
    Author     : mrhr10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        
    </head>
    <body>
        <h1>Create a new Event</h1>
        
        <form action="#" method="POST">
            <label for="eventTitle">Title:</label>
            <input id="eventTitle" name="eventTitle" type="text" placeholder="Enter event title" required>
            <br /><br />
            <label for="eventOrganizer">Organizer:</label>
            <input id="eventOrganizer" name="eventOrganizer" type="text" placeholder="Enter event organizer" required>
            <br /><br />
            <label for="eventDate">Date:</label>
            <input id="eventDate" name="eventDate" type="date" required>
            <br /><br />
            <label class="control-label" for="datetimepicker1">Appointment Time</label>
            <div class='input-group date' id='datetimepicker1'>
                <input type='text' name="eventDateTime" class="form-control" />
                <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
                </span>
            </div>
            <br /><br />
            <label for="eventVenue">Venue:</label>
            <input id="eventVenue" name="eventVenue" type="text" placeholder="Enter event venue" required>
            <br /><br />
            <label for="eventFee">Fee (RM):</label>
            <input id="eventTitle" name="eventFee" type="text" placeholder="Enter event fee" required>
            <br /><br />
            <label for="eventDesc">Description:</label>
            <textarea name="eventDesc" rows="4" cols="20"> </textarea>
            <br /><br />
            <input type="submit" value="Submit">
            
        </form>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/momentjs/2.14.1/moment.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
        
        <script>
            $(function () {
              $('#datetimepicker1').datetimepicker();
           });
          </script>
    </body>
</html>
