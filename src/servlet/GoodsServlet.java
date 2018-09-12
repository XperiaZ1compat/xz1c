package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import javabean.Good;

public class GoodsServlet extends HttpServlet {
	public void init(ServletConfig sc) throws ServletException {
		//初始化商品列表
		super.init(sc);
		
		Configuration config;
		ServletContext servletContext=sc.getServletContext();
	
		//读取属性文件
		String fileDir=servletContext.getRealPath("\\WEB-INF\\web.properties");		
		Parameters params = new Parameters();
		
		FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
		    new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
		    .configure(params.properties().setFileName(fileDir));
		
		try{
			config = builder.getConfiguration();
			List<Good> goods=new ArrayList<Good>();
			
			Iterator<String> itr=config.getKeys(); //获取当前Configuration对象可以使用的key
			while(itr.hasNext()){//遍历属性文件中的属性
				String name=itr.next();//属性名
				Double uintPrice=config.getDouble(name);//根据属性名得到属性值
				
				Good good=new Good();
				good.setName(name);
				good.setPrice(uintPrice);
				goods.add(good);				
			}
			
			servletContext.setAttribute("goods", goods);//保存为全局数据
		}catch(ConfigurationException cex){
			cex.printStackTrace();
		}
	}	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type=request.getParameter("type");	
		
		if("showGoods".equals(type)){	
			response.sendRedirect("/homework2/script/goodsShow.jsp");
		}		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}	


}
