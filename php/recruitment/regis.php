<?php
	session_start();
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
		        curl_setopt($ch, CURLOPT_URL, "http://localhost:8080/RecruitmentSystem/recruitment/user/registryJobpost/");
		        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
		        curl_setopt($ch, CURLOPT_POST, 1);
		        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded')); // In Java: @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

		        $data = array('postId'=>$_POST['id'],'username'=>$_SESSION['username']);
		        curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
		        $output = curl_exec($ch);
		        $info = curl_getinfo($ch);
		        if($output == "false"){
		        	?>
		        	<script >
		        		alert("ban da dang ki bai dang nay roi");
		        		window.location = "index.php";
		        	</script>
		        	<?php
		        }
		        else{
		        			        	?>
		        	<script >
		        		alert("damg ki thanh cong");
		        		window.location = "index.php";
		        	</script>
		        	<?php
		        }
		    }
			}
		}
	?>
</body>
</html>