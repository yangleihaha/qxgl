/**
 * 
 */
package com.xiudun.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiudun.service.Service;

/**
 * @author Administrator
 *
 */
public class RemoveUsersAction extends HttpServlet{
	private Service service = new Service();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String[] cnos = arg0.getParameterValues("cnos");
		service.removeUsers(cnos);
		arg1.sendRedirect("findAll.do");
	}
}
