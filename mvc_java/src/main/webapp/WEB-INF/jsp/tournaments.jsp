<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div>
	<h1>Browse Tournaments</h1>
	<h2>The best place to organize your tournaments</h2>
</div>
<div class="col-md-8">
	<form>
		<label for="searchFilter">Search Tournaments: </label>
		<input id="searchBar" class="form-control" type="text" name="searchFilter" placeholder="Search">
		<button class="btn btn-success" type="submit">Search</button>
	</form>
</div>
<div>
	<table>
		<tr>
			<th>Name</th>
			<th>Game</th>
			<th>Type</th> <!-- this would refer to elimination type -->
			<th>Location</th>
			<th>Organizer</th>
			<th>Status</th> <!-- Ongoing, Completed, Open for Registration? -->
		</tr>
		<!-- <c:forEach var="tournament" items="allTournaments"> -->
			<tr>
				<c:url var="tournamentDetail" value="/tournaments/detail?=id"/> <!-- Sample to use -->
				<td>Tournament</td>
				<td>Super Smash Bros. Melee</td>
				<td>Single</td>
				<td>The Internets</td>
				<td>Smash Melee Cup</td>
				<td>Completed</td>
			</tr>
		<!-- </c:forEach> -->
	</table>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />