package org.tsk.mng.backend.model.strategy;

import java.util.Set;

import org.tsk.mng.backend.model.TaskBE;

public interface StatusStrategy {

	void handle(Set<TaskBE> tasks, TaskBE taskToHandle);
}
