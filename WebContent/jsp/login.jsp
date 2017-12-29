<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js'></script>
<script src="<%=request.getContextPath()%>/resources/js/index.js"></script>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>
	<div class="login-page">

		<div class="form">

			<div align="center" style="color: red; padding-bottom: 10px;">${message}</div>
			<form:form id="loginForm" class="login-form" modelAttribute="login"
				action="loginProcess" method="post">

				<table>
					<tr class="row">
						<td><form:label path="userName">Username: </form:label></td>
						<td align="left"><form:input path="userName" name="userName"
								id="userName" /></td>
						<td class="error_msg">
					</tr>
					<tr class="row">
						<td><form:label path="password">Password:</form:label></td>
						<td align="left"><form:password path="password"
								name="password" id="password" /></td>
						<td class="error_msg">
					</tr>

					<tr align="right">
						<td colspan="2"><button id="login" name="login" onclick="">Login</button></td>
					</tr>
				</table>

			</form:form>
			<p class="message">
				Not registered? <a href=register>Create an account</a>
			</p>

		</div>
	</div>

</body>
</html>