<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Kode is a Premium Bootstrap Admin Template, It's responsive, clean coded and mobile friendly">
  <meta name="keywords" content="bootstrap, admin, dashboard, flat admin template, responsive," />
  <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png" />
  <title>牧云数据 | 环卫餐厨</title>

  <!-- ========== Css Files ========== -->
  <link href="css/login.css" rel="stylesheet">
  <!-- ================================================
	jQuery Library
	================================================ -->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	
	<!-- ================================================
	Bootstrap Core JavaScript File
	================================================ -->
	<script src="js/bootstrap/bootstrap.min.js"></script>
	
	<!-- ================================================
	Plugin.js - Some Specific JS codes for Plugin Settings
	================================================ -->
	<script type="text/javascript" src="js/plugins.js"></script>
	
	<!-- ================================================
	Sweet Alert
	================================================ -->
	<script src="js/sweet-alert/sweet-alert.min.js"></script>
	
	<!-- ================================================
	Kode Alert
	================================================ -->
	<script src="js/kode-alert/main.js"></script>
	<script src="js/login.js"></script>
  <style type="text/css">
    body{background: #F5F5F5;}
    .login-form{
    	margin:8% auto;
    }
    .login-form form {
		    /* background: transparent; */
		    border: 1px solid #fff;
		    border-radius: 3px;
		    background-color: rgba(255,255,255,0.3);
		    
	    }
  </style>
  </head>
  <body>
  
  <iframe style="width: 100%;height: 100%;border-width: 0px;z-index:-999;position:absolute;" sandbox="allow-scripts allow-same-origin" id="mh" src="SpecialEffects/1.html"></iframe>
  
  <!-- START CONTAINER -->
<div class="container-padding">
   <!-- Start Row -->
  <div class="row">
    <!-- Start Panel -->
    <div class="col-md-12">

    <div class="login-form">
      <form id="login_form">
        <div class="top">
          <!-- <img src="img/b-logo.png" alt="icon" class="icon"> -->
          <h1><span style="color:#5cadff">牧云数据</span><span style="color:#fff"> | 环卫餐厨</span></h1>
          <h4 style="color:#fff;">环保 ● 科技 ● 智能</h4>
        </div>
        <div class="form-area">
          <div class="group">
            <input id="account" style="background-color:rgba(255,255,255,0.3);border:1px solid #fff;" name="userAccount" type="text" class="form-control" placeholder="账号">
            <i class="fa fa-user"></i>
          </div>
          <div class="group">
            <input id="password" style="background-color:rgba(255,255,255,0.3);border:1px solid #fff;" name="password" type="password" class="form-control" placeholder="密码">
            <i class="fa fa-key"></i>
          </div>
          <div class="checkbox checkbox-primary">
            <input id="checkbox" type="checkbox" >
            <label for="checkbox"> <span style="color:#fff">记住账号及密码</span></label>
          </div>
          <button id="submit" type="button" class="btn btn-default btn-block">登录</button>
        </div>
      </form>
      <!-- <div class="footer-links row">
        <div class="col-xs-6"><a href="#"><i class="fa fa-external-link"></i> 注册账号</a></div>
        <div class="col-xs-6 text-right"><a href="#"><i class="fa fa-lock"></i> 忘记密码</a></div>
      </div> -->
    </div>
    
    </div>
    </div>
    </div>
    
    

</body>
</html>