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

import model.User;

@WebFilter(urlPatterns =  {"/registerbook.jsp","/update.jsp","/DeleteServlet"})
public class LoginFilter implements Filter {
	
	// this will prevent users from accessing secured web pages, a login is required to access them
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// ServletRequest is a parent class to httpServletRequest, same for the response classes
		
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		if(req.getSession().getAttribute("u")==null)
			resp.sendRedirect("login.jsp");
		else {	
			User u = (User)req.getSession().getAttribute("u");
			if(!u.getRole().equals("admin")) // this will check is the session is valid or not
				// only the child class can give the getSession() method
				// this will also check if the user is admin or not
				// if not they will be redirected to the login page until admin can login
				resp.sendRedirect("login.jsp"); // if not it will send the user ti the login page
		}
		
		
		chain.doFilter(req, resp); // this means to go to the next page after login, pages that are protected by filter
		// will be visible after login after mentioning this method
	}

}
