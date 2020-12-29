<?php

$sname= "localhost";
$uname= "root";
$password = "";

$db_name = "alumni_account";

$conn = mysqli_connect($sname, $uname, $password, $db_name);

$db = new PDO('mysql:host=localhost;dbname=' . $db_name . ';charset=utf8', $uname, $password);
$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

if (!$conn) {
	echo "Connection failed!";
}