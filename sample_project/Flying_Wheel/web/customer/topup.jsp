<%-- 
    Document   : customerTopup
    Created on : 10-Nov-2019, 21:49:34
    Author     : Muhammad Mohsin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Top Up</title>
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
                        <a class="nav-link" href="CustomerControllerServlet">Home<span class="sr-only">(current)</span></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="CustomerControllerServlet?command=VIEW-BOOKING">Booking</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerControllerServlet?command=VIEW-SHOP">Shop</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerControllerServlet?command=VIEW-CART">Cart</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerControllerServlet?command=VIEW-ORDER">Order</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerControllerServlet?command=TOP-UP">Top-Up</a>
                    </li>
                </ul>

                <form action="CustomerControllerServlet" method="GET">
                    <input type="hidden" name="command" value="LOGOUT" />
                    <button class="btn btn-secondary my-2 my-sm-0 rounded-pill text-white" name="logout" style="background-color: rgb(255, 60, 0);" >logout</button>
                </form>
            </div>
        </nav>


        <div class="row mt-5">
            <div class="col-md-5 m-auto">
                <div class="card card-body">

                    <c:if test="${not empty success}">
                        <div class="alert alert-dismissible alert-success">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>${success}</strong>
                        </div>  
                    </c:if>

                    <c:if test="${not empty fail}">
                        <div class="alert alert-dismissible alert-danger">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>${fail}</strong>
                        </div>  
                    </c:if>

                    <h1 class="text-center mb-3"><i class="fas fa-sign-in-alt"></i>TOP-UP</h1>
                    <form action="CustomerControllerServlet" method="post">
                        <input type="hidden" name="command" value="TOP-UP" />

                        <div class="form-group">
                            <label for="card">Card Type</label><br>
                            <input type="radio" name="card" value="visa"> Visa
                            <input type="radio" name="card" value="mastercard"> Mastercard
                        </div>

                        <div class="form-group">
                            <label for="cardno">Card Number</label>
                            <input
                                type="text"
                                id="cardno"
                                name="cardno"
                                class="form-control"
                                placeholder="Enter Valid Card Number" required
                                />  
                        </div>

                        <div class="form-group">
                            <label for="expdate">Expiry Date</label>
                            <div class="row w-75 pl-3">
                                <input
                                    type="text"
                                    id="month"
                                    name="expdate"
                                    class="form-control w-25"
                                    placeholder="MM" required
                                    /> &nbsp;&nbsp;&nbsp;
                                <input
                                    type="text"
                                    id="year"
                                    name="expdate"
                                    class="form-control w-25"
                                    placeholder="YY" required
                                    />  &nbsp;&nbsp;&nbsp;
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="ccv">CVV Code</label>
                            <input
                                type="text"
                                id="ccv"
                                name="ccv"
                                class="form-control w-25"
                                placeholder="CVV" required
                                />  
                        </div>


                        <div class="form-group">
                            <label for="amount">Amount</label>
                            <select name="amount" id="MyContentPlaceHolder_ddlJantina" class="form-control"
                                    required="required">
                                <option selected="selected" value="">Select Amount</option>
                                <option value="5.00">RM 5.00</option>
                                <option value="10.00">RM 10.00</option>
                                <option value="20.00">RM 20.00</option>
                                <option value="50.00">RM 50.00</option>
                                <option value="100.00">RM 100.00</option>
                            </select>
                        </div>

                        <br><p align="center"><button type="submit" class="btn btn-primary btn-lg">Topup</button></p>
                    </form>
                </div>
            </div>   
        </div>
    </body>
</html>

