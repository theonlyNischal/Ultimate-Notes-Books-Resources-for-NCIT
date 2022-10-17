<?php

$file_name="seday.txt";

//check if the file exists or not
if(file_exists($file_name)){
    $file=fopen($file_name,'r');

    //reading from file

    $file_size=filesize($file_name);

    $filedata=fread($file,$file_size);

    echo $filedata;

    //close
    fclose($file);

    //delete
    //unlink($file_name);
}
else{
    echo "Error: file does not exists!";
}



//writing to a file

//$bytes_info=fwrite($file,"\n Hello Again!");

//echo "$bytes_info bytes written to file!";


?>