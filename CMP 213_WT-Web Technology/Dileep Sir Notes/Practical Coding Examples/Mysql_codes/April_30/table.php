<?php
    include("connect.php");

    //database select
    $db=mysqli_select_db($connection,"institute");

    if($db){
        //db selected now create table

        $query="CREATE TABLE tbl_users(id INT(4) PRIMARY KEY AUTO_INCREMENT,name TEXT(100) ,roll INT(6),mobile_number BIGINT(10),email VARCHAR(200),status TEXT(50))";

        if(mysqli_query($connection,$query)){
            echo "table created successfully";
        }
        else{
            echo "failed to create table".mysqli_error($connection);
        }
    }
    else{
        echo "error in db selection".mysqli_error($connection);
    }


?>