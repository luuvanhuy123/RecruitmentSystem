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
			if(isset($_POST['connect'])){
				$ch = curl_init();
		        curl_setopt($ch, CURLOPT_URL, "http://localhost:8080/RecruitmentSystem/recruitment/user/connect/");
		        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
		        curl_setopt($ch, CURLOPT_POST, 1);
		        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded')); // In Java: @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		        $data = array('username'=>$_POST['email'],'postid'=>$_POST['postid'],'feedback'=>$_POST['feedback']);
		        curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
		        $output = curl_exec($ch);
		        $info = curl_getinfo($ch);
                if($output == "true"){
                    ?>
                    <script type="text/javascript">
                        window.location = "listconfirm.php";
                    </script>
                    <?php
                }
                else{
                    ?>
                        <script type="text/javascript">
                            alert("duyet khong thanh cong!");
                             window.location = "listconfirm.php";
                        </script>
                    <?php
                }
			}?>
</body>
</html>