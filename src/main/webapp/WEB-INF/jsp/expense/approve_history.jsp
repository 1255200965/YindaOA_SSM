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
  <title>我的审批记录</title>
 </head>
 <body >
 <div class="weui_tab">
  <div class="weui_navbar">
    <a class="weui_navbar_item weui_bar_item_on" onclick="load('approved.do');" style="background:#6495ED;">
          已审批
    </a>
    <a class="weui_navbar_item" onclick="load('approval.do');" style="background:#F0F8FF;" >
         待审批
    </a>
  </div>
  <div class="weui_tab_bd" id="loadContent">
    
  </div>
  
</div>
<script>
    //页面加载
	function load(data){
    	$.modal({
    		title:"报销类别选择",
    	    text:"",
    	    buttons:[
    	     {text:"火车票",onClick:function(){$("#loadContent").load(data+"?type=train");}},
    	     {text:"大巴",onClick:function(){$("#loadContent").load(data+"?type=bus");}},
    	     {text:"公交地铁",onClick:function(){$("#loadContent").load(data+"?type=subway");}},
    	     {text:"住宿",onClick:function(){$("#loadContent").load(data+"?type=hotel");}},
    	             ],
    	});
		
	};
	 
</script>
    <script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
     <script type="text/javascript" src="http://g.alicdn.com/ilw/ding/0.7.3/scripts/dingtalk.js"></script>
 </body> 
</html>
