<%--这一行是JSP页面的必要标识--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--自定义一个标签，允许调用tags里的文件--%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%--开启c标签的使用--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--定义变量ctx代表上下文路径--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>

<head>
    <title>journal</title>
    <!-- head中的必要声明 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="../stylesheets/reset.css">

    <link href="${ctx}/stylesheets/bootstrap.min.css" rel="stylesheet" />
    <link href="${ctx}/stylesheets/bootstrap-theme.min.css" rel="stylesheet" />
    <link href="${ctx}/stylesheets/bootstrap-treeview.min.css" rel="stylesheet" />
    <link href="${ctx}/stylesheets/shujutongji.css" rel="stylesheet" />
    <link href="${ctx}/stylesheets/ddcss.css" rel="stylesheet" />
    <link rel="stylesheet" href="${ctx}/stylesheets/header.css">

    <%--加载table样式文件--%>
    <link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/salary/table.css" />
</head>
<body>
    <%--加一个上边距，没有办法的办法--%>
    <p></p><br><br>
    <table  width="100%" border="1" cellspacing="0" cellpadding="0" class="table-1 daily">
        <thead class="table-1-tou " >
            <th style="width: 5%">日报编号</th>
            <th style="width: 5%">工号</th>
            <th style="width: 5%">姓名</th>
            <th style="width: 5%">日期</th>
            <th style="width: 5%">日期类型</th>
            <th style="width: 5%">当前部门</th>
            <th style="width: 5%">当前项目</th>
            <th style="width: 8%">订单</th>
            <th style="width: 5%">商务属性</th>
            <th style="width: 5%">当前出勤状态</th>
            <th style="width: 5%">申请人</th>
            <th style="width: 12%">申请原因</th>
            <th style="width: 4%">日报状态</th>
            <th style="width: 7%">操作</th>
        </thead>

        <c:forEach var="entity" items="${journal}">
            <tr>
                <td>${entity.seqNo}</td>
                <td>${entity.staffid}</td>
                <td>${entity.name}</td>
                <td>${entity.date}</td>
                <td>${entity.dateType}</td>
                <td>${entity.ordDepart}</td>
                <td>${entity.project}</td>
                <td>${entity.orderName}</td>
                <td>${entity.businessAttribute}</td>
                <td>${entity.whetherEffAtt}</td>
                <td>${entity.applyPerson}</td>
                <td>${entity.effectReason}</td>
                <td>${entity.journalState}</td>
                <td>
                    <%--a标签本不占空间，嵌入button后被其撑大--%>
                    <%--点打回后，只变日报状态。点通过后，先变日报和工资，再变状态。考虑到黄照香的习惯，打回放在前面--%>
                    <a href="${ctx}/userinfosalary/rejectJournal.do?seqNo=${entity.seqNo}&&staffid=${entity.staffid}"><button>打回</button></a>
                    <a style="margin-left: 20px" href="${ctx}/userinfosalary/approveJournal.do?seqNo=${entity.seqNo}&&staffid=${entity.staffid}"><button>通过</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <p class="p-middle">
        <a href="javascript:history.go(-1)"><button class="btn-submit">返回上一页</button></a>
    </p>
</body>
</html>
