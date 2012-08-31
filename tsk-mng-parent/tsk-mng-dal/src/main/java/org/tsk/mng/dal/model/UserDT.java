package org.tsk.mng.dal.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.tsk.mng.common.config.Consts;
import org.tsk.mng.common.infra.PropertiesHandler;
import org.tsk.mng.common.infra.SpringInitializer;


@Entity
@Table(name = "USER_DETAILS")
public class UserDT {

	public enum PermissionType {

		ADMIN,
		USER
	}
	
	
	
	public UserDT() {
		String beanIdOther = PropertiesHandler.readPropertie(Consts.SPRING_PROPERTIES_FILE_NAME, Consts.SET_IMPL_PROPERTY);
		String beanId = (String) SpringInitializer.getBeanFactory().getBean(Consts.SET_IMPL_PROPERTY);
		tasks = (Set<TaskDT>) SpringInitializer.getBeanFactory().getBean(beanId);
	}
	@Id
	@Column(name="MAIL")
	private String mail;
	
	@Column(name="F_NAME")
	private String firstName;
	
	@Column(name="L_NAME")
	private String lastName;
	
	@Column(name="NICK_NAME")
	private String nickName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="PERMISSION_STATUS")
	@Enumerated(EnumType.ORDINAL)
	private PermissionType permission;
	
//	
//	@ManyToOne(cascade={CascadeType.ALL} ,fetch=FetchType.EAGER)
//	@JoinColumn(name="SUPERIOR_ID")
	@Column(name="SUPERIOR_ID")
	private String superior;
	
//	@OneToMany(mappedBy="superior" ,fetch=FetchType.EAGER)
//	private List<UserDT> workers;
	
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinTable(name="OWNER_TASK", joinColumns=@JoinColumn(name="OWNER_ID"), inverseJoinColumns=@JoinColumn(name="TASK_ID"))
	private Set<TaskDT> tasks;
	
	public void addTask(TaskDT task){
    	tasks.add(task);
    }
//	public void setSuperiorValueDT(String superiorMail){
//		UserDao dao = SpringInitializer.getBeanFactory().getBean(Consts.USER_DAO_BEAN_ID, UserDao.class);
//		UserDT superiorEntity = dao.getByPK(superiorMail);
//		this.superior = superiorEntity;
//	}
	
	
//	public List<UserDT> getWorkers() {
//		return workers;
//	}
//	public void setWorkers(List<UserDT> workers) {
//		this.workers = workers;
//	}
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
	
	public String getSuperior() {
		return superior;
	}
	public void setSuperior(String superior) {
		this.superior = superior;
	}
	
	public Set<TaskDT> getTasks() {
		return tasks;
	}
	public void setTasks(Set<TaskDT> tasks) {
		this.tasks = tasks;
	}
	
	
	
}
