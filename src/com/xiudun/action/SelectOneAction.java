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
public class SelectOneAction extends HttpServlet{
	private Service service = new Service();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String cno = arg0.getParameter("cno");
		User user = service.selectOne(cno);
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"cno\":"+user.getCno()+",");
		sb.append("\"cname\":\""+user.getCname()+"\",");
		sb.append("\"cpass\":\""+user.getCpass()+"\",");
		sb.append("\"truename\":\""+user.getTruename()+"\"");
		sb.append("}");
		arg1.setContentType("text/json;charset=utf-8");
		arg1.getWriter().write(sb.toString());
	}
}
