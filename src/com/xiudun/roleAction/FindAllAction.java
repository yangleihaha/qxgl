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

/**
 * @author Administrator
 *
 */
@WebServlet("/findAllRole.do")
public class FindAllAction extends HttpServlet{
	private roleService service = new roleService();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		List<Role> list = service.findAll();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(Role r:list) {
			sb.append("{");
			sb.append("\"rno\":"+r.getRno()+",");
			sb.append("\"rname\":\""+r.getRname()+"\",");
			sb.append("\"description\":\""+r.getDescription()+"\"");
			sb.append("},");
			
		}
		sb.delete(sb.length()-1, sb.length());
		sb.append("]");
		arg1.setContentType("text/json;charset=utf-8");
		arg1.getWriter().write(sb.toString());
	}
}














