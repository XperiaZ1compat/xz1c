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

public class IncludeFilter implements Filter {	
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;		
		String originalUrl=req.getRequestURI();

	
		if(!originalUrl.endsWith("js")){
			req.getServletContext().getRequestDispatcher("/head.jsp").include (request,response);
			chain.doFilter(request, response);	
			req.getServletContext().getRequestDispatcher("/foot.jsp").include (request,response);			
		}else
			chain.doFilter(request, response);	
	}
	
	public void destroy() {}
	public void init(FilterConfig filterConfig) throws ServletException {	}	
}
