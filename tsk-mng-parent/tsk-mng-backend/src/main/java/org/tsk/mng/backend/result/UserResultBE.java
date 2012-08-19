package org.tsk.mng.backend.result;

import java.util.List;

import org.tsk.mng.backend.enums.OperationStatusType;
import org.tsk.mng.backend.model.UserBE;

public class UserResultBE {

	private OperationStatusType status;
	private List<UserBE> users;
	 
	
	public OperationStatusType getStatus() {
		return status;
	}
	public void setStatus(OperationStatusType status) {
		this.status = status;
	}
	public List<UserBE> getUsers() {
		return users;
	}
	public void setUsers(List<UserBE> users) {
		this.users = users;
	}
	public boolean addUser(UserBE userToAdd) {
		return users.add(userToAdd);
	}
	
	
}
