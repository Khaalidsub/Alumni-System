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


        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

            <div class="container">

                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="javascript:;">Home</a>
                    </li>
                    </li>
              
                    <li class="nav-item active">
                        <a class="nav-link" href="reportHomeUser.jsp">Report</a>
                    </li>

                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="AlumniController?command=ALUMNI-SEARCH">Connect</a>
                    </li>
                </ul>

                <ul class="navbar-nav">

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="h#" id="dropdown07" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${signIn.getName()}</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown07">
                            <a class="dropdown-item" href="AlumniController?command=MY-PROFILE">Profile</a>
                            <a class="dropdown-item" href="LogoutController">Logout</a>
                        </div>
                    </li>                  
                </ul>
            </div>

        </nav>   
        <div class="container" style="margin-top:100px">
            <div class="row">  
                <div class="col-6">

                    <img class="profile-pic"

                         src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5ff3fa5c86d30561b87039d0/img/vector@2x.svg"
                         />



                    <form action="AlumniController" method="post">
                        <input type="hidden" name="command" value="UPDATE-ALUMNI" />
                        <input type="hidden" name="email" value="${alumni.alumniEmail}" />

                        <h3>Basic Information</h3>
                        <img

                            src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5ff3fa5c86d30561b87039d0/img/line-1-2@1x.svg"
                            />
                        <p>Name: ${alumni.alumniName}</p><br />
                        <p>Citizenship: ${alumni.alumniCitizenship}</p><br />
                        <p>Gender: ${alumni.gender}</p><br />

                        <br /><br />
                        <h3><b>Postage Information</b> </h3>
                        <img
                            class="line-2-1PKwfj"
                            src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5ff3fa5c86d30561b87039d0/img/line-2-3@1x.svg"
                            /><br /><br />

                        <div class="d-flex">
                            <div>
                                <label for="streetName" class="mr-sm-2">StreetName:</label>
                                <input type="text" name="streetName" value="${alumniAddress.streetName}" />
                            </div>
                            <div>
                                <label for="houseNo" class="mr-sm-2">HouseNo:</label>
                                <input type="text" name="houseNo" value="${alumniAddress.houseNo}" />
                            </div>    
                        </div>
                        <br /><br />
                        <label for="postalCode" class="mr-sm-2">Postal Code:</label>
                        <input type="number" name="postalCode" value="${alumniAddress.postalCode}" />
                        <br /><br />
                        <label for="state" class="mr-sm-2">State:</label>
                        <input type="text" name="state" value="${alumniAddress.state}" /> 

                        <label for="region" class="mr-sm-2">Region: </label>
                        <input type="text" name="region" value="${alumniAddress.region}"  />
                        <br /><br />

                        <label for="city" class="mr-sm-2">City: </label>
                        <input type="text" name="city" value="${alumniAddress.city}" />

                        <label for="country" class="mr-sm-2">Country: </label>
                        <input type="text" name="country" value="${alumniAddress.country}" /><br /><br />

                        <br /><br />
                        <h3>Alumni Information </h3>
                        <img
                            class="line-2-1PKwfj"
                            src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5ff3fa5c86d30561b87039d0/img/line-2-3@1x.svg"
                            /><br /><br />

                        <p>Title:</p>
                        <select name="title"  class="overlap-group11-atxA5x">
                            <option selected value="${alumni.title}">${alumni.title}</option>
                            <option value="Mr">Mr</option>
                            <option value="Ms">Ms</option>
                            <option value="Dr">Dr</option>
                            <option value="Ir">Ir</option>
                            <option value="Professor">Professor</option>
                        </select>
                        <br /><br />  
                        <p>Education Level: ${alumni.eduLevel}</p><br /> 
                        <p>Alumni Matric No: ${alumni.alumniMatric} </p><br /><br /> 

                        <label for="graduateYear" class="mr-sm-2">City: </label>
                        <input name="graduateYear" type="number" value="${alumni.graduateYear}" />

                        <br /><br /><p>Batch Name: ${alumni.batchName}</p><br /> 
                        <p>Course Name: ${alumni.courseName}</p><br /> 

                        <br /><br />
                        <h3>Contact Information </h3>
                        <img
                            class="line-2-1PKwfj"
                            src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5ff3fa5c86d30561b87039d0/img/line-2-3@1x.svg"
                            /><br /><br />


                        <p>E-mail: ${alumni.alumniEmail}</p>

                        <br />
                        <label for="phone" class="mr-sm-2">Phone No: </label>
                        <input type="number" name="phone" value="${alumni.phoneNo}" />
                        <br /><br />
                        <button type="submit" class="btn btn-secondary">Save</button>

                    </form>

                </div>
            </div>
        </div>



    </body>
</html>
