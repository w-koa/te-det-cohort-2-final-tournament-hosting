package com.techelevator.controller;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
@Controller
public class TournamentController {

	@Autowired
	JDBCTournamentDAO tournamentDAO;
	@Autowired
	JDBCMatchUpDAO matchUpDAO;
	@Autowired
	JDBCTeamDAO teamDAO;

	// Display all tournaments
	@RequestMapping(path = "/tournaments", method = RequestMethod.GET)
	public String displayTournaments(ModelMap map) {

		List<Tournament> allTournaments = tournamentDAO.getAllTournaments();
		map.addAttribute("tournaments", allTournaments);

		return "tournaments";
	}
	
	@RequestMapping(path = "/tournaments/search", method = RequestMethod.GET)
	public String displayMatchingTournaments(ModelMap map, @RequestParam String search) {
		List<Tournament> matchingTournaments = tournamentDAO.searchTournaments(search);
		map.addAttribute("matchingTournaments", matchingTournaments);
		
		return "tournaments";
	}

	// Display tournament detail page
	@RequestMapping(path = "/tournament/detail", method = RequestMethod.GET)
	public String displayTournamentDetail(@RequestParam String tournamentId, ModelMap map) {
		// Google Map Embed API key
		String apiKey = "AIzaSyBvxfdPSYjCtOO_vyW3KGAIF2SzpKNgnGA";
		map.addAttribute("apiKey", apiKey);
		
		Tournament tournament = tournamentDAO.getTournamentByID(tournamentId);
		map.addAttribute("tournament", tournament);
		User organizer = tournamentDAO.getOrganizerByTournamentId(tournamentId);
		map.addAttribute("tournamentOrganizer", organizer);
		List<Team> participatingTeams = teamDAO.getParticipatingTeamsByTournamentId(tournamentId);
		map.addAttribute("participatingTeams", participatingTeams);
		List<MatchUp> matchups = matchUpDAO.getMatchUpsByTournamentId(tournamentId);
		map.addAttribute("matchups", matchups);

		return "tournamentDetail";
	}

	// Register new tournament
	@RequestMapping(path = "/tournaments/newTournament", method = RequestMethod.GET)
	public String displayRegisterNewTournament(@RequestParam String role) {

		if (Integer.parseInt(role) >= 3) {
			return "createTournament";
		}

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
	@RequestMapping(path = "/tournaments/newTournament", method = RequestMethod.POST)
	public String processRegisterNewTournament(@Valid @ModelAttribute Tournament tournament, BindingResult result,
			RedirectAttributes flash, HttpSession session) {
		System.out.println(tournament.toString());
		if (result.hasErrors()) {
			flash.addFlashAttribute("newTournament", tournament);
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "newTournament", result);

			return "redirect:/organizerDashboard";
		}

		// Register a new tournament here. Should take in a tournament object to save to
		// DB.

		Tournament newTournamentRegistration = tournament;

		newTournamentRegistration.setDescription(
				DescriptionBuilder.formatDesc(tournament.getFormat(), tournament.getRules(), tournament.getPrizes()));
		newTournamentRegistration.setTaggedDesc(DescriptionBuilder.formatTaggedDesc(tournament.getFormat(),
				tournament.getRules(), tournament.getPrizes()));
		System.out.println(newTournamentRegistration.toString());

		tournamentDAO.create(newTournamentRegistration);

		return "redirect:/newTournamentSuccess";
	}

	// Redirect page. Informs user that registration was successful, this page
	// should do other useful stuff.
	@RequestMapping(path = "/newTournamentSuccess", method = RequestMethod.GET)
	public String displayNewTournamentSuccess() {

		// Maybe a link to manage tournament details. Dashboard sort of view? Allow
		// edits and invitations to tournament.

		return "newTournamentSuccess";
	}

	@RequestMapping(path = "/tournaments/join", method = RequestMethod.GET)
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
		map.addAttribute("user", userTeam);
		List<Tournament> allTournaments = tournamentDAO.getAllTournaments();
		map.addAttribute("allTournaments", allTournaments);

		return "joinTournament";
	}

	// As team, join tournament
	@RequestMapping(path = "/tournaments/join", method = RequestMethod.POST)
	public String processJoinTournament(HttpSession session, @RequestParam String tournamentId,
			@RequestParam String teamId) {

		tournamentDAO.joinTournament(tournamentId, teamId);

		return "redirect:/tournaments/join/success";
	}

	@RequestMapping(path = "/tournaments/join/success", method = RequestMethod.GET)
	public String displayJoinTournamentSuccess(HttpSession session) {

		return "joinTournamentSuccess";
	}
	
	// As organizer, add team to tournament
	@RequestMapping(path = "/tournaments/addTeam", method = RequestMethod.POST)
	public String processAddTeamToOrganizerTournament(@RequestParam String tournamentId, 
			@RequestParam String teamId) {
		
		tournamentDAO.joinTournament(tournamentId, teamId);
		
		return "redirect:/organizerDashboard";
	}
	
	@RequestMapping (path="/matchPairing", method= RequestMethod.GET)
	public String pairMatchups (HttpSession session, @RequestParam (name = "tournamentId") String tournamentId) {
		//pull a list of all participants
		List <Team> tourneyParticipants = teamDAO.getParticipatingTeamsByTournamentId(tournamentId);
		List <Team> eliminatedTeams = teamDAO.eliminatedTeamsByTourneyId(tournamentId);
		// remove eliminated teams
		if (tourneyParticipants.size() > 0) {
		if (eliminatedTeams.size() > 0 ) {
		for (Team eliminated : eliminatedTeams) {
			for (int x = tourneyParticipants.size()-1 ; x >= 0 ; x--) {
				if (eliminated.equals(tourneyParticipants.get(x))) {
					tourneyParticipants.remove(x);
			}
			}
			}
			}
		for (int x = tourneyParticipants.size()-1 ; x >= 1 ; x= x-2) {
			MatchUp pairing = new MatchUp ();
			pairing.setTournamentId(tournamentId);
			pairing.setGameId("1");
			if (x == 0) {
				pairing.setTeamId1(tourneyParticipants.get(0).getId() + "");
				pairing.setTeamId2("0");
			}
			
			pairing.setTeamId1(tourneyParticipants.get(x).getId() + "");
			pairing.setTeamId2(tourneyParticipants.get(x-1).getId() + "");
			pairing.setLocation("Pod "+ x);
			pairing.setDate("1066-02-02");
			pairing.setTime("8:00pm");
			pairing.setWinnerId("0");
			pairing.setLoserId("0");
			tourneyParticipants.remove(x);
			tourneyParticipants.remove(x-1);
			
			System.out.println(pairing.toString());
			matchUpDAO.createMatchup(pairing);
		
		}
		}
			
		
		
		return "redirect:/tournament/detail?tournamentId=" + tournamentId;
	}
	
	@RequestMapping (path="/declareWinner", method= RequestMethod.GET)
	public String declareWinner (@RequestParam (name = "tournamentId") String tournamentId,
				@RequestParam String winner, @RequestParam String matchupId) {
			//pull a list of all participants
			MatchUp matchup = matchUpDAO.getMatchByMatchUpId(matchupId);
			boolean teamOneWon = matchup.getTeamId1().contentEquals(winner);
			matchUpDAO.updateWinner(matchup, teamOneWon);
		
			
			return "redirect:/tournament/detail?tournamentId=" + tournamentId;
		}
	}
