<%@page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>司机信息</title>
<%@include file="/includes/common.jsp"%>
<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript">
	$(function() {
		
		$("#u_dg").datagrid({
			idField : 'id',
			iconCls : 'icon-userManage',
			striped : true,
			loadMsg : '数据正在加载中，请稍后.....',
			rownumbers : true,//行号
			url : 'vehicle/listAllVehicle',
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
				text : '新增',
				iconCls : 'icon-add',
				handler : saveOpenDialog
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : editOpenDialog
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : deleteVehicle
			} ],
			columns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				sortable : 'true',
				field : 'id',
				title : '编号',
				width : 80,
				align : 'center'
			}, {
				field : 'vehicle_number',
				title : '车牌号',
				width : 250,
				align : 'center'
			}, {
				field : 'vehicle_type',
				title : '车辆类型',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					if(!value){
						return '暂未填写';
					}
					return value;
			}
			}, {
				field : 'company_name',
				title : '所属公司',
				width : 250,
				align : 'center',
				formatter : function(value, row, index) {
					if(!value){
						return '暂未填写';
					}
					return value;
			}
			},{
				field : 'create_time',
				title : '创建时间',
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
		// 双击选择角色
		$('#role_datagrid').datagrid({
			onDblClickRow : function(index, row) {
				// 获取文本框
				$('#roleName').val(row.roleName);
				// 设置隐藏域
				$('#roleId').val(row.roleId);
				//关闭dialog
				$("#r_dialog").dialog('close');
			}
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
	
	function reload(){
		$('#u_dg').datagrid('reload')
	}

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

	// 保存信息Dialog
	function saveOpenDialog() {
		url = '${pageContext.request.contextPath }/vehicle/addVehicle';
		uploadNum = 0;
		;
		$("#vehicleForm").form("clear");
		$('#u_dialog').dialog("setTitle", '&nbsp;添加司机信息').dialog('center')
				.dialog('open');
	}
	// 编辑车辆信息Dialog
	function editOpenDialog() {
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
		url = '${pageContext.request.contextPath }/vehicle/updateVehicle';
		;
		
		//清空表单
		$('#vehicleForm').form('clear');
		// 填充表单数据
		$('#vehicleForm').form('load', {
			id : selected[0].id,
			vehicle_number:selected[0].vehicle_number,
			vehicle_type : selected[0].vehicle_type,
			company_id : selected[0].company_id,
			company_name : selected[0].company_name,
			create_time : selected[0].create_time
		});
		
		$('#u_dialog').dialog("setTitle", '&nbsp;编辑车辆信息').dialog('center')
				.dialog('open');
	}

	// 删除车辆信息
	function deleteVehicle() {
		var selected = $('#u_dg').datagrid('getSelections');
		//window.alert(selected.length);
		if (selected.length < 1) {
			$.messager.alert('系统消息', '请选择您要删除的信息!', 'info');
			return;
		}
		url = '${pageContext.request.contextPath }/vehicle/deleteVehicle';
		//构造userId
		var userArr = [];

		for (var i = 0; i < selected.length; i++) {
			userArr.push(selected[i].id);
		}
		var ids = userArr.join(',');
		$.messager.confirm('系统提示信息', '确定要删除选中的信息吗?', function(r) {
			if (r) {
				//发送ajax请求道服务器 
				$.ajax({
					type : "post",
					url : url,
					data : {
						ids : ids
					},
					cache : false,
					dataType : 'json',
					success : function(data) {
						// 刷新当前数据表格
						$('#u_dg').datagrid('reload');
						//  清空idField(这一步，一定要做)   
						$('#u_dg').datagrid('unselectAll');

						if (data.code == 1) {
							$.messager.show({
								title : '系统消息',
								msg : '删除记录成功!'
							});
						} else {
							$.messager.show({
								title : '系统消息',
								msg : '删除记录失败!'
							});
						}
					},
					error : function(data) {
						$.messager.show({
							title : '系统消息',
							msg : '删除记录失败!'
						});
					}
				});

			}
		});
	}

	// 关闭添加桶信息 Dialog
	function closeDialog() {
		$("#vehicleForm").form("clear");
		$('#u_dialog').dialog("close");
		// 刷新当前数据表格
		$('#u_dg').datagrid('reload');
		//  清空idField(这一步，一定要做)   
		$('#u_dg').datagrid('unselectAll');
		
	}
	
	
	// 提交表单
	function doSubmit() {
			$.ajax({
				type : 'POST',
				url : url,
				dataType : 'json',
				data : $('#vehicleForm').serialize(),
				cache : false,
				success : function(data) {
					if (data.code == 1) {
						// 刷新当前数据表格
						$('#u_dg').datagrid('reload');
						//  清空idField(这一步，一定要做)   
						$('#u_dg').datagrid('unselectAll');
						$.messager.show({
							title : '系统消息',
							msg : '操作车辆信息成功!'
						});
					} else {
						$.messager.show({
							title : '系统消息',
							msg : '操作车辆信息失败!'
						});
					}
				},
				error : function(r) {
					$.messager.show({
						title : '系统消息',
						msg : '操作车辆信息失败!'
					});
				}
			});

		// 关闭dialog
		$('#u_dialog').dialog('close');
	}
	
	
</script>
<style>
.myinput {
	padding: 5px;
	width: 165px;
	height: 15px;
	border-radius: 5px;
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
			查询条件： <input class="easyui-textbox" data-options="prompt:'请输入车牌号或所属公司'"
				name="s_userName" id="s_userName"> <a
				href="javascript:searchRole(this.value)" class="easyui-linkbutton"
				iconCls='icon-search' plain="true">查询</a>
		</div>
	</div>
	<!-- 数据 -->
	<div id="u_dg"></div>
	<!-- toolbar工具栏 -->


	<!-- 添加车辆dialog -->
	<div id="u_dialog" class="easyui-dialog" iconCls="icon-userManage"
		modal="true" style="width: 570px; height: 400px; padding: 10px 20px"
		closed="true" buttons="#addbtn">

		<div style="padding: 10px 60px 20px 60px">
			<form id="vehicleForm" class="easyui-form" method="post"
				data-options="novalidate:true">
				<table cellpadding="5" border="1" style="margin:0 auto;">
					
					<tr>
						<td colspan="2" style="text-align:center;"><h3>车辆信息</h3></td>
						
					</tr>
					<tr>
						<td>车牌号:<input type="hidden" id="id" name="id" /></td>
						<td><input id="vehicle_number" maxlength="7" class="myinput"  type="text" name="vehicle_number"/>
						</td>
					</tr>
					<tr>
						<td>车辆类型:</td>
						<td><input id="vehicle_type" 
							class="myinput" name="vehicle_type" /></td>
					</tr>
					<tr>
						<td>所属公司:<input type="hidden" id="company_id" name="company_id" /></td>
						<td><input class="myinput" id="company_name" type="text" 
							name="company_name" /></td>
					</tr>
				</table>
			</form>
			<div id="result" style="text-align:center;"></div>
		</div>
		

	</div>
	<div id="addbtn">
		<a href="javascript:doSubmit()" class="easyui-linkbutton"
			iconCls='icon-ok'>确定</a> <a href="javascript:closeDialog()"
			class="easyui-linkbutton" iconCls='icon-clear'>关闭</a>
	</div>
</body>

</html>