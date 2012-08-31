<%@page import="org.tsk.mng.webclient.tools.Consts"%>
<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>Login Page - TaskManagementSystem</title>
</head>

<body style="height: 577px;">
	<jsp:useBean id="currentUserAttribute" scope="session"
		class="org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE" />
	<h1>
		Hello
		<jsp:getProperty property="firstName" name="currentUserAttribute" />

		<jsp:getProperty property="lastName" name="currentUserAttribute" />,
		<br><br>Welcome To Task Management System
	</h1>

	<br>
	<br> click here to logout :
	<jsp:getProperty property="mail" name="currentUserAttribute" />
	<form method="post"
		action=<%=request.getContextPath() + Consts.LOGOUT_SERVLET_URL%>>
		<input type="submit" value="Logout">
	</form>

	<div>
		<center>
			<table style="width: 839px;">
				<tr>
					<td><center>
							<a href=<%=request.getContextPath() + Consts.MY_TASKS_PAGE%>
								target="targetFrame"> Tasks</a>
						</center></td>
					<td style="width: 79px;"></td>
					<td><center>
							<a href=<%=request.getContextPath() + Consts.MY_USERS_PAGE%>
								target="targetFrame"> Users</a>
						</center></td>
				</tr>
			</table>
			<iframe frameborder="0" name="targetFrame" height="600" width="1000"></iframe>
		</center>
	</div>
</body>
</html>