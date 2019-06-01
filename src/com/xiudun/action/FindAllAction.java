/**
 * 
 */
package com.xiudun.action;

import java.io.IOException;
import java.util.List;

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
public class FindAllAction extends HttpServlet{
	private Service service = new Service();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		List<User> list = service.findAll();
		arg0.setAttribute("list", list);
		arg0.getRequestDispatcher("index.jsp").forward(arg0, arg1);
	}
}
