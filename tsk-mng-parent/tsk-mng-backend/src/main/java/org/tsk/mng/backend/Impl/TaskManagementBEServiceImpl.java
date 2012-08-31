package org.tsk.mng.backend.Impl;

import java.util.Set;

import javax.swing.Spring;

import org.tsk.mng.backend.exceptions.OperationFailureException;
import org.tsk.mng.backend.model.TaskBE;
import org.tsk.mng.backend.model.UserBE;
import org.tsk.mng.backend.service.TaskMangementBEService;
import org.tsk.mng.common.infra.SpringInitializer;
import org.tsk.mng.common.infra.TransformerUtil;
import org.tsk.mng.dal.dao.interfaces.TaskDao;
import org.tsk.mng.dal.dao.interfaces.UserDao;
import org.tsk.mng.dal.model.TaskDT;
import org.tsk.mng.dal.model.UserDT;

public class TaskManagementBEServiceImpl implements TaskMangementBEService {

	TaskDao taskDao;
	UserDao userDao;
	
	
	public TaskDao getTaskDao() {
		return taskDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setTaskDao(TaskDao taskDao) throws OperationFailureException {
		this.taskDao = taskDao;
	}

	
	public UserBE assignUserToTask(UserBE user, TaskBE task) throws OperationFailureException {
		UserDT userDT = userDao.getByPK(user.getMail());
		TaskDT taskDT = TransformerUtil.dozerConvert(task, TaskDT.class);
		userDT.getTasks().add(taskDT);
		taskDT.setOwner(userDT.getMail());
		
		if(!userDao.save(userDT, userDT.getMail())){
			String err = "Save failed to user : " + user.toString();
			throw new OperationFailureException(err);
		}
		
		return user;
	}

	public Set<TaskBE> getUserTasks(UserBE user) throws OperationFailureException {
		UserDT userDT = userDao.getByPK(user.getMail());
		UserBE retUser = TransformerUtil.dozerConvert(userDT, UserBE.class);
		return retUser.getTasks();
	}

	public TaskBE removeTaskFromUser(UserBE user, TaskBE task) throws OperationFailureException {
		UserDT userDT = userDao.getByPK(user.getMail());
		TaskDT taskDT = TransformerUtil.dozerConvert(task, TaskDT.class);
		userDT.getTasks().remove(taskDT);
		taskDao.delete(taskDT, taskDT.getTaskId());
		return null;
	}

	public TaskBE updateTask(TaskBE task) throws OperationFailureException {
		TaskDT taskDT = TransformerUtil.dozerConvert(task, TaskDT.class);
		taskDao.update(taskDT);
		
		return null;
	}

	public UserBE addDependencyToTask(TaskBE task, TaskBE dependentTask) throws OperationFailureException {
		task.getMeDependOnTasks().add(dependentTask);
		dependentTask.getDependOnMeTasks().add(task.getTaskId());
		TaskDT taskDT = TransformerUtil.dozerConvert(task, TaskDT.class);
		if(taskDao.save(taskDT, taskDT.getTaskId())){
			
		}
		return null;
	}

}
