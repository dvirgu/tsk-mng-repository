package org.tsk.mng.dal.dao.interfaces;

import org.tsk.mng.dal.model.UserDT;

public interface UserDao {

	/**
	 * Saves userToSave on DB
	 * 
	 * @param userToSave
	 */
	void save(UserDT userToSave);


	
	/**
	 * 
	 * @param mail
	 * @return
	 */
	UserDT getByPK(String mail);
	

	/**
	 * 
	 * save userToSave in DB and verify operation status.
	 * 
	 * @param userToSave
	 * @return true whether save operation has succeed, otherwise false
	 */
	boolean saveUserAndVerify(UserDT userToSave);

	/**
	 * 
	 * TODO
	 * @param userToDelete
	 * @return
	 */
	boolean deleteUserAndVerify(UserDT userToDelete);


	/**
	 * 
	 * 
	 * @param userToUpdate
	 * @return
	 */
	boolean updateUserAndVerify(UserDT userToUpdate);
	
}