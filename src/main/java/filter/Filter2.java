package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/AddCartServlet"})
public class Filter2 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		resp.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); // http 1.1
		resp.setHeader("Pragma", "no-cache");// http 1.0
		
		if(req.getSession().getAttribute("u")==null)
			resp.sendRedirect("login.jsp");
		else
			chain.doFilter(req, resp);
		
	}

}
