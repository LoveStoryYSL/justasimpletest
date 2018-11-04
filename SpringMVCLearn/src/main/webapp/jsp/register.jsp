<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript"src="./js/register.js"></script>
  </head>
  
  <body>
    	<form action="user/regist" method="post" onsubmit="return checkInfo()">
    		<table>
    			<tr>
    				<td align="right">用&ensp;户&ensp;名</td>
    				<td align="left"><input type="text" id="name_input" name="name" onblur="checkName()" onfocus="inputName()"></td>
    				<td align="left"><span style="display: none;color: red;" id="name_span"></span></td>
    			</tr>
    			<tr>
    				<td align="right">昵&ensp;&ensp;&ensp;&ensp;称</td>
    				<td align="left"><input type="text" id="nick_input" name="nick" onblur="checkNick()" onfocus="inputNick()"></td>
    				<td align="left"><span style="display: none;color: red;" id="nick_span"></span></td>
    			</tr>
    			<tr>
    				<td align="right">密&ensp;&ensp;&ensp;&ensp;码</td>
    				<td align="left"><input type="password" id="pass_input" name="password" onblur="checkPass()" onfocus="inputPass()"></td>
    				<td align="left"><span style="display: none;color: red;" id="pass_span"></span></td>
    			</tr>
    			<tr>
    				<td align="right">确认密码</td>
    				<td align="left"><input type="password" id="pass_check" name="" onblur="checkCheck()" onfocus=""></td>
    				<td align="left"><span style="display: none;color: red;" id="check_span"></span></td>
    			</tr>
    			
    			<tr>
    			<td align="right"><button type="submit">提交</button></td>
    			<td align="left"><button type="reset">重置</button></td>
    			<td><a href="demo12">验证</a></td>
    			</tr>
    			
    		</table>
    	</form>
  </body>
</html>
