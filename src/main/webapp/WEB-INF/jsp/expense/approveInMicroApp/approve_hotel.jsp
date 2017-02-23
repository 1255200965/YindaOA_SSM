<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
<%
	String path = request.getContextPath();/*获得当前项目的根路径 */
	
%>
<!-- 钉钉微应用内旅店报销审核界面 -->
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
 <head>
  <link rel="stylesheet" href="<%=path%>/stylesheets/weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/jquery-weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/projectcss.css"/>
  <title>住宿报销审核</title>
 </head>
 <body >
 <form id="form">
  	<!-- <div class="weui_cells" style="border:none;"> -->
  		<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>住宿原因</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary">
     		<span>${expenseApplayHotel.reason }</span>
     		<input class="weui_input" type="text" placeholder=""  name="id" value="${expenseApplayHotel.id }"  readonly style="display:none;">
   		 </div>
     	</div>
     		
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>旅馆名称</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<span>${expenseApplayHotel.hotelName }</span>
   		 </div>
   		 
     	</div>		
  		 <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>住宿日期</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		   <span>${expenseApplayHotel.startTime }</span>
   		    </div>
  		 </div>
  		
  	    <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>离店日期</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		   <span>${expenseApplayHotel.endTime }</span>
   		    </div>
  		 </div>
  			
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>金&nbsp;额</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<span>${expenseApplayHotel.moneyCost }</span>
   		 </div>
   		 
     	</div>
     	
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>天&nbsp;数</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<span>${expenseApplayHotel.daysCost }</span>
   		 </div>
   		 
     	</div>
     		
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>说&nbsp;明</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<span>${expenseApplayHotel.detailExplain}</span>	
   		 </div>
   		 
     	</div>
     	
  	     <hr/>
  	     <div class="weui_row">
     	<img src="http://121.40.29.241/YindaOAImageUpload/${expenseApplayHotel.imageUrl }" style="width:30%;height:10%" style="width:100px;height:100px" onclick="imageView(this);"/>
     	
     	</div>	
  	     <!-- <div class="weui-row">
  	     <div class="weui_uploader_input_wrp">
            <input class="weui_uploader_input" type="file" accept="image/jpg,image/jpeg,image/png,image/gif" multiple="">
  	     </div>
  	     </div> -->
        <div class="weui-row" id="flag">
			<div class="weui-col-10"></div>
			<div class="weui-col-40" ><a onclick="approve_hotel_update('agree');" class="weui_btn  weui_btn_primary" >通过</a></div>
			<div class="weui-col-40" ><a onclick="approve_hotel_update('disagree');" class="weui_btn   weui_btn_default" >驳回</a></div>
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
     function approve_hotel_update(data2){
    	if(data2 == 'disagree'){
    		$.prompt({
				  title: '',
				  text: '请输入驳回原因',
				  input: '',
				  empty: false, // 是否允许为空
				  onOK: function (input) {
				    //点击确认
					  $.post("approve_hotel_update.do",{"result":data2,"id":$("input[name='id']").val(),refuseReason:input},function(data){
				    		 if(data ==1 ){
				    			 $.alert("操作成功");
				    			 $("#flag").hide();
				    			 window.history.back(-1);
				    		 }else if(data == 0){
				    			 $.alert("系统繁忙,请稍后重试");
				    		 }
				    	 });
				    	
				  },
				  onCancel: function () {
				    //点击取消
				  }
				});
    	}else{
    		//点击确认
			  $.post("approve_hotel_update.do",{"result":data2,"id":$("input[name='id']").val(),refuseReason:""},function(data){
		    		 if(data ==1 ){
		    			 $.alert("操作成功");
		    			 $("#flag").hide();
		    			 window.history.back(-1);
		    		 }else if(data == 0){
		    			 $.alert("系统繁忙,请稍后重试");
		    		 }
		    	 });
    	}
    	
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
