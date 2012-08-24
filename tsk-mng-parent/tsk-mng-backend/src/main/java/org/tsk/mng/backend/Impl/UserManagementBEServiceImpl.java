package org.tsk.mng.backend.Impl;


import org.tsk.mng.backend.exceptions.OperationFailureException;
import org.tsk.mng.common.infra.TransformerUtil;
import org.tsk.mng.backend.model.UserBE;
import org.tsk.mng.backend.service.UserManagementBEService;
import org.tsk.mng.dal.dao.interfaces.UserDao;
import org.tsk.mng.dal.model.UserDT;

//TODO adding authorization checking in each service method
//TODO logger

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

	public UserBE addSuperiorToUser(UserBE superior, UserBE worker) throws OperationFailureException {

		UserBE retValue;

		try {
			
			if (superior == null || worker == null) {
				throw new OperationFailureException("superior or worker are null");
				//TODO debug logger ?
			}
			
			String workerPK = worker.getMail();
			String superiorPK = superior.getMail();
			boolean areParamValids = workerPK != null && !workerPK.isEmpty() && superiorPK != null && !superiorPK.isEmpty();  
			if (areParamValids == false) {
				throw new OperationFailureException("no mail in superior/worker");
				//TODO debug logger ?
			}
			
			UserDT workerDT = userDao.getByPK(workerPK);
			UserDT superiorDT = userDao.getByPK(superiorPK);
			if (!isUserExistInTheSystem(workerDT)) {
				throw new OperationFailureException("worker " + workerPK + " is not exist in the system");
			}
			if (!isUserExistInTheSystem(superiorDT)) {
				throw new OperationFailureException("superior " + superiorPK + "is not exist in the system");
			}
			
			workerDT.setSuperior(superiorDT);
			
			if (!userDao.saveAndVerifyUser(workerDT)) {
				throw new OperationFailureException("error occuer when tryied to save user " + workerPK);
				//TODO error logger
			}
		
			retValue = TransformerUtil.dozerConvert(workerDT, UserBE.class);
			
		} catch (Exception e) {
			throw new OperationFailureException(e.getMessage(),e);
			//TODO logger
		}
		
		
		return retValue;
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
	public UserBE createUser(UserBE user) throws OperationFailureException {
		//TODO adding authorization check

		try {
			//create UserDT
			UserDT userDT = TransformerUtil.dozerConvert(user, UserDT.class);

			if (isUserExistInTheSystem(userDT)) {
				throw new OperationFailureException("User already exist in the system");
			}

			if (!userDao.saveAndVerifyUser(userDT)) {
				throw new OperationFailureException("error occur while creating user");
			}

			return user;

		} catch (Exception e) { 
			//TODO logger
			throw new OperationFailureException("Exception occur : " + e.getMessage(),e);
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
	public UserBE readUser(String mail) throws OperationFailureException {

		try {
			UserDT userDT = userDao.getByPK(mail);
			if (userDT != null) {//the user exists
				return TransformerUtil.dozerConvert(userDT, UserBE.class);
			}
			// user doesn't exist
			throw new OperationFailureException("The User doesn't exist");

		}catch (Exception e) {
			//TODO logger
			throw new OperationFailureException("Exception occur : " + e.getMessage(),e);
		}
	}

	public UserBE updateUser(UserBE user) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * 
	 * TODO add descriptions
	 * @throws ResultBeException 
	 */
	@Override
	public UserBE authenticate(UserBE userBeToAuth) throws OperationFailureException {
		//TODO add logger

		try {

			if (userBeToAuth == null) {
				throw new OperationFailureException("userBeToAuth is null");
			}

			UserDT userToAuth = TransformerUtil.dozerConvert(userBeToAuth, UserDT.class);
			if (authenticate(userToAuth)) {
				return userBeToAuth;
			}

			//the user doesn't exist
			throw new OperationFailureException("your username/password is incorrect or doesn't exist");


		} catch (Exception e) {
			//TODO logger
			throw new OperationFailureException(e.getMessage(),e);
		}
	}


	private boolean authenticate(UserDT userToAuth) {
		//TODO change it to "smart" query

		UserDT userToCompare = userDao.getByPK(userToAuth.getMail());//TODO change it to "smart" query
		if (userToCompare != null) {
			return userToAuth.getPassword().equals(userToCompare.getPassword());
		}

		//user doesn't exist
		return false;
	}


}
