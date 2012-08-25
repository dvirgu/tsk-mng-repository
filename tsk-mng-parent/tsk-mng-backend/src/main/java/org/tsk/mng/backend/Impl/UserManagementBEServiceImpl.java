package org.tsk.mng.backend.Impl;


import org.tsk.mng.backend.aop.RolePermissionAnnotation;
import org.tsk.mng.backend.enums.PermissionType;
import org.apache.log4j.Logger;
import org.tsk.mng.backend.exceptions.OperationFailureException;
import org.tsk.mng.common.infra.TransformerUtil;
import org.tsk.mng.backend.model.UserBE;
import org.tsk.mng.backend.service.UserManagementBEService;
import org.tsk.mng.dal.dao.interfaces.UserDao;
import org.tsk.mng.dal.model.UserDT;

//TODO adding authorization checking in each service method - ANAR

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

	private static final Logger logger = Logger.getLogger(UserManagementBEServiceImpl.class);

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

			logger.info("trying to add " + superior + " as Sueprior of Worker " + worker);

			if (superior == null || worker == null) {
				throw new OperationFailureException("superior or worker are null");
			}

			logger.info("getting PK (mail) from worker and suprioir");
			String workerPK = worker.getMail();
			String superiorPK = superior.getMail();
			boolean areParamValids = workerPK != null && !workerPK.isEmpty() && superiorPK != null && !superiorPK.isEmpty();
			if (areParamValids == false) {
				throw new OperationFailureException("no mail in superior/worker");
			}

			//
			UserDT workerDT = userDao.getByPK(workerPK);
			UserDT superiorDT = userDao.getByPK(superiorPK);
			if (!isUserExistInTheSystem(workerDT)) {
				throw new OperationFailureException("worker " + worker + " does not exist in the system");
			}
			if (!isUserExistInTheSystem(superiorDT)) {
				throw new OperationFailureException("superior " + superior + "does not exist in the system");
			}
			logger.info("Worker: " + worker + " and Superior: " + superior + " were found");
			
			//adding superior to the worker and either adding worker to superior
			
			//check whether the Worker has Superior already
			UserDT currentSuperior = workerDT.getSuperior();
			if (currentSuperior != null) {
				String msg = "Suprior: " + currentSuperior.getNickName() + " already setted as Superior of " + worker;
				logger.info(msg);
				throw new OperationFailureException(msg);
			}

			//setting the superior as superior of the worker
			worker.setSuperior(superior);
			//adding the worker to superior workers list
			superior.addWorker(worker);
			
			workerDT = TransformerUtil.dozerConvert(worker, UserDT.class);
			superiorDT = TransformerUtil.dozerConvert(superior, UserDT.class);

			if (!userDao.updateUserAndVerify(workerDT)) {
				throw new OperationFailureException("error occuer when tryied to save user " + worker);
			}
			if (!userDao.updateUserAndVerify(superiorDT)) {
				throw new OperationFailureException("error occuer when tryid to save user " + superiorPK);
			}
			logger.info(superiorPK + " has added as superior of " + worker + ", the changes been updated in DB");

			retValue = worker;

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new OperationFailureException(e.getMessage(),e);
		}

		return retValue;
	}

	@RolePermissionAnnotation(allowedRoles={PermissionType.ADMIN})
	public UserBE createUser(UserBE user) throws OperationFailureException {

		try {
			if (user == null) {
				throw new OperationFailureException("user is null");
			}

			logger.info("try to create user : " + user);
			UserDT userDT = TransformerUtil.dozerConvert(user, UserDT.class);

			if (isUserExistInTheSystem(userDT)) {
				throw new OperationFailureException("User already exist in the system");
			}

			if (!userDao.saveUserAndVerify(userDT)) {
				throw new OperationFailureException("error occur while creating user");
			}

		} catch (Exception e) { 
			logger.error(e.getMessage(),e);
			throw new OperationFailureException(e.getMessage(),e);
		}

		logger.info("user " + user + " save succesfuly");

		return user;
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
	private boolean isUserExistInTheSystem(UserDT userDT)//TODO should be in the interface?
			throws NullPointerException {

		boolean retValue;

		if (userDT == null) {
			throw new NullPointerException("userDT is null");
		}

		if (userDT.getMail() == null) {
			throw new NullPointerException("PK value (mail) is null");
		}


		logger.info("trying to fetching " + userDT.getMail() + " from DB");
		retValue = userDao.getByPK(userDT.getMail()) != null;
		String messageToLog = retValue == true ? " found in the system" : " doesn't exist";
		logger.info(userDT.getMail() + messageToLog);

		return retValue;

	}

	public UserBE deleteUser(UserBE user) throws OperationFailureException {

		UserBE retValue;

		try {

			if (user == null) {
				throw new OperationFailureException("user is null");
			}

			logger.info("going to delete " + user + " from the system");
			UserDT userToDeleteDT = TransformerUtil.dozerConvert(user, UserDT.class);
			if (!isUserExistInTheSystem(userToDeleteDT)) {
				throw new OperationFailureException("User does not exist in the system");
			}

			if (!userDao.deleteUserAndVerify(userToDeleteDT)) {
				throw new OperationFailureException("delete " + user + " failed due DB failure");
			}

			logger.info("delete user : " + user + " has succeeded");
			retValue = user;

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new OperationFailureException(e.getMessage(),e);
		}

		return retValue;
	}

	public UserBE readUser(String mail) throws OperationFailureException {

		UserBE retValue;

		try {
			if (mail == null) {
				throw new OperationFailureException("mail is null");
			}
			logger.info("fetching user : " + mail + " from DB");
			UserDT userDT = userDao.getByPK(mail);
			// we don't use the private method isUserExistInTheSystem since this method would use over DB transaction.
			if (userDT == null) {//the does not exists
				throw new OperationFailureException("The User doesn't exist");
			}
			// user exist
			retValue = TransformerUtil.dozerConvert(userDT, UserBE.class);
			logger.info("user " + retValue + " has found in the system");

		}catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new OperationFailureException(e.getMessage(),e);
		}

		return retValue;
	}

	public UserBE updateUser(UserBE user) throws OperationFailureException {

		UserBE retValue;
		
		try {
			if (user == null) {
				throw new OperationFailureException("user is null");
			}
			
			logger.info("going to update " + user);
			UserDT userToUpdateDT = TransformerUtil.dozerConvert(user, UserDT.class);
			if (!userDao.updateUserAndVerify(userToUpdateDT)) {
				throw new OperationFailureException("Update user " + user + " failed due DB error");
			}
			
			retValue = user;
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new OperationFailureException(e.getMessage());
		}


		return retValue;
	}


	@Override
	public UserBE authenticate(UserBE userToAuth) throws OperationFailureException {

		UserBE retValue;
		
		try {

			if (userToAuth == null) {
				throw new OperationFailureException("userBeToAuth is null");
			}

			UserDT userToAuthDT = TransformerUtil.dozerConvert(userToAuth, UserDT.class);
			if (!authenticate(userToAuthDT)) {
				//the user doesn't exist
				throw new OperationFailureException("your username/password is incorrect or doesn't exist");
			}
			
			logger.info("User " + userToAuth + " is authenticate");
			retValue = userToAuth;

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new OperationFailureException(e.getMessage(),e);
		}
		
	return retValue;
	
	}


	//TODO change it to be in LDAP interface
	//this is LDAP method
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
