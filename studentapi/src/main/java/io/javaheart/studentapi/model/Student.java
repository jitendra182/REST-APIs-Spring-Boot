package io.javaheart.studentapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	@Id
	private int sid;
	private String sname;
	private String std;
	private String strm;
	
	
	public Student() {
		
	}
	
	public Student(int sid, String sname, String std, String strm) {
		this.sid = sid;
		this.sname = sname;
		this.std = std;
		this.strm = strm;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public String getStrm() {
		return strm;
	}
	public void setStrm(String strm) {
		this.strm = strm;
	}
}
