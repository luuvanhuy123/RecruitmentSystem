<?php
	session_start();
?>
<!DOCTYPE html>
<html>
<head>
	<title>history</title>
</head>
<body>
	<div align="right">
		<h3>ban dang dang nha voi tai khoan <?php echo $_SESSION['username'];?></h3>
		<button onclick="back()">BACK</button>
		<button onclick="logout()">LOGOUT</button>
	</div>
	<?php
		if(!isset($_SESSION['username'])){
			header("Location:index.php");
		}
		if($_SESSION['typeuser']== "1"){
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
			<div align="center">
				<h1>DANH SACH CAC BAI DANG CUA BAN</h1>
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
				<h1>DANH SACH CAC BAI DANG BAN DA NOP DON</h1>
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
		else if($_SESSION['typeuser'] == "3"){
			?>
			<h1>DANH SACH CAC BAI DANG DANG CAN DUOC DUYET</h1>
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
	        <div>
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
				    		<td><button type="submt">duyet</button></td>
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