package org.tsk.mng.backend.service;

import java.util.Set;

import org.tsk.mng.backend.exceptions.OperationFailureException;
import org.tsk.mng.backend.model.TaskBE;
import org.tsk.mng.backend.model.UserBE;

public interface TaskMangementBEService {

	/**
	 * 
	 * @param user
	 * @param task
	 * @return
	 * @throws OperationFailureException
	 */
	UserBE assignUserToTask(UserBE user, TaskBE task) throws OperationFailureException;
	
	/**
	 * 
	 * @param user
	 * @return 
	 * @throws OperationFailureException
	 */
	Set<TaskBE> getUserTasks(UserBE user) throws OperationFailureException;
	
	/**
	 * Validates if the task exist and if exists then remove the task, otherwise threw exception.
	 * 
	 * @param user
	 * @param task
	 * @return Removed task
	 * @throws OperationFailureException
	 */
	TaskBE removeTaskFromUser(UserBE user, TaskBE task) throws OperationFailureException;
	
	/**
	 * 
	 * @param task
	 * @return Updated task
	 * @throws OperationFailureException
	 */
	TaskBE updateTask(TaskBE task) throws OperationFailureException;
	
	/**
	 * 
	 * @param task
	 * @param dependentTask
	 * @return
	 * @throws OperationFailureException
	 */
	UserBE addDependencyToTask(TaskBE task, TaskBE dependentTask) throws OperationFailureException;
}
