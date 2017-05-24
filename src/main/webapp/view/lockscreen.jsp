<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Kode is a Premium Bootstrap Admin Template, It's responsive, clean coded and mobile friendly">
  <meta name="keywords" content="bootstrap, admin, dashboard, flat admin template, responsive," />
  <title>锁屏页</title>

  <!-- ========== Css Files ========== -->
  <link href="css/root.css" rel="stylesheet">
  <!--jQuery Library
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
	<script src="js/lock.js"></script>
  <style type="text/css">
    body{
      background: #F5F5F5;
    }
  </style>
  </head>
  <body>

    <div class="login-form">
      <form id="lockForm">
        <div class="top">
	        <a href="login">
	          <img src="img/profileimg.jpg" alt="icon" class="icon profile">
	         </a>
          <h1>${user.userAccount}</h1>
          <h4>锁屏状态</h4>
        </div>
        <div class="form-area">
          <div class="group">
          	<input type="hidden" value="lock" name="type">
          	<input id="account" type="hidden" value="${user.userAccount}" name="userAccount">
            <input id="password" type="password" name="password" class="form-control" placeholder="登录密码">
            <i class="fa fa-key"></i>
          </div>
          <button id="submit" type="button" class="btn btn-default btn-block">解锁屏幕</button>
        </div>
      </form>
      <div class="footer-links row">
        <div class="col-xs-6"><a href="#"><i class="fa fa-external-link"></i> 注册账号</a></div>
        <div class="col-xs-6 text-right"><a href="#"><i class="fa fa-lock"></i> 忘记密码</a></div>
      </div>
    </div>

</body>
</html>