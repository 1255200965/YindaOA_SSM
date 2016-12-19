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
  <title>火车票报销历史记录</title>
 </head>
 <body >
  	<div class="weui-row">
  		<div class="weui-col-40" style="overflow: hidden;"><b>日期</b></div>
  		<div class="weui-col-40" style="overflow: hidden;"><b>报销状态</b></div>
  		<a onclick="goExpense_bus();" style="color:red;"><b>新增</b></a>
  		<a></a>
    </div>
    <hr/>
    <c:forEach items="${expenseApplayTrainList }" var="expenseApplayTrain">
 	<div class="weui-row">
  		<div class="weui-col-40" style="overflow: hidden;">${expenseApplayTrain.startTime}</div>
  		<div class="weui-col-40" style="overflow: hidden;">${expenseApplayTrain.applayStatus}</div>
  		<a onclick="goExpense_view_train(${expenseApplayTrain.id});">查看</a>
  		<a></a>
    </div>
    <hr/>
    </c:forEach>
    <script>
    	function goExpense_bus(){
    		location="toExpense_train.do";
    	};
    	function goExpense_view_train(data){
    		location="toExpense_view_train.do?id="+data;
    	};
    </script>
 </body> 
</html>
