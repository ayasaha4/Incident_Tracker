<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="loginBaseTemplate">
	<tiles:putAttribute name="body">
		<div class="reg-page">

			<div class="form">
				<div align="center" style="color: red; padding-bottom: 10px;">${message}</div>
				<form:form id="registerForm" class="registerform"
					modelAttribute="register" action="registerProcess" method="post">

					<table>
						<tr class="row">
							<td><form:label path="userName">Username: </form:label></td>
							<td><form:input path="userName" name="userName"
									id="userName" /></td>
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
							<td><form:input path="location" name="location"
									id="location" /></td>
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
	</tiles:putAttribute>
</tiles:insertDefinition>
