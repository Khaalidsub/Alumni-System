<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <<link rel="stylesheet" href="css/information.css">
    <title></title>
  </head>
  <body>
    <div class="desktop-1">
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
    <div class="home border-class-1 comfortaa-bold-white-25px">Home</div>
    <div class="my-profile border-class-1 comfortaa-bold-white-25px">My Profile</div>
    <div class="search border-class-1 comfortaa-bold-white-25px">Search</div>
  </div>
  <div class="auto-flex-C61RwL">
    <div class="overlap-group1-fhuxN3">
      <img
        class="vector-GtdoDw"
        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5ff3fa5c86d30561b87039d0/img/vector-12@2x.svg"
      />
      <img
        class="ellipse-5"
        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5ff3fa5c86d30561b87039d0/img/ellipse-5@2x.svg"
      />
      <img
        class="vector-RMWSf2"
        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5ff3fa5c86d30561b87039d0/img/vector-14@2x.svg"
      />
    </div>
 
  </div>
  <div class="overlap-group-C61RwL">
      <form action="AlumniController" method="post">
          <input type="hidden" name="command" value="UPDATE-ALUMNI" />
     
    <div class="auto-flex2-4eduM0">
      <div class="basic-information border-class-1 comfortaa-bold-gray-20px">Basic Information</div>
      <img
        class="line-1"
        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5ff3fa5c86d30561b87039d0/img/line-1-2@1x.svg"
      />
    </div>
    <div class="auto-flex9-4eduM0">
      <div class="auto-flex3-hAA74W">
        <div class="name border-class-1 comfortaa-bold-black-20px">Name:</div>
        <div class="citizenship border-class-1 comfortaa-bold-black-20px">Citizenship:</div>
        <div class="gender border-class-1 comfortaa-bold-black-20px">Gender:</div>
        <div class="postage-information border-class-1 comfortaa-bold-gray-20px">Postage Information</div>
        <div class="address border-class-1 comfortaa-bold-black-20px">StreetName</div>
         <div class="address border-class-1 comfortaa-bold-black-20px">HouseNo:</div>
        <div class="postal-code border-class-1 comfortaa-bold-black-20px">Postal Code:</div>
        <div class="state border-class-1 comfortaa-bold-black-20px">State:</div>
      </div>
      <div class="auto-flex8-hAA74W">
        <div class="overlap-group5-1PKwfj">
          <div class="steven-rogers border-class-1 comfortaa-bold-abbey-20px">${alumni.alumniName}</div>
        </div>
        <div class="overlap-group7-1PKwfj">
          <div class="united-states-OCJWxz border-class-1 comfortaa-bold-abbey-20px">${alumni.alumniCitizenship}</div>
        </div>
        <div class="overlap-group14-1PKwfj"><div class="male border-class-1 comfortaa-bold-abbey-20px">${alumni.gender}</div></div>
        <img
          class="line-2-1PKwfj"
          src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5ff3fa5c86d30561b87039d0/img/line-2-3@1x.svg"
        />
        <!--<div  class="overlap-group12-1PKwfj"></div>-->
         

   
        <div style="height:120px;" class="auto-flex7-1PKwfj">
          <div class="auto-flex6-shBxuW">
<!--            <input class="overlap-group10-X8a6Pf">
   
            </input>-->
