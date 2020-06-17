<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link href="css/login.css" rel="stylesheet" />
	</head>
	<body>
		<h1>当当二手车<span style="font-size: 20px;">信息管理平台</span></h1>
		<hr color="gold" size="4" />
		<h3 align="center">用户登录</h3><span id="tips" style="color: red;margin: 0px 500px" >${msg}</span>
		<div class="box">
			<form action="/user/login.do" method="post">
				<div>
					<input type="text" name="user" placeholder="输入用户名" onfocus="clearMsg()" autocomplete="off"/>
				</div>
				<div>
					<input type="password" name="pw" placeholder="输入密码" onfocus="clearMsg()" autocomplete="off" />
				</div>
				<div>
					<input type="text" name="code" placeholder="输入验证码" onfocus="clearMsg()" autocomplete="off" />
				</div>
				<div>
					<img src="/img/pic.do" onclick="javascript:this.src='/img/pic.do?t='+Math.random()" />
				</div>
				<div class="login">
						<input type="submit" value="登录" />
				</div>
				<a href="register.html" style="margin: 0px 150px;">
					注册账号
				</a>
			</form>
				<script>
					function clearMsg() {
						document.getElementById("tips").innerText="";

					}
				</script>
		</div>
	</body>
</html>
