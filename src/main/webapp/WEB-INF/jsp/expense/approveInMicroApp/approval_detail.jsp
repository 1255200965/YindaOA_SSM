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
  <title>周报销明细</title>
  <style>
  	.header{
  		background-color:#E0FFFF;
  	}
  </style>
 </head>
 <body >
 <body >
 <div class="weui-row">
  		<button type="button" style="background-color:#32CD32;" onclick="selectAll();" id="selectAll">全选</button>
  		<div class="weui-col-40" style="overflow: hidden;"><b>姓名:${approvalStaff.staffName }</b></div>
  		<%-- <div class="weui-col-20" style="overflow: hidden;"><b>工号:${approvalStaff.staffId}</b></div> --%>
  		<div class="weui-col-40" style="overflow: hidden;"><b>总金额:${approvalStaff.cost}</b></div>
  		<a></a>
  		<!-- <a></a> -->
  </div>
  <div id="bus">
  <div class="header"  ><b>大巴</b></div>
  	<div class="weui-row header">
  		<a></a>
  		<!-- <button type="button"  onclick="selectAll();" id="selectAll">全选</button> -->
  		<a></a>
  		<div class="weui-col-20" style="overflow: hidden;"><b>报销人</b></div>
  		<div class="weui-col-20" style="overflow: hidden;"><b>报销金额</b></div>
  		<div class="weui-col-20" style="overflow: hidden;"><b>提交日期</b></div>
  		<a><b style="color:#696969;">操作</b></a>
  		<a></a>
  		<!-- <a></a> -->
    </div>
    <hr/>
    
 	<div data-bind="foreach:ShowListBus">
    <div class="weui-row" >
 		 <input type="checkbox" name="busIds" data-bind="textinput:id" class="ids"/> 
  		<div class="weui-col-20" style="overflow: hidden;" data-bind="text:staffName"></div>
  		 <div class="weui-col-20" style="overflow: hidden;" data-bind="text:moneyCost"></div> 
  		<div class="weui-col-20" style="overflow: hidden;" data-bind="text:submitTime"></div>
  		<input type="button" style="background-color:#32CD32;" data-bind="click:$root.approvalOptionBus" value="审批">
  		<a></a>
    </div>
    <br/>
    </div>
   </div>
   <div id="train">
   <div class="header" ><b>火车</b></div>
   <div class="weui-row header">
   		<a></a>
  		<!-- <button type="button"  onclick="selectAll();" id="selectAll">全选</button> -->
  		<div class="weui-col-20" style="overflow: hidden;"><b>报销人</b></div>
  		<div class="weui-col-20" style="overflow: hidden;"><b>报销金额</b></div>
  		<div class="weui-col-20" style="overflow: hidden;"><b>提交日期</b></div>
  		<a><b style="color:#696969;">操作</b></a>
  		<a></a>
  		<!-- <a></a> -->
    </div>
    <div data-bind="foreach:ShowListTrain">
    <div class="weui-row" >
 		<input type="checkbox" name="trainIds" data-bind="textinput:id" class="ids"/> 
  		<div class="weui-col-20" style="overflow: hidden;" data-bind="text:staffName"></div>
  		 <div class="weui-col-20" style="overflow: hidden;" data-bind="text:moneyCost"></div> 
  		 <div class="weui-col-20" style="overflow: hidden;" data-bind="text:submitTime"></div>
  		<input type="button" style="background-color:#32CD32;" data-bind="click:$root.approvalOptionTrain" value="审批">
  		<a></a>
    </div>
    <br/>
    </div>
    </div>
   <div id="hotel">
   <div class="header" ><b>旅店</b></div>
   <div class="weui-row header">
   		<a></a>
  		<!-- <button type="button"  onclick="selectAll();" id="selectAll">全选</button> -->
  		<div class="weui-col-20" style="overflow: hidden;"><b>报销人</b></div>
  		<div class="weui-col-20" style="overflow: hidden;"><b>报销金额</b></div>
  		<div class="weui-col-20" style="overflow: hidden;"><b>提交日期</b></div>
  		<a><b style="color:#696969;">操作</b></a>
  		<a></a>
  		<!-- <a></a> -->
    </div>
    <div data-bind="foreach:ShowListHotel">
     
    <div class="weui-row" >
 		<input type="checkbox" name="hotelIds" data-bind="textinput:id" class="ids"/> 
  		<div class="weui-col-20" style="overflow: hidden;" data-bind="text:staffName"></div>
  		 <div class="weui-col-20" style="overflow: hidden;" data-bind="text:moneyCost"></div> 
  		<div class="weui-col-20" style="overflow: hidden;" data-bind="text:submitTime"></div> 
  		<input type="button" style="background-color:#32CD32;" data-bind="click:$root.approvalOptionHotel" value="审批">
  		<a></a>
    </div>
    <br/>
    </div>
    </div>
    <div id="subWay">
   <div class="header" ><b>公交地铁</b></div>
     <div class="weui-row header">
     	<a></a>
  		<!-- <button type="button"  onclick="selectAll();" id="selectAll">全选</button> -->
  		<div class="weui-col-20" style="overflow: hidden;"><b>报销人</b></div>
  		<div class="weui-col-20" style="overflow: hidden;"><b>报销金额</b></div>
  		<div class="weui-col-20" style="overflow: hidden;"><b>提交日期</b></div>
  		<a><b style="color:#696969;">操作</b></a>
  		<a></a>
  		<!-- <a></a> -->
    </div>
    <div data-bind="foreach:ShowListSubway">
    <div class="weui-row" >
 		<input type="checkbox" name="subwayIds" data-bind="textinput:id" class="ids"/> 
  		<div class="weui-col-20" style="overflow: hidden;" data-bind="text:askStaffName"></div>
  		 <div class="weui-col-20" style="overflow: hidden;" data-bind="text:askMoney"></div> 
  		<div class="weui-col-20" style="overflow: hidden;" data-bind="text:submitTime"></div>
  		<input type="button" style="background-color:#32CD32;" data-bind="click:$root.approvalOptionSubway" value="审批">
  		<a></a>
    </div>
    <br/>
    </div>
   </div>
    
    <div><a onclick="approvalOptions('${type}','agree');" class="weui_btn weui_btn_primary" >一键审批</a></div>
    <br/>
    <div><a href="javascript:history.go(-1);" class="weui_btn weui_btn_plain_default" >返回</a></div>
    <script src="<%=path%>/javascripts//knockout-3.4.0rc.js"></script>
    <script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
    <script>
    $("document").ready(function(){
    	var ViewModel = function(){
    		var self = this;
    		self.ShowListBus=ko.observableArray();
    		self.ShowListTrain=ko.observableArray();
    		self.ShowListHotel=ko.observableArray();
    		self.ShowListSubway=ko.observableArray();
    		$(function () {
                self.getBus();
                self.getTrain();
                self.getHotel();
                self.getSubway();
            });
    		self.getBus = function(){
    			$.post("getApproval.do",{staffId:"${approvalStaff.staffId}",type:"bus"},function(data){
    				result = eval(data);
                    
                    //清空viewmodel
                    for (var i = 0; i < result.length; i++) {
                        self.ShowListBus.push(result[i]);
                        //加入每行题目信息
                    }
    			});
    			
    		}
    		self.getTrain = function(){
    			$.post("getApproval.do",{staffId:"${approvalStaff.staffId}",type:"train"},function(data){
    				result = eval(data);
                    
                    //清空viewmodel
                    for (var i = 0; i < result.length; i++) {
                        self.ShowListTrain.push(result[i]);
                        //加入每行题目信息
                    }
    			});
    		}
    		self.getSubway = function(){
    			$.post("getApproval.do",{staffId:"${approvalStaff.staffId}",type:"subway"},function(data){
    				result = eval(data);
                    
                    //清空viewmodel
                    for (var i = 0; i < result.length; i++) {
                        self.ShowListSubway.push(result[i]);
                        //加入每行题目信息
                    }
    			});
    		}
    		self.getHotel = function(){
    			$.post("getApproval.do",{staffId:"${approvalStaff.staffId}",type:"hotel"},function(data){
    				result = eval(data);
                    
                    //清空viewmodel
                    for (var i = 0; i < result.length; i++) {
                    	self.ShowListHotel.push(result[i]);
                        //加入每行题目信息
                    }
    			});
    			
    		}
    		self.approvalOptionBus = function(item){
    			window.location.href="go_approve_bus.do?id="+item.id;
    		}
    		self.approvalOptionTrain = function(item){
    			window.location.href="go_approve_train.do?id="+item.id;
    		}
			self.approvalOptionHotel = function(item){
				window.location.href="go_approve_hotel.do?id="+item.id;
    		}
			self.approvalOptionSubway = function(item){
				window.location.href="go_approve_subway.do?id="+item.id;
			}
    		
    	};
    	ko.applyBindings(new ViewModel);
    });
    
    //批量审批
   function approvalOptions(){
    	 var busStr=getValues("busIds"); 
    	 var trainStr=getValues("trainIds");
    	 var hotelStr=getValues("hotelIds");
    	 var subwayStr=getValues("subwayIds");  
    	var result="agree";
    			//批量火车票审批
		   if(trainStr ==""){
		   }else{
			$.post("approve_train_updates.do",{ids:trainStr,result:result},function(data){
			}); 
		   }
		 		//批量大巴审批
			 if(busStr==""){
				  
			   }else{
				$.post("approve_bus_updates.do",{ids:busStr,result:result},function(data){
					
			     }); 
			   }
		
				//旅店批量审批
			if(hotelStr==""){
				   
			   }else{
				$.post("approve_hotel_updates.do",{ids:hotelStr,result:result},function(data){
					
				}); 
			   }
				//地铁公交批量审批
			if(subwayStr==""){
				   
			   }else{
				$.post("approve_subway_updates.do",{ids:subwayStr,result:result},function(data){
					
				}); 
			   }
			 window.location.reload(); 
    }
   
   //获取复选框的值
  function getValues(data){
	  var checkboxes=document.getElementsByName(data);
	  var str="";
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
		   var checkboxes=document.getElementsByClassName("ids");
	  		for(var i=0;i<checkboxes.length;i++){
		 		 checkboxes[i].checked=true;  
	 		 } 
	  		$("#selectAll").text("清空");
	   }
	   if(text =="清空"){ 
		   var checkboxes=document.getElementsByClassName("ids");
	  		for(var i=0;i<checkboxes.length;i++){
	  			checkboxes[i].checked=false;
	 		 } 
	  		$("#selectAll").text("全选");
	   }
  }  
    </script>
 </body> 
    <script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
     <script type="text/javascript" src="http://g.alicdn.com/ilw/ding/0.7.3/scripts/dingtalk.js"></script>
 </body> 
</html>
