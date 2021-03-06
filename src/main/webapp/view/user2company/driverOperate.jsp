<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
  <head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>driverOperate</title>

  <!-- ========== Css Files ========== -->
  <link href="css/root.css" rel="stylesheet">

  </head>
  <body>
  <!-- Start Page Loading -->
  <div class="loading"><img src="img/loading.gif" alt="loading-img"></div>
  <!-- End Page Loading -->
 

<!-- START CONTENT -->
<div class="content">

  <!-- Start Presentation -->
  <div class="row presentation" style="padding:10px 35px">
    <div class="col-lg-8 col-md-6 titles">
      <h4>司机信息管理</h4>
    </div>
  </div>
  <!-- End Presentation -->

<!-- START CONTAINER -->
<div class="container-padding">

  <!-- Start Row -->
  <div class="row">

    <!-- Start Panel -->
    <div class="col-md-12">
      <div class="panel panel-default">
        <div class="panel-body table-responsive">

            <table id="dataTable" class="table display order-column" style="text-align:center;cursor:pointer;">
                <thead>
                    <tr>
                    	<th style="text-align:center;" data-orderable="false">序号</th>
                    	<th>ID</th>
                        <th style="text-align:center;">账号</th>
                        <th style="text-align:center;"data-orderable="false">密码</th>
                        <th style="text-align:center;"data-orderable="false">姓名</th>
                        <th style="text-align:center;">创建时间</th>
                        <th style="text-align:center;">是否可用</th>
                    </tr>
                </thead>
             
                <!-- <tfoot>
                    <tr>
                    	<th></th>
                    	<th>ID</th>
                        <th style="text-align:center;">账号</th>
                        <th style="text-align:center;">密码</th>
                        <th style="text-align:center;">姓名</th>
                        <th style="text-align:center;">创建时间</th>
                        <th style="text-align:center;">是否可用</th>
                    </tr>
                </tfoot> -->
             
                
            </table>

          <!-- Start Modal Code -->
            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
            	<div class="modal-dialog">
	                <div class="modal-content">
		                <div class="modal-header">
		                 	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		                    <h4 class="modal-title"><span id="head">新增用户</span></h4>
		                </div>
	                  	<div class="modal-body">
	                    	<div class="panel-body">
				              <form id="addForm" class="form-horizontal">
				
				                <div class="form-group">
				                  <label for="account" class="col-sm-2 control-label form-label">账号</label>
				                  <div class="col-sm-10">
				                  	<input type="hidden" name="id" id="id">
				                    <input maxlength="15" onfocus="clearTip()" type="text" onkeyup="this.value = this.value.replace(/[^0-9a-zA-Z@.\-]/g,'');validate(this.value);" class="form-control" name="userAccount" id="userAccount">
				                    <span id="helpBlock" style="margin-top:0px;margin-bottom:0px;" class="help-block"><i class="fa fa-exclamation-circle"></i> <span id="tip">提示信息</span></span>
				                  </div>
				                </div>
				
				                <div class="form-group">
				                  <label for="password" class="col-sm-2 control-label form-label">密码</label>
				                  <div class="col-sm-10">
				                    <input maxlength="15" onfocus="clearTip()" type="password" class="form-control" name="password" id="password" placeholder="">
				                  </div>
				                </div>
				
				                <div class="form-group ">
				                  <label for="userName" class="col-sm-2 control-label form-label">姓名</label>
				                  <div class="col-sm-10">
				                      <input maxlength="15" type="text" class="form-control" name="userName" id="userName">
				                  </div>
				                </div>
				                
				                <div class="form-group">
				                	<label for="enabled" class="col-sm-2 control-label form-label">账号状态</label>
					                <div class="col-sm-10">
					                    <select name="enabled" id="enabled" class="form-control">
					                      <option value="1">使用</option>
					                      <option value="0">禁用</option>
					                    </select>
					                </div>
				                </div>
				
				                <div class="form-group">
				                  <label for="remark" class="col-sm-2 control-label form-label">备注</label>
				                  <div class="col-sm-10">
				                      <textarea style="resize:none" class="form-control" rows="3" id="remark" placeholder=""></textarea>
				                  </div>
				                </div>
								
				              </form> 
				
				            </div>
	                  	</div>
		                <div class="modal-footer">
		                   <button id="bClose" type="button" class="btn btn-white" data-dismiss="modal">关闭窗口</button>
		                   <button id="bAdd" onclick="add()" type="button" class="btn btn-default">保存用户</button>
		                   <button id="bDelete" onclick="del()" type="button" class="btn btn-danger">删除用户</button>
		                   <button id="bUpdate" onclick="update()" type="button" class="btn btn-success">更新账号</button>
		                </div>
	                </div>
            	</div>
            </div>

          <!-- End Modal Code -->


      </div>
    </div>
    <!-- End Panel -->

  </div>
  <!-- End Row -->

