<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <jsp:include page="../bootstrap5.jsp" /> 
        <title>Alumni Profile</title>
    </head>
    <body>


         <c:choose>
            <c:when test="${signIn != null}">
                <jsp:include page="../headerNav.jsp" />  
            </c:when>
            <c:when test="${admin != null}">
                <jsp:include page="../adminHeaderNav.jsp" />  
            </c:when> 
         </c:choose>
                        <div class="container" style="margin-top: 100px">
            <div class="card d-flex flex-row justify-content-around align-items-center shadow">
              
                
                <div class=" card p-5 text-center d-flex flex-column justify-content-center shadow border-dark rounded align-items-center">

                    <img
                        class="w-50"
                        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/vector@2x.svg"
                        /> <br /><br /><br />
                    <div>${alumni.alumniName}</div>
                    <br /><br />
                    <c:choose>
                        <c:when test="${param.command eq 'MY-PROFILE'}">
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
                   </c:when>
                          <c:when test="${admin != null}">
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
                   </c:when>
            </c:choose>

                </div>

                <div class=" p-5 m-2 rounded">           


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
        </div>
    </body>
</html>
