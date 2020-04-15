<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<div>

<h1 class="text-center">Welcome to Tourney Time!</h1>
<h2>This is a test for the map API</h2>
</div>
<div>
<c:url var="apiKeyValue" value="${apiKey}"/>
<iframe width="600" height="450" frameborder="0" style="border: 0"
	src="https://www.google.com/maps/embed/v1/place?key=${apiKeyValue}
    &q=tech elevator detroit"
	allowfullscreen> </iframe>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />