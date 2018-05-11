<?php
	session_start();
?>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/table.css">
 	<link rel="stylesheet" type="text/css" href="css/button.css">
	<title>history</title>
</head>
<body>
	<div align="right">
		<h3>Bạn Đang Đăng Nhập Với Tài Khoản: <?php echo $_SESSION['username'];?></h3>
		<button class="gradient-button gradient-button-1" onclick="back()">BACK</button>
		<button class="gradient-button gradient-button-1" onclick="logout()">LOGOUT</button>
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
				<h1>DANH SÁCH CÁC BÀI ĐĂNG CỦA BẠN</h1>
				<form method="POST" action="listconfirm.php">
					<button class="gradient-button gradient-button-1" name="delete" name="delete">delete</button>
					<button class="gradient-button gradient-button-1" name="update" name="update">update</button>
					<button class="gradient-button gradient-button-1" name="detail" type="submit" name="detail">Detail</button>
					<table border="1" cellspacing="20dp" cellpadding="5dp">
						<tr>
							<td>postid</td>
							<td>name</td>
							<td>description</td>
							<td>salary</td>
							<td>date</td>
							
						</tr>
					<?php
						foreach ($arr as $p) { ?>
							<tr>
								<td><?php echo $p['postsId']; ?></td>
								<td><?php echo $p['jobName']; ?></td>
								<td><?php echo $p['jobDescription'];?></td>
								<td><?php echo $p['salary'];?></td>
								<td><?php echo $p['date'];?></td>
								<td><input type="radio" name="edit" value="<?php echo $p['postsId'];?>"></td>
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
		else if($_SESSION['typeuser'] == "3"){
			?>
			<h1 align="center">DANH SÁCH CÁC BÀI ĐANG ĐỢI DUYỆT</h1>
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
	        <div class="container" id="main">

	        	<form action="confirm.php" method="POST">
	        			 
		        	<table border="1">
		        			<tr>
							      <td>company_name</td>
							      <td>company_addres</td>
							      <td>jobName</td>
							      <td>date</td>
							      <td>salary</td>
							      <td>jobPosition</td>
							      <td>jobDescription</td>
							      <td></td>
							  </tr>
		        		<?php 
		        		foreach ($arr as $array) {
		        			?>
		        			<input type="hidden" name="id" value="<?php echo $array['postsId'] ?>">
		        		<tr>
		        				<td><?php echo $array['company_name']; ?></td>
							      <td><?php echo $array['company_addres']; ?></td>
							      <td><?php echo $array['jobName']; ?></td>
							      <td><?php echo $array['date']; ?></td>
							      <td><?php echo $array['salary']; ?></td>
							      <td><?php echo $array['jobPosition']; ?></td>
							      <td><?php echo $array['jobDescription']; ?></td>
							      <td><button class="gradient-button gradient-button-1" type="submit">Duyệt</button></td>
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