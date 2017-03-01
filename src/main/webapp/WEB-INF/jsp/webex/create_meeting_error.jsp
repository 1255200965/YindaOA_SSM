<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"   import="com.ecache.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();/*获得当前项目的根路径 */
    
%>

<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<head>
<link rel="stylesheet" href="/exam/jquery-weui/stylesheets/weui.css?" />
<link rel="stylesheet" href="/exam/jquery-weui/stylesheets/jquery-weui.css" />
<link rel="stylesheet" href="/exam/jquery-weui/stylesheets/projectcss.css" />
<script src="/exam/jquery-weui/javascripts/jquery-2.1.4.js"></script>
<script src="/exam/jquery-weui/javascripts/jquery-weui.js"></script>

	
	
	

<title>创建会议成功</title>
</head>
<style>
.assess {
	background: #04BE02;
	color: white;
	width: 40px;
	height: 40px;
	border-radius: 40px;
	text-align: center;
	line-height: 40px;
}
body{
background: #f1f5f8;
}
.meeting{
margin-bottom:3px;

}

</style>
<body>
	<div class="weui-pull-to-refresh-layer">
		<div class="pull-to-refresh-arrow"></div>
		<!-- 上下拉动的时候显示的箭头 -->
		<div class="pull-to-refresh-preloader"></div>
		<!-- 正在刷新的菊花 -->
		<div class="down">下拉刷新</div>
		<!-- 下拉过程显示的文案 -->
		<div class="up">释放刷新</div>
		<!-- 下拉超过50px显示的文案 -->
		<div class="refresh">正在刷新...</div>
		<!-- 正在刷新时显示的文案 -->
	</div>
	<div class="weui-msg">
  <div class="weui-msg__icon-area"><i class="weui-icon-success weui-icon_msg"></i></div>
  <div class="weui-msg__text-area">
    <h2 class="weui-msg__title">失败!请联系管理员！</h2>
   
      <%-- <a href="<%=path%>/findAll_WebEx;" class="weui-btn weui-btn_primary">会议列表</a> --%>
     <!--  <a href="javascript:;" class="weui-btn weui-btn_default">辅助操作</a> -->
    
  </div>
  <div class="weui-msg__extra-area">
    <div class="weui-footer">
      <p class="weui-footer__links">
        <%-- <a href="javascript:<%=path%>/findAll_WebEx;" class="weui-footer__link">底部链接文本</a> --%>
      </p>
      <p class="weui-footer__text">上海音达科技实业有限公司</p>
    </div>
  </div>
</div>
	
	
	<script>
    /** 页面下拉刷新**/
    $(document.body).pullToRefresh();
    $(document.body).on("pull-to-refresh", function() {
        window.location.reload();
        $(document.body).pullToRefreshDone();
        
        
        
    });
  


   
    </script>



  
</body>
</html>
