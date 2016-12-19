<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<body>
<h2>上海音达科技实业有限公司人事管理后台</h2>

<h5><a href="<%=basePath%>userinfo/testMethod.do">进入用户管理页</a></h5>
</body>
</html> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	session.invalidate();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>上海音达科技实业有限公司人事管理后台</title>
<!-- BootStrap3全面支持移动平台：下行代码为默认情况下，UI布局的宽度和移动设备的快读移植，缩放大小为原始大小。 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="<%=path%>/stylesheets/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path%>/stylesheets/font-awesome.min.css" />
<link rel="stylesheet" href="<%=path%>/stylesheets/ace-fonts.css" />
<link rel="stylesheet" href="<%=path%>/stylesheets/ace.min.css" />
<link rel="stylesheet" href="<%=path%>/stylesheets/ace-rtl.min.css" />

</head>

<body class="login-layout" style="background:#6fb3e0">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<!-- <i class="icon-leaf green"></i> -->
								<img width="32px" height="32px" alt="" src="<%=path %>/images/logo.png">
								<span class="white">上海音达科技实业有限公司人事管理后台</span>
							</h1>
							<!-- <h4 class="blue">&copy;</h4> -->
							<h4></h4>
						</div>

						<div class="space-12"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border" style="background:#6fb3e0">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i> 用户登陆
										</h4>

										<div class="space-6"></div>

										<!-- <form action="mvc/login.do" method="post"> -->
										<form id="form" action="" method="post">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" class="form-control" placeholder="用户名"
														name="name" id="name" /> <i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" class="form-control"
														placeholder="密码" name="password" id="password" /> <i
														class="icon-lock"></i>
												</span>
												</label>

												<div class="space"></div>

												<div class="clearfix">
													<!-- <label class="inline"> <input type="checkbox"
														class="ace" /> <span class="lbl"> Remember Me</span>
													</label> -->

													<button type="button"
														class="width-35 pull-right btn btn-sm btn-primary" onclick="subForm();">
														<i class="icon-key"></i> 登陆
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>


							<div id="forgot-box" class="forgot-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header red lighter bigger">
											<i class="icon-key"></i> Retrieve Password
										</h4>

										<div class="space-6"></div>
										<p>Enter your email and to receive instructions</p>

										<form>
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="email" class="form-control" placeholder="Email" />
														<i class="icon-envelope"></i>
												</span>
												</label>

												<div class="clearfix">
													<button type="button"
														class="width-35 pull-right btn btn-sm btn-danger">
														<i class="icon-lightbulb"></i> Send Me!
													</button>
												</div>
											</fieldset>
										</form>
									</div>
									<!-- /widget-main -->

									<div class="toolbar center">
										<a href="#" onclick="show_box('login-box'); return false;"
											class="back-to-login-link"> Back to login <i
											class="icon-arrow-right"></i>
										</a>
									</div>
								</div>
								<!-- /widget-body -->
							</div>
							<!-- /forgot-box -->

							<div id="signup-box" class="signup-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header green lighter bigger">
											<i class="icon-group blue"></i> New User Registration
										</h4>

										<div class="space-6"></div>
										<p>Enter your details to begin:</p>

										<form>
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="email" class="form-control" placeholder="Email" />
														<i class="icon-envelope"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" class="form-control" placeholder="Username" />
														<i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" class="form-control"
														placeholder="Password" /> <i class="icon-lock"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" class="form-control"
														placeholder="Repeat password" /> <i class="icon-retweet"></i>
												</span>
												</label> <label class="block"> <input type="checkbox"
													class="ace" /> <span class="lbl"> I accept the <a
														href="#">User Agreement</a>
												</span>
												</label>

												<div class="space-24"></div>

												<div class="clearfix">
													<button type="reset" class="width-30 pull-left btn btn-sm">
														<i class="icon-refresh"></i> Reset
													</button>

													<button type="button"
														class="width-65 pull-right btn btn-sm btn-success">
														Register <i class="icon-arrow-right icon-on-right"></i>
													</button>
												</div>
											</fieldset>
										</form>
									</div>

									<div class="toolbar center">
										<a href="#" onclick="show_box('login-box'); return false;"
											class="back-to-login-link"> <i class="icon-arrow-left"></i>
											Back to login
										</a>
									</div>
								</div>
								<!-- /widget-body -->
							</div>
							<!-- /signup-box -->
						</div>
						<!-- /position-relative -->
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
	</div>
<script src="<%=path%>/javascripts/jquery.min.js"></script>
 <script>
	function subForm(){
		if($("#name").val() == ""){
			alert("请输入用户名");
		}else if($("#password").val()==""){
			   alert("请输入密码");
		}else{
			$.post("login.do",$("#form").serialize(),function(data){
				if(data=="success"){
//					alert("登录成功");
					window.location.href="loginSuccess.do";
				}else if(data ="fail"){
					alert("该账户尚未注册,无法登录!")
				}
			}); 
		}
	}		
 </script>
</body>
</html>
