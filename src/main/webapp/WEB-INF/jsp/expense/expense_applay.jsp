<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
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
  <title>报销申请</title>
 </head>
 <body >
 <div class="weui_grids">
  <a  class="weui_grid js_grid" onclick="goExpense_train();">
    <div class="weui_grid_icon">
      <img src="<%=path%>/images/train.png" alt="">
    </div>
    <p class="weui_grid_label">
                   火车票
    </p>
  </a>
  <a  class="weui_grid js_grid" data-id="cell" onclick="goExpense_history_bus();">
    <div class="weui_grid_icon">
      <img src="<%=path%>/images/bus.png" alt="">
    </div>
    <p class="weui_grid_label">
              大巴费
    </p>
  </a>
  <a href="javascript:;" class="weui_grid js_grid" data-id="toast" onclick="goExpense_taxi();">
    <div class="weui_grid_icon">
      <img src="<%=path%>/images/bus.png" alt="">
    </div>
    <p class="weui_grid_label">
            的士费
    </p>
  </a>
  <a href="javascript:;" class="weui_grid js_grid" data-id="toast" onclick="goExpense_hotel();">
    <div class="weui_grid_icon">
      <img src="<%=path%>/images/bus.png" alt="">
    </div>
    <p class="weui_grid_label">
         住宿费
    </p>
  </a>
  <a href="javascript:;" class="weui_grid js_grid" data-id="toast">
    <div class="weui_grid_icon">
       <img src="<%=path%>/images/icon_nav_actionSheet.png" alt="">
    </div>
    <p class="weui_grid_label">
     &nbsp;
    </p>
  </a>  
</div>
  	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
    <script>
     function goExpense_train(){
    	 location="toExpense_history_train.do";
     }
     function goExpense_history_bus(){
    	 location="toExpense_history_bus.do";
     }
     function goExpense_taxi(){
    	 location="toExpense_history_taxi.do";
     }
     function goExpense_hotel(){
    	 location="toExpense_history_hotel.do";
     }
    </script>
 </body> 
</html>
