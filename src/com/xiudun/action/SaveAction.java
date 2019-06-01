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
public class SaveAction extends HttpServlet{
	private Service service = new Service();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		User user = (User) arg0.getAttribute("user");
		service.insert(user);
		arg1.setContentType("text/html;charset=utf-8");
		arg1.getWriter().write("Ìí¼Ó³É¹¦");
	}
}















