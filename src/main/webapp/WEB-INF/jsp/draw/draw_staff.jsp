<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();/*获得当前项目的根路径 */
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="format-detection" content="telephone=no">
		<title>音达科技刮刮卡</title>
		<link href="<%=path %>/stylesheets/activity-style.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="<%=path%>/stylesheets/weui.css"/>
  		<link rel="stylesheet" href="<%=path%>/stylesheets/jquery-weui.css"/>
	</head>
	
	</head>
	<body data-role="page" class="activity-scratch-card-winning">
		
		<div class="main">
			<div class="cover">
				<img src="images/activity-scratch-card-bannerbg.png">				
				<div id="prize"></div>
                <div id="scratchpad"></div>                
			</div>
	
				<div class="boxcontent boxwhite">
					<div class="box">
						<div class="title-brown">
							<span>
								奖项设置：
							</span>
						</div>
						<div class="Detail">
							<p>
								一等奖： 小黑侠跟拍无人机 * 2
							</p>
							<p>
								二等奖： Nokia6 * 6
							</p>
							<p>
								三等奖： 小米AMAZFIT华米智能运动手表 * 10
							</p>
						</div>
					</div>
				</div>
				
				<div class="boxcontent boxwhite">
					<div class="box">
						
						<a onclick="reStart();"><div class="Detail" style="text-align:center;">
							<p class="red">
								点击再来一次
							</p>
							<br/>
							 <p>
								1.2017年1月26日下午14:00起抽,13:30-14:00为预热时间方便大家熟悉抽奖的流程。
							</p>
							<p>
								2.抽中奖品后需手动输入工号进行领奖,抽奖前务必记清工号以防到时填错,错失大奖。
							</p> 
						</div>
						</a>
					</div>
				</div>
			</div>
			<div style="clear:both;">
			</div>
		<script src="<%=path %>/javascripts/jquery-2.1.4.js" type="text/javascript"></script>
		<script src="<%=path %>/javascripts/wScratchPad.js" type="text/javascript"></script>
		<script src="<%=path%>/javascripts/jquery-weui.js"></script>
		 
		<script type="text/javascript">
		
		    var flag='${flag}';
		    var prize;//奖项
		    var nowDate;//当前时间--小时
		    var prizeDate="2017-01-26 14:00:00";//正式抽奖开始时间
		    var joke;
			window.sncode = "null";
			$(function() {
				
				$("#scratchpad").wScratchPad({
					width: 200,
					height: 40,
					color: "#a9a9a7",
					realtime: true,
					scratchMove: function (e,percent){
						if(percent >70 && percent <100){
						 if(flag=="start"){
							if(prize=="一等奖" || prize =="二等奖" || prize =="三等奖"){	
									//获取当前时间
								    nowDate=getNowDate();
									//如果当前时间比抽奖时间大则进行抽奖,
									if(new Date(nowDate).getTime() >= new Date(prizeDate).getTime()){
										prizerOperation(prize);	
									}else{
										prizerOperation2(prize);
									}
									
					
									}else{
										$("#prize").html("再接再励");
									}
						 }else if(flag=="end"){
							 $("#prize").html("抽奖已结束");
						 }
						}
					}
				});
			});
			//获奖者操操作--测试版
			function prizerOperation2(prize){
				$("#prize").html(prize);
				$("#scratchpad").wScratchPad('clear');
				$.prompt({
					  title: '奖品认领',
					  text: '输入工号,点击确认,进行奖品认领',
					  input: '',
					  empty: false, // 是否允许为空
					  onOK: function (input) {
					    getPrize2(input);
					  },
					  onCancel: function () {
						  giveUp2(prize);
					  }
					});
			}
			//员工确认放弃该奖项--测试
			function giveUp2(prize){
				$.confirm({
					  title: '',
					  text: '确认放弃'+prize,
					  onOK: function () {
						  
					  },
					  onCancel: function () {
						  prizerOperation(prize);
					  }
					});	
			}
			//奖品认领--提交前跟员工确认下工号--测试
			function getPrize2(input){
				$.confirm({
					  title: '',
					  text: '确认工号为'+input,
					  onOK: function () {
						 getJoke();
						$.alert("恭喜您获得"+joke);
					  },
					  onCancel: function () {
						  prizerOperation2(prize);
					  }
					});			
			}
			
			//获奖者操操作--正式
			function prizerOperation(prize){
				$("#prize").html(prize);
				$("#scratchpad").wScratchPad('clear');
				$.prompt({
					  title: '奖品认领',
					  text: '输入工号,点击确认,进行奖品认领',
					  input: '',
					  empty: false, // 是否允许为空
					  onOK: function (input) {
					    getPrize(input);
					  },
					  onCancel: function () {
						  giveUp(prize);
					  }
					});
			}
			//员工确认放弃该奖项--正式
			function giveUp(prize){
				$.confirm({
					  title: '',
					  text: '确认放弃'+prize,
					  onOK: function () {
						  
					  },
					  onCancel: function () {
						  prizerOperation(prize);
					  }
					});	
			}
			//奖品认领--提交前跟员工确认下工号--正式
			function getPrize(input){
				$.confirm({
					  title: '',
					  text: '确认工号为'+input,
					  onOK: function () {
						 
						  $.post("getPrize.do",{"prizeType":prize,"staffId":input},function(data){
						    	if(data){
						    		$.alert("恭喜您成功认领"+prize);
						    	}else{
						    		getJoke();
						    		$.alert("很抱歉"+prize+"已被领完,恭喜您获得:"+joke);
						    	}
						    });
					  },
					  onCancel: function () {
						  prizerOperation(prize);
					  }
					});			
			}
			
				//重置刮刮乐
			function reStart(){
				var rand;
				//获取当前时间
			    nowDate=getNowDate();
				//如果当前时间比抽奖时间大则进行抽奖,
				/* if(new Date(nowDate).getTime() >= new Date(prizeDate).getTime()){
						//正式抽奖概率1/1000
					 rand=Math.floor(Math.random()*1000);
					
				}else{ */
							//预热1/5
					rand=Math.floor(Math.random()*5);
				/* } */
					if(rand==1){
						prize="一等奖";
					}else if(rand ==2){
						prize="二等奖";
					}else if(rand == 3){
						prize="三等奖";
					}else if(rand==4){
						prize="二等奖";
					}else if(rand == 5){
						prize="二等奖";
					}else if(rand == 6){
						prize="二等奖";
					}else if(rand ==350){
						prize="三等奖";
					}else if(rand ==560){
						prize="三等奖";
					}else if(rand ==100){
						prize="三等奖";
					}else if(rand ==790){
						prize="三等奖";
					}else if(rand ==70){
						prize="三等奖";
				    }else {
						prize="再接再励";
					}
				
				$("#prize").html("");
				$('#scratchpad').wScratchPad('reset');
			}
			//获取当前时间--具体到小时
			function getNowDate(){
				var date=new Date();
				var month = date.getMonth()+1;
				var day = date.getDate();
				var time = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
				var output = date.getFullYear() + '-' +
				(month<10 ? '0' : '') + month + '-' + (day<10 ? '0' : '') + day +" "+time;
				return output;
				}
			//中奖话语
			function getJoke(){
				var rand=Math.floor(Math.random()*5);
				if(rand==1){
					joke="今天手气棒棒哒";
				}else if(rand ==2){
					joke="鸡年大吉";
				}else if(rand == 3){
					joke="金玉满堂";
				}else if(rand == 4){
					joke="吉星高照";
				}else if(rand == 5){
					joke="岁岁平安";
				}else if(rand == 6){
					joke="年年有余";
				}else if(rand == 7){
					joke="万事如意";
				}else{
					joke="心想事成";
				}
			}
		</script>
		
	</body>

</html>