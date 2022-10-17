<?php

    $hostname="localhost";
    $username="root";
    $password="";

    $connection=mysqli_connect($hostname,$username,$password);

    if($connection){
        echo "Connected to $hostname successfully!";
    }
    else{
        echo "Connection was not successfull!";
    }

?>