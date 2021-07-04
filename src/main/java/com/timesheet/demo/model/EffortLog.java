package com.timesheet.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class EffortLog {
	
	@Id
	private int logId;
	@OneToOne
	@JoinColumn(name="eid", nullable=false)
	private EffortTracker effTrack;
	@OneToMany
	@JoinColumn(name="tid", nullable=false)
	private List<Task> tasks;
	private int efforts;
	private Date eDate;
	private Date submittedDate;
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public int getEfforts() {
		return efforts;
	}
	public void setEfforts(int efforts) {
		this.efforts = efforts;
	}
	public Date geteDate() {
		return eDate;
	}
	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}
	public Date getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}
	public EffortTracker getEffTrack() {
		return effTrack;
	}
	public void setEffTrack(EffortTracker effTrack) {
		this.effTrack = effTrack;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	@Override
	public String toString() {
		return "EffortLog [logId=" + logId + ", effTrack=" + effTrack + ", tasks=" + tasks + ", efforts=" + efforts
				+ ", eDate=" + eDate + ", submittedDate=" + submittedDate + "]";
	}
}
