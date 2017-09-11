<%@page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户</title>
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
			url : 'trashInfo/analysisTrash',
			queryParams : {
				dayNum : $('#dayNum').val()
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
			},{
				text : '历史记录',
				iconCls : 'icon-more',
				handler : OpenDataGrid
			},{
				text : '稽查任务',
				iconCls : 'icon-man',
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
				field : 'name',
				title : '餐饮企业',
				width : 250,
				align : 'center'
			},{
				sortable : 'true',
				field : 'area_name',
				title : '所属区域',
				width : 250,
				align : 'center'
			},{
				field : 'street_name',
				title : '街道',
				width : 200,
				align : 'center'
			},{
				field : 'dayPut',
				title : '当日产生量(kg)',
				width : 100,
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
				width : 100,
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
				formatter : function(value, row, index) {
					if(!value){
						return 0;
					}else{
						return value;
					}
				}
			},{
				field : 'barrelNum',
				title : '收集桶数',
				width : 180,
				align : 'center'
			},{
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
		
		
		$('#u_dg').datagrid({
			onClickRow:function(index,data){
				var row=$('#u_dg').datagrid('getSelected');
				select_ticke_id = row.id;
				if(row){
						$('#company').html('【'+row.name+'】');
					}
				}
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

		$('#detail').html('');
		selected[0].gross_weight_time = format(selected[0].gross_weight_time);
		selected[0].weight_time = format(selected[0].weight_time);
		selected[0].create_time = format(selected[0].create_time);
		$('#detail').append("<table class='detail' border='1' ><tr><td >餐饮企业</td><td colspan='3' Style='font-weight:bold;font-size:18px;color:#05a4d6;'>"+selected[0].name+"</td></tr><tr><td>所属区域</td><td>"+selected[0].area_name+"</td><td>地址</td><td>"+selected[0].street_name+"</td></tr><tr><td>拥有桶数</td><td>"+selected[0].last_used_barrel+"</td><td>签约收运频次</td><td>"+selected[0].bucket_code+"</td></tr><tr><td>收集日期</td><td>"+selected[0].create_time+"</td><td>实际收运频次</td><td>"+3+"</td></tr><tr><td>收集桶总数</td><td>"+selected[0].barrelNum+"</td><td>产生量(kg)</td><td>"+selected[0].dayPut+"</td></tr><tr><td>皮重(kg)</td><td>"+selected[0].tare_weight+"</td><td>记录时间</td><td>"+selected[0].create_time+"</td></tr></table>");

	}
	
	// 历史记录
	function OpenDataGrid() {
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
		var shopName = selected[0].name;
		var shopId = selected[0].restaurant_id;
		var openUrl = 'trashInfo/toDataGrid?shopName='+shopName+"&shopId="+shopId;	//弹出窗口的url
		var iWidth=900; //弹出窗口的宽度;
		var iHeight=750; //弹出窗口的高度;
		var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
		window.open(openUrl,"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft);
		
	}

	//
	function toDataGrid(val){
		var openUrl = 'trashInfo/toDataGrid?val='+val;	//弹出窗口的url
		var iWidth=800; //弹出窗口的宽度;
		var iHeight=600; //弹出窗口的高度;
		var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
		window.open(openUrl,"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft);
	}
	

	// 关闭Dialog
	function closeDialog() {
		$('#u_dialog').dialog("close");
		//  清空idField(这一步，一定要做)   
		//$('#u_dg').datagrid('unselectAll');
		//clearTip();
		$('#u_dg').datagrid('reload');
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
	

	function getByDayNum(){
		var dayNum = $('#dayNum').val().trim();
		if(!dayNum||dayNum==0){
			return ;
		}
		$("#u_dg").datagrid('load', {
			dayNum:dayNum
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
</style>
</head>


<body class="easyui-layout">
	<div class="easyui-panel" id="utbar" style="height:280px;">
	
		<div style="margin-left: 5px">
			<div style="height:35px;line-height:40px;font-size:16px;padding:5px 0;border-top:0px solid #fff;border-bottom:1px solid #fff;text-align:center;">
					<!-- 所属区域:
					<input id="area_name" value="北京市/北京市/海淀区"  onclick="getCity(this.value)"
						type="text" class="myinput"  
					placeholder="请选择所属区域"  readonly="readonly"/> -->
					<span id="company"></span>近&nbsp;<input id="dayNum"  onkeyup="this.value = this.value.replace(/[^0-9]/g, '');getByDayNum()" type="text" maxlength="3" class="myinput" value="7" style="width:25px;"/> 天产生量走势
			</div>
			<div id="analysisData">
				<h3>折线图</h3>
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