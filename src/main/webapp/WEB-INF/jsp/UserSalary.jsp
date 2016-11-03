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
<link type="text/css" rel="stylesheet" href="../stylesheets/style.css" />
<link href="../stylesheets/bootstrap.min.css" rel="stylesheet" />
<link href="../stylesheets/bootstrap-theme.min.css" rel="stylesheet" />
<link href="../stylesheets/bootstrap-treeview.min.css" rel="stylesheet" />
<link href="../stylesheets/shujutongji.css" rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="../stylesheets/ddcss.css" />
<script type="text/javascript" src="../javascripts/jquery-1.10.2.js"></script>
<script type="text/javascript" src="../javascripts/bootstrap.min.js"></script>
<script type="text/javascript" src="../javascripts/bootstrap-treeview.min.js"></script>
<script src="../javascripts//knockout-3.4.0rc.js"></script>
<style>
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
        window.open('../template/templateUserInfo.xls');
    }
    $(document).ready(function () {
        var type = "${tab}";
        if (type != "") checkInit(type);

        var ViewModel = function (){};
        ko.applyBindings(new ViewModel);
    });

    //查询所有员工工资
    self.GetUserListByDep = function(depddid){
        $.ajax({
            data:JSON.stringify(new UserModel(depddid,null,null,null)),
            type:"post",
            headers: { 'Content-Type': 'application/json' },
            dataType: 'json',
            url:"../usersalary/query.do",
            error:function(data){
                alert("出错了！！:"+data.msg);
            },
            success:function(data){
                result = eval(data.usertest);
                self.ShowList.removeAll();
                //清空viewmodel
                for (var i = 0; i < result.length; i++) {
                    self.ShowList.push(result[i]);
                    //加入每行题目信息
                }
            }
        });
    }


    self.GetUserByQuery = function () {
       if (nowDep != null){var depid = nowDep.name;} else {depid = null;}
        $.ajax({
            data:JSON.stringify(new UserModel(depid,$("#search_name").val())),
            type:"post",
            headers: { 'Content-Type': 'application/json' },
            dataType: 'json',
            url:"../usersalary/query.do",
            error:function(data){
                alert("出错了！！:"+data.msg);
            },
            success:function(data){
                result = eval(data.userlist);
                self.ShowList.removeAll();
                //清空viewmodel
                for (var i = 0; i < result.length; i++) {
                    self.ShowList.push(result[i]);
                }
            }
        });
    }

    self.ClickSearch = function () {
        self.GetUserByQuery();
    }

    function UserModel(depid,name) {
        this.staffUserId = null;
        this.name = name;
        this.age = null;
        this.sex = null;
        this.department = depid;
        this.idNo = null;
        this.cellphone = null;
        this.staffId = null;
        this.staffState = null;
        this.email = null;
        return this;
    }


</script>

<head>
        <meta charset="UTF-8">
        <title>工资查询</title>
        <link rel="stylesheet" href="../stylesheets/reset.css">
        <link rel="stylesheet" href="../stylesheets/buttons.css">
        <link rel="stylesheet" href="../stylesheets/affairsSearch.css">
        <link rel="stylesheet" href="../datePlug/jquery.monthpicker.css">
        <script src="../javascripts/jquery.min.js"></script>
        <script type="text/javascript" src="../datePlug/jquery.monthpicker.js"></script>
</head>
<body>

<div class="container-fluid">
    <div class="row-fluid top-tiku">
        <div class="top-left"> <img src="../images/logo.png" />
            <p>人事管理系统</p>
        </div>
        <div id="box">
            <script language="javascript">          function switchMenustyle(num) { for (var id = 1; id <= 5; id++) { if (id == num) { document.getElementById("mynav" + id).className = "hover"; } else { document.getElementById("mynav" + id).className = ""; } } }          </script>
            <div id="menu">
                <ul>
                    <li ><a  id="mynav1" onclick="switchMenustyle(1)"data-bind="attr: { href: '<%=basePath%>userinfo/import.do'}">人员导入 </a></li>
                    <li><a   id="mynav2" onclick="switchMenustyle(2)"data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}"> 通讯录 </a></li>
                    <li ><a  id="mynav3" onclick="switchMenustyle(3)" data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}">人员统计 </a></li>
                    <li ><a  id="mynav4" onclick="switchMenustyle(4)" data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}"> 部门统计</a></li>
                    <li ><a  id="mynav5" onclick="switchMenustyle(5)"data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}"> 趋势统计</a></li>
                    <li ><a class="hover" id="mynav6" onclick="switchMenustyle(6)"data-bind="attr: { href: '<%=basePath%>userinfo/test.do'}">工资查询</a></li>
                </ul>
            </div>
        </div>
        <div class="top-right">
            <p>欢迎您！<span >管理员</span></p>
            <a href=""><img src="../images/guanbi.png" /></a> </div>
    </div>
    <div class="container">
        <div class="content">
            <div class="cont-tit">
                工资查询
            </div>
            <div class="search">
                <div class="ser-input fl">

                    姓名：<input type="text" placeholder="输入姓名">
                    日期：<input type="text" placeholder="输入查询日期" class="input" id="monthly">

                </div>
                <div class="ser-btn fr">

                    <button  class="button button-glow button-border button-rounded button-primary button-small ">查询</button>
                    <button  class="button button-glow button-border button-rounded button-highlight button-small ">清空</button>

                </div>
            </div>
            <div class="ser-resault">
                <table border="1">
                    <thead>
                    <tr>
                        <th>日期</th>
                        <th>工作日</th>
                        <th>周末</th>
                        <th>缺勤</th>
                        <th>缺勤工资</th>
                        <th>事假</th>
                        <th>事假工资</th>
                        <th>长病假</th>
                        <th>长病假工资</th>
                        <th>调休</th>
                        <th>调休工资</th>
                        <th>请假</th>
                        <th>请假工资</th>
                        <th>加班</th>
                        <th>加班工资</th>
                        <th>出差天数</th>
                        <th>出差补贴</th>
                        <th>time</th>
                        <th>奖金</th>
                        <th>发放</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>xxx</td>
                        <td>2016-10</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                    </tr>
                    <tr>
                        <td>xxx</td>
                        <td>2016-10</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td>合计</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                    </tr>
                    </tfoot>
                </table>
            </div>

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
    </div>
</body>
</html>
