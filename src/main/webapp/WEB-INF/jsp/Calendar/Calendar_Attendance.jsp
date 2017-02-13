<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
<%
	String path = request.getContextPath();/*获得当前项目的根路径 */
%>
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<head>


<link href='<%=path%>/stylesheets/fullcalendar.css' rel='stylesheet' />
<link href='<%=path%>/stylesheets/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='<%=path%>/javascripts/jquery-1.9.1.min.js'></script>
<script src='<%=path%>/javascripts/jquery-ui-1.10.2.custom.min.js'></script>
<script src='<%=path%>/javascripts/fullcalendar.min.js'></script>
<title>日历</title>
</head>
<style>

	body {
		margin: 0;
		text-align: center;
		font-size: 40px;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		}
		
	

	#calendar {
		width: 100%;
		margin: 0 auto;
		}

</style>
<body>

<div id='calendar'></div>
	
</body>
<script>


$(document).ready(function() {

   
    	 
    	  $('#calendar').fullCalendar({
    			
    			editable: true,
    			
    			month:"${month}",
    			eventDrop: function(event, delta) {
    				
    			},
    			
    			loading: function(bool) {
    				if (bool) $('#loading').show();
    				else $('#loading').hide();
    			},	
    			
    			events:function(start, end, callback){
   				 var d =$('#calendar').fullCalendar('getDate');

					//var d2= d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate();
					var s = d.getMonth() + 1;
					//if (s < 10) s = '0'+s;
					var d2= d.getFullYear() + '-' + (s) ;
 				
 				 
 				 $.post("<%=path%>/Calendar/select_BY_Attendance.do",{"userid":"${userid}","date": d2 },function(data){
 					 	
 				
 					 callback(data); 
 					 
  				 });   				 
 				 
 			    } 
    			
    		});
 
      
      
      
	
	
});



</script>

</html>
