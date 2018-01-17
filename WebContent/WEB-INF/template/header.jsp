
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Top container -->
<c:if test="${empty sessionScope['user_info']}">
	<c:redirect url="login" />
</c:if>

<a href="logout">Logout <c:out value="${sessionScope['user_info']}" />
</a>