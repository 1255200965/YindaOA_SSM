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
  <title>已审批报销列表展示</title>
 </head>
 <body >
 <body >
  	<div class="weui-row">
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
  		<div class="weui-col-20" style="overflow: hidden;">${approval.staffName}</div>
  		<div class="weui-col-20" style="overflow: hidden;">${approval.moneyCost}</div>
  		<div class="weui-col-20" style="overflow: hidden;">${approval.applayStatus}</div>
  		<a onclick="approvalOption('${approval.id}','${type}','${approval.approverNow }');" >审批</a>
  		<a></a>
  		<!-- <a href="javascript:history.go(-1);">返回</a> -->
    </div>
    <hr/>
    </c:forEach>
    <script>
    
    function approvalOption(id,type,manager){
		if("train" == type){
			window.location.href="to_approve_train.do?id="+id+"&manager="+manager;
		}
		if("bus" == type){
			window.location.href="to_approve_bus.do?id="+id+"&manager="+manager;
		}
		if("hotel" == type){
			window.location.href="to_approve_hotel.do?id="+id+"&manager="+manager;
		}
		if("subway" == type){
			window.location.href="toExpense_subway_approve.do?id="+id+"&manager="+manager;
		}
	}
   
    
    
    </script>
 </body> 
    <script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
     <script type="text/javascript" src="http://g.alicdn.com/ilw/ding/0.7.3/scripts/dingtalk.js"></script>
 </body> 
</html>
