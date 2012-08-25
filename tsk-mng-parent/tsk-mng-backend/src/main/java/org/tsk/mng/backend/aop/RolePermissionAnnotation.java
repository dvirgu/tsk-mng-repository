package org.tsk.mng.backend.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.tsk.mng.backend.enums.PermissionType;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RolePermissionAnnotation {

	PermissionType[] allowedRoles();
}
