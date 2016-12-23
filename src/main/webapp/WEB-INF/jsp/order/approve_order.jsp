<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  <script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
  <script src="<%=path%>/javascripts/jquery-weui.js"></script>
  <script type="text/javascript" src="http://g.alicdn.com/ilw/ding/0.7.3/scripts/dingtalk.js"></script>
  <title>项目变更审批</title>
 </head>
 <style>
 .assess{
 background:#04BE02;
 color:white;
 width:40px;
 height:40px;
 border-radius:40px; 
 text-align:center;
 line-height:40px;
 }
 </style>
 <body >
  <div class="weui-pull-to-refresh-layer">
    <div class="pull-to-refresh-arrow"></div> <!-- 上下拉动的时候显示的箭头 -->
    <div class="pull-to-refresh-preloader"></div> <!-- 正在刷新的菊花 -->
    <div class="down">下拉刷新</div><!-- 下拉过程显示的文案 -->
    <div class="up">释放刷新</div><!-- 下拉超过50px显示的文案 -->
    <div class="refresh">正在刷新...</div><!-- 正在刷新时显示的文案 -->
  </div>
 
 <form>
<div class="weui_cells weui_cells_form " id="divform">

  <div class="weui_cell weui_vcode">
    <div class="weui_cell_hd"><label class="weui_label">变动部门</label></div>
    <div class="weui_cell_bd weui_cell_primary">
    <div class="weui_cell weui_cell_select">
    <div class="weui_cell_bd weui_cell_primary">
      <select class="weui_select" name="department" id="department">
        <option value="${itemChange.icDepartment}">${itemChange.icAskStaffDepart}</option>
      </select>
    </div>
   </div>
   </div>
  </div>
  
  
    <div class="weui_cell weui_vcode">
    <div class="weui_cell_hd"><label class="weui_label">变动项目</label></div>
    <div class="weui_cell_bd weui_cell_primary">
    <div class="weui_cell weui_cell_select">
    <div class="weui_cell_bd weui_cell_primary">
      <select class="weui_select" name="project" id="project">
      <option  >${itemChange.icChangeItem}</option>
      </select>
    </div>
   </div>
   </div>
  </div>
  
  
  
    <div class="weui_cell weui_vcode">
    <div class="weui_cell_hd"><label class="weui_label">变动订单</label></div>
    <div class="weui_cell_bd weui_cell_primary">
    <div class="weui_cell weui_cell_select">
    <div class="weui_cell_bd weui_cell_primary">
      <select class="weui_select" name="orderName" id="orderName">
        <option >${itemChange.icChangeOrder}</option>
      </select>
    </div>
   </div>
   </div>
  </div>
  
  
    <div class="weui_cell weui_vcode">
    <div class="weui_cell_hd"><label class="weui_label">商务属性</label></div>
    <div class="weui_cell_bd weui_cell_primary">
    <div class="weui_cell weui_cell_select">
    <div class="weui_cell_bd weui_cell_primary">
      <select class="weui_select" name="businessProperty" id="businessProperty">
        <option  value="TimeBase" <c:if test="${itemChange.icBusinessProperty=='TimeBase'}">selected='selected'</c:if> >TimeBase</option> 
        <option value="TaskBase"<c:if test="${itemChange.icBusinessProperty=='TaskBase'}">selected='selected'</c:if> >TaskBase</option>   
      </select>
    </div>
   </div>
   </div>
  </div>
  
  
  
    <div class="weui_cell weui_vcode">
    <div class="weui_cell_hd"><label class="weui_label">商务等级</label></div>
    <div class="weui_cell_bd weui_cell_primary">
    <div class="weui_cell weui_cell_select">
    <div class="weui_cell_bd weui_cell_primary">
      <select class="weui_select" name="yindaIdentify" id="yindaIdentify">
       <option >${itemChange.icCost}</option>
      </select>
    </div>
   </div>
   </div>
  </div>
  
        <div class="weui_cell weui_vcode">
    <div class="weui_cell_hd"><label class="weui_label">合同类型</label></div>
    <div class="weui_cell_bd weui_cell_primary">
    <div class="weui_cell weui_cell_select">
    <div class="weui_cell_bd weui_cell_primary">
      <select class="weui_select" name="contractType" id="contractType">
       <option >${itemChange.icApproveRecord}</option>
      </select>
    </div>
   </div>
   </div>
  </div>
  

   <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">变动省份</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input" type="text" placeholder="请输入省份" id="changeProvince" name="changeProvince" value="${itemChange.icChangeProvince}" readOnly>
    </div>
  </div>
  
     <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">变动城市</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input" type="text" placeholder="请输入城市" id="changeCity" name="changeCity" value="${itemChange.icWorkCity}" readOnly>
    </div>
  </div>

  
  
       <div class="weui_cell weui_vcode">
    <div class="weui_cell_hd"><label class="weui_label">室外工作</label></div>
    <div class="weui_cell_bd weui_cell_primary">
    <div class="weui_cell weui_cell_select">
    <div class="weui_cell_bd weui_cell_primary">
      <select class="weui_select" name="select1">
        <option  value="${itemChange.icOutroomWork}">${itemChange.icOutroomWork}</option>  
      </select>
    </div>
   </div>
   </div>
  </div>
  
    <div class="weui_cell">
    <div class="weui_cell_hd"><label for="" class="weui_label">生效日期</label></div>
    <div class="weui_cell_bd weui_cell_primary">
      <input class="weui_input" type="text" value="${itemChange.icApproveBegin}">
    </div>
  </div>

 
  
  <div class="weui_cell">
    <div class="weui_cell_hd"><label for="" class="weui_label">审批人</label></div>
    <div class="weui_cell_bd weui_cell_primary">
     <div class="assess">${approveName}<div>
    </div>
  </div>
  </div>
  
 
</div>

   <div class="weui_cell">
    
    <div class="weui_cell_bd weui_cell_primary">
      <c:if test="${itemChange.icApproveResult==null}"><a href="javascript:pass_approve();" class="weui_btn weui_btn_primary">通过</a></c:if>
    </div>
    
      <div class="weui_cell_bd weui_cell_primary">
       <c:if test="${itemChange.icApproveResult==null}"><a href="javascript:refuse_approve();" class="weui_btn weui_btn_disabled weui_btn_warn">拒绝</a></c:if>
    </div>
   
  </div>
 </div></form>		
    <script>
    /** 页面下拉刷新**/
    $(document.body).pullToRefresh();   
    $(document.body).on("pull-to-refresh", function() {   	 
    	window.location.reload();  	 	
    	$(document.body).pullToRefreshDone();
    	});


    
    function pass_approve(){
    	
    	var id ="${itemChange.icSequenceNo}";
    	
    	$.post("<%=path%>/ItemChange/pass_approve.do",{"id":id},function(data){
    	if("success"==data){
    		$.alert("操作成功！");
    	window.history.go(-1);
    	}else{   		
    		$.alert("操作失败！");
    	}
    		
    		
    	});
    	
    }
  

    function refuse_approve(){
    	 var id ="${itemChange.icSequenceNo}";
    		$.post("<%=path%>/ItemChange/refuse_approve.do",{"id":id},function(data){
    			if("success"==data){
    	    		$.alert("操作成功！");
    	    		window.history.go(-1);
    	    	}else{   		
    	    		$.alert("操作失败！");
    	    	}
    	    		
    			
    		});
        	
    
    	
    }

     
        
      
     
        
    </script>
 </body> 
</html>
