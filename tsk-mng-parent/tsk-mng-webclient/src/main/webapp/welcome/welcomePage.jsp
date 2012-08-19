<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>Login Page - TaskManagementSystem</title>
</head>

<body>
	<jsp:useBean id="currentUserAttribute" scope="session"
		class="org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE"/>
	<h1> Hello <jsp:getProperty property="firstName" name="currentUserAttribute" /> 
	<jsp:getProperty property="lastName" name="currentUserAttribute" />,
	 Welcome To Task Management System</h1>
	
	<br><br>
	click here to logout : <jsp:getProperty property="mail" name="currentUserAttribute"/>
	 
	
</body>
</html>