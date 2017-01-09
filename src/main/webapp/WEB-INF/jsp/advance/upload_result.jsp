<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>

<head>
    <title>预付款导入结果反馈</title>
    <%--引入excel文件夹的统一样式--%>
    <link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/excel.css" />
</head>

<%--导出页面的样式都写在export类下--%>
<body class="export">
    <h1>标题：预付款导入结果反馈！</h1>
    <table>
       <thead>
        <tr>
          <th>导入结果</th>
          <th>具体异常说明</th>
        </tr>
       </thead>
       <tbody>
       <c:if test="${errorList eq null || errorList.size()==0 }">
          <tr>
         	<td><h2>导入成功</h2></td>
         	<td><h2></h2></td>
         </tr>
       </c:if>
       <c:forEach items="${errorList }" var="error">
         <tr>
         	<td><h2>${error[0]}</h2></td>
         	<td><h2>${error[1]}</h2></td>
         </tr>
       </c:forEach>
       </tbody>
    </table>
    <br/>
    <a href="javascript:history.go(-1)">返回上一级</a>
</body>

</html>