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
			select{
				width: 200px;
				height: 35px;
			}
		</style>
		<script type="text/javascript" src="../js/jQuery3.3.1.js"></script>
		<script type="text/javascript">
			$(function () {
				$.post('parentFunctions.action',{},function(functions){
					for(var i=0;i<functions.length;i++){
						var fun = functions[i];
						$('select').append('<option value="'+fun.fno+'">'+fun.fname+'</option>');
					}
				},'json');
			});
		</script>
	</head>
	<body>
		<div>
			<form action="savez.action" method="post">
				<input type="hidden" value="${param.fno}" name="fno">
				<h2 align="center">修改父级菜单</h2>
				<p align="center" >
					
				</p>
				<ul>
					<li>
						<input type="text" name="fname" placeholder="请输入菜单名" required="required" value="${param.fname }"> 
					</li>
					<li>
						<input type="text" name="url" placeholder="请输入请求路径" required="required" value="${param.url }"> 
					</li>
					<li>
						 <select name="pno">
						 	<!-- <option value=""></option> -->
						 </select>
					</li>
				</ul>
				<!--  <button>修改</button>-->
			</form>
		</div>
	</body>
</html>