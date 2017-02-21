<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
<%
	String path = request.getContextPath();/*获得当前项目的根路径 */
	
%>
<!-- 钉钉微应用内大巴报销审核界面 -->
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
 <head>
  <link rel="stylesheet" href="<%=path%>/stylesheets/weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/jquery-weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/projectcss.css"/>
  <title>大巴车报销审批</title>
 </head>
 <body >
  <form id="form">
  	<!-- <div class="weui_cells" style="border:none;"> -->
  	     <br/>
  	     
  		<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>市/县</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<span>${expenseApplayBus.startCity}</span>
     		<input class="weui_input" type="text" placeholder=""  name="id" value="${expenseApplayBus.id}" readonly style="display:none;">
   		 </div>
     	</div>	
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>上车地址</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<span>${expenseApplayBus.startAddress }</span>
   		 </div>
   		 
     	</div>		
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>下车地址</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<span>${expenseApplayBus.destination }</span>
   		 </div>
   		 
     	</div>
  		 
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>下车时间</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<p>${expenseApplayBus.endTime }</p>
   		 </div>
   		 
     	</div>
     	 <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>上车时间</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		   <span>${expenseApplayBus.beginTime }</span>
   		    </div>
  		 </div>
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>金&nbsp;额</b></label>
   			 </div>
    	   <div class="weui_cell_ft weui_cell_primary">
     		<span>${expenseApplayBus.moneyCost }</span>
   		   </div> 
     	</div>
     	<div class="weui_cell"> 
    		<div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>用车事由</b></label></div>
    	     <div class="weui_cell_ft weui_cell_primary">
     	        <span>${expenseApplayBus.reason}</span>
   		     </div>
  	     </div> 
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>说&nbsp;明</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<span>${expenseApplayBus.detailExplain }</span>
   		 </div>
   		 
     	</div>
     	<div class="weui_row">
     	<img src="http://121.40.29.241/YindaOAImageUpload/${expenseApplayBus.imageUrl }" style="width:100px;height:100px" onclick="imageView(this);"/>
     	</div>	
  	     <hr/>
  	    <%--  <div class="weui-row">
  	     <div class="weui_uploader_input_wrp">
             <img src="${expenseApplayBus.detailExplain }"/>
  	     </div>
  	     </div> --%>
        <div class="weui-row" id="flag">
			<div class="weui-col-10"></div>
			<div class="weui-col-40" ><a onclick="to_approve_bus_update('agree');" class="weui_btn  weui_btn_primary">通过</a></div>
			<div class="weui-col-40" ><a onclick="to_approve_bus_update('disagree');" class="weui_btn  weui_btn_default">驳回</a></div>
			<div class="weui-col-10"></div>
	    </div> 
  	 <!-- </div> -->
  	</form>	
  	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
    <script type="text/javascript">
    var flag="${flag}";
    $(document).ready(function(){
    	if(flag=="hide"){
    		$("#flag").hide();
    	}
    });
    function to_approve_bus_update(data2){
     $.post("to_approve_bus_update.do",{"id":$("input[name='id']").val(),"result":data2},function(data){
    	 if(data==1){
    		 $.alert("操作成功");
    		 $("#flag").hide();
    		 window.history.back(-1);
    	 }else if(data == 0){
    		 $.alert("系统繁忙,请稍后重试");
    	 }
     });
    }
    //图片放大缩小
    function imageView(e){
    	if($(e).css("width")=="100px"){
    		$(e).css("width","300px");
    		$(e).css("height","300px");
    	}else if($(e).css("width")=="300px"){
    		$(e).css("width","100px");
    		$(e).css("height","100px");
    	}
    }
    </script>
 </body> 
</html>
