<%@page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<style type="text/css">
			div{
				width: 300px;
				height: 250px;
				background-color: pink;
				border: 2px solid yellow; 
				margin: 20px auto;
				border-radius: 20px;
			}
			p{
				height: 10px;
				margin-top: -15px;
				color: red;
			}
			input{
				width: 200px;
				height: 35px;
				margin-bottom: 15px;
				border-radius: 20px;
				padding-left: 20px;
			}
			li{
				list-style-type: none;
			}
			button{
				display:block;
				margin: 0 auto;
				width: 70px;
				height: 30px;
				background-color: yellow;
				border-radius: 10px;
			}
		</style>
	</head>
	<%String f = request.getParameter("f"); %>
	<body>
		<div>
			<form action="login.do" method="post">
				<h2 align="center">用户登录</h2>
				<p align="center" >
					<%if(f!=null && f.equals("9")){%>
						账号或密码错误!
					<% }%>
				</p>
				<ul>
					<li>
						<input type="text" name="cname" placeholder="请输入用户名" required="required"> 
					</li>
					<li>
						<input type="text" name="cpass" placeholder="请输入密码" required="required"> 
					</li>
				</ul>
				<button>登录</button>
			</form>
		</div>
	</body>
</html>