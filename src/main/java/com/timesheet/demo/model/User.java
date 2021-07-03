package com.timesheet.demo.model;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class User {

	@Id
	private int uid;
	private String uname;
	private String dept;
	private String role;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", dept=" + dept + ", role=" + role + "]";
	}
	
}
