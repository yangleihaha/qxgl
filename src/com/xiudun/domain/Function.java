/**
 * 
 */
package com.xiudun.domain;

import java.io.Serializable;

import org.xiudun.mvc.Data;

/**
 * @author Administrator
 *
 */
public class Function implements Serializable,Data{
	private static final long serialVersionUID = 2381882319658330421L;
	private Integer fno;
	private String fname;
	private String url;
	private Integer pno;
	private String pname;
	/**
	 * 
	 */
	public Function() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param fno
	 * @param fname
	 * @param url
	 * @param pno
	 * @param pname
	 */
	public Function(Integer fno, String fname, String url, Integer pno, String pname) {
		super();
		this.fno = fno;
		this.fname = fname;
		this.url = url;
		this.pno = pno;
		this.pname = pname;
	}
	public Integer getFno() {
		return fno;
	}
	public void setFno(Integer fno) {
		this.fno = fno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getPno() {
		return pno;
	}
	public void setPno(Integer pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "function [fno=" + fno + ", fname=" + fname + ", url=" + url + ", pno=" + pno + ", pname=" + pname + "]";
	}
	
}
