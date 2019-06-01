/**
 * 
 */
package com.xiudun.service;

import java.util.List;

import com.xiudun.dao.roleDao;
import com.xiudun.domain.Role;

/**
 * @author Administrator
 *
 */
public class roleService {
	private roleDao dao = new roleDao();
	public List<Role> findAll(){
		return dao.findAll();
	}
	public void saveRole(Role r) {
		dao.saveRole(r);
	}
	public void deleteRole(String rno) {
		dao.deleteRole(rno);
	}
	public Role findOneRole(String rno) {
		return dao.findOneRole(rno);
	}
	public void updateRole(Role r) {
		dao.updateRole(r);
	}
	public void deleteRoles(String[] rno) {
		for(int i=0;i<rno.length;i++) {
			dao.deleteRole(rno[i]);
		}
	}
	public List<Role> findUnLink(String cno){
		return dao.findUnLink(cno);
	}
	public List<Role> findLink(String cno){
		return dao.findLink(cno);
	}
	public void setRoles(String cno,String rnos) {
		dao.deleteRoles(cno);
		if(rnos!=null && rnos.length()!=0) {
			String[] rnoArray = rnos.split(",");
			for(String s : rnoArray) {
				dao.saveRoles(cno, s);
			}
		}
	}
}
