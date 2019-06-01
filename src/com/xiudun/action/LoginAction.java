/**
 * 
 */
package com.xiudun.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiudun.domain.User;
import com.xiudun.service.Service;

/**
 * @author Administrator
 *
 */
public class LoginAction extends HttpServlet{
	private Service service = new Service();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname = request.getParameter("cname");
		String cpass = request.getParameter("cpass");
		User user = service.login(cname, cpass);
		if(user == null) {
			response.sendRedirect("login.jsp?f=9");
		}else {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("main.jsp");
		}
	}
}
