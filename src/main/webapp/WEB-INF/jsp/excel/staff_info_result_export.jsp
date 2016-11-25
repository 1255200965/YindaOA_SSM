<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>

<head>
    <title>花名册导出结果</title>
    <%--引入excel文件夹的统一样式--%>
    <link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/excel.css" />
</head>

<%--导出页面的样式都写在export类下--%>
<body class="export">
    <h1>标题：数据表导出成功！</h1>
    <h2>成功导出的数据表名为：${tableName}</h2>
    <h2>导出路径：${path}</h2>
    <h2>导出的excel文件的列数：${columnAmount}</h2>
    <h2>导出耗时：${cost}</h2>
    <h2>共计导出条目数：${successAmount}</h2>
    <h2 class="warm">温馨提示：为保持磁盘清洁，请用完后及时清理文件！</h2>
    <%--button要放在a标签里面，不然会有很多问题--%>
    <a href="${ctx}/ExcelStaffInfo/homePage.do"><button>返回上一页</button></a>
</body>

</html>