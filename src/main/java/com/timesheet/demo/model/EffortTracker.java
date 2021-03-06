package com.timesheet.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class EffortTracker {

	@Id
	private int eid;
	@ManyToOne
	@JoinColumn(name="pid", nullable=false)
	private Project pid;
	@ManyToOne
	@JoinColumn(name="uid", nullable=false)
	private User uid;
	private String Status;
	@OneToMany
	private List<EffortLog> effLog;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public Project getPid() {
		return pid;
	}
	public void setPid(Project pid) {
		this.pid = pid;
	}
	public User getUid() {
		return uid;
	}
	public void setUid(User uid) {
		
		this.uid = uid;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public List<EffortLog> getEffLog() {
		return effLog;
	}
	public void setEffLog(List<EffortLog> effLog) {
		this.effLog = effLog;
	}
	@Override
	public String toString() {
		return "EffortTracker [eid=" + eid + ", pid=" + pid + ", uid=" + uid + ", Status=" + Status + ", effLog="
				+ effLog + "]";
	}
}
