package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.User;

//登录验证
public class SecurityServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type=request.getParameter("type");
		
		if("login".equals(type)){
			Map<String,String> usersMap =(Map<String,String>)this.getServletContext().getAttribute("usersMap");
			
			String name =request.getParameter("name");
			String password=request.getParameter("password");
			
			if(password!=null){
				if(password.equals(usersMap.get(name) )){//用户名和密码正确
					request.getSession().setAttribute("username",name );	//保存用户名到session，以后根据它来验证用户是否登录
					String originalUrl=(String)request.getSession().getAttribute("originalUrl");
					response.sendRedirect(originalUrl);//跳转到原始网页					
				}else
					response.sendRedirect("/homework2/login.jsp");//跳转到登录网页
			}else
				response.sendRedirect("/homework2/login.jsp");//跳转到登录网页
			
		}else if("exit".equals(type)){//注销
			//从session中移除username
			request.getSession().removeAttribute("username");
			request.getSession().removeAttribute("cart");
			response.sendRedirect("/homework2/index.jsp");//跳转到登录网页
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		doPost(request,response);
	}
}
