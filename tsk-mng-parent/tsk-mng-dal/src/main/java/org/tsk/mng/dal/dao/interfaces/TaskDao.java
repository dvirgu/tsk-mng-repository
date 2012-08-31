package org.tsk.mng.dal.dao.interfaces;

import org.tsk.mng.dal.model.TaskDT;
import org.tsk.mng.dal.model.UserDT;

public interface TaskDao {

	/**
	 * save taskToSave in DB and verify operation status.
	 * 
	 * @param true whether save operation has succeed, otherwise false
	 */
	boolean save(TaskDT taskToSave, Integer taskId);


	/**
	 * 
	 * @param mail
	 * @return
	 */
	TaskDT getByPK(Integer taskId);
	

	/**
	 * 
	 * TODO
	 * @param userToDelete
	 * @return
	 */
	boolean delete(TaskDT taskToDelete ,Integer taskId);


	/**
	 * 
	 * 
	 * @param userToUpdate
	 * @return
	 */
	void update(TaskDT taskToUpdate);
	
	
}
