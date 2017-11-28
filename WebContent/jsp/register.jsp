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
<script src="<%=request.getContextPath()%>/resources/js/index.js">
	
</script>
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

</head>
<body>
<div class="login-page">

		<div class="form">

		<form:form id="registerForm" class="registerform"
				modelAttribute="register" action="registerProcess" method="post">

				<table>
					<tr>
						<td><form:label path="userName">Username: </form:label></td>
						<td><form:input path="userName" name="userName" id="userName" /></td>
					</tr>
					<tr>
						<td><form:label path="password">Password:</form:label></td>
						<td><form:password path="password" name="password"
								id="password" /></td>
					</tr>

					<tr>
						<td><form:label path="email">Email:</form:label></td>
						<td><form:input path="email" name="email" id="email" /></td>
					</tr>

					<tr>
						<td><form:label path="phone">Phone:</form:label></td>
						<td><form:input path="phone" name="phone" id="phone" /></td>
					</tr>

					<tr>
						<td><form:label path="location">Location:</form:label></td>
						<td><form:input path="location" name="location" id="location" /></td>
					</tr>

					<tr align="right">
						<td><form:button id="register" name="register">Register</form:button></td>
					</tr>
					<tr>
						<td>
							<p class="message">
								Already registered? <a href=login>Sign In</a>
							</p>
						</td>
					</tr>

				</table>

			</form:form>

</div>
</div>
</body>
</html>