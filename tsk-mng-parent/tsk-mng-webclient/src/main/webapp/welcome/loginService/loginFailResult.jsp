<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Login to the system failed</title>

<h1>Login has failed</h1>
</head>
<body>
	<jsp:useBean id="userResultStatusAtt" scope="request"
		class="org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult"/>
	The Result is :
	<jsp:getProperty property="resultDescription" name="userResultStatusAtt"/>
</body>
</html>