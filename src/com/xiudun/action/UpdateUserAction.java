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
public class UpdateUserAction extends HttpServlet{
	private Service service = new Service();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String cno = arg0.getParameter("cno");
		String cname = arg0.getParameter("cname");
		String cpass = arg0.getParameter("cpass");
		String truename = arg0.getParameter("truename");
		User user = new User();
		user.setCno(Integer.parseInt(cno));
		user.setCname(cname);
		user.setCpass(cpass);
		user.setTruename(truename);
		service.updateUser(user);
		arg1.sendRedirect("findAll.do");
	}
}
