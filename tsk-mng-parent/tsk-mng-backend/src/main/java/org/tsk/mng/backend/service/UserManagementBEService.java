package org.tsk.mng.backend.service;

import org.tsk.mng.backend.exceptions.OperationFailureException;
import org.tsk.mng.backend.model.UserBE;

public interface UserManagementBEService {


	/**
	 * Tries to add superior to worker and updates DB.<p>
	 * The method checks whether the superior exists in the system<br>
	 * and if it does and worker either, updates:<br>
	 * Adding the worker to Superior worker list.
	 * in addition set the superior as superior of the worker 
	 * 
	 * @param superior
	 * @param worker
	 * @return {@link UserBE} returns the worker updated with the asked superior to add.
	 * @throws OperationFailureException in case of one of the parameters is null or doesn't exist.<br>
	 * in spit of those throws exception in case of DB failure.
	 */
	UserBE addSuperiorToUser(UserBE superior, UserBE worker) throws OperationFailureException;

	/**
	 * Provides create user service.<br>
	 * The service checks whether the requested user doesn't exist in the system.
	 * 
	 * @param user
	 * @return UserBE
	 * 
	 * @exception OperationFailureException - In case the user exists
	 */
	UserBE createUser(UserBE user) throws OperationFailureException;

	/**
	 * Tries to delete requested user.<br>
	 * Check whether the delete requested user exists in the system.<br>
	 * if it does, deletes it from the system and returns the deleted user. 
	 * 
	 * @param user
	 * @return
	 * @throws OperationFailureException - in case of the user doesn't exist or another error occur.
	 */
	UserBE deleteUser(UserBE user) throws OperationFailureException;


	/** Provides getUser service.<br>
	 *  try to find exist User by his PK (String mail).<br>
	 * 
	 * if succeed return the user as UserBE, otherwise throws exception.
	 * 
	 * @param mail
	 * @return {@link UserBE} with the requested user to get. 
	 * @throws OperationFailureException - in case the user does not exist or error occurs in data fetching
	 */
	UserBE readUser(String mail) throws OperationFailureException;


	/**
	 *
	 *  Updates User with new data.
	 *  the parameter user must be exists in the system.<br>
	 *  exists means the PK (mail) is existing.<br>
	 *  so the user should be the same user as the system knows.<br>
	 *  however the user includes new data.
	 * 
	 * 
	 * 
	 * @param user - the user to update with the new data.
	 * @return {@link UserBE} the updated user
	 * @throws OperationFailureException - in case the user does not exist or another error occured
	 */
	UserBE updateUser(UserBE user) throws OperationFailureException;

	/**
	 * Verify user authentication.<br>
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
