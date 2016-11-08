<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/8
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0">
    <title>考勤月历</title>
    <style>
        /*引入字体图标*/
        @font-face {
            font-family: 'iconfont';
            src: url('<%=basePath%>/fonts/iconfont/iconfont.eot'); /* IE9*/
            src: url('<%=basePath%>/fonts/iconfont/iconfont.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
            url('<%=basePath%>/fonts/iconfont/iconfont.woff') format('woff'), /* chrome、firefox */
            url('<%=basePath%>/fonts/iconfont/iconfont.ttf') format('truetype'), /* chrome、firefox、opera、Safari, Android, iOS 4.2+*/
            url('<%=basePath%>/fonts/iconfont/iconfont.svg#iconfont') format('svg'); /* iOS 4.1- */
        }
        .iconfont{
            font-family:"iconfont" !important;
            font-size:25px;font-style:normal;
            -webkit-font-smoothing: antialiased;
            -webkit-text-stroke-width: 0.2px;
            -moz-osx-font-smoothing: grayscale;
        }
        /*样式重置*/
        *{margin:0;padding:0;}
        ul li{list-style:none;}
        a{text-decoration: none;}
        .fl{float:left;}
        .fr{float:right;}
        /*样式*/
        html{background:#F2F2F2;color:#585A5D;}
        header{background:#2FA1F3;overflow: hidden;position: fixed;top:0;width:100%;padding:4% 0;color:#fff;}
        header .head-ico{border-right:1px solid #E5E5E5;padding:0 2%;margin:0.3% 3% 0.3% 0;}
        header .head-msg,header .head-ser{line-height:1.5;}
        header .head-ser{margin-right:2%;}
    </style>
</head>
<body>
<div class="box">
    <header>
        <div class="head-ico fl"><i class="iconfont">&#xe82f;</i></div>
        <div class="head-msg fl">工时明细</div>
        <div class="head-ser fr">帮助</div>
    </header>
</div>
</body>
</html>
