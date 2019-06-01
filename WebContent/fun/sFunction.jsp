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
				width: 200px;
				border: 1px solid black;
				text-align: center;
				margin: 30px auto;
			}
			#dlBox dt{
				height: 40px;
				line-height: 40px;
				cursor:pointer;
				position: relative;
			}
			#dlBox>dt{
				background: pink;
				border: 1px solid black;
			}
			#dlBox>dd{
				background: yellow;
				border: 1px solid black;
			}
			#dlBox input[type="checkbox"]{
				position: absolute;
				left:20px;
				top:0px;
			}
		</style>
		<script type="text/javascript" src="../js/jQuery3.3.1.js"></script>
		<script type="text/javascript">
			$(function () {
				$.post('../findAllFun.action',{},function(functions){
					for(var i=0;i<functions.length;i++){
						var fun = functions[i];
						if(fun.pno == -1){
							var dt = $('<dt><input type="checkbox" name="fno" value="'+fun.fno+'"/>'+fun.fname+'</dt>')
							$('#dlBox').append(dt);
							var dd = $('<dd></dd>');
							$('#dlBox').append(dd);
							var dl = $('<dl></dl>');
							dd.append(dl);
							for(var j=0;j<functions.length;j++){
								var fun2 = functions[j];
								if(fun2.pno == fun.fno){
									dl.append('<dt title="'+fun2.url+'"><input type="checkbox" name="fno" value="'+fun2.fno+'"/>'+fun2.fname+'</dt>');
								}
							}
						}
					}
					
					$.post('linkFunctions.action',{rno:$('#rno').val()},function(functions){
						for(var i=0;i<functions.length;i++){
							var fun = functions[i];
							$('#dlBox :checkbox[value="'+fun.fno+'"]').attr('checked',true);
						}
					},'json');
					
					$('#dlBox > dt :checkbox').click(function () {
						var f = $(this).prop('checked');
						$(this).parent().next().children().children().children().prop('checked',f);
					});
					
					$('#dlBox  dl :checkbox').click(function () {
						var f = $(this).prop('checked');
						if(f){
							$(this).parent().parent().parent().prev().children(':checkbox').prop('checked',true);
						}else{
							if($(this).parent().parent().children().children(':checked').length == 0){
								$(this).parent().parent().parent().prev().children(':checkbox').prop('checked',false);
							}
						}
					});
					
				},'json');
			});
		</script>
	</head>
	<body>
		<form action="../saveRoleFunctions.action" method="post">
			<input type="hidden" name="rno" value="${param.rno }" id="rno">
			<p align="center">
				<input type="submit" value="添加功能">
			</p>
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
		</form>
	</body>
</html>