<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div>
	<h1>Team Banner Image here?</h1>
</div>

<div>
	<h1>The Red Team</h1>
	<h2>Leader: Red</h2>
	<!-- Leader can appoint new leader if more than one member of Team -->
	<label for="temp">Website: </label>
	<a href="#" id="temp">Red Team Official</a>
</div>
<div id="teamSearchBar" class="col-md-8">
	<input class="form-control" type="text" name="searchBar" placeholder="Search for team members or registered tournaments"/>
	<button type="submit" class="btn btn-primary">Search</button>
</div>
<div id="allTeamInfoBlock">
	<div id="teamInfoTextBlock" class="">
		<div id="teamMembers" class="teamMembers">
			<h2>Team Members ($ofMembers)</h2>
			
			<table class="table table-hover table-striped">
				<tr>
					<th>Team Member</th>
					<th>Current Tournament?</th>
					<th>Wins</th>
					<th>Losses</th>
				</tr>

				<!-- foreach loop if members are private then skip -->
				<tr>
					<td>Crimson</td>
					<td>Ultimate PingPong League Singles</td>
					<td>10</td>
					<td>2</td>
				</tr>
				<tr>
					<td>Red</td>
					<c:url var="tournamentURL" value="/tournaments/detail?=id" />
					<td>Ultimate PingPong League Singles</td>
					<td>2</td>
					<td>10</td>
				</tr>
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
					<th>Start Date</th>
					<th>Organizer</th>
					<th>Status</th>
				</tr>

				<!-- ForEach -->
				<tr>

					<c:url var="tournamentDetail" value="/tournaments/detail?=id" />
					<!-- Sample to use -->
					<td>Smash Melee Championship 2020</td>
					<!--  make this into a clickable thing -->
					<c:url var="gameDetail" value="/games/detail?=id" />
					<td>Super Smash Bros. Melee</td>
					<td>Single</td>
					<td>The Internets</td>
					<c:url var="organizerDetail" value="/organizers/detail?=id" />
					<td>10/10/2020</td>
					<td>Smash Melee Union</td>
					<td>Completed</td>
				</tr>
				<tr>
					<c:url var="tournamentDetail" value="/tournaments/detail?=id" />
					<!-- Sample to use -->
					<td>Smash Melee Championship 2019</td>
					<!--  make this into a clickable thing -->
					<c:url var="gameDetail" value="/games/detail?=id" />
					<td>Super Smash Bros. Melee</td>
					<td>Single</td>
					<td>The Internets</td>
					<c:url var="organizerDetail" value="/organizers/detail?=id" />
					<td>10/10/2019</td>
					<td>Smash Melee Union</td>
					<td>Completed</td>
				</tr>
			</table>
		</div>
	</div>

</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />