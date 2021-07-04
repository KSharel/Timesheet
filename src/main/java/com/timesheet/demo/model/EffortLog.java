package com.timesheet.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EffortLog {
	
	@Id
	private int logId;
	@ManyToOne
	@JoinColumn(name="eid", nullable=false)
	private EffortTracker effTrack;
	@ManyToOne
	@JoinColumn(name="tid", nullable=false)
	private Task task;
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
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	@Override
	public String toString() {
		return "EffortLog [logId=" + logId + ", effTrack=" + effTrack + ", tasks=" + task + ", efforts=" + efforts
				+ ", eDate=" + eDate + ", submittedDate=" + submittedDate + "]";
	}
}
