<%@page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>历史数据</title>
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
			url : 'trashInfo/listAllTrash',
			queryParams : {
				name : ''
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
			},{
				sortable : 'true',
				field : 'id',
				title : '编号',
				width : 80,
				align : 'center'
			},{
				sortable : 'true',
				field : 'area_name',
				title : '所属区域',
				width : 250,
				align : 'center'
			},{
				sortable : 'true',
				field : 'name',
				title : '餐饮企业',
				width : 250,
				align : 'center'
			},{
				field : 'vehicle_number',
				title : '车牌号',
				width : 200,
				align : 'center'
			},{
				field : 'bucket_code',
				title : '桶编号',
				width : 350,
				align : 'center'
			},{
				sortable : 'true',
				field : 'net_weight',
				title : '垃圾净重(kg)',
				width : 180,
				align : 'center'
			},  {
				sortable : 'true',
				field : 'create_time',
				title : '称重时间',
				width : 300,
				align : 'center',
				formatter : function(value, row, index) {
					var unixTimestamp = new Date(value);
					return unixTimestamp.toLocaleString();
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
		
		console.log(selected);
		$('#detail').html('');
		selected[0].gross_weight_time = format(selected[0].gross_weight_time);
		selected[0].weight_time = format(selected[0].weight_time);
		selected[0].create_time = format(selected[0].create_time);
		$('#detail').append("<table class='detail' border='1' ><tr><td >餐饮企业</td><td colspan='3' Style='font-weight:bold;font-size:18px;color:#05a4d6;'>"+selected[0].name+"</td></tr><tr><td>所属区域</td><td>"+selected[0].area_name+"</td><td>地址</td><td>"+selected[0].street_name+"</td></tr><tr><td>车牌号</td><td>"+selected[0].vehicle_number+"</td><td>桶编号</td><td>"+selected[0].bucket_code+"</td></tr><tr><td>垃圾毛重(kg)</td><td>"+selected[0].gross_weight+"</td><td>毛重时间</td><td>"+selected[0].gross_weight_time+"</td></tr><tr><td>垃圾净重(kg)</td><td>"+selected[0].net_weight+"</td><td>称重时间</td><td>"+selected[0].weight_time+"</td></tr><tr><td>皮重(kg)</td><td>"+selected[0].tare_weight+"</td><td>记录时间</td><td>"+selected[0].create_time+"</td></tr></table>");
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
		var key_area = $("#area_name").val().trim();
		var key_company = $("#key_company").val().trim();
		var key_startDate = $("#key_startDate").val().trim();
		var key_endDate = $("#key_endDate").val().trim();
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
			  $.messager.alert('系统消息', '起始日期不能大于截止日期！', 'info');
			  return ; 
			 }
		}
		//提交表单，查询，dataGrid有个方法，直接向服务器发送请求
		$("#u_dg").datagrid('load', {
			key_area : key_area,
			key_company:key_company,
			key_startDate:key_startDate,
			key_endDate:key_endDate
		});
		$('#allArea').html('<h3>此处可显示按区域汇总信息</h3>');
		$('#allDustbin').html('--');
		$('#allTrash').html('--');
		if(key_area.length<7){
			return;
		}
		//ajax请求
		$.ajax({
			url:'trashInfo/listByArea',
			type:'post',
			dataType:'json',
			cache:'false',
			data:{
				key_area : key_area,
				key_company:key_company,
				key_startDate:key_startDate,
				key_endDate:key_endDate
			},
			success:function(data) {
				
				if(data.length<1){
					$('#allArea').html('暂无记录');
					return;
				}
				var area;
				var restCount=0;
				var dustbinCount=0;
				var trashCount=0;
				var allDustbin = 0;
				var allTrash = 0
								
				if(key_area.length<9&&key_area.length>5){//当选择省市时需去重循环获取
					//去重
					var unique_area =getUnique(data,'area_name');
					
					var keyLength = key_area.length+1;
					for(var i=0;i<unique_area.rows.length;i++){
						area = unique_area.rows[i].area_name.substring(keyLength);
						//发送ajax获取每个区有几家企业
						$.ajax({
							url:'trashInfo/listByArea',
							type:'post',
							dataType:'json',
							cache:'false',
							data:{
								key_area : area,
								key_company:key_company
							},
							success:function(data) {
								console.log(data);
								//去重
								var unique_name = getUnique(data,'name');
								console.log(unique_name);
								var areaArr = new Array()
								areaArr = data[0].area_name.split('/');
								area = areaArr[2];
								restCount = unique_name.total;
								dustbinCount = data.length;
								allDustbin = allDustbin+dustbinCount;
								for(var j=0;j<data.length;j++){
									trashCount = trashCount + data[j].net_weight;
									allTrash = allTrash + data[j].net_weight;
								}
								$('#allArea').append("<div class='allArea01' ><table style='margin-top:-1%;' border='0' cell-padding='0' ><tr height='30px' style='border-bottom:1px solid #fff;''><td style='font-weight:bold;font-size:16px;'>"+area+"</td><td></td><td style='border-left:1px solid #fff;padding-left:5px;'>已收企业</td><td style=padding:0 5px;'>"+restCount+"</td></tr><tr><td >已收垃圾桶</td><td style='padding:0 5px;'>"+dustbinCount+"</td><td style='border-left:1px solid #fff;padding-left:5px;'>已收垃圾量(kg)</td><td style='padding:0 5px;'>"+trashCount+"</td></tr></table></div>")
								trashCount = 0;
								$('#allDustbin').html(allDustbin);
								$('#allTrash').html(allTrash);
								return;
							}
						});
						
					}
				}else{//当选择省市区时直接截取末尾区
					//去重
					var unique_name =getUnique(data,'name');
					restCount = unique_name.total;
					
					var areaArr = new Array()
					areaArr = key_area.split('/');
					area = areaArr[2];
					dustbinCount = data.length;
					for(var j=0;j<data.length;j++){
						trashCount = trashCount + data[j].net_weight;
					}
					$('#allArea').append("<div class='allArea01' ><table style='margin-top:-1%;' border='0' cell-padding='0' ><tr height='30px' style='border-bottom:1px solid #fff;''><td style='font-weight:bold;font-size:16px;'>"+area+"</td><td></td><td style='border-left:1px solid #fff;padding-left:5px;'>已收企业</td><td style=padding:0 5px;'>"+restCount+"</td></tr><tr><td >已收垃圾桶</td><td style='padding:0 5px;'>"+dustbinCount+"</td><td style='border-left:1px solid #fff;padding-left:5px;'>已收垃圾量(kg)</td><td style='padding:0 5px;'>"+trashCount+"</td></tr></table></div>")
					$('#allDustbin').html(dustbinCount);
					$('#allTrash').html(trashCount);
				}
				
			}
		});
	}
	//去重
	function getUnique(data,cloumn){
		$b = {"total":0,"rows":[]};
		var tem = data;
		var len = tem.length;
		var i=0;
		var arr = [];
		for(; i<len; i++){       
		    var t = tem[i];
		    if(arr.indexOf(t[cloumn]) ==-1){
		        arr.push(t[cloumn]);
		        $b.rows.push(t);
		        $b.total++;
		    }
		     
		}
		 
		return $b;
	}
	
	function clearVal(){
		//获取值
		$("#area_name").val("");
		$("#key_company").val("");
		$("#key_startDate").val("");
		$("#key_endDate").val("");
		// 刷新当前数据表格
		//$('#u_dg').datagrid('reload');
		$("#u_dg").datagrid('load', {
			
		});
		$('#allArea').html('<h3>此处可显示按区域汇总信息</h3>');
		$('#allDustbin').html('--');
		$('#allTrash').html('--');
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
	
	function getAddress(flag){
		$('#select').combobox({   
		    url:'rfid/listUnuseRfid',  //这里设置你的后台链接，返回的json数据会自己解析写进下拉框
		    valueField:'rfid',   
		    textField:'rfid',
		    editable:false
		});
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
	<div class="easyui-panel" id="utbar" style="height:280px;">
	
		<div style="margin-left: 5px">
			<div style="margin-top:5px;">
				所属区域： 
				<!-- <input class="myinput" placeholder="请选择所属区域" onclick="getProvince()" id="key_area"> -->
					<input id="area_name"  onclick="getCity(this.value)"
						type="text" class="myinput"  
					placeholder="请选择所属区域"  readonly="readonly"/>
			</div>
			<div style="margin-top:5px;">
				企业名称： 
				<input class="myinput"  onkeyup="value=value.replace(/[\。\,\，\'\‘\.]/g,'')" placeholder="请输入企业名称"  id="key_company">
			</div>
			<div style="margin-top:5px;padding-bottom:5px;">
				收运日期：
				<input type="date" class="myinput" id="key_startDate" placeholder="收运起始时间" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,readOnly:true,maxDate:'%y-%M-%d'})" 
							readonly="readonly">
				<input type="date" class="myinput" id="key_endDate" placeholder="收运截止时间" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,readOnly:true,maxDate:'%y-%M-%d'})" 
							readonly="readonly">&nbsp;&nbsp;
				<a
					href="javascript:search()" class="easyui-linkbutton"
					iconCls='icon-search' plain="true">查询</a>&nbsp;&nbsp;
				<a
					href="javascript:clearVal()" class="easyui-linkbutton"
					iconCls='icon-cancel' plain="true">清空</a>
			</div>
			<div style="padding-bottom:5px;border-top:1px solid #fff;border-bottom:1px solid #fff;">
					<span>收集总桶数(桶)：<span id="allDustbin">--</span></span>&nbsp;&nbsp;
					<span>收集总量(kg)：<span id="allTrash">--</span></span>
			</div>
			<div id="allArea">
				<h3>此处可显示按区域汇总信息</h3>
			</div>
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