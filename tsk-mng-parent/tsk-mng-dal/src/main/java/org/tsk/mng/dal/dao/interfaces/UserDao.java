package org.tsk.mng.dal.dao.interfaces;

import org.tsk.mng.dal.model.UserDT;

public interface UserDao {

	/**
	 * save userToSave in DB and verify operation status.
	 * 
	 * @param true whether save operation has succeed, otherwise false
	 */
	boolean save(UserDT userToSave, String mail);


	/**
	 * 
	 * @param mail
	 * @return
	 */
	UserDT getByPK(String mail);
	

	/**
	 * 
	 * TODO
	 * @param userToDelete
	 * @return
	 */
	boolean delete(UserDT userToDelete ,String mail);


	/**
	 * 
	 * 
	 * @param userToUpdate
	 * @return
	 */
	void update(UserDT userToUpdate);
	
}