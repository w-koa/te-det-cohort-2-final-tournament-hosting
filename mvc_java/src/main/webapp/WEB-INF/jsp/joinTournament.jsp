<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="col-md-8">

	<div>
		<h1>Join Tournament</h1>
	</div>

	<div class="form-group">
		<c:url var="joinTournamentURL" value="/tournaments/join" />
		<form method="POST" action="${joinTournamentURL}" id="joinTournament">
			<div>
				<label for="tournamentSelect">Tournament Name: </label> <select
					id="tournamentSelect" class="form-control" name="tournamentId">
					<c:forEach var="tournament" items="${allTournaments}">
						<option value="${tournament.id}">${tournament.name} - ${tournament.game}</option>
					</c:forEach>

				</select>
				<input type="hidden" value="${userTeam.id}" name="teamId">
				<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-success">Join
					Tournament</button>
			</div>
		</form>
	</div>

</div>
<div></div>


<c:import url="/WEB-INF/jsp/footer.jsp" />