package org.tsk.mng.backend.result;

import java.util.List;

import org.tsk.mng.backend.enums.OperationStatusType;
import org.tsk.mng.backend.model.TaskBE;

public class TaskResultBE {

	private OperationStatusType status;
	private List<TaskBE> tasks;
	
	
	public OperationStatusType getStatus() {
		return status;
	}
	public void setStatus(OperationStatusType status) {
		this.status = status;
	}
	public List<TaskBE> getTasks() {
		return tasks;
	}
	public void setTasks(List<TaskBE> tasks) {
		this.tasks = tasks;
	}
	
	
}
