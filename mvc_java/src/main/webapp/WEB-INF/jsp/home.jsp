<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

	<h1 class="text-center">Welcome to Tournament Time!</h1>
	<h2 class="">Tourney Time is THE place for online tournament hosting. PEEP you favorite teams as they dominate the competition and move up the leader boards! Laugh as the losers "mallow" in defeat!</h2>

	<c:url var="logoImageURL" value="img/logobunnyjoust.png"/>
	<img class="img-responsive center-block" src="${logoImageURL}" alt="bunnies">

<c:import url="/WEB-INF/jsp/footer.jsp" />