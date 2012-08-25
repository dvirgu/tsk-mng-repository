package org.tsk.mng.frontend.infra;

import java.util.List;

import org.tsk.mng.taskmanagement.common_elements.opertaionresultstatus.OperationResultStatus;
import org.tsk.mng.taskmanagement.common_elements.task.taskfe.TaskFE;
import org.tsk.mng.taskmanagement.common_elements.task.taskresult.TaskResult;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;
import org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult;

public class ResultFactory {
	
	public static TaskResult createTaskResult(String resultMessage, OperationResultStatus resultStatus, TaskFE taskToReturn) {
		TaskResult resultToRet = new TaskResult();
		resultToRet.setResultDescription(resultMessage);
		resultToRet.setResultStatus(resultStatus);

		if (taskToReturn != null) {
			resultToRet.getTaskReturnValues().add(taskToReturn);	
		}

		return resultToRet;
	}

	public static TaskResult createTaskResult(String resultMessage, OperationResultStatus resultStatus, List<TaskFE> tasksCollection) {
		TaskResult resultToRet = createTaskResult(resultMessage, resultStatus, (TaskFE)null);
		
		if (tasksCollection != null) {
			resultToRet.setTaskReturnValues(tasksCollection);
		}

		return resultToRet;
	}

	public static TaskResult createFailureTaskResult(String faulureDescription) {
		return createTaskResult(faulureDescription, OperationResultStatus.FAILURE, (TaskFE)null);
	}
	
	public static UserResult createUserResult(String resultMessage, OperationResultStatus resultStatus, UserFE userToReturn) {
		UserResult resultToRet = new UserResult();
		resultToRet.setResultDescription(resultMessage);
		resultToRet.setResultStatus(resultStatus);

		if (userToReturn != null) {
			resultToRet.getUserReturnValues().add(userToReturn);
		}

		return resultToRet;
	}

	public static UserResult createFailureUserResult(String failueDescription) {
		return createUserResult(failueDescription, OperationResultStatus.FAILURE, null);
	}
}
