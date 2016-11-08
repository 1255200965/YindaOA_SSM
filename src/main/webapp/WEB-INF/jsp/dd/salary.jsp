<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/8
  Time: 16:30
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
    <title>个人财务</title>

    <!-- 日期插件引入文件 -->
    <script src="<%=basePath%>/datePlug/js/jquery.1.7.2.min.js"></script>
    <script src="<%=basePath%>/datePlug/js/mobiscroll_002.js" type="text/javascript"></script>
    <script src="<%=basePath%>/datePlug/js/mobiscroll_004.js" type="text/javascript"></script>
    <link href="<%=basePath%>/datePlug/css/mobiscroll_002.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath%>/datePlug/css/mobiscroll.css" rel="stylesheet" type="text/css">
    <script src="<%=basePath%>/datePlug/js/mobiscroll.js" type="text/javascript"></script>
    <script src="<%=basePath%>/datePlug/js/mobiscroll_003.js" type="text/javascript"></script>
    <script src="<%=basePath%>/datePlug/js/mobiscroll_005.js" type="text/javascript"></script>
    <link href="<%=basePath%>/datePlug/css/mobiscroll_003.css" rel="stylesheet" type="text/css">
    <!--日期插件引入文件结束  -->
    <link rel="stylesheet" href="../stylesheets/buttons.css">
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
        header{background:#2FA1F3;overflow: hidden;position: fixed;top:0;width:100%;padding:4% 0;color:#fff;box-shadow: 0px 5px 40px #000;}
        /*        header .person-pho{width:12%;float:left;margin-left:1%;}
                header .person-pho img{width:100%;border-radius: 50%;display: block;vertical-align: middle;}
                header .person-msg{float:left;padding-top:3%;font-size: 20px;}
                header .head-ser{float:right;padding-top:3%;}*/
        header .head-ico{border-right:1px solid #E5E5E5;padding:0 2%;margin:0.3% 3% 0.3% 0;}
        header .head-msg,header .head-ser{line-height:1.5;}
        header .head-ser{margin-right:2%;}

        .content{margin-top:12%;background:#F2F2F2;}
        .content .content-top{background:#2FA1F3;}
        .content .content-top .affair-msg{border-bottom: 1px solid #fff;padding:8% 0 2% 0;}
        .content .content-top .affair-msg p{text-align: center;font-size: 16px;color:#fff;}
        .content .content-top .affair-msg p:nth-child(2){font-size:45px;margin:2% 0;}
        .content .content-top .other{overflow:hidden;}
        .content .content-top .other a{display:block;width:33%;padding:4% 0;float:left;border-right:1px solid #fff;text-align: center;color:#fff;}
        .content .content-top .other a:nth-child(3){border:transparent;}
        .content .content-ser .tit-1{padding:3% 0;background:#fff;border-top:1px solid #E4E4E4;border-bottom:1px solid #E4E4E4;margin-top:2%;}
        .content .content-ser  .tit-1 p{font-size: 14px;margin-left:2%;}
        .content .content-ser .ser-details{margin-top:1%;overflow: hidden;}
        .content .content-ser .ser-details .person-pho{width:12%;float:left;margin-left:1%;}
        .content .content-ser .ser-details .person-pho img{width:100%;border-radius: 50%;}
        .content .content-ser .ser-details .person-msg{float:left;padding-top:4%;font-size: 14px;}
        .content .content-ser .ser-details .ser-date{font-size:14px;width:60%;}
        .content .content-ser .ser-details .ser-date input{display: inline-block;width: 28%;height:40px;border-radius: 10px; border: 1px solid #D5E5FF;text-align: center;color: #2FA1F3;}
        .content .content-ser .ser-details button{background:#2FA1F3;color:#fff;font-size:16px;border:none;border-radius: 5px;padding:0;width:30%;}

        /*        .content .content-ser .ser-details{margin-top:1%;overflow: hidden;}
                .content .content-ser .ser-details .person-pho{width:12%;float:left;margin-left:1%;}
                .content .content-ser .ser-details .person-pho img{width:100%;border-radius: 50%;}
                .content .content-ser .ser-details .person-msg{float:left;padding-top:4%;font-size: 14px;}
                .content .content-ser .ser-details .ser-date{float:right;margin-top:4%;font-size:14px;margin-right:2%;width:50%;}
                .content .content-ser .ser-details .ser-date input{display:inline-block;width:45%;}*/
    </style>
</head>
<body>
<div class="box">
    <header>
        <div class="head-ico fl"><i class="iconfont">&#xe82f;</i></div>
        <div class="head-msg fl">上海音达科技实业有限公司</div>
        <div class="head-ser fr">帮助</div>
    </header>
    <div class="content">
        <div class="content-top">
            <div class="affair-msg">
                <p>10月总收入（元）</p>
                <p>0.00</p>
                <p><a href="">点击查看详情</a></p>
            </div>
            <div class="other">
                <a href="#">工资</a>
                <a href="#">工作日历</a>
                <a href="#">其他</a>
            </div>
        </div>

        <div class="content-ser">
            <!--                     <div class="tit-1">
                                    <p>历史工资查询</p>
                                </div> -->
            <div class="ser-details">
                <!--                         <div class="person-pho"><img src="img/I.JPG" alt=""></div>
                                        <div class="person-msg">上海音达，Rose</div> -->
                <div class="ser-date fl">请选择日期：<input value="" class="" readonly="readonly" name="appDate" id="appDate" type="text" ></div>
                <button class="button button-raised button-rounded button-royal">查询</button>
            </div>
        </div>
    </div>
</div>
<script src="http://g.alicdn.com/dingding/open-develop/0.8.4/dingtalk.js"></script>
<script>
    // ----------------日期插件代码开始
    $(function () {
        var currYear = (new Date()).getFullYear();
        var opt={};
        opt.date = {preset : 'date'};
        opt.datetime = {preset : 'datetime'};
        opt.time = {preset : 'time'};
        opt.default = {
            theme: 'android-ics light', //皮肤样式
            display: 'modal', //显示方式
            mode: 'scroller', //日期选择模式
            dateFormat: 'yyyy-mm',
            lang: 'zh',
            showNow: true,
            nowText: "今天",
            startYear: currYear - 10, //开始年份
            endYear: currYear + 10 //结束年份
        };

        $("#appDate").mobiscroll($.extend(opt['date'], opt['default']));
        var optDateTime = $.extend(opt['datetime'], opt['default']);
        var optTime = $.extend(opt['time'], opt['default']);
        $("#appDateTime").mobiscroll(optDateTime).datetime(optDateTime);
        $("#appTime").mobiscroll(optTime).time(optTime);
    });
    // -----------------------日期插件代码结束
</script>

</body>
</html>

