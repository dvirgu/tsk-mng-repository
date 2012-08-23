package org.tsk.mng.backend.service;

import org.tsk.mng.backend.exceptions.ResultBeException;
import org.tsk.mng.backend.model.UserBE;

public interface UserManagementBEService {

	
	/**
	 * TODO
	 * 
	 * @param superior
	 * @param worker
	 * @return
	 * @throws ResultBeException
	 */
	UserBE addSuperiorToUser(UserBE superior, UserBE worker) throws ResultBeException;
	
	/**
	 * 
	 * TODO
	 * 
	 * @param user
	 * @return
	 * @throws ResultBeException
	 */
	UserBE createUser(UserBE user) throws ResultBeException;
	
	/**
	 * 
	 * TODO
	 * 
	 * @param user
	 * @return
	 * @throws ResultBeException
	 */
	UserBE deleteUser(UserBE user) throws ResultBeException;
	
	
	/**
	 * 
	 * TODO
	 * 
	 * @param mail
	 * @return
	 * @throws ResultBeException
	 */
	UserBE readUser(String mail) throws ResultBeException;
	
	
	/**
	 * TODO
	 * 
	 * @param user
	 * @return
	 * @throws ResultBeException
	 */
	UserBE updateUser(UserBE user) throws ResultBeException;

	/**
	 * 
	 * verify user authentication.<br>
	 * gets {@link UserBE} with Authentication info.<br>
	 * return the same {@link UserBE} like input whether the User is authenticated.<br>
	 * throw {@link ResultBeException} with appropriate description in case of authentication failure.<br>
	 * 
	 * @param useBeToAuth
	 * @return
	 * @throws ResultBeException
	 */
	UserBE authenticate(UserBE useBeToAuth) throws ResultBeException;
	
}
