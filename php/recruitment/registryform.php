<!DOCTYPE html>
<html>
<head>
    <title></title>
       <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<!------ Include the above in your HEAD tag ---------->

<div class="container" id="wrap">
      <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form  method="post" accept-charset="utf-8" class="form" role="form">   <legend>Sign Up</legend>
                    <h4>It's free and always will be.</h4>
                    <div class="row">
                            <input type="text" name="name" value="" class="form-control input-lg" placeholder="Full name"  /> 
                    <input type="text" name="email" value="" class="form-control input-lg" placeholder="Your Email"  />
                    <input type="password" name="password" value="" class="form-control input-lg" placeholder="Password"  />
                    <input type="password" name="confirm_password" value="" class="form-control input-lg" placeholder="Confirm Password"  />                                    <div class="row">
                    
                    </div>
                     <label>Gender : </label>                    <label class="radio-inline">
                        <input type="radio" name="gender" value="M" id=male />                        Male
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="gender" value="F" id=female />                        Female
                    </label>
                    <br />
                    <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit">
                        Create my account</button>
            </form>          
             </div>
        </div>            
    </div>
    </div>
        <?php
        if(isset($_POST['name']) && isset($_POST['password']) && isset($_POST['confirm_password']) && isset($_POST['email'])){
            if($_POST['password'] == $_POST['confirm_password']){
                $ch = curl_init();
                curl_setopt($ch, CURLOPT_URL, "http://localhost:8080/RecruitmentSystem/recruitment/services/regsistryJobseeker/");
                curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
                curl_setopt($ch, CURLOPT_POST, 1);
                curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded')); // In Java: @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

                $data = array('username'=>$_POST['email'],'password'=>$_POST['password'],'name'=>$_POST['name']);
                curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
                $output = curl_exec($ch);
                $info = curl_getinfo($ch);
                if($output == "true"){
                    ?>
                    <script type="text/javascript">
                         alert("dang ki thanh cong!");
                        window.location = "index.php";
                    </script>
                    <?php
                }
                else{
                    ?>
                        <script type="text/javascript">
                            alert("dang ki khong thanh cong!");
                        </script>
                    <?php
                }
            }
        }
          ?>
</body>
</html>