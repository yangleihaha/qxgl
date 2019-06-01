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
@WebServlet("/saveRole.do")
public class SaveRoleAction extends HttpServlet{
	private roleService service = new roleService();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String rname = arg0.getParameter("rname");
		String description = arg0.getParameter("description");
		Role r = new Role();
		r.setRname(rname);
		r.setDescription(description);
		service.saveRole(r);
		arg1.setContentType("text/html;charset=utf-8");
		arg1.getWriter().write("Ìí¼Ó³É¹¦");
	}
}	
