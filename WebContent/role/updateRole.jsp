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
				var rno = document.getElementById('rno');
				var xhr = new XMLHttpRequest();
				xhr.open('get','../findOneRole.do?rno='+rno.value,false);
				xhr.onreadystatechange = function () {
					if(xhr.readyState == 4 && xhr.status == 200 ){
						var r = xhr.responseText;
						callBack(r);
					}
				}
				xhr.send();
			}
			function callBack(r) {
				var role = eval('('+r+')');
				var rname = document.getElementById('rname');
				var description = document.getElementById('description');
				rname.value = role.rname;
				description.value = role.description;
			}
		</script>
	</head>
	<body>
		<div>
			<form action="../updateRole.do" method="post">
				<input type="hidden" value="${param.rno }" id="rno" name="rno">
				<h2 align="center">修改角色</h2>
				<p align="center" >
					
				</p>
				<ul>
					<li>
						<input type="text" name="rname" id="rname" placeholder="请输入角色名" required="required"> 
					</li>
					<li>
						<input type="text" name="description" id="description" placeholder="描述" required="required"> 
					</li>
				</ul>
				<button>修改</button>
			</form>
		</div>
	</body>
</html>