<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href= "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
    <link href="./css/alumni_style.css" rel="stylesheet" /> 
      
        <title></title>
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
 
  </nav>
        <div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-4">

                    <img
                        class="vector-a4vd0b"
                        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/vector@2x.svg"
                        /> <br /><br /><br />
                    <div>${alumni.alumniName}</div>
                    <br /><br />
                    <img
                        class="vector-HIQFF0"
                        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/vector-1@2x.svg"
                        />
                    <a href="AlumniController?command=INFO-DETAIL&alumniEmail=${alumni.alumniEmail}">  View information</a>
                     <br /><br />
                     <img
                        class="vector-g5WeGn"
                        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/vector-2@2x.svg"
                        />
                   <a  href="AlumniController?command=EDIT-PROFILE&alumniEmail=${alumni.alumniEmail}">   Edit information</a>
                    
                    
    </div>
    
          <div class="col-sm-8">           
               
               
               <div class="auto-flex3-Xa1OFb">
                    <div class="auto-flex-fCNQqZ">
                        <div class="basic-information border-class-1 comfortaa-bold-gray-20px">Basic Information</div>
                        <img
                            class="line-1"
                            src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/line-1@1x.svg"
                            />
                    </div>
                    <div class="name-steven-rogers border-class-1 comfortaa-bold-black-20px">Name : ${alumni.alumniName}</div><br />
                    <div class="name-steven-rogers6 border-class-1 comfortaa-bold-black-20px">Gender : ${alumni.gender}</div><br />
                    <div class="name-steven-rogers5 border-class-1 comfortaa-bold-black-20px">Citizenship:  ${alumni.alumniCitizenship}</div><br /><br />
                    <div class="auto-flex1-fCNQqZ">
                        <div class="alumni-information border-class-1 comfortaa-bold-gray-20px">Alumni Information</div>
                        <img
                            class="line-3"
                            src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/line-3@1x.svg"
                            />
                    </div>
                    <div class="name-steven-rogers4 border-class-1 comfortaa-bold-black-20px">Graduate Year : ${alumni.graduateYear}</div><br />
                    <div class="name-steven-rogers3 border-class-1 comfortaa-bold-black-20px">Batch Name :  ${alumni.batchName}</div><br />
                    <div class="name-steven-rogers2 border-class-1 comfortaa-bold-black-20px">Education Level :  ${alumni.eduLevel}</div><br /><br />
                    <div class="auto-flex2-fCNQqZ">
                        <div class="contact-information border-class-1 comfortaa-bold-gray-20px">Contact Information</div>
                        <img
                            class="line-2"
                            src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/line-2@1x.svg"
                            />
                    </div>
                    <div class="name-steven-rogers1 border-class-1 comfortaa-bold-black-20px">E-mail :  ${alumni.alumniEmail}</div><br />
                </div>
            </div>
        </div>
    </body>
</html>
