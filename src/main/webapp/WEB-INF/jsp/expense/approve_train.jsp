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
  <title>火车票报销审核</title>
 </head>
 <body >

  	<form id="form">
  	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>出发时间</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""  name="startTime" value="${expenseApplayTrain.startTime }" readonly>
     		<input class="weui_input" type="text" placeholder=""  name="id" value="${expenseApplayTrain.id }" readonly style="display:none;">
   		 </div>
     	</div>	
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>出发地点</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""  name="startAddress"  value="${expenseApplayTrain.startAddress }" readonly>
   		 </div>
   		 
     	</div>		
     	
  		 <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>到达时间</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		   <input class="weui_input" type="text" placeholder=""  name="endTime" value="${expenseApplayTrain.endTime }" readonly>
   		    </div>
  		 </div>
  	
  		 <div class="weui_cell"> 
    		<div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>目的地点</b></label></div>
    	     <div class="weui_cell_ft weui_cell_primary">
     	        <input class="weui_input" type="text"   name="endAddress" value="${expenseApplayTrain.endAddress }" readonly>
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
     		<input class="weui_input" type="text" placeholder=""  name="moneyCost" value="${expenseApplayTrain.moneyCost }" readonly>
   		 </div>
   		 
     	</div>
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>说&nbsp;明</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""  name="reason" value="${expenseApplayTrain.reason }" readonly>
     		<input class="weui_input" type="text" placeholder=""  name="imageUrl" value="${expenseApplayTrain.imageUrl }" readonly style="display:none;">
     		
   		 </div>
   		 
     	</div>	
  	     <hr/>
  	     <div class="weui_row">
     	<img src="http://121.40.29.241/YindaOA/upload/${expenseApplayTrain.imageUrl }" style="width:30%;height:10%；"/>
     	</div>	
  	    <!--  <div class="weui-row">
  	     <div class="weui_uploader_input_wrp">
            <input class="weui_uploader_input" type="file" accept="image/jpg,image/jpeg,image/png,image/gif" multiple="">
  	     </div>
  	     </div> -->
        <div class="weui-row">
			<div class="weui-col-10"></div>
			<div class="weui-col-80" ><a id="flag" onclick="approve_train_update();" class="weui_btn  weui_btn_primary" >通过</a></div>
			<div class="weui-col-10"></div>
	    </div> 
  	 <!-- </div> -->
  	</form>	
  	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
    <script>
    var flag="${flag}";
    $(document).ready(function(){
    	
    	if(flag=="pass"){
    		$("#flag").hide();
    	}
    });
    	function approve_train_update(){
    		$.post("approve_train_update.do",$("#form").serialize(),function(data){
    			if(data == 0){
    				$.alert("系统繁忙,请稍后重试");
    				
    			}else if(data ==1){
    			$.alert("审核通过成功");	
    			$("#flag").hide();
    			}
    			
    		});
    	}
    </script>
 </body> 
</html>
