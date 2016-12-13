<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>

<head>
    <title>文件导入结果</title>
    <%--引入excel文件夹的统一样式--%>
    <link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/excel.css" />
    <script src="../javascripts/jquery.min.js"></script>
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
            <th style="width: 15%">员工UserID</th>
            <th style="width: 30%">部门</th>
            <th style="width: 10%">姓名</th>
            <th style="width: 10%">工号</th>
            <th style="width: 17%">手机号</th>
            <th style="width: 18%">身份证号</th>
        </tr>
        <c:forEach var="item" items="${listFail}">
            <tr>
                <td>${item.staffUserId}</td>
                <td>${item.department}</td>
                <td>${item.name}</td>
                <td>${item.staffId}</td>
                <td>${item.cellphone}</td>
                <td>${item.idNo}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="${ctx}/ExcelStaffInfo/homePage.do"><button>返回上一页</button></a>

</body>

<script type="text/JavaScript">
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