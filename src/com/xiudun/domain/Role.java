/**
 * 
 */
package com.xiudun.domain;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class Role implements Serializable{

	private static final long serialVersionUID = -6448356377276382139L;
	private Integer rno;
	private String rname;
	private String description;
	/**
	 * 
	 */
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param rno
	 * @param rname
	 * @param description
	 */
	public Role(Integer rno, String rname, String description) {
		super();
		this.rno = rno;
		this.rname = rname;
		this.description = description;
	}
	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Role [rno=" + rno + ", rname=" + rname + ", description=" + description + "]";
	}
	
}
