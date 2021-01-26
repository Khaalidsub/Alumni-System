<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
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
        <c:choose>
            <c:when test="${signIn != null}">
                <jsp:include page="../headerNav.jsp" />  
            </c:when>
            <c:when test="${admin != null}">
                <jsp:include page="../adminHeaderNav.jsp" />  
            </c:when>
        </c:choose>
        <div class="search-container">
           
            <form action="AlumniController" method="post">
                <input type="hidden" name="command" value="SEARCH-ALUMNI" />
                <input type="text" value="${param.alumniName}" name="alumniName" placeholder="Search for alumni" class="search-for-alumni border-class-1 comfortaa-regular-normal-chicago-20px">
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>
        </div> 
        <div class="container" style="margin-top:30px">
             
            <div class="row">  
                <div class="col-sm-2">
                    <div class="col">


                        <div class="filter-text">
                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Filter Search</button>

                            <div name="filter" class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="AlumniController?command=ALUMNI-SEARCH&filter=Coursename">Course</a>
                                <a class="dropdown-item" href="AlumniController?command=ALUMNI-SEARCH&filter=Graduateyear">Graduation Year</a>
                                <a class="dropdown-item" href="AlumniController?command=ALUMNI-SEARCH&filter=Batchname">Batch</a>

                            </div>

                        </div>
                    </div>
                    <div class="mt-5">
                        <form action="AlumniController" method="post">
                            <input type="hidden" name="command" value="FILTER-ALUMNI" />
                            <input type="hidden" name="filter" value="${param.filter}" />
                            <label class="mb-2">Filter by : ${param.filter}</label>
                            <div class="input-group">

                                <input type="text" class="form-control" name="${param.filter}_input" placeholder="Search for ${param.filter}">
                                <div class="input-group-append">
                                    <button type="submit" class="btn btn-secondary" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </div>
                            </div>
                        </form>            
                    </div>
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
