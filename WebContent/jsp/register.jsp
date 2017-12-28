<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js'></script>
<script src="<%=request.getContextPath()%>/resources/js/index.js"></script>

</head>
<body>
	<div class="reg-page">

		<div class="form">
			<div align="center" style="color: red;padding-bottom: 10px;">${message}</div>
			<form:form id="registerForm" class="registerform"
				modelAttribute="register" action="registerProcess" method="post">

				<table>
					<tr class="row">
						<td><form:label path="userName">Username: </form:label></td>
						<td><form:input path="userName" name="userName" id="userName" /></td>
						<td class="error_msg">
					</tr>
					<tr class="row">
						<td><form:label path="password">Password:</form:label></td>
						<td><form:password path="password" name="password"
								id="password" /></td>
						<td class="error_msg">
					</tr>

					<tr class="row">
						<td><form:label path="email">Email:</form:label></td>
						<td><form:input path="email" name="email" id="email" /></td>
						<td class="error_msg">
					</tr>

					<tr class="row">
						<td><form:label path="phone">Phone:</form:label></td>
						<td><form:input path="phone" name="phone" id="phone" /></td>
						<td class="error_msg">
					</tr>

					<tr class="row">
						<td><form:label path="location">Location:</form:label></td>
						<td><form:input path="location" name="location" id="location" /></td>
						<td class="error_msg">
					</tr>

					<tr align="right">
						<td colspan="2"><form:button id="register" name="register">Register</form:button></td>
					</tr>
				</table>

			</form:form>
			<p class="message">
				Already registered? <a href=login>Sign In</a>
			</p>
		</div>
	</div>
</body>
</html>