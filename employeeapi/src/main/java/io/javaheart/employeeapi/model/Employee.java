package io.javaheart.employeeapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	private int eid;
	private String ename;
	private String epost;
	private String edept;
	
	
	public Employee() {
		
	}
	
	public Employee(int eid, String ename, String epost, String edept) {
		this.eid = eid;
		this.ename = ename;
		this.epost = epost;
		this.edept = edept;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEpost() {
		return epost;
	}
	public void setEpost(String epost) {
		this.epost = epost;
	}
	public String getEdept() {
		return edept;
	}
	public void setEdept(String edept) {
		this.edept = edept;
	}
}
