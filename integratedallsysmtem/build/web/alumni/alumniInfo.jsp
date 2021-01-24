<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href= "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <link href="./css/alumni_style.css" rel="stylesheet" /> 

    </head>

    <body>

        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

            <div class="container" >

                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="javascript:;">Home</a>
                    </li>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="AlumniController?command=MY-PROFILE">MyProfile</a>
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
                            <a class="dropdown-item" href="#">Profile</a>
                            <a class="dropdown-item" href="LogoutController">Logout</a>
                        </div>
                    </li>                  
                </ul>
            </div>

        </nav>     
        <div class="container" style="margin-top:100px">
            <div class="d-flex flex-column justify-content-center align-items-center">  
                <div class="col-6">
                    <div class="d-flex flex-row justify-content-between align-items-end">
                        <div class="overlap-group1-fhuxN3">
                            <img class="profile-pic"

                                 src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5ff3fa5c86d30561b87039d0/img/vector@2x.svg"
                                 />

                        </div>
                        <div>
                            <a href="AlumniController?command=EDIT-PROFILE" class="btn btn-warning">Edit Profile</a>
                        </div>
                    </div>



                    <div class="overlap-group-C61RwL">
                        <div class="auto-flex6-4eduM0">
                            <div class="basic-information border-class-1 comfortaa-bold-gray-20px">Basic Information</div>
                            <img
                                class="line-1"
                                src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/line-1@1x.svg"
                                />
                        </div><br /><br />
                        <div class="name-steven-rogers border-class-1 comfortaa-bold-black-20px">Name: ${alumni.alumniName}</div><br />
                        <div class="citizenshi-ted-states border-class-1 comfortaa-bold-black-20px">Citizenship: ${alumni.alumniCitizenship}</div><br />
                        <div class="gender-male border-class-1 comfortaa-bold-black-20px">Gender: ${alumni.gender}</div><br /><br />
                        <div class="auto-flex1-4eduM0">
                            <div class="postage-information border-class-1 comfortaa-bold-gray-20px">Postage Information</div>
                            <img
                                class="line-2-aIOKt1"
                                src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/line-2@1x.svg"
                                />
                        </div><br /><br />
                        <div class="address-17-t-kingston border-class-1 comfortaa-bold-black-20px">
                            Address: ${alumniAddress.houseNo}, ${alumniAddress.region}, ${alumniAddress.streetName}
                        </div>
                        <div class="auto-flex2-4eduM0"><br />
                            <div class="postal-code-12401 border-class-1 comfortaa-bold-black-20px">Postal Code: ${alumniAddress.postalCode}</div><br />
                            <div class="city-new-york-city border-class-1 comfortaa-bold-black-20px">City: ${alumniAddress.city} </div><br />
                        </div>
                        <div class="auto-flex3-4eduM0">
                            <div class="state-ny border-class-1 comfortaa-bold-black-20px">State: ${alumniAddress.state}</div><br />
                            <div class="country-un-ted-states border-class-1 comfortaa-bold-black-20px">Country: ${alumniAddress.country}</div><br />
                        </div>
                        <div class="auto-flex4-4eduM0">
                            <div class="alumni-information border-class-1 comfortaa-bold-gray-20px">Alumni Information</div>
                            <img
                                class="line-3"
                                src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/line-3@1x.svg"
                                />
                        </div><br /><br />
                        <div class="title-mr border-class-1 comfortaa-bold-black-20px">Title: ${alumni.title}</div><br />
                        <div class="education--vel-master border-class-1 comfortaa-bold-black-20px">Education Level: ${alumni.eduLevel}</div><br />
                        <div class="alumni-mat-a08-fa1234 border-class-1 comfortaa-bold-black-20px">Alumni Matric No: ${alumni.alumniMatric}</div><br />
                        <div class="graduate-year-2010 border-class-1 comfortaa-bold-black-20px">Graduate Year: ${alumni.graduateYear}</div><br />
                        <div class="batch-name-avengers border-class-1 comfortaa-bold-black-20px">Batch Name: ${alumni.batchName}</div><br />
                        <div class="course-nam-chitecture border-class-1 comfortaa-bold-black-20px">Course Name: ${alumni.courseName}</div><br />
                        <div class="auto-flex5-4eduM0">
                            <div class="contact-information border-class-1 comfortaa-bold-gray-20px">Contact Information</div>
                            <img
                                class="line-2-5EjQx8"
                                src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/line-2@1x.svg"
                                />
                        </div><br /><br />
                        <div class="e-mail-ste-s85mailcom border-class-1 comfortaa-bold-black-20px">E-mail: ${alumni.alumniEmail}</div><br />
                        <div class="phone-no-012-3456789 border-class-1 comfortaa-bold-black-20px">Phone No: ${alumni.phoneNo}</div><br />
                    </div>
                </div>
            </div>    

        </div>




    </body>
</html>

