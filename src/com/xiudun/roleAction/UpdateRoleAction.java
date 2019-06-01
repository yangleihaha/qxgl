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

import com.xiudun.domain.Role;
import com.xiudun.service.roleService;

/**
 * @author Administrator
 *
 */
@WebServlet("/updateRole.do")
public class UpdateRoleAction extends HttpServlet{
	private roleService service = new roleService();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		int rno = Integer.parseInt(arg0.getParameter("rno"));
		String rname = arg0.getParameter("rname");
		String description = arg0.getParameter("description");
		Role r = new Role();
		r.setRno(rno);
		r.setRname(rname);
		r.setDescription(description);
		service.updateRole(r);
		arg1.sendRedirect("role/roleIndex.jsp");
	}
}
