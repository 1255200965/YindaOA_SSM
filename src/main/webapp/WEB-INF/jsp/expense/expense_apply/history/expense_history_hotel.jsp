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
  <link rel="stylesheet" href="<%=path%>/stylesheets/expense.css"/>
  <script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
  <script src="<%=path%>/javascripts/jquery-weui.js"></script>
  <title>我的住宿费报销记录</title>
 </head>
 <body >
  	<div class="weui-row table-header">
  		<div class="weui-col-40" style="overflow: hidden;"><b>上车日期</b></div>
  		<div class="weui-col-40" style="overflow: hidden;"><b>报销状态</b></div>
  		<div><b>操作</b></div>
  		<a></a>
    </div>
    <hr/>
    <c:forEach items="${expenseApplayHotelList }" var="expenseApplayHotel">
 	<div class="weui-row font_content">
  		<div class="weui-col-40" style="overflow: hidden;">${expenseApplayHotel.startTime }</div>
  		<div class="weui-col-40" style="overflow: hidden;">${expenseApplayHotel.applayStatus }</div>
  		<button type="button"   style="background-color:#32CD32;" onclick="goExpense_view_hotel(${expenseApplayHotel.id})">查看</button>
  		<a></a>
    </div>
    <hr/>
    </c:forEach>
    <br/>
    <div class="weui-row" id="flag">
			<div class="weui-col-10"></div>
			<div class="weui-col-40" ><a onclick="reloadHtml();" class="weui_btn  weui_btn_primary">刷新</a></div>
			<div class="weui-col-40" ><a href="javascript:history.go(-1);" class="weui_btn   weui_btn_default">返回</a></div>
			<div class="weui-col-10"></div>
	</div> 
    <script>
    	function goExpense_hotel(){
    		location="toExpense_hotel.do";
    	};
    	function goExpense_view_hotel(data){
    		location="toExpense_view_hotel.do?id="+data;
    	};
    	function reloadHtml(){
    		window.location.reload();
    	};
    </script>
    <hr/>
 </body> 
</html>
