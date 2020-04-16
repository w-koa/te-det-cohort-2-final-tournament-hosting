<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div>
	<h2>Browse Tournaments</h2>
</div>
<div class="col-md-8">
	<c:url var="tournamentSearchURL" value="/tournaments/search"/>
	<form action="${tournamentSearchURL}" method="GET" class="searchForm" id="tournamentsSearchForm"> <!-- display: flex; align-items: center; -->
		<label for="searchFilter">Search Tournaments: </label>
		<input id="searchBar" class="form-control" type="text" name="search" placeholder="Search">
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
			<th>Date</th> <!-- Ongoing, Completed, Open for Registration? Can use to filter tournaments -->
		</tr>
		<c:forEach var="tournament" items="${tournaments}"> 
			<tr>
				<c:url var="tournamentDetail" value="/tournament/detail">
				<c:param value="${tournament.id}" name="tournamentId" /></c:url><!-- Sample to use -->
			
				<td><a href="${tournamentDetail}"><c:out value="${tournament.name}"/> </a></td> <!--  make this into a clickable thing -->
				<td><c:out value="${tournament.game}"/></td>
				<td><c:out value="${tournament.type}"/></td>
				<td><c:out value="${tournament.location}"/></td>
				<c:url var="organizerDetail" value="/organizers/detail?=id"/>
				<td><c:out value="${tournament.organizerId}"/></td>
				<td><c:out value="${tournament.date}"/></td> 
			</tr>
		</c:forEach>
	
		<c:forEach var="tournament" items="${matchingTournaments}"> 
			<tr>
				<c:url var="tournamentDetail" value="/tournament/detail">
				<c:param value="${tournament.id}" name="tournamentId" /></c:url><!-- Sample to use -->
			
				<td><a href="${tournamentDetail}"><c:out value="${tournament.name}"/> </a></td> <!--  make this into a clickable thing -->
				<td><c:out value="${tournament.game}"/></td>
				<td><c:out value="${tournament.type}"/></td>
				<td><c:out value="${tournament.location}"/></td>
				<c:url var="organizerDetail" value="/organizers/detail?=id"/>
				<td><c:out value="${tournament.organizerId}"/></td>
				<td><c:out value="${tournament.date}"/></td> 
			</tr>
		</c:forEach>
	</table>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />