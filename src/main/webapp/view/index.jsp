<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html >
<html>
  <head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png" />
  <title>系统详情</title>

  <!-- ========== Css Files ========== -->
  <link href="css/index.css" rel="stylesheet">
  <script type="text/javascript" src="js/jquery.min.js"></script>
  
  <style>
  	html { overflow-x: hidden;overflow-y: hidden; }
  </style>
  
  <script>

  </script>

  </head>
  <body>
  <!-- Start Page Loading -->
  <div class="loading"><img src="img/loading.gif" alt="loading-img"></div>
  <!-- End Page Loading -->
  <!-- START TOP -->
  <div id="top" class="clearfix">

    <!-- Start App Logo -->
    <div class="applogo">
      <a href="index" class="logo">牧云<span style="color:#000">数据</span></a>
    </div>
    <!-- End App Logo -->

    <!-- Start Sidebar Show Hide Button -->
    <a href="javascript:void(0)" class="sidebar-open-button"><i class="fa fa-bars"></i></a>
    <a href="javascript:void(0)" class="sidebar-open-button-mobile"><i class="fa fa-bars"></i></a>
    <!-- End Sidebar Show Hide Button -->


    <ul class="top-right">


    <li class="dropdown link">
      <a href="#" data-toggle="dropdown" class="dropdown-toggle profilebox"><img src="img/profileimg.jpg" alt="img"><b>Hi,${user.userAccount}</b><span class="caret"></span></a>
        <ul class="dropdown-menu dropdown-menu-list dropdown-menu-right">

          <!--<li class="divider"></li> -->
          <!-- <li><a href="/moving2cq/menu/lock"><i class="fa falist fa-lock"></i>锁屏</a></li> -->
          <li><a href="/moving2cq/logout"><i class="fa falist fa-power-off"></i>退出系统</a></li>
        </ul>
    </li>

    </ul>
    <!-- End Top Right -->

  </div>
  <!-- END TOP -->


<!-- START SIDEBAR -->
<div class="sidebar clearfix">

<ul class="sidebar-panel nav">
  <li class="sidetitle">Main</li>
  <li><a href="javascript:void(0)" onclick="redirect('menu/main');"><span class="icon color5"><i class="fa fa-home"></i></span>主页<!-- <span class="label label-default">2</span> --></a></li>
  <li><a href="javascript:void(0)" ><span class="icon color7"><i class="fa fa-bar-chart-o"></i></span>基础信息管理<span class="caret"></span></a>
    <ul>
      <c:if test="${user.userAccount=='admin' }"><li><a onclick="redirect('menu/userOperate');" href="javascript:;">用户信息管理</a></li></c:if>
      <li><a onclick="redirect('menu/restaurantOperate');" href="javascript:;">企业信息管理</a></li>
      <li><a onclick="redirect('menu/rfidOperate');" href="javascript:;">RFID电子标签管理</a></li>
      <li><a onclick="redirect('menu/bucketOperate');" href="javascript:;" >餐厨桶信息管理</a></li>
      <!-- <li><a onclick="redirect('menu/driverOperate');" href="javascript:;">司机信息管理</a></li> -->
      <li><a onclick="redirect('menu/carOperate');" href="javascript:;">车辆信息管理</a></li>
    </ul>
  </li>
  <li><a href="javascript:void(0)" ><span class="icon color7"><i class="fa fa-table"></i></span>餐厨信息列表<span class="caret"></span></a>
    <ul>
      <li><a onclick="redirect('menu/history');" href="javascript:;">历史数据</a></li>
      <li><a onclick="redirect('menu/dataAnalysis');" href="javascript:;">数据分析</a></li>
      <li><a onclick="redirect('menu/collect');" href="javascript:;">今日汇总</a></li>
    </ul>
  </li>
  <li><a href="javascript:void(0)" ><span class="icon color7"><i class="fa fa-map-marker"></i></span>地图相关数据<span class="caret"></span></a>
    <ul>
      <li><a onclick="redirect('menu/program');" href="javascript:;">车辆路线规划</a></li>
      <li><a onclick="redirect('menu/listLine');" href="javascript:;">车辆路线列表</a></li>
      <li><a onclick="redirect('menu/real');" href="javascript:;">车辆实时数据</a></li>
    </ul>
  </li>
</ul>

<ul class="sidebar-panel nav">
  <li class="sidetitle">More</li>
  <li><a href="grid.html"><span class="icon color15"><i class="fa fa-columns"></i></span>Grid System</a></li>
</ul>

<div class="sidebar-plan">
  Pro Plan<a href="javascript:void(0)" class="link">Upgrade</a>
  <div class="progress">
  <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
  </div>
</div>
<span class="space">42 GB / 100 GB</span>
</div>

</div>
<!-- END SIDEBAR -->


<!-- <iframe style="margin-top:3%;" id="mainframe" src="menu/main"  scrolling="auto" width="100%" onload="changeFrameHeight()" frameborder="0"></iframe>
 -->
<iframe id="mainframe" name="mainframe" marginwidth="0" marginheight="0" src="menu/main" frameborder="0" width="100%" scrolling="auto" height="100%"></iframe>
<script>

