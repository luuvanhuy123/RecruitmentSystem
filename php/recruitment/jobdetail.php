<?php
	session_start();
?>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/tab.css">
	<title>job detail</title>
</head>
<body>
	<?php
		if(!isset($_SESSION['username'])){
			header("Location:index.php");
		}
		else{
			if(isset($_POST['detail'])){
				echo $_POST['detail'];
			$ch = curl_init();
	        curl_setopt($ch, CURLOPT_URL, "http://localhost:8080/RecruitmentSystem/recruitment/user/jobdetail/");
	        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
	        curl_setopt($ch, CURLOPT_POST, 1);
	        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded')); // In Java: @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

	        $data = array('postformId'=>$_POST['detail']);
	        curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
	        $output = curl_exec($ch);
	        $info = curl_getinfo($ch);
	        $array = json_decode($output,true);
	    ?>
<ul>

	    		<li>company_name: <?php echo $array['company_name']; ?></li>
	    		<li>company_addres: <?php echo $array['company_addres']; ?></li>
	    		<li>company_phone: <?php echo $array['company_phone']; ?></li>
	    		<li>jobDescription: <?php echo $array['jobDescription']; ?></li>
	    		<li>jobName: <?php echo $array['jobName']; ?></li>
	    		<li>jobPosition: <?php echo $array['jobPosition']; ?></li>
	    		<li>date: <?php echo $array['date']; ?></li>
	    		<li>jobRecruitment: <?php echo $array['jobRecruitment']; ?></li>
	    		<li>salary: <?php echo $array['salary']; ?></li>
	    		<li>otherInfor: <?php echo $array['otherInfor']; ?></li>
	    		<li>salary: <?php echo $array['salary']; ?></li>
	    		<li>otherInfor: <?php echo $array['otherInfor']; ?></li>
	    	</ul>
	    </div>
	    	<form action="regis.php" method="POST">
	    		<input type="hidden" name="id" value="<?php echo $array['postsId'] ?>">
	    		<button type="submit">Nộp Đơn</button>

	    	</form>
	    		<button onclick="back()">Quay Lại</button>
	    <?php
	    }
	}
	?>
	<script >
		function back(){
			window.location = "index.php";
		}
</body>
</html>
