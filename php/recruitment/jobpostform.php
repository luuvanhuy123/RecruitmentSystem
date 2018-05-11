<?php
	session_start();
?>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/table.css">

	<title>post job</title>
</head>
</body>
	<?php
	 if(!isset($_SESSION['username'])){
	 	header("Location:index.php");
	 }
	 else{
	 	date_default_timezone_set('Asia/Ho_Chi_Minh');
   			$date = date('m/d/Y h:i:s a', time());
	 ?>
	<div align="center">
		<h2>XIN CHÀO <?php echo $_SESSION['username']; ?></h2>
		<h2>VUI LÒNG ĐIỀN THÔNG TIN VÀO FORM BÊN DƯỚI</h2>
		<form method="POST">
			<table cellpadding="5dp" cellspacing="20dp">
				<tr>
					<td>JOB NAME: </td>
					<td><input type="text" name="job_name" required=""></td>
				</tr>
				<tr>
					<td>JOB POSITION: </td>
					<td><input type="tetx" name="job_position" required=""></td>
				</tr>
				<tr>
					<td>JOB DESCRIPTION: </td>
					<td><textarea cols="50" rows="10" name="job_description" required=""></textarea></td>
				</tr>
				<tr>
					<td>JOB RECRUITMENT: </td>
					<td><textarea cols="50" rows="10" name="job_recruitment" required=""></textarea></td>
				</tr>
				<tr>
					<td>SALARY: </td>
					<td><input type="text" name="salary" required=""></td>
				</tr>
				<tr>
					<td>BENAFIT: </td>
					<td><input type="text" name="benafit"></td>
				</tr>
				<tr>
					<td>Other information: </td>
					<td><textarea cols="70" rows="15" name="other_inf"></textarea></td>
				</tr>
				<tr>
					<td>CARRER: </td>
					<td><select name="carrer" required="">
						<option value="1">Kinh doanh</option>
						<option value="2">Bán hàng</option>
						<option value="3">Chăm sóc khách hàng</option>
						<option value="4">Lao động phổ thông</option>
						<option value="5">Tài chính /kế toán/kiểm toán</option>
						<option value="6">Sinh viên/Mới tốt nghiệp/ Thực tập</option>
						<option value="7">Hành chính/Thư ký /Trợ Lý</option>
						<option value="8">Quảng cáo /Merketing/PR</option>
						<option value="9">Cơ khí /Kĩ thuật ứng dụng</option>
						<option value="10">Báo chí /Biên tập</option>
						<option value="11">Bảo vệ/vệ sĩ/An ninh</option>
						<option value="12">Bất động sản</option>
						<option value="13">Biên dịch/Phiên dịch</option>
						<option value="14">Bưu Chính viễn thông</option>
						<option value="15">Công Nghệ thông tin</option>
						<option value="16">Dầu khí / Địa chất</option>
						<option value="17">Dệt may</option>
						<option value="18">Điện/Điện lạnh/Điện Điện tử</option>
						<option value="19">Du Lịch/Nhà hàng /Khách sạn</option>
						<option value="20">Dược/Hóa chất/Sinh hóa</option>
						<option value="21">Giải trí /Vui chơi</option>
						<option value="22">Giáo dục /đào tạo/Thư viện</option>
						<option value="23">Giao thông vận tải /Cầu đường/Thủy lợi</option>
						<option value="24">Giày da/Thuộc gia Khác</option>
						<option value="25">Kho vận/vật tư/Thu mua</option>
						<option value="26">Khu chế xuất/khu công nghiệp</option>
						<option value="27">Kiến trúc nội thất</option>
						<option value="28">Làm đẹp/Gym/Spa</option>
						<option value="29">Luật/Pháp lý</option>
						<option value="30">Môi trường/xử lý địa chất</option>
						<option value="31">Mỹ phẩm/thời trang/trang sức</option>
						<option value="32">Ngân hàng/Chứng khoán/đầu tư</option>
						<option value="33">Nghệ thuật /điện ảnh</option>
						<option value="34">Ngoại Ngữ </option>
						<option value="35">Nhân sự</option>
						<option value="36">Nông/Lâm/ngư nghiệp</option>
						<option value="37">PG/PB/Lễ tân</option>
						<option value="38">Phát triển thị trường</option>
						<option value="39">Phục vụ /tạp vụ/Giúp việc</option>
						<option value="40">Quan hệ đối ngoại</option>
						<option value="41">Quản lý điều hành</option>
						<option value="42">Sản xuất/Vận hành sản xuất</option>
						<option value="43">Tài xế /lái xe/Giao Nhận</option>
						<option value="44">Thẩm định/Giám Định/Quản lý chất lượng</option>
						<option value="45">Thể dục/ thể thao</option>
						<option value="46">Thiết kế/Mỹ thuật</option>
						<option value="47">Thời vụ/Bán thời gian</option>
						<option value="48">Thực phẩm /dịch vụ ăn uống</option>
						<option value="49">Trang thiết bị công nghiệp</option>
						<option value="50">Trang thiết bị gia dụng</option>
						<option value="51">Trang thiết văn phòng</option>
						<option value="52">Tư vấn bảo hiểm</option>
						<option value="53">Xây dựng</option>
						<option value="54">Xuất nhập khẩu/Ngoại thương</option>
						<option value="55">Y Tế</option>
					</section>
				</td>
				</tr>
				<tr>
					<td>location</td>
					<td>
						<select name="location" required="">
							<option value="1">An Giang</option>
							<option value="2">Bà Rịa-Vũng Tàu</option>
							<option value="3">Bạc Liêu</option>
							<option value="4">Bắc Kạn</option>
							<option value="5">Bắc Giang</option>
							<option value="6">Bắc Ninh</option>
							<option value="7">Bến Tre</option>
							<option value="8">Bình Dương</option>
							<option value="9">Bình Định</option>
							<option value="10">Bình Phước</option>
							<option value="11">Bình Thuận</option>
							<option value="12">Cà Mau</option>
							<option value="13">Cao Bằng</option>
							<option value="14">Cần Thơ (TP)</option>
							<option value="15">Đà Nẵng (TP)</option>
							<option value="16">Đắk Lắk</option>
							<option value="17">Đắk Nông</option>
							<option value="18">Điện Biên</option>
							<option value="19">Đồng Nai</option>
							<option value="20">Đồng Tháp</option>
							<option value="21">Gia Lai</option>
							<option value="22">Hà Giang</option>
							<option value="23">Hà Nam</option>
							<option value="24">Hà Nội (TP)</option>
							<option value="25">Hà Tây</option>
							<option value="26">Hà Tĩnh</option>
							<option value="27">Hải Dương</option>
							<option value="28">Hải Phòng (TP)</option>
							<option value="29">Hòa Bình</option>
							<option value="30">Hồ Chí Minh (TP)</option>
							<option value="31">Hậu Giang</option>
							<option value="32">Hưng Yên</option>
							<option value="33">Khánh Hòa</option>
							<option value="34">Kiên Giang</option>
							<option value="35">Kon Tum</option>
							<option value="36">Lai Châu</option>
							<option value="37">Lào Cai</option>
							<option value="38">Lạng Sơn</option>
							<option value="39">Lâm Đồng</option>
							<option value="40">Long An</option>
							<option value="41">Nam Định</option>
							<option value="42">Nghệ An</option>
							<option value="43">Ninh Bình</option>
							<option value="44">Ninh Thuận</option>
							<option value="45">Phú Thọ</option>
							<option value="46">Phú Yên</option>
							<option value="47">Quảng Bình</option>
							<option value="48">Quảng Nam</option>
							<option value="49">Quảng Ngãi</option>
							<option value="50">Quảng Ninh</option>
							<option value="51">Quảng Trị</option>
							<option value="52">Sóc Trăng</option>
							<option value="53">Sơn La</option>
							<option value="54">Tây Ninh</option>
							<option value="55">Thái Bình</option>
							<option value="56">Thái Nguyên</option>
							<option value="57">Thanh Hóa</option>
							<option value="58">Thừa Thiên - Huế</option>
							<option value="59">Tiền Giang</option>
							<option value="60">Trà Vinh</option>
							<option value="61">Tuyên Quang</option>
							<option value="62">Vĩnh Long</option>
							<option value="63">Vĩnh Phúc</option>
							<option value="64">Yên Bá</option>
					</section>
				</td>
				</tr>
			</table>
			<button type="submit">POST</button>
		</form>
		<?php
		   date_default_timezone_set('Asia/Ho_Chi_Minh');
   			$date = date('m/d/Y h:i:s a', time());
		if(isset($_POST['job_name']) && isset($_POST['job_position']) && isset($_POST['job_description']) && isset($_POST['job_recruitment']) && isset($_POST['carrer']) && isset($_POST['benafit']) && isset($_POST['other_inf']) && isset($_POST['location']) && isset($_POST['salary']) ){
				$ch = curl_init();
				curl_setopt($ch, CURLOPT_URL, "http://localhost:8080/RecruitmentSystem/recruitment/user/post/");
		        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
		        curl_setopt($ch, CURLOPT_POST, 1);
		        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded')); // In Java: @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		        $data = array('job_name'=>$_POST['job_name'],'job_position'=>$_POST['job_position'],'job_description'=>$_POST['job_description'],'job_recruitment'=>$_POST['job_recruitment'],'salary'=>$_POST['salary'],'benafit'=>$_POST['benafit'],'other_inf'=>$_POST['other_inf'],'date'=>$date,'carrer'=>$_POST['carrer'],'location'=>$_POST['location'],'username'=>$_SESSION['username']);
		        curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
		        $output = curl_exec($ch);
		        $info = curl_getinfo($ch);
		        if ($output == "true") {
		        	?>
		        	<script type="text/javascript">
		        		window.location = "index.php";
		        	</script>
		        	<?php
		        }
		        else{
		        	?>
		        	<script type="text/javascript">
		        		window.location = "jobpostform.php";
		        	</script>
		        	<?php
		        }
		}
		?>
	</div>
	<?php } ?>
</body>
</html>