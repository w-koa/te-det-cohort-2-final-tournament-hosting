<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<div id="dashboardHeader">
	<c:choose>
		<c:when test="${empty currentUser}">
			<c:url var="loginHref" value="/login" />
			<a href="${loginHref}"><button class="btn btn-primary">Log
					In</button></a>
		</c:when>
		<c:when test="${currentUser.role != 2}">
			<h2>You must be an team captain to manage the team!</h2>
			<c:url var="newUserHref" value="/users/new" />
			<a href="${newUserHref}"><button class="btn btn-success">Register</button></a>
		</c:when>
	</c:choose>
</div>
<div>
	<h1>Team Captain Dashboard</h1>
	<h2>
		<c:out value="Welcome, ${currentUser.userName}!" />
	</h2>
	<%--<h2>${userTeam.teamName}</h2> --%>
	<%-- <c:url var="editTeamNameURL" value="/editTeamName" 
		 <a href="${editTeamNameURL">Edit</a> 
		 
		 Update team name.
		 Update captainID another option to consider.
		 --%>

</div>
<div class="col-md-8">
	<c:if test="${userTeam.name == null}">
		<h2>You must have a team to compete!</h2>
	</c:if>
	<div>
		<c:if test="${userTeam.name != null}">
			<div>
				<c:if test="${teamTournaments.size() == 0}">
					<h2>No tournaments! Join a tournament</h2>
				</c:if>
			</div>

			<div class="form-group">
				<c:url var="joinTournamentURL" value="/tournaments/join" />
				<form method="POST" action="${joinTournamentURL}"
					id="joinTournament">
					<div class="form-group">
						<label for="tournamentSelect">Tournament Name: </label> <select
							id="tournamentSelect" class="form-control" name="tournamentId">
							<c:forEach var="tournament" items="${allTournaments}">
								<option value="${tournament.id}">${tournament.name}-
									${tournament.game}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<input type="hidden" value="${userTeam.id}" name="teamId">
						<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
					</div>

					<div class="form-group">
						<button type="submit" class="btn btn-success">Join
							Tournament</button>
					</div>
				</form>
			</div>
		</c:if>
	</div>
	<%-- Not sure if we need a search form on this page.
	
	<div class="form-group">
		<form class="searchForm" id="searchForm">
			<!-- display: flex; align-items: center; -->
			<label for="searchFilter">Search: </label> <input id="searchBar"
				class="form-control" type="text" name="searchFilter"
				placeholder="Search">
			<button class="btn btn-success" type="submit">Search</button>
		</form>
	</div>
	 --%>
	<div>

		<div>
			<c:if test="${userTeam.name == null}">
				<h2>Create a team!</h2>
				<c:url var="createTeamURL" value="/createTeam" />
				<a href="${createTeamURL}"><button class="btn btn-success">Create
						Team</button></a>

			</c:if>
		</div>
		<c:if test="${userTeam.name != null}">
		<h2>${userTeam.name}'s Team Members</h2>
		</c:if>
		<c:if test="${userTeam.name == null}">
		<p> <p>
		</c:if>
		<table class="table table-hover table-striped">
			<tr>
				<th>Name</th>
			</tr>
			<tr>
				<c:forEach var="teamMember" items="${teamMembers}">
					<td>${teamMember.userName}</td>
				</c:forEach>
			</tr>
		</table>
	</div>
	<div>
		<h2>Registered Tournaments</h2>
		<table class="table table-hover table-striped">
			<tr>
				<th>Name</th>
				<th>Game</th>
				<th>Type</th>
				<th>Location</th>
				<th>Date</th>
			</tr>

			<c:choose>
				<c:when test="${teamTournaments.size() == 0}">
					<p>No tournaments yet</p>
				</c:when>

				<c:otherwise>
					<c:forEach var="tournament" items="${teamTournaments}">
						<!-- this will be team tournaments -->

						<tr>
							<c:url var="tournamentDetailURL" value="/tournament/detail">
								<c:param value="${tournament.id}" name="tournamentId" />
							</c:url>
							<td><a href="${tournamentDetailURL}"><c:out
										value="${tournament.name}" /></a></td>
							<td><c:out value="${tournament.game}" /></td>
							<td><c:out value="${tournament.type}" /></td>
							<td><c:out value="${tournament.location}" /></td>
							<td><c:out value="${tournament.date}" /></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<c:if test="${teamTournaments.size() == 0}">
			<h2 class="text-center">No tournaments found.</h2>
			<p class="text-center"><a href="#">Join a Tournament</a></p>
		</c:if>
	</div>
</div>
<div></div>


<c:import url="/WEB-INF/jsp/footer.jsp" />