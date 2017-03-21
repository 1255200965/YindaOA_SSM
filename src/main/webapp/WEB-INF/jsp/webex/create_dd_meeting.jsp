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
<link rel="stylesheet" href="<%=path%>/stylesheets/weui.css?v=<%=SystemConfig.version%>" />
<link rel="stylesheet" href="<%=path%>/stylesheets/jquery-weui.css?v=<%=SystemConfig.version%>" />
<link rel="stylesheet" href="<%=path%>/stylesheets/projectcss.css?v=<%=SystemConfig.version%>" />
<script src="<%=path%>/javascripts/jquery-2.1.4.js?v=<%=SystemConfig.version%>"></script>
<script src="<%=path%>/javascripts/jquery-weui.js?v=<%=SystemConfig.version%>"></script>
<script src="<%=path%>/javascripts/jquery.validate.min.js?v=<%=SystemConfig.version%>"></script>

<script type="text/javascript"
	src="http://g.alicdn.com/ilw/ding/0.7.3/scripts/dingtalk.js?v=<%=SystemConfig.version%>"></script>
<title>创建培训会议</title>
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
</style>
<body  id="bb">

<h3 style="text-align:center">您好，欢迎使用音达培训</h3>
	<form id="divform" action="<%=path%>/WebEx/create_dd_meeting.do">
		<div class="weui_cells weui_cells_form ">
 
            
 
    
			<div class="weui_cell">
				<div class="weui_cell_hd">
					<label class="weui_label">会议名称</label>
				</div>
				<div class="weui_cell_bd weui_cell_primary">
					<input class="weui_input" type="text" placeholder=""
						name ="meeting_name" id="meeting_name">
				</div>
			</div>


			<div class="weui_cell">
				<div class="weui_cell_hd">
					<label class="weui_label">会议描述</label>
				</div>
				<div class="weui_cell_bd weui_cell_primary">
					<input class="weui_input" type="text" placeholder=""
						name ="meeting_desc" id="meeting_desc">
				</div>
			</div>


	  <div class="weui_cell">
				<div class="weui_cell_hd">
					<label class="weui_label">会议密码</label>
				</div>
				<div class="weui_cell_bd weui_cell_primary">
					<input class="weui_input" type="number" placeholder=""
						name ="meeting_password" id="meeting_password">
						<input name="session_key" id="session_key" type="hidden">
				</div>
				
			</div>
				<div class="weui_cell">
				<div class="weui_cell_hd">
					<label class="weui_label">会议时间</label>
				</div>
				<div class="weui_cell_bd weui_cell_primary">
					<input class="weui_input"  id='datetime-picker'
						name ="meeting_time" type="text"  readonly>
						
				</div>
			</div>
			 <div class="weui_cell">
				<div class="weui_cell_hd">
					<label class="weui_label">会议人数</label>
				</div>
				<div class="weui_cell_bd weui_cell_primary">
					
						<select class="weui_select" name="meeting_count" id="meeting_count">
								<option value>请选择</option>
								<option value="20">20</option>
								<option value="50">50</option>
								<option value="100">100</option>
							</select>
				</div>
			</div>
			
				  <div class="weui_cell">
				<div class="weui_cell_hd">
					<label class="weui_label">会议时长</label>
				</div>
				<div class="weui_cell_bd weui_cell_primary">
					<!-- <input class="weui_input" type="text" placeholder="单位：分钟"
						name ="meeting_length" id="meeting_length"> -->
							<select class="weui_select" name="meeting_length" id="meeting_length">
								<option value>请选择</option>
								<option value="30">30</option>
								<option value="60">60</option>
								<option value="90">90</option>
								<option value="120">120</option>
							</select>
				</div>
			</div>
     
		

		</div>
		</div>


		</div>

		<div class="weui_cell">

			<div class="weui_cell_bd weui_cell_primary"  style="color:blue" >
				<input href="#" class="weui_btn weui_btn_primary" type="submit" />
				
			</div>
		</div>
		
		
	</form>
	<script>
 
  

 	
 
      $("#datetime-picker").datetimePicker({
        title: '自定义格式',
        yearSplit: '-',
        monthSplit: '-',
        dateSplit: '',
        times: function () {
          return [  // 自定义的时间	
            {
              values: (function () {
                var hours = [];
                for (var i=0; i<24; i++) hours.push(i > 9 ? i : '0'+i);
                return hours;
              })()
            },
            {
              divider: true,  // 这是一个分隔符
              content: ':'
            },
            {
              values: (function () {
                var minutes = [];
                for (var i=0; i<59; i++) minutes.push(i > 9 ? i : '0'+i);
                return minutes;
              })()
            },
            {
              divider: true,  // 这是一个分隔符
              content: ''
            }
          ];
        },
        onChange: function (picker, values, displayValues) {
          console.log(values);
        }
      });

   
  	// 邮政编码验证   
  	jQuery.validator.addMethod("IsChinese", function(value, element) {   
  	    var tel = /^([a-zA-Z0-9]|[._]){4,10}$/;
  	    return this.optional(element) || (tel.test(value));
  	}, "请填写汉字");

    </script> 
    
