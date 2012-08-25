package org.tsk.mng.dal.dao.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.tsk.mng.dal.dao.interfaces.UserDao;
import org.tsk.mng.dal.model.TaskDT;
import org.tsk.mng.dal.model.UserDT;
import org.tsk.mng.dal.model.UserDT.PermissionType;

public class UserDaoImpl extends BaseDaoImpl<UserDT, String> implements UserDao {

	public boolean saveUserAndVerify(UserDT userToSave) {
		if (userToSave != null) {
			save(userToSave);
			UserDT verifyUser = getByPK(userToSave.getMail());

			return verifyUser != null;
		}

		throw new NullPointerException("userToSave is null");
	}

	@Override
	public boolean deleteUserAndVerify(UserDT userToDelete) {
		if (userToDelete == null) {
			throw new NullPointerException("userToDelete is null");
		}

		delete(userToDelete); // invoke Base delete
		UserDT verifyDelete = getByPK(userToDelete.getMail());

		return verifyDelete == null; // equal to null , means user does not
		// exist any more
	}

	/**
	 *TODO add descriptions
	 * 
	 * 
	 */
	@Override
	public boolean updateUserAndVerify(UserDT userToUpdate) {
		if (userToUpdate == null) {
			throw new NullPointerException("userToUpdate is null");
		}
		update(userToUpdate);

		//FIXME should add ability to verify update
		//the query below doesn't work, should fix it
		//in the meantime return true anyway.
		return true;
/*		String query = "FROM UserDT " +
				"WHERE " +
				"mail = ? " +
				"AND firstName = ? " +
				"AND lastName = ? " +
				"AND nickname = ? " +
				"AND password = ? " +
				"AND permission = ? " +
				"AND superior = ? " +
				"AND workers = ?";

		List queryResult = getHibernateTemplate().find(query,
				userToUpdate.getMail(),
				userToUpdate.getFirstName(),
				userToUpdate.getLastName(),
				userToUpdate.getNickName(),
				userToUpdate.getPassword(),
				userToUpdate.getPermission(),
				userToUpdate.getSuperior(),
				userToUpdate.getWorkers());

		return queryResult.size() == 1; // query result should be 1 due only one user should be update.*/ 
	}
}