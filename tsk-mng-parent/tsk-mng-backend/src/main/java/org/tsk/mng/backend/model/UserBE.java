package org.tsk.mng.backend.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.tsk.mng.backend.enums.PermissionType;
import org.tsk.mng.common.config.Consts;
import org.tsk.mng.common.infra.PropertiesHandler;
import org.tsk.mng.common.infra.SpringInitializer;

public class UserBE {

	private String mail;
	private String firstName;
	private String lastName;
	private String nickName;
	private String password;
	private PermissionType permission;
	private List<UserBE> superiors;
	private List<UserBE> workers;
	private Set<TaskBE> tasks;
	
	
	
	public UserBE() {
		String beanIdProp = PropertiesHandler.readPropertie(Consts.SPRING_PROPERTIES_FILE_NAME, Consts.SET_IMPL_PROPERTIE);
		String beanId = (String) SpringInitializer.getBeanFactory().getBean(Consts.SET_IMPL_PROPERTIE);
		tasks = (Set<TaskBE>) SpringInitializer.getBeanFactory().getBean(beanId);
	}


	@Override
	public String toString() {
		return "Mail: " + mail + " Name: " + lastName + " " + firstName;
	}
	
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public PermissionType getPermission() {
		return permission;
	}
	public void setPermission(PermissionType permission) {
		this.permission = permission;
	}
	public List<UserBE> getSuperiors() {
		return superiors;
	}
	public void setSuperiors(List<UserBE> superiors) {
		this.superiors = superiors;
	}
	public List<UserBE> getWorkers() {
		return workers;
	}
	public void setWorkers(List<UserBE> workers) {
		this.workers = workers;
	}
	public Set<TaskBE> getTasks() {
		return tasks;
	}
	public void setTasks(Set<TaskBE> tasks) {
		this.tasks = tasks;
	}
	
	
	
	
}
