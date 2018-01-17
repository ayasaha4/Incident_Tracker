<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="baseTemplate">
    <tiles:putAttribute name="body">
 
 
 
       
            <h3>Home page </h3>
 
            <p>WELCOME ${user_info}.</p>
            
 
 
 
    </tiles:putAttribute>
</tiles:insertDefinition>