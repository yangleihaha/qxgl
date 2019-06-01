<%@page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<style type="text/css">
			dl,dt,dd{
				margin: 0;
				padding: 0;
			}
			.dlBox{
				width: 130px;
				border: 1px solid black;
				text-align: center;
			}
			.dlBox dt{
				height: 40px;
				line-height: 40px;
				cursor:pointer;
			}
			.dlBox > dt{
				background: pink;
				border: 1px solid black;
			}
			.dlBox > dd{
				background: yellow;
				border: 1px solid black; 
				overflow: hidden;
				height: 0px;
			}
		</style>
		<script type="text/javascript">
			window.onload = function () {
				var dlBox = document.getElementById('dlBox');
				var c = dlBox.children;
				for(var i=0;i<c.length;i++){
					if(c[i].tagName == 'DT'){
						c[i].onclick = function () {
							var dd = this.nextElementSibling;
							var h = dd.getElementsByTagName('dt').length*40;
							var ddSt = getComputedStyle(dd,false);
							var height = ddSt.height;
							height = parseInt(height);
							if(height != 0){
								var t1 = window.setInterval(function () {
									h -= 5;
									if(h<=0){
										dd.style.height = 0;
										window.clearInterval(t1);
									}else{
										dd.style.height = h+'px';
									}
								},25);
							}else{
								var lh = 0;
								var t2 = window.setInterval(function () {
									lh += 5;
									if(lh>=h){
										dd.style.height = h+'px';
										window.clearInterval(t2);
									}else{
										dd.style.height = lh+'px';
									}
								},25);
							}
						}
					}
				}
			}
		</script>
	</head>
	<body>
		<dl class="dlBox" id="dlBox">
			<dt>权限管理</dt>
			<dd>
				<dl>
					<dt>
						<a href="findAll.do" target="main">用户管理</a>
					</dt>
					<dt><a href="role/roleIndex.jsp" target="main">角色管理</a></dt>
					<dt><a href="fun/funIndex.jsp" target="main">功能管理</a></dt>
				</dl>
			</dd>
			
			<dt>权限管理</dt>
			<dd>
				<dl>
					<dt>
						用户管理
					</dt>
					<dt>角色管理</dt>
					<dt>功能管理</dt>
				</dl>
			</dd>
			
			<dt>权限管理</dt>
			<dd>
				<dl>
					<dt>
						用户管理
					</dt>
					<dt>角色管理</dt>
					<dt>功能管理</dt>
				</dl>
			</dd>
		</dl>
	</body>
</html>