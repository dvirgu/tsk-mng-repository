<%@page import="org.tsk.mng.webclient.tools.Consts"%>
<%@page
	import="org.tsk.mng.taskmanagement.common_elements.task.taskfe.TaskFE"%>
<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<script language="JavaScript" type="text/javascript">
	function getSupport(selectedtype) {
		document.menuform.opperationType.value = selectedtype;
		document.menuform.submit();
	}
	function submitRemove(tableID) {
	try {
		var table = document.getElementById(tableID);
		var rowsCount = table.rows.length;
		var tasksid = new Array();

		for ( var i = 0; i < rowsCount; i++) {
			var rows = table.rows[i];
			var checkbox = rows.cell[0].childNodes[0];
			if (checkbox != null && checkbox.checked == true) {
				alert(rows.cell[1]);			
				tasksid.push(rows.cell[1].childNode[0]);
			}
		}
		document.menuform.params.setAttribute('params',tasksid);
		getSupport('RemoveTask');
		} catch (e) {
			alert(e);
		}
		
	}
</script>
<title>Tasks View</title>
</head>
<body>
	<jsp:useBean id="currentUserAttribute" scope="session"
		class="org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE" />

	<div id="container" style="width: 500px">

		<div id="header">
			<h2><jsp:getProperty property="firstName"
					name="currentUserAttribute" />
				<jsp:getProperty property="lastName" name="currentUserAttribute" />
				- Task View
			</h2>
		</div>
		<form name="menuform"
			action=<%=request.getContextPath() + Consts.TASKS_SERVLET%>>
			<div id="menu"
				style="background-color: #FFFFFF; height: 37px; width: 100px; float: left;">
				<input type="hidden" name="opperationType"> <input
					type="hidden" name="params">

				<table style="width: 360px;">
					<tr>
						<td><a
							href=<%=request.getContextPath() + Consts.ADD_TASK_PAGE%>>Add
								Task</a></td>
						<td><a href="javascript:submitRemove('tasksTable')">Remove
								Task</a></td>
						<td><a href="javascript:getSupport('UpdateTask')">Update
								Task</a></td>
					</tr>
				</table>
			</div>
			<div id="content"
				style="background-color: #EEEEEE; height: 600px; width: 800px; float: left;">
				<center>
					<TABLE id="tasksTable" cellpadding="15" border="1"
						style="background-color: #FFFFFF;">
						<TR>
							<TD>Select</TD>
							<TD>Task ID</TD>
							<TD>Status</TD>
							<TD>Description</TD>
							<TD>ETA</TD>
							<TD>Alert Date</TD>
							<TD>Owner</TD>
							<TD>Depended Tasks</TD>
						</TR>
						<%
							if (currentUserAttribute != null) {
								for (TaskFE task : currentUserAttribute.getTasks()) {
						%>
						<TR>
							<TD><input type="checkbox" name="checkedTaks_"
								<%=task.getTaskId()%> />
							<TD><%=task.getTaskId()%></TD>
							<TD><%=task.getStatus().toString()%></TD>
							<TD><%=task.getDescriptions()%></TD>
							<TD><!--%=task.getDeadLine().toString()%-->dummy</TD>
							<TD><!--%=task.getAlert().toString()%-->dummy</TD>
							<TD><%=task.getOwner()%></TD>
							<!--TODO TD><a href="javascript://TODO">Depended Tasks</a></TD-->
						</TR>
						<%
							}//end for
							}//end if
						%>
					</TABLE>
				</center>
			</div>

		</form>
	</div>
</body>
</html>