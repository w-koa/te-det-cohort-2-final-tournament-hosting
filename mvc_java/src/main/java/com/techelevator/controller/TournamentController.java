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
import com.techelevator.model.TeamModel.JDBCTeamDAO;
import com.techelevator.model.TeamModel.Team;
import com.techelevator.model.TournamentModel.JDBCTournamentDAO;
import com.techelevator.model.TournamentModel.Tournament;
import com.techelevator.model.UserModel.User;

@Controller
public class TournamentController {
	
	@Autowired
	JDBCTournamentDAO tournamentDAO;
	@Autowired
	JDBCMatchUpDAO matchUpDAO;
	@Autowired
	JDBCTeamDAO teamDAO;
	
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
//	@RequestMapping(path="/tournaments/newTournament", method = RequestMethod.POST)
//	public String processRegisterNewTournament(@RequestParam String ) {
//		
//		// Register a new tournament here. Should take in a tournament object to save to DB.
//		
//		// Tournament newTournamentRegistration = tournament;
//		// tournamentDAO.registerNewTournament(newTournamentRegistration);
//		
//		
//		return "redirect:/newTournamentSuccess";
//	}
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
	
	@RequestMapping(path="/tournaments/join", method = RequestMethod.GET)
	public String displayJoinTournament(ModelMap map, HttpSession session) {
		
		User currentUser = (User) session.getAttribute("currentUser");
		if (currentUser == null) {
			return "redirect:/login";
		}
		if (!currentUser.getRole().equals("2")) {
			System.out.println("Oops, not a team captain!");
			return "redirect:/newUser";
		}
		Team userTeam = teamDAO.getTeamByCaptainId(Integer.parseInt(currentUser.getUserID()));
		map.addAttribute("userTeam", userTeam);
		List<Tournament> allTournaments = tournamentDAO.getAllTournaments();
		map.addAttribute("allTournaments", allTournaments);
		
		return "joinTournament";
	}
	
	@RequestMapping(path="/tournaments/join", method = RequestMethod.POST)
	public String processJoinTournament(HttpSession session, @RequestParam String tournamentId, @RequestParam String teamId) {
		
		tournamentDAO.joinTournament(tournamentId, teamId);
		
		return "redirect:/tournaments/join/success";
	}
	
	@RequestMapping(path="/tournaments/join/success", method = RequestMethod.GET)
	public String displayJoinTournamentSuccess(HttpSession session) {
		
		return "joinTournamentSuccess";
	}
}
