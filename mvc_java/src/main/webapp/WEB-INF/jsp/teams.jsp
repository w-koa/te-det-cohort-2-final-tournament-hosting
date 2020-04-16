<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div>
	<h2>Browse Teams</h2>
</div>
<div class="col-md-8">
	<c:url var="teamSearchURL" value="/teams/search" />
	<form method="GET" action="${teamSearchURL}" class="searchForm"
		id="teamsSearchForm">
		<label for="searchFilter">Search Teams: </label> <input id="searchBar"
			class="form-control" type="text" name="search" placeholder="Search">
		<button class="btn btn-success" type="submit">Search</button>
	</form>
</div>
<div>
	<table class="table table-hover table-striped">
		<tr>
			<th>Name</th>
			<th>Current Tournament</th>
			<th>Game</th>
			<th>Tournament Ranking</th>
			<th>Wins</th>
			<th>Losses</th>
			<th>Team Website</th>
		</tr>
		<c:forEach var="team" items="${allTeams}">
			<tr>
				<c:url var="teamDetail" value="/teams/detail?id=${team.id}" />
				<td><a href="${teamDetail}"><c:out value="${team.name}" /></a></td>
				<td>Current?</td>
				<td>Game</td>
				<td>Ranking</td>
				<td>Wins</td>
				<td>Losses</td>
				<td>${team.name}.com</td>
			</tr>
		</c:forEach>

		<c:forEach var="team" items="${matchingTeams}">
			<tr>
				<c:url var="teamDetail" value="/teams/detail?id=${team.id}" />
				<td><a href="${teamDetail}"><c:out value="${team.name}" /></a></td>
				<td>Current?</td>
				<td>Game</td>
				<td>Ranking</td>
				<td>Wins</td>
				<td>Losses</td>
				<td>${team.name}.com</td>
			</tr>
		</c:forEach>
	</table>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />