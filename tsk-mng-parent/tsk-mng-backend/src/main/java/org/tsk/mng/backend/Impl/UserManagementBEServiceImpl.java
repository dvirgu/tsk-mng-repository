package org.tsk.mng.backend.Impl;


import org.tsk.mng.backend.enums.OperationStatusType;
import org.tsk.mng.backend.infa.TransformerUtil;
import org.tsk.mng.backend.model.UserBE;
import org.tsk.mng.backend.result.UserResultBE;
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

	public UserResultBE addSuperiorToUser(UserBE superior, UserBE worker) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method provides create user service.
	 * The service checks whether the requested user doesn't exist in the system.
	 * 
	 * In case the user is existing the result be Failure with appropriate notice description
	 * 
	 * @param user
	 * @author Dvir
	 * 
	 */
	public UserResultBE createUser(UserBE user) {
		UserResultBE result = null;

		try {
			//create UserDT
			UserDT userDT = TransformerUtil.dozerConvert(user, UserDT.class);

			if (!isUserExistInTheSystem(userDT)) { 
				userDao.save(userDT); //TODO should check whether the user is created successfully
				result = new UserResultBE(OperationStatusType.Success, "User : " + user + " has created in DB", user);
			} else {
				result = new UserResultBE("The username " + user.getMail() + " is already existing in the system");
			}

		} catch (Exception e) { 
			e.printStackTrace(); //TODO logger
			result = new UserResultBE("Exception occur : " + e.getMessage());
		}

		return result;

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

	public UserResultBE deleteUser(UserBE user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * This method provide getUser service.
	 * TODO add more descriptions
	 * 
	 * @return return UserResultBE
	 * @param mail - the ID of the user
	 */
	public UserResultBE readUser(String mail) {
		UserResultBE result = null;
		
		try {
			UserDT user = userDao.getByPK(mail);
			if (user != null) {//the user exists
				UserBE userToRet = TransformerUtil.dozerConvert(user, UserBE.class);
				result =  new UserResultBE(OperationStatusType.Success, "The user " + mail + " has found", userToRet);
			} else {
				result = new UserResultBE("The User doesn't exist");
			}
		}catch (Exception e) {
			//TODO logger
			result = new UserResultBE("Exception occur : " + e.getMessage());
		}
		
		return result;

	}

	public UserResultBE updateUser(UserBE user) {
		// TODO Auto-generated method stub
		return null;
	}



}
