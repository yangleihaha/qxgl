/**
 * 
 */
package com.xiudun.roleAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiudun.service.roleService;

/**
 * @author Administrator
 *
 */
@WebServlet("/setRoles.do")
public class SetRolesAction extends HttpServlet{
	private roleService service = new roleService();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String cno = arg0.getParameter("cno");
		String rnos = arg0.getParameter("rnos");
		service.setRoles(cno, rnos);
		arg1.setContentType("text/html;charset=utf-8");
		arg1.getWriter().write("²Ù×÷³É¹¦");
	}
}








