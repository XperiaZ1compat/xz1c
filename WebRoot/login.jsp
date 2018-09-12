<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<html>
<head><meta charset="utf-8">
</head>
  
  <body>
  	<form method="post" action="/homework2/servlet/SecurityServlet?type=login">
		<table>
    	<tr><td>用户验证录入:<br />用户名：<input type="text" name="name"/></td></tr>
		<tr><td>密码：<input type="password" name="password"/></td></tr>
		</table>
		<input type="submit"  value="提交"/>
	</form>
  </body>
</html>
