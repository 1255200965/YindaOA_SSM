<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
  <script type="text/javascript" src="http://g.alicdn.com/ilw/ding/0.7.3/scripts/dingtalk.js"></script>

  <title>待审批列表</title>
 </head>
 <body id="content"> 
    <div class="weui-pull-to-refresh-layer">
    <div class="pull-to-refresh-arrow"></div> <!-- 上下拉动的时候显示的箭头 -->
    <div class="pull-to-refresh-preloader"></div> <!-- 正在刷新的菊花 -->
    <div class="down">下拉刷新</div><!-- 下拉过程显示的文案 -->
    <div class="up">释放刷新</div><!-- 下拉超过50px显示的文案 -->
    <div class="refresh">正在刷新...</div><!-- 正在刷新时显示的文案 -->
    </div>
    <div></div>
  	<div class="weui-row">
  		<div class="weui-col-35" style="overflow: hidden;"><b>日期</b></div>
  		<div class="weui-col-25" style="overflow: hidden;"><b>申请人</b></div>
  		<div class="weui-col-25" style="overflow: hidden;"><b>审批状态</b></div>
  		<div class="weui-col-15" style="overflow: hidden;"><b>操作</b></div>
  	
  		<!-- <a></a> -->
    </div>
    <hr/>
   
    <c:forEach items="${orderChangeList}" var="orderChange">
 	<div class="weui-row">
  		<div class="weui-col-35" style="overflow: hidden;">${orderChange.modifyTime}</div>
  		<div class="weui-col-25" style="overflow: hidden;">${orderChange.modifyUser}</div>
  		<div class="weui-col-25" style="overflow: hidden;">未完成</div>
  		
  		<div class="weui-col-15" style="overflow: hidden;"><a onclick="ajaxLoadPage('${orderChange.id}','${sessionScope.staff_user_id}');">审批</a></div>
  		<!-- <a href="javascript:history.go(-1);">返回</a> -->
    </div>
    <hr/>
    </c:forEach>
    
    <script>
    /** 页面下拉刷新**/
    $(document.body).pullToRefresh();   
    $(document.body).on("pull-to-refresh", function() {   	 
    	window.location.reload();  	 	
    	$(document.body).pullToRefreshDone();
    	});
    </script>
    <script>  
  
function ajaxLoadPage(id,staff_user_id){
	$.post("<%=path%>/orderChange/approve_order_page_in.do",{'id':id,'staff_user_id':staff_user_id},function (data){
		
		  $("#content").html(data);
		
	})
	
}

    </script>
 </body> 
</html>
