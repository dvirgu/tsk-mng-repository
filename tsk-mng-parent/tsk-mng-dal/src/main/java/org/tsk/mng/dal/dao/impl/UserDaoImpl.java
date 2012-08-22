package org.tsk.mng.dal.dao.impl;

import org.tsk.mng.dal.dao.interfaces.UserDao;
import org.tsk.mng.dal.model.UserDT;

public class UserDaoImpl extends BaseDaoImpl<UserDT, String> implements UserDao {

	public boolean saveAndVerifyUser(UserDT userToSave) {
		if (userToSave != null) {
			save(userToSave);
			UserDT verifyUser = getByPK(userToSave.getMail());

			return verifyUser != null;
		}

		throw new NullPointerException("userToSave is null");
	}
}
