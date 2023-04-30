<?php 
$username=$_POST['username'];
$email=$_POST['email'];
$password=$_POST['password'];
$confirm-password=$_POST['confirm-password'];

//DB Conn
$conn=new mysqli('localhost','root','','test');
if($conn->connect_error){
    die("connection failed:".$conn->connect_error);
}
else{
    $stmt=$conn->prepare("insert into registration(userName,email,password,confirm-password)values(?,?,?)");
    $stmt->bind_param("")
    $stmt->execute();
    echo"Registration Successfull!!!";
    $stmt->close();
    $conn->close();
}
?>