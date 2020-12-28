<?php 
session_start();

if (isset($_SESSION['id']) && isset($_SESSION['user_name'])) {

 ?>
<!DOCTYPE html>
<html>
<head>
	<title>HOME</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
     <h1>Hello, <?php echo $_SESSION['name']; ?></h1>

     <?php   if($_SESSION['id'] == '1') {?>
     <h1> <?php echo "You are an admin";
     }
     else if ($_SESSION['id'] == '2') {?></h1>

     <h1><?php echo "You are an alumni";
     } ?></h1>


     <a href="logout.php">Logout</a>
</body>
</html>

<?php 
}else{
     header("Location: index.php");
     exit();
}
 ?>