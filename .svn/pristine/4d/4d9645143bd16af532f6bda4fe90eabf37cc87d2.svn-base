<%@page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>今日汇总</title>
<script type="text/javascript" src="http://czhw.org:9190/resources/js/My97DatePicker/WdatePicker.js"></script>

<%@include file="/includes/common.jsp"%>
<script type="text/javascript">
	$(function() {

		$("#u_dg").datagrid({
			idField : 'id',
			iconCls : 'icon-userManage',
			striped : true,
			loadMsg : '数据正在加载中，请稍后.....',
			rownumbers : true,//行号
			singleSelect: true,
			url : 'trashInfo/listDayAllTrash',
			queryParams : {

			},
			//fit : true,
			//fitColumns : true,
			striped : true, //隔行变色 
			remoteSort : true,//数据在页面排序
			height : 500,
			width : 'auto',
			toolbar : [ {
				text : '查看详情',
				iconCls : 'icon-tip',
				handler : OpenDetailDialog
			} ],
			columns : [ [ {
				field : 'ck',
				checkbox : true
			},/* {
				sortable : 'true',
				field : 'id',
				title : '编号',
				width : 80,
				align : 'center'
			}, */{
				field : 'name',
				title : '餐饮企业',
				width : 250,
				align : 'center'
			},{
				field : 'area_name',
				title : '所属区域',
				width : 250,
				align : 'center',
				formatter : function(value, row, index) {
					if(value){
						var arr = value.split('/');
						return arr[arr.length-1];
					}else{
						return value;
					}
				}
			},{
				field : 'street_name',
				title : '街道地址',
				width : 200,
				align : 'center'
			},{
				field : 'dayPut',
				title : '产生量(kg)',
				width : 350,
				align : 'center'
			},{
				field : 'net_weight',
				title : '日均产生量(kg)',
				width : 180,
				align : 'center'
			},  {
				field : 'create_time',
				title : '日期',
				width : 300,
				align : 'center',
				formatter : function(value, row, index) {
					return getNowFormatDate(0);
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
		
		
		getCompany();
		
		//页面初始化结束--------------------------------------------------------------------		
	});
	
	

	var url;
	// 查看详情Dialog
	function OpenDetailDialog() {
		var selected = $('#u_dg').datagrid('getSelections');
		if (selected.length == 0) {
			$.messager.alert('系统消息', '请先勾选数据。',
					'info');
			return;
		}
		if (selected.length > 1) {
			$.messager.alert('系统消息', '一次只能查看一条数据。',
					'info');
			return;
		}
		
		$('#u_dialog').dialog("setTitle", '&nbsp;查看详情').dialog('center')
				.dialog('open');
		
		$('#detail').html('');
		selected[0].gross_weight_time = format(selected[0].gross_weight_time);
		selected[0].weight_time = format(selected[0].weight_time);
		selected[0].create_time = format(selected[0].create_time);
		$('#detail').append("<table class='detail' border='1' ><tr><td >餐饮企业</td><td colspan='3' Style='font-weight:bold;font-size:18px;color:#05a4d6;'>"+selected[0].name+"</td></tr><tr><td>所属区域</td><td>"+selected[0].area_name+"</td><td>地址</td><td>"+selected[0].street_name+"</td></tr><tr><td>车牌号</td><td>"+selected[0].vehicle_number+"</td><td>今日产生量</td><td>"+selected[0].dayPut+"</td></tr><tr><td>垃圾毛重(kg)</td><td>"+selected[0].gross_weight+"</td><td>毛重时间</td><td>"+selected[0].gross_weight_time+"</td></tr><tr><td>垃圾净重(kg)</td><td>"+selected[0].net_weight+"</td><td>称重时间</td><td>"+selected[0].weight_time+"</td></tr><tr><td>皮重(kg)</td><td>"+selected[0].tare_weight+"</td><td>记录时间</td><td>"+selected[0].create_time+"</td></tr></table>");
		/*
		
		<table class='detail' border='1' ><tr><td >餐饮企业</td><td colspan='3' Style='font-weight:bold;font-size:18px;'>"+麦当劳+"</td></tr><tr><td>所属区域</td><td>"+海淀区+"</td><td>地址</td><td>"+中南海南街25号+"</td></tr><tr><td>车牌号</td><td>"+64123131+"</td><td>桶编号</td><td>"+NO56413+"</td></tr><tr><td>垃圾毛重(kg)</td><td>"+641+"</td><td>毛重时间</td><td>"+2017.1.3 12:36:23+"</td></tr><tr><td>垃圾净重(kg)</td><td>"+641+"</td><td>称重时间</td><td>"+2017.1.3 12:36:23+"</td></tr><tr><td>皮重(kg)</td><td>"+641+"</td><td>记录时间</td><td>"+2017.1.3 12:36:23+"</td></tr></table>
		
		*/
	}


	// 关闭Dialog
	function closeDialog() {
		$('#u_dialog').dialog("close");
		//  清空idField(这一步，一定要做)   
		//$('#u_dg').datagrid('unselectAll');
		//clearTip();
		$('#u_dg').datagrid('reload');
	}
	
	// 查询
	function search() {
		//获取值
		var key_restId = $('#key_restId').combobox('getValue');
		 
		//提交表单，查询，dataGrid有个方法，直接向服务器发送请求
		$("#u_dg").datagrid('load', {
			key_company_id:key_restId
		});

		
	}
	
	function clearVal(){
		
		$('#key_restId').val('');
		 
		//提交表单，查询，dataGrid有个方法，直接向服务器发送请求
		$("#u_dg").datagrid('load', {
		});
		$('#key_restId').combobox('select','企业名称');//菜单项可以text或者id
	}
	
	//城市选择
	function getCity(val){
		var openUrl = 'restInfo/toCity?val='+val;	//弹出窗口的url
		var iWidth=800; //弹出窗口的宽度;
		var iHeight=600; //弹出窗口的高度;
		var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
		window.open(openUrl,"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft);
	}
	
	function getCompany(){
		$('#key_restId').combobox({   
		    url:'trashInfo/getCompanyList',  //这里设置你的后台链接，返回的json数据会自己解析写进下拉框
		    valueField:'id',   
		    textField:'name',
		    editable:false,
		    width:150,
		    onLoadSuccess:function(){////////////
		    	$('#key_restId').combobox('select','企业名称');//菜单项可以text或者id
		    	}
		});
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
	
	function format(value) {
		var unixTimestamp = new Date(value);
		return unixTimestamp.toLocaleString();
	}

</script>
<style>
.myinput {
	padding-left:5px;
	width:145px;
	height:20px;
	border-radius:5px;
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
</style>
</head>


<body class="easyui-layout">
	<div class="easyui-panel" id="utbar" style="height:180px;">
	
		<div style="margin-left: 5px;border-bottom:1px solid #fff;padding:15px 0;">
			<!-- <div style="margin-top:5px;">
				所属区域： 
				<input class="myinput" placeholder="请选择所属区域" onclick="getProvince()" id="key_area">
					<input id="area_name"  onclick="getCity(this.value)"
						type="text" class="myinput"  
					placeholder="请选择所属区域"  readonly="readonly"/>
			</div> -->
			<div style="margin-top:5px;">
				下拉选择： 
				<span onclick="getCompany()">
					<select id="key_restId"  style="height: 25px;line-height: 25px;width: 97px;border-radius:5px;border:none;">
						<option>企业名称</option>
					</select>
				</span>
				
				<br>
				<br>
				<a
					href="javascript:search()" class="easyui-linkbutton"
					iconCls='icon-search' plain="true">查询</a>&nbsp;&nbsp;
				<a
					href="javascript:clearVal()" class="easyui-linkbutton"
					iconCls='icon-cancel' plain="true">清空</a>
			</div>
			<!-- <div style="margin-top:5px;padding-bottom:5px;">
				收运日期：
				<input type="date" class="myinput" id="key_startDate" placeholder="收运起始时间" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true,readOnly:true,maxDate:'%y-%M-%d'})" 
							readonly="readonly">
				<input type="date" class="myinput" id="key_endDate" placeholder="收运截止时间" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true,readOnly:true,maxDate:'%y-%M-%d'})" 
							readonly="readonly">&nbsp;&nbsp;
				<a
					href="javascript:search()" class="easyui-linkbutton"
					iconCls='icon-search' plain="true">查询</a>&nbsp;&nbsp;
				<a
					href="javascript:clearVal()" class="easyui-linkbutton"
					iconCls='icon-cancel' plain="true">清空</a>
			</div> -->
		</div>
	</div>
	<!-- 数据 -->
	<div id="u_dg" style="margin-top:150px;"></div>
	<!-- toolbar工具栏 -->


	<!-- dialog -->
	<div id="u_dialog" class="easyui-dialog" iconCls="icon-userManage"
		modal="true" style="width: 570px; height: 450px; padding: 10px 20px"
		closed="true" buttons="#addbtn">

		<div id="detail" style="padding: 10px 30px 20px 30px;border:0px solid red;">
			
		</div>
	</div>
	<div id="addbtn">
		 <a href="javascript:closeDialog()"
			class="easyui-linkbutton" iconCls='icon-clear'>关闭</a>
	</div>
</body>

</html>