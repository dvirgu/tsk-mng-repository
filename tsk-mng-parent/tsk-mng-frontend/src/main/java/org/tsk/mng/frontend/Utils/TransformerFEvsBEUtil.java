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
public class TransformerFEvsBEUtil {

	public static UserResult convertUserResultBEtoUserResult(UserResultBE userResultBe) {

		UserResult userToRet = new UserResult();
		OperationResultStatus status;

		try {
			List<UserFE> newUsers = convertUserListBEtoFE(userResultBe.getUsers());
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
			taskToRet.setOwner(convertUserBEtoFE(taskToConvert.getOwner()));
			taskToRet.setStatus(convertStatusBEtoStatusFE(taskToConvert.getStatus()));
			taskToRet.setTaskId(taskToConvert.getTaskId());

			List<TaskFE> newDependencyList = convertTaskListBEtoFE(taskToConvert.getDependentTasks());
			taskToRet.getDependentTasks().addAll(newDependencyList);

			return taskToRet;
		}
		return null;
	}

	public static UserFE convertUserBEtoFE(UserBE userBEToConvert) {

		if (userBEToConvert != null) {
			UserFE userToRet = new UserFE();

			userToRet.setFirstName(userBEToConvert.getFirstName());
			userToRet.setLastName(userBEToConvert.getLastName());
			userToRet.setMail(userBEToConvert.getMail());
			userToRet.setNickName(userBEToConvert.getNickName());
			userToRet.setPassword(userBEToConvert.getPassword());
			userToRet.setPermission(convertPermission(userBEToConvert
					.getPermission()));

			List<UserFE> newSuperiors = convertUserListBEtoFE(userBEToConvert.getSuperiors());
			userToRet.getSuperiors().addAll(newSuperiors);

			List<UserFE> newWorkers = convertUserListBEtoFE(userBEToConvert.getWorkers());
			userToRet.getWorkers().addAll(newWorkers);

			List<TaskFE> newTasks = convertTaskListBEtoFE(userBEToConvert.getTasks());
			userToRet.getTasks().addAll(newTasks);

			return userToRet;
		}

		return null;
	}

	public static UserBE convertUserFEtoBE(UserFE userFEtoConvert) {

		if (userFEtoConvert != null) {
			UserBE userBeToRet = new UserBE();
			userBeToRet.setFirstName(userFEtoConvert.getFirstName());
			userBeToRet.setLastName(userFEtoConvert.getLastName());
			userBeToRet.setMail(userFEtoConvert.getMail());
			userBeToRet.setNickName(userFEtoConvert.getNickName());
			userBeToRet.setPassword(userFEtoConvert.getPassword());
			userBeToRet.setPermission(convertPermissionFEtoBE(userFEtoConvert.getPermission()));
			userBeToRet.setSuperiors(convertUserListFEtoBE(userFEtoConvert.getSuperiors()));
			userBeToRet.setTasks(convertTaskListFEtoBE(userFEtoConvert.getTasks()));
			userBeToRet.setWorkers(convertUserListFEtoBE(userFEtoConvert.getWorkers()));
			
			return userBeToRet;
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
		case ADMIN:
			return PermissionType.ADMIN;
		case USER:
			return PermissionType.USER;
		default:
			return PermissionType.USER;
		}
	}

	private static List<UserFE> convertUserListBEtoFE(
			List<UserBE> listToConvert) {

		if (listToConvert != null) { 
			List<UserFE> listToRet = new ArrayList<UserFE>();

			for (UserBE userBe : listToConvert) {
				listToRet.add(convertUserBEtoFE(userBe));
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

	private static List<TaskFE> convertTaskListBEtoFE(
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

	private static List<TaskBE> convertTaskListFEtoBE(List<TaskFE> tasksToConvert) {
		
		if (tasksToConvert != null) {
			
			List<TaskBE> listToRet = new ArrayList<TaskBE>();
			
			for (TaskFE taskFE : tasksToConvert) {
				listToRet.add(convertTaskFEtoBE(taskFE));
			}
			
			return listToRet;
		}
		
		return null;
	}

	private static List<UserBE> convertUserListFEtoBE(List<UserFE> superiorsToConvert) {
		
		if (superiorsToConvert != null) {
			List<UserBE> listToRet = new ArrayList<UserBE>();
			
			for (UserFE userFE : superiorsToConvert) {
				listToRet.add(convertUserFEtoBE(userFE));
			}
			
			return listToRet;
		}
		
		return null;
		
	}

	private static org.tsk.mng.backend.enums.PermissionType convertPermissionFEtoBE(
			PermissionType permission) {

		switch (permission) {
		case ADMIN :
			return org.tsk.mng.backend.enums.PermissionType.ADMIN;
		case USER :
			return org.tsk.mng.backend.enums.PermissionType.USER;
		default :
			return null;
		}

	}

}
