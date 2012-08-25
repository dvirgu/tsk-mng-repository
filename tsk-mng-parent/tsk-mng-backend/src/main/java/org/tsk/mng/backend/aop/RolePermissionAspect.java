package org.tsk.mng.backend.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.tsk.mng.backend.enums.PermissionType;
import org.tsk.mng.backend.exceptions.OperationFailureException;
import org.tsk.mng.backend.model.UserBE;
import org.tsk.mng.backend.service.UserManagementBEService;
import org.tsk.mng.common.infra.SpringInitializer;
import org.tsk.mng.common.infra.TransformerUtil;

@Aspect
public class RolePermissionAspect {

	private static final Logger logger = Logger.getLogger(RolePermissionAspect.class);
	
	@Around("@annotation(org.tsk.mng.backend.aop.RolePermissionAnnotation)")
	public Object around(ProceedingJoinPoint pjp ,RolePermissionAnnotation roleAnnotation) throws Throwable{
		
		boolean isMethodAllowed = isMethodAllowed(pjp ,roleAnnotation); 
		if(isMethodAllowed){
			Object retVal = pjp.proceed();
			
			return retVal;
		} else {
			String errorMessage = "User not allowed";
			logger.error(errorMessage);
			throw new Exception(errorMessage); // TODO: change to BaseException
		}
		
		
	}
	
	private boolean isMethodAllowed(ProceedingJoinPoint pjp ,RolePermissionAnnotation roleAnnotation) throws OperationFailureException{
		
		boolean isAllowed = false;
		
		if(roleAnnotation != null){

			PermissionType[] allowedRoles = roleAnnotation.allowedRoles();
			String soapHeader = ((String)(pjp.getArgs()[0]));
			UserBE user = TransformerUtil.dozerConvert(SpringInitializer.getBean(UserManagementBEService.class).readUser(soapHeader), UserBE.class); 
			PermissionType userRole = user.getPermission();
			
			for(PermissionType allowedRole : allowedRoles){
				if(allowedRole == userRole){
					isAllowed = true;
				}
			}
		}
		
		return isAllowed;
	}
	
	
}
