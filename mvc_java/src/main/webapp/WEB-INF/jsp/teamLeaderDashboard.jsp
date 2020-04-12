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
			<a href="${newUserHref}"><button class="btn btn-primary">Register</button></a>
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

	<div>
		<p>Sample. Should show if no tournaments are registered</p>
		<h2>No tournaments! Join a tournament</h2>
	</div>
	<c:url var="joinTournamentURL" value="/tournaments/join" />
	<div class="form-group">
		<form method="POST" action="${registerTournamentURL}"
			id="registerTournament">
			<div>
				<label for="name">Tournament Name: </label> <select
					id="tournamentSelect" class="form-control">
					<c:forEach var="tournament" items="${allTournaments}">
						<option value="${tournament.id}">${tournament.name}-
							${tournament.game}</option>
					</c:forEach>

				</select>
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-primary">Join
					Tournament</button>
			</div>
		</form>
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
		<h2>Manage Team Members</h2>
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
		<h2>Manage Tournaments</h2>
		<table class="table table-hover table-striped">
			<tr>
				<th>Name</th>
				<th>Game</th>
				<th>Type</th>
				<th>Location</th>
				<th>Date</th>
			</tr>

			<c:choose>
				<c:when test="${organizerTournaments != 0}">
					<p>there's something in organizer tournaments</p>
				</c:when>

				<c:otherwise>
					<c:forEach var="tournament" items="${organizerTournaments}"> <!-- this will be team tournaments -->

						<tr>
							<c:url var="tournamentDetailURL" value="/tournament/detail?id=${tournament.id}"/>
							<td><a href="${tournamentDetailURL}"><c:out value="${tournament.name}" /></a></td>
							<td><c:out value="${tournament.game}" /></td>
							<td><c:out value="${tournament.type}" /></td>
							<td><c:out value="${tournament.location}" /></td>
							<td><c:out value="${tournament.date}" /></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<c:if test="${organizerTournaments == 0}">
			<h2 class="text-center">No tournaments found.</h2>
			<a href="#">Join a Tournament</a>
		</c:if>
	</div>
</div>
<div></div>


<c:import url="/WEB-INF/jsp/footer.jsp" />