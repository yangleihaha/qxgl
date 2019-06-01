/**
 * 
 */
package com.xiudun.funAction;

import java.util.List;

import org.xiudun.mvc.ActionContext;

import com.xiudun.domain.Function;
import com.xiudun.domain.User;
import com.xiudun.service.funService;

import net.sf.json.JSONArray;

/**
 * @author Administrator
 *
 */
public class FunAction {
	private funService service = new funService();
	
	
	private String fname;
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	
	private Function f;
	public void setF(Function f) {
		this.f = f;
	}
	
	private int rno;
	public void setRno(int rno) {
		this.rno = rno;
	}
	
	private int[] fno;
	public void setFno(int[] fno) {
		this.fno = fno;
	}
	
	public String findAllFun() {
		List<Function> list = service.findAllFun();
		String json = JSONArray.fromObject(list).toString();
		return "out:"+json;
	}
	public String savef() {
		Function f = new Function(null,fname,null,-1,null);
		service.save(f);
		return "out:添加成功";
	}
	public String parentFunctions() {
		List<Function> list = service.parentFunctions();
		String json = JSONArray.fromObject(list).toString();
		return "out:"+json;
	}
	public String savez() {
		service.save(f);
		return "out:添加成功";
	}
	
	public String linkFunctions() {
		List<Function> list = service.linkFunctions(rno);
		String json = JSONArray.fromObject(list).toString();
		return "out:"+json;
	}
	public String saveRoleFunctions() {
		service.saveRoleFunctions(rno, fno);
		return "out:添加成功";
	}
	
	public String currentFunctions() {
		User user = (User) ActionContext.getContext().getReq()
				.getSession().getAttribute("user");
		List<Function> list = service.currentFunctions(user.getCno());
		String json = JSONArray.fromObject(list).toString();
		return "out:"+json;
	}
	
	public String updateParentFun() {
		service.updateParentFun(fname, fno[0]);
		return "out:修改成功";
	}
}
