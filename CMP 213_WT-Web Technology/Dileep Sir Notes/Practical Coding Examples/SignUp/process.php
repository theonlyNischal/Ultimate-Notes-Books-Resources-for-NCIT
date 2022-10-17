<?php

    if($_SERVER['REQUEST_METHOD']=="POST"){
        //process the form

        if(empty($_POST['username']) || empty($_POST['useremail'])){
            echo "Please provide both name and email!<br>";
        }
        else{
            $name=$_POST['username'];
            $email=$_POST['useremail'];
            
            //check for valid name format and email format

            if(preg_match("/[A-Za-z]+/",$name)){
                echo "valid name pattern";
            }
            else{
                echo "Invalid name pattern!";
            }

            if(filter_var($email,FILTER_VALIDATE_EMAIL)){
                echo "valid email format!";
            }
            else{
                echo "Invalid email!";
            }

            echo "Name:$name   Email:$email";
        }

       
      
    }
    else{
        echo "Not Authorized!";
    }

?>