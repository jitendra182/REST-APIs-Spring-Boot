package io.javaheart.productdataapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productdata")
public class ProductData {
	@Id
	private int pid;
	private String pname;
	private String ptype;
	private int pqty;
	
	public ProductData(){
		
	}
	
	public ProductData(int pid, String pname, String ptype, int pqty) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.ptype = ptype;
		this.pqty = pqty;
	}
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public int getPqty() {
		return pqty;
	}

	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
}
