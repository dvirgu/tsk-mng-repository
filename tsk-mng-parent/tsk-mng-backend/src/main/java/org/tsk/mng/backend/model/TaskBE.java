package org.tsk.mng.backend.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.tsk.mng.backend.enums.TaskStatusType;
import org.tsk.mng.backend.model.strategy.StatusStrategy;
import org.tsk.mng.common.config.Consts;
import org.tsk.mng.common.infra.SpringInitializer;
import org.tsk.mng.common.infra.TransformerUtil;
import org.tsk.mng.dal.dao.impl.TaskDaoImpl;
import org.tsk.mng.dal.dao.impl.UserDaoImpl;
import org.tsk.mng.dal.dao.interfaces.TaskDao;
import org.tsk.mng.dal.dao.interfaces.UserDao;
import org.tsk.mng.dal.model.TaskDT;
import org.tsk.mng.dal.model.UserDT;

public class TaskBE implements Comparable<TaskBE> {

	private int taskId;
	private String descriptions;
	private Date alert;
	private Date deadline;
	private String owner;
	private TaskStatusType status;
	private Set<TaskBE> meDependOnTasks;
	private Set<Integer> dependOnMeTasks;
	
	

	public TaskBE() {
		String beanId = SpringInitializer.getBeanFactory().getBean(Consts.SET_IMPL_PROPERTY ,String.class);
		meDependOnTasks = (Set) SpringInitializer.getBeanFactory().getBean(beanId);
		dependOnMeTasks = (Set) SpringInitializer.getBeanFactory().getBean(beanId);
	}
	
	public void addTask(TaskBE task){
		meDependOnTasks.add(task);
	}
	public void setOwnerValueBE(UserDT ownerObj){
		this.owner = ownerObj.getMail();
	}
	
	public void setDependOnMeTasksValueBE(List<TaskDT> taskDTSet) {
		for(TaskDT taskDT : taskDTSet){
			dependOnMeTasks.add(taskDT.getTaskId());
		}
	}

	public Set<Integer> getDependOnMeTasks() {
		return dependOnMeTasks;
	}

	public void setDependOnMeTasks(Set<Integer> dependOnMeTasks) {
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
		
		status.handle(getDepenedentTaskFromDB(), this);
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
	
	public Set<TaskBE> getDepenedentTaskFromDB(){
		TaskDao dao = SpringInitializer.getBeanFactory().getBean(Consts.TASK_DAO_BEAN_ID, TaskDao.class);
		Set<TaskBE> taskBeSet = new HashSet<TaskBE>();
		for(Integer taskId : dependOnMeTasks){
			TaskDT taskDT = dao.getByPK(taskId);
			TaskBE taskBE = TransformerUtil.dozerConvert(taskDT, TaskBE.class);
			taskBeSet.add(taskBE);
		}
	
		return taskBeSet;
	}
	
	@Override
	public String toString() {
		return "TaskID: " + taskId + " Owner: " + owner + "Status: " + status;
	}



}
