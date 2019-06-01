/**
 * 
 */
package com.xiudun.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 *
 */
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String path = request.getRequestURI();
		if(path.indexOf("login.jsp")!=-1 || path.indexOf("login.do")!=-1) {
			arg2.doFilter(arg0, arg1);
		}else if(request.getSession().getAttribute("user")!=null) {
			arg2.doFilter(arg0, arg1);
		}else {
			response.sendRedirect("login.jsp");
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
