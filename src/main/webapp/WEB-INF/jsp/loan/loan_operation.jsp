<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
 String path=request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
 <!--  员工个人冲借款展示界面 -->
<head>
<meta charset="utf-8" />
    <title>预付款列表 </title>
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
<form id="form" method="post" > 
  <div class="caidan-tiku" style="margin-bottom:3%">    
  				<div class="caidan-tiku-s" style="margin-right:5%" id="staffNameDiv"> <span>姓名：</span>
                    <input id="staffName" type="text" name="staffName" class="shuruk-a2" placeholder="" value="${staffName }">
                </div>     
                <div class="caidan-tiku-s" style="margin-right:5%" id="staffIdDiv"> <span>工号：</span>
                    <input id="staffId" type="text" name="staffId" class="shuruk-a2" placeholder="" value="${staffId }">
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>时间：</span>
                    <input id="startTime" type="text" name="startTime" class="laydate-icon shuruk-a2 form_date" placeholder="" value="${startTime }">
                    <input id="endTime" type="text" name="endTime" class="shuruk-a2 form_date" placeholder=""  value="${endTime}">
                </div>
                 <div style="float:right;margin-right:15px;padding-bottom:10px;" >
                    <input  type="button" value="查询"  class="btn btn-success" onclick="search();">
                    <input   type="button" value="清空"  class="btn btn-default" style="background:#fd9162" onclick="clearPropertities();">
                </div>  
          </div>       
</form>
    <div style="width:100%; height:700px;padding-top: 5px;overflow:scroll;border:0 solid #000000;">
            <table  width="100%" border="1" cellspacing="0" cellpadding="0" class="table-1">
                <thead class="table-1-tou">
                <th class="text_center" >审批编号</th>
                <th class="text_center" >姓名</th>
               <th class="text_center" >部门</th> 
                 <th class="text_center">工号</th>
              <!--  <th class="text_center">审批状态</th>
                <th class="text_center">审批结果</th> -->
               <!--  <th class="text_center">审批发起时间</th> -->
               <!--  <th class="text_center">审批完成时间</th> -->
                <!-- <th class="text_center" >历史审批人</th>
                <th class="text_center" >当前审批人</th> -->
                <th class="text_center" >借款时间</th>
                <th class="text_center">借款用途大类</th>
                <th class="text_center">借款用途小类</th>
                <th class="text_center" >借款金额</th>
                <!-- <th class="text_center" >还款金额</th>
                <th class="text_center" >发票金额</th> -->
                <th class="text_center" >收款人</th>
                <!-- <th class="text_center">开户银行</th> -->
               <!--  <th class="text_center" >开户支行</th> -->
                <th class="text_center" >银行账号</th>
               
                <!-- <th class="text_center" >借款原因</th> -->
                <!-- <th class="text_center" >其他</th> -->
                <th class="text_center">冲借款状态</th>
                <th class="text_center" >操作</th>
                </thead>
                <tbody >
               <c:forEach items="${advanceList}" var="advance">
                <tr >
                	<!--  审批编号 -->
                <td class="text_center" width="6%">${advance.approveNo }</td>
                 	<!-- 姓名 -->
                <td class="text_center" width="6%">${advance.askStaffName }</td>
               		 <!-- 部门-->
                 <td class="text_center" width="9%">${advance.askStaffDep }</td>
                	<!-- 工号 -->
                <td class="text_center" width="6%">${advance.askStaffId}</td>
                	<!-- 审批状态 -->
                <%-- <td class="text_center" width="6%">${advance.approveStatus }</td>
                	<!-- 审批结果 -->
                <td class="text_center" width="6%">${advance.approveResult}</td> --%>
                	<!-- 审批发起时间 -->
               <%--  <td class="text_center" width="6%">${advance.askStartTime }</td>
                	<!-- 审批完成时间 -->
                <td class="text_center" width="6%">${advance.askEndTime}</td> --%>
                <%--      <!-- 历史审批人-->
                <td class="text_center" width="6%">${advance.approverHistory}</td>
                	 <!-- 当前审批人-->
                <td class="text_center" width="6%">${advance.approverNow }</td> --%>
                	 <!-- 借款时间-->
                <td class="text_center" width="6%">${advance.advanceStartTime }</td>
                 	<!-- 借款用途大类 -->
                <td class="text_center" width="6%">${advance.advanceAimMc }</td> 
                	<!-- 借款用途小类 -->
                <td class="text_center" width="6%">${advance.advanceAimSc }</td>
                		 <!-- 借款金额-->
                <td class="text_center" width="6%">${advance.advanceSum }</td>
                 		<!-- 还款金额 -->
                <%-- <td class="text_center" width="3%"><input type="text"  class="shuruk-a2" name="approveRepayment"  value="${advance.approveRepayment }" /></td> --%>
                		<!-- 发票金额 -->
               <%--  <td class="text_center" width="3%"><input  type="text"  class="shuruk-a2" name="approveInvoice" value="${advance.approveInvoice }"/></td> --%>
                 		<!-- 收款人-->
                <td class="text_center" width="6%">${advance.advancePayee }</td>
                 		<!-- 开户银行-->
               <%--  <td class="text_center" width="6%">${advance.advanceBank }</td> --%>
                		 <!-- 开户支行-->
              <%--   <td class="text_center" width="">${advance.advanceBranch }</td> --%>
                 		<!-- 银行账号-->
                <td class="text_center" width="">${advance.advanceBankAccount }</td> 
               	  		<!-- 借款原因-->
               <%--  <td class="text_center" width="">${advance.advanceReason }</td>
                		<!-- 其他 -->
                <td class="text_center" width="">${advance.other }</td> --%>
                <td class="text_center">${advance.loanStatus }</td>
                <td class="text_center"> 
                	<input type="button" class="btn btn-success" onclick="startAloan('${advance.approveNo}','${advance.loanStatus }');" value="冲预付"/>
                	<input type="button" class="btn btn-info" onclick="view('${advance.approveNo}','${advance.loanStatus}');" value="详情"/>
                </td>
                </tr>
               </c:forEach>
                </tbody>
            </table>
            <%-- <jsp:include page="./commons/page.jsp"></jsp:include> --%>
     </div>
<footer height="100px";>
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
function startAloan(data1,data2){
	if(data2=="驳回" || data2=="" || data2==null){
		window.location.href="goStartALoan.do?approveNo="+data1;
		
	}else{
		alert("已做冲借款,请稍后重试");
	}
};
	//查询
function search(){
	window.location.href="toLoan_operation.do?staffName="+$("#staffName").val()
			+"&staffId="+$("#staffId").val()+"&startTime="+$("#startTime").val()
			+"&endTime="+$("#endTime").val();
};
 //清空
function clearPropertities(){
	$("#staffName").val("");
	$("#staffId").val("");
	$("#startTime").val("");
	$("#endTime").val("");
}
		//判空
	function isNull(data){
		return (data == "" || data == undefined || data == null) ? 0 : data; 
	};
		//冲预付详情查看
	function view(data,data2){
		if(data2=="" || data2==null){
			alert("当前预付款未做冲预付,无法查看冲预付详情");
		}else{
			window.location.href="toLoanView.do?approveNo="+data;
		}
	};
	var staffId = '${staffId}';
	//给马天立流个接口有权限发起所有的冲借款
$("#document").ready(function(){
	 if(isNull(staffId) != 0){
		$("#staffNameDiv").hide();
		$("#staffIdDiv").hide();
	} 
});
</script>
</body>
</html>
