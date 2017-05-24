<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
  <head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>bucketOperate</title>

  <!-- ========== Css Files ========== -->
  <link href="css/root.css" rel="stylesheet">
  
  <style>

  	}
  </style>

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
      <h4>餐厨桶信息管理</h4>
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
                        <th style="text-align:center;">桶编号</th>
                        <th style="text-align:center;">关联RFID卡号</th>
                        <th style="text-align:center;">型号</th>
                        <th style="text-align:center;">容积(L)</th>
                        <th style="text-align:center;">是否绑定商家</th>
                        <th style="text-align:center;">创建时间</th>
                        <th style="text-align:center;">最近修改时间</th>
                        <!-- <th style="text-align:center;">备注</th> -->
                    </tr>
                </thead>
                
               
             
                <!-- <tfoot>
                    <tr>

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
		                    <h4 class="modal-title"><span id="head">新增餐厨桶</span></h4>
		                </div>
	                  	<div class="modal-body">
	                    	<div class="panel-body">
				              <form id="addForm" class="form-horizontal">
				
				                <div class="form-group">
				                  <label for="bucketCode" class="col-sm-2 control-label form-label">桶编号</label>
				                  <div class="col-sm-10">
				                  	<input type="hidden" name="id" id="id">
				                    <input readonly class="form-control" name="bucket_code" id="bucketCode">
				                    <span id="helpBlock" class="help-block"><a onclick="setBucketCode(16,16)" href="javascript:void(0)" class="btn btn-info btn-xs">生成餐厨桶编号</a> <span id="tip"></span></span>
				                  </div>
				                </div>
				
				                <div class="form-group">
				                	<label for="rfid" class="col-sm-2 control-label form-label">RFID卡号</label>
					                <div  class="col-sm-10">
					                    <select name="rfid" id="rfid" style="width:250px;">
					                    	<option id="rfidOption" value="暂未关联">下拉选择RFID卡号</option>
					                    </select>
					                    <span class="help-block"><!-- <i class="fa fa-exclamation-circle"></i> --></span>
					                </div>
				                </div>	
				                
				                <div class="form-group ">
				                  <label class="col-sm-2 control-label form-label">型号</label>
				                  <div class="col-sm-10">
				                      	<input type="text" class="form-control" value="" name="bucket_mode"  id="bucket_mode">
				                  </div>
				                </div>
				                
				                <div class="form-group ">
				                  <label class="col-sm-2 control-label form-label">容积(L)</label>
				                  <div class="col-sm-10">
				                      	<input type="number" class="form-control" name="volume" value=""  id="volume">
				                  </div>
				                </div>			
				                
				                <!-- <div class="form-group ">
				                  <div class="col-sm-12">
				                  <h5 style="margin-top:0px;margin-bottom:-15px;">关联信息</h5>
				                  <hr>
				                  </div>
				                </div>
				                
				                <div class="form-group ">
				                  <label class="col-sm-2 control-label form-label">商家</label>
				                  <div class="col-sm-10">
				                      	<input readonly class="form-control" value=""  id="restaurantName">
				                  </div>
				                </div>
				                
				                <div class="form-group ">
				                  <label class="col-sm-2 control-label form-label">地址</label>
				                  <div class="col-sm-10">
				                      	<input readonly class="form-control" value=""  id="restaurantAddress">
				                  </div>
				                </div> -->
								
				              </form> 
				
				            </div>
	                  	</div>
		                <div class="modal-footer">
		                   <button id="bClose" type="button" class="btn btn-white" data-dismiss="modal">关闭窗口</button>
		                   <button id="bAdd" onclick="add()" type="button" class="btn btn-default">保存餐厨桶</button>
		                   <button id="bDelete" onclick="del()" type="button" class="btn btn-danger">删除餐厨桶</button>
		                   <button id="bUpdate" onclick="update()" type="button" class="btn btn-success">更新餐厨桶</button>
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
var RFID_obj = '';
window.onload=function(){ 
	
}

