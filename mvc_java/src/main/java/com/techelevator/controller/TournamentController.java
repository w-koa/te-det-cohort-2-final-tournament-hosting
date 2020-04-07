package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TournamentController {
	
	//@Autowired
	//JDBCTournamentDAO tournamentDAO
	
	
	// Display all tournaments
	@RequestMapping(path="/tournaments", method = RequestMethod.GET)
	public String displayTournaments(ModelMap map) {
		
		//List<Tournament> allTournaments = tournamentDAO.getAllTournaments();
		//map.addAttribute("allTournaments", allTournaments);
		
		return "tournaments";
	}
	
	// Display tournament detail page
	@RequestMapping(path="/tournaments/detail", method = RequestMethod.GET)
	public String displayTournamentDetail(@RequestParam int tournamentId, ModelMap map) {
		
		//Tournament tournament = tournamentDAO.getTournamentById();
		//map.addAttribute("tournament", tournament);
		
		return "tournamentDetail";
	}
	
	
	// Register new tournament
	@RequestMapping(path="/tournaments/newTournament", method = RequestMethod.GET)
	public String displayRegisterNewTournament(@RequestParam String role) {
		
		//if(role == "admin" || role == "organizer") {
		// let them register a new tournament }
		
		return "registerNewTournament";
	}

	// Post/Redirect
	@RequestMapping(path="/tournaments/newTournament", method = RequestMethod.POST)
	public String processRegisterNewTournament() {
		
		// Register a new tournament here. Should take in a tournament object to save to DB.
		
		// Tournament newTournamentRegistration = tournament;
		// tournamentDAO.registerNewTournament(newTournamentRegistration);
		
		
		return "redirect:/newTournamentSuccess";
	}
	
	// Redirect page. Informs user that registration was successful, this page should do other useful stuff.
	@RequestMapping(path="/newTournamentSuccess", method = RequestMethod.GET)
	public String displayNewTournamentSuccess() {
		
		// Maybe a link to manage tournament details. Dashboard sort of view? Allow edits and invitations to tournament.
		
		return "newTournamentSuccess";
	}
}
