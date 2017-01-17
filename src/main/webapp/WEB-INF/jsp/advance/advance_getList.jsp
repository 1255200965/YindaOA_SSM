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
              <div class="caidan-tiku-s" style="margin-right:5%"> <span>姓名：</span>
                    <input id="askStaffName" type="text" name="askStaffName" class="shuruk-a2" placeholder="" value="${advance2.askStaffName }">
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>工号：</span>
                    <input id="askStaffId" type="text" name="askStaffId" class="shuruk-a2" placeholder="" value="${advance2.askStaffId }">
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>部门：</span>
                    <select id="askStaffDep" type="text" name="askStaffDep" class="shuruk-a2" placeholder="" >
                    	<option value=""></option>
                    	<c:forEach items="${depList }" var="dep">
                    	 	<option value="${dep }"	<c:if test="${dep eq  advance2.askStaffDep}">selected="selected"</c:if>>${dep}</option>
                    	</c:forEach>
                    </select>
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>审批状态：</span>
                    <select id="approveResult" type="text" name="approveResult" class="shuruk-a2" placeholder="" >
                        <option value="同意" <c:if test="${advance2.approveResult eq '同意' }">selected="selected"</c:if>>已同意</option>
                    	<option value="" <c:if test="${advance2.approveResult eq '' }">selected="selected"</c:if>>全部</option>
                    </select>
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>时间：</span>
                    <input id="askStartTime" type="text" name="askStartTime" class="laydate-icon shuruk-a2 form_date" placeholder="" value="${advance2.askStartTime }">
                    <input id="askEndTime" type="text" name="askEndTime" class="shuruk-a2 form_date" placeholder=""  value="${advance2.askEndTime }">
                </div>
                 <div style="float:right;margin-right:15px;padding-bottom:10px;" >
                    <input  type="button" value="查询"  class="btn btn-success" onclick="subForm();">
                    <input   type="button" value="下载"  class="btn btn-default" style="background:#fd9162" onclick="downLoad();">
                    <input   type="button" value="清空"  class="btn btn-default" style="background:#fd9162" onclick="clearPropertities();">
                </div>         
    </div>
</form>
    <div style="width:100%; height:700px;padding-top: 5px;overflow:scroll;border:0 solid #000000;">
            <table  width="100%" border="1" cellspacing="0" cellpadding="0" class="table-1">
                <thead class="table-1-tou">
                <th class="text_center" >审批编号</th>
                <th class="text_center" >姓名</th>
                <!-- <th class="text_center" >部门</th>
                <th class="text_center">工号</th> -->
                <th class="text_center">审批状态</th>
                <th class="text_center">审批结果</th>
               <!--  <th class="text_center">审批发起时间</th> -->
               <!--  <th class="text_center">审批完成时间</th> -->
                <th class="text_center" >历史审批人</th>
                <th class="text_center" >当前审批人</th>
                <th class="text_center" >借款时间</th>
                <th class="text_center">借款用途大类</th>
                <th class="text_center">借款用途小类</th>
                <th class="text_center" >借款金额</th>
                <th class="text_center" >收款人</th>
                <!-- <th class="text_center">开户银行</th> -->
                <th class="text_center" >开户支行</th>
                <th class="text_center" >银行账号</th>
                <!-- <th class="text_center" >借款原因</th> -->
                <!-- <th class="text_center" >其他</th> -->
                <th class="text_center" >状态</th>
                </thead>
                <tbody >
               <c:forEach items="${advanceList}" var="advance">
                <tr >
                	<!--  审批编号 -->
                <td class="text_center" width="6%">${advance.approveNo }</td>
                 	<!-- 姓名 -->
                <td class="text_center" width="6%">${advance.askStaffName }</td>
               		 <!-- 部门-->
                <%-- <td class="text_center" width="9%">${advance.askStaffDep }</td>
                	<!-- 工号 -->
                <td class="text_center" width="6%">${advance.askStaffId}</td> --%>
                	<!-- 审批状态 -->
                <td class="text_center" width="6%">${advance.approveStatus }</td>
                	<!-- 审批结果 -->
                <td class="text_center" width="6%">${advance.approveResult}</td>
                	<!-- 审批发起时间 -->
               <%--  <td class="text_center" width="6%">${advance.askStartTime }</td>
                	<!-- 审批完成时间 -->
                <td class="text_center" width="6%">${advance.askEndTime}</td> --%>
                     <!-- 历史审批人-->
                <td class="text_center" width="6%">${advance.approverHistory}</td>
                	 <!-- 当前审批人-->
                <td class="text_center" width="6%">${advance.approverNow }</td>
                	 <!-- 借款时间-->
                <td class="text_center" width="6%">${advance.advanceStartTime }</td>
                 	<!-- 借款用途大类 -->
                <td class="text_center" width="6%">${advance.advanceAimMc }</td> 
                	<!-- 借款用途小类 -->
                <td class="text_center" width="6%">${advance.advanceAimSc }</td>
                		 <!-- 借款金额-->
                <td class="text_center" width="6%">${advance.advanceSum }</td>
                 		<!-- 收款人-->
                <td class="text_center" width="6%">${advance.advancePayee }</td>
                 		<!-- 开户银行-->
               <%--  <td class="text_center" width="6%">${advance.advanceBank }</td> --%>
                		 <!-- 开户支行-->
                <td class="text_center" width="">${advance.advanceBranch }</td>
                 		<!-- 银行账号-->
                <td class="text_center" width="">${advance.advanceBankAccount }</td>
               	  		<!-- 借款原因-->
               <%--  <td class="text_center" width="">${advance.advanceReason }</td>
                		<!-- 其他 -->
                <td class="text_center" width="">${advance.other }</td> --%>
                <th class="text_center">${advance.exportStatus }</th>
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
	function subForm(){
		$("#form").submit();
	}
	function clearPropertities(){
		$("input[name='askStaffName']").val("");
		$("input[name='askStaffId']").val("");
		$("select[name='askStaffDep']").val("");
		$("input[name='askStartTime']").val("");
		$("input[name='askEndTime']").val("");	
		
	}
	function downLoad(){
		
		window.location.href="downLoad.do?askStaffName="+$("#askStaffName").val()+"&askStaffId="+$("#askStaffId").val()
						+"&askStaffDep="+$("#askStaffDep").val()+"&askStartTime="+$("#askStartTime").val()
						+"&askEndTime="+$("#askEndTime").val()+"&approveResult="+$("#approveResult").val();
	}
	
</script>
</body>
</html>
