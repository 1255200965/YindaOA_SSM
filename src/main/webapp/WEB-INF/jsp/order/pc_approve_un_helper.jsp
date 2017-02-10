<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<meta name=Generator content="Microsoft Word 14 (filtered)">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<style>
<!--
 /* Font Definitions */
 @font-face
	{font-family:宋体;
	panose-1:2 1 6 0 3 1 1 1 1 1;}
@font-face
	{font-family:宋体;
	panose-1:2 1 6 0 3 1 1 1 1 1;}
@font-face
	{font-family:Calibri;
	panose-1:2 15 5 2 2 2 4 3 2 4;}
@font-face
	{font-family:微软雅黑;
	panose-1:2 11 5 3 2 2 4 2 2 4;}
@font-face
	{font-family:"\@宋体";
	panose-1:2 1 6 0 3 1 1 1 1 1;}
@font-face
	{font-family:"\@微软雅黑";
	panose-1:2 11 5 3 2 2 4 2 2 4;}
 /* Style Definitions */
 p.MsoNormal, li.MsoNormal, div.MsoNormal
	{margin:0cm;
	margin-bottom:.0001pt;
	text-align:justify;
	text-justify:inter-ideograph;
	font-size:10.5pt;
	font-family:"Calibri","sans-serif";}
h1
	{mso-style-link:"标题 1 Char";
	margin-top:17.0pt;
	margin-right:0cm;
	margin-bottom:16.5pt;
	margin-left:0cm;
	text-align:justify;
	text-justify:inter-ideograph;
	line-height:240%;
	page-break-after:avoid;
	font-size:22.0pt;
	font-family:"Calibri","sans-serif";}
p.MsoAcetate, li.MsoAcetate, div.MsoAcetate
	{mso-style-link:"批注框文本 Char";
	margin:0cm;
	margin-bottom:.0001pt;
	text-align:justify;
	text-justify:inter-ideograph;
	font-size:9.0pt;
	font-family:"Calibri","sans-serif";}
span.Char
	{mso-style-name:"批注框文本 Char";
	mso-style-link:批注框文本;}
span.1Char
	{mso-style-name:"标题 1 Char";
	mso-style-link:"标题 1";
	font-weight:bold;}
.MsoChpDefault
	{font-family:"Calibri","sans-serif";}
 /* Page Definitions */
 @page WordSection1
	{size:595.3pt 841.9pt;
	margin:72.0pt 90.0pt 72.0pt 90.0pt;
	layout-grid:15.6pt;}
div.WordSection1
	{page:WordSection1;}
-->
body{
background:white;
margin:0;
padding-left:30%;
}
</style>

</head>

<body lang=ZH-CN style='text-justify-trim:punctuation'>

<div class=WordSection1 style='layout-grid:15.6pt'>

<h1><span lang=EN-US>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span
style='font-family:宋体'>项目变更后台使用说明</span></h1>

<p class=MsoNormal><span lang=EN-US style='font-family:"微软雅黑","sans-serif"'>&nbsp;</span></p>

<p class=MsoNormal><span style='font-family:"微软雅黑","sans-serif"'>该输入框为订单名称输入框</span></p>

<p class=MsoNormal><span lang=EN-US><img width=408 height=104 id="图片 4"
src="<%=path %>/images/order_img/image001.png"
alt=""></span></p>

<p class=MsoNormal><span lang=EN-US>&nbsp;</span></p>

<p class=MsoNormal><span lang=EN-US>&nbsp;</span></p>

<p class=MsoNormal><span style='font-family:宋体'>输入文字值点击查询按钮，即可查询你的待审批项目变更列表</span></p>

<p class=MsoNormal><span lang=EN-US>&nbsp;</span></p>

<p class=MsoNormal><span lang=EN-US><img width=326 height=183 id="图片 2"
src="<%=path %>/images/order_img/image002.png"
alt="说明"></span></p>

<p class=MsoNormal><span lang=EN-US>&nbsp;</span></p>

<p class=MsoNormal><span style='font-family:宋体'>每一行的代表一条项目变更申请</span> <span
style='font-family:宋体'>修改完成后</span> <span style='font-family:宋体'>需勾选按钮</span></p>

<p class=MsoNormal><span lang=EN-US><img width=586 height=91 id="图片 3"
src="<%=path %>/images/order_img/image003.png"
alt="说明"></span></p>

<p class=MsoNormal><span lang=EN-US><img width=251 height=101 id="图片 5"
src="<%=path %>/images/order_img/image004.png"
alt="说明"></span></p>

<p class=MsoNormal><span style='font-family:宋体'>多条修改完成后</span> <span
style='font-family:宋体'>点击多条通过</span><span lang=EN-US>/</span><span
style='font-family:宋体'>多条拒绝</span></p>

<p class=MsoNormal><span lang=EN-US><img width=212 height=187 id="图片 7"
src="<%=path %>/images/order_img/image005.png"
alt="说明"></span></p>

<p class=MsoNormal><span style='font-family:宋体'>成功后页面会提示</span></p>

<p class=MsoNormal><span lang=EN-US><img width=440 height=168 id="图片 8"
src="<%=path %>/images/order_img/image006.png"
alt="说明"></span></p>

<p class=MsoNormal><span lang=EN-US>&nbsp;</span></p>

<p class=MsoNormal><span style='font-family:宋体'>这样就审批完成了！</span></p>

<p class=MsoNormal><span lang=EN-US>&nbsp;</span></p>

</div>

</body>

</html>
