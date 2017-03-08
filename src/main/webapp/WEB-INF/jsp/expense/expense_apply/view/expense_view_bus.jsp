<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
<%
	String path = request.getContextPath();/*获得当前项目的根路径 */
%>
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
 <head>
  <link rel="stylesheet" href="<%=path%>/stylesheets/weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/jquery-weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/projectcss.css"/>
   <link rel="stylesheet" href="<%=path%>/stylesheets/expense.css"/>
  <title>大巴票报销详细信息查看</title>
 </head>
 <body >
  <form id="form">
  	<!-- <div class="weui_cells" style="border:none;"> -->
  	     <br/>
  	     <input class="weui_input" type="text" placeholder=""  name="id" value="${expenseApplayBus.id}" hidden>
  		<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary font_title">
      			<label class="weui_label"><b>市/县</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary font_content">
     		<input class="weui_input" type="text" placeholder=""  name="startCity" value="${expenseApplayBus.startCity}" readonly>
   		 </div>
     	</div>	
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary font_title">
      			<label class="weui_label"><b>上车地点</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary font_content">
     		<input class="weui_input" type="text" placeholder=""  name="startAddress" value="${expenseApplayBus.startAddress }" readonly>
   		 </div>
   		 
     	</div>		
  	     <div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary font_title">
      			<label class="weui_label"><b>下车地点</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary font_content">
     		<input class="weui_input" type="text" placeholder=""  name="destination" value="${expenseApplayBus.destination }" readonly>
   		 </div>
   		 
     	</div>
     	<div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary font_title"><label class="weui_label"><b>上车时间</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary font_content">
     		   <input class="weui_input" type="text" placeholder=""  name="beginTime" value="${expenseApplayBus.beginTime }" onfocus="(this.type='date')" readonly>
   		    </div>
  		 </div>
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary font_title">
      			<label class="weui_label"><b>下车时间</b></label>
   			 </div>
    	 <div class="weui_cell_ft weui_cell_primary font_content">
     		<input class="weui_input" type="text" placeholder=""  name="endTime" value="${expenseApplayBus.endTime }" onfocus="(this.type='date')" readonly>
   		 </div>
   		 
     	</div>
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary font_title">
      			<label class="weui_label"><b>金&nbsp;额</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary font_content">
     		<input class="weui_input" type="text" placeholder=""  name="moneyCost" value="${expenseApplayBus.moneyCost }" onchange="checkFormat(this);" readonly>
   		 </div>
   		 
     	</div>
     	<div class="weui_cell"> 
    		<div class="weui_cell_bd weui_cell_primary font_title"><label class="weui_label"><b>用车事由</b></label></div>
    	     <div class="weui_cell_ft weui_cell_primary font_content">
     	        <input class="weui_input" type="text"   name="reason" value="${expenseApplayBus.reason}" readonly>
   		     </div>
  	     </div> 
     	<div class="weui_cell">
    		<div class="weui_cell_bd weui_cell_primary font_title">
      			<label class="weui_label"><b>说&nbsp;明</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary font_content">
     		<input class="weui_input" type="text" placeholder=""  name="detailExplain" value="${expenseApplayBus.detailExplain }" readonly>
   		 </div>
   		 
     	</div>
     	<div class="weui_cell ">
    		<div class="weui_cell_bd weui_cell_primary font_title">
      			<label class="weui_label"><b>审批人顺序</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary font_content">
     		<input class="weui_input" type="text" placeholder=""  name="" value="${expenseApplayBus.approverOrder }" disabled>
   		 </div>
   		 
     	</div>	
     	<div class="weui_cell ">
    		<div class="weui_cell_bd weui_cell_primary font_title">
      			<label class="weui_label"><b>当前审批人</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary font_content">
     		<input class="weui_input" type="text" placeholder=""  name="" value="${expenseApplayBus.approverNow }" disabled>
   		 </div>
   		 
     	</div>	
     	<div class="weui_cell refuse">
    		<div class="weui_cell_bd weui_cell_primary font_title">
      			<label class="weui_label"><b>驳回原因</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary font_content">
     		<input class="weui_input" type="text" placeholder=""  name="" value="${expenseApplayBus.refuseReason }" readonly>
   		 </div>
   		 
     	</div>	
  	     <hr/>
  	    <div class="weui-row">
             <%-- <img src="<%=path%>/upload/${expenseApplayBus.imageUrl}" style="height:10%;width:30%;"/> --%>
                <img src="http://121.40.29.241/YindaOAImageUpload/${expenseApplayBus.imageUrl}" style="width:100px;height:100px" onclick="imageView(this);"/>
                <input class="weui_input" type="text" placeholder=""  name="imageUrl" value="${expenseApplayBus.imageUrl }" hidden/>
  	     </div>
         <p style="color:red;">注:如果是由于图片原因被驳回的报销申请，请删除该报销并重新提交</p>
		<div class="weui-row">
			<div class="weui-col-10"></div>
			<div class="weui-col-40"><a onclick="formSubmit();" class="weui_btn  weui_btn_primary refuse">提交</a></div>
			<div class="weui-col-40"><a href="javascript:history.go(-1);" class="weui_btn  weui_btn_default">返回</a></div>
			<div class="weui-col-10"></div>
		</div>
		<br/>
		<div class="weui-row refuse">
		<div class="weui-col-10"></div>
		<div class="weui-col-80"><a onclick="delete2('${expenseApplayBus.id}');" class="weui_btn  weui_btn_warn">删除</a></div>
		<div class="weui-col-10"></div>
		</div>		
	   
  	 <!-- </div> -->
  	</form>	
  	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
    <script type="text/javascript">
    	var flag="${flag}";
    	$("document").ready(function(){
    		//如果审批状态不是拒绝的话,将重新编辑的功能隐藏
    		if(flag=="hide"){
    			$(".refuse").hide();
    		}else if(flag=="show"){
    		
    			//如果审批状态是拒绝的话,将重新编辑的功能开放
    			$("input").removeAttr("readonly");
    			
    		}
    	});
    	function formSubmit(){
    		$.post("toExpense_bus_save_again.do",$("#form").serialize(),function(data){
    			if(data=="success"){
    				window.history.go(-1);
    			}else{
    				$.alert("当前系统繁忙,请重新提交");
    			}
    		});
    	}
    	function delete2(e){
    		$.post("delete_bus.do",{id:e},function(data){
    			if(data=="success"){
    				$.alert("删除成功");
    				window.history.go(-1);
    			}else{
    				$.alert("系统繁忙,请稍后重试");
    			}
    		});
    	}
    	//金额格式检查
        function checkFormat(e){
        	var s = /^(([1-9]\d*)|\d)(\.\d{1,2})?$/;
        	if(s.test($(e).val())){
        		
        	}else{
        		$.alert("金额必须为数字,请重新填写");
        		$(e).val("");
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
