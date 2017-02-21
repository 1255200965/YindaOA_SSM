<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
<%
	String path = request.getContextPath();/*获得当前项目的根路径 */
%>

<!-- 页面复用大巴、火车、旅店的待审批报销信息都在该页面做列表展示 -->
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
 <head>
  <link rel="stylesheet" href="<%=path%>/stylesheets/weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/jquery-weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/projectcss.css"/>
  <title>周报销汇总</title>
 </head>
 <body >
  	<div class="weui-row">
  		<button type="button" style="background-color:#32CD32;" onclick="selectAll();" id="selectAll">全选</button>
  		<div class="weui-col-20" style="overflow: hidden;"><b>报销人</b></div>
  		<div class="weui-col-20" style="overflow: hidden;"><b>总金额</b></div> 
  		<!-- <div class="weui-col-20" style="overflow: hidden;"><b>申请周次</b></div> -->
  		<a><b style="color:#696969;">操作</b></a>
  		<a></a>
  		<!-- <a></a> -->
    </div>
    <br/>
    <div data-bind="foreach:ShowList">
    <div class="weui-row" >
 		<input type="checkbox" name="ids" data-bind="textinput:staffId"/> 
  		<div class="weui-col-20" style="overflow: hidden;" data-bind="text:staffName"></div>
  		 <div class="weui-col-20" style="overflow: hidden;" data-bind="text:cost"></div> 
  		<!-- <div class="weui-col-20" style="overflow: hidden;" data-bind="text:sumTime"></div> -->
  		<input type="button" style="background-color:#32CD32;" data-bind="click:$root.approvalOption" value="明细">
  		<a></a>
    </div>
    <br/>
    </div>
    <div><a onclick="approvalOptions('agree');" class="weui_btn weui_btn_primary" >一键审批</a></div>
    <br/>
    <div><a href="javascript:history.go(-1);" class="weui_btn weui_btn_plain_default" >返回</a></div>
    <script src="<%=path%>/javascripts//knockout-3.4.0rc.js"></script>
    <script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
    <script type="text/javascript">  
    $("document").ready(function(){
    	var ViewModel = function(){
    		var self = this;
    		self.ShowList=ko.observableArray();
    		$(function () {
                self.getStaffs();
            });
    		self.getStaffs = function(){
    			$.ajax({
                   // data:JSON.stringify(new UserModel(depddid,null,null,null)),
                    type:"post",
                    headers: { 'Content-Type': 'application/json' },
                    dataType: 'json',
                    url:"<%=path%>/getStaffs.do",
                    error:function(data){
                        alert("出错了！！:"+data.msg);
                    },
                    success:function(data){
                        result = eval(data);
                        
                        //清空viewmodel
                        for (var i = 0; i < result.length; i++) {
                            self.ShowList.push(result[i]);
                            //加入每行题目信息
                        }
                    }
                });
    		}
    		
    		self.approvalOption = function(item){
    			
                window.location.href="goApprovalDetail.do?staffId="+item.staffId+"&staffName="+item.staffName+"&cost="+item.cost;
            };
    		
    	};
    	ko.applyBindings(new ViewModel);
    });
  
   //获取复选框的值
  function getValues(){
	  var checkboxes=document.getElementsByName("ids");
	  var str = "";
	  for(var i=0;i<checkboxes.length;i++){
		  if(checkboxes[i].checked){
			 if(str != ""){
			 str +=","+ checkboxes[i].value;
			 }else{
				 str += checkboxes[i].value;
			 }
		  }
	  }
	  return str;
  }  
   //全选
  function selectAll(){
	   var text=$("#selectAll").text();
	   if(text == "全选"){
		   var checkboxes=document.getElementsByName("ids");
	  		for(var i=0;i<checkboxes.length;i++){
		 		 checkboxes[i].checked=true;  
	 		 } 
	  		$("#selectAll").text("清空");
	   }
	   if(text =="清空"){ 
		   var checkboxes=document.getElementsByName("ids");
	  		for(var i=0;i<checkboxes.length;i++){
	  			checkboxes[i].checked=false;
	 		 } 
	  		$("#selectAll").text("全选");
	   }
  }  
	//获取复选框的值
  function getValues(){
	  var checkboxes=document.getElementsByName("ids");
	  var str = "";
	  for(var i=0;i<checkboxes.length;i++){
		  if(checkboxes[i].checked){
			 if(str != ""){
			 str +=","+ checkboxes[i].value;
			 }else{
				 str += checkboxes[i].value;
			 }
		  }
	  }
	  return str;
  }  
	//审批
  function approvalOptions(data){
	  var str=getValues();
	  if(str==""){
		   alert("请选择一键审批报销数据");
	  }else{
		  $.post("approves.do",{type:data,ids:str},function(data){
			  if(data=="success"){
				  window.location.reload();
			  }else{
				  $.alert("系统繁忙,请稍后重试");
				  window.location.reload();
			  }
		  });
	  }
  }
		
	
    </script>
 </body> 
</html>
