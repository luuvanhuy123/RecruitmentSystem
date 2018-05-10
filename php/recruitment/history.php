<?php
	session_start();
?>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/history.css">
	<title>history</title>
</head>
<body>
	<div id="top">
		<div id="element">
		<h3>Bạn Đang Đăng Nhập Với Tài Khoản: <?php echo $_SESSION['username'];?></h3>
		<div id="btntopelement">
			<?php
					if($_SESSION['typeuser'] == "1"){
				?>
					<p class="infoTop">User: </p>
					<p class="infoTop">Admin: </p>
					<p class="infoTop">Recruiter: </p>
					<p class="infoTop">JobSeeker: </p>
				<?php }?>
		<p style=" float: left; opacity: 0.3;font-size: 15px;font-weight: 100;">|</p>
		<p class="btntop" onclick="back()">Back</p>
		<p style=" float: left; opacity: 0.3;font-size: 15px;font-weight: 100;">|</p>
		<p class="btntop" onclick="logout()">Logout</p>
		</div>
		</div>

	</div>
	<?php
		if(!isset($_SESSION['username'])){
			header("Location:index.php");
		}
		if($_SESSION['typeuser']== "3"){
			$ch = curl_init();
	        curl_setopt($ch, CURLOPT_URL, "http://localhost:8080/RecruitmentSystem/recruitment/user/recruiter_history/");
	        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
	        curl_setopt($ch, CURLOPT_POST, 1);
	        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded')); // In Java: @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

	        $data = array('username'=>$_SESSION['username']);
	        curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
	        $output = curl_exec($ch);
	        $info = curl_getinfo($ch);
	        $arr = json_decode($output,true);
			?>
			<div id="main">
				<h1 >DANH SÁCH CÁC BÀI ĐĂNG CỦA BẠN</h1>
				<form method="POST">
					<button name="delete">delete</button>
					<button name="update">update</button>
					<table border="1" cellspacing="20dp" cellpadding="5dp">
						<tr>
							<td>postid</td>
							<td>name</td>
							<td>description</td>
							<td>salary</td>
							<td>date</td>
							<td>status</td>
							<td>carrer</td>
							<td>location</td>
							
						</tr>
					<?php
						foreach ($arr as $p) { ?>
							<tr>
								<td><?php echo $p['postsId']; ?></td>
								<td><?php echo $p['jobName']; ?></td>
								<td><?php echo $p['jobDescription'];?></td>
								<td><?php echo $p['salary'];?></td>
								<td><?php echo $p['date'];?></td>
								<td><?php echo $p['status'];?></td>
								<td><?php echo $p['careerid'];?></td>
								<td><?php echo $p['locationid'];?></td>
								<td><input type="radio" name="edit" value="<?php echo $p['postId']?>"></td>
							</tr>
						<?php }
					?>
					</table>
				</form>
			</div>
			<?php
		}
		else if($_SESSION['typeuser'] == "2"){
			?>
			<div align="center">
				<h1>DANH SÁCH CÁC BÀI ĐĂNG BẠN ĐÃ SUBMIT</h1>
			</div>
			<?php
			$ch = curl_init();
	        curl_setopt($ch, CURLOPT_URL, "http://localhost:8080/RecruitmentSystem/recruitment/user/joobseekerhis/");
	        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
	        curl_setopt($ch, CURLOPT_POST, 1);
	        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded')); // In Java: @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

	        $data = array('username'=>$_SESSION['username']);
	        curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
	        $output = curl_exec($ch);
	        $info = curl_getinfo($ch);
	        $arr = json_decode($output,true);
	        ?>
	        <div align="center">
	        	<table cellspacing="10dp" cellpadding="5dp" border="1">
	        			<tr>
	        				<td>postid</td>
	        				<td>status</td>
	        				<td>feedback</td>
	        			</tr>
	        		<?php
	        		foreach ($arr as $key) {
	        		?>
	        			<tr>
	        				<td><?php echo $key['postid']; ?></td>
	        				<td><?php echo $key['status']; ?></td>
	        				<td><?php echo $key['feedback']; ?></td>
	        			</tr>
	        			<?php }
	        			?>
	        	</table>
	        </div>
	        <?php
		}
		else if($_SESSION['typeuser'] == "1"){
			?>
			<?php
			$ch = curl_init();
	        curl_setopt($ch, CURLOPT_URL, "http://localhost:8080/RecruitmentSystem/recruitment/user/adminconfirm/");
	        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
	        curl_setopt($ch, CURLOPT_POST, 1);
	        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded')); // In Java: @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

	        $data = array('username'=>$_SESSION['username']);
	        curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
	        $output = curl_exec($ch);
	        $info = curl_getinfo($ch);
	        $arr = json_decode($output,true);
	        ?>
	        <div id="main">
	        	<h1>DANH SÁCH CÁC BÀI ĐANG ĐỢI DUYỆT</h1>
	        	<form action="confirm.php" method="POST">
		        	<table border="1">
		        		<?php 
		        		foreach ($arr as $array) {
		        			?>
		        			<input type="hidden" name="id" value="<?php echo $array['postsId'] ?>">
		        		<tr>
		        			<td>company_name: <?php echo $array['company_name']; ?></td>
				    		<td>company_addres: <?php echo $array['company_addres']; ?></td>
				    		<td>company_phone: <?php echo $array['company_phone']; ?></td>
				    		<td>jobDescription: <?php echo $array['jobDescription']; ?></td>
				    		<td>jobName: <?php echo $array['jobName']; ?></td>
				    		<td>jobPosition: <?php echo $array['jobPosition']; ?></td>
				    		<td>date: <?php echo $array['date']; ?></td>
				    		<td>jobRecruitment: <?php echo $array['jobRecruitment']; ?></td>
				    		<td>salary: <?php echo $array['salary']; ?></td>
				    		<td>otherInfor: <?php echo $array['otherInfor']; ?></td>
				    		<td>salary: <?php echo $array['salary']; ?></td>
				    		<td>otherInfor: <?php echo $array['otherInfor']; ?></td>
				    		<td><button type="submt">Duyệt</button></td>
		        		</tr>
		        		<?php
		        	}
		        	?>
		        	</table>
		        </form>
	        </div>
			<?php
		}
	?>
	<script >
		function logout(){
			window.location = "logout.php";
		}
		function back(){
			window.location = "index.php";
		}
	</script>
</body>
</html>