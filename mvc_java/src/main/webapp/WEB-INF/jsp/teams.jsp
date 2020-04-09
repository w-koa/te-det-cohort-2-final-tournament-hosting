<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div>
	<h2>Browse Teams</h2>
</div>
<div class="col-md-8">
	<form class="searchForm" id="teamsSearchForm"> <!-- display: flex; align-items: center; -->
		<label for="searchFilter">Search Teams: </label>
		<input id="searchBar" class="form-control" type="text" name="searchFilter" placeholder="Search">
		<button class="btn btn-success" type="submit">Search</button>
	</form>
</div>
<div>
	<table class="table table-hover table-striped">
		<tr>
			<th></th> <!-- Placeholder for team avatar/logo? -->
			<th>Name</th>
			<th>Current Tournament</th>
			<th>Game</th>
			<th>Tournament Ranking</th>
			<th>Wins</th> 
			<th>Losses</th>
			<th>Ties</th>
			<th>Team Website</th>
		</tr>
		<!-- <c:forEach var="team" items="allTeams"> -->
		
		<c:forEach var="team" items="${allTeams}">
			<tr>
				<c:url var="teamDetail" value="/teams/detail?id=${team.id}"/>
				<td></td> <!-- Empty for now. Team Logo placeholder -->
				<td><a href="${teamDetail}"><c:out value="${team.name}"/></a></td>
				<td>Current?</td>
				<td>Game</td>
				<td>Ranking</td>
				<td>Wins</td>
				<td>Losses</td>
				<td>Ties</td>
				<td>${team.name}.com</td>
			</tr>
		</c:forEach>
		
			<tr>
				<c:url var="teamDetail" value="/teams/detail?=id"/> <!-- Sample to use click either logo or team name
				as link -->
				<td>teamLogo.jpg</td>
				<td>Super L33T Team</td>
				<td>L33tMan</td>
				<c:url var="tournamentDetail" value="/tournaments/detail?id=${team.id}"/>
				<td>Smash Melee Championship 2020</td>
				<c:url var="gameDetail" value="/games/detail?=id"/>
				<td>Super Smash Bros. Melee</td>
				<td>2</td>
				<td>13</td>
				<td>3</td>
				<td>0</td>
				<td>superl33tteam.com</td>
			</tr>
			<tr>
				<c:url var="teamDetail" value="/teams/detail?=id"/> <!-- Sample to use -->
				<td>teamLogo.jpg</td>
				<td>Other Team</td>
				<td>N00bPwner</td>
				<td>Smash Melee Championship 2020</td>
				<td>Super Smash Bros. Melee</td>
				<td>4</td>
				<td>9</td>
				<td>6</td>
				<td>1</td>
				<td>otherteam.com</td>
			</tr>
		<!-- </c:forEach> -->
	</table>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />