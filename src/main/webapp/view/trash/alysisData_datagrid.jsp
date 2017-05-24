<%@page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>历史记录</title>
<script type="text/javascript" src="http://czhw.org:9190/resources/js/My97DatePicker/WdatePicker.js"></script>

<%@include file="/includes/common.jsp"%>
<script type="text/javascript">
	$(function() {
		
		$('#key_startDate').val(getNowFormatDate(7));
		$('#key_endDate').val(getNowFormatDate(0));
		
		$("#u_dg").datagrid({
			idField : 'id',
			iconCls : 'icon-userManage',
			striped : true,
			loadMsg : '数据正在加载中，请稍后.....',
			rownumbers : true,//行号
			singleSelect: true,
			url : 'trashInfo/analysisTrashByDate',
			queryParams : {
				key_shopId:$('#shopId').val(),
				key_company : $('#key_company').val(),
				key_startDate:$('#key_startDate').val(),
				key_endDate:$('#key_endDate').val(),
				dayNum:7
			},
			//fit : true,
			fitColumns : true,
			striped : true, //隔行变色 
			remoteSort : true,//数据在页面排序
			height : 450,
			width : 'auto',
			columns : [ [{
				field : 'name',
				title : '餐饮企业',
				width : 250,
				align : 'center'
			},{
				field : 'dayPut',
				title : '当日产生量(kg)',
				width : 130,
				align : 'center',
				formatter : function(value, row, index) {
					if(!value){
						return "0";
					}else{
						return value;
					}
				}
			},{
				field : 'net_weight',
				title : '近期平均量(kg)',
				width : 130,
				align : 'center',
					formatter : function(value, row, index) {
						if(!value){
							return "0";
						}else{
							return value;
						}
					}
			},{
				field : 'last_used_barrel',
				title : '拥有桶数',
				width : 180,
				align : 'center',
			},{
				field : 'barrelNum',
				title : '收集桶数',
				width : 180,
				align : 'center'
			},{
				sortable : 'true',
				field : 'create_time',
				title : '记录日期',
				width : 300,
				align : 'center',
				formatter : function(value, row, index) {
					var unixTimestamp = new Date(value);
					return unixTimestamp.toLocaleDateString();
				}
			}
			] ],

			//分页
			pagination : true,
			pageSize : 15,
			pageList : [ 15, 25, 35, 45 ]
		});
		$('#u_dg').datagrid('getPager').pagination({
			displayMsg : '当前显示从{from}到{to}共{total}记录',
		});
		
		
		/* $('#u_dg').datagrid({
			onClickRow:function(index,data){
				var row=$('#u_dg').datagrid('getSelected');
				select_ticke_id = row.id;
				if(row){
						$('#company').html('【'+row.name+'】');
					}
				}
			}); */
		
		 /* if("\v"=="v"){//IE浏览器
			    document.getElementById("key_endDate").onpropertychange=toGet;
			   }else{ // 其他浏览器
			 	$("#key_endDate").on("keyup",toGet());
			   } */
		 
		//页面初始化结束--------------------------------------------------------------------		
	});
	
	function format(value) {
		var unixTimestamp = new Date(value);
		return unixTimestamp.toLocaleString();
	}
	
	function changeColor(id,col){
		$(id).css('background',col);
	}
	
	var i=0;
	window.onresize = function(){
		
		console.log(i++);
		window.location.reload();
	}
	var temp01;
	var temp02;
	
	function toGet(){
		
		var key_startDate = $("#key_startDate").val().trim();
		var key_endDate = $("#key_endDate").val().trim();
		temp01 = key_startDate;
		temp02 = key_endDate;
		if(key_startDate&&!key_endDate){
			$.messager.alert('系统消息', '您未选择截止日期!', 'info');
			return;
		}
		if(!key_startDate&&key_endDate){
			$.messager.alert('系统消息', '您未选择起始日期!', 'info');
			return;
		}
		if(key_startDate && key_endDate){
			var d1 = new Date(key_startDate.replace(/\-/g, "\/")); 
			var d2 = new Date(key_endDate.replace(/\-/g, "\/")); 
			if(d1 >=d2){ 

			  $('#key_startDate').val(getNowFormatDate(7));
			  $('#key_endDate').val(getNowFormatDate(0));
			  $.messager.alert('系统消息', '起始日期不能大于截止日期！', 'info');
			  return ; 
			 }
		}
		  var d = string2date(key_startDate);
		  var d2 = string2date(key_endDate);
		  var result = getDayNum(d,d2);
		//提交表单，查询，dataGrid有个方法，直接向服务器发送请求
			$("#u_dg").datagrid('load', {
				key_shopId:$('#shopId').val(),
				key_company : $('#key_company').val(),
				key_startDate:$('#key_startDate').val(),
				key_endDate:$('#key_endDate').val(),
				dayNum:result
			}); 
		  
	}
	
	function string2date(str){
		  return new Date(Date.parse(str.replace(/-/g,  "/")));
		}
	
	function getDayNum(d,d2){
		
		var year = d.getFullYear();
		var month = d.getMonth()+1;
		var date = d.getDate();
		var sDate = year+"-"+month+"-"+ date;
		
		var year2 = d2.getFullYear();
		var month2 = d2.getMonth()+1;
		var date2 = d2.getDate();
		var eDate = year2+"-"+month2+"-"+ date2;
		
		var sArr = sDate.split("-");
		var eArr = eDate.split("-");
		var sRDate = new Date(sArr[0], sArr[1], sArr[2]);
		var eRDate = new Date(eArr[0], eArr[1], eArr[2]);
		var result = (eRDate-sRDate)/(24*60*60*1000);
		return result;
	}
	
	function getNowFormatDate(i) {
	    var date = new Date();
	    var seperator1 = "-";
	    var seperator2 = ":";
	    var month = date.getMonth() + 1;
	    var strDate = date.getDate()-i;
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
	    return currentdate;
	} 

