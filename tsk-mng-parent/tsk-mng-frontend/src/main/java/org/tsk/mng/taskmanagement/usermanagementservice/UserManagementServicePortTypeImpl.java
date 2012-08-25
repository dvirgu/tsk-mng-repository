
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package org.tsk.mng.taskmanagement.usermanagementservice;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.apache.log4j.Logger;
import org.tsk.mng.backend.model.UserBE;
import org.tsk.mng.backend.service.UserManagementBEService;
import org.tsk.mng.common.infra.SpringInitializer;
import org.tsk.mng.common.infra.TransformerUtil;
import org.tsk.mng.taskmanagement.common_elements.opertaionresultstatus.OperationResultStatus;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.PermissionType;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;
import org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult;
import org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo;

/**
 * This class was generated by Apache CXF 2.2
 * Wed Aug 22 02:38:07 IDT 2012
 * Generated source version: 2.2
 * 
 */

@javax.jws.WebService(
		serviceName = "UserManagementService",
		portName = "UserManagementServicePort",
		targetNamespace = "http://mng.tsk.org/taskManagement/UserManagementService/",
		wsdlLocation = "http://localhost:8080/tsk-mng-frontend-0.0.1-REVISION/services/UserManagementServicePort?wsdl",
		endpointInterface = "org.tsk.mng.taskmanagement.usermanagementservice.UserManagementServicePortType")

public class UserManagementServicePortTypeImpl implements UserManagementServicePortType {

	private static final Logger logger = Logger.getLogger(UserManagementServicePortTypeImpl.class);


	/**
	 * This methods verify user authentication
	 * this methods has invoke in each start of WebSerivce method. 
	 *
	 * @return UserResult with status about whether user authenticates or does not
	 */
	//@Override TODO move it to AuthFilter
	public UserResult isAuthenticate(UserAuthInfo userToAuthenticate) {

		try {

			UserManagementBEService servcie = getUserService();

			UserBE useBeToAuth = TransformerUtil.dozerConvert(userToAuthenticate, UserBE.class);

			UserBE authenticateUser = servcie.authenticate(useBeToAuth);
			if (authenticateUser != null) {//is authenticated
				UserFE authenticatedUser = TransformerUtil.dozerConvert(userToAuthenticate, UserFE.class);
				return createResult("user is authenticated", OperationResultStatus.SUCCESS,authenticatedUser);
			}

			return createFailureResult("Authentication error occur");

		} catch (Exception e) {
			//TODO logger
			return createFailureResult(e.getMessage());
		}
	}



	/*
	 * Web Service Methods
	 */

	/* (non-Javadoc)
	 * @see org.tsk.mng.taskmanagement.usermanagementservice.UserManagementServicePortType#addSuperiorToUserOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo  soapHeader ,)org.tsk.mng.taskmanagement.usermanagementwrapper.AddSuperiorToUserTypeRequest  addSuperiorToUserRequest )*
	 */
	public org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult addSuperiorToUserOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,org.tsk.mng.taskmanagement.usermanagementwrapper.AddSuperiorToUserTypeRequest addSuperiorToUserRequest) { 
		logger.info("Executing operation addSuperiorToUserOperation");

		UserResult result;
		
		try {
			 //TODO
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.tsk.mng.taskmanagement.usermanagementservice.UserManagementServicePortType#createUserOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo  soapHeader ,)org.tsk.mng.taskmanagement.usermanagementwrapper.CreateUserTypeRequest  createUserRequest )*
	 */
	public org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult createUserOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,org.tsk.mng.taskmanagement.usermanagementwrapper.CreateUserTypeRequest createUserRequest) { 
		/*LOG.info("Executing operation createUserOperation");
        System.out.println(soapHeader);
        System.out.println(createUserRequest);*/

		try	{

			if(createUserRequest == null) {
				return createFailureResult("CreateUserRequest is null");
			}

			UserManagementBEService service = getUserService();

			/*
			 * 
			 * TODO add comments
			 */
			UserFE userFromRequest = createUserRequest.getUser();
			if(userFromRequest != null) {
				UserBE userToCreate = (UserBE)TransformerUtil.dozerConvert(userFromRequest, UserBE.class);
				service.createUser(userToCreate);
				return createResult("User has created successfuly", OperationResultStatus.SUCCESS, userFromRequest);
			}

			return createFailureResult("No User has Requested");

		} catch(Exception ex)	{
			ex.printStackTrace();
			return createFailureResult(ex.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see org.tsk.mng.taskmanagement.usermanagementservice.UserManagementServicePortType#deleteUserOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo  soapHeader ,)org.tsk.mng.taskmanagement.usermanagementwrapper.DeleteUserTypeRequest  deleteUserRequest )*
	 */
	public org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult deleteUserOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,org.tsk.mng.taskmanagement.usermanagementwrapper.DeleteUserTypeRequest deleteUserRequest) { 
		logger.info("Executing operation deleteUserOperation");
		System.out.println(soapHeader);
		System.out.println(deleteUserRequest);
		try {
			org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult _return = null;
			return _return;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	/* (non-Javadoc)
	 * @see org.tsk.mng.taskmanagement.usermanagementservice.UserManagementServicePortType#updateUserOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo  soapHeader ,)org.tsk.mng.taskmanagement.usermanagementwrapper.UpdateUserTypeRequest  updateUserRequest )*
	 */
	public org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult updateUserOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,org.tsk.mng.taskmanagement.usermanagementwrapper.UpdateUserTypeRequest updateUserRequest) { 
		logger.info("Executing operation updateUserOperation");
		System.out.println(soapHeader);
		System.out.println(updateUserRequest);
		
		try {
			org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult _return = null;
			return _return;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	/* (non-Javadoc)
	 * @see org.tsk.mng.taskmanagement.usermanagementservice.UserManagementServicePortType#readUserOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo  soapHeader ,)org.tsk.mng.taskmanagement.usermanagementwrapper.ReadUserTypeRequest  readUserRequest )*
	 */
	public org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult readUserOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,org.tsk.mng.taskmanagement.usermanagementwrapper.ReadUserTypeRequest readUserRequest) { 
		/*LOG.info("Executing operation readUserOperation");
        System.out.println(soapHeader);
        System.out.println(readUserRequest);*/

		//TODO UserResult result;
		
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

	//TODO delete: protected abstract UserResult readUserTemplate(ReadUserTypeRequest readUserRequest);


	protected UserManagementBEService getUserService() {
		return SpringInitializer.getBean(UserManagementBEService.class);
	}

	protected UserResult createResult(String resultMessage, OperationResultStatus resultStatus, UserFE userToReturn) {
		UserResult userToRet = new UserResult();
		userToRet.setResultDescription(resultMessage);
		userToRet.setResultStatus(resultStatus);

		if(userToReturn != null) {
			List<UserFE> userToReturnArr = new ArrayList<UserFE>();
			userToReturnArr.add(userToReturn);
			userToRet.setUserReturnValues(userToReturnArr);
		}

		return userToRet;
	}

	protected UserResult createFailureResult(String failueDescription) {
		return createResult(failueDescription, OperationResultStatus.FAILURE, null);
	}

}
