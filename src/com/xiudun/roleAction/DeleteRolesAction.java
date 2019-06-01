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
@WebServlet("/deleteRoles.do")
public class DeleteRolesAction extends HttpServlet{
	private roleService service = new roleService();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String[] rnos = arg0.getParameterValues("rnos");
		service.deleteRoles(rnos);
		arg1.sendRedirect("role/roleIndex.jsp");
	}
}
