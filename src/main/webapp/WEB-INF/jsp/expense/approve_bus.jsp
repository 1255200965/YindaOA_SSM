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
  <title>大巴票报销详细信息查看</title>
 </head>
 <body >
  <form id="form">
  	<!-- <div class="weui_cells" style="border:none;"> -->
  	     <br/>
  	     <div style="text-align:center;">---------------------上车---------------------</div>
  		<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>市/县</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""  name="startCity" value="${expenseApplayBus.startCity}" readonly>
     		<input class="weui_input" type="text" placeholder=""  name="id" value="${expenseApplayBus.id}" readonly style="display:none;">
   		 </div>
     	</div>	
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>地址</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""  name="startAddress" value="${expenseApplayBus.startAddress }" readonly>
   		 </div>
   		 
     	</div>		
     	
  		 <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>时间</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		   <input class="weui_input" type="text" placeholder=""  name="beginTime" value="${expenseApplayBus.beginTime }" readonly>
   		    </div>
  		 </div>
  	
  		 <div class="weui_cell"> 
    		<div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>用车事由</b></label></div>
    	     <div class="weui_cell_ft weui_cell_primary">
     	        <input class="weui_input" type="text"   name="reason" value="${expenseApplayBus.reason}" readonly>
   		     </div>
  	     </div> 
  	     <div style="text-align:center;">---------------------下车---------------------</div>
  	     <br/>
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>地址</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""  name="destination" value="${expenseApplayBus.destination }" readonly>
   		 </div>
   		 
     	</div>
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>时间</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""  name="endTime" value="${expenseApplayBus.endTime }" readonly>
   		 </div>
   		 
     	</div>
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>金&nbsp;额</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""  name="moneyCost" value="${expenseApplayBus.moneyCost }" readonly>
   		 </div>
   		 
     	</div>
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>说&nbsp;明</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""  name="detailExplain" value="${expenseApplayBus.detailExplain }" readonly>
   		 </div>
   		 
     	</div>
     	<div class="weui_row">
     	<img src="http://121.40.29.241/YindaOA/upload/${expenseApplayBus.imageUrl }" style="width:30%;height:10%"/>
     	</div>	
  	     <hr/>
  	    <%--  <div class="weui-row">
  	     <div class="weui_uploader_input_wrp">
             <img src="${expenseApplayBus.detailExplain }"/>
  	     </div>
  	     </div> --%>
        <div class="weui-row">
			<div class="weui-col-10"></div>
			<div class="weui-col-60"><a onclick="to_approve_bus_update();" class="weui_btn  weui_btn_primary">通过</a></div>
			<div class="weui-col-10"></div>
	    </div> 
  	 <!-- </div> -->
  	</form>	
  	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
    <script type="text/javascript">
    function to_approve_bus_update(){
     $.post("to_approve_bus_update.do",$("#form").serialize(),function(data){
    	 if(data==1){
    		 $.alert("通过报销审批");
    	 }else if(data == 0){
    		 $.alert("系统繁忙,请稍后重试");
    	 }
     });
    }
    </script>
 </body> 
</html>
