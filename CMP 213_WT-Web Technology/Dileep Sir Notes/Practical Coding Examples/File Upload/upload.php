<html>
    <body>
        <form method="POST" action="" enctype="multipart/form-data">
            Name:<input type="text" name="username"/><br><br>
            Image:<input type="file" name="myfile">

            <input type="submit" name="submit" value="Upload"/>
        </form>
    </body>
</html>

<?php
    if(isset($_POST['submit'])){

        if(isset($_FILES['myfile'])){

            echo "<hr>";
            $username=$_POST['username'];
            $filesize=$_FILES['myfile']['size'];
            $filename=$_FILES['myfile']['name'];
            $filetype=$_FILES['myfile']['type'];
            $templocation=$_FILES['myfile']['tmp_name'];

            $targetlocation="files/"."$filename";

            $extensions=array("image/jpeg","image/jpg","image/png");

            //check and compare file type
            if(in_array($filetype,$extensions)===false){
                echo "File type not supported. Please upload jpeg/jpg/png files only";

            }
            else{

            if(move_uploaded_file($templocation,$targetlocation)){

                //store the information in databse table
                $conn=mysqli_connect("localhost","root","");
                $db=mysqli_select_db($conn,"seday");
                if($db){
                    $query="INSERT INTO images(username,imagename) VALUES('$username','$filename')";
                    if(mysqli_query($conn,$query)){
                        echo "Successfully added to database<br>";
                    }
                    else{
                        echo "Error:".mysqli_error($conn);
                    }
                }
                else{
                    echo "db error";
                }

                echo "File uploaded successfully!<br>";
                echo "<img src='$targetlocation' height='200' width='300'/>";
                echo "Temp Location: $templocation";
                echo "Target Location: $targetlocation<br>";
                echo "File size: $filesize<br>";
                echo "File type: $filetype<br>";
                echo "Uploaded by: $username";

            }
            else{
                echo "Upload failed!";
            }
        }


        }
        else{
            echo "No file selected please select one!";
        }

    }

?>