function redirect(url){
	document.getElementById('mainframe').src =url;
}
$(window.parent.document).find("#mainframe").load(function(){
	var main = $(window.parent.document).find("#mainframe");
	var thisheight = $(document).height()+30;
	main.height(thisheight);
});
window.onresize=function(){
	var main = $(window.parent.document).find("#mainframe");
	var thisheight = $(document).height()+30;
	main.height(thisheight);
}
</script>


<!-- ================================================
jQuery Library
================================================ -->


<!-- ================================================
Bootstrap Core JavaScript File
================================================ -->
<script src="js/bootstrap/bootstrap.min.js"></script>

<!-- ================================================
Plugin.js - Some Specific JS codes for Plugin Settings
================================================ -->
<script type="text/javascript" src="js/plugins.js"></script>

<!-- ================================================
Bootstrap Select
================================================ -->
<script type="text/javascript" src="js/bootstrap-select/bootstrap-select.js"></script>

<!-- ================================================
Bootstrap Toggle
================================================ -->
<script type="text/javascript" src="js/bootstrap-toggle/bootstrap-toggle.min.js"></script>

<!-- ================================================
Flot Chart
================================================ -->
<!-- main file -->
<script type="text/javascript" src="js/flot-chart/flot-chart.js"></script>
<!-- time.js -->
<script type="text/javascript" src="js/flot-chart/flot-chart-time.js"></script>
<!-- stack.js -->
<script type="text/javascript" src="js/flot-chart/flot-chart-stack.js"></script>
<!-- pie.js -->
<script type="text/javascript" src="js/flot-chart/flot-chart-pie.js"></script>
<!-- demo codes -->
<script type="text/javascript" src="js/flot-chart/flot-chart-plugin.js"></script>


<!-- ================================================
Easy Pie Chart
================================================ -->
<!-- main file -->
<script type="text/javascript" src="js/easypiechart/easypiechart.js"></script>
<!-- demo codes -->
<script type="text/javascript" src="js/easypiechart/easypiechart-plugin.js"></script>

<!-- ================================================
Sparkline
================================================ -->
<!-- main file -->
<script type="text/javascript" src="js/sparkline/sparkline.js"></script>
<!-- demo codes -->
<script type="text/javascript" src="js/sparkline/sparkline-plugin.js"></script>

<!-- ================================================
Rickshaw
================================================ -->
<!-- d3 -->
<script src="js/rickshaw/d3.v3.js"></script>
<!-- main file -->
<script src="js/rickshaw/rickshaw.js"></script>
<!-- demo codes -->
<script src="js/rickshaw/rickshaw-plugin.js"></script>

<!-- ================================================
Moment.js
================================================ -->
<script type="text/javascript" src="js/moment/moment.min.js"></script>


<!-- ================================================
Below codes are only for index widgets
================================================ -->
<!-- Today Sales -->
<script>

// set up our data series with 50 random data points

var seriesData = [ [], [], [] ];
var random = new Rickshaw.Fixtures.RandomData(20);

for (var i = 0; i < 110; i++) {
  random.addData(seriesData);
}

// instantiate our graph!

var graph = new Rickshaw.Graph( {
  element: document.getElementById("todaysales"),
  renderer: 'bar',
  series: [
    {
      color: "#33577B",
      data: seriesData[0],
      name: 'Photodune'
    }, {
      color: "#77BBFF",
      data: seriesData[1],
      name: 'Themeforest'
    }, {
      color: "#C1E0FF",
      data: seriesData[2],
      name: 'Codecanyon'
    }
  ]
} );

graph.render();

var hoverDetail = new Rickshaw.Graph.HoverDetail( {
  graph: graph,
  formatter: function(series, x, y) {
    var date = '<span class="date">' + new Date(x * 1000).toUTCString() + '</span>';
    var swatch = '<span class="detail_swatch" style="background-color: ' + series.color + '"></span>';
    var content = swatch + series.name + ": " + parseInt(y) + '<br>' + date;
    return content;
  }
} );

</script>

<!-- Today Activity -->
<script>
// set up our data series with 50 random data points

var seriesData = [ [], [], [] ];
var random = new Rickshaw.Fixtures.RandomData(20);

for (var i = 0; i < 50; i++) {
  random.addData(seriesData);
}

// instantiate our graph!

var graph = new Rickshaw.Graph( {
  element: document.getElementById("todayactivity"),
  renderer: 'area',
  series: [
    {
      color: "#9A80B9",
      data: seriesData[0],
      name: 'London'
    }, {
      color: "#CDC0DC",
      data: seriesData[1],
      name: 'Tokyo'
    }
  ]
} );

graph.render();

var hoverDetail = new Rickshaw.Graph.HoverDetail( {
  graph: graph,
  formatter: function(series, x, y) {
    var date = '<span class="date">' + new Date(x * 1000).toUTCString() + '</span>';
    var swatch = '<span class="detail_swatch" style="background-color: ' + series.color + '"></span>';
    var content = swatch + series.name + ": " + parseInt(y) + '<br>' + date;
    return content;
  }
} );
</script>



</body>
</html>