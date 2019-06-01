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
@WebServlet("/findOneRole.do")
public class FindOneRole extends HttpServlet{
	private roleService service = new roleService();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String rno = arg0.getParameter("rno");
		Role r = service.findOneRole(rno);
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"rno\":"+r.getRno()+",");
		sb.append("\"rname\":\""+r.getRname()+"\",");
		sb.append("\"description\":\""+r.getDescription()+"\"");
		sb.append("}");
		arg1.setContentType("text/json;charset=utf-8");
		arg1.getWriter().write(sb.toString());
		
	}
}