</div>
<!-- END CONTAINER -->

</div>


<!-- ================================================
jQuery Library
================================================ -->
<script type="text/javascript" src="js/jquery.min.js"></script>

<!-- ================================================
Bootstrap Core JavaScript File
================================================ -->
<script src="js/bootstrap/bootstrap.min.js"></script>

<!-- ================================================
Plugin.js - Some Specific JS codes for Plugin Settings
================================================ -->
<script type="text/javascript" src="js/plugins.js"></script>

<!-- ================================================
Data Tables
================================================ -->
<!-- <script src="js/datatables/datatables.min.js"></script> -->
<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>



<script>

var oldAccount;

$(document).ready(function() {
	
	
    var t = $('#dataTable').DataTable({
    	scrollY:        '50vh',
        scrollCollapse: true,
    	"processing": true,
        "serverSide": true,
        "ajax":"user/listAllUser",
        "deferRender": true, //延迟加载数据
        	
        "columnDefs": [//用于隐藏字段  
    	             {  "searchable": false,
    	                 "orderable": false,
    	                 "targets": 0
    	             }  
    	        ], 
    	"columns": [
					{ "data": null,"targets": 0 },
                    { "data": "id","visible": false },
                    { "data": "user_account" },
                    { "data": "password" },
                    { "data": "user_name" },
                    { "data": "create_time" },
                    { "data": "enabled" }
                ],
    	"paging":   true,		//分页
    	"bFilter" : true,		// 搜索栏
    	"pagingType": "full_numbers",
        "ordering": true,		//排序
        "order": [[ 1, "asc" ]],
        "info":     true,		//显示总共有几条记录
        //"order": [[ 3, "desc" ]]//默认排序 从0开始算
        "language": {
            "decimal":        "",
            "emptyTable":     "暂无记录",
            "info":           "当前显示_START_ 到 _END_ / 总记录数 _TOTAL_",
            "infoEmpty":      "展示 0 to 0 of 0 数据记录",
            "infoFiltered":   "(筛选自 _MAX_ 条记录)",
            "infoPostFix":    "",
            "thousands":      ",",
            "lengthMenu":     "每页显示 _MENU_ 条记录",
            "loadingRecords": "努力加载中...",
            "processing":     "努力加载中...",
            "search":         "关键字查询:",
            "zeroRecords":    "没有匹配的记录",
            "paginate": {
                "first":      "首页",
                "last":       "末页",
                "next":       "下一页",
                "previous":   "上一页"
            },
            "aria": {
                "sortAscending":  ": activate to sort column ascending",
                "sortDescending": ": activate to sort column descending"
            }
          },
          
          "createdRow": function ( row, data, index ) {//回调函数用于格式化返回数据
        	  			  if(!data.user_name){
        	  				$('td', row).eq(3).html("暂未填写");
        	  			  }
	                      if (data.create_time) {
	                    	  var unixTimestamp = new Date( data.create_time ) ;
	                    	  commonTime = unixTimestamp.toLocaleString();
	                          //$('td', row).eq(4).css("color","blue");
	                          $('td', row).eq(4).html(commonTime);
	                      }
	                      
	                      if (data.enabled) {
	                          $('td', row).eq(5).css("color","green");
	                          $('td', row).eq(5).html("账号可用");
	                      }else{
	                    	  $('td', row).eq(5).css("color","red");
	                          $('td', row).eq(5).html("账号不可用");
	                      }
	                  },
	     /*  "initComplete": function () {//初始化完成回调函数
		                      var api = this.api();
		                      api.$('td').click( function () {
		                          api.search( this.innerHTML ).draw();
		                      } );
		                  } */
	      /* "aoColumns": [//设置字段排序规则
	                      null,
	                      null,
	                      { "orderSequence": [ "asc" ] },
	                      { "orderSequence": [ "desc", "asc", "asc" ] },
	                      { "orderSequence": [ "desc" ] },
	                      null
	                    ] */
          "fnDrawCallback": function(){
	        		var api = this.api();
	        		var startIndex= api.context[0]._iDisplayStart;//获取到本页开始的条数
	        	    api.column(0).nodes().each(function(cell, i) {
	        		cell.innerHTML = startIndex + i + 1;
        		});
        	}

	     

    });
    
    /* t.on( 'order.dt search.dt', function () {
        t.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw(); */
    
    //添加工具条
    $("#dataTable_length").prepend('<div class="btn-group" role="group" aria-label="..."><button  id="add" type="button" class="btn btn-light"><i class="fa  fa-plus"></i>新增用户</button><button id="refresh" type="button" class="btn btn-light"><i class="fa fa-refresh"></i>刷新数据</button><button type="button" class="btn btn-light"><i class="fa fa-cog"></i>用户设置</button></div> <br><br>');
    
    //tr绑定点击事件
    var table = $('#dataTable').DataTable();

    
    
    //单选tr
    $('#dataTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
            var data = table.row( this ).data();
            console.log(data);
            var form = $('#addForm'); 
        	$('#userAccount').val(data.user_account);
        	oldAccount = data.user_account;
        	$("#password").val(data.password);
        	$("#userName").val(data.user_name);
        	var enabled = data.enabled;
        	if(enabled){
        		$('#enabled').val(1);
        	}else{
        		$('#enabled').val(0);
        	}
        	$("#id").val(data.id);
            $('#myModal').modal();
        	$('#bClose').hide();
        	$('#bAdd').hide();
        	$('#bDelete').show();
        	$('#bUpdate').show();
        	$('#head').html("更新账号");
        	
        	}
         } );
    
 
    $('#refresh').click( function () {
        //table.row('.selected').remove().draw( false );
    	table.order( [[ 1, 'asc' ]] ).draw( false );
    } );
    
    $('#add').click(function(){
    	
    	$('#myModal').modal();
    	$('#bDelete').hide();
    	$('#bUpdate').hide();
    	$('#bClose').show();
    	$('#bAdd').show();
    	$('#head').html("新增用户");
    });
    
    
    //Modal 设置-------------------------
    /* $('#myModal').modal({
    	//backdrop:'static'
    }); */
    $('#myModal').on('hidden.bs.modal', function () {
    	  // 执行一些动作...
    	  //$('.modal-body').append('关闭modal后添加');
    	  $('#addForm')[0].reset();
    	  table.$('tr.selected').removeClass('selected');
    	});
    
} );
	
	//去除排序查询
	/* $.extend( true, $.fn.dataTable.defaults, {
	    "searching": false,
	    "ordering": false
	} ); */
	
	Date.prototype.toLocaleString = function() {
		
		//debugger;
		var Month = this.getMonth() + 1;
		var Date = this.getDate();
		var Hour = this.getHours();
		var Minute = this.getMinutes();
		var Seconds = this.getSeconds();
		if(Month<10){
			Month = "0" + Month;
		}
		if(Date<10){
			Date = "0" + Date;
		}
		if(Hour<10){
			Hour = "0" + Hour;
		}
		if(Minute<10){
			Minute = "0" + Minute;
		}
		if(Seconds<10){
			Seconds = "0" + Seconds;
		}
        return this.getFullYear() + "/" + Month + "/" + Date + "  " + Hour + ":" + Minute + ":" + Seconds;
  };
  
  //验证账号------------------------------------------------------------
  
  var objParameter = new Object();
  function validate(val){
	  if(!val){
		  clearTip();
		  return false;
	  }else if(val==oldAccount){
		  clearTip();
		  return false;
	  }else{
		  
		  url_ = 'user/validate';
		  objParameter.validateValue = val.trim();
		  
		  $.ajax({
				 url:url_,
				 type:'POST',
				 dataType:'json',
				 cache:false,
				 data:objParameter,
				 success:function(data){
					 if(data.message=='可用'){
						  $('#tip').html("账号可用！");
						  $('#tip').css('color','green');
					  }else{
						  $('#tip').html("账号不可用！");
						  $('#tip').css('color','red');
						  setTimeout(function(){
							  clearTip();
							  $('#userAccount').val("");
						  },3000);
					  }
				 },
				 error:function(){
					 swal("抱歉出了点故障", "请稍后再试", "error");
				 }
			  });
		  
		  
		  
	  }
  }
  
  function add(){
	  var userAccount = $('#userAccount').val().trim();
	  var password = $('#password').val().trim();
	  if(!userAccount){
		  $('#tip').html("请填写账号!");
		  $('#tip').css("color",'red');
		  return false
	  }
	  if(!password){
		  $('#tip').html("密码不能为空!");
		  $('#tip').css("color",'red');
		  return false
	  }
	  else{
		  
		  url_ = 'user/addUser';
		  
		  $.ajax({
				 url:url_,
				 type:'POST',
				 dataType:'json',
				 cache:false,
				 data:$('#addForm').serialize(),
				 success:function(data){
					 if(data.code==1){
						$('#myModal').modal('hide');
						swal("新增用户", "操作成功", "success");
						$('#dataTable').DataTable().order( [[ 1, 'asc' ]] ).draw( false );
						$('#addForm')[0].reset();
					  }else{
						  swal("新增用户", "操作失败,请稍后再试!", "error");
					  }
				 },
				 error:function(){
					 swal("新增用户", "操作失败,请稍后再试!", "error");
				 }
			  });
	  }
  }
  
  function update(){
	  var userAccount = $('#userAccount').val().trim();
	  var password = $('#password').val().trim();
	  if(!userAccount){
		  $('#tip').html("请填写账号!");
		  $('#tip').css("color",'red');
		  return false
	  }
	  if(!password){
		  $('#tip').html("密码不能为空!");
		  $('#tip').css("color",'red');
		  return false
	  }
	  else{
		  
		  url_ = 'user/updateUser';
		  
		  $.ajax({
				 url:url_,
				 type:'POST',
				 dataType:'json',
				 cache:false,
				 data:$('#addForm').serialize(),
				 success:function(data){
					 if(data.code==1){
						$('#myModal').modal('hide');
						swal("更新账号", "操作成功", "success");
						$('#dataTable').DataTable().order( [[ 1, 'asc' ]] ).draw( false );
						$('#addForm')[0].reset();
					  }else{
						  swal("更新账号", "操作失败,请稍后再试!", "error");
					  }
				 },
				 error:function(){
					 swal("更新账号", "操作失败,请稍后再试!", "error");
				 }
			  });
	  }
  }
  
  function del(){
	  
	  var id = $('#id').val();
	  url_ = 'user/deleteUser';
	  
	  swal({
          title: "是否确定删除该用户?", 
          text: "删除的数据将不能恢复", 
          type: "warning", 
          showCancelButton: true, 
          cancelButtonText: "否",
          confirmButtonColor: "#DD6B55", 
          confirmButtonText: "是", 
          closeOnConfirm: false 
        },
        function(){
        	 $.ajax({
				 url:url_,
				 type:'POST',
				 dataType:'json',
				 cache:false,
				 data:{
					 'ids': id+','
				 },
				 success:function(data){
					 if(data.code==1){
						$('#myModal').modal('hide');
						swal("删除账号", "操作成功", "success");
						$('#dataTable').DataTable().order( [[ 1, 'asc' ]] ).draw( false );
						$('#addForm')[0].reset();
					  }else{
						  swal("删除账号", "操作失败,请稍后再试!", "error");
					  }
				 },
				 error:function(){
					 swal("删除账号", "操作失败,请稍后再试!", "error");
				 }
			  });
        });
	  
	  }
  
  function clearTip(){
	  $('#tip').html("提示信息");
	  $('#tip').css('color','#58666e');
  }
  
  
	
</script>

<!-- ================================================
Sweet Alert
================================================ -->
<script src="js/sweet-alert/sweet-alert.min.js"></script>

<br><br><br><br><br><br><br>

</body>
</html>