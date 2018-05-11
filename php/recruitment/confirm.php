<?php
	session_start()
?>
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<?php
		if(!isset($_SESSION['username'])){
			header("Location:index.php");
		}
		else{
			if(!isset($_POST['action'])){
				if(isset($_POST['id'])){
				$ch = curl_init();
		        curl_setopt($ch, CURLOPT_URL, "http://localhost:8080/RecruitmentSystem/recruitment/user/confirm/");
		        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
		        curl_setopt($ch, CURLOPT_POST, 1);
		        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded')); // In Java: @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		        $data = array('postId'=>$_POST['id'],'username'=>$_SESSION['username']);
		        curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
		        $output = curl_exec($ch);
		        $info = curl_getinfo($ch);
		        if($output=="true"){
		        	?>
		        		<script >
		        			window.location = "history.php";
		        		</script>
		        	<?php
		        }
				}
			}
		}
	?>
</body>
</html>