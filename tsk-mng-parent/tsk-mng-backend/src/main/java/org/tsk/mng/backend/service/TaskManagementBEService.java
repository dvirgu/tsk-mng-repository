package org.tsk.mng.backend.service;

import java.util.Set;

import org.tsk.mng.backend.exceptions.OperationFailureException;
import org.tsk.mng.backend.model.TaskBE;
import org.tsk.mng.backend.model.UserBE;

public interface TaskManagementBEService {

	/**
	 * Validate if user exist and if exist then save task in DB, otherwise threw exception
	 * 
	 * @param user
	 * @param task
	 * @return
	 * @throws OperationFailureException
	 */
	UserBE assignUserToTask(UserBE user, TaskBE task) throws OperationFailureException;
	
	/**
	 * Validates if the user exist and if exist then return all his tasks, otherwise threw exception.
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
	 * Validates if the task exist and if exists then update the task, otherwise threw exception.
	 * 
	 * @param task
	 * @return Updated task
	 * @throws OperationFailureException
	 */
	TaskBE updateTask(TaskBE task) throws OperationFailureException;
	
	/**
	 * Validates if the task exist, validate if dependentTask exist, 
	 * if they are then add the dependentTask to task and save to DB
	 * 
	 * @param task
	 * @param dependentTask
	 * @return 
	 * @throws OperationFailureException
	 */
	UserBE addDependencyToTask(TaskBE task, TaskBE dependentTask) throws OperationFailureException;
}
