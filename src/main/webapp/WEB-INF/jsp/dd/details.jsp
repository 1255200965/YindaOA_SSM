<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/8
  Time: 19:57
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
    <title>工资详情</title>
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
        /*引入字体图标结束*/
        html{background:#F2F2F2;color:#585A5D;}
        *{margin:0;padding:0;}
        ul{list-style: none;}
        a{text-decoration: none;}
        header{background:#2FA1F3;padding:3% 0;color:#fff;text-align:center;font-size:18px;}
        header a{color:#fff;display: inline-block;float:left;margin-top:-1%;}

        .content .cont-tit{background:#F2F2F2;font-size:16px;padding:3% 0;}
        .content .cont-details ul li{overflow: hidden;padding:3% 0;border-bottom:1px solid #E4E4E4;background:#fff;}
        .content .cont-details ul li .details-l{float:left;text-align:left;}
        .content .cont-details ul li .details-r{float:right;text-align:right;}
    </style>
</head>
<body>
<header>
    <a href="<%=basePath%>user/phone-salary.do"><i class="iconfont">&#xe82f;</i></a>
    工资详情（2016年10月）
</header>
<div class="content">
    <div class="cont-tit">
        详细数据
    </div>
    <div class="cont-details">
        <ul>
            <li>
                <p class="details-l">工资月份</p>
                <p class="details-r">2016年10月</p>
            </li>
            <li>
                <p class="details-l">基本工资</p>
                <p class="details-r">0.00</p>
            </li>
            <li>
                <p class="details-l">奖金</p>
                <p class="details-r">0.00</p>
            </li>
            <li>
                <p class="details-l">个税代扣</p>
                <p class="details-r">0.00</p>
            </li>
            <li>
                <p class="details-l">扣款</p>
                <p class="details-r">0.00</p>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
