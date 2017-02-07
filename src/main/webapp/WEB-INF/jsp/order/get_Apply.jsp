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
  <title>申请记录</title>
 </head>
 <body >
  	<div class="weui-row">
  		<div class="weui-col-35" style="overflow: hidden;"><b>日期</b></div>
  		<div class="weui-col-25" style="overflow: hidden;"><b>申请人</b></div>
  		<div class="weui-col-25" style="overflow: hidden;"><b>审批结果</b></div>
  		<div class="weui-col-15" style="overflow: hidden;"><b>操作</b></div>
  	
  		<!-- <a></a> -->
    </div>
    <hr/>
    <c:forEach items="${orderChangeList}" var="orderChange">
 	<div class="weui-row">
  		<div class="weui-col-35" style="overflow: hidden;">${fn:substring(orderChange.modifyTime,0,10)}</div>
  		<div class="weui-col-25" style="overflow: hidden;">${orderChange.modifyUser}</div>
  		
  		<div class="weui-col-25" style="overflow: hidden;">
  		<c:choose>

   <c:when test="${orderChange.orderStatus eq '审核通过' && orderChange.orderResult eq null}"> 
             审核中
   </c:when>
   
   <c:otherwise>
    ${orderChange.orderStatus}
   
   </c:otherwise>
  
</c:choose></div>
  		<div class="weui-col-15" style="overflow: hidden;"><a onclick="go_approve_page(${orderChange.id},${sessionScope.staff_user_id});">查看</a></div>
  		<!-- <a href="javascript:history.go(-1);">返回</a> -->
    </div>
    <hr/>
    </c:forEach>
    <script>
   function go_approve_page(id,userid){
    	
    	window.location =  "<%=path%>/orderChange/select_orderchage.do?id="+id+"&staff_user_id="+userid;
    	
    }
    </script>
 </body> 
</html>
