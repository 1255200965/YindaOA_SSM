<%--
  Created by IntelliJ IDEA.
  User: ma
  Date: 2016/10/20
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>

    <title>导入通讯录</title>
    <link rel="stylesheet" href="../stylesheets/reset.css">
    <link rel="stylesheet" href="../stylesheets/buttons.css">
    <link href="../stylesheets/bootstrap.min.css" rel="stylesheet" />
    <link href="../stylesheets/bootstrap-theme.min.css" rel="stylesheet" />
    <link href="../stylesheets/bootstrap-treeview.min.css" rel="stylesheet" />
    <link href="../stylesheets/shujutongji.css" rel="stylesheet" />
    <link href="../stylesheets/ddcss.css" rel="stylesheet" />
    <link rel="stylesheet" href="../stylesheets/header.css">

    <script type="text/javascript" src="../javascripts/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="../javascripts/bootstrap.min.js"></script>
    <script type="text/javascript" src="../javascripts/bootstrap-treeview.min.js"></script>
    <script src="../javascripts//knockout-3.4.0rc.js"></script>
    <style>
        .clear-margin{margin:0;padding:0;}
        *{box-sizing: content-box;-webkit-box-sizing: content-box;}
        .c_box{width:1350px;margin-top:20px;border:none;}
        .c_box .col-md-2{width:189px;}
        .c_box .c_right_box {width:1056.7px;}
        .c_box .tab-content .form-bg{background:#fff;}
        .c_box  .active{background:#fff;}

        .file {
            position: relative;
            display: inline-block;
            background: #D0EEFF;
            border: 1px solid #99D3F5;
            border-radius: 4px;
            padding: 4px 12px;
            overflow: hidden;
            color: #1E88C7;
            text-decoration: none;
            text-indent: 0;
            line-height: 20px;
        }
        .file input {
            position: absolute;
            font-size: 100px;
            right: 0;
            top: 0;
            opacity: 0;
        }
        .file:hover {
            background: #AADFFD;
            border-color: #78C3F3;
            color: #004974;
            text-decoration: none;
        }
    </style>

<script>
    function showFile(id){
        var filepath = $("#filename"+id).val();
        $("#upfilename"+id).html(filepath);
    }
    function check_upload(theform,id)
    {
        var filename = document.getElementById("filename"+id).value;
        if(filename == "" ||filename == null || filename.indexOf(".xls")==-1){
            //alert('只能上传.xlsx文件');
            $("#upfilename"+id).html("只能上传.xls文件");
            return false;
        }
    }
    function downloadTemplate(){
        //window.open('../template/templateUserInfo.xls');
        window.location.href="../template/templateUserInfo.xls";
    }
    function checkInit(id){
        $('#mytab a[href="#tab' + id +'"]').tab('show');
        var msgTip = "${error}";
        if (msgTip != "") {
            $("#upfilename" + id).html(msgTip);
        } else{
            var validate_msg = "${validate}";
            var upfilename = "${filename}";
            var success_msg = "${successAmount}";
            if (validate_msg != "") {
                $("#upfilename"+id).html(upfilename);
                $("#checkmsg"+id).html(validate_msg);
                $("#successmsg"+id).html("成功导入数:"+success_msg);
            } else{
                var row_msg = "${row}";
                var column_msg = "${column}";
                var reason_msg = "${reason}";
                $("#upfilename"+id).html(upfilename);
                $("#checkmsg"+id).html("文件校验失败！");
                $("#successmsg"+id).html("行:"+row_msg+" 列:"+column_msg+" 出错！<br/>原因:"+reason_msg);
            }
        }
    }
    $(document).ready(function () {
        var type = "${tab}";
        if (type != "") checkInit(type);

            var ViewModel = function (){};
            ko.applyBindings(new ViewModel);
        });
    </script>
</head>
<body>

<div class="container-fluid clear-margin">
    <header>
        <div class="head-cont">
            <div class="head-left fl">
                <img src="../images/logo.png" height="35" width="50" alt="">
                人事管理系统
            </div>
            <div class="head-nav fl" id="h-nav">
                <ul>
                    <li><a class="active" data-bind="attr: { href: '<%=basePath%>userinfo/import.do'}">人员导入</a></li>
                    <li><a data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}">通讯录</a></li>
                    <li><a data-bind="attr: { href: '<%=basePath%>Import/navigator.do'}">审批数据导入</a></li>
                    <li><a data-bind="attr: { href: '<%=basePath%>userinfo/test.do'}">工资查询</a></li>
                    <li><a data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}">关于我们</a></li>
                </ul>
            </div>
            <div class="head-right fl">
                欢迎您！管理员&nbsp;&nbsp;&nbsp;
                <a href=""><img src="../images/guanbi.png" height="22" width="22" alt=""></a>
            </div>
        </div>
    </header>
    <%--<div class="row-fluid top-tiku">--%>
        <%--<div class="top-left"> <img src="../images/logo.png" />--%>
            <%--<p>人事管理系统</p>--%>
        <%--</div>--%>
        <%--<div id="box">--%>
            <%--<script language="javascript">          function switchMenustyle(num) { for (var id = 1; id <= 5; id++) { if (id == num) { document.getElementById("mynav" + id).className = "hover"; } else { document.getElementById("mynav" + id).className = ""; } } }          </script>--%>
            <%--<div id="menu">--%>
                <%--<ul>--%>
                    <%--<li ><a  class="hover"id="mynav1" onclick="switchMenustyle(1)"data-bind="attr: { href: '<%=basePath%>userinfo/import.do'}">人员导入 </a></li>--%>
                    <%--<li><a   id="mynav2" onclick="switchMenustyle(2)"data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}"> 通讯录 </a></li>--%>
                    <%--<li ><a  id="mynav3" onclick="switchMenustyle(3)" data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}">人员统计 </a></li>--%>
                    <%--<li ><a  id="mynav4" onclick="switchMenustyle(4)" data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}"> 部门统计</a></li>--%>
                    <%--<li ><a  id="mynav5" onclick="switchMenustyle(5)"data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}"> 趋势统计</a></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="top-right">--%>
            <%--<p>欢迎您！<span >管理员</span></p>--%>
            <%--<a href=""><img src="../images/guanbi.png" /></a> </div>--%>
    <%--</div>--%>
    <div class="c_box">
    <div class="row-fluid center-block c_center_box" style="width:70%; background:#fff;">
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist" id="mytab">
        <li role="presentation" class="active"><a href="#tab1" role="tab" data-toggle="tab">添加新用户</a></li>
        <li role="presentation"><a href="#tab2" role="tab" data-toggle="tab">导出/修改用户信息</a></li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content"  style="border:1px solid #dedede; border-radius: 4px;">
        <div role="tabpanel form-bg" class="tab-pane active" id="tab1">
            <form name="userForm1" action="../userinfo/importMethod.do" enctype="multipart/form-data" method="post" onsubmit="return check_upload(this,1)">
                <input style="display: none;" name="tab" value="1"/>
            <div>
                <H2>导入用户</H2>
                <br/>
                <p>我们会自动给未使用的成员发送激活短信</p>
                <br/>
                <p>
                    第一步：
                    下载员工通讯录模版，批量填写员工信息</p>
                <a href="javascript:;" class="file">下载
                        <input  type="button" value="下载"  class="" onclick="downloadTemplate()">
                </a>
                <br/>
                <br/>
                <p>
                    第二步：
                    上传填写好的员工信息表</p>
                <a href="javascript:;" class="file">选择文件
                    <input  type="file" value="选择文件"   id="filename1" name="importExcel"  onchange="showFile(1)">
                </a>
                <div>
                    <div id="upfilename1">未上传任何文件</div>
                    <div id="checkmsg1"></div>
                    <div id="successmsg1"></div>
                </div>
                <br/>
                <br/>

            </div>
                <div style="text-align: center;margin-bottom:20px;" >
                   <input   type="submit" value="上传"  class="  button button-3d button-rounded button-primary" >

                </div>
            </form>
        </div>
        <div role="tabpanel" class="tab-pane" id="tab2">
            <form name="userForm2" action="../userinfo/importMethod.do" enctype="multipart/form-data" method="post" onsubmit="return check_upload(this,2)">
                <input style="display: none;" name="tab" value="2"/>
            <div>
                <H2>导出用户</H2>
                <br/>
                <p>我们会自动给未使用的成员发送激活短信</p>
                <br/>
                <p>
                    第一步：
                    导出员工信息</p>
                <a href="javascript:;" class="file">下载
                    <input  type="button" value="下载"  class="" onclick="downloadTemplate()">
                </a>
                <br/>
                <br/>
                <p>
                    第二步：
                    上传修改好的员工信息表</p>
                <a href="javascript:;" class="file">选择文件
                    <input  type="file" value="选择文件"    id="filename2" name="importExcel" onchange="showFile(2)">
                </a>
                <div>
                    <div id="upfilename2">未上传任何文件</div>
                    <div id="checkmsg2"></div>
                    <div id="successmsg2"></div>
                </div>
                <br/>
                <br/>

            </div>

            <div style="text-align: center;margin-bottom:20px;" >
                    <input   type="submit" value="上传"  class="button button-3d button-rounded button-primary" >
            </div>
            </form>
        </div>
    </div>
    </div>
    <div class="row-fluid center-block c_center_box" style="width:70%; ">
        <H2>出错列表</H2>
        <table style="margin-top:15px;"  border="1" cellspacing="0" cellpadding="0" class="table-1">
            <tr class="table-1-tou">
                <td width="10%">编号 </td>
                <td width="5%">姓名</td>
                <td width="5%">工号</td>
                <td width="7%"> 部门 </td>
                <td width="10%">手机号 </td>
                <td width="10%"> 邮箱 </td>
                <td width="15%"> 身份证号 </td>
                <td width="10%"> 出错原因 </td>
            </tr>
            <tbody >
            <c:if test="${!empty listFail }">
                <c:forEach items="${listFail}" var="list">
                    <tr>
                        <td>${list.staffUserId }</td>
                        <td>${list.name }</td>
                        <td>${list.staffId }</td>
                        <td>${list.department }</td>
                        <td>${list.cellphone }</td>
                        <td>${list.email }</td>
                        <td>${list.idNo }</td>
                        <td>${list.staffState }</td>
                    </tr>
                </c:forEach>
            </c:if>

            </tbody>
        </table>
    </div>
    </div>
    <div class="row-fluid">
        <div class="footer" data-reactid=".0.a">
            <div style="margin-bottom:5px;" data-reactid=".0.a.0">
            <span data-reactid=".0.a.0.0">
                <img width="11px" src="https://gw.alicdn.com/tps/TB14UngLXXXXXXQapXXXXXXXXXX-22-26.png" data-reactid=".0.a.0.0.0"></span>
                <span data-reactid=".0.a.0.1">上海音达科技实业有限公司</span></div>

        </div>
        </div>
</div>
</body>
</html>
