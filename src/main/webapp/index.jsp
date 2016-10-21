<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<body>
<h2>上海音达科技实业有限公司人事管理后台</h2>

<h5><a href="<%=basePath%>userinfo/testMethod.do">进入用户管理页</a></h5>
</body>
</html>
