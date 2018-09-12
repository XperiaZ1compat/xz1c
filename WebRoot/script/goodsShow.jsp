<%@ page language="java" import="java.util.*,javabean.Good" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head></head><body>
  
    <% List<Good> goods=(ArrayList<Good>) this.getServletContext().getAttribute("goods");%>
    <table width='324' height='120' border='1'> 
    	<tr bgcolor='#FFACAC'>
    		<td>商品</td><td>单价</td><td>添加到购物车</td>
    	</tr>
	<% for(int i=0;i<goods.size();i++){
		Good good=goods.get(i);		%>		
		<tr bgcolor='#F1FAFA'>
			<td><%=good.getName()%></td>
			<td><%=good.getPrice()%></td>				
			<td><a href='/homework2/servlet/CartServlet?type=addCart&<%=good.getName()%>=<%=good.getName()%>'>加入购物车</a></td>
		</tr>
	<%}%>					
	</table>	
</BODY></HTML>
