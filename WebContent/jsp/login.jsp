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
<script src="<%=request.getContextPath()%>/resources/js/index.js">
	
</script>
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

</head>

<body>
	<div class="login-page">

		<div class="form">


			<form:form id="loginForm" class="login-form" modelAttribute="login"
				action="loginProcess" method="post">

				<table>
					<tr>
						<td><form:label path="userId">Username: </form:label></td>
						<td><form:input path="userId" name="userId" id="userId" /></td>
					</tr>
					<tr>
						<td><form:label path="password">Password:</form:label></td>
						<td><form:password path="password" name="password"
								id="password" /></td>
					</tr>

					<tr align="right">
						<td><form:button id="login" name="login">Login</form:button></td>

						<p class="message">
							Not registered? <a href=register>Create an account</a>
						</p>

					</tr>
				</table>

			</form:form>

		</div>
	</div>

	<!-- <fieldset id="loginForm" modelAttribute="login" action="loginProcess" method="post">
           
             <label name="email">Email</label>
             <input type="email" value="example@example.com" />
             <label name="password">Password</label>
             <input type="password" />
             <input type="submit" value="login" action="loginProcess" />
 
           </fieldset> -->

	<%-- <form name='login' modelAttribute="login" action="${pageContext.request.contextPath}/loginProcess" method='POST'>
      <table>
         <tr>
            <td>User:</td>
            <td><input type='text' name='userid' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
  </form> --%>


</body>
</html>