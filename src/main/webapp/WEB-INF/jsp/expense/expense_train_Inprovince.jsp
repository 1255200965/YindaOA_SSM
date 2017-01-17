<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
<%
	String path = request.getContextPath();/*获得当前项目的根路径 */
	String data = request.getParameter("data");
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
  <title>添加火车票</title>
 </head>
 <body >

  	
  	<form id="form" action="expense_train_save.do" method="post" enctype="multipart/form-data" onsubmit="return check();" >
  	<!-- <div class="weui_cells" style="border:none;"> -->
  	   
  		<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>上车时间</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="date" placeholder=""   value="" name="startTime">
     		
   		 </div>
     	</div>	
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>上车地点</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""  name="startAddress" value="" id="startAddress" >
   		 </div>
   		 
     	</div>		
     	
  		 <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>下车时间</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		   <input class="weui_input" type="date" placeholder=""  name="endTime"  id="endTime" >
   		    </div>
  		 </div>
  	
  		 <div class="weui_cell"> 
    		<div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>下车地点</b></label></div>
    	     <div class="weui_cell_ft weui_cell_primary">
     	        <input class="weui_input" type="text"   name="endAddress"  id="endAddress">
   		     </div>
  	     </div> 
  	     
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>订票方式</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""   value="自购" >
   		 </div>
   		 
     	</div>
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>车次</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""   value="" name="trainNum">	
   		 </div>
     	</div>	
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>金&nbsp;额</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""  name="moneyCost" value="" id="moneyCost">
   		 </div>
   		 
     	</div>
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>说&nbsp;明</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""  name="reason"  id="reason">
   		 </div>
   		 
     	</div>	
  	     <hr/>
  	     <div class="weui-row">
  	     <div class="weui_uploader_input_wrp">
            <input class="weui_uploader_input" type="file" accept="image/jpg,image/jpeg,image/png,image/gif" multiple="" name="image"  onchange="showInfo();">
            <p id="picInfo"></p>
  	     </div>
  	     </div>
        <div class="weui-row">
			<div class="weui-col-10"></div>
			<div class="weui-col-40"><input type="submit" class="weui_btn weui_btn_mini weui_btn_primary"  value="提交"></div>
			<div class="weui-col-20"><a href="javascript:history.go(-2);" class="weui_btn weui_btn_mini weui_btn_default">返回</a></div>
			<div class="weui-col-10"></div>
	    </div> 
  	 <!-- </div> -->
  	</form>
  	
  	
  	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
    <script type="text/javascript">
   //提交前的信息完整性校验
    function check(){
    	if($("input[name='trainNum']").val()==null || $("input[name='trainNum']").val()==""){
    		$.alert("请填写车次信息");
    		return false;
    	}
    	if($("input[name='startTime']").val()==null || $("input[name='startTime']").val()==""){
    		$.alert("请填写下车时间");
    		return false;
    	}
    	if($("input[name='image']").val()==null || $("input[name='image']").val()==""){
    		$.alert("请上传出差票据信息照片");
    		return false;
    	}
    	if($("input[name='moneyCost']").val()==null || $("input[name='moneyCost']").val()==""){
    		$.alert("请填写报销金额");
    		return false;
    	}	
    	if($("input[name='endTime']").val()==null || $("input[name='endTime']").val()==""){
    		$.alert("请填写上车时间");
    		return false;
    	}
    	
    	if($("input[name='startAddress']").val()==null || $("input[name='startAddress']").val()==""){
    		$.alert("请填写上车地点");
    		return false;
    	}
    	if($("input[name='endAddress']").val()==null || $("input[name='endAddress']").val()==""){
    		$.alert("请填写下车地点");
    		return false;
    	}
    	return true;
    }
   //展示图片添加信息
    function showInfo(){
    	if($("input[name='image']").val()!=null && $("input[name='image']").val()!=""){
    	  $("#picInfo").text("图片一");   
    	} 
   	 }
   
  //文件上传反馈
	$(document).ready(function(){
		
	   var data="<%=data%>";
	   
	   if(data == null || data ==""){
		  
	   }else if(data=="fail"){
		   $.alert("系统繁忙,请稍后重试");
	   }
	});		
    </script>
 </body> 
</html>
