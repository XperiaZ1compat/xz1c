<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head></head>
  
  <body>
	<table width='600' height='120' border='1'> 
		<tr bgcolor='#F1FAFA'>
			<td>成功添加到购物车!</td>	
			<td><a href='/homework2/servlet/CartServlet?type=showCart'>查看购物车</a>
			<td><a href='/homework2/servlet/GoodsServlet?type=showGoods'>返回商品列表</a></td>
			<td><a href='/homework2/servlet/SecurityServlet?type=exit'>注销</a></td>	
		</tr>
	</table>
  </body>
</html>
