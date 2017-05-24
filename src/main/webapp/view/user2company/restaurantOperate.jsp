<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
  <head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>restOperate</title>

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
      <h4>企业信息管理</h4>
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
                    	<th style="text-align:center;">企业名称</th>
                    	<th style="text-align:center;">店面地址</th>
                    	<th style="text-align:center;">联系人</th>
                    	<th style="text-align:center;">联系人电话</th>
                    	<th style="text-align:center;">创建时间</th>
                        <th style="text-align:center;">最近修改时间</th>
                    	<th style="text-align:center;">最近收运时间</th>
                    	
                        <th style="text-align:center;">code</th>
                        <th style="text-align:center;">商业区域</th>
                        <th style="text-align:center;">地址</th>
                        <th style="text-align:center;">停业日期</th>
                        <th style="text-align:center;">收集频率/天</th>
                        <th style="text-align:center;">投诉电话</th>
                        <th style="text-align:center;">联系人电话</th>
                        
                        <th style="text-align:center;">合同年限</th>
                        <th style="text-align:center;">合同编号</th>
                        <th style="text-align:center;">日均餐厨产生量(kg)</th>
                        <th style="text-align:center;">日均废弃油脂产生量（kg）</th>
                        <th style="text-align:center;">证件编号</th>
                        <th style="text-align:center;">约定上门收集结束时间（时分秒）</th>
                        <th style="text-align:center;">卫生许可证发放时间</th>
                        <th style="text-align:center;">是否收集地沟油</th>
                        <th style="text-align:center;">纬度</th>
                        <th style="text-align:center;">latitudeDone</th>
                        <th style="text-align:center;">法人代表</th>
                        <th style="text-align:center;">longitude</th>
                        <th style="text-align:center;">longitudeDone</th>
                        <th style="text-align:center;">供餐规模</th>
                        
                        
                        <th style="text-align:center;">openDate</th>
                        <th style="text-align:center;">orderIndex</th>
                        <th style="text-align:center;">餐饮服务许可证</th>
                        <th style="text-align:center;">许可证编号</th>
                        <th style="text-align:center;">phoneNumber</th>
                        <th style="text-align:center;">photoFile</th>
                        <th style="text-align:center;">photoIds</th>
                        <th style="text-align:center;">remain厨余</th>
                        <th style="text-align:center;">remarks</th>
                        <th style="text-align:center;">企业规模scale</th>
                        <th style="text-align:center;">signingDate</th>
                        <th style="text-align:center;">starLevel</th>
                        <th style="text-align:center;">startCollectTime</th>
                        
                        
                        <th style="text-align:center;">收运公司idsyCompanyid</th>
                        <th style="text-align:center;">收运合同附件 (证件图片)syCompanyFile</th>
                        <th style="text-align:center;">垃圾桶个数trashBinNum</th>
                        <th style="text-align:center;">企业规模 ID（大 中 小型）type</th>
                        <th style="text-align:center;">废弃油脂wasteOil</th>
                        <th style="text-align:center;">企业类型Id(参数表的id）classesId</th>
                        <th style="text-align:center;">证件类型Id(参数表的id）documentTypeId</th>
                        <th style="text-align:center;">streetId</th>
                        <th style="text-align:center;">来源时间sourceTime</th>
                        <th style="text-align:center;">来源类型 0.新增 1.申报sourceType</th>
                        <th style="text-align:center;">联络人联系电话contactTel</th>
                        <th style="text-align:center;">法人代表身份证复印件legalManFileIds</th>
                        <th style="text-align:center;">法人代表手机legalManPhone</th>
                        <th style="text-align:center;">legalManTel法人代表联系电话</th>
                        <th style="text-align:center;">来源人sourceManId</th>
                        <th style="text-align:center;">约定上门收集结束时间（时分秒）endCollectTime2</th>
                        <th style="text-align:center;">files</th>
                        <th style="text-align:center;">供餐时间mealTime</th>
                        
                        <th style="text-align:center;">约定上门收集开始时间2（时分秒）startCollectTime2</th>
                        <th style="text-align:center;">单位地址unitAddress</th>
                        <th style="text-align:center;">单位名称（全称）unitName</th>
                        <th style="text-align:center;">最后收集车辆lastCollectCarCode</th>
                        <th style="text-align:center;">最后收集车辆IDlastCollectCarId</th>
                        <th style="text-align:center;">供餐规模显示值mealRangeDisplayValue</th>
                        <th style="text-align:center;">供餐规模id(参数表的id）mealRangeId</th>
                        <th style="text-align:center;">名称的拼音pinyin</th>
                        
                        <th style="text-align:center;">签约状态 1:确认； 0：注销；2：初始signedStatus</th>
                        <th style="text-align:center;">elevator</th>
                        <th style="text-align:center;">签约结束时间signingEndDate</th>
                        <th style="text-align:center;">楼梯, 1有，0没有stair</th>
                        <th style="text-align:center;">收运结束时间syEndDate</th>
                        <th style="text-align:center;">收运开始时间syStartDate</th>
                        <th style="text-align:center;">楼层floorNum</th>
                        <th style="text-align:center;">签约收运企业名称syCompanyName</th>
                        <th style="text-align:center;">申报垃圾桶数applyTrashBinNum</th>
                        <th style="text-align:center;">数据来源dataSource</th>
                        <th style="text-align:center;">营业执照或机构代码证复印件ID（附件表id）paperFileIds</th>
                        <th style="text-align:center;">营业执照或机构代码证复印件paperFileNames</th>
                        <th style="text-align:center;">餐企信誉评估分数creditAssessRecord</th>
                        
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
		                    <h4 class="modal-title"><span id="head">新增车辆</span></h4>
		                </div>
	                  	<div class="modal-body">
	                    	<div class="panel-body">
				              <form id="addForm" class="form-horizontal">
				
				                <div class="form-group">
				                  <label for="account" class="col-sm-2 control-label form-label">车牌号码</label>
				                  <div class="col-sm-10">
				                  	<input type="hidden" name="id" id="id">
				                    <input class="form-control" name="carcode" id="carCode">
				                    <span id="helpBlock" class="help-block"><!-- <a onclick="set车辆(26,16)" href="javascript:void(0)" class="btn btn-info btn-xs">生成车辆卡号</a> --> <span id="tip"></span></span>
				                  </div>
				                </div>
				
				                <div class="form-group">
				                	<label for="enabled" class="col-sm-2 control-label form-label">车载重量</label>
					                <div class="col-sm-10">
					                    <input class="form-control" name="carload" id="carLoad">
					                </div>
				                </div>
				                
				                <div class="form-group">
				                	<label for="enabled" class="col-sm-2 control-label form-label">司机姓名</label>
					                <div class="col-sm-10">
					                    <input class="form-control" name="driver" id="driver">
					                </div>
				                </div>
				                
				                <div class="form-group">
				                	<label for="enabled" class="col-sm-2 control-label form-label">手机号码</label>
					                <div class="col-sm-10">
					                    <input maxlength="11" class="form-control" name="driverphone" id="driverPhone">
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
				                </div> -->
				                
				              </form> 
				
				            </div>
	                  	</div>
		                <div class="modal-footer">
		                   <button id="bClose" type="button" class="btn btn-white" data-dismiss="modal">关闭窗口</button>
		                   <button id="bAdd" onclick="add()" type="button" class="btn btn-default">保存车辆</button>
		                   <button id="bDelete" onclick="del()" type="button" class="btn btn-danger">删除车辆</button>
		                   <button id="bUpdate" onclick="update()" type="button" class="btn btn-success">更新车辆</button>
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
        "ajax":{
        	url:"restInfo/listAll",
            type:"POST"
        },
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
    	                    { "data": "name" },
    	                    { "data": "restaurantAddress" },
    	                    { "data": "contactPerson" },
    	                    { "data": "contactPhone" },
    	                    { "data": "createTime" ,"defaultContent": "<i>--</i>"},
    	                    { "data": "lastChangeTime" ,"defaultContent": "<i>--</i>"},
    	                    { "data": "lastCollectDateTime" ,"defaultContent": "<i>--</i>"},
    	                    
    	                    
    	                    { "data": "code","visible": false },
    	                    { "data": "businessArea","visible": false },
    	                    { "data": "address","visible": false },
    	                    { "data": "closeDate","visible": false ,"defaultContent": "<i>--</i>"},
    	                    { "data": "collectFrequency","visible": false },
    	                    { "data": "complaintsHotline","visible": false },
    	                    { "data": "contactMobile","visible": false },
    	                    { "data": "contractLength","visible": false },
    	                    { "data": "contractNo","visible": false },
    	                    { "data": "dailyOutput","visible": false },
    	                    { "data": "dailyOutPutWasteOil","visible": false },
    	                    { "data": "documentNo","visible": false },
    	                    { "data": "endCollectTime","visible": false ,"defaultContent": "<i>--</i>"},
    	                    { "data": "hygienicLicenseDate","visible": false ,"defaultContent": "<i>--</i>"},
    	                    { "data": "isCollectScdOil","visible": false },
    	                    
    	                    
    	                    { "data": "latitude","visible": false },
    	                    { "data": "latitudeDone","visible": false },
    	                    { "data": "legalRepresentative","visible": false },
    	                    { "data": "longitude","visible": false },
    	                    { "data": "longitudeDone","visible": false },
    	                    { "data": "mealRange","visible": false },
    	                    
    	                    
    	                    { "data": "openDate","visible": false ,"defaultContent": "<i>--</i>"},
    	                    { "data": "orderIndex","visible": false },
    	                    { "data": "permit","visible": false },
    	                    { "data": "permitNo","visible": false },
    	                    { "data": "phoneNumber","visible": false },
    	                    { "data": "photoFile","visible": false },
    	                    { "data": "photoIds","visible": false },
    	                    { "data": "remain","visible": false },
    	                    { "data": "remarks","visible": false },
    	                    { "data": "scale","visible": false },
    	                    { "data": "signingDate","visible": false ,"defaultContent": "<i>--</i>"},
    	                    { "data": "starLevel","visible": false },
    	                    { "data": "startCollectTime","visible": false ,"defaultContent": "<i>--</i>"},
    	                    { "data": "syCompanyid","visible": false },
    	                    { "data": "syCompanyFile","visible": false,"defaultContent": "<i>--</i>" },
    	                    { "data": "trashBinNum","visible": false ,"defaultContent": "<i>--</i>"},
    	                    { "data": "type","visible": false },
    	                    { "data": "wasteOil","visible": false },
    	                    { "data": "classesId","visible": false },
    	                    { "data": "documentTypeId","visible": false },
    	                    { "data": "streetId","visible": false },
    	                    { "data": "sourceTime","visible": false ,"defaultContent": "<i>--</i>"},
    	                    { "data": "sourceType","visible": false },
    	                    { "data": "contactTel","visible": false },
    	                    { "data": "legalManFileIds","visible": false },
    	                    { "data": "legalManPhone","visible": false },
    	                    { "data": "legalManTel","visible": false },
    	                    { "data": "sourceManId","visible": false },
    	                    { "data": "endCollectTime2","visible": false ,"defaultContent": "<i>--</i>"},
    	                    { "data": "files","visible": false },
    	                    { "data": "mealTime","visible": false ,"defaultContent": "<i>--</i>"},
    	                    { "data": "startCollectTime2","visible": false ,"defaultContent": "<i>--</i>"},
    	                    { "data": "unitAddress","visible": false ,"defaultContent": "<i>--</i>"},
    	                    { "data": "unitName","visible": false },
    	                    { "data": "lastCollectCarCode","visible": false },
    	                    { "data": "lastCollectCarId","visible": false },
    	                    { "data": "mealRangeDisplayValue","visible": false },
    	                    { "data": "mealRangeId","visible": false },
    	                    { "data": "pinyin","visible": false },
    	                    { "data": "contactMobile","visible": false },
    	                    { "data": "signedStatus","visible": false },
    	                    { "data": "elevator","visible": false },
    	                    { "data": "signingEndDate","visible": false ,"defaultContent": "<i>--</i>"},
    	                    { "data": "stair","visible": false },
    	                    { "data": "syEndDate","visible": false ,"defaultContent": "<i>--</i>"},
    	                    { "data": "syStartDate","visible": false ,"defaultContent": "<i>--</i>"},
    	                    { "data": "floorNum","visible": false },
    	                    { "data": "syCompanyName","visible": false },
    	                    { "data": "applyTrashBinNum","visible": false },
    	                    { "data": "dataSource","visible": false },
    	                    { "data": "paperFileIds","visible": false },
    	                    { "data": "paperFileNames","visible": false },
    	                    { "data": "creditAssessRecord","visible": false }
    	                    
    	                ],
    	"paging":   true,		//分页
    	"bFilter" : true,		// 搜索栏
    	"pagingType": "full_numbers",
        "ordering": true,		//排序
        "order": [[ 6, "desc" ]],
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
        	  
			        	  if(!data.name){
				  				$('td', row).eq(1).html("——");
				  			  }			  
        	  
        	  			  
	                      if (!data.restaurantAddress) {
	                          $('td', row).eq(2).html("--");
	                      }
	                      
	                      if (!data.contactPerson) {
	                          $('td', row).eq(3).html("--");
	                      }
	                      if (!data.contactPhone) {
	                          $('td', row).eq(4).html("--");
	                      }
	                      if (data.createTime) {
	                    	  var unixTimestamp = new Date( data.createTime ) ;
	                    	  commonTime = unixTimestamp.toLocaleString();
	                          $('td', row).eq(5).html(commonTime);
	                      }
	                      
	                      if (data.lastChangeTime) {
	                    	  var unixTimestamp = new Date( data.lastChangeTime ) ;
	                    	  commonTime = unixTimestamp.toLocaleString();
	                          $('td', row).eq(6).html(commonTime);
	                      }
	                      
	                      if (data.lastCollectDateTime!=0 &&data.lastCollectDateTime!=null) {
	                    	  var unixTimestamp = new Date( data.lastCollectDateTime ) ;
	                    	  commonTime = unixTimestamp.toLocaleString();
	                          $('td', row).eq(7).html(commonTime);
	                      }else{
	                    	  $('td', row).eq(7).html('--');
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
    $("#dataTable_length").prepend('<div class="btn-group" role="group" aria-label="..."><button  id="add" type="button" class="btn btn-light"><i class="fa  fa-plus"></i>新增企业</button><button id="refresh" type="button" class="btn btn-light"><i class="fa fa-refresh"></i>刷新数据</button><button type="button" class="btn btn-light"><i class="fa fa-cog"></i>企业设置</button></div> <br><br>');
    
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
            $("#id").val(data.id);
        	$('#carCode').val(data.carCode);
			$('#carLoad').val(data.carLoad);
			$('#driver').val(data.driver);
			$('#driverPhone').val(data.driverPhone);
        	
            $('#myModal').modal();
        	$('#bClose').hide();
        	$('#bAdd').hide();
        	$('#bDelete').show();
        	$('#bUpdate').show();
        	$('#head').html("更新车辆");
        	$('#tip').html('');
        	
        	}
         } );
    
 
    $('#refresh').click( function () {
        //table.row('.selected').remove().draw( false );
    	table.order( [[ 6, 'desc' ]] ).draw( false );
    } );
    
    $('#add').click(function(){
    	
    	$('#myModal').modal();
    	$('#bDelete').hide();
    	$('#bUpdate').hide();
    	$('#bClose').show();
    	$('#bAdd').show();
    	$('#head').html("新增车辆");
    	$('#tip').html("");
    });
    
    
    //Modal 设置-------------------------
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
  
  function add(){
	  var rfidCode = $('#carCode').val().trim();
	  if(!rfidCode){
		  $('#tip').html("您未填写车牌号码！");
		  $('#tip').css("color",'red');
		  return false
	  }
	  else{
		  
		  url_ = 'carInfo/addCar';
		  
		  $.ajax({
				 url:url_,
				 type:'POST',
				 dataType:'json',
				 cache:false,
				 data:$('#addForm').serialize(),
				 success:function(data){
					 if(data.code==1){
						$('#myModal').modal('hide');
						swal("新增车辆", "操作成功", "success");
						$('#dataTable').DataTable().order( [[ 6, 'desc' ]] ).draw( false );
						$('#addForm')[0].reset();
					  }else{
						  swal("新增车辆", "操作失败,请稍后再试!", "error");
					  }
				 },
				 error:function(){
					 swal("新增车辆", "操作失败,请稍后再试!", "error");
				 }
			  });
	  }
  }
  
  function update(){
	   
		  url_ = 'carInfo/updateCar';
		  
		  $.ajax({
				 url:url_,
				 type:'POST',
				 dataType:'json',
				 cache:false,
				 data:$('#addForm').serialize(),
				 success:function(data){
					 if(data.code==1){
						$('#myModal').modal('hide');
						swal("更新车辆", "操作成功", "success");
						$('#dataTable').DataTable().order( [[ 7, 'desc' ]] ).draw( false );
						$('#addForm')[0].reset();
					  }else{
						  swal("更新车辆", "操作失败,请稍后再试!", "error");
					  }
				 },
				 error:function(){
					 swal("更新车辆", "操作失败,请稍后再试!", "error");
				 }
			  });
	  
  }
  
  function del(){
	  
	  var id = $('#id').val();
	  url_ = 'carInfo/deleteCar';
	  
	  swal({
          title: "是否确定删除该车辆信息?", 
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
					 'id': id
				 },
				 success:function(data){
					 if(data.code==1){
						$('#myModal').modal('hide');
						swal("删除车辆", "操作成功", "success");
						$('#dataTable').DataTable().order( [[ 6, 'desc' ]] ).draw( false );
						$('#addForm')[0].reset();
					  }else{
						  swal("删除车辆", "操作失败,请稍后再试!", "error");
					  }
				 },
				 error:function(){
					 swal("删除车辆", "操作失败,请稍后再试!", "error");
				 }
			  });
        });
	  
	  }
  
  function clearTip(){
	  $('#tip').html("提示信息");
	  $('#tip').css('color','#58666e');
  }
  
  function set车辆(len, radix){
	  $('#tip').html("");
	  var uid = 'E'+uuid(len, radix);
	  $('#rfidCode').val(uid);
	  return false;
	  $.ajax({
			 url:'rfid/validate',
			 type:'POST',
			 dataType:'json',
			 cache:false,
			 data:{
				 'validateValue':uid
			 },
			 success:function(data){
				 if(data.message=='可用'){
					 $('#rfidCode').val(uid);
				  }else{
					  $('#tip').html("卡号不可用,请重新生成！");
					  $('#tip').css('color','red');
					  $('#rfidCode').val('');
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
  
	
</script>

<!-- ================================================
Sweet Alert
================================================ -->
<script src="js/sweet-alert/sweet-alert.min.js"></script>

<br><br><br><br><br><br><br>

</body>
</html>