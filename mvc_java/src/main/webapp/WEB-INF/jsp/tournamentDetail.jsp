<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />


<div>
	<div>
		<h1>${tournament.name }</h1>
		<h2>Hosted by: ${tournamentOrganizer.userName}</h2>
		<!-- link to organizer -->
	</div>
	<div id="allTournamentInfoBlock">
		<div id="tournamentInfoTextBlock" class="">
			<div class="tournamentDetails">
				<h2>Tournament Details</h2>

				<h4>Where</h4>
				<p>${tournament.location}</p>
				<h4>When</h4>
				<p>${tournament.date}</p>

				${tournament.taggedDesc}

				<!-- maybe some sort of embedded calendar... ? -->

			</div>
			<div class="tournamentParticipants">
				<h2>Participating Teams</h2>
				<c:if
					test="${participatingTeams.size() == 0 && currentUser.role.equals('3') && tournament.organizerId ==
					currentUser.userID}">
					<p>Invite Teams!</p>
				</c:if>
				<c:if test="${participatingTeams.size() == 0}">
					<p>No teams yet!</p>
				</c:if>
				<c:forEach var="team" items="${participatingTeams}">
					<c:url var="teamDetailURL" value="/teams/detail?id=${team.id}" />
					<p>
						<a href="${teamDetailURL}">${team.name}</a>
					<p>
				</c:forEach>
			</div>
		</div>
		<div id="tournamentTablesBlock">
			<div id="matchupInfoBlock">

				<h2>Matchups</h2>


				<div>
					<div class="button">
						<c:if test="${currentUser.role == 3}">

							<c:url var="pairMatchups" value="/matchPairing">

								<c:param name="tournamentId" value="${tournament.id}" />

							</c:url>
							<a href="${pairMatchups}"><button class="btn btn-success">Pair
									Matchups</button></a>
						</c:if>
					</div>
					<table id="tournamentMatchupTable"
						class="table table-hover table-striped">
						<tr>
							<th>Matchup</th>
							<th>Location</th>
							<th>Time</th>
							<th>Winner</th>
							<th>
							<th>
						</tr>
						<c:forEach var="matchup" items="${matchups}">
							<tr>
								<td><c:out value="${matchup.team1Name}" /> VS. <c:out
										value="${matchup.team2Name}" /></td>
								<td><c:out value="${matchup.location}" /></td>
								<td><c:out value="${matchup.date}" /> @<c:out
										value="${matchup.time}" /></td>
								<td><c:if test="${matchup.winnerId} != 0">
										<c:out value="${matchup.winnerName}" />
									</c:if></td>
								<td><c:if test="${currentUser.role == 3}">

										<c:url var="oneWins" value="/declareWinner">
											<c:param name="winner" value="${matchup.teamId1}" />
											<c:param name="matchupId" value="${matchup.matchUpId}" />
											<c:param name="tournamentId" value="${tournament.id}" />
										</c:url>
										<c:url var="twoWins" value="/declareWinner">
											<c:param name="winner" value="${matchup.teamId2}" />
											<c:param name="matchupId" value="${matchup.matchUpId}" />
											<c:param name="tournamentId" value="${tournament.id}" />
										</c:url>
										<a href="${oneWins}"><button class="btn btn-success">Team
												One Wins</button></a>
										<a href="${twoWins}"><button class="btn btn-success">Team
												Two Wins</button></a>
									</c:if>
							</tr>
						</c:forEach>
					</table>
				</div>

			</div>
		</div>
	</div>
	<div id="embeddedMap">
		<h2>Tournament Map</h2>
		<c:url var="apiKeyValue" value="${apiKey}" />
		<iframe width="600" height="450" frameborder="0" style="border: 0"
			src="https://www.google.com/maps/embed/v1/place?key=${apiKeyValue}
    		&q=${tournament.location}"
			allowfullscreen> </iframe>
	</div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />