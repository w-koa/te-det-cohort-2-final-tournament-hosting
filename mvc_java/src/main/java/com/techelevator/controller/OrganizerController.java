package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.TeamModel.JDBCTeamDAO;
import com.techelevator.model.TeamModel.Team;
import com.techelevator.model.TournamentModel.JDBCTournamentDAO;
import com.techelevator.model.TournamentModel.Tournament;
import com.techelevator.model.UserModel.User;

@Controller
public class OrganizerController {
	
	@Autowired
	private JDBCTournamentDAO tournamentDAO;
	@Autowired
	private JDBCTeamDAO teamDAO;

	@RequestMapping(path="/organizerDashboard", method = RequestMethod.GET)
	public String displayOrganizerDashboard(ModelMap map, ModelMap modelHolder, HttpSession session) {
		
		// Gets user session data.
		User currentUser = (User) session.getAttribute("currentUser");
		map.addAttribute("currentUser", currentUser);
		
		// loads tournament modelattribute
		if( ! modelHolder.containsAttribute("newTournament")) {
			modelHolder.addAttribute("newTournament", new Tournament());
		}
		
		// Redirect to login if user data is null
		if (currentUser == null) {
			return "redirect:/login";
		}
		// Redirect to user registration if role is not organizer.
		if (!currentUser.getRole().equals("3")) {
			System.out.println("Oops, not an organizer!");
			return "redirect:/users/new";
		}
		
		List<Tournament> organizerTournaments = tournamentDAO.getTournamentByOrganizer(currentUser.getUserID());
		map.addAttribute("organizerTournaments", organizerTournaments);
		
		List<Team> allTeams = teamDAO.getAllTeams();
		map.addAttribute("allTeams", allTeams);
		return "organizerDashboard";
	}
}
