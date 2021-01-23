<%-- 
    Document   : login
    Created on : Jan 12, 2021, 7:30:24 AM
    Author     : Muaz Amir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
       <title>Alumni Login System</title>

      <!-- Bootstrap core CSS -->
      <link href="CSS/bootstrap.min.css" rel="stylesheet">

      <style>
         .bd-placeholder-img {
           font-size: 1.125rem;
           text-anchor: middle;
           -webkit-user-select: none;
           -moz-user-select: none;
           -ms-user-select: none;
           user-select: none;
         }

         @media (min-width: 768px) {
           .bd-placeholder-img-lg {
             font-size: 3.5rem;
           }
         }
      </style>

      <!-- Custom styles for this template -->
      <link href="css/navbar-top-fixed.css" rel="stylesheet">
      
     <!-- JQUERY -->
      <script
         src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
         crossorigin="anonymous"></script>
        <script type="text/javascript"
                src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js">
                    
        </script>
      
   </head>

   <body>

      

      <main role="main" class="container">

       

         <div class="row">
             <div class="col"></div>
                 
            <div class="col-6">
                <br><br><br>
               <div class="card shadow">
                  <div class="card-body">
                      
                     <h2>Login</h2>
                     <br>
                     <form action="SignInController" method="post">
                     <div class="form-floating sm-3">
                         <label for="floatingInput">Email address</label>
                         <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="Email" required>           
                    </div>
                     
                    <div class="form-floating">
                        <label for="floatingPassword">Password</label>
                      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password" required>  
                    </div>    
                         <br>${message}
                         <br>
                         <button type="submit" class="btn btn-primary">Login</button> Dont have an account yet? 
                           <a href="register.html"><button type="button" class="btn btn-danger" >Sign Up</button></a>

                     </form>
                  </div>
               </div>
               
            </div>
              <div class="col"></div>
         </div>

      </main>

      <footer class="container">
         <br />
        
      </footer>
      
      <script src="js/jquery-3.5.1.min.js"></script>
      <script src="js/popper.min.js"></script>      
      <script src="js/bootstrap.min.js"></script>
   </body>   
   
   <script type="text/javascript">
 
    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },
         
                password: "required"
            },
             
            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                },
                 
                password: "Please enter password"
            }
        });
 
    });
</script>
   
   
</html>

