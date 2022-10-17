<?php

    if($_SERVER['REQUEST_METHOD']=="POST"){

        $u_name=$_POST['name'];
        $u_roll=$_POST['roll'];
        $u_email=$_POST['email'];
        $u_mobile=$_POST['mobile'];
        $u_status=$_POST['status'];

        //connecting to server
        $conn=mysqli_connect("localhost","root","");
        $db=mysqli_select_db($conn,"institute");
        if($db){
            //insert into table
            $query="INSERT INTO tbl_users(name,roll,mobile_number,email,status) VALUES('$u_name','$u_roll','$u_mobile','$u_email','$u_status')";

            if(mysqli_query($conn,$query)){
                echo "User registered!";
            }
            else{
                echo "Registration failed!".mysqli_error($conn);
            }
        }
        else{
            echo "error with db";
        }
    }
?>