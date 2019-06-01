/**
 * 
 */
package com.xiudun.roleAction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiudun.domain.Role;
import com.xiudun.service.roleService;

import net.sf.json.JSONArray;

/**
 * @author Administrator
 *
 */
@WebServlet("/unLinkRoles.do")
public class UnLinkRolesAction extends HttpServlet{
	private roleService service = new roleService();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String cno = arg0.getParameter("cno");
		List<Role> list = service.findUnLink(cno);
		String json = JSONArray.fromObject(list).toString();
		arg1.setContentType("text/json;charset=utf-8");
		arg1.getWriter().write(json);
	}
}
















