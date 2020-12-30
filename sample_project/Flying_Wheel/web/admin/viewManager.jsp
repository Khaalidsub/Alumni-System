<%-- 
    Document   : viewManager
    Created on : Oct 26, 2019, 11:10:38 PM
    Author     : Khalid
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Admin Dashboard</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>

        <!--navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="AdminControllerServlet">Flying-Wheel</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01"
                    aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarColor01">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="AdminControllerServlet">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminControllerServlet?command=VIEW-MANAGER">Managers</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminControllerServlet?command=VIEW-MEMBER">Members</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminControllerServlet?command=VIEW-BICYCLE">Bicycles</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminControllerServlet?command=VIEW-ITEM">Items</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminControllerServlet?command=VIEW-FINANCIAL-REPORT">Financial Report</a>
                    </li>
                </ul>

                <form action="AdminControllerServlet" method="GET">
                    <input type="hidden" name="command" value="LOGOUT" />
                    <button class="btn btn-secondary my-2 my-sm-0 rounded-pill text-white" name="logout" style="background-color: rgb(255, 60, 0);" >logout</button>
                </form>
            </div>
        </nav>
        <!--Table-->
        <br>
        <br>
        <div class="container">

            <a href="AdminControllerServlet?command=ADD-MANAGER" class="btn btn-primary">Add-Manager</a>
            <br>
            <br>
            <table class="table table-hover text-center">
                <c:if test="${not empty success}">
                    <div class="alert alert-dismissible alert-success">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>Well done!</strong> You successfully Added ${success}.
                    </div>  
                </c:if>
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <c:forEach var="tempManger" items="${MANAGER_LIST}">

                    <!-- set up a link for each student -->
                    <c:url var="updatelink" value="AdminControllerServlet">
                        <c:param name="command" value="LOAD" />
                        <c:param name="userId" value="${tempManger.userid}" />
                    </c:url>

                    <!--  set up a link to delete a student -->
                    <c:url var="deleteLink" value="AdminControllerServlet">
                        <c:param name="command" value="DELETE" />
                        <c:param name="userId" value="${tempManger.userid}" />
                    </c:url>
                    <c:url var="disablelink" value="AdminControllerServlet">
                        <c:param name="command" value="DISABLE" />
                        <c:param name="userId" value="${tempManger.userid}" />
                    </c:url>

                    <tr>
                        <th scope="row">${tempManger.userid}</th>
                        <td>${tempManger.username}</td>
                        <td>${tempManger.email}</td>
                        <td>${tempManger.phone}</td>
                        <td><a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure you want to delete this manager?')))
                                           return false">
                                Delete</a> | <a href="${updatelink}">View</a>  | <a href="${disablelink}" onclick="if (!(confirm('Are you sure you want to disable this manager?')))
                                            return false">disable</a> 


                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
