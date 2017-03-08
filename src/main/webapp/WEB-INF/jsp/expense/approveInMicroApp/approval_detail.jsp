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
   <link rel="stylesheet" href="<%=path%>/stylesheets/expense.css"/>
  <title>月报销明细</title>
  <style>
  	
  </style>
 </head>
 <body >
 <body >
 <div class="weui-row table-header">
  		<button type="button" style="background-color:#32CD32;" onclick="selectAll();" id="selectAll">全选</button>
  		<div class="weui-col-40 font_title" style="overflow: hidden;" ><b>报销人:${approvalStaff.staffName }</b></div>
  		<%-- <div class="weui-col-20" style="overflow: hidden;"><b>工号:${approvalStaff.staffId}</b></div> --%>
  		<div class="weui-col-40 font_title" style="overflow: hidden;"><b>总金额:${approvalStaff.cost}</b></div>
  		<a></a>
  		<!-- <a></a> -->
  </div>
  <br/>
  <div id="bus">
  
  	<div class="weui-row header table-header">
  		<a></a>
  		<!-- <button type="button"  onclick="selectAll();" id="selectAll">全选</button> -->
  		<!-- <div class="weui-col-20" style="overflow: hidden;"><b>报销人</b></div> -->
  		<div class="weui-col-15 font_title" style="overflow: hidden;"><b>金额</b></div>
  		<div class="weui-col-20 font_title" style="overflow: hidden;"><b>日期</b></div>
  		<div class="weui-col-20 font_title" style="overflow: hidden;"><b>类别</b></div>
  		<a><b style="color:#696969;">操作</b></a>
  		<a></a>
  		<!-- <a></a> -->
    </div>
    <hr/>
    
 	<div data-bind="foreach:ShowListBus ">
    <div class="weui-row font_content" >
 		 <input type="checkbox" name="busIds" data-bind="textinput:id" class="ids"/> 
  		 <div class="weui-col-15" style="overflow: hidden;" data-bind="text:moneyCost"></div> 
  		<div class="weui-col-20" style="overflow: hidden;" data-bind="text:beginTime"></div>
  		<div class="weui-col-20" style="overflow: hidden;">大巴</div>
  		<input type="button" style="background-color:#32CD32;" data-bind="click:$root.approvalOptionBus" value="审批">
  		<input type="button" style="background-color:#FF3333;" data-bind="click:$root.refuseOptionBus" value="驳回">
    </div>
    <br/>
    </div>
   </div>
   <div id="train">
    <div data-bind="foreach:ShowListTrain">
    <div class="weui-row font_content" >
 		<input type="checkbox" name="trainIds" data-bind="textinput:id" class="ids"/> 
  		<!-- <div class="weui-col-20" style="overflow: hidden;" data-bind="text:staffName"></div> -->
  		 <div class="weui-col-15" style="overflow: hidden;" data-bind="text:moneyCost"></div> 
  		 <div class="weui-col-20" style="overflow: hidden;" data-bind="text:startTime"></div>
  		 <div class="weui-col-20" style="overflow: hidden;" >火车</div>
  		 <input type="button" style="background-color:#32CD32;" data-bind="click:$root.approvalOptionTrain" value="审批">
  		 <input type="button" style="background-color:#FF3333;" data-bind="click:$root.refuseOptionTrain" value="驳回">
    </div>
    <br/>
    </div>
    </div>
   <div id="hotel">
    <div data-bind="foreach:ShowListHotel">
     
    <div class="weui-row font_content" >
 		<input type="checkbox" name="hotelIds" data-bind="textinput:id" class="ids"/> 
  		<!-- <div class="weui-col-20" style="overflow: hidden;" data-bind="text:staffName"></div> -->
  		 <div class="weui-col-15" style="overflow: hidden;" data-bind="text:moneyCost"></div> 
  		<div class="weui-col-20" style="overflow: hidden;" data-bind="text:startTime"></div> 
  		<div class="weui-col-20" style="overflow: hidden;" >住宿费</div> 
  		<input type="button" style="background-color:#32CD32;" data-bind="click:$root.approvalOptionHotel" value="审批">
  		<input type="button" style="background-color:#FF3333;" data-bind="click:$root.refuseOptionHotel" value="驳回">
    </div>
    <br/>
    </div>
    </div>
    <div id="subWay">
    <div data-bind="foreach:ShowListSubway">
    <div class="weui-row font_content" >
 		<input type="checkbox" name="subwayIds" data-bind="textinput:id" class="ids"/> 
  		<!-- <div class="weui-col-20" style="overflow: hidden;" data-bind="text:askStaffName"></div> -->
  		 <div class="weui-col-15" style="overflow: hidden;" data-bind="text:askMoney"></div> 
  		<div class="weui-col-15" style="overflow: hidden;" data-bind="text:askMonth"></div>
  		<div class="weui-col-20" style="overflow: hidden;" >公交地铁</div>
  		<input type="button" style="background-color:#32CD32;" data-bind="click:$root.approvalOptionSubway" value="审批">
  		<input type="button" style="background-color:#FF3333;" data-bind="click:$root.refuseOptionSubway" value="驳回">
    </div>
    <br/>
    </div>
   </div>
    
    <div><a onclick="approvalOptions();" class="weui_btn weui_btn_primary" >一键审批</a></div>
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
    		//查看明细
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
			//审批拒绝操作
			self.refuseOptionBus = function(item){
				$.prompt({
					  title: '',
					  text: '请输入驳回原因',
					  input: '',
					  empty: false, // 是否允许为空
					  onOK: function (input) {
					    //点击确认
						  $.post("to_approve_bus_update.do",{id:item.id,result:"disagree",refuseReason:input},function(data){
								if(data == 1){
									window.location.reload();
								}else{
									 $.alert("驳回操作失败"); 
								}
							});
					  },
					  onCancel: function () {
					    //点击取消
					  }
					});
				
    		}
    		self.refuseOptionTrain = function(item){
    			$.prompt({
					  title: '',
					  text: '请输入驳回原因',
					  input: '',
					  empty: false, // 是否允许为空
					  onOK: function (input) {
					    //点击确认
						  $.post("approve_train_update.do",{id:item.id,result:"disagree",refuseReason:input},function(data){
								if(data== 1){
									window.location.reload();
								}else{
									$.alert("驳回操作失败");
								}
							});
					  },
					  onCancel: function () {
					    //点击取消
					  }
					});
    		}
			self.refuseOptionHotel = function(item){
				$.prompt({
					  title: '',
					  text: '请输入驳回原因',
					  input: '',
					  empty: false, // 是否允许为空
					  onOK: function (input) {
					    //点击确认
						  $.post("approve_hotel_update.do",{id:item.id,result:"disagree",refuseReason:input},function(data){
								if(data== 1){
									window.location.reload();
								}else{
									$.alert("驳回操作失败");
								}
							});
					  },
					  onCancel: function () {
					    //点击取消
					  }
					});
				
    		}
			self.refuseOptionSubway = function(item){
				$.prompt({
					  title: '',
					  text: '请输入驳回原因',
					  input: '',
					  empty: false, // 是否允许为空
					  onOK: function (input) {
					    //点击确认
						  $.post("expense_subway_approve_update.do",{id:item.id,result:"disagree",refuseReason:input},function(data){
								if(data== "success"){
									window.location.reload();
								}else{
									$.alert("驳回操作失败");
								}
							});
					  },
					  onCancel: function () {
					    //点击取消
					  }
					});
				
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
				if(data == "success"){
					window.location.reload(); 
				}
			}); 
		   }
		 		//批量大巴审批
			 if(busStr==""){
				  
			   }else{
				$.post("approve_bus_updates.do",{ids:busStr,result:result},function(data){
					if(data == "success"){
						window.location.reload(); 
					}
			     }); 
			   }
		
				//旅店批量审批
			if(hotelStr==""){
				   
			   }else{
				$.post("approve_hotel_updates.do",{ids:hotelStr,result:result},function(data){
					if(data == "success"){
						window.location.reload(); 
					}
				}); 
			   }
				//地铁公交批量审批
			if(subwayStr==""){
				   
			   }else{
				$.post("approve_subway_updates.do",{ids:subwayStr,result:result},function(data){
					if(data == "success"){
						window.location.reload(); 
					}
				}); 
			   }
			 
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
