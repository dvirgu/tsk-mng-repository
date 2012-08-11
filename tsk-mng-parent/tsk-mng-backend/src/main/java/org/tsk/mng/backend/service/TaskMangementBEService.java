package org.tsk.mng.backend.service;

import org.tsk.mng.backend.model.TaskBE;
import org.tsk.mng.backend.model.UserBE;
import org.tsk.mng.backend.result.TaskResultBE;
import org.tsk.mng.backend.result.UserResultBE;

public interface TaskMangementBEService {

	UserResultBE assignUserToTask(UserBE user, TaskBE task);
	
	TaskResultBE getUserTasks(UserBE user);
	
	TaskResultBE removeTaskFromUser(UserBE user, TaskBE task);
	
	TaskResultBE updateTask(TaskBE task);
	
	UserResultBE addDependencyToTask(TaskBE task, TaskBE dependentTask);
}
