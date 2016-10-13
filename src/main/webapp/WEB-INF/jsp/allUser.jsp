<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ma
  Date: 2016/10/13
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

<link type="text/css" rel="stylesheet" href="../../stylesheets/style.css" />
<link href="../stylesheets/bootstrap.min.css" rel="stylesheet" />
<link href="../stylesheets/shujutongji.css" rel="stylesheet" />
<script type="text/javascript" src="../javascripts/jquery-1.10.2.js"></script>
<script type="text/javascript" src="../javascripts/bootstrap.min.js"></script>
<head>
    <title>人员列表显示</title>
</head>

<body>
<table border="1">
    <tbody>
    <tr>
        <th>姓名</th>
        <th>年龄</th>
    </tr>
    <c:if test="${!empty listUser }">
        <c:forEach items="${listUser}" var="list">
            <tr>
                <td>${list.username }</td>
                <td>${list.age }</td>

            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>
