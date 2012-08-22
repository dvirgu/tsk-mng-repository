package org.tsk.mng.dal.dao.interfaces;

import org.tsk.mng.dal.model.UserDT;

public interface UserDao {

	/**
	 * 
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
	 * 
	 * @param userToSave
	 * @return
	 */
	boolean saveAndVerifyUser(UserDT userToSave);
}
