<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/includes/common.jsp"%>
<title>用户管理</title>
<!-- My97DatePicker -->
<script type="text/javascript" src="http://czhw.org:9190/resources/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/util.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="css/bootstrap/js/bootstrap.min.js"></script>
<!-- <script type="text/javascript">
	var UUID;
	var COMPANY;
	$(function() {	

		
		$("#u_dg").datagrid({
			idField : 'id',
			iconCls : 'icon-userManage',
			striped : true,
			loadMsg : '数据正在加载中，请稍后.....',
			rownumbers : true,//行号
			url : 'restInfo/listAllRestInfo',
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
				handler : deleteUser
			}, '-', {
				text : '餐厨桶绑定信息',
				iconCls : 'icon-tip',
				handler : addOpenDialog
			} ],
			columns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				sortable : 'true',
				field : 'id',
				title : '编号',
				width : 120,
				align : 'center'
			}, {
				field : 'name',
				title : '餐饮企业简称',
				width : 350,
				align : 'center'
			}, {
				field : 'area_name',
				title : '省市区',
				width : 300,
				align : 'center'
			}, {
				field : 'street_name',
				title : '街道',
				width : 400,
				align : 'center'
			}, {
				field : 'restaurant_address',
				title : '地址',
				width : 350,
				align : 'center',
			}, {
				field : 'classes_name',
				title : '企业类型',
				width : 300,
				align : 'center'
			}, {
				field : 'table_index',
				title : '桌数',
				width : 150,
				align : 'center'
			}, {
				field : 'seat_index',
				title : '餐位数',
				width : 150,
				align : 'center'
			}, {
				field : 'last_used_barrel',
				title : '已绑定桶数',
				width : 300,
				align : 'center',
				formatter : function(value, row, index) {
					if(!value){
						return '暂无记录';
					}else{
						return value;
					}
				}
			},{
				field : 'last_collect_num',
				title : '最近一次收集量(吨)',
				width : 300,
				align : 'center',
				formatter : function(value, row, index) {
					if(!value){
						return '暂无记录';
					}else{
						return value;
					}
				}
			},{
				field : 'last_collect_date',
				title : '最近一次收集日期',
				width : 350,
				align : 'center',
				formatter : function(value, row, index) {
					if(value){
						var unixTimestamp = value.substring(0,19);
						return unixTimestamp.toLocaleString();
					}else{
						return '暂无记录';
					}
				}
			},{
				field : 'signing_date',
				title : '登记日期',
				width : 350,
				align : 'center',
				/* formatter : function(value, row, index) {
					var unixTimestamp = new Date(value);
					return unixTimestamp.toLocaleString();
				} */
			},{
				field : 'business_status',
				title : '营业状态',
				width : 150,
				align : 'center'
			},{
				field : 'open_date',
				title : '开业日期',
				width : 350,
				align : 'center',
				/* formatter : function(value, row, index) {
					var unixTimestamp = new Date(value);
					return unixTimestamp.toLocaleString();
				} */
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
		
		$('#b_dialog').dialog({
		    left:0,
		    top:0 
		});
		
		//页面初始化结束--------------------------------------------------------------------		
	});
	

	// 查询
	function searchRole() {
		//获取值
		var key = $("#s_name").val();
		//提交表单，查询，dataGrid有个方法，直接向服务器发送请求
		$("#u_dg").datagrid('load', {
			key : key
		});
	}
	
	
	

	var url;

	// 新增用户Dialog
	function saveOpenDialog() {
		url = '${pageContext.request.contextPath }/restInfo/add';
		uploadNum = 0;
		var uuid = getuuid();
		$('#uploadBtn').html('上传文件');
		$('#fileurl').html("");
		$('#download').html("");
		$('#delfile').html("");
		$("#restaurantForm").form("clear");
		$('#code').val(uuid);
		$("input[name='business_status']").get(0).checked = true;
		$("#document_type_name").val(0); 
		$("#permit").val('无');
		$("#classes_name").val('未选择');
		$("#type_name").val('大型');
		$("input[name='use_before_lola']").get(0).checked = true;
		$('#u_dialog').dialog("setTitle", '&nbsp;添加门店信息').dialog('center')
				.dialog('open');
	}
	
	
	// 编辑用户Dialog
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
		url = '${pageContext.request.contextPath }/restInfo/updateRestInfo';
		//清空表单
		$('#restaurantForm').form('clear');
		//文件栏初始化
		$('#fileurl').html('');
		$('#download').html('');
		$('#delfile').html('');
		//选中checkbox
		if(selected[0].meal_time){
			var arr = selected[0].meal_time.split(',');
			$(arr).each(function (i,dom){
		        $(":checkbox[value='"+dom+"']").prop("checked",true);
		    });
		}
		
		
		
		//文件栏填充信息
		var file_ = selected[0].sy_contract_file;
		if(file_){
			var filearr = file_.split("\\");
			var num = filearr.length-1;
			var fileName_ = filearr[num];
			$('#fileurl').html(fileName_);
			$('#uploadBtn').html('文件替换');
			$('#download').html('<span class="down">下载文件</span>');
			$('#delfile').html('<span class="del">删除文件</span>');
		}
		
		// 填充表单数据
		$('#restaurantForm').form('load', {
			id : selected[0].id,
			code: selected[0].code,
			name : selected[0].name,
			area_name : selected[0].area_name,
			street_name : selected[0].street_name,
			restaurant_address : selected[0].restaurant_address,
			business_status : selected[0].business_status,
			register_date : selected[0].register_date,
			open_date : selected[0].open_date,
			close_date : selected[0].close_date,
			contact_person : selected[0].contact_person,
			contact_phone : selected[0].contact_phone,
			unit_name : selected[0].unit_name,
			unit_address : selected[0].unit_address,
			legal_pepresentative : selected[0].legal_pepresentative,
			phone_number : selected[0].phone_number,
			document_type_name : selected[0].document_type_name,
			document_no : selected[0].document_no,
			permit : selected[0].permit,
			permit_no : selected[0].permit_no,
			classes_name : selected[0].classes_name,
			meal_range : selected[0].meal_range,
			business_area : selected[0].business_area,
			table_index : selected[0].table_index,
			seat_index : selected[0].seat_index,
			use_before_lola : selected[0].use_before_lola,
			type_name : selected[0].type_name,
			longitude : selected[0].longitude,
			latitude : selected[0].latitude,
			longitude_done : selected[0].longitude_done,
			latitude_done : selected[0].latitude_done,
			daily_output : selected[0].daily_output,
			declare_food_fesidue : selected[0].declare_food_fesidue,
			declare_dirty_oil : selected[0].declare_dirty_oil,
			declare_frying_oil : selected[0].declare_frying_oil,
			contract_no : selected[0].contract_no,
			sy_company_name : selected[0].sy_company_name,
			signing_date : selected[0].signing_date,
			contract_length : selected[0].contract_length,
			start_collect_time : selected[0].start_collect_time,
			end_collect_time : selected[0].end_collect_time,
			start_collect_time2 : selected[0].start_collect_time2,
			end_collect_time2 : selected[0].end_collect_time2,
			remark : selected[0].remark
		});
		$('#u_dialog').dialog("setTitle", '&nbsp;编辑门店信息').dialog('center')
				.dialog('open');
	}

	// 删除商家
	function deleteUser() {
		var selected = $('#u_dg').datagrid('getSelections');
		//window.alert(selected.length);
		if (selected.length < 1) {
			$.messager.alert('系统消息', '请先选择要删除的门店数据!', 'info');
			return;
		}
		url = '${pageContext.request.contextPath }/restInfo/deleteRestInfo';
		//构造restId
		var restArr = [];
		for (var i = 0; i < selected.length; i++) {
			restArr.push(selected[i].id);
		}
		var ids = restArr.join(',');
		var codeArr = [];
		for (var i = 0; i < selected.length; i++) {
			codeArr.push(selected[i].code);
		}
		var codes = codeArr.join(',');
		$.messager.confirm('系统提示信息', '您确定要删除所有选中的门店记录吗?', function(r) {
			if (r) {
				//发送ajax请求道服务器 
				$.ajax({
					type : "post",
					url : url,
					data : {
						ids : ids,
						codes:codes
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
		$("#restaurantInfo").form("clear");
		$('#u_dialog').dialog("close");
		// 刷新当前数据表格
		$('#u_dg').datagrid('reload');
		//  清空idField(这一步，一定要做)   
		$('#u_dg').datagrid('unselectAll');
		clearTip();
	}
	
	// 关闭绑定 Dialog
	function bcloseDialog() {
		$("#bindingForm").form("clear");
		$('#b_dialog').dialog("close");
		// 刷新当前数据表格
		$('#u_dg').datagrid('reload');
		//  清空idField(这一步，一定要做)   
		$('#u_dg').datagrid('unselectAll');

	}


	// 提交表单
	function doSubmit() {
		
		var street_name = $("#street_name").val().trim();
		var name = $("#name").val().trim();
		var restaurant_address = $("#restaurant_address").val().trim();
		var unit_name = $("#unit_name").val().trim();
		var register_date = $('#register_date').val();
		var open_date = $('#open_date').val();
		var classes_name = $("#classes_name").val();
		var type_name = $("#type_name").val();
		var longitude_done = $("#longitude_done").val().trim();
		var latitude_done = $("#latitude_done").val().trim();
		var signing_date = $('#signing_date').val().trim();
		var start_collect_time = $('#start_collect_time').val().trim();
		var end_collect_time = $('#end_collect_time').val().trim();
		if (!street_name || !name) {
			$.messager.alert('系统消息', '所属街道或店铺名不能为空！', 'info');
			return;
		} else if (!restaurant_address||!unit_name) {
			$.messager.alert('系统消息', '门店地址或单位名不能为空！', 'info');
			return;
		}else if (!open_date) {
			$.messager.alert('系统消息', '请选择开业日期！', 'info');
			return;
		}else if (!signing_date||!register_date) {
			$.messager.alert('系统消息', '您尚未选择登记日期或协议签约日期！', 'info');
		} else if (!classes_name || !type_name) {
			$.messager.alert('系统消息', '单位类型或企业规模不能为空！', 'info');
		}else if (!longitude_done || !latitude_done) {
			$.messager.alert('系统消息', '偏转后经度或偏转后纬度不能为空！', 'info');
		}else if (!start_collect_time || !end_collect_time) {
			$.messager.alert('系统消息', '请选择约定上门收集时间段！', 'info');
		} else { 
			$.ajax({
				type : 'POST',
				url : url,
				dataType : 'json',
				data : $('#restaurantForm').serialize(),
				cache : false,

				success : function(data) {
					if (data.code == 1) {
						// 刷新当前数据表格
						$('#u_dg').datagrid('reload');
						//  清空idField(这一步，一定要做)   
						$('#u_dg').datagrid('unselectAll');
						$.messager.show({
							title : '系统消息',
							msg : '操作门店信息成功!'
						});
					} else {
						$.messager.show({
							title : '系统消息',
							msg : '操作门店信息失败!'
						});
					}
				},
				error : function(r) {
					$.messager.show({
						title : '系统消息',
						msg : '操作门店信息失败!'
					});
				}
			});
		//}

		// 关闭dialog
		$('#u_dialog').dialog('close');
		}
	}

	// 关闭角色窗口
	function closeRoleDialog() {
		$("#r_dialog").dialog('close');
	}

	

	// 清空提示信息
	function clearTip() {
		$('#tipAddFactory').html('');
		$('#tipAddAccount').html('');
		$('#tipUpdateAccount').html('');
	}
	
	function getMap(){
		var openUrl = "restInfo/toMap";//弹出窗口的url
		var iWidth=800; //弹出窗口的宽度;
		var iHeight=600; //弹出窗口的高度;
		var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
		window.open(openUrl,"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft); 
		
	}
	
	
	
	var uploadNum = 0;
	//文件上传
	function upload() {
		uploadNum++;
		url = '${pageContext.request.contextPath }/restInfo/updateByCode';
		var name = $('#name').val();
		var id = $('#id').val();
		var uuid = $("#code").val();
		var openUrl = "upload/toUpload?code="+uuid+"&folderName="+uuid+"&id="+id+"&uploadNum="+uploadNum;	//弹出窗口的url
		var iWidth=800; //弹出窗口的宽度;
		var iHeight=600; //弹出窗口的高度;
		var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
		window.open(openUrl,"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft);
        }
	
	//删除文件
	function delfile(){
		var code = $("#code").val();
		var r = confirm("确定要删除文件吗？");
		if(!r){
			return false;
		}
		$.ajax({
			type : 'POST',
			url : 'upload/delfile',
			dataType : 'json',
			data : {uuid:code},
			cache : false,

			success : function(data) {
				if (data.code == 1) {
					$.messager.show({
						title : '系统消息',
						msg : '删除文件成功!'
					});
					$('#uploadBtn').html('上传文件');
					$('#fileurl').html("");
					$('#download').html("");
					$('#delfile').html("");
					uploadNum = 2;
				} else {
					$.messager.show({
						title : '系统消息',
						msg : '删除文件失败!'
					});
				}
			},
			error : function(r) {
				$.messager.show({
					title : '系统消息',
					msg : '删除文件失败!'
				});
			}
		
		});
	}
	
	//下载文件
	function down() { 
		var selected = $('#u_dg').datagrid('getSelections');
		var folderName = $('#code').val();
		var fileName = $('#fileurl').html();
		var url_="upload/download?folderName="+folderName+"&name="+fileName;
		url_ = encodeURI(url_);
        try{ 
            var elemIF = document.createElement("iframe");   
            elemIF.src = url_;   
            elemIF.style.display = "none";   
            document.body.appendChild(elemIF);   
        }catch(e){ 
 
        } 
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
	
	// 绑定桶Dialog
	function addOpenDialog() {

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
		var selected = $('#u_dg').datagrid('getSelections');
		var shop = selected[0].name;
		var shopId = selected[0].id;
		$('#shopName').html(shop);
		$('#hasBind').html("");
		$('#willBind').html("");
		getHasBind(shopId);
		getWillBind(shopId);
		
		
		$('#b_dialog').dialog("setTitle", '&nbsp;绑定桶信息').dialog('center')
				.dialog('open');
	}
	
	/*  
    js由毫秒数得到年月日  
           使用： (new Date(data[i].creationTime)).Format("yyyy-MM-dd hh:mm:ss.S")  
    */
	Date.prototype.Format = function (fmt) { //author: meizz  
        var o = {  
            "M+": this.getMonth() + 1, //月份  
            "d+": this.getDate(), //日  
            "h+": this.getHours(), //小时  
            "m+": this.getMinutes(), //分  
            "s+": this.getSeconds(), //秒  
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度  
            "S": this.getMilliseconds() //毫秒  
        };  
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
        for (var k in o)  
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));  
        return fmt;  
    };  
	    
	function getHasBind(shopId){
		//获取所有可绑定桶信息
		$.ajax({
			type : 'POST',
			url : 'rest2bucket/getHasBinding',
			dataType : 'json',
			data : {restId:shopId},
			cache : false,

			success : function(data) {
				console.log(data);
				if(data.length==0){
					$('#hasBind').append('<span>当前暂未绑定餐厨桶。</span>');
					$('#hasBindNum').html(0);
				}else{
					$('#hasBindNum').html(data.length);
					for(var i=0;i<data.length;i++){
						var date = new Date(data[i].binding_date).Format("yyyy-MM-dd hh:mm:ss.S");
						date = date.substr(0,19);
						console.log("日期:"+date);
						$('#hasBind').append(
						'<input type="checkbox" checked="checked" onclick="change(this.name,this.value,'+shopId+')"id="'+data[i].bucket_id+'" name="'+shopId+'" value="'+data[i].bucket_id+'" />'+data[i].bucket_code+"-"+"绑定时间："+date+'&nbsp;&nbsp;');
					}
				}
				
				
			},
			error : function(r) {
				$.messager.show({
					title : '系统消息',
					msg : ''
				});
			}
		
		});
	}
	
	function getWillBind(shopId){
		//获取所有可绑定桶信息
		$.ajax({
			type : 'POST',
			url : 'bucket/getAllBucket',
			dataType : 'json',
			//data : {uuid:code},
			cache : false,

			success : function(data) {
				console.log(data);
				if(data.length==0){
					$('#willBind').append('<span>暂无餐厨桶可绑定,可前往餐厨桶信息管理添加桶信息。</span>');
					$('#willBindNum').html(0);
				}else{
					$('#willBindNum').html(data.length);
					for(var i=0;i<data.length;i++){
						$('#willBind').append(
						'<input type="checkbox" onclick="change(this.name,this.value,'+shopId+')"id="'+data[i].id+'" name="'+shopId+'" value="'+data[i].id+'" />'+data[i].bucket_code+"&nbsp;&nbsp;");
					}
				}
				
				
			},
			error : function(r) {
				$.messager.show({
					title : '系统消息',
					msg : ''
				});
			}
		
		});
	}
	
	
	
	function change(restId,bucketId,shopId){
		
		//alert("restId:"+restId+"bucketId:"+bucketId);
		var url = "rest2bucket/unbindingBucket";
		var checked = $('#'+bucketId).is(':checked');
		if(checked){
			url = "rest2bucket/bindingBucket";
			msg = '绑定成功!';
			err = '解绑失败';
		}
		
		$.ajax({
			type : 'POST',
			url : url,
			dataType : 'json',
			data : {restId:restId,bucketId:bucketId},
			cache : false,

			success : function(data) {
				if(data.code==1){
					$('#hasBind').html("");
					$('#willBind').html("");
					getHasBind(shopId);
					getWillBind(shopId);
					$.messager.show({
						title : '系统消息',
						msg : '操作成功!'
					});
				}
				
				
			},
			error : function(r) {
				$.messager.show({
					title : '系统消息',
					msg : '操作失败!'
				});
			}
		
		});
	}
	
</script>
<style>
.myinput {
	padding: 3px;
	width: 165px;
	height: 15px;
	border-radius: 5px;
}

textarea {
	padding: 5px;
	width: 97%;
}

tr {
	height: 35px;
}

#td div {
	width: 80px;
}

#fileurl {
	color: #fff;
}

a#fileurl:hover {
	color: #fff;
}

.down {
	color: #05a4d6;
}

a.down_a:hover {
	color: #05a4d6;
}

.del {
	color: red;
}
</style> -->
</head>

<!-- <body class="easyui-layout">
	<div class="easyui-panel" id="utbar">
		<div style="margin-left: 5px">
			查询条件： <input class="easyui-textbox"
				data-options="prompt:'餐饮企业简称或省市区'" id="s_name"> <a
				href="javascript:searchRole(this.value)" class="easyui-linkbutton"
				iconCls='icon-search' plain="true">查询</a>
		</div>
	</div>
	数据
	<div id="u_dg"></div>
	toolbar工具栏


	添加用户dialog
	<div id="u_dialog" class="easyui-dialog" iconCls="icon-userManage"
		modal="true"
		style="width: 750px; height: 550px; padding: 10px 20px; margin-top: 5%;"
		closed="true" buttons="#addbtn">

		<div style="padding: 10px 60px 20px 60px; border: 0px solid red;">
			<form id="restaurantForm" class="easyui-form" method="post"
				enctype="multipart/form-data" data-options="novalidate:true">
				<table cellpadding="5" border="1" width="100%"
					style="margin: 0 auto;">
					<tr>

						<td colspan="4">
							<h3>基本资料</h3> <input type="hidden" id="id" name="id" />

						</td>
					</tr>
					<tr>
						<td>系统编号:</td>
						<td colspan="3"><input id="code" class="myinput"
							style="width: 285px;" type="text" name="code"
							placeholder="系统自动生成" readonly="readonly" /></td>
					</tr>
					<tr>
						<td id="td"><div>区域:</div></td>
						<td><input id="area_name" onclick="getCity(this.value)"
							type="text" class="myinput" name="area_name"
							placeholder="选择门店所属省市区" readonly="readonly" /></td>
						<td><div>街道(镇):</div></td>
						<td><input id="street_name" type="text" class="myinput"
							name="street_name" onfocus="clearTip()" placeholder="(必填项)" /></td>
					</tr>
					<tr>
						<td>门店简称:</td>
						<td><input class="myinput" id="name" type="text" name="name"
							onfocus="clearTip()" placeholder="(必填项)" /></td>
						<td>门店地址:</td>
						<td><input class="myinput" id="restaurant_address"
							type="text" name="restaurant_address" onfocus="clearTip()"
							placeholder="(必填项)" /></td>
					</tr>
					<tr>
						<td>营业状态:</td>
						<td><input type="radio" value="开业" name="business_status">开业
							<input type="radio" value="歇业" name="business_status">歇业</td>
						<td>登记日期:</td>
						<td><input placeholder="请选择登记日期(必选)"
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,readOnly:true})"
							readonly="readonly" type="text" class="myinput"
							name="register_date" id="register_date"></td>
					</tr>
					<tr>
						<td>开业日期:</td>
						<td><input type="date" class="myinput" name="open_date"
							id="open_date" placeholder="请选择开业日期(必选)"
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,readOnly:true})"
							readonly="readonly"></td>
						<td>停业日期:</td>
						<td><input type="date" class="myinput" name="close_date"
							id="close_date" placeholder="请选择停业日期"
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,readOnly:true})"
							readonly="readonly"></td>
					</tr>
					<tr>
						<td>联系人:</td>
						<td><input class="myinput" id="contact_person" type="text"
							name="contact_person" /></td>
						<td>联系电话:</td>
						<td><input class="myinput" maxlength="11"
							onkeyup="value=value.replace(/[^\d\.]/g,'')" id="contact_phone"
							type="text" name="contact_phone" /></td>
					</tr>
					<tr>
						<td>单位简称:</td>
						<td><input class="myinput" id="unit_name" type="text"
							name="unit_name" onfocus="clearTip()" placeholder="(必填项)" /></td>
						<td>单位地址:</td>
						<td><input class="myinput" id="unit_address" type="text"
							name="unit_address" /></td>
					</tr>
					<tr>
						<td>法人代表:</td>
						<td><input class="myinput" id="legal_pepresentative"
							type="text" name="legal_pepresentative" /></td>
						<td>联系电话:</td>
						<td><input class="myinput" maxlength="11"
							onkeyup="value=value.replace(/[^\d\.]/g,'')" id="phone_number"
							type="text" name="phone_number" /></td>
					</tr>
					<tr>
						<td>证件类型:</td>
						<td><select id="document_type_name" name="document_type_name">
								<option value="0" selected="selected">--请选择--</option>
								<option value="营业执照">营业执照</option>
								<option value="组织机构代码证">组织机构代码证</option>
						</select></td>
						<td>证件编号:</td>
						<td><input class="myinput" ime-mode:disabled id="document_no"
							type="text" name="document_no" /></td>
					</tr>
					<tr>
						<td>餐饮服务许可证:</td>
						<td><select id="permit" name="permit">
								<option value="有">有</option>
								<option value="无">无</option>
						</select></td>
						<td>餐饮服务许可证编号:</td>
						<td><input class="myinput" ime-mode:disabled id="permit_no"
							type="text" name="permit_no" placeholder="(必填项)" /></td>
					</tr>
					<tr>
						<td>单位类型:</td>
						<td><select id="classes_name" name="classes_name">
								<option value="未选择">--请选择--</option>
								<option value="中餐厅">中餐厅</option>
								<option value="西餐厅">西餐厅</option>
								<option value="快餐店">快餐店</option>
								<option value="综合体">综合体</option>
								<option value="美食街">美食街</option>
								<option value="单位食堂">单位食堂</option>
								<option value="学校食堂">学校食堂</option>
								<option value="医院食堂">医院食堂</option>
								<option value="茶艺厅">茶艺厅</option>
								<option value="咖啡厅">咖啡厅</option>
								<option value="酒吧">酒吧</option>
								<option value="夜总会">夜总会</option>
								<option value="食品加工">食品加工</option>
						</select></td>
						<td>供餐规模:</td>
						<td><input class="myinput"
							onkeyup="value=value.replace(/[^\d\.]/g,'')" id="meal_range"
							type="text" name="meal_range" onfocus="clearTip()" /></td>
					</tr>
					<tr>
						<td>供餐时间:</td>
						<td id="meal"><span id="breakfast"> <input
								name="meal_time" value="breakfast" type="checkbox">早餐
						</span> <span id="lunch"> <input name="meal_time" value="lunch"
								type="checkbox">午餐
						</span> <span id="dinner"> <input name="meal_time" value="dinner"
								type="checkbox">晚餐
						</span> <span id="snack"> <input name="meal_time" value="snack"
								type="checkbox">夜宵
						</span></td>
						<td>供餐、加工营业面积(平方米):</td>
						<td><input class="myinput"
							onkeyup="value=value.replace(/[^\d\.]/g,'')" id="business_area"
							type="text" name="business_area" /></td>
					</tr>
					<tr>
						<td>桌数:</td>
						<td><input class="myinput"
							onkeyup="value=value.replace(/[^\d\.]/g,'')" id="table_index"
							type="text" name="table_index" /></td>
						<td>餐位数:</td>
						<td><input class="myinput"
							onkeyup="value=value.replace(/[^\d\.]/g,'')" id="seat_index"
							type="text" name="seat_index" /></td>
					</tr>
					<tr>
						<td>是否使用偏转前经纬度:</td>
						<td><input type="radio" name="use_before_lola" value="是">是
							<input type="radio" name="use_before_lola" value="否"
							checked="checked">否</td>
						<td>企业规模:</td>
						<td><input class="myinput"
							onkeyup="value=value.replace(/[^\d\.]/g,'')" id="type_name"
							type="text" name="type_name" placeholder="(必填项)" />
							<select id="type_name" name="type_name">
								<option value="大型" selected="selected">大型</option>
								<option value="中型">中型</option>
								<option value="小型">小型</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><input class="myinput" id="longitude" type="hidden"
							name="longitude" /></td>
						<td></td>
						<td><input class="myinput" id="latitude" type="hidden"
							name="latitude" /></td>
					</tr>
					<tr>
						<td>地址经维度(用于车辆路线安排):</td>
						<td><input class="myinput" id="longitude_done" type="text"
							name="longitude_done" placeholder="(必填项)" /></td>
						<td><input class="myinput" id="latitude_done" type="text"
							name="latitude_done" placeholder="(必填项)" /></td>
						<td><button onclick="getMap()">定位</button></td>
					</tr>
					<tr>
						<td colspan="4"><h3>收运信息</h3></td>
					</tr>
					<tr>
						<td>日均产生量(吨):</td>
						<td><input class="myinput"
							onkeyup="value=value.replace(/[^\d\.]/g,'')" id="daily_output"
							type="text" name="daily_output" /></td>
						<td>申报食物残余(吨):</td>
						<td><input class="myinput"
							onkeyup="value=value.replace(/[^\d\.]/g,'')"
							id="declare_food_fesidue" type="text" name="declare_food_fesidue" /></td>
					</tr>
					<tr>
						<td>申报地沟油(吨):</td>
						<td><input class="myinput"
							onkeyup="value=value.replace(/[^\d\.]/g,'')"
							id="declare_dirty_oil" type="text" name="declare_dirty_oil" /></td>
						<td>申报煎炸老油(吨):</td>
						<td><input class="myinput"
							onkeyup="value=value.replace(/[^\d\.]/g,'')"
							id="declare_frying_oil" type="text" name="declare_frying_oil" /></td>
					</tr>
					<tr>
						<td>收运协议编号:</td>
						<td><input class="myinput" ime-mode:disabled id="contract_no"
							type="text" name="contract_no" /></td>
						<td>签约收运企业:</td>
						<td><input class="myinput" id="sy_company_name" type="text"
							name="sy_company_name" /></td>
					</tr>
					<tr>
						<td>协议签订日期:</td>
						<td><input class="myinput" id="signing_date" type="text"
							name="signing_date" placeholder="请选择协议签订日期(必填)"
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,readOnly:true})"
							readonly="readonly" /></td>
						<td>协议年限(年):</td>
						<td><input class="myinput"
							onkeyup="value=value.replace(/[^\d\.]/g,'')" id="contract_length"
							type="text" name="contract_length" /></td>
					</tr>
					<tr>
						<td>约定上门收集时间段1:</td>
						<td colspan="3"><input class="myinput"
							id="start_collect_time" type="text" name="start_collect_time"
							placeholder="请选择开始时间(必选)"
							onclick="WdatePicker({dateFmt:'HH:mm:ss',maxDate:'#F{$dp.$D(\'start_collect_time\')}',isShowClear:false,readOnly:true})"
							readonly="" />&nbsp;至: <input class="myinput"
							id="end_collect_time" type="text" name="end_collect_time"
							placeholder="请选择结束时间(必选)"
							onclick="WdatePicker({dateFmt:'HH:mm:ss',maxDate:'#F{$dp.$D(\'end_collect_time\')}',isShowClear:false,readOnly:true})"
							readonly="" /></td>
					</tr>
					<tr>
						<td>约定上门收集时间段2:</td>
						<td colspan="3"><input class="myinput"
							id="start_collect_time2" type="text" name="start_collect_time2"
							placeholder="请选择开始时间"
							onclick="WdatePicker({dateFmt:'HH:mm:ss',maxDate:'#F{$dp.$D(\'start_collect_time2\')}',isShowClear:false,readOnly:true})"
							readonly="" />&nbsp;至: <input class="myinput"
							id="end_collect_time2" type="text" name="end_collect_time2"
							placeholder="请选择结束时间"
							onclick="WdatePicker({dateFmt:'HH:mm:ss',maxDate:'#F{$dp.$D(\'end_collect_time2\')}',isShowClear:false,readOnly:true})"
							readonly="" /></td>
					</tr>
					<tr>
						<td>文件上传:</td>
						<td colspan="3">
							<button id="uploadBtn" onclick="upload()">上传文件</button> <a
							href="javascript:void(0);" id="fileurl"></a> &nbsp;&nbsp; <a
							class="down_a" href="javascript:void(0);" title="点击下载文件"
							onclick="down()" id="download"></a> &nbsp;&nbsp; <a
							href="javascript:void(0);" title="点击删除文件" onclick="delfile()"
							id="delfile"></a>
						</td>
					</tr>
					<tr>
						<td>备注:</td>
						<td colspan="3"><textarea name="remark"></textarea></td>
					</tr>
				</table>
			</form>

		</div>

	</div>
	<div id="addbtn">
		<a href="javascript:doSubmit()" class="easyui-linkbutton"
			iconCls='icon-ok'>提交</a> <a href="javascript:closeDialog()"
			class="easyui-linkbutton" iconCls='icon-clear'>关闭</a>
	</div>


	绑定桶弹窗=========================================================================================
	绑定dialog
	<div id="b_dialog" class="easyui-dialog" iconCls="icon-userManage"
		modal="true"
		style="width: 830px; height: 550px; padding: 10px 20px; top: 0;"
		closed="true" buttons="#baddbtn">

		<div style="padding: 10px 25px 20px 0px; border: 0px solid red;">
			<form id="bindingForm" class="easyui-form" method="post"
				enctype="multipart/form-data" data-options="novalidate:true">
				<table cellpadding="5" border="1" width="100%" style="">
					<tr>
						<td style="text-align: center;">
							<h3>
								<span id="shopName"></span>●餐厨桶绑定信息
							</h3> <br>
						<span style="color: green;">Tip:勾选即可完成绑定与解绑。</span> <input
							type="hidden" id="bRestId" name="bRestId" />
						</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;当前已绑定 [<span id="hasBindNum"></span>]
						</td>
					</tr>
					<tr>
						<td style="padding: 5px;" id="hasBind"></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;所有可绑定 [<span id="willBindNum"></span>]
						</td>
					</tr>
					<tr>
						<td style="padding: 5px;" id="willBind"></td>
					</tr>

				</table>
			</form>
		</div>

	</div>
	<div id="baddbtn">
		<a href="javascript:doSubmitb()" class="easyui-linkbutton"
			iconCls='icon-ok'>提交</a> 
		<a href="javascript:bcloseDialog()" class="easyui-linkbutton"
			iconCls='icon-clear'>关闭</a>
	</div>
