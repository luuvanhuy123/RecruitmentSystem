<?php
   session_start();
?>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
	<title>Buy Book</title>
  <link rel="stylesheet" type="text/css" href="stype_button.css">
</head>
<body style="font-size:125%; font-family : tahoma;">
<div align="center">
	<form style="font-size:150%; font-family : tahoma;" method="post">
		USERNAME: <input type="text" name="username" ><br>
		PASSWORD: <input type="password" name="password"><br>
		<button type="submit">DANG NHAP</button>
	</form>
	<?php
	if (isset($_POST['username']) && isset($_POST['password'])){
		$ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, "http://localhost:8080/RecruitmentSystem/recruitment/services/login/");
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_POST, 1);
        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded')); // In Java: @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

        $data = array('username'=>$_POST['username'],'password'=>$_POST['password']);
        curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
        $output = curl_exec($ch);
        $info = curl_getinfo($ch);
        if($output=="-1"){
            ?>
        <script type="text/javascript">
        	location.load();
        </script>
        <?php
        }
        else
	       	$_SESSION['username']= $_POST['username'];
            $_SESSION['typeuser']= $output;
            ?>
        <script type="text/javascript">
        	window.location = "index.php";
        </script>
        <?php
        }
	?>
</div>
</body>
</html>