$(document).ready(function() {
	
    var t = $('#dataTable').DataTable({
    	scrollY:        '50vh',
        scrollCollapse: true,
    	"processing": true,
        "serverSide": true,
        "ajax":"bucket/listAllBucket",
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
    	                    { "data": "bucket_code" },
    	                    { "data": "rfid" }, 
    	                    { "data": "bucket_mode"},
    	                    { "data": "volume" },
    	                    { "data": "is_binding" },
    	                    { "data": "create_time" },
    	                    { "data": "update_time" }
    	                ],
    	"paging":   true,		//分页
    	"bFilter" : true,		// 搜索栏
    	"pagingType": "full_numbers",
        "ordering": true,		//排序
        "order": [[ 7, "desc" ]],
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
            "processing":     "数据加载中...",
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
        	  
			        	  if(!data.rfid){
				  				$('td', row).eq(2).html("暂未关联RFID");
				  			  }			  
        	  
        	  			  if(data.is_binding ==1){
        	  				$('td', row).eq(5).html("已绑定");
        	  			  }else{
        	  				$('td', row).eq(5).html("未绑定");
        	  				$('td', row).eq(5).css('color','#0fde0f');
        	  			  }
        	  			  
	                      
	                      if (data.create_time) {
	                    	  var unixTimestamp = new Date( data.create_time ) ;
	                    	  commonTime = unixTimestamp.toLocaleString();
	                          $('td', row).eq(6).html(commonTime);
	                      }
	                      
	                      if (data.update_time) {
	                    	  var unixTimestamp = new Date( data.update_time) ;
	                    	  commonTime = unixTimestamp.toLocaleString();
	                          $('td', row).eq(7).html(commonTime);
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
    
    //添加工具条
    $("#dataTable_length").prepend('<div class="btn-group" role="group" aria-label="..."><button onclick="openModal()"  id="add" type="button" class="btn btn-light"><i class="fa  fa-plus"></i>新增餐厨桶</button><button id="refresh" type="button" class="btn btn-light"><i class="fa fa-refresh"></i>刷新数据</button><button type="button" class="btn btn-light"><i class="fa fa-cog"></i>餐厨桶设置</button></div> <br><br>');
    
    //tr绑定点击事件
    var table = $('#dataTable').DataTable();

    
    
    //单选tr
    $('#dataTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
        	
        	$('#myModal').modal();
        	$('#bClose').hide();
        	$('#bAdd').hide();
        	$('#bDelete').show();
        	$('#bUpdate').show();
        	$('#head').html("更新餐厨桶");
        	$('#tip').html('');
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
            var data = table.row( this ).data();
            console.log(data);
    		
            $("#id").val(data.id);
        	$('#bucketCode').val(data.bucket_code);
        	$("#rfidOption").html(data.rfid);
        	$("#rfidOption").val(data.rfid);
			$('#bucket_mode').val(data.bucket_mode);
			$('#volume').val(data.volume);
        	
        	}
         } );
    
 
    $('#refresh').click( function () {
        //table.row('.selected').remove().draw( false );
    	table.order( [[ 7, 'desc' ]] ).draw( false );
    } );
    
    
    
    
    //Modal 设置-------------------------
    $('#myModal').on('hidden.bs.modal', function () {
    	  // 执行一些动作...
    	  //$('.modal-body').append('关闭modal后添加');
    	  $('#addForm')[0].reset();
    	  table.$('tr.selected').removeClass('selected');
    	  getRFID();
    	});
    
    $('#identifier').on('show.bs.modal', function () {
    	  getRFID();
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
  
  
  var objParameter = new Object();
  
  
  function openModal(){
  	$('#myModal').modal();
  	$('#bDelete').hide();
  	$('#bUpdate').hide();
  	$('#bClose').show();
  	$('#bAdd').show();
  	$('#head').html("新增餐厨桶");
  	$('#tip').html("");
  	getRFID();
  }
  
  
  function add(){
	  
	  var bucketCode = $('#bucketCode').val().trim();
	  if(!bucketCode){
		  $('#tip').html("请先生成餐厨桶编号!");
		  $('#tip').css("color",'red');
		  return false
	  }
	  else{
		  url_ = 'bucket/addBucket';
		  $.ajax({
				 url:url_,
				 type:'POST',
				 dataType:'json',
				 cache:false,
				 data:$('#addForm').serialize(),
				 success:function(data){
					 if(data.code==1){
						$('#myModal').modal('hide');
						swal("新增餐厨桶", "操作成功", "success");
						$('#dataTable').DataTable().order( [[ 7, 'desc' ]] ).draw( false );
						$('#addForm')[0].reset();
						//getRFID();
						console.log('添加成功,重新获取RFID...');
					  }else{
						  swal("新增餐厨桶", "操作失败,请稍后再试!", "error");
					  }
				 },
				 error:function(){
					 swal("新增餐厨桶", "操作失败,请稍后再试!", "error");
				 }
			  });
	  }
  }
  
  function update(){
	   
		  url_ = 'bucket/updateBucket';
		  
		  $.ajax({
				 url:url_,
				 type:'POST',
				 dataType:'json',
				 cache:false,
				 data:$('#addForm').serialize(),
				 success:function(data){
					 if(data.code==1){
						$('#myModal').modal('hide');
						swal("更新餐厨桶", "操作成功", "success");
						$('#dataTable').DataTable().order( [[ 8, 'desc' ]] ).draw( false );
						$('#addForm')[0].reset();
						//getRFID();
						console.log('更新成功,重新获取RFID...');
					  }else{
						  swal("更新餐厨桶", "操作失败,请稍后再试!", "error");
					  }
				 },
				 error:function(){
					 swal("更新餐厨桶", "操作失败,请稍后再试!", "error");
				 }
			  });
	  
  }
  
  function del(){
	  
	  var id = $('#id').val();
	  url_ = 'bucket/deleteBucket';
	  
	  swal({
          title: "是否确定删除该餐厨桶?", 
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
						swal("删除餐厨桶", "操作成功", "success");
						$('#dataTable').DataTable().order( [[ 8, 'desc' ]] ).draw( false );
						$('#addForm')[0].reset();
						//getRFID();
						console.log('删除成功,重新获取RFID...');
					  }else{
						  swal("删除餐厨桶", "操作失败,请稍后再试!", "error");
					  }
				 },
				 error:function(){
					 swal("删除餐厨桶", "操作失败,请稍后再试!", "error");
				 }
			  });
        });
	  
	  }
  
  function clearTip(){
	  $('#tip').html("提示信息");
	  $('#tip').css('color','#58666e');
  }
  
  function setBucketCode(len, radix){
	  $('#tip').html("");
	  var uid = 'B'+uuid(len, radix);
	  $('#bucketCode').val(uid);
	  return false;
	  $.ajax({
			 url:'bucket/validate',
			 type:'POST',
			 dataType:'json',
			 cache:false,
			 data:{
				 'validateValue':uid
			 },
			 success:function(data){
				 if(data.message=='可用'){
					 $('#bucketCode').val(uid);
				  }else{
					  $('#tip').html("卡号不可用,请重新生成！");
					  $('#tip').css('color','red');
					  $('#bucketCode').val('');
				  }
			 },
			 error:function(){
				 swal("抱歉出了点故障", "请稍后再试", "error");
			 }
		  });
	  
  }
  
  function uuid(len, radix) {
	    var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
	    var uuid = [], i;
	    radix = radix || chars.length;

	    if (len) {
	      // Compact form
	      for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random()*radix];
	    } else {
	      // rfc4122, version 4 form
	      var r;

	      // rfc4122 requires these characters
	      uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
	      uuid[14] = '4';

	      // Fill in random data.  At i==19 set the high bits of clock sequence as
	      // per rfc4122, sec. 4.1.5
	      for (i = 0; i < 36; i++) {
	        if (!uuid[i]) {
	          r = 0 | Math.random()*16;
	          uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
	        }
	      }
	    }

	    return uuid.join('');
	}
  
  function getRestaurant(id){

		  url_ = 'restInfo/selectById';
		  
		  $.ajax({
				 url:url_,
				 type:'POST',
				 dataType:'json',
				 cache:false,
				 data:{
					 'id':id
				 },
				 success:function(data){
					 if(data.code==1){
						console.log(data.rows);
						var name = data.rows[0].name;
						var address = data.rows[0].address;
						if(!name){
							name = '暂未填写';
						}
						if(!address){
							address = '暂未填写';
						}
						$('#restaurantName').val(name);
						$('#restaurantAddress').val(address);
					  }
				 },
				 error:function(){
					 //swal("e", "操作失败,请稍后再试!", "error");
				 }
			  });
  }
  
  function getRFID(){
	  url_ = 'rfid/listUnUseRfid';
	  $.ajax({
			 url:url_,
			 type:'POST',
			 dataType:'json',
			 cache:false,
			 data:{
				 
			 },
			 success:function(data){
				 console.log(data);
				 if(data.length>0){
					 $('#rfid').html('');
				      $('#rfid').append('<option value="暂未关联" id="rfidOption">下拉选择RFID卡号</option>');
					  for(var i=0;i<data.length;i++){
							 $('#rfid').append('<option value='+data[i].rfidcode+'>'+data[i].rfidcode+'</option>');
						 }
				  }else{
					  /* swal("暂无可关联RFID", "请先前往RFID信息管理页面添加！", "warning");
					  $('#myModal').hide(); */
				  }
			 },
			 error:function(){
				 swal("获取RFID", "操作失败,请稍后再试!", "error");
			 }
		  });
}
  

	
</script>

<!-- ================================================
Sweet Alert
================================================ -->
<script src="js/sweet-alert/sweet-alert.min.js"></script>

<script type="text/javascript" src="http://www.w3cschool.cc/try/jeasyui/jquery.easyui.min.js"></script>

<br><br><br><br><br><br><br>

</body>
</html>