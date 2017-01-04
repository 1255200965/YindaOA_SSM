<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();/*获得当前项目的根路径 */
%>
<!-- 地铁公交票审批页面 -->
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
  <title>我的地铁公交费用报销记录</title>
 </head>
 <body >
  	<div class="weui-row">
  		<div class="weui-col-40" style="overflow: hidden;"><b>月份</b></div>
  		<div class="weui-col-40" style="overflow: hidden;"><b>报销状态</b></div>
  		<a  onclick="subwayAdd();" style="color:red;"><b >新增</b></a>
  		<a></a>
  		<!-- <a></a> -->
    </div>
    <hr/>
    <c:forEach items="${subwayList }" var="subway">
 	<div class="weui-row">
  		<div class="weui-col-40" style="overflow: hidden;">${subway.askMonth }</div>
  		<div class="weui-col-40" style="overflow: hidden;">${subway.approveStatus}</div>
  		<a onclick="detailView(${subway.id});">查看</a>
  		<a></a>
    </div>
    <hr/>
    </c:forEach>
    <script>
    	function detailView(id){
    	  location = "subwayDetailView.do?id="+id;
    	};
    	function subwayAdd(){
    		location="toExpense_subway.do";
    	};
    </script>
 </body> 
</html>
