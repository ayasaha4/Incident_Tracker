<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="loginBaseTemplate">
	<tiles:putAttribute name="body">

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
	</tiles:putAttribute>
</tiles:insertDefinition>