<script>

$().ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
		
    	var meeting_name = $("#meeting_name").val();
    	var meeting_desc = $("#meeting_desc").val();
    	var meeting_password = $("#meeting_password").val();
    	var meeting_count = $("#meeting_count").val();
    	var meeting_length = $("#meeting_length").val();
    
    	
    	
	  $("#divform").validate({
		  submitHandler : function() {  //验证通过后的执行方法
	            //当前的form通过ajax方式提交（用到jQuery.Form文件）
	          
		  debugger;
		  /*获取当前日期*/
	        var date = new Date();
	        var year = date.getFullYear();
	        var month = date.getMonth()+1;
	        var day = date.getDate();
	        var hh = date.getHours(); //截取小时 
	        var mm = date.getMinutes()+10; //截取分钟
	        if(month<10){
	        	month = "0"+month;
	        }
	        if(day<10){
	        	day = "0"+day;
	        }
	        var nowtime = year+"-"+month+"-"+day+" "+hh+":"+mm;
	        var meeting_time = $("input[name='meeting_time']").val();
	        
	            if(nowtime>meeting_time){
	            	$.alert("会议时间必须为10分钟之后时间段");
	            	return;
	            }
				 $.post("<%=path%>/WebEx/create_dd_meeting.do",$("#divform").serialize(),function(data){
                      
		             
		                if(data == "success"){
		                	
		                	$.post("<%=path%>/WebEx/create_dd_meeting_success.do",function(data){
		                		
		                		$("#bb").html(data);
		                	})
		                }else if(data == "error"){
		                	window.location = "<%=path%>/WebEx/create_dd_meeting_error.do";
		                } else {
		                	window.location = "<%=path%>/WebEx/create_dd_meeting_time_error.do?meeting_name="+data;
	                    }
		             
		         });
	        } ,
		  
	    rules: {
	      meeting_name: "required",
	      meeting_password:"required",
	      meeting_desc: "required",
	      meeting_name: {
	        required: true,
	        minlength: 6,
	        IsChinese: ""
	   
	      },
	      meeting_password: {
	        required: true,
	        minlength: 6,
	      
	      },
	      meeting_desc: {
		        required: true,
		        minlength: 6,
		        IsChinese: ""
		      },
	      meeting_time: {
		        required: true,		      
		      },
		   meeting_length: {
			        required: true,    
			      },			      
		  meeting_count: {
				        required: true,    
				      }
	    
	    },
	   
	   
    
    
	    
	    messages: {
	      meeting_name: {
	        required: "请输入会议名称",
	        minlength: "长度不能小于6,不能含特殊字符"
	      },
	      meeting_password: {
	        required: "请输入密码",
	        minlength: "密码长度不能小于 6"
	      },
	      meeting_desc: {
	        required: "请输入会议描述",
	        minlength: "长度不能小于6,不能含特殊字符",
	       
	      },
	      meeting_length: {
		        required: "请选择会议时长",
		       
		       
		      },
		 meeting_time: {
			        required: "请选择会议时间",
			       
			       
			      },
		meeting_count: {
				     required: "请选择会议人数"
				       
				      }
	      
	     
	    }
	})
	});

</script>

  
</body>
</html>
