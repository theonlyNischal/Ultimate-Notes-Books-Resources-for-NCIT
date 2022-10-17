<?php
    
    require_once("connect.php");

    //create database

    $query="CREATE DATABASE institute";

    $result=mysqli_query($connection,$query);

    if($result){
        echo "<br>DATABASE created successfully";
    }
    else{
        echo "<br>Error in creating database".mysqli_error($connection);
    }

?>