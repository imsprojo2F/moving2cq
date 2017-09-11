<%@page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>桶</title>
<%@include file="/includes/common.jsp"%>
<script type="text/javascript">
	$(function() {
		
		$("#u_dg").datagrid({
			idField : 'id',
			iconCls : 'icon-userManage',
			striped : true,
			loadMsg : '数据正在加载中，请稍后.....',
			rownumbers : true,//行号
			url : 'bucket/listAllBucket',
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
				handler : deleteBucket
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
				field : 'bucket_code',
				title : '桶编号',
				width : 150,
				align : 'center'
			}, {
				field : 'bucket_mode',
				title : '型号',
				width : 150,
				align : 'center'
			}, {
				field : 'is_binding',
				title : '是否被绑定',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					if(value==0){
						return '<span style="color:#149914;">未被绑定</span>';
					}
					return '<span style="color:red;">已被绑定</span>';
			}
			}, {
				field : 'volume',
				title : '容积(升)',
				width : 150,
				align : 'center'
			}, {
				field : 'rfid',
				title : 'RFID',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
						return value;
				}
			}, {
				field : 'rfid_status',
				title : 'RFID使用状态',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
						if(value=="无效"){
						return '<span style="color:red;">'+value+'</span>';
						}else{
							return '<span style="color:#149914;">'+value+'</span>';
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
		
		
		//rfid下拉框
		var rfids = '${rfidList}';
		if(rfids=='[]'){
			$('#rfids').html('请先填写RFID相关信息！');
			$('#SEL').hide();
		}else{
			$('#rfids').hide();
			$('#SEL').show();
		}
		
		
		
		//刷新当前表格数据
		//setInterval('reload()',10000);
		//页面初始化结束--------------------------------------------------------------------		
	});
	
	function reload(){
		$('#u_dg').datagrid('reload')
	}
	
	function test(){
		$('#select').combobox({   
		    url:'rfid/listUnuseRfid',  //这里设置你的后台链接，返回的json数据会自己解析写进下拉框
		    valueField:'rfid',   
		    textField:'rfid',
		    editable:false
		});
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

	// 保存桶信息Dialog
	function saveOpenDialog() {
		url = '${pageContext.request.contextPath }/bucket/addBucket';
		clearTip();
		$('#TIP').hide();
		$("#bucketForm").form("clear");
		$('#u_dialog').dialog("setTitle", '&nbsp;添加餐厨桶信息').dialog('center')
				.dialog('open');
	}
	
	var oldVal;
	// 编辑桶信息Dialog
	function editOpenDialog() {
		var selected = $('#u_dg').datagrid('getSelections');
		
		if(!selected){
				$.messager.alert('系统消息', '请先勾选数据!',
						'info');
				return;
		}
		if (selected.length == 0) {
			$.messager.alert('系统消息', '请先勾选数据!',
					'info');
			return;
		}
		oldVal = selected[0].bucket_code;
		if (selected.length > 1) {
			$.messager.alert('系统消息', '一次只能修改一条数据!',
					'info');
			return;
		}
		url = '${pageContext.request.contextPath }/bucket/updateBucket';
		clearTip();
		$('#TIP').show();
		//清空表单
		$('#bucketForm').form('clear');
		// 填充表单数据
		$('#bucketForm').form('load', {
			id : selected[0].id,
			bucket_code : selected[0].bucket_code,
			bucket_mode : selected[0].bucket_mode,
			volume : selected[0].volume,
			rfid: selected[0].rfid,
			create_time : selected[0].create_time
		});
		
		//添加rfid到session中
		addToSession(selected[0].bucket_code,selected[0].rfid);
		$('#u_dialog').dialog("setTitle", '&nbsp;编辑桶信息').dialog('center')
				.dialog('open');
	}

	// 删除桶信息
	function deleteBucket() {
		var selected = $('#u_dg').datagrid('getSelections');
		//window.alert(selected.length);
		if (selected.length < 1) {
			$.messager.alert('系统消息', '请选择您要删除的信息!', 'info');
			return;
		}
		url = '${pageContext.request.contextPath }/bucket/deleteBucket';
		//构造userId
		var userArr = [];
		var rfidArr = [];
		for (var i = 0; i < selected.length; i++) {
			userArr.push(selected[i].id);
			rfidArr.push(selected[i].rfid);
		}
		var ids = userArr.join(',');
		var rfids = rfidArr.join(',');
		$.messager.confirm('系统提示信息', '确定要删除选中的信息吗?', function(r) {
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

	// 关闭添加桶信息 Dialog
	function closeDialog() {
		$("#bucketForm").form("clear");
		$('#u_dialog').dialog("close");
		//  清空idField(这一步，一定要做)   
		$('#u_dg').datagrid('unselectAll');
		
	}
	
	// 验证是否已被使用
	function validate(URL,Value) {
		
		if(!Value){
			return ;
		}
		if(Value.length<6){
			$('#result').html(
			"<span style='color:green'>Tip:建议输入长度为6位由字母、数字组成的编号。</span>");
			return;
		}
		
		if(oldVal==Value){
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
								"<span style='color:green'>Tip:桶编号可用</span>");
					} else {
						$('#result').html(
								"<span style='color:red'>Tip:桶编号已被使用！</span>");
						setTimeout("$('#bucket_code').val('')", 10);
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
			var rfid = $('input[name=rfid]').val();
			var bucket_code = $('#bucket_code').val().trim();
			if(!rfid||!bucket_code){
				alert('您未填写桶编码或未选择RFID！');
				return ;
			}
			if(bucket_code.length<6){
				$('#result').html(
				"<span style='color:green'>Tip:建议输入长度为6位由字母、数字组成的编号。</span>");
				return;
			}
			$.ajax({
				type : 'POST',
				url : url,
				dataType : 'json',
				data : $('#bucketForm').serialize(),
				cache : false,
				success : function(data) {
					if (data.code == 1) {
						// 刷新当前数据表格
						$('#u_dg').datagrid('reload');
						//  清空idField(这一步，一定要做)   
						$('#u_dg').datagrid('unselectAll');
						$.messager.show({
							title : '系统消息',
							msg : '操作桶信息成功!'
						});
					} else {
						$.messager.show({
							title : '系统消息',
							msg : '操作桶信息失败!'
						});
					}
				},
				error : function(r) {
					$.messager.show({
						title : '系统消息',
						msg : '操作桶信息失败!'
					});
				}
			});

		// 关闭dialog
		$('#u_dialog').dialog('close');
	}
	
	//把旧的rfid存入session
	function addToSession(bucket_code,rfid){
		$.ajax({
			type : 'POST',
			url : 'bucket/addToSession',
			dataType : 'json',
			data : {
				bucket_code:bucket_code,
				rfid:rfid
			},
			cache : false,
			success : function(data) {
				if (data.code == 1) {
					
				} else {
					
				}
			}
		});
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
			查询条件： <input class="easyui-textbox" data-options="prompt:'请输入桶编号或rfid'"
				name="s_userName" id="s_userName"> <a
				href="javascript:searchRole(this.value)" class="easyui-linkbutton"
				iconCls='icon-search' plain="true">查询</a>
		</div>
	</div>
	<!-- 数据 -->
	<div id="u_dg"></div>
	<!-- toolbar工具栏 -->


	<!-- 添加桶dialog -->
	<div id="u_dialog" class="easyui-dialog" iconCls="icon-userManage"
		modal="true" style="width: 570px; height: 400px; padding: 10px 20px"
		closed="true" buttons="#addbtn">

		<div style="padding: 10px 60px 20px 60px">
			<form id="bucketForm" class="easyui-form" method="post"
				data-options="novalidate:true">
				<table cellpadding="5" border="1" style="margin:0 auto;">
					
					<tr>
						<td colspan="2" style="text-align:center;"><h3>餐厨桶信息</h3></td>
						
					</tr>
					<tr>
						<td>桶编号:<input type="hidden" id="ID" name="id" /></td>
						<td><input id="bucket_code" class="myinput" onblur="validate('bucket/validate',this.value)"
							onfocus="clearTip()" maxlength="6"
							onkeyup="this.value = this.value.replace(/[^0-9a-zA-Z\-]/g, '');" type="text" name="bucket_code"
							/></td>
					</tr>
					<tr>
						<td>型号:</td>
						<td><input id="bucket_mode" onkeyup="this.value = this.value.replace(/[^0-9a-zA-Z]/g, '');"
							class="myinput" name="bucket_mode"
							/></td>
					</tr>
					<tr>
						<td>容积(升):</td>
						<td><input class="myinput" id="volume" type="text"
							name="volume" onkeyup="value=value.replace(/[^\d\.]/g,'')"/></td>
					</tr>
					<tr>
						<td>RFID:<span id="oldRFID" style="display:none;"></span></td>
						<td>
							<span id="rfids"></span>
							<span id="SEL" onclick="test()">
								<select id="select" name="rfid" style="width:95px;">
								</select>
							</span>
						</td>
					</tr>
				</table>
			</form>
			<div id="result" style="text-align:center;"></div>
			<span style="text-align:center; id="TIP">提示:RFID下拉框仅会显示所有正常及未被使用的RFID,如无需更换RFID,关闭当前窗口即可。</span>
		</div>
		

	</div>
	<div id="addbtn">
		<a href="javascript:doSubmit()" class="easyui-linkbutton"
			iconCls='icon-ok'>确定</a> <a href="javascript:closeDialog()"
			class="easyui-linkbutton" iconCls='icon-clear'>关闭</a>
	</div>
</body>

</html>