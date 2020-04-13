package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.DescriptionBuilder;
import com.techelevator.model.MatchUpModel.JDBCMatchUpDAO;
import com.techelevator.model.MatchUpModel.MatchUp;
import com.techelevator.model.TournamentModel.JDBCTournamentDAO;
import com.techelevator.model.TournamentModel.Tournament;
import com.techelevator.model.UserModel.User;

@Controller
public class TournamentController {
	
	@Autowired
	JDBCTournamentDAO tournamentDAO;
	@Autowired
	JDBCMatchUpDAO matchUpDAO;
	
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
	List <MatchUp> matchups = matchUpDAO.getMatchUpsByTournamentId(tournamentId);
	map.addAttribute("matchups", matchups);
		
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
	public String processRegisterNewTournament(@Valid @ModelAttribute Tournament tournament, BindingResult result, RedirectAttributes flash,
			HttpSession session) {
		if(result.hasErrors()) {
			flash.addFlashAttribute("newTournament", tournament);
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "newTournament", result);
			
			return "redirect:/organizerDashboard";
		}
	
		// Register a new tournament here. Should take in a tournament object to save to DB.
		
		Tournament newTournamentRegistration = tournament;
		
		newTournamentRegistration.setDescription(DescriptionBuilder.formatDesc(tournament.getFormat(),
				tournament.getRules(), tournament.getPrizes()));
		newTournamentRegistration.setTaggedDesc(DescriptionBuilder.formatTaggedDesc(tournament.getFormat(),
				tournament.getRules(), tournament.getPrizes()));
		
		
		tournamentDAO.create(newTournamentRegistration);
		
		
		return "redirect:/organizerDashboard";
	}
	
	// Redirect page. Informs user that registration was successful, this page should do other useful stuff.
	@RequestMapping(path="/newTournamentSuccess", method = RequestMethod.GET)
	public String displayNewTournamentSuccess() {
		
		// Maybe a link to manage tournament details. Dashboard sort of view? Allow edits and invitations to tournament.
		
		return "newTournamentSuccess";
	}
}
