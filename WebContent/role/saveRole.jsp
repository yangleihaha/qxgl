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
	</head>
	<body>
		<div>
			<form action="../saveRole.do" method="post">
				<h2 align="center">添加角色</h2>
				<p align="center" >
					
				</p>
				<ul>
					<li>
						<input type="text" name="rname" placeholder="请输入角色名" required="required"> 
					</li>
					<li>
						<input type="text" name="description" placeholder="描述" required="required"> 
					</li>
				</ul>
				<button>添加</button>
			</form>
		</div>
	</body>
</html>