<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<div>
	<c:choose>
		<c:when test="${empty currentUser}">
			<c:url var="loginHref" value="/login" />
			<a href="${loginHref}"><button class="btn btn-primary">Log
					In</button></a>
		</c:when>
		<c:when test="${currentUser.role < 3}">
			<h2>You must be an organizer to manage tournaments!</h2>
			<c:url var="newUserHref" value="/users/new" />
			<a href="${newUserHref}"><button class="btn btn-primary">Register</button></a>
		</c:when>
	</c:choose>
</div>
<div>
	<h1>Organizer Dashboard</h1>
</div>
<div class="col-md-8">
	<c:url var="organizerTournaments" value="${organizerTournamentsList}" />


	<%-- <c:if test="organizerTournaments.size() = 0">--%>

	<p>Sample. Should show if no tournaments being hosted by this
		organizer</p>
	<h2>No tournaments hosted! Register a new tournament</h2>
	<c:url var="registerTournamentURL" value="/tournaments/newTournament" />
	<div class="form-group">
		<form method="POST" action="${registerTournamentURL}"
			id="registerTournament">
			<div>
				<label for="name">Tournament Name: </label> <input type="text"
					name="name" class="form-control" id="tournamentName">
			</div>
			<div>
				<label for="date">Date: </label> <input type="datetime" name="date"
					class="form-control" id="tournamentDate">
			</div>
			<div>
				<label for="location">Location: </label> <input type="text"
					class="form-control" name="location" id="tournamentLocation">
			</div>
			<div>
				<label for="game">Game: </label> <input type="text" name="game"
					class="form-control" id="tournamentGame">
			</div>
			<div class="radio">
				<label><input type="radio" class="optionsRadios"
					id="optionsRadios1" name="type" value="Single" checked>Single
					Elimination</label>
			</div>
			<div>
				<label for="description">Description: </label>
				<textarea name="description" rows="4" form="registerTournament"
					class="form-control" id="tournamentDescription">Describe your tournament...</textarea>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Register Tournament</button>
			</div>
		</form>
	</div>
	<%--</c:if> --%>
	<div class="form-group">
		<form class="searchForm" id="earchForm">
			<!-- display: flex; align-items: center; -->
			<label for="searchFilter">Search: </label> <input id="searchBar"
				class="form-control" type="text" name="searchFilter"
				placeholder="Search">
			<button class="btn btn-success" type="submit">Search</button>
		</form>
	</div>
</div>
<div></div>


<c:import url="/WEB-INF/jsp/footer.jsp" />