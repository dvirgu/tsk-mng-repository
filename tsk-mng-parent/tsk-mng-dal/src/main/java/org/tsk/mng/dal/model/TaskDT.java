package org.tsk.mng.dal.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TASK_DETAILS")
public class TaskDT {

	public enum TaskStatusType {

		Done,
		InProgress,
		NotStarted,
		Waiting,
		Failed
	}
	
	@Id
	@Column(name="ID")
	private int taskId;
	
	@Column(name="DESCRIPTION")
	private String descriptions;
	
	@Column(name="ALERT")
	private Date alert;
	
	@Column(name="DEADLINE")
	private Date deadline;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="OWNER_MAIL")
	private UserDT owner;
	
	@Column(name="STATUS")
	@Enumerated(EnumType.ORDINAL)
	private TaskStatusType status;
	
	@ManyToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinTable(name="DEPENDENT_TASKS", joinColumns=@JoinColumn(name="TASK_ID"), inverseJoinColumns=@JoinColumn(name="DEPENDENT_TASK_ID"))
	private List<TaskDT> meDependOnTasks;
	
	@ManyToMany(mappedBy="meDependOnTasks" ,fetch=FetchType.EAGER)
	private List<TaskDT> dependOnMeTasks;
	
	
	public List<TaskDT> getDependOnMeTasks() {
		return dependOnMeTasks;
	}
	public void setDependOnMeTasks(List<TaskDT> dependOnMeTasks) {
		this.dependOnMeTasks = dependOnMeTasks;
	}
	public List<TaskDT> getMeDependOnTasks() {
		return meDependOnTasks;
	}
	public void setMeDependOnTasks(List<TaskDT> dependentTasks) {
		this.meDependOnTasks = dependentTasks;
	}
	public List<TaskDT> getDependOnMyTasks() {
		return dependOnMeTasks;
	}
	public void setDependOnMyTasks(List<TaskDT> dependOnMyTasks) {
		this.dependOnMeTasks = dependOnMyTasks;
	}
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
	
	public UserDT getOwner() {
		return owner;
	}
	public void setOwner(UserDT owner) {
		this.owner = owner;
	}
	public TaskStatusType getStatus() {
		return status;
	}
	public void setStatus(TaskStatusType status) {
		this.status = status;
	}
	
	
	
	
}
