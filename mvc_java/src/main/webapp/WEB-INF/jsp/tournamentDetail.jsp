<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div>
	<h1>Banner Image here?</h1>
</div>

<div>
	<h1>Smash Melee Championships 2020</h1>
	<h2>Hosted by: Smash Melee League</h2>
	<!-- link to organizer -->
</div>
<div id="allTournamentInfoBlock">
	<div id="tournamentInfoTextBlock" class="">
		<div class="tournamentDetails">
			<h2>Tournament Details</h2>

			<h4>Where</h4>
			<p>The Internets</p>
			<h4>When</h4>
			<p>The Day before tomorrow</p>
			<h4>Format</h4>
			<p>Single Elimination 1v1, 3 Stock, No items</p>

		</div>
		<div class="tournamentRules">
			<h2>Rules</h2>
			<!--  for each to display rules? -->
			<ul>
				<li>Don't talk about fight club</li>
				<li>Don't. Talk. About. Fight Club.</li>
				<li>No smoking</li>
				<li>You have to shower and wear deodorant</li>
			</ul>
		</div>
		<div class="tournamentPrizes">
			<h2>Prizes</h2>

			<ol>
				<li>Bragging rights, maybe some money</li>
				<li>You didn't get third</li>
				<li>You placed, so that's something</li>
				<li>Fourth place huh...</li>
			</ol>
		</div>
		<div class="tournamentSchedule">
			<h2>Schedule</h2>
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
				<table id="tournamentMatchupTable"
					class="table table-hover table-striped">
					<tr>
						<th>Matchup</th>
						<th>Winner</th>
					</tr>
					<tr>
						<td>L33tTeam vs. NewbPwners</td>
						<td>L33tTeam</td>
					</tr>
					<tr>
						<td>Cats vs. Doges</td>
						<td>Doges</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />