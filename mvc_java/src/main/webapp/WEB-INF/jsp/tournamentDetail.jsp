<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />


<div>
	<h1>${tournament.name }</h1>
	<h2>Hosted by: ${tournament.organizerName}</h2>
	<!-- link to organizer -->
</div>
<div id="allTournamentInfoBlock">
	<div id="tournamentInfoTextBlock" class="">
		<div class="tournamentDetails">
	<h2>Tournament Details</h2>
	 
	 <h4>Where</h4> <p>${tournament.location}</p> 
	  <h4>When</h4> <p>${tournament.date}</p> 
		
		${tournament.taggedDesc}
	
			<!-- maybe some sort of embedded calendar... ? -->

		</div>
		<div class="tournamentParticipants">
			<h2>Participants</h2>
			<p>list goes here</p>
		</div>
	</div>
	<div id="tournamentTablesBlock">
		<div id="rankingsBlock">
			<h2>Rankings</h2>
			<div>
				<table id="tournamentRankings"
					class="table table-hover table-striped">
					<tr>
						<th>Rank</th>
						<th>Team</th>
						<th>Wins</th>
						<th>Losses</th>
						<th>Ties</th>
					</tr>

					<!-- There will be a for each loop here -->
					<tr>
						<td>1</td>
						<td>TotallyLegit Team</td>
						<td>9999</td>
						<td>0</td>
						<td>0</td>
					</tr>
					<tr>
						<td>2</td>
						<td>NumberToo</td>
						<td>12</td>
						<td>2</td>
						<td>1</td>
					</tr>
				</table>
			</div>
		</div>
		<div id="matchupInfoBlock">

			<h2>Matchups</h2>

			<div>
			<div class= "button"> 
			<c:if test="${currentUser.role == 3}">
			
				<c:url var="pairMatchups" value="/matchPairing" >
				<c:param name="tournamentId" value ="${tournament.id}"/>
 				</c:url>
				<a href="${pairMatchups}"><button class="btn btn-primary">Pair Matchups</button></a>
			</c:if>
			</div>
				<table id="tournamentMatchupTable"
					class="table table-hover table-striped">
					<tr>
						<th>Matchup</th>
						<th>Location</th>
						<th>Time</th>
						<th>Winner</th>
					</tr>
					<c:forEach var="matchup" items="${matchups}"> 
					<tr>
						<td><c:out value = "${matchup.team1Name}"/> VS. <c:out value = "${matchup.team2Name}"/></td>
						<td><c:out value = "${matchup.location}"/></td>
						<td><c:out value = "${matchup.date}"/> @<c:out value = "${matchup.time}"/></td>
						<td>
						<c:if test="${matchup.winnerId} != 0">
						<c:out value= "${matchup.winnerName}"/>
						</c:if></td>
							
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />