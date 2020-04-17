<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="col-md-8">

	<div>
		<h1>Team Created!</h1>
	</div>
	<div>
		<c:url var="teamDashboardURL" value="/teamLeaderDashboard"/>
		<a href="${teamDashboardURL}"><button class="btn btn-success">Team Dashboard</button></a>
	</div>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />