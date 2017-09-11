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
			url : 'driver/listAllDriver',
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
				handler : deleteDriver
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
				field : 'name',
				title : '姓名',
				width : 150,
				align : 'center'
			}, {
				field : 'id_card_number',
				title : '身份证号',
				width : 250,
				align : 'center',
				formatter : function(value, row, index) {
					if(!value){
						return '暂未填写';
					}
					return value;
			}
			}, {
				field : 'phone_number',
				title : '手机号',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
					if(!value){
						return '暂未填写';
					}
					return value;
			}
			}, {
				field : 'photo_name',
				title : '照片',
				width : 150,
				align : 'center',
				formatter : function(value, row, index) {
						if(!value){
							return '暂无照片';
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
		url = '${pageContext.request.contextPath }/driver/addDriver';
		uploadNum = 0;
		clearTip();
		$('#uploadBtn').html('上传照片');
		$("#driverForm").form("clear");
		$('#code').val(getUUID());
		$('#u_dialog').dialog("setTitle", '&nbsp;添加司机信息').dialog('center')
				.dialog('open');
	}
	// 编辑桶信息Dialog
	function editOpenDialog() {
		uploadNum = 2;
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
		url = '${pageContext.request.contextPath }/driver/updateDriver';
		clearTip();
		//文件栏填充信息
		var file = selected[0].photo_name;
		if(file){
			$('#fileurl').html(file);
			$('#uploadBtn').html('替换照片');
			$('#download').html('<span class="down">下载照片</span>');
			$('#delfile').html('<span class="del">删除照片</span>');
		} 
		//清空表单
		$('#driverForm').form('clear');
		// 填充表单数据
		$('#driverForm').form('load', {
			id : selected[0].id,
			pic_code:selected[0].pic_code,
			name : selected[0].name,
			id_card_number : selected[0].id_card_number,
			phone_number : selected[0].phone_number,
			photo_name: selected[0].photo_name,
			create_time : selected[0].create_time
		});
		
		$('#u_dialog').dialog("setTitle", '&nbsp;编辑司机信息').dialog('center')
				.dialog('open');
	}

	// 删除司机信息
	function deleteDriver() {
		var selected = $('#u_dg').datagrid('getSelections');
		//window.alert(selected.length);
		if (selected.length < 1) {
			$.messager.alert('系统消息', '请选择您要删除的信息!', 'info');
			return;
		}
		url = '${pageContext.request.contextPath }/driver/deleteDriver';
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
		$("#driverForm").form("clear");
		$('#u_dialog').dialog("close");
		// 刷新当前数据表格
		$('#u_dg').datagrid('reload');
		//  清空idField(这一步，一定要做)   
		$('#u_dg').datagrid('unselectAll');
		
	}
	
	
	function clearTip(){
		$('#result').html('');
		$('#fileurl').html('');
		$('#download').html('');
		$('#delfile').html('');
	}
	// 提交表单
	function doSubmit() {
			if(!checkCard()){
				return;
			}
			$.ajax({
				type : 'POST',
				url : url,
				dataType : 'json',
				data : $('#driverForm').serialize(),
				cache : false,
				success : function(data) {
					if (data.code == 1) {
						// 刷新当前数据表格
						$('#u_dg').datagrid('reload');
						//  清空idField(这一步，一定要做)   
						$('#u_dg').datagrid('unselectAll');
						$.messager.show({
							title : '系统消息',
							msg : '操作司机信息成功!'
						});
					} else {
						$.messager.show({
							title : '系统消息',
							msg : '操作司机信息失败!'
						});
					}
				},
				error : function(r) {
					$.messager.show({
						title : '系统消息',
						msg : '操作司机信息失败!'
					});
				}
			});

		// 关闭dialog
		$('#u_dialog').dialog('close');
	}
	
	
  
  	var uploadNum = 0;
  	//文件上传
	function upload() {
		url = '${pageContext.request.contextPath }/driver/updateByCode';
		uploadNum++;
		var name = $('#phone_number').val().trim();
		var id = $('#id').val();
		var uuid = $("#code").val();
		//alert(uuid);
		if(!name){
			alert("请先填写手机号!");
			return false;
		}
		//alert(uploadNum);
		var openUrl = "upload/toUpload?folderName="+name+"&id="+id+"&uploadType=pic&code="+uuid+"&uploadNum="+uploadNum;	//弹出窗口的url
		var iWidth=800; //弹出窗口的宽度;
		var iHeight=600; //弹出窗口的高度;
		var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
		window.open(openUrl,"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft);
        }
	
	//删除文件
	function delfile(){
		var code = $("#code").val();
		var r = confirm("确定要删除照片吗？");
		if(!r){
			return false;
		}
		$.ajax({
			type : 'POST',
			url : 'upload/delfile',
			dataType : 'json',
			data : {uuid:code,uploadType:'pic'},
			cache : false,

			success : function(data) {
				if (data.code == 1) {
					$.messager.show({
						title : '系统消息',
						msg : '删除照片成功!'
					});
					$('#uploadBtn').html('上传照片');
					$('#fileurl').html("");
					$('#download').html("");
					$('#delfile').html("");
					uploadNum = 2;
				} else {
					$.messager.show({
						title : '系统消息',
						msg : '删除照片失败!'
					});
				}
			},
			error : function(r) {
				$.messager.show({
					title : '系统消息',
					msg : '删除照片失败!'
				});
			}
		
		});
	}
	
	//为系统编码生成uuid,用于文件上传
	function getUUID() {
	    var s = [];
	    var hexDigits = "0123456789abcdef";
	    for (var i = 0; i < 36; i++) {
	        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
	    }
	    s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
	    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
	    s[8] = s[13] = s[18] = s[23] = "-";
	 
	    var uuid = s.join("");
	    return uuid;
	}
	
	//下载文件
	
	function down() { 
		var selected = $('#u_dg').datagrid('getSelections');
		var folderName = $('#phone_number').val();
		var fileName = $('#fileurl').html();
		url="upload/download?folderName="+folderName+"&name="+fileName;
		url = encodeURI(url);
        try{ 
            var elemIF = document.createElement("iframe");   
            elemIF.src = url;   
            elemIF.style.display = "none";   
            document.body.appendChild(elemIF);   
        }catch(e){ 
 
        } 
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
			查询条件： <input class="easyui-textbox" data-options="prompt:'请输入司机姓名'"
				name="s_userName" id="s_userName"> <a
				href="javascript:searchRole(this.value)" class="easyui-linkbutton"
				iconCls='icon-search' plain="true">查询</a>
		</div>
	</div>
	<!-- 数据 -->
	<div id="u_dg"></div>
	<!-- toolbar工具栏 -->


	<!-- 添加司机dialog -->
	<div id="u_dialog" class="easyui-dialog" iconCls="icon-userManage"
		modal="true" style="width: 570px; height: 400px; padding: 10px 20px"
		closed="true" buttons="#addbtn">

		<div style="padding: 10px 60px 20px 60px">
			<form id="driverForm" class="easyui-form" method="post"
				data-options="novalidate:true">
				<table cellpadding="5" border="1" style="margin:0 auto;">
					
					<tr>
						<td colspan="2" style="text-align:center;"><h3>司机信息</h3></td>
						
					</tr>
					<tr>
						<td>系统编号:</td>
						<td>
							<input type="text" class="myinput" readonly="readonly" id="code" name="pic_code">
						</td>
					</tr>
					<tr>
						<td>姓名:<input type="hidden" id="id" name="id" /></td>
						<td><input id="name" class="myinput"  type="text" name="name"/>
						</td>
					</tr>
					<tr>
						<td>身份证号:</td>
						<td><input id="card_no" maxlength="18"
							class="myinput" name="id_card_number" onkeyup="value=value.replace(/[^\d\.]/g,'')"
							/></td>
					</tr>
					<tr>
						<td>手机号:</td>
						<td><input class="myinput" id="phone_number" type="text" maxlength="11"
							name="phone_number" onkeyup="value=value.replace(/[^\d\.]/g,'')"/></td>
					</tr>
					<tr>
						<td>照片:</td>
						<td>
							<button id="uploadBtn" onclick="upload()">上传照片</button>
							<a href="javascript:void(0);" id="fileurl"></a>
							&nbsp;&nbsp;
							<a class="down_a" href="javascript:void(0);" title="点击下载文件" onclick="down()" id="download"></a>
							&nbsp;&nbsp;
							<a href="javascript:void(0);" title="点击删除文件" onclick="delfile()" id="delfile"></a>
						</td>
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