</body>
 -->
 <body>
 	<div class="wrap">
		<h2>添加商户</h2>
		<div class="form-inline">
			<div class="form-search">
				<div class="form-group">
				  <label class="col-sm-4 control-label">餐饮企业：</label>
				  <div class="col-sm-7">
				    <input type="text" class="form-control"  placeholder="">
				  </div>
				</div>
				<div class="form-group">
				  <label class="col-sm-4 control-label">区域：</label>
				  <div class="col-sm-7">
				    <input type="text" class="form-control"  placeholder="">
				  </div>
				</div>
				<div class="form-group">
				  <label class="col-sm-4 control-label">企业规模：</label>
				  <div class="col-sm-7">
					<select class="form-control">
					  <option>选择状态</option>
					</select>
				  </div>
				</div>
				<div class="form-group">
				  <label class="col-sm-4 control-label">企业类型：</label>
				  <div class="col-sm-7">
					<select class="form-control">
					  <option>选择状态</option>
					</select>
				  </div>
				</div>
				<div class="form-group">
				  <label class="col-sm-4 control-label">供餐规模：</label>
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
					<button type="button" class="btn btn-info">查询</button>
					<button type="button" class="btn btn-default">清空</button>
					<button type="button" class="btn btn-info">统计</button>
				</div>
			</div>
			<div class="form-container clearfix">
				<table class="table table-hover table-striped table-border">
					<thead>
						<tr>
							<th><input type="checkbox" /></th>
							<th>企业名称</th>
							<th>区域</th>
							<th>街道</th>
							<th>地址</th>
							<th>企业类型</th>
							<th>桶数</th>
							<th>收集量（kg）</th>
							<th>收集日期</th>
							<th>登记日期</th>
							<th>营业状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox" /></td>
							<td>麻巷银丝面馆</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
					<tfoot>
						<td colspan="12">
							<div class="fl pager">
								<span>全选</span>
								<button type="button" class="btn btn-info">导入</button>
								<button type="button" class="btn btn-info">导出</button>
								<button type="button" class="btn btn-info">新增</button>
								<button type="button" class="btn btn-info">批量删除</button>
							</div>
							<div class="fr">
								<ul class="pagination">
									<li>共有33条，每页显示：</li>
									<li>
									<select class="form-control">
									  <option>10</option>
									</select>
									</li>
								</ul>
								<ul class="pagination">
							        <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
							        <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
							        <li><a href="#">2</a></li>
							        <li><a href="#">3</a></li>
							        <li><a href="#">4</a></li>
							        <li><a href="#">5</a></li>
							        <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
							     </ul>
							     <ul class="pagination">
									<li><input type="text" class="form-control" style="width:40px;"></li>
									<li>
									<button type＝'button' class='btn btn-warning'>GO</button>
									</li>
								</ul>
							</div>
						</td>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
 </body>
 </html>