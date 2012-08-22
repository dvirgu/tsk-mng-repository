package org.tsk.mng.backend.Impl;

import org.tsk.mng.backend.model.TaskBE;
import org.tsk.mng.backend.model.UserBE;
import org.tsk.mng.backend.service.TaskMangementBEService;
import org.tsk.mng.dal.dao.interfaces.TaskDao;

public class TaskManagementBEServiceImpl implements TaskMangementBEService {

	TaskDao taskDao;
	
	
	public TaskDao getTaskDao() {
		return taskDao;
	}

	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	
	public UserBE assignUserToTask(UserBE user, TaskBE task) {
		// TODO Auto-generated method stub
		return null;
	}

	public TaskBE getUserTasks(UserBE user) {
		// TODO Auto-generated method stub
		return null;
	}

	public TaskBE removeTaskFromUser(UserBE user, TaskBE task) {
		// TODO Auto-generated method stub
		return null;
	}

	public TaskBE updateTask(TaskBE task) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserBE addDependencyToTask(TaskBE task, TaskBE dependentTask) {
		// TODO Auto-generated method stub
		return null;
	}

}
