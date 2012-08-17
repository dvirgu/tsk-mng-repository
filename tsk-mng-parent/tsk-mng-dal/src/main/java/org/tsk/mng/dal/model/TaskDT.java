package org.tsk.mng.dal.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.tsk.mng.backend.enums.TaskStatusType;
import org.tsk.mng.backend.model.TaskBE;
import org.tsk.mng.backend.model.UserBE;

@Entity
@Table(name = "TASK_DETAILS")
public class TaskDT {

	@Id
	@Column(name="ID")
	private int taskId;
	
	@Column(name="DESCRIPTION")
	private String descriptions;
	
	@Column(name="ALERT")
	private Date alert;
	
	@Column(name="DEADLINE")
	private Date deadline;
	
	@Column(name="OWNER")
	private UserBE owner;
	
	@Column(name="STATUS")
	private TaskStatusType status;
	
	@ManyToMany
	@JoinTable(name="DEPENDENT_TASKS", joinColumns=@JoinColumn(name="TASK_ID"), inverseJoinColumns=@JoinColumn(name="DEPENDENT_TASK_ID"))
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
	
	
	
}
