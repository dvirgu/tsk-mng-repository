package org.tsk.mng.backend.service;

import org.tsk.mng.backend.model.TaskBE;
import org.tsk.mng.backend.model.UserBE;

public interface TaskMangementBEService {

	UserBE assignUserToTask(UserBE user, TaskBE task);
	
	TaskBE getUserTasks(UserBE user);
	
	TaskBE removeTaskFromUser(UserBE user, TaskBE task);
	
	TaskBE updateTask(TaskBE task);
	
	UserBE addDependencyToTask(TaskBE task, TaskBE dependentTask);
}
