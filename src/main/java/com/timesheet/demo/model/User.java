package com.timesheet.demo.model;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {

	@Id
	private int uid;
	private String uname;
	private String dept;
	private String role;
	@ManyToMany
	private List<Project> projects;
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
	
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", dept=" + dept + ", role=" + role + "]";
	}
	
}
