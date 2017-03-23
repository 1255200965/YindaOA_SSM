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

	
	
	

<title>创建会议失败</title>
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

	<div class="weui-msg">
  <div class="weui-msg__icon-area"><i class="weui-icon-success weui-icon_msg"></i></div>
  <div class="weui-msg__text-area">
    <h2 class="weui-msg__title">该功能没有对您开放</h2>
   
      <%-- <a href="<%=path%>/findAll_WebEx;" class="weui-btn weui-btn_primary">会议列表</a> --%>
     <!--  <a href="javascript:;" class="weui-btn weui-btn_default">辅助操作</a> -->
    
  </div>
  <div class="weui-msg__extra-area">
    <div class="weui-footer">
    <h3 class="weui-msg__title">已开放名单</h2>
<p class="weui-footer__links">姓名               ——  工号 </p>
<p class="weui-footer__links">王龙	   ——  	11261</p>
<p class="weui-footer__links">秦光远	   —— 	17080</p>
<p class="weui-footer__links">方舒	   —— 	19561</p>	
<p class="weui-footer__links">吴梦萍	   —— 	10375</p>	
<p class="weui-footer__links">魏群	   —— 	22031</p>		
<p class="weui-footer__links">杨旭兰	   —— 	22031</p>	    
<p class="weui-footer__links">周靓	   —— 	10268</p>	    
<p class="weui-footer__links">黄照香	   —— 	19119</p>	    
<p class="weui-footer__links">丁希林	   ——   19179</p>	  
<p class="weui-footer__links">高雪峰	   ——    10305</p>	
<p class="weui-footer__links">韩永林           —— 	    13025</p>	
<p class="weui-footer__links">岳韶斌	   ——    41401</p>	
<p class="weui-footer__links">章其波	   ——    16318</p>	
<p class="weui-footer__links">孙华武	   ——  19355</p>	
<p class="weui-footer__links">谭英花           ——        14037</p>	
<p class="weui-footer__links">吴成勇           ——           19002</p>	
<p class="weui-footer__links">钱忠诚	   ——     10272</p>	
<p class="weui-footer__links">马天立	   ——    16360</p>	
<p class="weui-footer__links">徐圆圆	   ——    17082</p>
<p class="weui-footer__links">潘佳蕾           ——         17084</p>	
<p class="weui-footer__links">朱俊柯	   ——    19770</p>	
<p class="weui-footer__links">余芳芳  	   ——    70664</p>	
<p class="weui-footer__links">祁鑫炎 	   ——    16382</p>		  
                      
     
      
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
