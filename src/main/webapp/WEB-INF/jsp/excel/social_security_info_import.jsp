<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>

<head>
    <title>文件导入结果</title>
    <%--引入excel文件夹的统一样式--%>
    <link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/excel.css" />
</head>

<body class="import">
    <h1>文件导入结果：</h1>
    <h2>成功导出的数据表名为：社保详细信息</h2>
    <h2>文件上传成功！</h2>
    <h2>表头效验成功！</h2>
    <h2>导入耗时：${cost}</h2>
    <h2>上传成功的条目数目为：${successAmount}</h2>
    <h2>上传失败的条目数目为：${failAmount}</h2>
    <h2 class="small_title">提交不成功的信息列表：</h2>
    <table>
        <tr>
            <th style="width: 20%">姓名</th>
            <th style="width: 20%">工号</th>
            <th style="width: 30%">分公司</th>
            <th style="width: 30%">交金地</th>
        </tr>
        <c:forEach var="item" items="${listFail}">
            <tr>
                <td>${item.ssiName}</td>
                <td>${item.ssiStaffId}</td>
                <td>${item.ssiBranchCompany}</td>
                <td>${item.ssiSecurityAddress}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="${ctx}/ExcelSocialSecurityInfo/homePage.do"><button>返回上一页</button></a>
</body>

</html>