/**
 * 
 */
package com.xiudun.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.xiudun.jdbc.BaseDao;

import com.xiudun.domain.User;

/**
 * @author Administrator
 *
 */
public class Dao extends BaseDao {
	public User findByNameAndPass(String cname,String cpass) {
		// bbbbbbbbbbbbbb
		String sql = "select * from tb_user where cname=? and cpass=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yang","root","root");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cname);
			ps.setString(2, cpass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User user = new User(rs.getInt("cno"),rs.getString("cname"),rs.getString("cpass"),rs.getString("truename"));
				return user;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<User> findAll(){
		String sql = "select * from tb_user";
		List<User> list = selectList(sql, User.class);
		return list;
	}
	public void insert(User user) {
		String sql = "insert into tb_user values(null,?,?,?)";
		insert(sql, user.getCname(),user.getCpass(),user.getTruename());
	}
	public void removeUser(String cno) {
		String sql="delete from tb_user where cno = ?";
		super.delete(sql, cno);
	}
	public User selectOne(String cno) {
		String sql="select * from tb_user where cno=?";
		List<User> list = super.selectList(sql, User.class, cno);
		return list.get(0);
	}
	public void updateUser(User user) {
		String sql="update tb_user set cname=?,cpass=?,truename=? where cno=?";
		super.update(sql, user.getCname(),user.getCpass(),user.getTruename(),user.getCno());
	}
}














