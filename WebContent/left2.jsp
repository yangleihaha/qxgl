<%@page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<style type="text/css">
			dl,dt,dd{
				padding: 0;
				margin: 0;
			}
			#dlBox{
				width: 150px;
				border: 1px solid black;
				text-align: center;
				margin: 30px auto;
			}
			#dlBox dt{
				height: 40px;
				line-height: 40px;
				cursor:pointer;
			}
			#dlBox>dt{
				background: pink;
				border: 1px solid black;
			}
			#dlBox>dd{
				background: yellow;
				border: 1px solid black;
			}
		</style>
		<script type="text/javascript" src="js/jQuery3.3.1.js"></script>
		<script type="text/javascript">
			$(function () {
				$.post('currentFunctions.action',{},function(functions){
					for(var i=0;i<functions.length;i++){
						var fun = functions[i];
						if(fun.pno == -1){
							var dt = $('<dt>'+fun.fname+'</dt>')
							$('#dlBox').append(dt);
							var dd = $('<dd></dd>');
							$('#dlBox').append(dd);
							var dl = $('<dl></dl>');
							dd.append(dl);
							for(var j=0;j<functions.length;j++){
								var fun2 = functions[j];
								if(fun2.pno == fun.fno){
									dl.append('<dt title="'+fun2.url+'"><a href="'+fun2.url+'" target="main">'+fun2.fname+'</a></dt>');
								}
							}
						}
					}
					$('#dlBox>dt').click(function () {
						$(this).next().slideToggle(600);
					});
				},'json');
			});
		</script>
	</head>
	<body>
		<dl id="dlBox">
			<!-- <dt>权限管理</dt>
			<dd>
				<dl>
					<dt>用户管理</dt>
					<dt>用户管理</dt>
					<dt>用户管理</dt>
				</dl>
			</dd>
			
			<dt>权限管理</dt>
			<dd>
				<dl>
					<dt>用户管理</dt>
					<dt>用户管理</dt>
					<dt>用户管理</dt>
				</dl>
			</dd> -->
		</dl>
	</body>
</html>