<?php

$conn=mysqli_connect("localhost","root","");
$db=mysqli_select_db($conn,"seday");

if($db){
    $query="SELECT * FROM images";

    $result=mysqli_query($conn,$query);

    if($result){

?>
<h2>Available Images in DB</h2>

<?php
        while($row=mysqli_fetch_assoc($result)){
            $imageid=$row['id'];
            $username=$row['username'];
            $imagename=$row['imagename'];
?>
    <div class="imagebox">
        <image src="<?php echo 'files/'.$imagename; ?>" height='200'/>
        <p>Uploaded by:<?php echo $username; ?> </p>
        <button >Delete</button>

<?php
    

?>
    </div>             

<?php
        }

    }
    else {
        echo "Nothing to display";
    }
}
else{
    echo "db error!";
}


?>