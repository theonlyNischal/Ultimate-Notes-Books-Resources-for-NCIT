<?php

	error_reporting( ~E_NOTICE );
	
	require_once 'dbconfig.php';
	
	if(isset($_GET['edit_id']) && !empty($_GET['edit_id']))
	{
		$id = $_GET['edit_id'];
		$stmt_edit = $DB_con->prepare('SELECT * FROM tbl_users WHERE id =:news_id');
		$stmt_edit->execute(array(':news_id'=>$id));
		$edit_row = $stmt_edit->fetch(PDO::FETCH_ASSOC);
		extract($edit_row);
	}
	else
	{
		header("Location: index.php");
	}
	
	
	
	if(isset($_POST['btn_save_updates']))
	{
		$title = $_POST['title'];// news title
		$description = $_POST['description'];// news description
					
		
		// if no error occured, continue ....
		if(!isset($errMSG))
		{
			$stmt = $DB_con->prepare('UPDATE tbl_news
									     SET title=:title, 
										     description=:description,
								       WHERE id=:id');
			$stmt->bindParam(':title',$title);
			$stmt->bindParam(':description',$description);
			$stmt->bindParam(':id',$id);
				
			if($stmt->execute()){
				?>
                <script>
				alert('Successfully Updated ...');
				window.location.href='index.php';
				</script>
                <?php
			}
			else{
				$errMSG = "Sorry Data Could Not Updated !";
			}
		
		}
		
						
	}
	
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Demo PHP MySQL - NCIT Web Technology SE 2016</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="bootstrap/js/bootstrap.min.js"></script>

<script src="jquery-1.11.3-jquery.min.js"></script>
</head>
<body>

<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
 
        <div class="navbar-header">
            <a class="navbar-brand" href="index.php" title='List all News'>Home</a>
        </div>
 
    </div>
</div>


<div class="container">

<div class="clearfix"></div>

<form method="post" class="form-horizontal">
	
    
    <?php
	if(isset($errMSG)){
		?>
        <div class="alert alert-danger">
          <span class="glyphicon glyphicon-info-sign"></span> &nbsp; <?php echo $errMSG; ?>
        </div>
        <?php
	}
	?>
   
    
	<table class="table table-bordered table-responsive">
	
    <tr>
    <tr>
    	<td><label class="control-label">Title</label></td>
        <td><input class="form-control" type="text" name="title" placeholder="Enter News Title" value="<?php echo $title; ?>" /></td>
    </tr>
    
    <tr>
    	<td><label class="control-label">Description</label></td>
        <td><textarea class="form-control" name="description" value="<?php echo $description; ?>">
        </textarea>
        </td>
    </tr>
    
    <tr>
        <td colspan="2"><button type="submit" name="btn_save_updates" class="btn btn-default">
        <span class="glyphicon glyphicon-save"></span> Update
        </button>
        
        <a class="btn btn-default" href="index.php"> <span class="glyphicon glyphicon-backward"></span> cancel </a>
        
        </td>
    </tr>
    
    </table>
    
</form>

</div>
</body>
</html>