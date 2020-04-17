<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="col-md-8">

	<div>
		<h1>Tournament Created!</h1>
	</div>
	<div>
		<c:url var="organizerDashboardURL" value="/organizerDashboard"/>
		<a href="${organizerDashboardURL }"><button class="btn btn-success">Organizer Dashboard</button></a>
	</div>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />