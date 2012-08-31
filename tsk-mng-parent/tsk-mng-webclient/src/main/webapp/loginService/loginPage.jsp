<html>
	<body>
		<h2>Task Management System - Login</h2>
		<script type="text/javascript" src="ajaxCode.js"></script>

		<%@page import="org.tsk.mng.webclient.tools.Consts"%>

		<form method="post"
			action=<%=request.getContextPath() + Consts.LOGIN_SERVLET_URL%>>
			<table>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="userName" style="width: 160" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" style="width: 160;"></td>
				</tr>
				<!-- input type="button" value="Send" name="sendButton" onclick="callServer()"-->
			</table>
			<br> <br> <input type="submit" value="Login">
			<%
				String userResultStatusAtt = (String) request
						.getAttribute(Consts.SERVICE_RESULT_DESCRIPTION_ATT);
				if (userResultStatusAtt != null) {
					out.print(userResultStatusAtt);
				}
			%>
		</form>
	</body>
</html>
