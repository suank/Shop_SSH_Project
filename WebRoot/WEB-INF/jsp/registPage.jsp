<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>会员注册</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/register.css" rel="stylesheet" type="text/css"/>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>

<script>
	function checkEmail(){
		// 校验邮箱 :
		var email = document.getElementById("email").value;
		if(email.indexOf("@") == -1){
			alert("邮箱格式有误!");
		}
	}
	

	//校验用户注册
	function checkForm(){
		// 校验用户名:
		// 获得用户名文本框的值:
		var username = document.getElementById("username").value;
		if(username == null || username == ''){
			alert("用户名不能为空!");
			return false;
		}
		// 校验密码:
		// 获得密码框的值:
		var password = document.getElementById("password").value;
		if(password == null || password == ''){
			alert("密码不能为空!");
			return false;
		}
		// 校验确认密码:
		var repassword = document.getElementById("repassword").value;
		if(repassword != password){
			alert("两次密码输入不一致!");
			return false;
		}
		
		//邮箱不可为空
		var email = document.getElementById("email").value;
		if(email == null||email == '' ){
			alert("邮箱不可为空!");
			return false;
		}
	
	}
	
	
	//校验用户名是否已经存在  	AJAX异步校验
	//鼠标在username失焦的时候触发
	function checkUsername(){
		// 获得文件框值:
		var username = document.getElementById("username").value;
		// 1.创建异步交互对象
		var xhr = createXmlHttp();
		// 2.设置监听
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					document.getElementById("span1").innerHTML = xhr.responseText;
				}
			}
		}
		
		// 3.打开连接
		xhr.open("GET","${pageContext.request.contextPath}/user_findByName.action?"+"username="+username,true);
		// 4.发送
		xhr.send(null);
	}
	
	function createXmlHttp(){
		   var xmlHttp;
		   try{ 
		        xmlHttp=new XMLHttpRequest();
		    }
		    catch (e){
			   try{// Internet Explorer
			         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
			      }
			    catch (e){
			      try{
			         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			      }
			      catch (e){}
			      }
		    }
			return xmlHttp;
		 }


// //AJAX发起异步请求
// function checkUsername(){
// 	var username = document.getElementById("username").value;
// 	$.ajax({
// 		//发送数据的方式，POST/GET
// 		type : "GET" ,
// 		//请求url，即请求的action，jsp中的js可以使用el表达式，html中就用路径
// 		url : "${pageContext.request.contextPath}/user_findByName.action",
// 		//请求参数
// 		data : {"username": username}, 
// 		//如果请求成功，并且action执行成功，则会返回到这个success的函数中，函数的返回值data就是action中返回的数据，一般返回的是JSON字符串类型的数据
// 		success : function(data){
// 			//看看传回的数据
// 			alert(data) ;  
// 		}
// 	}) ;
// }
	
	
	//点击图片更换按钮
	function change(){
		var img = document.getElementById("checkImg");
		img.src="${pageContext.request.contextPath}/user_checkImg.action?"+new Date().getTime();
	}
	
</script>
</head>
<body>
<div class="container header">
	<div class="span5">
	</div>
	<div class="span9">
<div class="headerAd">
</div>	</div>
	
	<%@ include file="menu.jsp" %>

</div>	<div class="container register">
		<div class="span24">
			<div class="wrap">
				<div class="main clearfix">
					<div class="title">
						<strong>会员注册</strong>USER REGISTER
					</div>
					<div>
						<s:actionerror />
					</div>
					<form id="registerForm" action="${ pageContext.request.contextPath }/user_regist.action"  method="post" novalidate="novalidate" onsubmit="return checkForm();">
						<table>
							<tbody><tr>
								<th>
									<span class="requiredField">*</span>用户名:
								</th>
								<td>
<!-- 									onblur失焦触发 -->
									<input type="text" id="username" name="username" class="text" maxlength="20" onblur="checkUsername()"/>
									<span id="span1"></span>
								</td>
							</tr>
							<tr>
								<th>
									<span class="requiredField">*</span>密&nbsp;&nbsp;码:
								</th>
								<td>
									<input type="password" id="password" name="password" class="text" maxlength="20" autocomplete="off"/>
									<span><s:fielderror fieldName="password"/></span>
								</td>
							</tr>
							<tr>
								<th>
									<span class="requiredField">*</span>确认密码:
								</th>
								<td>
									<input id="repassword" type="password" name="repassword" class="text" maxlength="20" autocomplete="off"/>
								</td>
							</tr>
							<tr>
								<th>
									<span class="requiredField">*</span>E-mail:
								</th>
								<td>
									<input type="text" id="email" name="email" class="text" maxlength="200" onblur="checkEmail()">
									<span><s:fielderror fieldName="email"/></span>
								</td>
							</tr>
									<tr>
										<th>
											姓名:
										</th>
										<td>
												<input type="text" name="name" class="text" maxlength="200"/>
												<span><s:fielderror fieldName="name"/></span>
										</td>
									</tr>
									
									<tr>
										<th>
											电话:
										</th>
										<td>
												<input type="text" name="phone" class="text" />
										</td>
									</tr>
									
									<tr>
										<th>
											地址:
										</th>
										<td>
												<input type="text" name="addr" class="text" maxlength="200"/>
												<span><s:fielderror fieldName="addr"/></span>
										</td>
									</tr>
								<tr>
									<th>
										<span class="requiredField">*</span>验证码:
									</th>
									<td>
										<span class="fieldSet">
<!-- 											captchaImage 验证码内库 -->
											<input type="text" id="checkcode" name="checkcode" class="text captcha" maxlength="4" autocomplete="off"><img id="checkImg" class="captchaImage" src="${pageContext.request.contextPath}/user_checkImg.action" onclick="change()" title="点击更换验证码">
										</span>
									</td>
								</tr>
							<tr>
								<th>&nbsp;
									
								</th>
								<td>
									<input type="submit" class="submit" value="注册">
								</td>
							</tr>
							<tr>
								<th>&nbsp;
									
								</th>
							</tr>
							<tr>
								<th>&nbsp;
									
								</th>
							</tr>
						</tbody></table>
					</form>
				</div>
			</div>
		</div>
	</div>
<div class="container footer">
<div id="_my97DP" style="position: absolute; top: -1970px; left: -1970px;"><iframe style="width: 190px; height: 191px;" src="./会员注册 - Powered By Mango Team_files/My97DatePicker.htm" frameborder="0" border="0" scrolling="no"></iframe></div></body></html>