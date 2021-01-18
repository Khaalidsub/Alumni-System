<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href= "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
    <link href="./css/alumni_style.css" rel="stylesheet" /> 
   <link href="./css/view_profile.css" rel="stylesheet" />
  </head>
  <body>
       <div class="jumbotron" style="margin-bottom:0">
        
    <img class="logo" src="image/LOGO-UTM.png" alt="LOGO UTM" />
        
                <h1>Alumni of Seni Bina</h1>
     
</div> 
    
      <nav class="navbar navbar-expand-sm bg-light">
     
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="index.html">Home</a>
        </li>
        <li class="nav-item"><a class="nav-link" href="AlumniController?command=MY-PROFILE">My Profile</a></li>
        <li class="nav-item"><a class="nav-link" href="AlumniController?command=ALUMNI-SEARCH">Connect</a></li>
             
    </ul>
      <div class="search-container">
            <form action="AlumniController" method="post">
                <input type="hidden" name="command" value="SEARCH-ALUMNI" />
                <input type="text" name="alumniName" placeholder="Search for alumni" class="search-for-alumni border-class-1 comfortaa-regular-normal-chicago-20px">
                <button type="submit"><i class="fa fa-search"></i></button>
                
        </div>   
  </nav>
  <div class="container" style="margin-top:30px">
  <div class="row">  
            <div class="col-sm-2">
        <div class="filter-text">
        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Filter Search</button>
      
          <div class="dropdown-menu dropdown-menu-right">
              <a class="dropdown-item" href="#">Course</a>
              <a class="dropdown-item" href="#">Graduation Year</a>
             <a class="dropdown-item" href="#">Batch</a>
   
          </div>
      
        </div>
<!--             <div>
             <input type="text" name="alumniName" placeholder="Search for alumni" class="">
                <button type="submit"><i class="fa fa-search"></i></button>
        </div>-->
  </div>
    <div class="col-sm-8">
            
<table class="table">
      <c:forEach var="tempAlumni" items="${ALUMNI_LIST}">
          <tr class="spaceUnder"><td rowspan="2">
       
          <img
            class="vector-6QVaxv"
            src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/vector-4@2x.svg"
            /> </td>
      <td colspan="2">
          ${tempAlumni.alumniName}
        </td>
        <td rowspan="2"> 
         
          <a href="AlumniController?command=ALUMNI-INFO&alumniEmail=${tempAlumni.alumniEmail}">  
              
              <button type="button" class="btn btn-info">VIEW</button></a>
        </td>
      </tr>
      <tr><td>
           UTM Alumni
          </td>
          <td>
            <div class="graduation-year-20 border-class-1 comfortaa-regular-normal-black-16px">
              Graduation year : ${tempAlumni.graduateYear}
            </td>
      </tr>
       </c:forEach>
      </table>
            </div>
                


  </body>
</html>
