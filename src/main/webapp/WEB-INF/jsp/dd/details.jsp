<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/8
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL标签引入 -->
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
        .content .cont-details ul li .details-l{float:left;text-align:left;margin-left: 10px;}
        .content .cont-details ul li .details-r{float:right;text-align:right;margin-right: 10px;}
    </style>
</head>
<script>


</script>
<body>
<header>
   <%-- <a href="<%=basePath%>user/phone-salary.do"><i class="iconfont">&#xe82f;</i></a>--%>
    工资详情
</header>
<div class="content">
    <div class="cont-tit">
        详细数据
    </div>
    <div class="cont-details">
        <ul>
            <li>
                <p class="details-l">工资月份</p>
                <p class="details-r">${list.salarydate }</p>
            </li>
            <li>
                <p class="details-l">基本工资</p>
                <p class="details-r">${list.baseSalary }</p>
            </li>
            <li>
                <p class="details-l">当月满勤天数</p>
                <p class="details-r">${list.datetype }</p>
            </li>
            <li>
                <p class="details-l">当月实际考勤天数</p>
                <p class="details-r">${list.realityattendance }</p>
            </li>
            <li>
                <p class="details-l">当月有效打卡天数</p>
                <p class="details-r">${list.effectiveattendance }</p>
            </li>
            <li>
                <p class="details-l">请假天数</p>
                <p class="details-r">${list.leavetype }</p>
            </li>
            <li>
                <p class="details-l">有效加班天数</p>
                <p class="details-r">${list.workovertime }</p>
            </li>
            <li>
                <p class="details-l">加班补贴</p>
                <p class="details-r">${list.worksalary }</p>
            </li>
            <li>
                <p class="details-l">小计</p>
                <p class="details-r">${list.subtotal }</p>
            </li>
            <li>
                <p class="details-l">有效出差天数</p>
                <p class="details-r">${list.evection }</p>
            </li>
            <li>
                <p class="details-l">出差补贴</p>
                <p class="details-r">${list.allowance }</p>
            </li>
            <li>
                <p class="details-l">高温补贴</p>
                <p class="details-r">${list.heatingAllowance }</p>
            </li>
            <li>
                <p class="details-l">公交地铁费</p>
                <p class="details-r">${list.trafficsalary }</p>
            </li>
            <li>
                <p class="details-l">timebase奖金</p>
                <p class="details-r">${list.timesalary }</p>
            </li>
            <li>
                <p class="details-l">taskbase奖金</p>
                <p class="details-r">${list.tasksalary }</p>
            </li>
            <li>
                <p class="details-l">部门奖金</p>
                <p class="details-r">${list.userbonus }</p>
            </li>
            <li>
                <p class="details-l">社保代扣</p>
                <p class="details-r">${list.socialdecase }</p>
            </li>
            <li>
                <p class="details-l">税前收入总计</p>
                <p class="details-r">${list.totalsalary }</p>
            </li>
            <li>
                <p class="details-l">当月工资</p>
                <p class="details-r">${list.monthSalary }</p>
            </li>
            <li>
                <p class="details-l">当月工资所得税</p>
                <p class="details-r">${list.tax }</p>
            </li>
            <li>
                <p class="details-l">当月工资实发</p>
                <p class="details-r">${list.realsalary }</p>
            </li>
            <li>
                <p class="details-l">当月预发奖金</p>
                <p class="details-r">${list.monthBonus }</p>
            </li>
            <li>
                <p class="details-l">当月预发奖金所得税</p>
                <p class="details-r">${list.monthBonusTax }</p>
            </li>
            <li>
                <p class="details-l">当月预发奖金实发</p>
                <p class="details-r">${list.monthBonusReal }</p>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
