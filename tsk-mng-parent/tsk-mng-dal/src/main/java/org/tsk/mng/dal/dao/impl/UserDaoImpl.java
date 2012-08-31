package org.tsk.mng.dal.dao.impl;

import org.tsk.mng.dal.dao.interfaces.UserDao;
import org.tsk.mng.dal.model.UserDT;

public class UserDaoImpl extends BaseDaoImpl<UserDT, String> implements UserDao {

	@Override
	public boolean authenticate(String user, String password) {
		boolean isAllowed = false;
		
		UserDT userDT = getByPK(user);
		if(userDT != null){
			if(userDT.getPassword().equals(password)){
				isAllowed = true;
			}
		}
		
		return isAllowed;
	}


	
}