<%@page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<style type="text/css">
			div{
				width: 300px;
				height: 500px;
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
		<script type="text/javascript">
			window.onload = function () {
				var cno = document.getElementById('cno');
				cno = cno.value;
				var xhr = new XMLHttpRequest();
				xhr.open('get','selectOne.do?cno='+cno,false);
				xhr.onreadystatechange = function () {
					if(xhr.readyState == 4 && xhr.status == 200){
						var r = xhr.responseText;
						callBack(r);
					}
				}
				xhr.send();
			}
			
			function callBack(r) {
				var user = eval('('+r+')');
				var cname = document.getElementById('cname');
				cname.value = user.cname;
				var cpass = document.getElementById('cpass');
				cpass.value = user.cpass;
				var truename = document.getElementById('truename');
				truename.value = user.truename;
			}
		</script>
	</head>
	<body>
		<div>
			<form action="updateUser.do" method="post">
				<h2 align="center">修改用户</h2>
				<p align="center" >
				<input type="hidden" value="${param.cno }" name="cno" id="cno"> 
				</p>
				<ul>
					<li>
						<input type="text" name="cname" placeholder="请输入用户名" required="required" id="cname"> 
					</li>
					<li>
						<input type="text" name="cpass" placeholder="请输入密码" required="required" id="cpass"> 
					</li>
					<li>
						<input type="text" name="truename"  placeholder="真实姓名" required="required" id="truename"> 
					</li>
				</ul>
				<button>修改</button>
			</form>
		</div>
	</body>
</html>