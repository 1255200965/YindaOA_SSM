<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
<%
	String path = request.getContextPath();/*获得当前项目的根路径 */
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
  <form id="form">
  	<!-- <div class="weui_cells" style="border:none;"> -->
  		<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>出发时间</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="date" placeholder="" id="picker" name="startTime">
   		 </div>
     	</div>	
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>出发地点</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="" id="start" name="startAddress" >
   		 </div>
   		 
     	</div>		
     	
  		 <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>到达时间</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		   <input class="weui_input" type="date" placeholder="" id="picker" name="endTime">
   		    </div>
  		 </div>
  	
  		 <div class="weui_cell"> 
    		<div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>目的地点</b></label></div>
    	     <div class="weui_cell_ft weui_cell_primary">
     	        <input class="weui_input" type="text"  id="name" name="endAddress">
   		     </div>
  	     </div> 
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>订票方式</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="" id="name"  value="自购" readonly>
   		 </div>
   		 
     	</div>
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>金&nbsp;额</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="" id="name" name="moneyCost" value="">
   		 </div>
   		 
     	</div>
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>说&nbsp;明</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="" id="name" name="reason" value="" >
   		 </div>
   		 
     	</div>	
  	     <hr/>
  	     <div class="weui-row">
  	     <div class="weui_uploader_input_wrp">
            <input class="weui_uploader_input" type="file" accept="image/jpg,image/jpeg,image/png,image/gif" multiple="">
  	     </div>
  	     </div>
        <div class="weui-row">
			<div class="weui-col-10"></div>
			<div class="weui-col-40"><a onclick="expense_train_save();" class="weui_btn weui_btn_mini weui_btn_primary" >提交</a></div>
			<div class="weui-col-20"><a href="javascript:history.go(-1);" class="weui_btn weui_btn_mini weui_btn_default">返回</a></div>
			<div class="weui-col-10"></div>
	    </div> 
  	 <!-- </div> -->
  	</form>	
  	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
    <script type="text/javascript">
      function expense_train_save(){
    	  $.post("expense_train_save.do",$("#form").serialize(),function(data){
    		  if(data=="success"){
    			  $.alert("提交成功,请耐心等待审核");
    		  }else{
    			  $.alert("系统繁忙,请稍后重试");
    		  }
    	  });
      }
    </script>
 </body> 
</html>
