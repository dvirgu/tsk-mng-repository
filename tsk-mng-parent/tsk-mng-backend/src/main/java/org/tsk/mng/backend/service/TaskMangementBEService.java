package org.tsk.mng.backend.service;

import org.tsk.mng.backend.model.TaskBE;
import org.tsk.mng.backend.model.UserBE;

public interface TaskMangementBEService {

	/**
	 * 
	 * @param user
	 * @param task
	 * @return
	 */
	UserBE assignUserToTask(UserBE user, TaskBE task);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	TaskBE getUserTasks(UserBE user);
	
	/**
	 * 
	 * @param user
	 * @param task
	 * @return
	 */
	TaskBE removeTaskFromUser(UserBE user, TaskBE task);
	
	/**
	 * 
	 * @param task
	 * @return
	 */
	TaskBE updateTask(TaskBE task);
	
	/**
	 * 
	 * @param task
	 * @param dependentTask
	 * @return
	 */
	UserBE addDependencyToTask(TaskBE task, TaskBE dependentTask);
}
