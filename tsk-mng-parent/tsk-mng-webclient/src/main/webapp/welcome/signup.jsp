<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title> SignUp -Task Management System </title>
</head>

<h1>SignUp - User</h1>
<body>

<p>Please fill all fields :</p>
<form method="post" action="SignUp">
Email : <input type="text"/ name="mail"><br><br>
Password : <input type="password" name="password"/><br><br>
First Name : <input type="text"/ name="firstName"><br><br>
Last Name : <input type="text"/ name="lastName"><br><br>
Nickname : <input type="text"/ name="nickName"><br><br>
Permission:<br><br> <div> User <input type="radio" checked="checked" name="permissions" value="User"> Admin <input type="radio" name="permissions" value="Admin"></div><br><br>
<input type="submit" value="Submit"/>
</form>
</body>
</html>