</script>
<style>
.myinput {
	padding-left:5px;
	width:95px;
	height:20px;
	border-radius:3px;
	margin-top:-3px;
}
.allArea01{
	margin-top:5px;
	float:left;
	height:45px;
	width:15%;
	border-radius:5px;
	background:#2aa7df;
	padding:5px;
	margin-right:3px;
}
.detail{
	width:100%;margin:0 auto;text-align:left;font-size:12px;
}
.detail td{
	padding:5px;
}
.btn{
	float:left;
	width:65px;
	padding:3px 5px;
	border-radius:5px;
	background:#2aa7df;
	cursor:pointer;
	border:none;
	margin-left:6px;
}
</style>
</head>


<body class="easyui-layout">
	<div class="easyui-panel" id="utbar" style="height:235px;width:100%;">
		<div >
			<div style="width:100%;height:100px;font-size:16px;padding-top:35px;border-top:1px solid #fff;border-bottom:1px solid #fff;text-align:left;">
				<div>
					<span>&nbsp;&nbsp;餐饮企业:<input id="key_company" type="text" value="${shopName }" class="myinput" readonly="readonly"></span>
					<input type="hidden" value="${shopId }" id="shopId">
					<span >&nbsp;&nbsp;收运日期:
						<input style="width:80px;" id="key_startDate" type="date" class="myinput" id="key_startDate" placeholder="收运起始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false,readOnly:true,maxDate:'%y-%M-%d',onpicked:toGet})" 
							readonly="readonly">&nbsp;&nbsp;至
						<input style="width:80px;" id="key_endDate" type="date" class="myinput" id="key_endDate" placeholder="收运截止日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false,readOnly:true,maxDate:'%y-%M-%d',onpicked:toGet})" 
									readonly="readonly">						
					</span>
				</div>	
					<span id="list" onmouseover="changeColor('#list','rgb(13, 156, 55)');" onmouseout="changeColor('#list','#2aa7df');" class="btn">列表显示</span>
					&nbsp;&nbsp;
					<span id="chart" class="btn" onmouseover="changeColor('#chart','rgb(13, 156, 55)');" onmouseout="changeColor('#chart','#2aa7df');">图表显示</span>
			</div>
		</div>
	</div>
	<!-- 数据 -->
	<div id="u_dg" style="margin-top:28%;"></div>
	<!-- toolbar工具栏 -->

</body>

</html>