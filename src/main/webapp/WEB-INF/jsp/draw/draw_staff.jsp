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
	    line-height:150px;
	    font-size:15px;
	    vertical-align:middle;
	    color:blue;  
	    border:1px solid black;  
	}
	.header{
		text-align:center;
	}
	</style>
</head>
<body>
<div>
  <c:forEach items="${staffInfoList }" var="staffInfo">
	<div class="show" style="display:none;">${staffInfo.name} 工号：${staffInfo.staffId}</div>
  </c:forEach> 
</div>

<br/>


	<div class="header">
		<h2 class="weui-footer__fixed-bottom">上海音达科技实业有限公司</h2>
	</div>
<textarea class="weui_textarea luckyStaff"  rows="1" id="luckyStaff" readonly>音达科技</textarea>
<br/>
<a id="btn" class="weui_btn weui_btn_plain_default" style="display:none;" >开始</a>
<div class="luckyStaff" >
	<h2 id="luckyStaff">抽奖说明</h2>
	<h4 id="luckyStaff">因本次年终抽奖活动参与人数较多,如遇页面卡顿,可点击如下链接直接跳入中奖人员名单展示界面直接查看当前中奖信息</h4>
	<a href="<%=path%>/toDraw_getList.do">点我跳转</a>
</div>
<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
<script src="<%=path%>/javascripts/jquery-weui-1.1.0.js"></script>
<script>
		//抽奖页面人名转动过程
	var showlen=$('.show').length; //获取人员总数
	var time=null; //初始化计时器
	var id=null;
    $(document).ready(function(){
    	 id=window.setInterval(postRequest,1000);
    	
    });
    //向后台定时发送POST请求
    function postRequest(){
    	$.post("getFlagSJ.do",{},function(data){
    			//如果抽奖开始就触发btn.click()方法
    		var obj =data;
    		if(obj.option =="start"){
    			clearInterval(time); //终止计时器	
    			time=setInterval(show,0); //开启计时器
    		}else if(obj.option=="end"){
    			clearInterval(time); //终止计时器	
    			$("#luckyStaff").html("恭喜"+obj.result+"获得"+obj.drawType);
    		}
    	});
    }
	function show(){
		
		var idx=Math.floor(Math.random()*showlen); //生成随机数
		$("#luckyStaff").html($('.show').eq(idx).html());//将当前选中的人的名字显示在下面的框内
		}
</script>
</body>
</html>
