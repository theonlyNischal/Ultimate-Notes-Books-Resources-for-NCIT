<?php

    //save user's name and age to a text file named usersdata.txt

    //calculate the user count



    //redirection
    //header('Location:home.php')

    session_start();

    if($_SERVER['REQUEST_METHOD']=="POST"){
        
        $user=$_POST['username'];
        $age=$_POST['userage'];

        $file_name="usersdata.txt";
        if(!file_exists($file_name)){
            //no file exists,creating new one
            $file=fopen($file_name,'w') or die("Error unable to create file");
        }
        else{
            $file=fopen($file_name,'a') or die("Error unable to open file");
        }

        $content="Name: $user , Age: $age <br>";
        $bytes_written=fwrite($file,$content);
        echo "$bytes_written bytes written to file";

        //creating session
        $_SESSION['user']=$user;

        if(isset($_SESSION['user_count'])){
            $_SESSION['user_count']=$_SESSION['user_count']+1;
        }
        else{
            $_SESSION['user_count']=1;
        }

        //redirecting
        header('Location:home.php');


    }
    else{
        header('Location:login.php');
    }

?>