package org.tsk.mng.backend.result;

import java.util.ArrayList;
import java.util.List;

import org.tsk.mng.backend.enums.OperationStatusType;
import org.tsk.mng.backend.model.UserBE;

public class UserResultBE {

	private OperationStatusType status;
	private List<UserBE> users;
	private String description;


	public UserResultBE(OperationStatusType status,String description, UserBE user) {
		setStatus(status);
		setDescription(description);
		addUser(user);
	}

	/**
	 * this constructor used to create failure result
	 *
	 * OperationStatusType - set to Failure
	 * @param description
	 */
	public UserResultBE(String description) {
		setDescription(description);
		setStatus(OperationStatusType.FAILURE);
	}

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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public boolean addUser(UserBE userToAdd) {
		synchronized (this) {
			if (users == null) {
				users = new ArrayList<UserBE>();	
			}
		}
		return users.add(userToAdd);
	}
}
