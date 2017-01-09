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
	<link rel="stylesheet" href="<%=path%>/stylesheets/jquery-weui.css"/>
	<link rel="stylesheet" href="<%=path%>/stylesheets/projectcss.css"/>
	<style>
	#luckyStaff{
	
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
		<h1 class="weui-footer__fixed-bottom">上海音达科技实业有限公司</h1>
	</div>
 <select class="weui_select" name="drawType" id="drawType">
        <option selected="" value="0">请选择奖品类别</option>
        <option value="一等奖">一等奖</option>
        <option value="二等奖">二等奖</option>
        <option value="三等奖">三等奖</option>
        <option value="阳光普照奖">阳光普照奖</option>
 </select>	
<textarea class="weui_textarea"  rows="1" id="luckyStaff">音达科技</textarea>
<br/>
<a id="btn" class="weui_btn weui_btn_plain_default">开始</a>


<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
<script src="<%=path%>/javascripts/jquery-weui.js"></script>
<script>
	var showlen=$('.show').length; //获取人员总数
	var time=null; //初始化计时器
	$('#btn').click(function(){
	 if($("#drawType").val()==0){
		 $.alert("请选择奖品类别");
	 }else{	
		var flag=$(this).html();
		flag=flag=='开始'?'停止':'开始'; //交换按钮上的内容
		$(this).html(flag);
		switch(flag)
		{
		case '停止': //这里是开始作抽奖
	 		//向后台传递抽奖开始的消息
			$.post("getMessageMJ.do",{"option":"start","drawType":$("#drawType").val()});
			getIndex(0); 
		break;
		case '开始': //这里是停止循环
			getIndex(1);
			$.post("getMessageMJ.do",{"option":"end","result":$("#luckyStaff").html(),"drawType":$("#drawType").val()});
			$('#luckyStaff').html($("#luckyStaff").html()); //汇报结果
		break;
		}
	 }
	});
	function getIndex(mark)
		{
			if(mark==1)
		{
			clearInterval(time); //终止计时器
		}
		else
		{
			time=setInterval(show,0); //开启计时器
		}
		}
	function show(){
		
		var idx=Math.floor(Math.random()*showlen); //生成随机数
		$("#luckyStaff").html($('.show').eq(idx).html());//将当前选中的人的名字显示在下面的框内
		}
</script>
</body>
</html>
