/**
 * 
 */
package com.xiudun.dao;

import java.util.List;

import org.xiudun.jdbc.BaseDao;

import com.xiudun.domain.Function;

/**
 * @author Administrator
 *
 */
public class funDao extends BaseDao{
	public List<Function> findAllFun() {
		String sql = "select f.*,'' pname from t_function f";
		return super.selectList(sql, Function.class);
	}
	public void save(Function f) {
		String sql="insert into t_function values(null,?,?,?)";
		super.insert(sql, f.getFname(),f.getUrl(),f.getPno());
	}
	public List<Function> parentFunctions(){
		String sql = "select f.*,'' pname from t_function f where pno = -1";
		return super.selectList(sql, Function.class);
	}
	public List<Function> linkFunctions(int rno){
		String sql = "select f.*,'' pname from t_function f where fno in (select fno from t_role_function where rno=?)";
		return super.selectList(sql, Function.class, rno);
	}
	public void removeRoleFunctions(int rno) {
		String sql="delete from t_role_function where rno=?";
		super.delete(sql, rno);
	}
	public void saveRoleFunctions(int rno,int fno) {
		String sql="insert into t_role_function values(null,?,?)";
		super.insert(sql, rno,fno);
	}
	
	public List<Function> currentFunctions(int cno){
		String sql="select t_function.*,'' pname from t_function where fno in(select fno from t_role_function where rno in(select rno from t_user_role where cno=?))";
		return super.selectList(sql, Function.class, cno);
	}
	
	public void updateParentFun(String fname,int fno) {
		String sql = "update t_function set fname=? where fno=?";
		super.update(sql, fname,fno);
	}
}








