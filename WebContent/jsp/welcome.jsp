<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
</head>

<body>
	
	<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container w3-row">
    <div class="w3-col s8 w3-bar">
      <span>Welcome, <strong>${UserEmail}</strong></span><br>
    </div>
  </div>
  <hr>
  <div class="w3-bar-block">
    <a href="viewIncidents" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" title="close menu"><i class="fa fa-remove fa-fw"></i>  View Incident</a>
   
    
  </div>
</nav>
	
	
	
	
</body>
</html>