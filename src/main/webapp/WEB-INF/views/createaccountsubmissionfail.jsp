<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${resultsuccess != null}">
	<div class="alert alert-success">
		<strong>${resultsuccess}!</strong>
	</div>
</c:if>
<c:if test="${resulterror != null}">
	<div class="alert alert-error">
		<strong>${resulterror}!</strong>
	</div>
</c:if>