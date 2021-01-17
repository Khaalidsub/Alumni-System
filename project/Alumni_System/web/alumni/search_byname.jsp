<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
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
    <title></title>
   <link href="./css/view_profile.css" rel="stylesheet" />
  </head>
  <body>
    <div class="search">
  <div class="overlap-group10">
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
    <a href="AlumniController?command=ALUMNI-SEARCH"><div class="search border-class-1 comfortaa-bold-white-25px">Search</div></a>
  </div>
  <div class="auto-flex2-C61RwL">
    <div class="overlap-group-phANlq">
      <div class="rectangle-20"></div>
      <div class="rectangle-22"></div>
      <div class="filter-search border-class-1 comfortaa-bold-white-20px">Filter Search</div>
      <img
        class="vector-tj2oKg"
        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/vector-8@2x.svg"
      />
      <div class="course border-class-1 comfortaa-bold-chicago-20px">Course</div>
      <div class="graduation-year border-class-1 comfortaa-bold-chicago-20px">Graduation Year</div>
      <div class="batch border-class-1 comfortaa-bold-chicago-20px">Batch</div>
    </div>
    <div class="auto-flex1-phANlq">
      <div class="auto-flex-1XBJaM">
        <div class="overlap-group2-dSU0qP">
            
            <form action="AlumniController" method="post">
                <input type="hidden" name="command" value="SEARCH-ALUMNI" />
                <button type="submit"><img
            class="vector-BRQyZ1"
            src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/vector-3@2x.svg"
            /></button>
                <input type="text" name="alumniName" placeholder="Search for alumni" class="search-for-alumni border-class-1 comfortaa-regular-normal-chicago-20px">
        </div></form>
        <div class="overlap-group3-dSU0qP">
          <div class="auto-flex3-E1ZttC">
            <img
              class="fill-6"
              src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/fill-6@2x.svg"
            />
            <img
              class="fill-1-itu69x"
              src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/fill-1-1@2x.svg"
            />
          </div>
          <div class="auto-flex4-E1ZttC">
            <img
              class="fill-4"
              src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/fill-4@2x.svg"
            />
            <img
              class="fill-9"
              src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/fill-9@2x.svg"
            />
          </div>
        </div>
        <div class="overlap-group1-dSU0qP">
          <img
            class="fill-1-fhKmGV"
            src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/fill-1@2x.svg"
          />
          <img
            class="combined-shape"
            src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/combined-shape@2x.svg"
          />
        </div>
      </div>
 

      <c:forEach var="tempAlumni" items="${ALUMNI_SEARCHLIST}">
                <div class="overlap-group-JUxu8l">
        <div class="overlap-group">
          <img
            class="vector-6QVaxv"
            src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/vector-4@2x.svg"
          />
        </div>
        <div class="auto-flex">
          <div class="steven-rogers border-class-1 comfortaa-bold-black-22px">${tempAlumni.alumniName}</div>
          <div class="auto-flex-mbTXrJ">
            <div class="utm-alumni border-class-1 comfortaa-bold-black-20px">UTM Alumni</div>
            <div class="graduation-year-20 border-class-1 comfortaa-regular-normal-black-16px">
              Graduation year : ${tempAlumni.graduateYear}
            </div>
          </div>
        </div>
        <div class="overlap-group-92K7kn">
          <div class="button smart-layers-pointers"></div>
          <img
            class="rectangle-25"
            src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fede5adc6293ae5ee39b91f/img/rectangle-25@2x.svg"
          />
          <a href="AlumniController?command=ALUMNI-INFO&alumniEmail=${tempAlumni.alumniEmail}">  <div class="view border-class-1 comfortaa-bold-black-25px">VIEW</div></a>
        </div>
      </div>
      </c:forEach> 
    </div>
  </div>
</div>
  </body>
</html>

