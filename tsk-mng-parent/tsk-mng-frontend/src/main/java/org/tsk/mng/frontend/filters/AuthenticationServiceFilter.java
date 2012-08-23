package org.tsk.mng.frontend.filters;

import org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult;
import org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo;

public interface AuthenticationServiceFilter  {
	
	/**
	 * TODO
	 * 
	 * @param userToAuthenticate
	 * @return
	 */
	UserResult isAuthenticate(UserAuthInfo userToAuthenticate);
	
}
