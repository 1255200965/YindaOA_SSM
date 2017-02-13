<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
<%
	String path = request.getContextPath();/*获得当前项目的根路径 */
%>
<!-- 钉钉应用内报销审核入口界面 -->
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
 <head>
  <link rel="stylesheet" href="<%=path%>/stylesheets/weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/jquery-weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/projectcss.css"/>
  <title>我的审批记录</title>
 </head>
 <body >
 <div class="weui_grids">
  <a  class="weui_grid js_grid" onclick="jump('approved.do');">
    <div class="weui_grid_icon">
      <img src="<%=path%>/images/train.png" alt="">
    </div>
    <p class="weui_grid_label">
                   已审批
    </p>
  </a>
  <a  class="weui_grid js_grid" onclick="jump('approval.do');">
    <div class="weui_grid_icon">
      <img src="<%=path%>/images/train.png" alt="">
    </div>
    <p class="weui_grid_label">
                 待审批
    </p>
  </a>
  </div>
<script>
    //页面加载
	function jump(data){
    	
    	$.modal({
    		title:"",
    	    text:"",
    	    buttons:[
    	     {text:"火车票",onClick:function(){location=data+"?type=train";}},
    	     {text:"大巴",onClick:function(){location=data+"?type=bus";}},
    	     {text:"公交地铁",onClick:function(){location=data+"?type=subway";}},
    	     {text:"住宿",onClick:function(){location=data+"?type=hotel";}},
    	             ],
    	});
		
	};
	 
</script>
    <script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
     <script type="text/javascript" src="http://g.alicdn.com/ilw/ding/0.7.3/scripts/dingtalk.js"></script>
 </body> 
</html>
