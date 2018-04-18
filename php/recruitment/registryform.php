<!DOCTYPE html>
<html>
<head>
	<title>registry form</title>
</head>
<body>
	<div>
		<form method="POST" id="registryform">
			<button type="submit" name="jobseeker">JOB SEEKER</button>
			<button type="submit" name="recruiter">RECRUITER</button>
		</form>
	</div>
	<?php
	if (isset($_POST['jobseeker'])) {?>
		<script>
          var child = document.getElementById("registryform");
          child.parentNode.remove(child);
        </script>
        <h2>NHAP THONG VAO FORM BEN DUOI</h2>
        <form method="POST">
        	USERNAME: <input type="text" name="username"><br/>
			PASSWORD: <input type="password" name="password"><br/>
			PASSWORD: <input type="password" name="password1"><br/>
			<button type="submit" name="post">REGISTRY</button>
        </form>
	<?php
		if(isset($_POST['post'])){
	     	$ch = curl_init();
	        curl_setopt($ch, CURLOPT_URL, "http://localhost:8080/bookStore/book/Services/Buy/");
	        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
	        curl_setopt($ch, CURLOPT_POST, 1);
	        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded')); // In Java: @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	        $data = array('username'=>$_SESSION['username'],'book_ID'=>$_POST['book_ID'],'date_buy'=>$date);
	        curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
	        $output = curl_exec($ch);
	        $info = curl_getinfo($ch);
	        curl_close($ch);
	        if ($output=="2") {
	        	# code...
	        }
	        else{
	        	
	        }
		}
	}
	if(isset($_POST['recruiter'])){?>
		<script>
          var child = document.getElementById("registryform");
          child.parentNode.remove(child);
        </script>
         <h2>NHAP THONG VAO FORM BEN DUOI</h2>
        <form method="POST">
        	NAME:<input type="text" name="name" required=""><br>
        	email: <input type="text" name="email" required=""><br/>
        	sex: <input type="" name="sex" required=""><br/>
        	address:<input type="text" name="address" required=""><br/>
        	company_name:<input type="text" name="company_name" required=""><br/>
        	company_address:<input type="text" name="company_address" required=""><br/>
        	company_phone: <input type="text" name="company_phone" required=""><br/>
        	company_inf:<input type="text" name="company_inf" required=""><br/>
			PASSWORD: <input type="password" name="password" required=""><br/>
			PASSWORD: <input type="password" name="password1" required=""><br/>
			<button type="submit" name="post">REGISTRY</button>
        </form>
     <?php
     if(isset($_POST['post'])){
     	$ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, "http://localhost:8080/bookStore/book/Services/Buy/");
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_POST, 1);
        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded')); // In Java: @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        $data = array('username'=>$_SESSION['username'],'book_ID'=>$_POST['book_ID'],'date_buy'=>$date);
        curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
        $output = curl_exec($ch);
        $info = curl_getinfo($ch);
        curl_close($ch);
        if ($output=="1") {
        	# code...
        }
        else{

        }
     }
	}
	?>
</body>
</html>