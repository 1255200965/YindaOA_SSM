<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
<%
	String path = request.getContextPath();
%>
<html lang="en">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
 <head>
    <title>音达集团年终抽奖活动</title>
	<link rel="stylesheet" href="<%=path%>/stylesheets/weui.css"/>
	<link rel="stylesheet" href="<%=path%>/stylesheets/jquery-weui-1.1.0.css"/>
	<link rel="stylesheet" href="<%=path%>/stylesheets/projectcss.css"/>
	<style>
	.luckyStaff{
	
		text-align:center;
	    line-height:30px;
	    font-size:15px;
	    vertical-align:middle;
	    border:1px solid black;  
	}
	.header{
		text-align:center;
	}
	
	</style>
</head>
<body>
	<div class="header">
		<h1 class="weui-footer__fixed-bottom">上海音达科技实业有限公司年终晚会抽奖</h1>
	</div>
<div class="luckyStaff" >
	<h2   id="luckyStaffs">获奖人员名单</h2>
	<br/>
		  <div class="weui-row">
			<div class="weui-col-30" ><h4>奖品类别</h4></div>
			<div class="weui-col-30" ><h4>幸运员工</h4></div>
		  </div>
		  <c:forEach items="${list}" var="draw">
			<div class="weui-row">
			 <div class="weui-col-30" >${draw.drawType}</div>
			  <div class="weui-col-70">${draw.staffName}</div>
			</div>
		</c:forEach>	
</div>
<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
<script src="<%=path%>/javascripts/jquery-weui-1.1.0.js"></script>
<script>
	/* var id=null;
    $(document).ready(function(){
    	 id=window.setInterval(postRequest,10000);
    	
    });
    //向后台定时发送POST请求
    function postRequest(){
    	$.post("getFlagSJ.do",{},function(data){
    			
    		
    	});
    }
    */
   
</script>
</body>
</html>
