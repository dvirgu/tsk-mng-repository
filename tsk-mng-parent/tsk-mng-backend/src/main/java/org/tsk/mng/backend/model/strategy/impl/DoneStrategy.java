package org.tsk.mng.backend.model.strategy.impl;

import java.util.Set;

import org.tsk.mng.backend.model.TaskBE;
import org.tsk.mng.backend.model.strategy.StatusStrategy;

public class DoneStrategy implements StatusStrategy {

	@Override
	public void handle(Set<TaskBE> tasks, TaskBE taskToHandle) {
		for(TaskBE task : tasks){
			task.doneTask(taskToHandle);
		}
	}

}
