<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div>
	<h2>Browse Tournaments</h2>
</div>
<div class="col-md-8">
	<form class="searchForm" id="tournamentsSearchForm"> <!-- display: flex; align-items: center; -->
		<label for="searchFilter">Search Tournaments: </label>
		<input id="searchBar" class="form-control" type="text" name="searchFilter" placeholder="Search">
		<button class="btn btn-success" type="submit">Search</button>
	</form>
</div>
<div>
	<table class="table table-hover table-striped">
		<tr>
			<th>Name</th>
			<th>Game</th>
			<th>Type</th> <!-- this would refer to elimination type -->
			<th>Location</th>
			<th>Organizer</th>
			<th>Status</th> <!-- Ongoing, Completed, Open for Registration? Can use to filter tournaments -->
		</tr>
		<!-- <c:forEach var="tournament" items="allTournaments"> -->
			<tr>
				<c:url var="tournamentDetail" value="/tournaments/detail?=id"/> <!-- Sample to use -->
				<td>Smash Melee Championship 2020</td> <!--  make this into a clickable thing -->
				<c:url var="gameDetail" value="/games/detail?=id"/>
				<td>Super Smash Bros. Melee</td>
				<td>Single</td>
				<td>The Internets</td>
				<c:url var="organizerDetail" value="/organizers/detail?=id"/>
				<td>Smash Melee Union</td>
				<td>Completed</td> 
			</tr>
		<!-- </c:forEach> -->
	</table>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />