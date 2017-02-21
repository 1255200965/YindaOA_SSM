<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
<%
	String path = request.getContextPath();/*获得当前项目的根路径 */
%>
<!-- 报销申请入口 -->
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
 <head>
  <link rel="stylesheet" href="<%=path%>/stylesheets/weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/jquery-weui.css"/>
  <link rel="stylesheet" href="<%=path%>/stylesheets/projectcss.css"/>
  <title>报销申请</title>
 </head>
 <body >
 <div class="weui_grids">
  <a  class="weui_grid js_grid" onclick="goExpense_train();">
    <div class="weui_grid_icon">
      <img src="<%=path%>/images/train.png" alt="">
    </div>
    <p class="weui_grid_label">
                   火车票报销
    </p>
  </a>
  <a  class="weui_grid js_grid" data-id="cell" onclick="goExpense_history_bus();">
    <div class="weui_grid_icon">
      <img src="<%=path%>/images/bus.png" alt="">
    </div>
    <p class="weui_grid_label">
              大巴费报销
    </p>
  </a>
  <a href="javascript:;" class="weui_grid js_grid" data-id="toast" onclick="goExpense_hotel();">
    <div class="weui_grid_icon">
      <img src="<%=path%>/images/hotel.png" alt="">
    </div>
    <p class="weui_grid_label">
         住宿费报销
    </p>
  </a>
   <a href="javascript:;" class="weui_grid js_grid" data-id="toast" onclick="goExpense_subway();">
    <div class="weui_grid_icon">
      <img src="<%=path%>/images/taxi.png" alt="">
    </div>
    <p class="weui_grid_label">
           地铁公交报销
    </p>
  </a> 
   <a href="javascript:;" class="weui_grid js_grid" data-id="toast" onclick="goApprove_history_view();">
    <div class="weui_grid_icon">
      <img src="<%=path%>/images/taxi.png" alt="">
    </div>
    <p class="weui_grid_label">
         	审批信息查看   
    </p>
  </a> 
 
</div>
  	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
    <script type="text/javascript" src="http://g.alicdn.com/ilw/ding/0.7.3/scripts/dingtalk.js"></script>
    <script>
     function goExpense_train(){
    	 location="toExpense_train.do";
     }
     function goExpense_history_bus(){
    	 location="toExpense_bus.do";
     }
     function goExpense_hotel(){
    	 location="toExpense_hotel.do";
     }
     function goExpense_subway(){
    	 location="toExpense_subway.do";
     }
     
     function goApprove_history_view(){
    	 location="goApprove_record.do";
    	
     }
     /*权限验证配置所需的信息 */
     var config =<%=request.getAttribute("config")%>;
     //当前用户
     var nowUser=null;
     //用户授权码
     var code=null;
     /* $(document).ready(function(){
    	 $.alert(config);
     }); */
      //配置钉钉jsapi
     dd.config({
         agentId : "38433641",
         corpId : config.corpId,
         timeStamp : config.timeStamp,
         nonceStr : config.nonceStr,
         signature : config.signature,
         jsApiList : [ 'runtime.info', 'biz.contact.choose',
             'device.notification.confirm', 'device.notification.alert',
             'device.notification.prompt', 'biz.ding.post',
             'biz.util.openLink' ]
     });

    
     dd.ready(function() {
  
         dd.runtime.permission.requestAuthCode({
             corpId : config.corpId,
             onSuccess : function(info) {
                //存储用户信息
              $.post("loginJudge.do",{"code":info.code});
               
             },
             onFail : function(err) {
                 alert('fail: ' + JSON.stringify(err));
             }
         });
     });
    </script>
 </body> 
</html>
