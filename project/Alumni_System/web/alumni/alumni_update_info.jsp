<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link href="css/information.css" rel="stylesheet" />
        <title></title>
    </head>
    
    <body>
      <body>
    <div class="view-information">
  <div class="overlap-group2">
    <div class="rectangle-1"></div>
    <img
      class="humaaans-3-characters"
      src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/humaaans-3-characters@2x.png"
    />
    <h1 class="alumni-of---surveying border-class-1 footlightmtlight-regular-normal-white-45px">
      Alumni of <br />Faculty of Built Environment &amp; Surveying
    </h1>
    <img
      class="ellipse-3"
      src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/ellipse-3@2x.png"
    />
    <a href="index.html"><div class="home border-class-1 comfortaa-bold-white-25px">Home</div></a>
    <a href="AlumniController?command=MY-PROFILE"><div class="my-profile border-class-1 comfortaa-bold-white-25px">My Profile</div></a>
    <a href="AlumniController?command=ALUMNI-SEARCH"><div class="search border-class-1 comfortaa-bold-white-25px">Connect</div></a>
  </div>
  <div class="auto-flex-C61RwL">
    <div class="overlap-group1-fhuxN3">
      <img
        class="vector-GtdoDw"
        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5ff3fa5c86d30561b87039d0/img/vector@2x.svg"
      />
      <img
        class="ellipse-5"
        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5ff3fa5c86d30561b87039d0/img/ellipse-5@2x.svg"
      />
      <img
        class="vector-RMWSf2"
        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5ff3fa5c86d30561b87039d0/img/vector-2@2x.svg"
      />
    </div>
    
  </div>
  <div class="overlap-group-C61RwL">
    <div class="auto-flex6-4eduM0">
      <div class="basic-information border-class-1 comfortaa-bold-gray-20px">Basic Information</div>
      <img
        class="line-1"
        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/line-1@1x.svg"
      />
    </div>
    <div class="name-steven-rogers border-class-1 comfortaa-bold-black-20px">Name: ${alumni.alumniName}</div>
    <div class="citizenshi-ted-states border-class-1 comfortaa-bold-black-20px">Citizenship: ${alumni.alumniCitizenship}</div>
    <div class="gender-male border-class-1 comfortaa-bold-black-20px">Gender: ${alumni.gender}</div>
    <div class="auto-flex1-4eduM0">
      <div class="postage-information border-class-1 comfortaa-bold-gray-20px">Postage Information</div>
      <img
        class="line-2-aIOKt1"
        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/line-2@1x.svg"
      />
    </div>
    <div class="address-17-t-kingston border-class-1 comfortaa-bold-black-20px">
      Address: ${alumniAddress.houseNo}, ${alumniAddress.region}, ${alumniAddress.streetName}
    </div>
    <div class="auto-flex2-4eduM0">
      <div class="postal-code-12401 border-class-1 comfortaa-bold-black-20px">Postal Code: ${alumniAddress.postalCode} </div>
      <div class="city-new-york-city border-class-1 comfortaa-bold-black-20px">City: ${alumniAddress.city} </div>
    </div>
    <div class="auto-flex3-4eduM0">
      <div class="state-ny border-class-1 comfortaa-bold-black-20px">State: ${alumniAddress.state}</div>
      <div class="country-un-ted-states border-class-1 comfortaa-bold-black-20px">Country: ${alumniAddress.country}</div>
    </div>
    <div class="auto-flex4-4eduM0">
      <div class="alumni-information border-class-1 comfortaa-bold-gray-20px">Alumni Information</div>
      <img
        class="line-3"
        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/line-3@1x.svg"
      />
    </div>
    <div class="title-mr border-class-1 comfortaa-bold-black-20px">Title: ${alumni.title}</div>
    <div class="education--vel-master border-class-1 comfortaa-bold-black-20px">Education Level: ${alumni.eduLevel}</div>
    <div class="alumni-mat-a08-fa1234 border-class-1 comfortaa-bold-black-20px">Alumni Matric No: ${alumni.alumniMatric}</div>
    <div class="graduate-year-2010 border-class-1 comfortaa-bold-black-20px">Graduate Year: ${alumni.graduateYear}</div>
    <div class="batch-name-avengers border-class-1 comfortaa-bold-black-20px">Batch Name: ${alumni.batchName}</div>
    <div class="course-nam-chitecture border-class-1 comfortaa-bold-black-20px">Course Name: ${alumni.courseName}</div>
    <div class="auto-flex5-4eduM0">
      <div class="contact-information border-class-1 comfortaa-bold-gray-20px">Contact Information</div>
      <img
        class="line-2-5EjQx8"
        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/line-2@1x.svg"
      />
    </div>
    <div class="e-mail-ste-s85mailcom border-class-1 comfortaa-bold-black-20px">E-mail: ${alumni.alumniEmail}</div>
    <div class="phone-no-012-3456789 border-class-1 comfortaa-bold-black-20px">Phone No: ${alumni.phoneNo}</div>
  </div>
</div>
  </body>
</html>

