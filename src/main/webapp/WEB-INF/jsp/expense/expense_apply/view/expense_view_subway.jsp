<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
<%
	String path = request.getContextPath();/*获得当前项目的根路径 */
	String data= request.getParameter("data");
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
  <title>地铁公交报销详情查看</title>
 </head>
 <body >
  <form id="form" >	
  <input class="weui_input" type="text" placeholder=""  name="id" value="${subwayApply.id }"  style="display:none;">
  		 <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>月份</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		    <input class="weui_input" type="text" placeholder=""  name="askMonth" value="${subwayApply.askMonth }" disabled>
   		    </div>
  		 </div>
  		
  	     <div class="weui_cell ">
  		    <div class="weui_cell_bd weui_cell_primary"><label class="weui_label"><b>金额</b></label></div>
    		<div class="weui_cell_ft weui_cell_primary">
     		  <input class="weui_input" type="text" placeholder=""  name="askMoney" value="${subwayApply.askMoney}" onchange="checkFormat(this);"readonly>
   		    </div>
  		 </div>
  		 <div class="weui_cell ">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>审批顺序</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""  name="" value="${subwayApply.approverOrder }" disabled>
   		 </div>
   		 
     	</div>	
     	<div class="weui_cell ">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>当前审批人</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""  name="" value="${subwayApply.approverNow }" disabled>
   		 </div>
     	</div>	
     	<div class="weui_cell refuse">
    		<div class="weui_cell_bd weui_cell_primary">
      			<label class="weui_label"><b>驳回原因</b></label>
   			 </div>
    	<div class="weui_cell_ft weui_cell_primary">
     		<input class="weui_input" type="text" placeholder=""  name="" value="${expenseApplay.refuseReason }" readonly>
   		 </div>
   		 
     	</div>	
     	<br/>
       <div class="weui-row">
			<div class="weui-col-10"></div>
			<div class="weui-col-40"><a onclick="formSubmit();" class="weui_btn  weui_btn_primary refuse">提交</a></div>
			<div class="weui-col-40"><a href="javascript:history.go(-1);" class="weui_btn  weui_btn_default">返回</a></div>
			<div class="weui-col-10"></div>
		</div>
		<br/>
		<div class="weui-row refuse">
		<div class="weui-col-10"></div>
		<div class="weui-col-80"><a onclick="delete2('${subwayApply.id}');" class="weui_btn  weui_btn_warn">删除</a></div>
		<div class="weui-col-10"></div>
		</div>		
  	 <!-- </div> -->
  	</form>	
  	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
    <script>
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
		$.post("toExpense_subway_save_again.do",$("#form").serialize(),function(data){
			if(data=="success"){
				window.history.go(-1);
			}else{
				$.alert("当前系统繁忙,请重新提交");
			}
		});
	}
	function delete2(e){
		$.post("delete_subway.do",{id:e},function(data){
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
    </script>
 </body> 
</html>
