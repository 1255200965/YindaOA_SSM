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

<body class="import">

    <p>提交不成功的错误列表</p>
    <p>${download}</p>

    <table>
        <tr>
            <th>姓名</th>
            <th>年龄</th>
            <th>会不会打DOTA</th>
            <th>有没有听过09唱的“我不能忍”</th>
        </tr>
        <tr>
            <td>姓名</td>
            <td>年龄</td>
            <td>会不会打DOTA</td>
            <td>有没有听过09唱的“我不能忍”</td>
        </tr>
    </table>
</body>

<script>
    var i = 0;
    var bg = null;
    var color = null;

    document.write('<table border="1" align="center" width="500">');
    while(i < 100){
        if(i % 10 == 0){
            if(i % 20 == 0)
                bg="#cccccc";
            else
                bg="#ffffff";
            document.write('<tr align="center" onmouseover="showBG(this)" onmouseout="unShowBG(this)" bgcolor="'+ bg +'">');
        }

        document.write('<td>' + i + '</td>');
        i++;

        if(i % 10 == 0){
            document.write('</tr>');
        }
    }
    document.write('</table>');

    function showBG(obj){
        color = obj.bgColor;
        obj.bgColor = "orange";
    }

    function unShowBG(obj){
        obj.bgColor = color;
    }
</script>

</html>