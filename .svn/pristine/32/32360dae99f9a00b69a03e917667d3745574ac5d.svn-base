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
<%@include file="/includes/common.jsp"%>
<link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="css/bootstrap/js/bootstrap.min.js"></script>
<!-- <script type="text/javascript">
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
			fit : true,
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
				handler : deleteUser
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
				field : 'userAccount',
				title : '账号',
				width : 150,
				align : 'center'
			}, {
				field : 'password',
				title : '密码',
				width : 150,
				align : 'center'
			}, {
				field : 'userName',
				title : '姓名',
				width : 150,
				align : 'center'
			}, {
				field : 'createTime',
				title : '创建时间',
				width : 300,
				align : 'center',
				formatter : function(value, row, index) {
					var unixTimestamp = new Date(value);
					return unixTimestamp.toLocaleString();
				}
			}, {
				field : 'enabled',
				title : '是否启用',
				width : 90,
				align : 'center',
				formatter : function(value, row, index) {
						if(value==1){
							return "是";
						}else{
							return "否";
						}
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

	// 保存用户Dialog
	function saveOpenDialog() {
		url = '${pageContext.request.contextPath }/user/addUser';
		$('#account').removeAttr("readonly");
		$('#account').attr("onblur","validate('user/validate',this.value)");
		$("#userForm").form("clear");
		$("input[name='enabled']").get(0).checked = true;
		$("#fcCode").val(1);
		$('#u_dialog').dialog("setTitle", '&nbsp;添加用户').dialog('center')
				.dialog('open');
	}
	// 编辑用户Dialog
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

	// 删除用户
	function deleteUser() {
		var selected = $('#u_dg').datagrid('getSelections');
		//window.alert(selected.length);
		if (selected.length < 1) {
			$.messager.alert('系统消息', '请选择您要删除的用户!', 'info');
			return;
		}
		url = '${pageContext.request.contextPath }/user/deleteUser';
		//构造userId
		var userArr = [];
		for (var i = 0; i < selected.length; i++) {
			userArr.push(selected[i].id);
		}
		var ids = userArr.join(',');
		$.messager.confirm('系统提示信息', '确定要删除选中的用户吗?', function(r) {
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

	// 关闭添加用户 Dialog
	function closeDialog() {
		$("#userForm").form("clear");
		$('#u_dialog').dialog("close");
	//  清空idField(这一步，一定要做)   
		$('#u_dg').datagrid('unselectAll');
		clearTip();
	}

	// 提交表单
	function doSubmit() {
		var tip = $('#tipAddAccount');
		var id = $("#ID").val()
		var account = $("#account").val().trim();
		var password = $("#password").val().trim();
		var name = $("#userName").val();
		var enabled = $("input:radio:checked").val();
		var fcCode = $("#fcCode").val();
		if (!account || !password) {
			$.messager.alert('系统消息', '账号或密码不能为空！', 'info');
			return;
		}else if (account.length < 5) {
			$.messager.alert('系统消息', '账号长度过短！', 'info');
			return;
		}else if (password.length < 6) {
			$.messager.alert('系统消息', '密码不能小于6位数！', 'info');
			return;
		} else {
			$.ajax({
				type : 'POST',
				url : url,
				dataType : 'json',
				data : {
					'id' : id,
					'userAccount' : account,
					'userName' : name,
					'password' : password,
					'enabled' : enabled
				},
				cache : false,

				success : function(data) {
					if (data.code == 1) {
						// 刷新当前数据表格
						$('#u_dg').datagrid('reload');
						//  清空idField(这一步，一定要做)   
						$('#u_dg').datagrid('unselectAll');
						$.messager.show({
							title : '系统消息',
							msg : '操作用户成功!'
						});
					} else {
						$.messager.show({
							title : '系统消息',
							msg : '操作用户失败!'
						});
					}
				},
				error : function(r) {
					$.messager.show({
						title : '系统消息',
						msg : '操作用户失败!'
					});
				}
			});
		}

		// 关闭dialog
		$('#u_dialog').dialog('close');
	}

	// 关闭角色窗口
	function closeRoleDialog() {
		$("#r_dialog").dialog('close');
	}

	// 账号是否已被使用
	function validate(URL,Value) {

		if (!Value.trim()) {
			$('#account').val('');
			return false;
		}
		if (Value.trim().length < 5) {
			$('#tipAddAccount').html(
					"<span style='color:red'>为了账号安全请输入不小于5位的账号！</span>");
			return false;
		}
		$.ajax({
			type : 'POST',
			url : URL,
			dataType : 'json',
			data : {
				'validateValue' : Value
			},
			cache : false,
			beforeSend : function() {
				// $("#loadingModal").modal("show");
			},
			success : function(data) {
				//alert(data.message);
				
					if (data.code == 1) {
						$('#tipAddAccount').html(
								"<span style='color:green'>账号可用</span>");
						$('#tipUpdateAccount').html(
								"<span style='color:green'>账号可用</span>");
					} else {
						$('#tipAddAccount').html(
								"<span style='color:red'>账号已被使用！</span>");
						setTimeout("$('#account').val('')", 1000);
						$('#tipUpdateAccount').html(
								"<span style='color:red'>账号已被使用！</span>");
						setTimeout("$('#update_account').val('')", 1000);
					}
			},

			error : function() {

			},
			complete : function() {
				// $("#loadingModal").modal("hide");
			}
		});
	}

	// 清空提示信息
	function clearTip() {

		$('#tipAddAccount').html('');
	}
	function check(val) {
		if (val.trim().length < 6) {
			$('#tipAddAccount').html(
					"<span style='color:red'>密码不能少于6位数！</span>");
			return false;
		}
		
	}
</script>
 -->
</head>
<body>
	<div class="wrap">
		<h2>添加商户</h2>
		<div class="form-horizontal">
			<h3><i></i>基本信息</h3>
			<div class="form-container clearfix">
			<div class="form-group">
			  <label for="inputID" class="col-sm-4 control-label">商 户 I  D：</label>
			  <div class="col-sm-7">
			    <input type="text" class="form-control"  placeholder="CYQY20150425217">
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">登记日期：</label>
			  <div class="col-sm-7">
			    <input type="date" class="form-control"  placeholder="2017-01-16">
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">商户状态：</label>
			  <div class="col-sm-7">
			    <select class="form-control">
			        <option>选择状态</option>
			      </select>
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">营业状态：</label>
			  <div class="col-sm-7">
			    <select class="form-control">
			        <option>选择状态</option>
			      </select>
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">区域：</label>
			  <div class="col-sm-7">
			    <input type="text" class="form-control"  placeholder="2017-01-16">
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">街道（镇）：</label>
			  <div class="col-sm-7">
			    <select class="form-control">
			        <option>选择街道</option>
			      </select>
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">店面简称：</label>
			  <div class="col-sm-7">
			    <input type="text" class="form-control"  placeholder="店面简称">
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">店面地址：</label>
			  <div class="col-sm-7">
			    <input type="text" class="form-control"  placeholder="店面地址">
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">开业日期：</label>
			  <div class="col-sm-7">
			    <input type="text" class="form-control"  placeholder="2017-01-16">
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">停业日期：</label>
			  <div class="col-sm-7">
			    <input type="text" class="form-control"  placeholder="2017-01-16">
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">联系人：</label>
			  <div class="col-sm-7">
			    <input type="text" class="form-control"  placeholder="联系人">
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">联系电话：</label>
			  <div class="col-sm-7">
			    <input type="text" class="form-control"  placeholder="联系电话">
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">单位名称：</label>
			  <div class="col-sm-7">
			    <input type="text" class="form-control"  placeholder="单位名称">
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">单位地址：</label>
			  <div class="col-sm-7">
			    <input type="text" class="form-control"  placeholder="单位地址">
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">法人代表：</label>
			  <div class="col-sm-7">
			    <input type="text" class="form-control"  placeholder="法人代表">
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">联系电话：</label>
			  <div class="col-sm-7">
			    <input type="text" class="form-control"  placeholder="联系电话">
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">证件类型：</label>
			  <div class="col-sm-7">
			    <select class="form-control">
			        <option>请选择</option>
			      </select>
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">证件编号：</label>
			  <div class="col-sm-7">
			    <input type="text" class="form-control"  placeholder="证件编号">
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">供餐时间：</label>
			  <div class="col-sm-7">
			    <label class="checkbox-inline">
				  <input type="checkbox" id="inlineCheckbox1" value="option1"> 早餐
				</label>
				<label class="checkbox-inline">
				  <input type="checkbox" id="inlineCheckbox2" value="option2"> 午餐
				</label>
				<label class="checkbox-inline">
				  <input type="checkbox" id="inlineCheckbox3" value="option3"> 晚餐
				</label>
				<label class="checkbox-inline">
				  <input type="checkbox" id="inlineCheckbox4" value="option4"> 夜宵
				</label>
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">供餐、加工营业面积：</label>
			  <div class="col-sm-7">
			    <input type="text" class="form-control"  placeholder="证件编号">
			    <em>平方米</em>
			  </div>
			</div>
			<div class="form-group">
			  <label class="col-sm-4 control-label">实际收集时间段：</label>
			  <div class="col-sm-7 col-area">
			    <input type="text" class="form-control"  placeholder="2016-02"><span>至</span><input type="text" class="form-control"  placeholder="2016-02">
			  </div>
			</div>
		</div>
			<h3><i></i>收运信息</h3>
			<div class="form-container clearfix">
				<div class="form-group">
				  <label class="col-sm-4 control-label">日均生产量：</label>
				  <div class="col-sm-7">
				    <em>吨</em>
				    <input type="text" class="form-control"  placeholder="324，342">
				    
				  </div>
				</div>
				<div class="form-group">
				  <label class="col-sm-4 control-label">申报食物残余：</label>
				  <div class="col-sm-7">
				    <em>吨</em>
				    <input type="text" class="form-control"  placeholder="324，342">
				    
				  </div>
				</div>
				<div class="form-group">
				  <label class="col-sm-4 control-label">协议签订日期：</label>
				  <div class="col-sm-7">
				    <input type="date" class="form-control"  placeholder="324，342">
				  </div>
				</div>
				<div class="form-group">
				  <label class="col-sm-4 control-label">协议年限：</label>
				  <div class="col-sm-7">
				  	<em>年</em>
				    <input type="text" class="form-control"  placeholder="324，342">
				  </div>
				</div>
				<div class="form-group">
				  <label class="col-sm-4 control-label">约定上门收集时间段1：</label>
				  <div class="col-sm-7 col-area">
				    <input type="text" class="form-control"  placeholder="2016-02"><span>至</span><input type="text" class="form-control"  placeholder="2016-02">
				  </div>
				</div>
				<div class="form-group">
				  <label class="col-sm-4 control-label">约定上门收集时间段2：</label>
				  <div class="col-sm-7 col-area">
				    <input type="text" class="form-control"  placeholder="2016-02"><span>至</span><input type="text" class="form-control"  placeholder="2016-02">
				  </div>
				</div>
				<div class="form-group form-full">
				  <label class="col-sm-2 control-label">文件上传：</label>
				  <div class="col-sm-9">
				  	<div class="col-file">
				  		<button type="button" class="btn btn-info">上传附件</button>
				    	<input type="file" class="form-control">
				    </div>
				  </div>
				</div>
				<div class="form-group form-full">
				  <label class="col-sm-2 control-label">备注：</label>
				  <div class="col-sm-9">
				    <textarea class="form-control" rows="3"></textarea>
				  </div>
				</div>
			</div>
			<h3><i></i>RFID信息</h3>
			<div class="form-container clearfix">
				<table class="table table-border">
					<thead>
						<tr>
							<th></th>
							<th>RFID编号</th>
							<th>最后一次称重</th>
							<th>称重时间</th>
							<th>RFID状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td></td>
							<td>e2001027720e02265465ec</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>
			<h3><i></i>图片信息</h3>
			<div class="form-container clearfix">
				<ul class="form-photo">
					<li onclick="" class="addphoto"><img src='images/cz/pupdate.png' /></li>
					<li><img src='images/cz/pic.png' class="updatepic"/><i class="pclose"></i></li>
				</ul>
			</div>
		</div>
		<div class="form-btn">
			<button type="button" class="btn btn-default">返回</button>
			<button type="button" class="btn btn-info">保存</button>
		</div>
	</div>
</body>

<!-- <body class="easyui-layout">
	<div class="easyui-panel" id="utbar"  style="position:absolute;top:0;left:0;">
		<div style="margin-left: 5px">
			查询条件： <input class="easyui-textbox" data-options="prompt:'请输入账号或姓名'"
				name="s_userName" id="s_userName"> <a
				href="javascript:searchRole(this.value)" class="easyui-linkbutton"
				iconCls='icon-search' plain="true">查询</a>
		</div>
	</div>
	数据
	<div id="u_dg" style="margin-top:30px;"></div>
	toolbar工具栏


	添加用户dialog
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
		<a href="javascript:doSubmit()" class="easyui-linkbutton"
			iconCls='icon-ok'>确定</a> <a href="javascript:closeDialog()"
			class="easyui-linkbutton" iconCls='icon-clear'>关闭</a>
	</div>
</body>
 -->
</html>