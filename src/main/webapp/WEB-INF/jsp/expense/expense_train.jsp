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
  <form id="form" action="expense_train_save.do" method="post" enctype="multipart/form-data" >
  	<!-- <div class="weui_cells" style="border:none;"> -->
  		<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>出发时间</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<!-- <input class="weui_input" type="date" placeholder=""  name="startTime"> -->
     		<select class="weui_select" name="btSequenceNo" onchange="getDetail();">
  	 		   <c:forEach items="${businessTripList}" var="businessTrip">
  	 		   			<option value=""></option>
  	   					<option value="${businessTrip.btSequenceNo }">${businessTrip.btAskBeginTime}----${businessTrip.btStartCity}---->${businessTrip.btAddress }</option>
  	  			</c:forEach>
  			</select>
   		 </div>
     	</div>	
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>出发地点</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""  name="startAddress" value="" id="startAddress" readonly>
   		 </div>
   		 
     	</div>		
     	
  		 <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>到达时间</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		   <input class="weui_input" type="date" placeholder=""  name="endTime"  id="endTime" readonly>
   		    </div>
  		 </div>
  	
  		 <div class="weui_cell"> 
    		<div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>目的地点</b></label></div>
    	     <div class="weui_cell_ft weui_cell_primary">
     	        <input class="weui_input" type="text"   name="endAddress"  id="endAddress" readonly>
   		     </div>
  	     </div> 
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>订票方式</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""   value="自购" readonly>
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
     		<input class="weui_input" type="text" placeholder=""  name="reason"  id="reason" readonly>
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
			<div class="weui-col-20"><a href="javascript:history.go(-1);" class="weui_btn weui_btn_mini weui_btn_default">返回</a></div>
			<div class="weui-col-10"></div>
	    </div> 
  	 <!-- </div> -->
  	</form>
  	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
    <script type="text/javascript">
    function showInfo(){
    	if($("input[name='image']").val()!=null && $("input[name='image']").val()!=""){
    	  $("#picInfo").text("图片一");   
    	} 
   	 }
    function getDetail(){
    	$.post("getDetail.do",{"btSequenceNo":$("select[name='btSequenceNo']").val()},function(data){
    		$("#startAddress").val(data.btStartCity);
    		$("#reason").val(data.btAskReason);
    		$("#endAddress").val(data.btAddress);
    		$("#endTime").val(data.btAskBeginTime);
    	});
    }
  //文件上传反馈
	$(document).ready(function(){
	   var data="<%=data%>";
	   if(data==null){
		   
	   }else if(data == "success"){
		   $.alert("提交成功,请耐心等待管理员审核");
		 /* location="toExpense_history_bus.do";  */
		   window.history.go(-2);
		/*  window.history.back(-2); */
	   }else if(data=="fail"){
		   $.alert("系统繁忙,请稍后重试");
	   }
	});		
    </script>
 </body> 
</html>
