<%@ page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<style type="text/css">
			#box{
				width: 800px;
				height: 400px;
				margin: 50px auto;
			}
			#left{
				width: 298px;
				height: 400px;
				border: 1px solid black;
				float: left;
			}
			#btns{
				width: 200px;
				height: 400px;
				float: left;
				text-align: center;
			}
			#right{
				width: 298px;
				height: 400px;
				border: 1px solid black;
				float: left;
			} 
			#leftBtn,#rightBtn{
				width: 80px;
				height: 30px;
				margin-top: 80px;
			}
			ul li{
				list-style-type: none;
				border-bottom: 1px dotted black;
				cursor: pointer;
			}
		</style>
		<script type="text/javascript" src="../js/jQuery3.3.1.js"></script>
		<script type="text/javascript">
			$(function () {
				$.post('../unLinkRoles.do',{cno:$('#cno').val()},function(roles){
					for(var i=0;i<roles.length;i++){
						$('#left ul').append('<li>'+roles[i].rno+'|'+roles[i].rname+'</li>');
					}
					toRightClick();
				},'json');
				
				$.post('../linkRoles.do',{cno:$('#cno').val()},function(roles){
					for(var i=0;i<roles.length;i++){
						$('#right ul').append('<li>'+roles[i].rno+'|'+roles[i].rname+'</li>');
					}
					toLeftClick();
				},'json');
				
				$('#rightBtn').click(function () {
					$('#left ul li').appendTo('#right ul');
					toLeftClick();
				});
				$('#leftBtn').click(function () {
					$('#right ul li').appendTo('#left ul');
					toRightClick();
				});
				
				$('#submitBtn').click(function () {
					var cno = $('#cno').val();
					var rnos = '';
					$('#right ul li').each(function (i,li) {
						var str = $(li).html();
						var i = str.indexOf('|');
						var rno = str.substring(0,i);
						rnos+= rno+',';
					});
					location = '../setRoles.do?cno='+cno+'&rnos='+rnos;
				});
				
			});
			
			function toRightClick() {
				$('#left ul li').off('dblclick').dblclick(function () {
					$('#right ul').append($(this));
					toLeftClick();
				});
			}
			function toLeftClick() {
				$('#right ul li').off('dblclick').dblclick(function () {
					$('#left ul').append($(this));
					toRightClick();
				});
			}
		</script>
	</head>
	<body>
		<input type="hidden" value="${param.cno }" name="cno" id="cno"/>
		<div id="box">
			<div id="left">
				<ul></ul>
			</div>
			<div id="btns">
				<input type="button" value=">>" id="rightBtn"/><br>
				<input type="button" value="&lt&lt" id="leftBtn"/>
			</div>
			<div id="right">
				<ul></ul>
			</div>
		</div>
		<p align="center">
			<input type="button" id="submitBtn" value="提交">
		</p>
	</body>
</html>