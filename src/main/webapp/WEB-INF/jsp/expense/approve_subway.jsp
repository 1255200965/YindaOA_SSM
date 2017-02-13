<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
<%
	String path = request.getContextPath();/*获得当前项目的根路径 */
	String data= request.getParameter("data");
%>
<!-- 地铁公交费用报销管理员审核界面 -->
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
 <head>
  <link rel="stylesheet" href="<%=path%>/stylesheets/weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/jquery-weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/projectcss.css"/>
  <title>地铁公交报销审批</title>
 </head>
 <body >
  <form id="form" >	
  	    <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>员工姓名</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		   <p> ${subwayApply.askStaffName }</p>
   		    </div>
  		 </div>
  		  <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>部门</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		   <p>${subwayApply.askStaffDepart }</p>
   		    </div>
  		 </div>
  		 <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>月份</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		    <p>${subwayApply.askMonth }月</p>
     		    <input class="weui_input" type="text" placeholder=""  name="id" value="${subwayApply.id }"  style="display:none;">
   		    </div>
  		 </div>
  		
  	     <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>金额</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		  <p>${subwayApply.askMoney}</p>
   		    </div>
  		 </div>
     	<br/>
        <div class="weui-row" id="approveOption">
			<div class="weui-col-10"></div>
			<div class="weui-col-40"><input type="button" onclick="approveResult('agree');" class="weui_btn weui_btn_mini weui_btn_primary"  value="同意"></div>
			<div class="weui-col-20"><a onclick="approveResult('disagree');" class="weui_btn weui_btn_mini weui_btn_default">驳回</a></div>
			<div class="weui-col-10"></div>
	    </div> 
  	 <!-- </div> -->
  	</form>	
  	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
    <script>
     var flag='${flag}';
      function approveResult(data){
    	 
    	  $.post("expense_subway_approve_update.do",{"result":data,"id":$("input[name='id']").val()},function(data2){
    		 if(data2=="success"){
    			 $("#approveOption").hide();
    			 $.alert("操作成功");
    		 } else{
    			 $.alert("系统繁忙,请重新操作");
    		 }
    	  });
    	  
      }
      $(document).ready(function(){
    	  if(flag=="hide"){
    		  $("#approveOption").hide();
    	  }
      });
    </script>
 </body> 
</html>
