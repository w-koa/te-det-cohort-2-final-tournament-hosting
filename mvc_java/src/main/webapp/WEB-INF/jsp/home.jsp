<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h1 class="text-center">Welcome to Tourney Time!</h1>
<p class="">
	Tourney Time is THE place for online tournament hosting. PEEP your
	favorite teams as they dominate the competition and move up the leader
	boards! Laugh as the losers "mallow" in defeat!</>

	<c:url var="logoImageURL" value="img/logobunnyjoust.png" />
	<img class="img-responsive center-block" src="${logoImageURL}"
		alt="bunnies" id="bunnyLargeImg">
<div id="homepageSection">
	<div>
		<div>
			<h4>Browse Teams and Tournaments</h4>
		</div>
		<p>Anyone can look at the teams and tournaments being hosted on Tourney Time!</p>
		
	</div>
	<div>
		<div>
			<h4>Compete</h4>
		</div>
		<p>Are you a team leader? Organize your team and compete in tournaments!</p>
		<p>Get started by signing up as a Team Captain!</p>
		<c:url var="registerURL" value="/users/new"/>
		<a href="${registerURL}"><button class="btn btn-success">Sign Up!</button></a>
	
	</div>
	<div>
		<div>
			<h4>Tournament Hosting</h4>
		</div>
		<p>Organize and host your tournaments at Tourney Time!</p>
		<p>Get started by signing up as an Organizer!</p>
		<a href="${registerURL}"><button class="btn btn-success">Sign Up!</button></a>
	</div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />