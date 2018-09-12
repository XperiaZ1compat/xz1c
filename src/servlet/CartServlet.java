package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.Cart;
import javabean.Good;
import javabean.GoodItem;

public class CartServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type=request.getParameter("type");
		List<Good> goods=(ArrayList<Good>) this.getServletContext().getAttribute("goods");
		HttpSession session=request.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		if(cart==null){//第一次加入购物车
			cart=new Cart();
		}	
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();		
		
		if("addCart".equals(type)){//从购买商品来	
			for(int i=0;i<goods.size();i++){
				String goodName=goods.get(i).getName();
				String goodNameString=request.getParameter(goodName);
				
				if(goodNameString!=null){//添加的是该商品
					int index=-1;
					//检查购物车中是否有该商品	
					for(int j=0;j<cart.getGoods().size();j++){
						if(goodName.equals(cart.getGoods().get(j).getName())){
							index=j;
							break;
						}						
					}
					
					if(index > -1){//购物车中有该商品						
						//更新购买数量，把数量加1
						cart.getGoods().get(index).setNumber(cart.getGoods().get(index).getNumber()+1);						
					}else{//购物车中没有该商品
						GoodItem goodItem=new GoodItem();
						goodItem.setName(goodName);
						goodItem.setNumber(1);
						goodItem.setPrice(goods.get(i).getPrice());
						cart.getGoods().add(goodItem);
					}
				}				
			}
			session.setAttribute("cart", cart);//保存 更新后的购物车				
			response.sendRedirect("/homework2/script/addCart.jsp");
			
		}else if("showCart".equals(type)){//展示购物车
			response.sendRedirect("/homework2/script/showCart.jsp");
			
		}else if("editShow".equals(type)){//编辑购物车的界面购物车
			response.sendRedirect("/homework2/script/editCart.jsp");
			
		}else if("edit".equals(type)){//编辑购物车
			cart=new Cart();//从新构建购物车
			//遍历客户端提交过来的数据
			Enumeration em = request.getParameterNames();
			 while (em.hasMoreElements()) {
			    String name = (String) em.nextElement();//水果名
			    
			    if(!"type".equals(name)){
					int nowCount=Integer.parseInt(request.getParameter(name));//购买数量

			    	GoodItem goodItem=new GoodItem();
			    	goodItem.setName(name);
			    	goodItem.setNumber(nowCount);
			    	//设置单价
			    	for(Good nowGood:goods) {
			    		if(name.equals(nowGood.getName()))
			    			goodItem.setPrice(nowGood.getPrice());
			    	}
			    	cart.getGoods().add(goodItem); 				  
				 }			 
			 }
			 session.setAttribute("cart", cart);//保存 新的购物车
			 response.sendRedirect("/homework2/servlet/CartServlet?type=showCart");
		}		
	}		
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
}
