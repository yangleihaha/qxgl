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
public class RemoveUserAction extends HttpServlet{
	private Service service = new Service();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String cno = arg0.getParameter("cno");
		service.removeUser(cno);
		arg1.sendRedirect("findAll.do");
	}
}
