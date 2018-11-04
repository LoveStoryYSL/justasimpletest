<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login Page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	window.onload=function ()
	{
		
		var message="${errorMessage}";
		if(message=="")
		{
			document.getElementById("errorSpan").style.display="none";
		}
		else
		{
			document.getElementById("errorSpan").style.display="inline";
			document.getElementById("errorSpan").style.color="red";
		}
	}
	
	</script>
  </head>
  
  <body>
  	<form method="post" action="login">
  		<table>
  			<tr>
  				<td></td>
  				<td><span id="errorSpan" style="display: none">${errorMessage}</span></td>
  			</tr>
  			<tr>
  				<td align="right">用户名</td>
  				<td align="left"><input type="text" name="username"></td>
  			</tr>
  			<tr>
  				<td align="right">密&ensp;&ensp;码</td>
  				<td align="left"><input type="password" name="password"></td>
  			</tr>
  			<tr>
  				<td align="right"><input type="submit" value="登录"></td>
  				<td align="left"><input type="reset" value="重置"></td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>
