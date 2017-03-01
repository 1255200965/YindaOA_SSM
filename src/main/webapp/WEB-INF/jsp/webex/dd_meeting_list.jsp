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
	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
   <link rel="stylesheet" href="<%=path%>/stylesheets/weui.css"/>
   <link rel="stylesheet" href="<%=path%>/stylesheets/jquery-weui.css"/>
   <link rel="stylesheet" href="<%=path%>/stylesheets/projectcss.css"/>
	
	

<title>音达会议列表</title>
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
<h3 style="text-align:center">音达会议列表</h3>
<c:forEach items="${webexList}" var="list" >

		<div class="weui_cells weui_cells_form meeting" style ="font-size:10px;">
			<div class="weui_cell" style ="font-size:10px;">
				<div class="weui_cell_hd">
					<label class="weui_label" >会议名称</label>
				</div>
				<div class="weui_cell_bd weui_cell_primary" style ="font-size:10px;">
					${list.meetingName}
					<input type="hidden" name="id" value="${list.id}"/>
					<input type="hidden" name="session_key" value="${list.sessionKey}"/>
					<input type="hidden" name="meeting_name" value="${list.meetingName}"/>
					<input type="hidden" name="meeting_password" value="${list.meetingPassword}"/>
					<input type="hidden" name="meeting_time" value="${list.meetingTime}"/>
				</div>
				<div class="weui_cell_hd"style ="font-size:10px";>
					<label class="weui_label" >会议时间：</label>
				</div>
				<div class="weui_cell_bd weui_cell_primary" style ="font-size:10px;">
					${list.meetingTime}
				</div>
				
			</div>
				<div class="weui_cell">
				<div class="weui_cell_hd" style ="font-size:10px;">
					<label class="weui_label">会议描述</label>
				</div>
				<div class="weui_cell_bd weui_cell_primary" style ="font-size:10px;">
					${list.meetingDesc}
				</div>
				<a  class="weui_btn weui_btn_primary apply_meeting" style="background:#2789d6; font-size:10px;">申请加入</a>				
			    </div>
			<div class="weui_cell">
				<!-- <div class="weui_cell_hd" style ="font-size:10px;">
					<label class="weui_label">所需积分：</label>
				</div>
				<div class="weui_cell_bd weui_cell_primary" style ="font-size:10px;">
					 
				</div> -->
				<div class="weui_cell_hd" style ="font-size:10px;">
					<label class="weui_label">已报名人数：</label>
				</div>
				<div class="weui_cell_bd weui_cell_primary" style ="font-size:10px;">
					未知
				</div>
			</div>
	</div>
</c:forEach>	
	
	
	<script>
    /** 页面下拉刷新**/
    $(document.body).pullToRefresh();
    $(document.body).on("pull-to-refresh", function() {
        window.location.reload();
        $(document.body).pullToRefreshDone();
        
        
        
    });
  

 	
   $('.apply_meeting').click(
        function(){
            
          /*  $.confirm("当前操作需要消耗您的积分，您确定么？积分不可退！", function() { */
  //点击确认后的回调函数
    //this表示当前被点击元素，但是此时我们当做dom对象
            
            var tr = $(this).parent().parent();
            //alert($(this).html())
            //$(this) 表示当前被点击元素，但是此时我们当做jquery对象
            // $.alert(session_key.html());
            var id = tr.find("input[name='id']").val();  
            //alert(id);
            var session_key = tr.find("input[name='session_key']").val();           
            var meeting_name = tr.find("input[name='meeting_name']").val();
            var meeting_time = tr.find("input[name='meeting_time']").val();
            var meeting_password = tr.find("input[name='meeting_password']").val();
            
            $.prompt({
            	  title: '邮箱',
            	  text: 'webex邮箱一致',
            	  input: '',
            	  empty: false, // 是否允许为空
            	  onOK: function (input) {
            		  
            	  if(input.indexOf("com")<=0||input.indexOf("@")<=0){
            		  $.alert("您输入的不是一个邮箱账号，请重新输入！");
            		  return;
            	  }
            	       //点击确认
            	      
            		  window.location = "<%=path%>/WebEx/add_dd_meeting.do?session_key="+session_key+"&meeting_name="+meeting_name+"&meeting_time="+meeting_time
                      +"&meeting_password="+meeting_password+"&id="+id+"&user_email="+input;
                      
                      
            	  },
            	  onCancel: function () {
            	    //点击取消
            	  }
            	});
           
            
            
             }
            
           
          
      
      );
    
    </script>



  
</body>
</html>
