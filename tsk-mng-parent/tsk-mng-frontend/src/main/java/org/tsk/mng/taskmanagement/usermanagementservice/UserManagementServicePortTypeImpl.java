package org.tsk.mng.taskmanagement.usermanagementservice;

import org.tsk.mng.backend.model.UserBE;
import org.tsk.mng.backend.service.UserManagementBEService;
import org.tsk.mng.common.infra.TransformerUtil;
import org.tsk.mng.taskmanagement.common_elements.opertaionresultstatus.OperationResultStatus;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;
import org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult;
import org.tsk.mng.taskmanagement.usermanagementwrapper.ReadUserTypeRequest;

public class UserManagementServicePortTypeImpl extends
UserManagementServicePortTypeBase {

	@Override
	protected UserResult readUserTemplate(ReadUserTypeRequest readUserRequest) {
		try	{

			if(readUserRequest == null) {
				return createFailureResult("ReadRequest is null");
			}

			UserManagementBEService service = getUserService();


			//TODO add comments

			String userNameToRead = readUserRequest.getUser();
			if(userNameToRead != null) {
				UserBE readedUser = service.readUser(userNameToRead);
				UserFE userToRet = TransformerUtil.dozerConvert(readedUser, UserFE.class);
				return createResult("User has been found", OperationResultStatus.SUCCESS, userToRet);
			}

			return createFailureResult("No User has requested");

		} catch(Exception ex) {

			ex.printStackTrace();
			return createFailureResult(ex.getMessage());
		}
	}
}
