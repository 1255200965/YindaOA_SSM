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
  <title>的士票报销历史信息</title>
 </head>
 <body >
  	<div class="weui-row">
  		<div class="weui-col-20" style="overflow: hidden;"><b>日期</b></div>
  		<div class="weui-col-20" style="overflow: hidden;"><b>报销状态</b></div>
  		<a onclick="goExpense_taxi();" ><b>新增</b></a>
  		<a></a>
    </div>
    <hr/>
    <c:forEach items="${expenseApplayTaxiList }" var="expenseApplayTaxi">
 	<div class="weui-row">
  		<div class="weui-col-20" style="overflow: hidden;">${expenseApplayTaxi.startTime }</div>
  		<div class="weui-col-20" style="overflow: hidden;">${expenseApplayTaxi.applayStatus}</div>
  		<a onclick="goExpense_view_taxi(${expenseApplayTaxi.id});">查看</a>
  		<a href="javascript:history.go(-1);">返回</a>
    </div>
    <hr/>
    </c:forEach>
    <script>
    	function goExpense_taxi(){
    		location="toExpense_taxi.do";
    	};
    	function goExpense_view_taxi(data){
    		location="toExpense_view_taxi.do?id="+data;
    	};
    </script>
 </body> 
</html>
