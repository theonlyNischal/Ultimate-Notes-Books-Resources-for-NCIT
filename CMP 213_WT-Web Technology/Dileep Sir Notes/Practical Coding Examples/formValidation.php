<?php

    //defining variables to hold error mesages
    $nameErr=$emailErr=$passErr=$genErr="";

    //defining variables to hold field values
    $name=$email=$password=$gender="";

    if($_SERVER["REQUEST_METHOD"]=="POST"){

        //for username
        if(empty($_POST['username'])){
            //username is empty
            $nameErr="Name cannot be empty!";
        }
        else{
            //username is not empty, check pattern(alphabets only)
            $name=$_POST['username'];
            if(!preg_match("/^[a-zA-Z ]*$/",$name)){
                //pattern not matched
                $nameErr="Only alphabets or a space is allowed!";
            }
        }

        //for useremail

        if(empty($_POST['useremail'])){
            $emailErr="User email cannot be empty!";
        }
        else{
            $email=$_POST['useremail'];

            if(!filter_var($email,FILTER_VALIDATE_EMAIL)){
                $emailErr="Incorrect email format!";
            }
        }

        //for password

        if(empty($_POST['userpass'])){
            $passErr="Password can't be empty";
        }
        else{
            $password=$_POST['userpass'];
            if(strlen($password)<6){
                $passErr="Password must be 6 characters long!";
            }
        }

        //for gender
        if(empty($_POST['usergen'])){
            $genErr="Please specify your gender";
        }
        else{
            $gender=$_POST['usergen'];
        }


        //display

       
    }


?>


<html>
    <head>
        <style>
            .error{
                color:red;
            }
        </style>
    </head>
    <body>
        <h2>Sign up Form</h2>
        <p><span class="error">* required fields</span></p>
        <form action="" method="POST">
            Name: <input type="text" name="username" value="<?php echo $name; ?>"/> <span class="error">* <?php echo $nameErr; ?> </span><br><br>

            Email: <input type="text" name="useremail" value="<?php echo $email; ?>"/> <span class="error">* <?php echo $emailErr; ?> </span><br><br>

            Password: <input type="password" name="userpass" value="<?php echo $password ?>"/> <span class="error">* <?php echo $passErr; ?></span><br><br>

            Gender: 
            Male <input type="radio" name="usergen" value="male" <?php if(isset($gender) && $gender=="male") echo "checked" ?>/> 

            Female <input type="radio" name="usergen" value="female" <?php if(isset($gender) && $gender=="female") echo "checked" ?>/> 

            Other <input type="radio" name="usergen" value="other" <?php if(isset($gender) && $gender=="other") echo "checked" ?>/> <span class="error">* <?php echo $genErr;?></span><br><br>

            <input type="submit" value="Sign Up" name="submit"/>
        </form>
    </body>

</html>


<?php
if($_SERVER["REQUEST_METHOD"]=="POST"){

    if(empty($nameErr) && empty($emailErr) && empty($passErr) && empty($genErr)){
        //display the info

        echo "<h3>Your input is:</h3>";
        echo "$name <br> $email <br> $password <br> $gender";

        //database insertion and redirection to another page

    }
}


?>
