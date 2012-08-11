package org.tsk.mng.backend.service;

import org.tsk.mng.backend.model.UserBE;
import org.tsk.mng.backend.result.UserResultBE;

public interface UserManagementBEService {

	UserResultBE addSuperiorToUser(UserBE superior, UserBE worker);
	
	UserResultBE createUser(UserBE user);
	
	UserResultBE deleteUser(UserBE user);
	
	UserResultBE readUser(String mail);
	
	UserResultBE updateUser(UserBE user);
	
}
