<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="w3-container w3-row">

	<div class="w3-col s8 w3-bar">
		<span>Welcome, <strong>${user_info}</strong></span><br>

	</div>
</div>
<hr>
<div class="w3-container"></div>
<div class="w3-bar-block">
	<c:forEach var="lang" items="${offerings}">
		<a href="${lang}" class="w3-bar-item w3-button w3-padding"> <i
			class="fa fa-eye fa-fw"> </i> ${lang}
		</a>
		<br>
	</c:forEach>

</div>