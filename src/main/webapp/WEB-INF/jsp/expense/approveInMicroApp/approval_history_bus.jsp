<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
<%
	String path = request.getContextPath();/*获得当前项目的根路径 */
%>
<!-- 页面复用大巴、火车、旅店的待审批报销信息都在该页面做列表展示 -->
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
 <head>
  <link rel="stylesheet" href="<%=path%>/stylesheets/weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/jquery-weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/projectcss.css"/>
  <title>待审批报销列表展示</title>
 </head>
 <body >
 <body >
  	<div class="weui-row">
  		<button type="button" style="background-color:#32CD32;" onclick="selectAll();" id="selectAll">全选</button>
  		<div class="weui-col-20" style="overflow: hidden;"><b>报销人</b></div>
  		<div class="weui-col-20" style="overflow: hidden;"><b>报销金额</b></div>
  		<div class="weui-col-20" style="overflow: hidden;"><b>报销状态</b></div>
  		<a><b style="color:#696969;">操作</b></a>
  		<a></a>
  		<!-- <a></a> -->
    </div>
    <hr/>
    <c:forEach items="${approvalList }" var="approval">
 	<div class="weui-row">
 		<input type="checkbox" name="ids" value="${approval.id}"/> 
  		<div class="weui-col-20" style="overflow: hidden;">${approval.staffName}</div>
  		<div class="weui-col-20" style="overflow: hidden;">${approval.moneyCost}</div>
  		<div class="weui-col-20" style="overflow: hidden;">${approval.applayStatus}</div>
  		<button type="button" style="background-color:#32CD32;" onclick="approvalOption('${approval.id}','${type}','${approval.approverNow }');" >审批</button>
  		<a></a>
  		<!-- <a href="javascript:history.go(-1);">返回</a> -->
    </div>
    <hr/>
    </c:forEach>
    
    <div><a onclick="approvalOptions('${type}','agree');" class="weui_btn weui_btn_primary" >一键审批</a></div>
    <br/>
    <div><a href="javascript:history.go(-1);" class="weui_btn weui_btn_plain_default" >返回</a></div>
    
    <script>
    //单条审批
    function approvalOption(id,type,manager){
		if("train" == type){
			window.location.href="go_approve_train.do?id="+id+"&manager="+manager;
		}
		if("bus" == type){
			window.location.href="go_approve_bus.do?id="+id+"&manager="+manager;
		}
		if("hotel" == type){
			window.location.href="go_approve_hotel.do?id="+id+"&manager="+manager;
		}
		if("subway" == type){
			window.location.href="toExpense_subway_approve.do?id="+id+"&manager="+manager;
		}
	}
    //批量审批
   function approvalOptions(type,result){
	   if("train" == type){
		   var str=getValues();
		   if(str==""){
			   $.alert("请选择一键审批报销数据");
		   }else{
			$.post("approve_train_updates.do",{ids:str,result:result},function(data){
				if(data=="success"){
					$.alert("操作成功");
					window.location.reload();
				}else {
					$.alert("系统繁忙,请稍后重试");
				}
			}); 
		   }
		}
		if("bus" == type){
			 var str=getValues();
			 if(str==""){
				   $.alert("请选择一键审批报销数据");
			   }else{
				$.post("approve_bus_updates.do",{ids:str,result:result},function(data){
					if(data=="success"){
						$.alert("操作成功");
						window.location.reload();
					}else {
						$.alert("系统繁忙,请稍后重试");
					}
			     }); 
			   }
		}
		if("hotel" == type){
			var str=getValues();
			if(str==""){
				   $.alert("请选择一键审批报销数据");
			   }else{
				$.post("approve_hotel_updates.do",{ids:str,result:result},function(data){
					if(data=="success"){
						$.alert("操作成功");
						window.location.reload();
					}else {
						$.alert("系统繁忙,请稍后重试");
					}
				}); 
			   }
		}
		
   }
   
   //获取复选框的值
  function getValues(){
	  var checkboxes=document.getElementsByName("ids");
	  var str = "";
	  for(var i=0;i<checkboxes.length;i++){
		  if(checkboxes[i].checked){
			 if(str != ""){
			 str +=","+ checkboxes[i].value;
			 }else{
				 str += checkboxes[i].value;
			 }
		  }
	  }
	  return str;
  }  
   //全选
  function selectAll(){
	   var text=$("#selectAll").text();
	   if(text == "全选"){
		   var checkboxes=document.getElementsByName("ids");
	  		for(var i=0;i<checkboxes.length;i++){
		 		 checkboxes[i].checked=true;  
	 		 } 
	  		$("#selectAll").text("清空");
	   }
	   if(text =="清空"){ 
		   var checkboxes=document.getElementsByName("ids");
	  		for(var i=0;i<checkboxes.length;i++){
	  			checkboxes[i].checked=false;
	 		 } 
	  		$("#selectAll").text("全选");
	   }
  }  
    </script>
 </body> 
    <script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
     <script type="text/javascript" src="http://g.alicdn.com/ilw/ding/0.7.3/scripts/dingtalk.js"></script>
 </body> 
</html>
