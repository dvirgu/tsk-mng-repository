package org.tsk.mng.backend.service;

import org.tsk.mng.backend.exceptions.ResultBeException;
import org.tsk.mng.backend.model.UserBE;

public interface UserManagementBEService {

	UserBE addSuperiorToUser(UserBE superior, UserBE worker) throws ResultBeException;
	
	UserBE createUser(UserBE user) throws ResultBeException;
	
	UserBE deleteUser(UserBE user) throws ResultBeException;
	
	UserBE readUser(String mail) throws ResultBeException;
	
	UserBE updateUser(UserBE user) throws ResultBeException;
	
}
