package org.tsk.mng.backend.Impl;

import java.util.ArrayList;
import java.util.List;

import org.tsk.mng.backend.enums.OperationStatusType;
import org.tsk.mng.backend.model.UserBE;
import org.tsk.mng.backend.result.UserResultBE;
import org.tsk.mng.backend.service.UserManagementBEService;
import org.tsk.mng.dal.dao.interfaces.UserDao;
import org.tsk.mng.dal.model.UserDT;

public class UserManagementBEServiceImpl implements UserManagementBEService {

	private UserDao userDao;
	
	
	public UserDao getUserDaoObj() {
		return userDao;
	}

	public void setUserDaoObj(UserDao userDaoObj) {
		this.userDao = userDaoObj;
	}
	
	
	/* ServiceImpl Methods */

	public UserResultBE addSuperiorToUser(UserBE superior, UserBE worker) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserResultBE createUser(UserBE user) {
		
		UserDT userDataType = new UserDT();
		userDataType.setFirstName("Sahi");
		userDataType.setMail("dvirgu@gmail.com");
		userDataType.setLastName("Bamm");
		
		userDao.save(userDataType);
		
		return new UserResultBE();
		
		
	}

	public UserResultBE deleteUser(UserBE user) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserResultBE readUser(String mail) {
		
		createUser(new UserBE());
		
		UserDT user = userDao.getByPK(mail);

		UserResultBE returnResult = new UserResultBE();
		
		returnResult.setStatus(OperationStatusType.Success);
		List<UserBE> users = new ArrayList<UserBE>();
		UserBE userBE = new UserBE();
		userBE.setFirstName(user.getFirstName());
		userBE.setLastName(user.getLastName());
		userBE.setMail(user.getMail());
//		userBE.setNickName(user.getNickName());
//		userBE.setPassword(user.getPassword());
//		userBE.setPermission(user.getPermission());
		users.add(userBE);
		
		returnResult.setUsers(users);
		
		return returnResult;
	}

	public UserResultBE updateUser(UserBE user) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
