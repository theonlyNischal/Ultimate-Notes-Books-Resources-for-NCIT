<?php

    include("connect.php");

    $db=mysqli_select_db($connection,"institute");

    if($db){
            //insert into table 
            $query="INSERT INTO tbl_users(name,roll,mobile_number,email,status) VALUES('anish','123456','9876543210','anish@ncit.edu.np','student')";

            if(mysqli_query($connection,$query)){
                echo "values insertted successfully!";
            }
            else{
                echo "failed to insert values";
            }
    }
    else{
        echo "error in db selection";
    }

?>