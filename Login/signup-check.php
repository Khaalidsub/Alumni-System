<?php 
session_start(); 
include "db_conn.php";

if (isset($_POST['uname']) && isset($_POST['password'])
    && isset($_POST['email']) && isset($_POST['confirm_password'])) {

	function validate($data){
       $data = trim($data);
	   $data = stripslashes($data);
	   $data = htmlspecialchars($data);
	   return $data;
	}

	$uname = validate($_POST['uname']);
	$pass = $_POST['password'];

	$re_pass = $_POST['confirm_password'];
	$email = validate($_POST['email']);

	$id = 2;
	$user_data = 'uname'. $uname. 'email'. $email;


	if (empty($uname)) {
		header("Location: index.php?error=username is required&$user_data");
	    exit();
	}else if(empty($pass)){
        header("Location: index.php?error=Password is required&$user_data");
	    exit();
	}
	else if(empty($re_pass)){
        header("Location: index.php?error=Confirmation password is required&$user_data");
	    exit();
	}

	else if(empty($email)){
        header("Location: index.php?error=Email is required&$user_data");
	    exit();
	}

	else if($pass !== $re_pass){
        header("Location: index.php?error=confirmation password does not match&$user_data");
	    exit();
	}

	else{

	    $sql = "SELECT * FROM users WHERE user_name='$uname' AND password='$pass' AND email='$email'"	;
		$result = mysqli_query($conn, $sql);

		if (mysqli_num_rows($result) > 0) {
			header("Location: index.php?error=The username is taken try another&$user_data");
			exit();
			 
		}else {

			$sql2 = "INSERT INTO users (id,user_name, password, email ) VALUES(?,?,?,?)";
			$stmtinsert = $db->prepare($sql2);
			$result2 = $stmtinsert->execute([$id, $uname, $pass, $email]);


           if ($result2) {
           	 header("Location: index.php?success=Your account has been created successfully");
	         exit();
           }else {
	           	header("Location: index.php?error=unknown error occurred&$user_data");
		        exit();
           }
		}
		
	}
	
}else{
	header("Location: index.php");
	exit();
}