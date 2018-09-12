<%@ page language="java" import="java.util.*,javabean.Cart" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head></head>
  
  <body>
  		<% 	Cart cart=(Cart) session.getAttribute("cart");
			if(cart==null){//第一次加入购物车
				cart=new Cart();
			}				
		%>			
		<table width='324' height='120' border='1'> 
			<tr bgcolor='#FFACAC'>
				<td>商品</td><td>单价</td><td>已购买数量</td><td>小计</td>			
			</tr>			
		<% for(int i=0;i<cart.getGoods().size();i++){ %>			
			<tr bgcolor='#F1FAFA'>
				<td><%=cart.getGoods().get(i).getName()%></td>
				<td><%=cart.getGoods().get(i).getPrice()%></td>
				<td><%=cart.getGoods().get(i).getNumber()%></td>
				<td><%=cart.getGoods().get(i).getTotal()%></td>
			</tr>				
		<% } %>	
			<tr bgcolor='#FFACAC'>
				<td colspan='2'><a href='/homework2/servlet/CartServlet?type=editShow'>编辑购物车</a></td>
				<td colspan='2' align='right'>总计：<%=cart.getTotalMoney()%></td>
			</tr>
		</table>
  </body>
</html>
