package org.tsk.mng.backend.model;

import java.util.Date;
import java.util.Set;

import org.tsk.mng.backend.enums.TaskStatusType;
import org.tsk.mng.backend.model.strategy.StatusStrategy;
import org.tsk.mng.common.config.Consts;
import org.tsk.mng.common.infra.SpringInitializer;

public class TaskBE implements Comparable<TaskBE> {

	private int taskId;
	private String descriptions;
	private Date alert;
	private Date deadline;
	private String owner;
	private TaskStatusType status;
	private Set<TaskBE> meDependOnTasks;
	private Set<TaskBE> dependOnMeTasks;
	
	

	public TaskBE() {
		String beanId = SpringInitializer.getBeanFactory().getBean(Consts.SET_IMPL_PROPERTY ,String.class);
		meDependOnTasks = (Set) SpringInitializer.getBeanFactory().getBean(beanId);
		dependOnMeTasks = (Set) SpringInitializer.getBeanFactory().getBean(beanId);
	}

	public Set<TaskBE> getDependOnMeTasks() {
		return dependOnMeTasks;
	}

	public void setDependOnMeTasks(Set<TaskBE> dependOnMeTasks) {
		this.dependOnMeTasks = dependOnMeTasks;
	}
	
	public Set<TaskBE> getMeDependOnTasks() {
		return meDependOnTasks;
	}

	public void setMeDependOnTasks(Set<TaskBE> meDependOnTasks) {
		this.meDependOnTasks = meDependOnTasks;
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public TaskStatusType getStatus() {
		return status;
	}

	public void setStatus(TaskStatusType status) {
		this.status = status;
	}

	

	@Override
	public int compareTo(TaskBE otherTask) {
		return this.deadline.compareTo(otherTask.getDeadline());
	}

	@Override
	public int hashCode() {

		return new Integer(taskId).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		TaskBE otherTask = null;
		
		if(obj instanceof TaskBE){
			otherTask = (TaskBE) obj;
		} else {
			return false;
		}
		
		return taskId == otherTask.getTaskId();
	}
	
	public void notify(StatusStrategy status){
		status.handle(dependOnMeTasks, this);
	}
	
	public void removeTask(TaskBE taskToRemove){
		meDependOnTasks.remove(taskToRemove);
	}
	
	public void doneTask(TaskBE taskDone){
		meDependOnTasks.remove(taskDone);
	}
	
	public void alertTask(){
		status = TaskStatusType.ALERTED;
	}
	
	public StatusStrategy checkStatus(){
		
		
		
		return null;
	}
	
	@Override
	public String toString() {
		return "TaskID: " + taskId + " Owner: " + owner + "Status: " + status;
	}



}
