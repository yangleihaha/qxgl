<%@page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<script type="text/javascript">
			window.onload = function () {
				var xhr = new XMLHttpRequest();
				xhr.open('get','../findAllRole.do',false);
				xhr.onreadystatechange = function () {
					if(xhr.readyState == 4 && xhr.status == 200){
						var r = xhr.responseText;
						callBack(r);
					}
				}
				xhr.send();
			}
			function callBack(r) {
				var list = eval('('+r+')');
				for(var i=0;i<list.length;i++){
					var role = list[i];
					var tr = document.createElement('tr');
					var tbody = document.getElementById('tbody');
					tbody.appendChild(tr);
					var td0 = document.createElement('td');
					var td1 = document.createElement('td');
					var td2 = document.createElement('td');
					var td3 = document.createElement('td');
					var td4 = document.createElement('td');
					
					tr.align = 'center';
					tr.style.background = 'pink';
					tr.appendChild(td0);
					tr.appendChild(td1);
					tr.appendChild(td2);
					tr.appendChild(td3);
					tr.appendChild(td4);
					
					
					td1.innerHTML = role.rno;
					td2.innerHTML = role.rname;
					td3.innerHTML = role.description;
					
					var inputCheckBox = document.createElement('input');
					inputCheckBox.type = 'checkbox';
					
					
					inputCheckBox.setAttribute('form', 'deleteRoles' ); 
					
					
					inputCheckBox.name='rnos';
					inputCheckBox.value=role.rno;
					td0.appendChild(inputCheckBox);
					
					var a = document.createElement('a');
					var a1 = document.createElement('a');
					var a2 = document.createElement('a');
					td4.appendChild(a);
					td4.appendChild(a1);
					td4.appendChild(a2);
					a.href = 'updateRole.jsp?rno='+role.rno;
					a.innerHTML='编辑';
					a1.href='../deleteRole.do?rno='+role.rno;
					a1.innerHTML='删除';
					a2.href = '../fun/sFunction.jsp?rno='+role.rno;
					a2.innerHTML = '设置功能';
					
					var all = document.getElementById('all');
					all.onclick = function () {
						var checkboxs = document.getElementsByName('rnos');
						for(var i=0;i<checkboxs.length;i++){
							checkboxs[i].checked = all.checked;
						}
					}
					
					tr.flag = 0;
					tr.onmouseover = function () {
						this.style.background = 'yellow';
					}
					tr.onmouseout = function () {
						this.style.background = 'pink';
					}
					tr.onclick = function () {
						if(this.flag == 0){
							
							var trs = tbody.getElementsByTagName('tr');
							for(var i=0;i<trs.length;i++){
								if(trs[i] == this){
									continue;
								}else{
									trs[i].style.background = 'pink';
									
									trs[i].onmouseout = function () {
										this.style.background = 'pink';
									}
									trs[i].flag = 0;
								}
							}
							
							
							
							
							this.onmouseout = null;
							this.flag = 1;
						}else{
							this.onmouseout = function () {
								this.style.background = 'pink';
							}
							this.flag = 0;
						}
					}
				}
			}
			
			function deleteroles() {
				var checkboxs = document.getElementsByName('rnos');
				for(var i=0;i<checkboxs.length;i++){
					if(checkboxs[i].checked == true){
						var f = confirm('确认删除吗?');
						if(f){
							var form = document.getElementById('deleteRoles');
							form.submit();
						}
						return;
					}
				}
				alert('请选择要删除的数据!');
			}
		</script>
	</head>
	<body>
		<h2 align="center">角色管理</h2>
		<p align="center">
			<a href="saveRole.jsp">添加角色</a>
			<a href="javascript:deleteroles();">批量删除</a>
			<a href="importRole.jsp">批量添加</a>
			<a href="../exportRole.do">数据导出</a>
		</p>
		
			<table align="center" border="1" cellspacing="0" width="60%">
				<thead>
					<tr bgcolor="pink">
						<th>全选<input type="checkbox" id="all"></th>
						<th>序号</th>
						<th>角色名</th>
						<th>描述</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="tbody">
					
				</tbody>
			</table>
		<form action="../deleteRoles.do" id="deleteRoles" method="post"></form>
	</body>
</html>