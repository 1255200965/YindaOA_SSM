<%--
  Created by IntelliJ IDEA.
  User: ma
  Date: 2016/10/17
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%--开启c标签的使用--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--定义变量ctx代表上下文路径--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<title>人资管理平台</title>
<%--<link type="text/css" rel="stylesheet" href="../stylesheets/style.css" />--%>
<link rel="stylesheet" href="<%=path%>/stylesheets/reset.css">

<link href="<%=path%>/stylesheets/bootstrap.min.css" rel="stylesheet" />
<link href="<%=path%>/stylesheets/bootstrap-theme.min.css"
	rel="stylesheet" />
<link href="<%=path%>/stylesheets/bootstrap-treeview.min.css"
	rel="stylesheet" />
<link href="<%=path%>/stylesheets/shujutongji.css" rel="stylesheet" />
<link href="<%=path%>/stylesheets/ddcss.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path%>/stylesheets/header.css">

<script type="text/javascript"
	src="<%=path%>/javascripts/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="<%=path%>/javascripts/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/javascripts/bootstrap-treeview.min.js"></script>
<script src="<%=path%>/javascripts//knockout-3.4.0rc.js"></script>
<style>
* {
	box-sizing: content-box;
	-webkit-box-sizing: content-box;
}

.c_box {
	min-width: 1350px;
	width: 100%;
}

.c_box .col-md-2 {
	min-width: 189px;
	width: 12.4%;
}

.c_box .c_left_box {
	height: 850px;
}

.c_box .c_right_box {
	min-width: 1056.7px;
	width: 79%;
}

.table-1 tbody td {
	font-size: 12px;
}
</style>

