<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
<%
	String path = request.getContextPath();/*获得当前项目的根路径 */
	String data= request.getParameter("data");
%>
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
 <head>
  <link rel="stylesheet" href="<%=path%>/stylesheets/weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/jquery-weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/projectcss.css"/>
  <title>发起住宿费用报销</title>
 </head>
 <body >
  <form id="form" action="toExpense_hotel_save.do" method="post" enctype="multipart/form-data" onsubmit="return check();">
  	<!-- <div class="weui_cells" style="border:none;"> -->
  		<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>住宿原因</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="请输入住宿原因(必填)"  name="reason">
   		 </div>
     	</div>
     		
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>旅馆名称</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="请输入旅馆名称(必填)"  name="hotelName" >
   		 </div>
   		 
     	</div>		
  		 <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>住宿日期</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		   <input class="weui_input" type="text" placeholder="请输入住宿日期(必填)"  name="startTime" onfocus="(this.type='date')">
   		    </div>
  		 </div>
  		
  	    <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>离店日期</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		   <input class="weui_input" type="text" placeholder="请输入离店日期(必填)"  name="endTime" onfocus="(this.type='date')">
   		    </div>
  		 </div>
     	
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>天&nbsp;数</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="请输入住宿天数(必填)"  name="daysCost" value="" onchange="checkFormat(this);">
   		 </div>
   		 
     	</div>
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>金&nbsp;额</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="请输入金额(必填)"  name="moneyCost" value="" onchange="checkFormat2(this);">
   		 </div>
   		 
     	</div>
     		
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>说&nbsp;明</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="请输入说明(可选)"  name="detailExplain" value="" >
   		 </div>
   		 
     	</div>
     	
  	     <hr/>
  	     <div class="weui-row">
  	     <div class="weui_uploader_input_wrp">
            <input class="weui_uploader_input" type="file" id='image' accept="image/jpg,image/jpeg,image/png,image/gif" multiple="" name="image"  onchange="showInfo('image','picInfo');">
            <img src="" height="80" width="80" id="picInfo"/>
  	     </div>
  	     </div>
        <div class="weui-row">
			<div class="weui-col-10"></div>
			<div class="weui-col-40"><input type="submit" class="weui_btn  weui_btn_primary"  value="提交"></div>
			<div class="weui-col-40"><a href="javascript:history.go(-1);" class="weui_btn  weui_btn_default">返回</a></div>
			<div class="weui-col-10"></div>
		</div>	
		<br/>
		<div class="weui-row">
		<div class="weui-col-10"></div>
		<div class="weui-col-80"><a href="<%=path%>/toExpense_history_hotel.do" class="weui_btn  weui_btn_warn">历史报销信息查看</a></div>
		<div class="weui-col-10"></div>
		</div>	
  	 <!-- </div> -->
  	</form>	
  	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
    <script>
    function check(){
    	if($("input[name='reason']").val()==null || $("input[name='reason']").val()==""){
    		$.alert("请输入住宿原因");
    		return false;
    	}
    	if($("input[name='hotelName']").val()==null || $("input[name='hotelName']").val()==""){
    		$.alert("请输入旅店名称");
    		return false;
    	}
    	if($("input[name='startTime']").val()==null || $("input[name='startTime']").val()==""){
    		$.alert("请输入住宿日期");
    		return false;
    	}
    	if($("input[name='endTime']").val()==null || $("input[name='endTime']").val()==""){
    		$.alert("请输入离店日期");
    		return false;
    	}
    	if($("input[name='daysCost']").val()==null || $("input[name='daysCost']").val()==""){
    		$.alert("请输入天数");
    		return false;
    	}
    	if($("input[name='moneyCost']").val()==null || $("input[name='moneyCost']").val()==""){
    		$.alert("请输入金额");
    		return false;
    	}
    	if($("input[name='image']").val()==null || $("input[name='image']").val()==""){
    		$.alert("请上传出差票据照片");
    		return false;
    	}
    	return true;
    }
    function showInfo(){
    	if($("input[name='image']").val()!=null && $("input[name='image']").val()!=""){
    	  $("#picInfo").text("图片一已添加");   
    	} 
   	 }
  //文件上传反馈
	$(document).ready(function(){
	   var data="<%=data%>";
	   if(data==null){
		   
	   }else if(data=="fail"){
		   $.alert("系统繁忙,请稍后重试");
	   }
	});	
    //金额格式检查
    function checkFormat(e){
    	var s = /^(([1-9]\d*)|\d)(\.\d{1,2})?$/;
    	if(s.test($(e).val())){
    		
    	}else{
    		$.alert("金额必须为数字,请重新填写");
    		$(e).val("");
    	}
    }
  //金额格式检查
    function checkFormat2(e){
    	var s = /^(([1-9]\d*)|\d)(\.\d{1,2})?$/;
    	if(s.test($(e).val())){
    		
    	}else{
    		$.alert("天数必须为数字,请重新填写");
    		$(e).val("");
    	}
    }
  		//图片预览
	function showInfo(fileid,target){
		var preview = document.querySelector('#'+target);//获取img元素,显示图片位置，根据el表达式('#'+target)
		var file = document.querySelector('#'+fileid).files[0];//根据id拿到文件选择框里面的文件，
		var reader = new FileReader();//创建FileReader接口（把文件放到图片预览框里面）
		reader.onloadend = function () {
		preview.src = reader.result;
		}
		if (file) {
		reader.readAsDataURL(file);
		} else {
		preview.src = "";
		}
	}
    </script>
 </body> 
</html>
