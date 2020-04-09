package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.TournamentModel.JDBCTournamentDAO;
import com.techelevator.model.TournamentModel.Tournament;

@Controller
public class TournamentController {
	
	@Autowired
	JDBCTournamentDAO tournamentDAO;
	
	
	// Display all tournaments
	@RequestMapping(path="/tournaments", method = RequestMethod.GET)
	public String displayTournaments(ModelMap map) {
		
		List<Tournament> allTournaments = tournamentDAO.getAllTournaments();
		map.addAttribute("tournaments", allTournaments);
		
		return "tournaments";
	}
	
		
	// Display tournament detail page
	@RequestMapping(path="/tournament/detail", method = RequestMethod.GET)
	public String displayTournamentDetail(@RequestParam String tournamentId, ModelMap map) {
		
	Tournament tournament = tournamentDAO.getTournamentByID(tournamentId);
	map.addAttribute("tournament", tournament);
		
		return "tournamentDetail";
	}
	
	
	// Register new tournament
	@RequestMapping(path="/tournaments/newTournament", method = RequestMethod.GET)
	public String displayRegisterNewTournament(@RequestParam String role) {
		
		if(Integer.parseInt(role) >= 3) {
		 return "createTournament"; }
		
		return "/";
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
