<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
                <link rel="stylesheet" href= "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
                <link href="./css/alumni_style.css" rel="stylesheet" /> 
                <link href="./css/view_profile.css" rel="stylesheet" />-->
        <jsp:include page="../bootstrap5.jsp" /> 
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
        <main class="main mt-5 d-flex flex-column justify-content-start">
            <h2 class="text-center my-5">Connect With Different Alumni</h2>
            <hr class="container-md"/>
            <div class="container d-flex flex-column align-items-center" style="margin-top:30px">
                <div class="d-flex flex-row justify-content-between align-self-start w-100">
                    <div class="d-flex flex-column align-items-start">


                        <div class="filter-text">
                            <button type="button" class="btn btn-primary dropdown-toggle" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">Filter Search</button>

                            <div name="filter" aria-labelledby="dropdownMenuButton" class="dropdown-menu  dropdown-toggle" >
                                <a class="dropdown-item" href="AlumniController?command=ALUMNI-SEARCH&filter=Coursename">Course</a>
                                <a class="dropdown-item" href="AlumniController?command=ALUMNI-SEARCH&filter=Graduateyear">Graduation Year</a>
                                <a class="dropdown-item" href="AlumniController?command=ALUMNI-SEARCH&filter=Batchname">Batch</a>

                            </div>

                        </div>
                        <form class="d-flex flex-row mt-3" action="AlumniController" method="post">
                            <input type="hidden" name="command" value="FILTER-ALUMNI" />
                            <input type="hidden" name="filter" value="${param.filter}" />
                            <!--<label class="mb-2">Filter by : ${param.filter}</label>-->
                            <div class="input-group">

                                <button type="submit" class="btn btn-secondary" type="button" id="button-addon2">
                                    <i class="fa fa-search">Filter Search</i>
                                </button>

                                <input type="text" class="form-control" name="${param.filter}_input"  aria-describedby="button-addon2" placeholder="Search for ${param.filter}">


                            </div>



                        </form>   
                    </div>
                    <div class="d-flex flex-row justify-content-between align-items-center">
                      
                        <div class="d-flex justify-content-end my-5 ">

                            <form class="d-flex flex-row" action="AlumniController" method="post">
                                <input type="hidden" name="command" value="SEARCH-ALUMNI" />
                                <input type="text" value="${param.alumniName}" name="alumniName" placeholder="Search for alumni" class="form-control">
                                <button class="btn btn-primary" type="submit"><i class="fa fa-search">Search</i></button>
                            </form>
                        </div>
                    </div>

                </div>



                <div class="col-sm-10 d-flex flex-column align-items-end">


                    <table class="table border rounded table-bordered caption-top">
                          <caption>List of Alumni</caption>
                        <c:forEach var="tempAlumni" items="${ALUMNI_LIST}">
                            <tr class="spaceUnder"><td  class="d-flex flex-row justify-content-center" rowspan="2">

                                    <img
                                        class="vector-6QVaxv"
                                        src="https://anima-uploads.s3.amazonaws.com/projects/5fedca635c07fd3ab0e1d2bd/releases/5fedca9c5122d4b9a1c05998/img/vector-4@2x.svg"
                                        /> </td>
                                <td colspan="2">
                                    ${tempAlumni.alumniName}
                                </td>
                                <td class="d-flex flex-row justify-content-center" rowspan="2"> 

                                    <a href="AlumniController?command=ALUMNI-INFO&alumniEmail=${tempAlumni.alumniEmail}">  

                                        <button type="button" class="btn btn-info">VIEW</button></a>
                                </td>
                            </tr>
                            <tr><td colspan="2" class="d-flex flex-row justify-content-center ">
                                    UTM Alumni
                                </td>
                                <td colspan="4">
                                    <div class="graduation-year-20 border-class-1 comfortaa-regular-normal-black-16px">
                                        Graduation year : ${tempAlumni.graduateYear}
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>  

            </div>
        </main>




    </body>
</html>
