<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
 <div align="center">
  <h1>Alumni Register Form</h1>
  <form action="RegisterController" method="post">
   <table style="width: 80%">
    <tr>
     <td>Name</td>
     <td><input type="text" name="Name" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
     <td>Phone No.</td>
     <td><input type="text" name="phone" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="Address" /></td>
    </tr>
    <tr>
     <td>Previous Job</td>
     <td><input type="text" name="PreviousJob" /></td>
    </tr>
    <tr>
     <td>Current Job</td>
     <td><input type="text" name="CurrentJob" /></td>
    </tr>
    <tr>
     <td>Current Salary</td>
     <td><input type="text" name="SalaryCurrent" /></td>
    </tr>
    <tr>
     <td>Previous Salary</td>
     <td><input type="text" name="SalaryPrevious" /></td>
    </tr>
    <tr>
     <td>Graduate Year</td>
     <td><input type="text" name="GraduateYear" /></td>
    </tr>
    
    
  
   </table>
   <input type="submit" name="Submit" value="Submit" />
  </form>
 </div>
</body>
</html>