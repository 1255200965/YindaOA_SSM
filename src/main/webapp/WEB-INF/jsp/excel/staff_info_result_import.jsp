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
    <h2>成功导出的数据表名为：花名册</h2>
    <h2>文件上传成功！</h2>
    <h2>表头效验成功！</h2>
    <h2>上传成功的条目数目为：${successAmount}</h2>
    <h2>上传失败的条目数目为：${failAmount}</h2>
    <h2 class="small_title">提交不成功的信息列表：</h2>
    <table>
        <tr>
            <th>员工UserID</th>
            <th>部门</th>
            <th>姓名</th>
            <th>工号</th>
            <th>手机号</th>
            <th>身份证号</th>
        </tr>
    </table>
    <a href="${ctx}/ExcelStaffInfo/homePage.do"><button>返回上一页</button></a>
</body>

<script>
    <c:forEach items="${listFail}">
        // 首先定义一个列表，用于存放要填的内容
        var contentList = new Array();
        contentList.push("${staffUserId}");
        contentList.push("${apartment}");
        contentList.push("${name}");
        contentList.push("${staffId}");
        contentList.push("${cellphone}");
        contentList.push("${idNo}");

        var tableList = document.getElementsByTagName("table");
        var table = tableList[0];

        var rowAmount = table.rows.length;
        var newRow = table.insertRow(rowAmount);
        for (var i=0; i<contentList.length; i++) {
            var cell = newRow.insertCell(i);
            cell.innerHTML = contentList[i];
        }
    </c:forEach>

//    document.write('<table border="1" align="center" width="500">');
//    while(i < 100){
//        if(i % 10 == 0){
//            if(i % 20 == 0)
//                bg="#cccccc";
//            else
//                bg="#ffffff";
//            document.write('<tr align="center" onmouseover="showBG(this)" onmouseout="unShowBG(this)" bgcolor="'+ bg +'">');
//        }
//
//        document.write('<td>员工UserID</td>');
//        i++;
//
//        if(i % 10 == 0){
//            document.write('</tr>');
//        }
//    }
//    document.write('</table>');
//
//    function showBG(obj){
//        color = obj.bgColor;
//        obj.bgColor = "orange";
//    }
//
//    function unShowBG(obj){
//        obj.bgColor = color;
//    }
</script>

</html>