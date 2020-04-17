<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="col-md-8">

	<div>
		<h1>Create New Team</h1>
		<p>Please use an appropriate team name.</p>
	</div>
	
	<div class="form-group">
		<c:url var="createTeamURL" value="/createTeam" />
		<form method="POST" action="${createTeamURL}" id="createTeam">
			<div class="form-group">
				<label for="teamName">Team Name: </label>
				<input type="text" name="teamName" id="teamName" class="form-control">
				<input type="hidden" value="${Integer.parseInt(currentUser.userID)}" name="captainId">
				<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-success">Create Team!</button>
			</div>
		</form>
	</div>

</div>
<div></div>


<c:import url="/WEB-INF/jsp/footer.jsp" />