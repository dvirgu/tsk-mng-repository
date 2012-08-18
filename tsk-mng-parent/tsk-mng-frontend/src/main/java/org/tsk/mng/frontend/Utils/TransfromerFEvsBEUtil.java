package org.tsk.mng.frontend.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.tsk.mng.backend.model.TaskBE;
import org.tsk.mng.backend.model.UserBE;
import org.tsk.mng.backend.result.UserResultBE;
import org.tsk.mng.taskmanagement.common_elements.opertaionresultstatus.OperationResultStatus;
import org.tsk.mng.taskmanagement.common_elements.task.taskfe.TaskFE;
import org.tsk.mng.taskmanagement.common_elements.task.taskfe.TaskStatusType;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.PermissionType;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;
import org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult;


/**
 * 
 * 
 * @since 18/8/2012 
 * @author Dvir
 *
 */
public class TransfromerFEvsBEUtil {

	public static UserResult convertUserResultBEtoUserResult(UserResultBE userResultBe) {

		UserResult userToRet = new UserResult();
		OperationResultStatus status;

		try {
			List<UserFE> newUsers = convertUserBEListToUserFEList(userResultBe.getUsers());
			userToRet.getUserReturnValues().addAll(newUsers);
			status = OperationResultStatus.SUCCSESSFUL;

		} catch (Exception e) {
			e.printStackTrace(); //TODO logger
			status = OperationResultStatus.FAILURE;
		}

		userToRet.setResultStatus(status);
		return userToRet;

	}

	
	public static TaskBE convertTaskFEtoBE(TaskFE taskToConvert) {
		return null;
	}
	
	public static TaskFE convertTaskBEtoFE(TaskBE taskToConvert) {

		if (taskToConvert != null) {
			TaskFE taskToRet = new TaskFE();

			taskToRet.setAlert(dateToXMLDate(taskToConvert.getAlert()));
			taskToRet.setDeadLine(dateToXMLDate(taskToConvert.getDeadline()));
			taskToRet.setDescriptions(taskToConvert.getDescriptions());
			taskToRet.setOwner(convertUserBEtoUserFE(taskToConvert.getOwner()));
			taskToRet.setStatus(convertStatusBEtoStatusFE(taskToConvert.getStatus()));
			taskToRet.setTaskId(taskToConvert.getTaskId());

			List<TaskFE> newDependencyList = convertTaskBEListToTaskFEList(taskToConvert.getDependentTasks());
			taskToRet.getDependentTasks().addAll(newDependencyList);

			return taskToRet;
		}
		return null;
	}

	private static UserFE convertUserBEtoUserFE(UserBE userBEToConvert) {

		if (userBEToConvert != null) {
			UserFE userToRet = new UserFE();

			userToRet.setFirstName(userBEToConvert.getFirstName());
			userToRet.setLastName(userBEToConvert.getLastName());
			userToRet.setMail(userBEToConvert.getMail());
			userToRet.setNickName(userBEToConvert.getNickName());
			userToRet.setPassword(userBEToConvert.getPassword());
			userToRet.setPermission(convertPermission(userBEToConvert
					.getPermission()));

			List<UserFE> newSuperiors = convertUserBEListToUserFEList(userBEToConvert.getSuperiors());
			userToRet.getSuperiors().addAll(newSuperiors);

			List<UserFE> newWorkers = convertUserBEListToUserFEList(userBEToConvert.getWorkers());
			userToRet.getWorkers().addAll(newWorkers);

			List<TaskFE> newTasks = convertTaskBEListToTaskFEList(userBEToConvert.getTasks());
			userToRet.getTasks().addAll(newTasks);

			return userToRet;
		}

		return null;
	}

	/**
	 * convert from BE enum type to FE enum type. In case of input error will
	 * return USER permission.
	 * 
	 * 
	 * @param permissionTypeToConvert
	 * @return
	 */
	private static PermissionType convertPermission(
			org.tsk.mng.backend.enums.PermissionType permissionTypeToConvert) {

		switch (permissionTypeToConvert) {
		case Admin:
			return PermissionType.ADMIN;
		case User:
			return PermissionType.USER;
		default:
			return PermissionType.USER;
		}
	}

	private static List<UserFE> convertUserBEListToUserFEList(
			List<UserBE> listToConvert) {

		if (listToConvert != null) { 
			List<UserFE> listToRet = new ArrayList<UserFE>();

			for (UserBE userBe : listToConvert) {
				listToRet.add(convertUserBEtoUserFE(userBe));
			}

			return listToRet;
		}
		return null;
	}



	private static TaskStatusType convertStatusBEtoStatusFE(
			org.tsk.mng.backend.enums.TaskStatusType statusToConvert) {
		switch (statusToConvert) {
		case Done:
			return TaskStatusType.DONE;
		case Failed:
			return TaskStatusType.FAILED;
		case InProgress:
			return TaskStatusType.IN_PROGRESS;
		case NotStarted:
			return TaskStatusType.NOT_STARTED;
		case Waiting:
			return TaskStatusType.WAITING;
		default:
			return null;
		}
	}

	private static XMLGregorianCalendar dateToXMLDate(Date dataToConvert) {

		if (dataToConvert != null) {

			try {
				GregorianCalendar calender = new GregorianCalendar();
				calender.setTime(dataToConvert);
				XMLGregorianCalendar retValue = DatatypeFactory.newInstance()
						.newXMLGregorianCalendar(calender);

				return retValue;
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace(); // TODO logger
				return null;
			}

		} return null;
	}

	private static List<TaskFE> convertTaskBEListToTaskFEList(
			List<TaskBE> taskListToConvert) {

		if (taskListToConvert != null) {

			List<TaskFE> listToRet = new ArrayList<TaskFE>();

			for (TaskBE userBe : taskListToConvert) {
				listToRet.add(convertTaskBEtoFE(userBe));
			}

			return listToRet;
		}

		return null;
	}

}