</head>
<body>

	<header>
		<div class="">
			<div class="head-left fl">
				<img src="<%=path%>/images/logo.png" height="35" width="50" alt="">
				人事管理系统
			</div>

			<div class="head-nav fl" id="h-nav">
				<ul>
					<li>
						<div class="btn-group">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								导入模块 <span class="caret"></span>
							</a>
							<ul class="dropdown-menu" style="background-color: #3792F2;">
								<li
										style="-webkit-border-radius: 10; -moz-border-radius: 10; border-radius: 10;">
										<a href="<%=basePath%>ExcelStaffInfo/homePage.do" target="loadcontent"
								>花名册导入</a></li>
								<li><a href="<%=basePath%>AskLeaveExcel/homePage.do" target="loadcontent">请假申请</a></li>
								<li><a href="<%=basePath%>OvertimeExcel/homePage.do" target="loadcontent">加班申请</a></li>
								<li><a href="<%=basePath%>upload/toBusinessTrip.do"target="loadcontent">出差导入</a></li>
								<li><a href="<%=basePath%>ExcelItemChange/homePage.do" target="loadcontent">项目信息变动</a></li>
								<li><a href="<%=basePath%>ExcelAttendanceDetail/homePage.do" target="loadcontent">考勤明细导入</a></li>
								<li><a href="<%=basePath%>ExcelSignIn/homePage.do" target="loadcontent">签到导入</a></li>
								<li><a href="<%=basePath%>ExcelSocialSecurityInfo/homePage.do"target="loadcontent">社保信息导入</a></li>
								<li><a href="<%=basePath%>advance/toUpload.do"target="loadcontent">预付款导入</a></li>
                                <li><a href="<%=basePath%>expenseWork/expenseWork_import_page.do"target="loadcontent">办事处报销导入</a></li>

							</ul>
						</div>
					</li>
					<li>
						<div class="btn-group">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								通讯录 <span class="caret"></span>
							</a>
							<ul class="dropdown-menu" style="background-color: #3792F2;">
								<li style="-webkit-border-radius: 10; -moz-border-radius: 10; border-radius: 10;">
										<a href="<%=basePath%>userinfo/testMethod.do" target="loadcontent">通讯录</a>
								</li>
							</ul>
						</div>
					</li>
					<li>
						<div class="btn-group">
							<ul class="dropdown-menu" style="background-color: #3792F2;">
								<%--loadcontent表明页面会从下面打开，不会挡住顶边栏--%>
								<li><a href="${ctx}/userinfo/querys.do" target="loadcontent">奖金生成</a></li>
								<li><a href="${ctx}/usersalary/search_salary_page.do" target="loadcontent">工资导出</a></li>
								<%--注意这个写法需要很精确，多谢CSDN上的热心网友指点--%>
								<c:if test="${staffid eq '16462' || staffid eq '19119'}">
									<li><a href="${ctx}/userinfosalary/checkJournal.do" target="loadcontent">日报审批</a></li>
								</c:if>
							</ul>
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								工资奖金 <span class="caret"></span>
							</a>
						</div>
					</li>
					<li>
						<div class="btn-group">
							<ul class="dropdown-menu" style="background-color: #3792F2;">
								<li><a href="${ctx}/userinfo/querys.do" target="loadcontent">日报发文</a></li>
								<li style="-webkit-border-radius: 10; -moz-border-radius: 10; border-radius: 10;">
									<a href="<%=basePath%>toAskForLeave.do"  target="loadcontent">请假发文</a>
								</li>
								<li><a href="<%=basePath%>toOverTime.do" target="loadcontent">加班发文</a></li>
								<li><a href="<%=basePath%>toSocialSecurity.do" target="loadcontent">社保发文</a></li>
								<li><a href="<%=basePath%>attendance_search.do" target="loadcontent">考勤导出</a></li>
								<li><a href="<%=basePath%>advance/toAdvance_getList.do" target="loadcontent">预付款发文</a></li>
								<li><a href="<%=basePath%>expenseWork/expenseWork_page.do" target="loadcontent">办事处报销发文</a></li>
								<li><a href="<%=basePath%>loan/toLoan_operation.do" target="loadcontent">冲借款提交</a></li>
								<li><a href="<%=basePath%>loan/toLoan_approveGetList.do" target="loadcontent">冲借款审批</a></li>
								<li><a href="<%=basePath%>expenseApplyApprove/goApproveInPC.do" target="loadcontent">报销审批</a></li>

							</ul>
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								发文模块 <span class="caret"></span>
							</a>
						</div>
					</li>
					<li>

						<div class="btn-group">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								订单系统 <span class="caret"></span>
							</a>
							<ul class="dropdown-menu" style="background-color: #3792F2;">
								<li style="-webkit-border-radius: 10; -moz-border-radius: 10; border-radius: 10;">
								<a href="<%=basePath%>order/search_order_page.do" target="loadcontent">订单查询</a></li>
								<a href="<%=basePath%>PCOrderChange/pc_get_approve_un.do" target="loadcontent">项目变更后台</a></li>
							 <%--<li><a onclick="ajaxLoadPage('<%=basePath%>usersalary/search_salary_page.do')">工资查询</a></li>--%>
							</ul>
						</div>
					</li>

				</ul>
			</div>
			<div class="head-right fl">
				欢迎您！管理员&nbsp;&nbsp;&nbsp; <a href=""><img
					src="<%=path%>/images/guanbi.png" height="22" width="22" alt=""></a>
			</div>
		</div>
	</header>

	<div>
             <iframe class="weui_tab_bd " height="1000px"; frameborder="no" src="<%=basePath%>userinfo/querys.do" name="loadcontent" style="width:100%;">
			 
			 
			 </iframe>
    </div>
	<!-- <div class="row-fluid">
		<div class="footer" data-reactid=".0.a">
			<div style="margin-bottom: 5px;" data-reactid=".0.a.0">
				<span data-reactid=".0.a.0.0"> <img width="11px"
					src="https://gw.alicdn.com/tps/TB14UngLXXXXXXQapXXXXXXXXXX-22-26.png"
					data-reactid=".0.a.0.0.0"></span> <span data-reactid=".0.a.0.1">上海音达科技实业有限公司</span>
			</div>
		</div>
	</div> -->
	
</body>

<script type="text/javascript">
	
</script>
</html>
