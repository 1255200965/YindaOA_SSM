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
	.luckyStaff{
	
		text-align:center;
	    line-height:25px;
	    font-size:13px;
	    vertical-align:middle;
	}
	.luckyStaff2{
	
		text-align:center;
	    line-height:30px;
	    font-size:20px;
	    vertical-align:middle;
	    color:#000000;  
	}
	.header{
		text-align:center;
		color:#FFD700; 
	}
	.header2{
		color:#FFD700; 
	}
	#body{
		background:url("<%=path%>/images/draw01.png") no-repeat;
		width:100%;
		height:auto;
		background-size:cover;
	}
	</style>
</head>
<body id="body">
<div>
  <c:forEach items="${staffMap }" var="staffInfo">
	<div class="show" style="display:none;">${staffInfo.key} 工号：${staffInfo.value}</div>
  </c:forEach> 
</div>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<p class="weui_textarea luckyStaff2"  id="drawType" ></p>

<p class="weui_textarea luckyStaff2"   id="luckyStaff">音达科技<p>
<br/>
<br/>


<a id="btn" class="weui_btn weui_btn_plain_default" style="display:none;" >开始</a>
<div class="luckyStaff"  id="luckyStaffs">
		  <c:forEach items="${luckyList}" var="draw">
			<div class="weui-row">
			  <a></a>
			  <div class="weui-col-45" >${draw.drawType}</div>
			  <div class="weui-col-45">${draw.staffName}(${draw.staffId})</div>
			  <a></a>
			</div>
		 </c:forEach>	
</div>
<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
<script src="<%=path%>/javascripts/jquery-weui.js"></script>
<script>
		//抽奖页面人名转动过程
	var showlen=$('.show').length; //获取人员总数
	var time=null; //初始化计时器
	var id=null;
	var obj=null;
	var staffName=null;
	var staffId = null;
    $(document).ready(function(){
    		//页面加载之后就去请求一次,以获取当前是否在抽奖,以及奖品类别两个信息
    	$.post("getFlagSJ.do",{},function(data){	
    		obj = data;
    		staffName=obj.staffName;
    		staffId=obj.staffId;
    		if(obj.option =="start"){
    			if(obj.drawType != "本次抽奖活动已结束"){
    				clearInterval(time); //终止计时器	
    				time=setInterval(show,0); //开启计时器
    					//设置当前奖品类别
    				$("#drawType").html("当前抽奖:"+obj.drawType);	
    			}else{
    				$("#drawType").html("本次抽奖活动已结束");
    				$("#luckyStaff").html("恭喜以下幸运员工");
    			}
    		}else if(obj.option=="end"){
    			clearInterval(time); //终止计时器
    				//设置下次奖品类别
    			if(obj.drawType != "本次抽奖活动已结束"){
    			 	$("#drawType").html("接下来的抽奖:"+obj.drawType);
    			}else{
    				$("#drawType").html("本次抽奖活动已结束");
    				$("#luckyStaff").html("恭喜以下幸运员工");
    			}
    		}else{
    			$("#drawType").html("接下来的抽奖:"+obj.drawType);
    		}
    	});
    	
    	 id=window.setInterval(postRequest,1000);
    		 
    });
   
    //向后台定时发送POST请求
    function postRequest(){
    	$.post("getFlagSJ.do",{},function(data){ 
    			//如果抽奖开始就触发btn.click()方法
    		obj =data;
    		if(obj.option =="start"){
    		 
    			clearInterval(time); //终止计时器	
    			$("#drawType").html("当前抽奖:"+obj.drawType);
    			time=setInterval(show,0); //开启计时器
    		
    		}else if(obj.option=="end"){
    			clearInterval(time); //终止计时器	
    			$("#drawType").html("接下来的抽奖:"+obj.drawType);
    		  if(staffName != obj.staffName && staffId != obj.staffId){
    			$("#luckyStaff").html("恭喜"+obj.staffName+"("+obj.staffId+")"+"获得"+obj.drawType);
    			$("#luckyStaffs").append("<div class='weui-row'>"
    									+"<a></a>"
    									+"<div class='weui-col-70'>"+obj.drawType+"</div>"
    									+"<div class='weui-col-30' >"+obj.staffName+(obj.staffId)+"</div>"
    									+"<a></a>"
    									+"</div>");
    			staffName=obj.staffName;
    			staffId = obj.staffId;
    		  }
    		}
    	});
    }
	function show(){
		
		var idx=Math.floor(Math.random()*showlen); //生成随机数
		$("#luckyStaff").html($('.show').eq(idx).html());//将当前选中的人的名字显示在下面的框内
		};
</script>
</body>
</html>
