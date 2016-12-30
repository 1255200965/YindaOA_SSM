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
  <title>项目变更申请详情</title>
 </head>
 <body >
    <div class="weui_cells weui_cells_form " >

  <div class="weui_cell weui_vcode">
    <div class="weui_cell_hd"><label class="weui_label">变动部门</label></div>
    <div class="weui_cell_bd weui_cell_primary">
    <div class="weui_cell weui_cell_select">
    <div class="weui_cell_bd weui_cell_primary">
    <span>${itemChange.icAskStaffDepart}</span>
    </div>
   </div>
   </div>
  </div>
  
  
    <div class="weui_cell weui_vcode">
    <div class="weui_cell_hd"><label class="weui_label">变动项目</label></div>
    <div class="weui_cell_bd weui_cell_primary">
    <div class="weui_cell weui_cell_select">
    <div class="weui_cell_bd weui_cell_primary">
    <span>${itemChange.icChangeItem }</span>
    </div>
   </div>
   </div>
  </div>
  
  
  
    <div class="weui_cell weui_vcode">
    <div class="weui_cell_hd"><label class="weui_label">变动订单</label></div>
    <div class="weui_cell_bd weui_cell_primary">
    <div class="weui_cell weui_cell_select">
    <div class="weui_cell_bd weui_cell_primary">
     <span>${itemChange.icChangeOrder }</span>
    </div>
   </div>
   </div>
  </div>
  
  
    <div class="weui_cell weui_vcode">
    <div class="weui_cell_hd"><label class="weui_label">商务属性</label></div>
    <div class="weui_cell_bd weui_cell_primary">
    <div class="weui_cell weui_cell_select">
    <div class="weui_cell_bd weui_cell_primary">
    <span>${itemChange.icBusinessProperty }</span>
    </div>
   </div>
   </div>
  </div>
  
  
  
    <div class="weui_cell weui_vcode">
    <div class="weui_cell_hd"><label class="weui_label">商务等级</label></div>
    <div class="weui_cell_bd weui_cell_primary">
    <div class="weui_cell weui_cell_select">
    <div class="weui_cell_bd weui_cell_primary">
    <span>${itemChange.icCost }</span>
    </div>
   </div>
   </div>
  </div>
  
        <div class="weui_cell weui_vcode">
    <div class="weui_cell_hd"><label class="weui_label">合同类型</label></div>
    <div class="weui_cell_bd weui_cell_primary">
    <div class="weui_cell weui_cell_select">
    <div class="weui_cell_bd weui_cell_primary">
     <span>${itemChange.icApproveRecord }</span>
    </div>
   </div>
   </div>
  </div>
  

   <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">变动省份</label></div>
    <div class="weui_cell_bd weui_cell_primary">
    <span>${itemChange.icChangeProvince }</span>
    </div>
  </div>
  
     <div class="weui_cell">
    <div class="weui_cell_hd"><label class="weui_label">变动城市</label></div>
    <div class="weui_cell_bd weui_cell_primary">
       <span>${itemChange.icWorkCity }</span>
    </div>
  </div>

  
  
       <div class="weui_cell weui_vcode">
    <div class="weui_cell_hd"><label class="weui_label">室外工作</label></div>
    <div class="weui_cell_bd weui_cell_primary">
    <div class="weui_cell weui_cell_select">
    <div class="weui_cell_bd weui_cell_primary">
     <span>${itemChange.icOutroomWork }</span>
    </div>
   </div>
   </div>
  </div>
  
    <div class="weui_cell">
    <div class="weui_cell_hd"><label for="" class="weui_label">生效日期</label></div>
    <div class="weui_cell_bd weui_cell_primary">
       <span>${itemChange.icApproveBegin }</span>
    </div>
  </div>

  </div>
  

   <div class="weui_cell">
    
    <div class="weui_cell_bd weui_cell_primary">
     <a href="javascript:history.go(-1);" class="weui_btn weui_btn_primary">返回</a>
    </div>
  </div>
 
  	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/jquery-weui.js"></script>
 </body> 
</html>
