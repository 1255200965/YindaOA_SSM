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
  <title>添加大巴票</title>
 </head>
 <body >
  <form id="form" method="post" enctype="multipart/form-data" action="toExpense_bus_save.do">
  	<!-- <div class="weui_cells" style="border:none;"> -->
  	     <br/>
  	     <div style="text-align:center;">---------------------上车---------------------</div>
  		<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>市/县</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="" id="picker" name="startCity" >
   		 </div>
     	</div>	
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>地址</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="" id="start" name="startAddress" >
   		 </div>
   		 
     	</div>		
     	
  		 <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>时间</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		   <input class="weui_input" type="date" placeholder=""  name="beginTime" >
   		    </div>
  		 </div>
  	
  		 <div class="weui_cell"> 
    		<div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>用车事由</b></label></div>
    	     <div class="weui_cell_ft weui_cell_primary">
     	        <input class="weui_input" type="text"  id="name" name="reason" >
   		     </div>
  	     </div> 
  	     <div style="text-align:center;">---------------------上车---------------------</div>
  	     <br/>
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>地址</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="" id="name" name="destination" >
   		 </div>
   		 
     	</div>
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>时间</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="date" placeholder="" id="name" name="endTime">
   		 </div>
   		 
     	</div>
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>金&nbsp;额</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="" id="name" name="moneyCost" >
   		 </div>
   		 
     	</div>
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>说&nbsp;明</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder="" id="name" name="detailExplain" >
   		 </div>
   		 
     	</div>	
  	     <hr/>
  	     <div class="weui-row">
  	     <div class="weui_uploader_input_wrp">
            <input class="weui_uploader_input" type="file" accept="image/jpg" name="image.jpg">
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
    	<%-- $(document).ready(function(){
    		var data="<%=data%>";
    		if(data == "success"){
				$.alert("提交成功,请耐心等待审核结果");
				location="toExpense_history_bus.do";
			}else{
				$.alert("系统繁忙,请稍后重试");
			}
    	}); --%>
    			
    </script>
 </body> 
</html>
