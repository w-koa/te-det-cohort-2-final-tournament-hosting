<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/header.jsp" />
<div class="col-md-8">
	<c:choose>
		<c:when test="${empty currentUser}">
			<c:url var="loginHref" value="/login" />
			<a href="${loginHref}"><button class="btn btn-primary">Log
					In</button></a>
		</c:when>
		<c:when test="${currentUser.role != 3}">
			<h2>You must be an organizer to manage tournaments!</h2>
			<c:url var="newUserHref" value="/users/new" />
			<a href="${newUserHref}"><button class="btn btn-primary">Register</button></a>
		</c:when>
	</c:choose>
</div>
<div>
	<h1>Organizer Dashboard</h1>
	<h2>
		<c:out value="Welcome, ${currentUser.userName}!" />
	</h2>
</div>
<div class="col-md-8">


	<h2>Register a new tournament</h2>
	<c:url var="registerTournamentURL" value="/tournaments/newTournament" />
	<div class="form-group">
		<form method="POST" action="${registerTournamentURL}"
			id="registerTournament">
			<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
			<input type="hidden" name="organizerId" value="${currentUser.userID}"/>
			<input type="hidden" name="type" value="single"/>	
			<div>
				<label for="name">Tournament Name: </label> <input type="text"
					name="name" class="form-control" id="name"
					placeholder="Tournament Name">
			</div>
	
			 <div>
				<label for="date">Date: </label> <input type="date" name="date"
					class="form-control" id="date" value = "<fmt:formatDate value="${date}" pattern="yyyy-mm-dd" />">
					
			</div> 
			<div>
				<label for="location">Location: </label> <input type="text"
					class="form-control" name="location" id="location"
					placeholder="Location">
			</div>
			<div>
				<label for="game">Game: </label> <input type="text" name="game"
					class="form-control" id="game" placeholder="Game">
			</div>
			<!-- <div class="radio">
				<label><input type="radio" class="optionsRadios"
					id="optionsRadios1" name="type" value="single" checked>Single
					Elimination</label>
			</div> -->
		
			<div>
				<label for="format">Format: </label>
				<textarea name="format" rows="4" form="registerTournament"
					class="form-control" id="format">Describe your tournament format</textarea>
			</div>
			<div>
				<label for="rules">Rules: </label>
				<textarea name="rules" rows="4" form="registerTournament"
					class="form-control" id="rules">Describe your tournament rules</textarea>
			</div>
			<div>
				<label for="prizes">Prizes: </label>
				<textarea name="prizes" rows="4" form="registerTournament"
					class="form-control" id="prizes">Describe your tournament prizes</textarea>
			</div> 
			<div class="form-group">
				<button type="submit" class="btn btn-success">Register
					Tournament</button>
			</div>
		</form>
	</div>

	<div class="form-group">
		<form method="POST" class="searchForm" id="searchForm">
			<!-- display: flex; align-items: center; -->
			<label for="searchFilter">Search: </label> <input id="searchBar"
				class="form-control" type="text" name="searchFilter"
				placeholder="Search">
			<button class="btn btn-success" type="submit">Search</button>
		</form>
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
				<c:when test="${organizerTournaments.size() == 0}">
					<p>there's something in organizer tournaments</p>
				</c:when>

				<c:otherwise>
					<c:forEach var="tournament" items="${organizerTournaments}">

						<tr>
							<c:url var="tournamentDetailURL" value="/tournament/detail">
							<c:param value="${tournament.id}" name="tournamentId"/>
							</c:url>
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
		<c:if test="${organizerTournaments.size() == 0}">
			<h2 class="text-center">No tournaments found.</h2>
			<a href="#">Host a Tournament</a>
		</c:if>
	</div>
</div>
<div class="col-md-8">
	<div>
		<h2>Invite Teams to your tournaments!</h2>
	</div>
	<div class="form-group">
		<c:url var="addTeamURL" value="/tournaments/addTeam"/>
		<form method="POST" action="${addTeamURL}" id="inviteTeamForm">
			<div>
				<label for="tournamentName">Tournament: </label>
				<select id="tournamentSelect" name="tournamentId" class="form-control">
					<c:forEach var="tournament" items="${organizerTournaments}">
						<option value="${tournament.id}">${tournament.name}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<label for="teamName">Team: </label> 
				<select id="teamSelect" name="teamId" class="form-control">
					<c:forEach var="team" items="${allTeams}">
						<option value="${team.id}">${team.name}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
			</div>
			<div>
				<button type="submit" class="btn btn-success">Add Team!</button>
			</div>
		</form>
	</div>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />