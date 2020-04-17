<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div>
	<h1>${team.name}</h1>
	<h2>Leader: ${teamLeader.userName}</h2>
	<!-- Leader can appoint new leader if more than one member of Team -->
	<label for="temp">Website: </label>
	<a href="#" id="temp">${team.name}.com</a>
</div>
<div id="allTeamInfoBlock">
	<div id="teamInfoTextBlock" class="">
		<div id="teamMembers" class="teamMembers">
			<h2><c:out value="Team Members (${teamMembers.size()})"/></h2>
			
			<table class="table table-hover table-striped">
				<tr>
					<th>Team Member</th>
					<th>Current Tournament?</th> <!-- we don't have a current tourney attribute -->
				</tr>

				<!-- foreach loop if members are private then skip -->
				<c:forEach var="member" items="${teamMembers}">
					<td><c:out value="${member.userName}"/></td>
					<td></td>
					
				</c:forEach>
			</table>
		</div>

		<div id="registeredTournaments">

			<h2>Registered Tournaments</h2>

			<table class="table table-hover table-striped">
				<tr>
					<th>Name</th>
					<th>Game</th>
					<th>Type</th>
					<th>Location</th>
					<th>Date</th>
					<th>Organizer</th>
				</tr>

				<!-- ForEach -->
				
				<c:forEach var="tournament" items="${registeredTournaments}">
				<tr>
					<c:url var="tournamentURL" value="/tournament/detail">
					<c:param value="${tournament.id}" name="tournamentId"/>
					</c:url>
				
					<td><a href="${tournamentURL}"><c:out value="${tournament.name}"/></a></td>
					<td><c:out value="${tournament.game}"/></td> <%--Get actual game names --%>
					<td><c:out value="${tournament.type}"/></td>
					<td>${tournament.location}</td>
					<td>${tournament.date}</td>
					<c:url var="organizerPageURL" value="/organizers/?id=${tournament.organizerId}"/>
					<td><c:out value="${tournament.organizerId }"/></td>
					
				</tr>
				
				</c:forEach>
			</table>
		</div>
	</div>

</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />