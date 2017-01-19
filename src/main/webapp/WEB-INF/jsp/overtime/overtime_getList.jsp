<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
 String path=request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
    <title>加班明细</title>
    <!-- this "tags" contains all the patterns we need in this page -->
    <link rel="stylesheet" href="<%=path%>/stylesheets/reset.css"/>
    <link href="<%=path%>/stylesheets/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=path%>/stylesheets/bootstrap-theme.min.css" rel="stylesheet" />
    <link href="<%=path%>/stylesheets/bootstrap-treeview.min.css" rel="stylesheet" />
    <link href="<%=path%>/stylesheets/shujutongji.css" rel="stylesheet" />
    <link href="<%=path%>/stylesheets/ddcss.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=path%>/stylesheets/bootstrap.min.css" />
    <link rel="shortcut icon" type="image/ico" href="<%=path%>/images/yd.ico" />
    <link rel="stylesheet" href="<%=path%>/stylesheets/reset.css"/>
    <link rel="stylesheet" href="<%=path%>/stylesheets/buttons.css"/>
    <link rel="stylesheet" href="<%=path%>/stylesheets/header.css"/>
    <link rel="stylesheet" href="<%=path%>/stylesheets/affairs-search.css"/>
    <link rel="stylesheet" href="<%=path%>/datePlug/jquery.monthpicker.css"/>
    <link href="<%=path%>/datetimepicker/sample/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="<%=path%>/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    
    <script src="<%=path%>/javascripts/jquery-1.10.2.js"></script> 
    <script src="<%=path%>/datePlug/jquery.monthpicker.js"></script>
    <script type="text/javascript" src="<%=path%>/javascripts/bootstrap-treeview.min.js"></script>
    <script src="<%=path%>/javascripts/knockout-3.4.0rc.js"></script>
    
    <script type="text/javascript" src="<%=path%>/datetimepicker/sample/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="<%=path%>/datetimepicker/sample/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=path%>/datetimepicker/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="<%=path%>/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>


    <style>
        *{box-sizing: content-box;-webkit-box-sizing: content-box;}
        .c_box{min-width:1350px;width:100%;}
        .c_box .col-md-2{min-width:189px;width:12.4%;}
        .c_box .c_left_box{height:850px;}
        .c_box .c_right_box {min-width:1056.7px;width:79%;}
        .table-1 tbody td{font-size:12px;}
    </style>
    
</head>

<body style="background-color:white;">

<br/>
<form id="form"> 
  <div class="caidan-tiku" style="margin-bottom:3%">              
              <div class="caidan-tiku-s" style="margin-right:5%"> <span>姓名：</span>
                    <input id="search_name" type="text" name="otAskStaffName" class="shuruk-a2" placeholder="" value="${overTime2.otAskStaffName}">
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>工号：</span>
                    <input id="search_workid" type="text" name="otAskStaffId" class="shuruk-a2" placeholder="" value="${overTime2.otAskStaffId }">
                </div>
               <div class="caidan-tiku-s" style="margin-right:5%"> <span>部门：</span>
                    <input id="otAskStaffDepart" type="text" name="otAskStaffDepart" class="shuruk-a2" placeholder="" value="${overTime2.otAskStaffDepart }">
                </div>
               <%--  <div class="caidan-tiku-s" style="margin-right:5%"> <span>部门：</span>
                    <select id="otAskStaffDepart" name="otAskStaffDepart"  >
                    	<option value=""></option>
                    	<c:forEach items="${depList }" var="dep">
                    	 	<option value="${dep }"	<c:if test="${dep eq  overTime2.otApproveResult}">selected="selected"</c:if>>${dep}</option>
                    	</c:forEach>
                    </select>
                </div> --%>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>加班开始时间：</span>
                    <input id="start" type="text" name="otAskBeginTime" class="laydate-icon shuruk-a2 form_date" placeholder="" value="${overTime2.otAskBeginTime}">
                    <input id="search_name2" type="text" name="otAskEndTime" class="shuruk-a2 form_date" placeholder=""  value="${overTime2.otAskEndTime }">
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>审批结果：</span>
                    <select id="otApproveResult" name="otApproveResult" class="shuruk-a2"  >
                    	<option value="同意" <c:if test="${overTime2.otApproveResult eq '同意'}">selected="selected"</c:if>>同意</option>
                    	<option value=""  <c:if test="${overTime2.otApproveResult eq ''}" >selected="selected"</c:if>>全部</option>
                    </select>
                </div>
                
                <div style="float:right;margin-right:0px;padding-bottom:0px;" >
                    <button  type="button"   class="btn btn_primary" onclick="subForm();">查询</button>
                    <button  type="button"   class="btn btn_info"  onclick="clearPropertities();">清空</button>
                    <button  type="button"   class="btn btn_danger" style="background:#fd9162" onclick="downLoad();">下载</button>
                </div>           
    </div>
</form>
    <div style="width:100%; height:700px;padding-top: 5px;overflow:auto;border:0 solid #000000;">
            <table  width="100%" border="1" cellspacing="0" cellpadding="0" class="table-1">
                <thead class="table-1-tou">
                <td class="text_center" width="6%">姓名</td>
                <td class="text_center" width="9%">工号</td>
                <td class="text_center" width="6%">部门</td>
                <td class="text_center" width="6%">加班类型</td>
                <td class="text_center" width="6%">加班原因</td>
                <td class="text_center" width="6%">开始时间</td>
                <td class="text_center" width="6%">结束时间</td>
                <td class="text_center" width="6%">加班时长</td>
                <td class="text_center" width="6%">加班地点</td>
                <td class="text_center" width="6%">历史审人</td>
                <td class="text_center" width="6%">当前审批人</td>
                <td class="text_center" width="6%">审批状态</td>
                <td class="text_center" width="6%">审批结果</td>
                
                </thead>
                <tbody >
               <c:forEach items="${overTimeList}" var="overTime">
                <tr >
                 <td class="text_center" width="6%">${overTime.otAskStaffName }</td>
                <td class="text_center" width="6%">${overTime.otAskStaffId }</td>
                <td class="text_center" width="9%">${overTime.otAskStaffDepart }</td>
                <td class="text_center" width="6%">${overTime.otPayMethod}</td>
                <td class="text_center" width="6%">${overTime.otAskReason }</td>
                <td class="text_center" width="6%">${overTime.otApproveBegin}</td>
                <td class="text_center" width="6%">${overTime.otApproveEnd }</td>
                <td class="text_center" width="6%">${overTime.otCost}</td>
                <td class="text_center" width="6%">${overTime.otAddress}</td>
                <td class="text_center" width="6%">${overTime.otHistoryApproveName}</td>
                <td class="text_center" width="6%">${overTime.otNowApproveName }</td>
                 <td class="text_center" width="6%">${overTime.otApproveState}</td>
                <td class="text_center" width="6%">${overTime.otApproveResult }</td>
                </tr>
               </c:forEach>
                </tbody>
            </table>
            <%-- <jsp:include page="./commons/page.jsp"></jsp:include> --%>
     </div>
<footer>
    <p><img src="<%=path%>/images/tubiao.png" alt="">上海音达科技实业有限公司</p>
</footer> 
<script type="text/javascript">
$('.form_date').datetimepicker({
    language:  'zh-CN',
    todayBtn:  1,
	autoclose: 1,
	format:'yyyy-mm-dd',
	minView: "month",
});
	function subForm(){
		$("#form").submit();
	}
	function clearPropertities(){
		$("input[name='otAskStaffName']").val("");
		$("input[name='otAskStaffId']").val("");
		$("input[name='otAskStaffDepart']").val("");
		$("input[name='otApproveBegin']").val("");
		$("input[name='otApproveEnd']").val("");
	}
	function downLoad(){
		
		window.location.href="overtime/download.do";
	}
</script>
</body>
</html>
