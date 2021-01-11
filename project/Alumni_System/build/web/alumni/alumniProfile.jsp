<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <link href="css/view_profile.css" rel="stylesheet" />
        <title></title>
    </head>
    <body>
        <div class="view-profile">
            <div class="overlap-group1">
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
            <div class="auto-flex4-C61RwL">
                <div class="overlap-group-Xa1OFb">
                    <div class="rectangle-23"></div>
                    <img
                        class="ellipse-4"
                        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/ellipse-4@2x.svg"
                        />
                    <img
                        class="vector-a4vd0b"
                        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/vector@2x.svg"
                        />
                    <div class="view-information border-class-1 comfortaa-bold-haiti-20px">View information</div>
                    <img
                        class="vector-HIQFF0"
                        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/vector-1@2x.svg"
                        />
                    <div class="edit-information border-class-1 comfortaa-bold-black-20px">Edit information</div>
                    <img
                        class="vector-g5WeGn"
                        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/vector-2@2x.svg"
                        />
                    <div class="steven-rogers border-class-1 comfortaa-bold-black-30px">${alumni.alumniName}</div>
                </div>
                <div class="auto-flex3-Xa1OFb">
                    <div class="auto-flex-fCNQqZ">
                        <div class="basic-information border-class-1 comfortaa-bold-gray-20px">Basic Information</div>
                        <img
                            class="line-1"
                            src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/line-1@1x.svg"
                            />
                    </div>
                    <div class="name-steven-rogers border-class-1 comfortaa-bold-black-20px">Name : ${alumni.alumniName}</div>
                    <div class="name-steven-rogers6 border-class-1 comfortaa-bold-black-20px">Gender : ${alumni.gender}</div>
                    <div class="name-steven-rogers5 border-class-1 comfortaa-bold-black-20px">Citizenship:  ${alumni.alumniCitizenship}</div>
                    <div class="auto-flex1-fCNQqZ">
                        <div class="alumni-information border-class-1 comfortaa-bold-gray-20px">Alumni Information</div>
                        <img
                            class="line-3"
                            src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/line-3@1x.svg"
                            />
                    </div>
                    <div class="name-steven-rogers4 border-class-1 comfortaa-bold-black-20px">Graduate Year : ${alumni.graduateYear}</div>
                    <div class="name-steven-rogers3 border-class-1 comfortaa-bold-black-20px">Batch Name :  ${alumni.batchName}</div>
                    <div class="name-steven-rogers2 border-class-1 comfortaa-bold-black-20px">Education Level :  ${alumni.eduLevel}</div>
                    <div class="auto-flex2-fCNQqZ">
                        <div class="contact-information border-class-1 comfortaa-bold-gray-20px">Contact Information</div>
                        <img
                            class="line-2"
                            src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/line-2@1x.svg"
                            />
                    </div>
                    <div class="name-steven-rogers1 border-class-1 comfortaa-bold-black-20px">E-mail :  ${alumni.alumniEmail}</div>
                </div>
            </div>
        </div>
    </body>
</html>
