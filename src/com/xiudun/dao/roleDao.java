/**
 * 
 */
package com.xiudun.dao;

import java.util.List;

import org.xiudun.jdbc.BaseDao;

import com.xiudun.domain.Role;

/**
 * @author Administrator
 *
 */
public class roleDao extends BaseDao{
	public List<Role> findAll() {
		String sql = "select * from t_role";
		return super.selectList(sql, Role.class);
	}
	public void saveRole(Role r) {
		String sql = "insert into t_role values(?,?,?)";
		super.insert(sql, null,r.getRname(),r.getDescription());
	}
	public void deleteRole(String rno) {
		String sql = "delete from t_role where rno=?";
		super.delete(sql, rno);
	}
	public Role findOneRole(String rno) {
		String sql = "select * from t_role where rno=?";
		return super.selectOne(sql, Role.class, rno);
	}
	public void updateRole(Role r) {
		String sql = "update t_role set rname=?,description=? where rno=?";
		super.update(sql, r.getRname(),r.getDescription(),r.getRno());
	}
	public List<Role> findUnLink(String cno){
		String sql = "select * from t_role where rno not in(select rno from t_user_role where cno=?) order by rno";
		return super.selectList(sql, Role.class, cno);
	}
	public List<Role> findLink(String cno){
		String sql = "select * from t_role where rno in(select rno from t_user_role where cno=?) order by rno";
		return super.selectList(sql, Role.class, cno);
	}
	public void deleteRoles(String cno) {
		String sql = "delete from t_user_role where cno=?";
		super.delete(sql, cno);
	}
	public void saveRoles(String cno,String rno) {
		String sql = "insert into t_user_role values(null,?,?)";
		super.insert(sql, cno,rno);
	}
}
