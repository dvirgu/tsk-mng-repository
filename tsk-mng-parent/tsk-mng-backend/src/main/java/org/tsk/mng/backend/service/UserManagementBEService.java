package org.tsk.mng.backend.service;

import org.tsk.mng.backend.exceptions.OperationFailureException;
import org.tsk.mng.backend.model.UserBE;

public interface UserManagementBEService {

	
	/**
	 * Tries to add superior to worker and updates DB.<br>
	 * The method checks whether the superior exists in the system<br>
	 * and if it does and worker either updates worker by set his superior.<br>
	 * 
	 * 
	 * @param superior
	 * @param worker
	 * @return {@link UserBE} returns the worker updated with the asked superior to add.
	 * @throws OperationFailureException in case of one of the parameters is null or doesn't exist.<br>
	 * in spit of those throws exception in case of DB failure.
	 */
	UserBE addSuperiorToUser(UserBE superior, UserBE worker) throws OperationFailureException;
	
	/**
	 * 
	 * TODO add descriptions
	 * 
	 * @param user
	 * @return
	 * @throws OperationFailureException
	 */
	UserBE createUser(UserBE user) throws OperationFailureException;
	
	/**
	 * 
	 * TODO add descriptions
	 * 
	 * @param user
	 * @return
	 * @throws OperationFailureException
	 */
	UserBE deleteUser(UserBE user) throws OperationFailureException;
	
	
	/**
	 * 
	 * TODO add descriptions
	 * 
	 * @param mail
	 * @return
	 * @throws OperationFailureException
	 */
	UserBE readUser(String mail) throws OperationFailureException;
	
	
	/**
	 * TODO add descriptions
	 * 
	 * @param user
	 * @return
	 * @throws OperationFailureException
	 */
	UserBE updateUser(UserBE user) throws OperationFailureException;

	/**
	 * 
	 * verify user authentication.<br>
	 * gets {@link UserBE} with Authentication info.<br>
	 * return the same {@link UserBE} like input whether the User is authenticated.<br>
	 * throw {@link OperationFailureException} with appropriate description in case of authentication failure.<br>
	 * 
	 * @param useBeToAuth
	 * @return
	 * @throws OperationFailureException
	 */
	UserBE authenticate(UserBE useBeToAuth) throws OperationFailureException;
	
}
