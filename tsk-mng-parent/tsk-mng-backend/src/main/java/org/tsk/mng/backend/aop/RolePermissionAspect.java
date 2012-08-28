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
	
	@Around(value = "@annotation(org.tsk.mng.backend.aop.RolePermissionAnnotation) && @annotation(roleAnnotation)", argNames="roleAnnotation")
	public Object around(final ProceedingJoinPoint pjp ,RolePermissionAnnotation roleAnnotation) throws Throwable{
		
		Object retVal = null;
		boolean isMethodAllowed = isMethodAllowed(pjp ,roleAnnotation); 
		if(isMethodAllowed){
			retVal = pjp.proceed();
			
		} else {
			String warnMessage = "User not allowed";
			logger.warn(warnMessage);
			throw new OperationFailureException(warnMessage);
		}
		
		return retVal;
	}
	
	private boolean isMethodAllowed(ProceedingJoinPoint pjp ,RolePermissionAnnotation roleAnnotation) throws OperationFailureException{
		
		boolean isAllowed = false;
		
		if(roleAnnotation != null){

			PermissionType[] allowedRoles = roleAnnotation.allowedRoles();
			if(pjp.getArgs()[0] instanceof UserBE){
				UserBE user = ((UserBE)(pjp.getArgs()[0]));
				//UserBE user = TransformerUtil.dozerConvert(SpringInitializer.getBean(UserManagementBEService.class).readUser(soapHeader), UserBE.class); 
				PermissionType userRole = user.getPermission();
				
				for(PermissionType allowedRole : allowedRoles){
					if(allowedRole == userRole){
						isAllowed = true;
					}
				}
			} else {
				throw new OperationFailureException("The first argument is not instance of UserBE");
			}
			
		}
		
		return isAllowed;
	}
	
	
}
