package org.tsk.mng.backend.Impl;


import org.tsk.mng.backend.exceptions.ResultBeException;
import org.tsk.mng.backend.infa.TransformerUtil;
import org.tsk.mng.backend.model.UserBE;
import org.tsk.mng.backend.service.UserManagementBEService;
import org.tsk.mng.dal.dao.interfaces.UserDao;
import org.tsk.mng.dal.model.UserDT;

/**
 * The class present
 * the implementation of the server side business logic
 * 
 * 
 * @author anar - infrastructure
 * @author Dvir - implement
 *
 */
public class UserManagementBEServiceImpl implements UserManagementBEService {

	private UserDao userDao;

	/* 
	 * WARNING : 
	 * DO NOT CHANGE GET/SET METHODS OF USERDAO
	 * IS IN USING OF SPRING FRAMEWORK
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/* 
	 * WARNING : 
	 * DO NOT CHANGE GET/SET METHODS OF USERDAO
	 * IS IN USING OF SPRING FRAMEWORK
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	/* ServiceImpl Methods */

	public UserBE addSuperiorToUser(UserBE superior, UserBE worker) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method provides create user service.
	 * The service checks whether the requested user doesn't exist in the system.
	 * 
	 * In case the user is existing appropriate @link BEResultException exception throws
	 * 
	 * @param user
	 * @return UserBE
	 * @author Dvir
	 * 
	 * @exception ResultBeException
	 */
	public UserBE createUser(UserBE user) throws ResultBeException {

		try {
			//create UserDT
			UserDT userDT = TransformerUtil.dozerConvert(user, UserDT.class);
			
			if (isUserExistInTheSystem(userDT)) {
				throw new ResultBeException("User already exist in the system");
			}
			
			if (!userDao.saveAndVerifyUser(userDT)) {
				throw new ResultBeException("error occur while creating user");
			}
			
			return user;

		} catch (Exception e) { 
			//TODO logger
			 throw new ResultBeException("Exception occur : " + e.getMessage(),e);
		}
	}

	/**
	 * Return boolean answer about existing of userDT
	 * 
	 * @throws NullPointerException - usually in case of userDT or PK field is null
	 * @param userDT
	 * @return true whether the user is exist in the DB.
	 * @author Dvir
	 * 
	 */
	private boolean isUserExistInTheSystem(UserDT userDT)//TODO should be in the interface
			throws NullPointerException {
		if (userDT != null) {
			if (userDT.getMail() != null) {
				return userDao.getByPK(userDT.getMail()) != null;
			}
			throw new NullPointerException("PK value (mail) is null");
		}
		throw new NullPointerException("userDT is null");
	}

	public UserBE deleteUser(UserBE user) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * This method provide getUser service.
	 * in case of error in data fetching
	 * throw exception with appropriate message/description
	 * 
	 * @return UserBE
	 * @param mail - the ID/PK of the user
	 * @throws ResultBeException 
	 */
	public UserBE readUser(String mail) throws ResultBeException {

		try {
			UserDT userDT = userDao.getByPK(mail);
			if (userDT != null) {//the user exists
				return TransformerUtil.dozerConvert(userDT, UserBE.class);
			}
			// user doesn't exist
			throw new ResultBeException("The User doesn't exist");
			
		}catch (Exception e) {
			//TODO logger
			throw new ResultBeException("Exception occur : " + e.getMessage(),e);
		}
	}

	public UserBE updateUser(UserBE user) {
		// TODO Auto-generated method stub
		return null;
	}



}
