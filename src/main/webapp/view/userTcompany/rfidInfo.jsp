<%@page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RFID</title>
<%@include file="/includes/common.jsp"%>
<script type="text/javascript">
	$(function() {

		$("#u_dg").datagrid({
			idField : 'id',
			iconCls : 'icon-rfidManage',
			striped : true,
			loadMsg : '数据正在加载中，请稍后.....',
			rownumbers : true,//行号
			url : 'rfid/listAllRfid',
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
				handler : deleteRfid
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
				field : 'rfid',
				title : 'rfid',
				width : 150,
				align : 'center'
			}, {
				field : 'rfid_status',
				title : 'rfid使用状态',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					if(value=="无效"){
					return '<span style="color:red;">'+value+'</span>';
					}else{
						return '<span style="color:#149914;">'+value+'</span>';
					}
			}
			}, {
				field : 'is_used',
				title : 'RFID是否被关联桶',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					if(value==1){
					return '<span style="color:red;">已被关联</span>';
					}else{
						return '<span style="color:#149914;">未被关联</span>';
					}
			}
			}, {
				field : 'last_read_date_time',
				title : '最后一次称重时间',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					if(value){
						var unixTimestamp = new Date(value);
						return unixTimestamp.toLocaleString();
					}else{
						return '暂无记录';
					}
				}
			},{
				field : 'last_weight',
				title : '最后一次称重重量',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					if(value){
						return value;
					}else{
						return '暂无记录';
					}
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
		$("#s_rfidName").keydown(function(event) {
			event = document.all ? window.event : event;
			if ((event.keyCode || event.which) == 13) {
				searchRole();
			}
		});

		//输入框只能输入字母和数字
		$("#account").on("keyup", function() {
			this.value = this.value.replace(/[^0-9a-zA-Z]/g, '');
		});
		
		
		//刷新当前表格数据
		//setInterval('reload()',10000);
		// 刷新当前数据表格始化结束--------------------------------------------------------------------		
	});
	
	function reload(){
		$('#u_dg').datagrid('reload')
	}
	// 查询
	function searchRole() {
		//获取值
		var key = $("#s_rfidName").val();
		//提交表单，查询，dataGrid有个方法，直接向服务器发送请求
		$("#u_dg").datagrid('load', {
			key : key
		});
	}

	var url;

	// 保存RFIDDialog
	function saveOpenDialog() {
		url = '${pageContext.request.contextPath }/rfid/addRfid';
		//$("#rfidForm").form("clear");
		clearTip();
		$('#id,#rfid').val('');
		$("#sel option[value='正常']").attr("selected",true);
		$('#u_dialog').dialog("setTitle", '&nbsp;添加RFID').dialog('center')
				.dialog('open');
	}
	// 编辑RFIDDialog
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
		url = '${pageContext.request.contextPath }/rfid/updateRfid';
		//清空表单
		$('#rfidForm').form('clear');
		clearTip();
		// 填充表单数据
		$('#rfidForm').form('load', {
			id : selected[0].id,
			rfid : selected[0].rfid,
			rfid_status : selected[0].rfid_status,
			last_read_date_time : selected[0].last_read_date_time,
			last_weight : selected[0].last_weight
		});
		$('#u_dialog').dialog("setTitle", '&nbsp;编辑RFID').dialog('center')
				.dialog('open');
	}

	// 删除RFID
	function deleteRfid() {
		var selected = $('#u_dg').datagrid('getSelections');
		//window.alert(selected.length);
		if (selected.length < 1) {
			$.messager.alert('系统消息', '请选择您要删除的RFID!', 'info');
			return;
		}
		url = '${pageContext.request.contextPath }/rfid/deleteRfid';
		//构造rfidId
		var rfidArr = [];
		var rfids = [];
		for (var i = 0; i < selected.length; i++) {
			rfidArr.push(selected[i].id);
			rfidArr.push(selected[i].rfid);
		}
		var ids = rfidArr.join(',');
		$.messager.confirm('系统提示信息', '所有关联RFID的桶也会被删除,<br>确定要删除选中的记录吗?', function(r) {
			if (r) {
				//发送ajax请求道服务器 
				$.ajax({
					type : "post",
					url : url,
					data : {
						ids : ids,
						rfids:rfids
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

	// 关闭添加RFID Dialog
	function closeDialog() {
		$("#rfidForm").form("clear");
		$('#u_dialog').dialog("close");
		//  清空idField(这一步，一定要做)   
		$('#u_dg').datagrid('unselectAll');
	}
	
	
	// 验证是否已被使用
	function validate(URL,Value) {
		if(!Value){
			return;
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
				
					if (data.code == 1) {
						$('#result').html(
								"<span style='color:green'>Tip:RFID可用</span>");
					} else {
						$('#result').html(
								"<span style='color:red'>Tip:RFID已被使用！</span>");
						
						if(Value==$('#rfid').val()){
							
							setTimeout(function(){
								$('#rfid').val('');	
							}, 10);
							
						}
					}
			},

			error : function() {

			},
			complete : function() {
				// $("#loadingModal").modal("hide");
			}
		});
	}
	
	function clearTip(){
		$('#result').html('');
	}

	// 提交表单
	function doSubmit() {
			if(!$('#rfid').val()){
				alert('请填写RFID!');
				return ;
			}
			var oldRfid;
			if(url=='${pageContext.request.contextPath }/rfid/updateRfid'){
				var selected = $('#u_dg').datagrid('getSelections');
				oldRfid = selected[0].rfid;
			}
			
			$.ajax({
				type : 'POST',
				url : url,
				dataType : 'json',
				data : {
						id:$('#id').val(),
						rfid:$('#rfid').val(),
						rfid_status:$('#sel').val(),
						oldRfid:oldRfid
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
							msg : '操作RFID成功!'
						});
					} else {
						$.messager.show({
							title : '系统消息',
							msg : '操作RFID失败!'
						});
					}
				},
				error : function(r) {
					$.messager.show({
						title : '系统消息',
						msg : '操作RFID失败!'
					});
				}
			});

		// 关闭dialog
		$('#u_dialog').dialog('close');
	}

	// 关闭角色窗口
	function closeRoleDialog() {
		$("#r_dialog").dialog('close');
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
			查询条件： <input class="easyui-textbox" data-options="prompt:'请输入RFID'"
				name="s_rfidName" id="s_rfidName"> <a
				href="javascript:searchRole(this.value)" class="easyui-linkbutton"
				iconCls='icon-search' plain="true">查询</a>
		</div>
	</div>
	<!-- 数据 -->
	<div id="u_dg"></div>
	<!-- toolbar工具栏 -->


	<!-- 添加RFIDdialog -->
	<div id="u_dialog" class="easyui-dialog" iconCls="icon-rfidManage"
		modal="true" style="width: 570px; height: 350px; padding: 10px 20px"
		closed="true" buttons="#addbtn">

		<div style="padding: 10px 60px 20px 60px;border:0px solid red;">
			<form id="rfidForm" class="easyui-form" method="post"
				data-options="novalidate:true">
				<table cellpadding="5" border="1" style="margin:0 auto;">
					<tr>
						<td colspan="2" style="text-align:center;"><h3>RFID信息</h3></td>
					</tr>
					<tr>
						<td>RFID:<input id="id" type="hidden" name="id" /></td>
						<td><input class="myinput" 
							onfocus="clearTip()" maxlength="6"
							onkeyup="this.value = this.value.replace(/[^0-9a-zA-Z\-]/g, '');validate('rfid/validate',this.value);clearTip();" id="rfid" type="text" name="rfid"
							/>
						</td>
					</tr>
					<tr>
						<td>rfid使用状态:</td>
						<td>
							<select id="sel" name="rfid_status">
								<option value="正常" >正常</option>
								<option value="无效">无效</option>
							</select>
						</td>
					</tr>
				</table>
			</form>
			<br>
			<div id="result" style="text-align:center;"></div>
			<span >提示:当RFID信息更新时,需重新打开餐厨桶信息管理界面才可同步。</span>
		</div>
		<br>
		

	</div>
	<div id="addbtn">
		<a href="javascript:doSubmit()" class="easyui-linkbutton"
			iconCls='icon-ok'>确定</a> <a href="javascript:closeDialog()"
			class="easyui-linkbutton" iconCls='icon-clear'>关闭</a>
	</div>
</body>

</html>