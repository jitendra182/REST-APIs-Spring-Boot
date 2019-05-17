package io.javaheart.customerapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	private int cid;
	private String cname;
	private String caddress;
	private long cphon;
	
	public Customer() {
	}
	
	
	public Customer(int cid, String cname, String caddress, long cphon) {
		this.cid = cid;
		this.cname = cname;
		this.caddress = caddress;
		this.cphon = cphon;
	}
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public long getCphon() {
		return cphon;
	}
	public void setCphon(long cphon) {
		this.cphon = cphon;
	}
	
}