<%@page import="org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE"%>
<%@page
	import="org.tsk.mng.taskmanagement.common_elements.task.taskfe.TaskStatusType"%>
<%@page import="org.tsk.mng.webclient.tools.Consts"%>
<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>Add Tasks</title>
</head>
<h1>Add Task</h1>
<jsp:useBean id="currentUserAttribute"
	class="org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE"
	scope="session" />
<body>
	<form action=<%=request.getContextPath() + Consts.TASKS_SERVLET%>
		method="post">
		<table>
			<tr>
				<td>Task-ID:</td>
				<td><input type="text" name=<%=Consts.TASK_ID_PARAM%> /></td>
			</tr>
			<tr>
				<td>Status:</td>
				<td>
					<%
						for (TaskStatusType status : TaskStatusType.values()) {
					%><input type="radio" name=<%=Consts.STATUS_PARAM%>
					value=<%=status.toString()%> /> <%=status.toString()%><br> <%
 	}
 %>
				</td>
			</tr>
			<tr>
				<td>Descriptions:</td>
				<td><input type="text" name=<%=Consts.DESCRIPTIONS_PARAM%> /></td>
			</tr>
			<tr>
				<td>ETA:</td>
				<td><input type="text" name=<%=Consts.DEADLINE_PARAM%> /></td>
			</tr>
			<tr>
				<td>Alert:</td>
				<td><input type="text" name=<%=Consts.DEADLINE_PARAM%> /></td>
			</tr>
			<tr>
				<td>Owner:</td>
				<td><select name=<%=Consts.TASK_OWNER_PARAM%>>
				<% for (UserFE worker : currentUserAttribute.getWorkers()) { %>
						<option><%=worker.getMail() %></option>
						<% } %> 
				</select></td>
			</tr>
		</table>
		<input type="submit" value="Send" />
	</form>
</body>
</html>