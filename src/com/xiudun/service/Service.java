/**
 * 
 */
package com.xiudun.service;

import java.util.List;

import com.xiudun.dao.Dao;
import com.xiudun.domain.User;

/**
 * @author Administrator
 *
 */
public class Service {
	private Dao dao = new Dao();
	public User login(String cname,String cpass) {
		return dao.findByNameAndPass(cname, cpass);
	}
	public List<User> findAll(){
		return dao.findAll();
	}
	
	public void insert(User user) {
		dao.insert(user);
	}
	public void removeUser(String cno) {
		dao.removeUser(cno);
	}
	public void removeUsers(String[] cnos) {
		for(String s:cnos) {
			dao.removeUser(s);
		}
	}
	public User selectOne(String cno) {
		return dao.selectOne(cno);
	}
	public void updateUser(User user) {
		dao.updateUser(user);
	}
}
