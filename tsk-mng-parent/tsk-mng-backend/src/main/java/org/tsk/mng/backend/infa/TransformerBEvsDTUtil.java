package org.tsk.mng.backend.infa;

import java.util.ArrayList;
import java.util.List;

import org.tsk.mng.backend.model.TaskBE;
import org.tsk.mng.backend.model.UserBE;
import org.tsk.mng.dal.model.TaskDT;
import org.tsk.mng.dal.model.TaskDT.TaskStatusType;
import org.tsk.mng.dal.model.UserDT;
import org.tsk.mng.dal.model.UserDT.PermissionType;




/**
 * This class used to provide Transformation services :
 * From DataTypes object to ObjectBE,
 * From ObjectBe to ObjectFe
 * 
 * 
 * @since August 17 ,2012
 * @author Dvirgu
 *
 */
public class TransformerBEvsDTUtil {



	public static TaskBE convertTaskDTtoBE(TaskDT taskDTtoConvert) {
		
		return null;
	}
	
	
	/**
	 * 
	 * 
	 * @param user
	 * @return
	 */
	public static UserDT convertUserBEtoDT(UserBE userToConvert) {

		if (userToConvert != null) {

			UserDT userToRet = new UserDT();

			userToRet.setFirstName(userToConvert.getFirstName());
			userToRet.setLastName(userToConvert.getLastName());
			userToRet.setMail(userToConvert.getMail());
			userToRet.setNickName(userToConvert.getNickName());
			userToRet.setPassword(userToConvert.getPassword());
			userToRet.setPermission(convertPermissionBEtoDT(userToConvert.getPermission()));
			userToRet.setSuperior(convertSuperiorBEtoDT(userToConvert.getSuperiors()));
			userToRet.setTasks(convertTaskListBEtoDT(userToConvert.getTasks()));
			
			return userToRet;
		} 

		return null;


	}

	private static List<TaskDT> convertTaskListBEtoDT(List<TaskBE> tasks) {

		if (tasks != null) {
			List<TaskDT> listToRet = new ArrayList<TaskDT>();

			for (TaskBE taskBe : tasks) {
				listToRet.add(convertTaskBEtoDT(taskBe));
			}
			
			return listToRet;
		}

		return null;
	}

	private static TaskDT convertTaskBEtoDT(TaskBE taskBeToConvert) {

		if (taskBeToConvert != null) {
			TaskDT taskDTtoRet = new TaskDT();

			taskDTtoRet.setAlert(taskBeToConvert.getAlert());
			taskDTtoRet.setDeadline(taskBeToConvert.getDeadline());
			taskDTtoRet.setDependentTasks(convertTaskListBEtoDT(taskBeToConvert.getDependentTasks()));
			taskDTtoRet.setOwner(convertUserBEtoDT(taskBeToConvert.getOwner()));
			taskDTtoRet.setStatus(convertStatucBEtoDT(taskBeToConvert.getStatus()));
			taskDTtoRet.setTaskId(taskBeToConvert.getTaskId());
			
			return taskDTtoRet;
		}
		return null;
	}

	private static TaskStatusType convertStatucBEtoDT(
			org.tsk.mng.backend.enums.TaskStatusType status) {

		switch (status) {
		case Done:
			return TaskStatusType.Done;
		case Failed :
			return TaskStatusType.Failed;
		case InProgress :
			return TaskStatusType.InProgress;
		case NotStarted :
			return TaskStatusType.NotStarted;
		case Waiting :
			return TaskStatusType.Waiting;
		default:
			return null;
		}
	}

	private static UserDT convertSuperiorBEtoDT(List<UserBE> superiors) {
		
		if (superiors != null) {
			return convertUserBEtoDT(superiors.get(0));
		}

		return null;
	}

	private static PermissionType convertPermissionBEtoDT(
			org.tsk.mng.backend.enums.PermissionType permission) {

		switch (permission) {
		
		case Admin:
			return PermissionType.Admin;
		case User :
			return PermissionType.User;
		default:
			return null;
		}
	}





}