<input type="text" name="streetName" value="${alumniAddress.streetName}" class="overlap-group17-X8a6Pf"/>
<input type="text" name="houseNo" value="${alumniAddress.houseNo}" class="overlap-group17-X8a6Pf"/>
<input type="number" name="postalCode" value=" ${alumniAddress.postalCode}" class="overlap-group17-X8a6Pf"/>
<input type="text" name="state" value="${alumniAddress.state}" class="overlap-group17-X8a6Pf"/>   
          </div>
          <div class="auto-flex4-shBxuW">
            <div class="city border-class-1 comfortaa-bold-black-20px">City:</div>
            <div class="country border-class-1 comfortaa-bold-black-20px">Country:</div>
              <div class="country border-class-1 comfortaa-bold-black-20px">Region:</div>
          </div>
          <div class="auto-flex5-shBxuW">
              <input type="text" name="city" value="${alumniAddress.city}"  class="overlap-group18-kYbQDV"/>
              
           
         <input type="text" name="country" value="${alumniAddress.country}"  class="overlap-group18-kYbQDV"/>
      
            
 <input type="text" name="region" value="${alumniAddress.region}"  class="overlap-group18-kYbQDV"/>
      
            
        
          </div>
        </div>
      </div>
    </div>
    <div class="auto-flex1-4eduM0">
      <div class="alumni-information border-class-1 comfortaa-bold-gray-20px">Alumni Information</div>
      <img
        class="line-3"
        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5ff3fa5c86d30561b87039d0/img/line-3-2@1x.svg"
      />
    </div>
    <div class="auto-flex10-4eduM0">
      <div class="title border-class-1 comfortaa-bold-black-20px">Title:</div>
      <select name="title"  class="overlap-group11-atxA5x">
                     <option selected value="${alumni.title}">${alumni.title}</option>
           <option value="Mr">Mr</option>
            <option value="Ms">Ms</option>
             <option value="Dr">Dr</option>
              <option value="Ir">Ir</option>
               <option value="Professor">Professor</option>
      </select>
    </div>
    <div class="auto-flex11-4eduM0">
      <div class="education-level border-class-1 comfortaa-bold-black-20px">Education Level:</div>
      <div class="overlap-group3-EhU6zU"><div class="master border-class-1 comfortaa-bold-abbey-20px">${alumni.eduLevel}</div></div>
    </div>
    <div class="auto-flex12-4eduM0">
      <div class="alumni-matric-no border-class-1 comfortaa-bold-black-20px">Alumni Matric No.:</div>
      <div class="overlap-group4-T44CbI">
        <div class="a08-fa1234 border-class-1 comfortaa-bold-abbey-20px">${alumni.alumniMatric}</div>
      </div>
    </div>
    <div class="auto-flex13-4eduM0">
      <div class="graduate-year border-class-1 comfortaa-bold-black-20px">Graduate Year:</div>
      <input name="graduateYear" type="number" value="${alumni.graduateYear}" class="overlap-group8-FEz7fr"/>
    </div>
    <div class="auto-flex14-4eduM0">
      <div class="batch-name border-class-1 comfortaa-bold-black-20px">Batch Name:</div>
      <div class="overlap-group6-WWZ2KX">
        <div class="avengers border-class-1 comfortaa-bold-abbey-20px">${alumni.batchName}</div>
      </div>
    </div>
    <div class="auto-flex15-4eduM0">
      <div class="course-name border-class-1 comfortaa-bold-black-20px">Course Name:</div>
      <div class="overlap-group13-7SUk4Y">
        <div class="architecture border-class-1 comfortaa-bold-abbey-20px"> ${alumni.courseName}</div>
      </div>
    </div>
    <div class="auto-flex16-4eduM0">
      <div class="contact-information border-class-1 comfortaa-bold-gray-20px">Contact Information</div>
      <img
        class="line-2-JeuC3e"
        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5ff3fa5c86d30561b87039d0/img/line-2-3@1x.svg"
      />
    </div>
    <div class="auto-flex17-4eduM0">
      <div class="e-mail border-class-1 comfortaa-bold-black-20px">E-mail:</div>
      <div class="overlap-group16-EWh5Ex">${alumni.alumniEmail}</div>
      
  
    </div>
    <div class="auto-flex18-4eduM0">
      <div class="phone-no border-class-1 comfortaa-bold-black-20px">Phone No.:</div>
      <input type="phone" name="phone" value="${alumni.phoneNo}"  class="overlap-group15-EACngc"/>
 

    </div>
   <button class="group-20">
      <div class="group-14">
        <div class="tick-square"></div>
        <div class="save border-class-1 comfortaa-bold-black-20px">Save</div>
      </div>
    </button>
           </form>
  </div>
</div>
  </body>
</html>
