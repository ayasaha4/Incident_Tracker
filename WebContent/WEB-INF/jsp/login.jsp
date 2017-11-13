<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Login</title>
    <link rel="stylesheet" href="WebContent/WEB-INF/resources/css/style.css">
</head>

<body>
  <div id="wrap">
  <div id="regbar">
    <div id="navthing">
    
      <h2><a href="#" id="login">Login</a> | <a href="#">Register</a></h2>
    <div class="login">
      <div class="arrow-up"></div>
      <div class="formholder">
        <div class="randompad">
           <fieldset id="loginForm" modelAttribute="login" action="loginProcess" method="post">
           <!-- <form:form id="loginForm" modelAttribute="login" action="loginProcess" method="post">
           <form:label path="username">Username: </form:label>
           <form:input path="username" name="username" id="username" />
           <form:label path="password">Password:</form:label>
           <form:password path="password" name="password" id="password" />
           <form:button id="login" name="login">Login</form:button>
           </form:form> -->
             <label name="email">Email</label>
             <input type="email" value="example@example.com" />
             <label name="password">Password</label>
             <input type="password" />
             <input type="submit" value="login" action="loginProcess" />
 
           </fieldset>
        </div>
      </div>
    </div>
    </div>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script  src="WebContent/WEB-INF/js/index.js"></script>

</body>
</html>