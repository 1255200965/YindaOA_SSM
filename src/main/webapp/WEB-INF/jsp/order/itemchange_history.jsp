<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  <script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
  <script src="<%=path%>/javascripts/jquery-weui.js"></script>
  <title>项目变更申请历史记录</title>
 </head>
 <body >
  	<div class="weui-row">
  		<div class="weui-col-35" style="overflow: hidden;"><b>日期</b></div>
  		<div class="weui-col-25" style="overflow: hidden;"><b>审批状态</b></div>
  		<div class="weui-col-25" style="overflow: hidden;"><b>审批结果</b></div>
  		<div class="weui-col-15" style="overflow: hidden;"><b>操作</b></div>
  	
  		<!-- <a></a> -->
    </div>
    <hr/>
    <c:forEach items="${itemChangeList }" var="itemChange">
 	<div class="weui-row">
  		<div class="weui-col-35" style="overflow: hidden;">${itemChange.icApproveBegin}</div>
  		<div class="weui-col-25" style="overflow: hidden;">${itemChange.icApproveState}</div>
  		<div class="weui-col-25" style="overflow: hidden;">${itemChange.icApproveResult}</div>
  		
  		<div class="weui-col-15" style="overflow: hidden;"><a onclick="itemChange_view(${itemChange.icSequenceNo});">查看</a></div>
  		<!-- <a href="javascript:history.go(-1);">返回</a> -->
    </div>
    <hr/>
    </c:forEach>
    <script>
    	function itemChange_view(data){
    		location="itemChange_view.do?id="+data;
    	};
    </script>
 </body> 
</html>
