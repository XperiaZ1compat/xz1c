<%@ page language="java" import="java.util.*,javabean.Cart" pageEncoding="UTF-8"%>
<!doctype html>
<html>  <head></head>
  
  <body>
  	<% 	Cart cart=(Cart) session.getAttribute("cart");
		if(cart==null){//第一次加入购物车
			cart=new Cart();
		}				
	%>	
	<form action='/homework2/servlet/CartServlet?type=edit' method='post'>
		<table width='500' height='120' border='1'>
			<tr bgcolor='#FFACAC'>
				<td><input id='checkboxAll' type='checkbox' onchange='checkAll(this);'></td>
				<td>商品</td>
				<td>单价</td>
				<td>数量</td>
				<td>小计</td>
			</tr>		
		<% for(int i=0;i<cart.getGoods().size();i++){ %>
			<tr bgcolor='#F1FAFA'>
				<td><input name='checkbox1'  type='checkbox'></td>
				<td><%=cart.getGoods().get(i).getName()%></td>
				<td><%=cart.getGoods().get(i).getPrice()%></td>
				<td><input type='button' value='-' onClick="changeOne('<%=cart.getGoods().get(i).getName()%>',-1)">
					<input type='text' oldValue='' name='<%=cart.getGoods().get(i).getName()%>' id='<%=cart.getGoods().get(i).getName()%>' 
							onChange='check(this)' onFocus='remember(this)' value='<%=cart.getGoods().get(i).getNumber()%>'>
					<input type='button' value='+' onClick="changeOne('<%=cart.getGoods().get(i).getName()%>',1)"></td>
				<td><%=cart.getGoods().get(i).getTotal()%></td>
			</tr>	
		<% } %>			
			<tr bgcolor='#FFACAC'>
				<td colspan='2'><input type='button' value='删除所选' onClick='deleteCheck()'></td>
				<td><input type='submit' value='提交'></td>
				<td align='right'>总计：</td>
				<td id='total'><%=cart.getTotalMoney()%></td>
			</tr>
		</table>
	</form>
</body>
<script type='text/javascript' src='/homework2/js/cartEdit.js'></script>
</html>  
    
  </body>
</html>
