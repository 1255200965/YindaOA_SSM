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
    <meta name="format-detection" content="telephone=no"/>

    <script src="<%=basePath%>/javascripts/jquery-1.10.2.js"></script>
    <link href="<%=basePath%>/datePlug/mobiscroll.custom-2.5.0.min.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>/datePlug/mobiscroll.custom-2.5.0.min.js" type="text/javascript"></script>
    <!--日期插件引入文件结束  -->
    <link rel="stylesheet" href="<%=basePath%>/stylesheets/buttons.css">
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
        .content .content-top .other a{display:block;width:33%;padding:4% 0;float:left;border-right:1px solid #fff;border-bottom:1px solid #fff;text-align: center;color:#fff;}
        .content .content-top .other a:nth-child(3){border-right:transparent;}
        .content .content-top .other a:nth-child(6){border-right:transparent;}

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
                <p><a href="<%=basePath%>user/phone-details.do">点击查看详情</a></p>
            </div>
            <div class="other">
                <a href="<%=basePath%>user/phone-kaoqin.do">考勤</a>
                <a href="<%=basePath%>user/phone-kaoqin.do">加班日历</a>
                <a href="<%=basePath%>user/phone-kaoqin.do?date=201611&type=1">请假天数</a>
                <a href="<%=basePath%>user/phone-kaoqin.do)">出差</a>
                <a href="javascript:void(0)" onclick="openLink('<%=basePath%>user/phone-kaoqin.do')">项目</a>
                <a href="javascript:void(0)" onclick="openLink('<%=basePath%>user/phone-details.do')">其他</a>
            </div>
        </div>

        <div class="content-ser">
            <!--                     <div class="tit-1">
                                    <p>历史工资查询</p>
                                </div> -->
            <div class="ser-details">
                <!--                         <div class="person-pho"><img src="img/I.JPG" alt=""></div>
                                        <div class="person-msg">上海音达，Rose</div> -->
                <div class="ser-date fl">请选择日期：<input id="scroller" name="scroller"></div>
                <button class="button button-raised button-rounded button-royal" onclick="initSalary()">查询</button>
            </div>
        </div>

        <input id="userid" style="display: none;">
        <input id="code" style="display: none;">
    </div>
</div>
<script src="http://g.alicdn.com/dingding/open-develop/0.8.4/dingtalk.js"></script>
<script>
//  日期插件代码开始
$(function(){
    $("#scroller").mobiscroll().date();

    var currYear = (new Date()).getFullYear();

    //初始化日期控件
    var opt = {
        preset: 'date', //日期，可选：date\datetime\time\tree_list\image_text\select
        theme: 'android-ics light', //皮肤样式，可选：default\android\android-ics light\android-ics\ios\jqm\sense-ui\wp light\wp
        display: 'modal', //显示方式 ，可选：modal\inline\bubble\top\bottom
        mode: 'scroller', //日期选择模式，可选：scroller\clickpick\mixed
        lang:'zh',
        dateFormat: 'yyyy-mm', // 日期格式
        setText: '确定', //确认按钮名称
        cancelText: '取消',//取消按钮名籍我
        dateOrder: 'yyyymm', //面板中日期排列格式
        monthText: '月', yearText: '年', //面板中年月日文字
        showNow: false,
        nowText: "今",
        startYear:currYear, //开始年份
        endYear:currYear + 100 //结束年份
        //endYear:2099 //结束年份
    };

    $("#scroller").mobiscroll(opt);
});
//  日期插件代码结束

</script>

<script type="text/javascript">
    //在此拿到权限验证配置所需要的信息
    var _config = <%= com.ddSdk.auth.AuthHelper.getConfig(request) %>;
    //当前用户，当前时间
    var nowUser = null;
    var nowTime = null;

    var qs = <%= request.getAttribute("msg") %>;
    if (qs == null || qs == "NO!") {
        //alert("没有邮箱！");
        $("#email").text("");
        $("#password").text("");
    }
    //配置钉钉jsapi
    dd.config({
        agentId: _config.agentid,
        corpId: _config.corpId,
        timeStamp: _config.timeStamp,
        nonceStr: _config.nonceStr,
        signature: _config.signature,
        jsApiList: ['runtime.info', 'biz.contact.choose',
            'device.notification.confirm', 'device.notification.alert',
            'device.notification.prompt', 'biz.ding.post',
            'biz.util.openLink', 'device.geolocation.get', 'biz.map.view', 'biz.map.locate']
    });

    dd.ready(function () {
        //获取免登授权码
        dd.runtime.permission.requestAuthCode({
            corpId: _config.corpId,
            onSuccess: function (result) {
                /*{
                 code: 'hYLK98jkf0m' //string authCode
                 }*/
                $("#code").val(result.code);
            },
            onFail: function (err) {
            }

        });
        //获取容器信息
        dd.runtime.info({
            onSuccess: function (info) {
                logger.e('runtime info: ' + JSON.stringify(info));
            },
            onFail: function (err) {
                logger.e('fail: ' + JSON.stringify(err));
            }
        });
        //允许下拉刷新
        dd.ui.pullToRefresh.enable({
            onSuccess: function () {
            },
            onFail: function () {
            }
        })
        //设置菜单栏
        dd.biz.navigation.setMenu({
            backgroundColor: "#ADD8E6",
            items: [
                {
                    id: "此处可以设置帮助",//字符串
                    // "iconId":"file",//字符串，图标命名
                    text: "帮助"
                }
                ,
                {
                    "id": "2",
                    "iconId": "photo",
                    "text": "我们"
                }
                ,
                {
                    "id": "3",
                    "iconId": "file",
                    "text": "你们"
                }
                ,
                {
                    "id": "4",
                    "iconId": "time",
                    "text": "他们"
                }
            ],
            onSuccess: function (data) {
                alert(JSON.stringify(data));

            },
            onFail: function (err) {
                alert(JSON.stringify(err));
            }
        });
        //获取个人信息
        dd.biz.user.get({
            onSuccess: function (info) {
                logger.e('userGet success: ' + JSON.stringify(info));
                //{id:staff_user_id,nickName:name}
                $("#userid").val(info.id);
                nowUser = info.id;
            },
            onFail: function (err) {
                logger.e('userGet fail: ' + JSON.stringify(err));
            }
        });
        initSalary();
    });
    //打开链接
    function openLink(url) {
        dd.biz.util.openLink({
            name:url,//页面名称
            params:{"date":nowTime},//传参
            onSuccess: function (result) {
            },
            onFail: function (err) {
                alert(JSON.stringify(err));
            }
        });
    }
    //显示信息
    function showMsg(Msg) {
        dd.device.notification.alert({
            message: Msg,
            title: "message",//可传空
            buttonName: "收到",
            onSuccess: function () {
                //onSuccess将在点击button之后回调
                /*回调*/
            },
            onFail: function (err) {
            }
        });
    }
    function initSalary(){
        //输入用户id，日期,返回工资对象
        nowTime = $("#scroller").val();
        alert("当前用户是:"+nowUser + "\n当前日期是:" + nowTime);
    }
</script>
</body>
</html>

