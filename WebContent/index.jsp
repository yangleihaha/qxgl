<%@page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
	<head>
		<style type="text/css">
			table{
				width: 500px;
				text-align: center;
			}
		</style>
		<script type="text/javascript">
			window.onload = function(){
				var all = document.getElementById("all");
				all.onclick = function () {
					var inputs = document.getElementsByName("cnos");
					for(var i=0;i<inputs.length;i++){
						inputs[i].checked = all.checked; 
					}
				}
			}
			function remove() {
				var inputs = document.getElementsByName("cnos");
				for(var i=0;i<inputs.length;i++){
					if(inputs[i].checked == true){
						var f = confirm("确认要删除吗?");
						if(f){
							var form = document.getElementById("removeForm");
							form.submit() ;
						}
						return;
					}
				}
				alert("请选择要删除的信息!");
			}
		</script>
	</head>
	<body>
		<p align="center">
			<a href="saveUser.jsp">添加用户</a>
			<a href="import.jsp">批量添加</a>|
			<a href="export.do">文件下载</a>
			<a href="javascript:remove();">批量删除</a>
		</p>
		<table border="1" cellspacing="0" align="center">
			<tr style="background: pink">
				<td>全选<input type="checkbox" id="all"></td>
				<td>序号</td>
				<td>账号</td>
				<td>密码</td>
				<td>真实姓名</td>
				<td>操作</td>
			</tr>
			<c:choose>
				<c:when test="${requestScope.list == null or requestScope.list.size()==0 }">
					<tr>
						<td colspan="5" align="center">没有任何记录</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${requestScope.list }" var="user" varStatus="i">
						<c:if test="${i.index%2==0 }">
							<tr style="background: yellow">
								<td><input type="checkbox" name="cnos" value="${user.cno }" form="removeForm"></td>
								<td>${user.cno }</td>
								<td>${user.cname }</td>
								<td>${user.cpass }</td>
								<td>${user.truename }</td>
								<td>
									<a href="update.jsp?cno=${user.cno }">编辑</a>|
									<a href="removeUser.do?cno=${user.cno }">删除</a>|
									<a href="role/setRole.jsp?cno=${user.cno }">设置角色</a>
								</td>
							</tr>
						</c:if>
						<c:if test="${i.index%2==1 }">
							<tr style="background: pink">
								<td><input type="checkbox" name="cnos" value="${user.cno }" form="removeForm"></td>
								<td>${user.cno }</td>
								<td>${user.cname }</td>
								<td>${user.cpass }</td>
								<td>${user.truename }</td>
								<td>
									<a href="update.jsp?cno=${user.cno }">编辑</a>|
									<a href="removeUser.do?cno=${user.cno }">删除</a>|
									<a href="role/setRole.jsp?cno=${user.cno }">设置角色</a>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
		</table>
		<form action="removeUsers.do" id="removeForm"></form>
	</body>
</html>