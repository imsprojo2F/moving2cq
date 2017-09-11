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
			url : 'user/listAllUser',
			queryParams : {
				name : '',
				gender : true
			},
			//fit : true,
			fitColumns : true,
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
			}, {
				sortable : 'true',
				field : 'id',
				title : '所属区',
				width : 80,
				align : 'center'
			}, {
				field : 'userAccount',
				title : '已收企业总数',
				width : 150,
				align : 'center'
			}, {
				field : 'password',
				title : '已收垃圾桶总数',
				width : 150,
				align : 'center'
			}, {
				field : 'userName',
				title : '已收垃圾总量',
				width : 150,
				align : 'center'
			}, {
				field : 'createTime',
				title : '查询时间段',
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
		

		//搜索框绑定enter
		$("#s_userName").keydown(function(event) {
			event = document.all ? window.event : event;
			if ((event.keyCode || event.which) == 13) {
				searchRole();
			}
		});

		//输入框只能输入字母和数字
		$("#account").on("keyup", function() {
			this.value = this.value.replace(/[^0-9a-zA-Z]/g, '');
		});

		//页面初始化结束--------------------------------------------------------------------		
	});
	// 查询
	function searchRole() {
		//获取值
		var key = $("#s_userName").val();
		//提交表单，查询，dataGrid有个方法，直接向服务器发送请求
		$("#u_dg").datagrid('load', {
			key : key
		});
	}

	var url;

	
	// 查看详情Dialog
	function OpenDetailDialog() {
		var selected = $('#u_dg').datagrid('getSelections');
		if (selected.length == 0) {
			$.messager.alert('系统消息', '请先勾选数据!',
					'info');
			return;
		}
		if (selected.length > 1) {
			$.messager.alert('系统消息', '一次只能修改一条数据!',
					'info');
			return;
		}
		url = '${pageContext.request.contextPath }/user/updateUser';
		//清空表单
		$('#userForm').form('clear');
		clearTip();
		$('#account').attr("readonly","readonly");
		$('#account').removeAttr("onblur");
		// 填充表单数据
		$('#userForm').form('load', {
			id : selected[0].id,
			userAccount : selected[0].userAccount,
			userName : selected[0].userName,
			password : selected[0].password,
			enabled : selected[0].enabled
		//sys_factory_id : selected[0].sys_factory
		});
		$('#u_dialog').dialog("setTitle", '&nbsp;编辑用户').dialog('center')
				.dialog('open');
	}


	// 关闭Dialog
	function closeDialog() {
		$("#userForm").form("clear");
		$('#u_dialog').dialog("close");
		//  清空idField(这一步，一定要做)   
		$('#u_dg').datagrid('unselectAll');
		clearTip();
	}

</script>
<style>
.myinput {
	padding-left:5px;
	width:115px;
	height:20px;
	border-radius:5px;
}
tr{
	height:40px;
}
textarea {
	padding: 5px;
}
</style>
</head>


<body class="easyui-layout">
	<div class="easyui-panel" id="utbar">
		<div style="margin-left: 5px">
			<div style="margin-top:5px;">
				查询条件： 
				<input class="myinput" placeholder="请输入所属区域"  id="key_area">
			</div>
			<div style="margin-top:5px;padding-bottom:0px;">
				收运日期：
				<input type="date" class="myinput" id="key_startDate" placeholder="收运起始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,readOnly:true})" 
							readonly="readonly">
				<input type="date" class="myinput" id="key_endDate" placeholder="收运结止日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,readOnly:true})" 
							readonly="readonly">&nbsp;&nbsp;
				<a
					href="javascript:searchRole(this.value)" class="easyui-linkbutton"
					iconCls='icon-search' plain="true">查询</a>&nbsp;&nbsp;
				<a
					href="javascript:searchRole(this.value)" class="easyui-linkbutton"
					iconCls='icon-cancel' plain="true">清空</a>
			</div>
		</div>
	</div>
	<!-- 数据 -->
	<div id="u_dg"></div>
	<!-- toolbar工具栏 -->


	<!-- dialog -->
	<div id="u_dialog" class="easyui-dialog" iconCls="icon-userManage"
		modal="true" style="width: 570px; height: 350px; padding: 10px 20px"
		closed="true" buttons="#addbtn">

		<div style="padding: 10px 60px 20px 60px">
			<form id="userForm" class="easyui-form" method="post"
				data-options="novalidate:true">
				<table cellpadding="5" border="1" style="margin:0 auto;">
					<tr>
						<td colspan="2" style="text-align:center;"><h3>用户信息</h3></td>
						
					</tr>
					<tr>
						<td>账号:<input type="hidden" id="ID" name="id" /></td>
						<td><input id="account" class="myinput"
							onblur="validate('user/validate',this.value)"
							onfocus="clearTip()" type="text" name="userAccount"
							placeholder="请输入账号(必填)" ime-mode:disabled/></td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input id="password" onblur="check(this.value)"
							type="password" class="myinput" name="password"
							onfocus="clearTip()" placeholder="请输入至少6位密码(必填)" /></td>
					</tr>
					<tr>
						<td>姓名:</td>
						<td><input class="myinput" id="userName" type="text"
							name="userName" onfocus="clearTip()" /></td>
					</tr>
					<tr>
						<td>是否启用:</td>
						<td><input type="radio" value="1" name="enabled" id="Enabled">是
							<input type="radio" value="0" name="enabled">否</td>
					</tr>
					<tr style=" font-size: 16px;">
						<td colspan="2"><span id="tipAddAccount"></span></td>
					</tr>
				</table>
			</form>

		</div>

	</div>
	<div id="addbtn">
		 <a href="javascript:closeDialog()"
			class="easyui-linkbutton" iconCls='icon-clear'>关闭</a>
	</div>
</body>

</html>