package org.tsk.mng.dal.model;

import java.util.List;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "USER_DETAILS")
public class UserDT {

	public enum PermissionType {

		ADMIN,
		USER
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
	
	
	@ManyToOne(cascade={CascadeType.ALL} ,fetch=FetchType.EAGER)
	@JoinColumn(name="SUPERIOR_ID")
	private UserDT superior;
	
	@OneToMany(mappedBy="superior" ,fetch=FetchType.EAGER)
	private List<UserDT> workers;
	
	@OneToMany(mappedBy="owner" ,fetch=FetchType.EAGER)
	private List<TaskDT> tasks;
	
	
	
	public List<UserDT> getWorkers() {
		return workers;
	}
	public void setWorkers(List<UserDT> workers) {
		this.workers = workers;
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
	
	public UserDT getSuperior() {
		return superior;
	}
	public void setSuperior(UserDT superior) {
		this.superior = superior;
	}
	
	public List<TaskDT> getTasks() {
		return tasks;
	}
	public void setTasks(List<TaskDT> tasks) {
		this.tasks = tasks;
	}
	
	
	
}
