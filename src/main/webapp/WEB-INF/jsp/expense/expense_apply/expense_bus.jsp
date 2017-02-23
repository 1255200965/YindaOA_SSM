<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
<%
	String path = request.getContextPath();/*获得当前项目的根路径 */
	String data=request.getParameter("data");//回调返回数据
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
  <title>发起大巴车报销</title>
 </head>
 <body >
  <form id="form" method="post" enctype="multipart/form-data" action="toExpense_bus_save.do" onsubmit="return check();">
  	<!-- <div class="weui_cells" style="border:none;"> -->
  	    
  	     
  		<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>市/县</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="请填写所在市/县(必填)"  name="startCity" >
   		 </div>
     	</div>	
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>上车地址</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="请填写上车地址(必填)"  name="startAddress" >
   		 </div> 
     	</div>		
   
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>下车地址</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="请填写下车地址(必填)"  name="destination" >
   		 </div>
   		 
     	</div>
     	<div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>上车时间</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		   <input class="weui_input" type="text" placeholder="请填写上车时间(必填)"  name="beginTime" onfocus="(this.type='date')" >
   		    </div>
  		 </div>
  	    
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>下车时间</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="请填写下车时间(必填)"  name="endTime" onfocus="(this.type='date')" >
   		 </div>
   		 
     	</div>
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>金&nbsp;额</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="请填写报销金额(必填)"  name="moneyCost" onchange="checkFormat(this);">
   		 </div>
   		 
     	</div>
     	 <div class="weui_cell"> 
    		<div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>用车事由</b></label></div>
    	     <div class="weui_cell_ft weui_cell_primary">
     	        <input class="weui_input" type="text"   name="reason" placeholder="请填写用车事由(可选)">
   		     </div>
  	     </div> 
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>说&nbsp;明</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="请填写说明(可选)"  name="detailExplain" >
   		 </div>
   		 
     	</div>	
  	     <hr/>
  	     <div class="weui-row">
  	     <div class="weui_uploader_input_wrp">
            <input class="weui_uploader_input" type="file" id="image" accept="image/jpg,image/jpeg,image/png,image/gif" name="image" onchange="showInfo('image','picInfo');" value="">
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
		<div class="weui-col-80"><a href="<%=path%>/expenseApplyApprove/toExpense_history_bus.do" class="weui_btn  weui_btn_warn">历史报销信息查看</a></div>
		<div class="weui-col-10"></div>
		</div>	
	    
  	 <!-- </div> -->
  	</form>	
  	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
    <script type="text/javascript">
    function check(){
    	if($("input[name='startCity']").val()== null || $("input[name='startCity']").val()=="" ){
    		$.alert("请输入市/县");
    		return false;
    	}
    	if($("input[name='startAddress']").val()== null || $("input[name='startAddress']").val()=="" ){
    		$.alert("请输入上车地址");
    		return false;
    	}
    	if($("input[name='destination']").val()== null || $("input[name='destination']").val()=="" ){
    		$.alert("请输入下车地址");
    		return false;
    	}
    	if($("input[name='beginTime']").val()== null || $("input[name='beginTime']").val()=="" ){
    		$.alert("请输入上车时间");
    		return false;
    	}
    	if($("input[name='endTime']").val()== null || $("input[name='endTime']").val()=="" ){
    		$.alert("请输入下车时间");
    		return false;
    	}
    	if($("input[name='moneyCost']").val()== null || $("input[name='moneyCost']").val()=="" ){
    		$.alert("请输入金额");
    		return false;
    	}
    	if($("#image").val()==null || $("#image").val()==""){
    		$.alert("请上传出差票据信息照片");
    		return false;
    	}
    	return true;
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
