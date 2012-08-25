package org.tsk.mng.backend.model;

import java.util.Date;
import java.util.List;

import org.tsk.mng.backend.enums.TaskStatusType;

public class TaskBE {

	private int taskId;
	private String descriptions;
	private Date alert;
	private Date deadline;
	private UserBE owner;
	private TaskStatusType status;
	private List<TaskBE> dependentTasks;
	
	

	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public Date getAlert() {
		return alert;
	}
	public void setAlert(Date alert) {
		this.alert = alert;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public UserBE getOwner() {
		return owner;
	}
	public void setOwner(UserBE owner) {
		this.owner = owner;
	}
	public TaskStatusType getStatus() {
		return status;
	}
	public void setStatus(TaskStatusType status) {
		this.status = status;
	}
	public List<TaskBE> getDependentTasks() {
		return dependentTasks;
	}
	public void setDependentTasks(List<TaskBE> dependentTasks) {
		this.dependentTasks = dependentTasks;
	}
	
	
	@Override
	public String toString() {
		return "TaskID: " + taskId + " Owner: " + owner + "Status: " + status;
	}

	
}