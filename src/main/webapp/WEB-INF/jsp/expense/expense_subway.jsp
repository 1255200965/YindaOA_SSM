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
  <title>地铁公交票报销</title>
 </head>
 <body >
  <form id="form">	
  		 <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>月份</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		   <input class="weui_input" type="text" placeholder=""  name="askMonth" readonly>
   		    </div>
  		 </div>
  		
  	     <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>金额</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		   <input class="weui_input" type="text" placeholder=""  name="askMoney">
   		    </div>
  		 </div>
     	<br/>
        <div class="weui-row" id="option">
			<div class="weui-col-10"></div>
			<div class="weui-col-40"><input type="button" class="weui_btn weui_btn_mini weui_btn_primary"  value="提交" onclick="toExpense_subway_save();"></div>
			<div class="weui-col-20"><a href="javascript:history.go(-1);" class="weui_btn weui_btn_mini weui_btn_default">返回</a></div>
			<div class="weui-col-10"></div>
	    </div> 
  	 <!-- </div> -->
  	</form>	
  	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
    <script>
   
   $(document).ready(function(){
	   var curMonth;
	  if( new Date().getDate()>=20){
	   //获取当前月份
	   curMonth=new Date().getMonth()+1;
	  }else{
		  curMonth=new Date().getMonth();
	  }
	   if(curMonth<10){
		   curMonth="0"+curMonth;
	   }
	   //获取当前年份
	   var year = new Date().getFullYear();
	   var date = year+"-"+curMonth;
	   //重置报销日期只能是当前月份
	   $("input[name='askMonth']").val(date);   
   });
   function toExpense_subway_save(){
	   if($("input[name='askMoney']").val()==null || $("input[name='askMoney']").val()==""){
   		   $.alert("请填写申报金额");	   
	   }else{
	   $.post("toExpense_subway_save.do",$("#form").serialize(),function(data){
		   if(data=="success"){
			   $("#option").hide();
			   $.alert("提交成功,请等待管理员审核");
		   }else if(data=="fail"){
			   $.alert("系统繁忙,请稍后重试");
		   }
	   });
	   }
   }
  
    </script>
 </body> 
</html>
