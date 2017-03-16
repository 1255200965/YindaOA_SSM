<%--这一行是JSP页面的必要标识--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--自定义一个标签，允许调用tags里的文件--%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%--定义c标签--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--把上下文变成ctx--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>

<head>
    <title>journal</title>
    <!-- head中的必要声明 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%--加载table样式文件--%>
    <link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/salary/table.css" />
</head>
<body>
    <p class="p-middle">这个页面是每个人的日报，更改数据后再次提交可以回到总表。</p>
    <br>

    <table class="daily">
        <tr>
            <th style="width: 7%">工号</th>
            <th style="width: 7%">姓名</th>
            <th style="width: 7%">日期</th>
            <th style="width: 7%">项目</th>
            <th style="width: 7%">订单</th>
            <th style="width: 7%">订单地市</th>
            <th style="width: 7%">请假类型</th>
            <th style="width: 7%">考勤地市</th>
            <th style="width: 7%">是否有效考勤</th>
            <th style="width: 7%">签到地市</th>
            <th style="width: 7%">是否有效签到</th>
            <th style="width: 7%">是否有效加班</th>
            <th style="width: 7%">是否有效出差</th>
        </tr>

        <c:forEach var="entity" items="${journal}">
            <tr>
                <td>${entity.staffid}</td>
                <td>${entity.name}</td>
                <td>${entity.date}</td>
                <td>${entity.project}</td>
                <td>${entity.orderName}</td>
                <td>${entity.orderProcity}</td>
                <td>${entity.askLeaveType}</td>
                <td>${entity.attProcity}</td>
                <td><input value=${entity.whetherEffAtt}></td>
                <td>${entity.signProcity}</td>
                <td><input value=${entity.whetherEffSign}></td>
                <td><input value=${entity.whetherEffOt}></td>
                <td><input value=${entity.whetherEffBt}></td>
            </tr>
        </c:forEach>
    </table>

    <p class="p-middle">
        <a href="${ctx}/loginSuccess.do"><button class="btn-submit">一键提交</button></a>
    </p>
</body>
</html>
