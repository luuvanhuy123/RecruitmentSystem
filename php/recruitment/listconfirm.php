<?php
	session_start();
?>
<!DOCTYPE html>
<html>
<head>
		<link rel="stylesheet" type="text/css" href="css/table.css">
 	<link rel="stylesheet" type="text/css" href="css/button.css">
	<title></title>
</head>
<body>

	<?php
		if(!isset($_SESSION['username'])){
			header("Location:index.php");
		}
		if(isset($_POST['detail']) && isset($_POST['edit'])){
			?>
				<div align="center">
				<h1>DANH SACH CAC BAI DANG BAN DA NOP DON</h1>
			</div>
			<?php
			$ch = curl_init();
	        curl_setopt($ch, CURLOPT_URL, "http://localhost:8080/RecruitmentSystem/recruitment/user/listregis/");
	        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
	        curl_setopt($ch, CURLOPT_POST, 1);
	        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded')); // In Java: @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

	        $data = array('id'=>$_POST['edit']);
	        curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
	        $output = curl_exec($ch);
	        $info = curl_getinfo($ch);
	        $arr = json_decode($output,true);
	        ?>
	        <div align="center">
	        	<form method="POST" >
	        		<table cellspacing="10dp" cellpadding="5dp" border="1">
	        			<tr>
	        				<td>postid</td>
	        				<td>status</td>
	        				<td>email</td>
	        				<td>feedback</td>
	        				<td></td>
	        			</tr>
	        		<?php
	        		foreach ($arr as $key) {
	        		?>
	        			<tr>
	        				<td><?php echo $key['postid']; ?></td>
	        				<td><?php echo $key['status']; ?></td>
	        				<td><?php echo $key['email']; ?></td>
	        				<input type="hidden" name="postid" value="<?php echo $key['postid']; ?>">
	        				<input type="hidden" name="email" value="<?php echo $key['email']; ?>">
	        				<td><input type="text" name="feedback" ></td>
	        				<td><button name="connect" type="submit">lien he</button></td>
	        			</tr>
	        			<?php }
	        			?>
	        	</table>
	        	</form>
	        </div><?php
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
                        alert("duyet thanh khong thanh cong!");
                    </script>
                    <?php
                }
                else{
                    ?>
                        <script type="text/javascript">
                            alert("duyet khong thanh cong!");
                        </script>
                    <?php
                }
			}?>
	        <?php
		}
		if(isset($_POST['delete'])){
			echo "delete";
		}
		if(isset($_POST['update'])){
			echo "update";
		}
	?>
</body>
</html>