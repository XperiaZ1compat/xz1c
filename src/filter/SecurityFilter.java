package filter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SecurityFilter implements Filter {
	
	public void init(FilterConfig filterConfig) throws ServletException {
		
		Map<String,String> usersMap= new Hashtable<String,String>();

		usersMap.put("tom",filterConfig.getInitParameter("tom"));
		usersMap.put("jerry",filterConfig.getInitParameter("tom"));

		
		filterConfig.getServletContext().setAttribute("usersMap", usersMap);
	}	
	
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest) request;		
		HttpSession session = req.getSession();
		
		if (session.getAttribute("username") != null) {			
			chain.doFilter(request, response);		
		} else {
			String queryString=req.getQueryString();
			String originalUrl=req.getRequestURI();
			originalUrl+="?"+queryString;

			session.setAttribute("originalUrl", originalUrl);	
			
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("/homework2/login.jsp");
		}
	}
	
	public void destroy() {}
}
