/**
 * 
 */
package com.xiudun.domain;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class User implements Serializable{

	/**
	 * TODO ÌîÐ´×¢ÊÍ
	 */
	private static final long serialVersionUID = 7203968398717051525L;
	private Integer cno;
	private String cname;
	private String cpass;
	private String truename;
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param cno
	 * @param cname
	 * @param cpass
	 * @param truename
	 */
	public User(Integer cno, String cname, String cpass, String truename) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.cpass = cpass;
		this.truename = truename;
	}
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	@Override
	public String toString() {
		return "User [cno=" + cno + ", cname=" + cname + ", cpass=" + cpass + ", truename=" + truename + "]";
	}
	
}
