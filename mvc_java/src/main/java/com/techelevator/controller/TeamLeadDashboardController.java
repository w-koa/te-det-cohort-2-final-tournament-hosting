package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.MatchUpModel.JDBCMatchUpDAO;
import com.techelevator.model.TeamModel.JDBCTeamDAO;
import com.techelevator.model.TeamModel.Team;
import com.techelevator.model.TournamentModel.JDBCTournamentDAO;
import com.techelevator.model.TournamentModel.Tournament;
import com.techelevator.model.UserModel.User;

@CrossOrigin
@Controller
public class TeamLeadDashboardController {

	@Autowired
	JDBCTeamDAO teamDAO;

	@Autowired
	JDBCTournamentDAO tournamentDAO;

	@Autowired
	JDBCMatchUpDAO matchupDAO;

	@RequestMapping(path = "/teamLeaderDashboard", method = RequestMethod.GET)
	public String displayTeamLeadDashboard(ModelMap map, HttpSession session) {

		// Get user session data
		User currentUser = (User) session.getAttribute("currentUser");
		map.addAttribute("currentUser", currentUser);
		
		// Redirect to login if user data is null
		if (currentUser == null) {
			return "redirect:/login";
		}
		
		// Will get team info from captainId
		int userIdInt = Integer.parseInt(currentUser.getUserID());
		Team userTeam = teamDAO.getTeamByCaptainId(userIdInt);
		List<User> teamMembers = teamDAO.getMembersByTeamId(userTeam.getId());
		map.addAttribute("userTeam", userTeam);
		map.addAttribute("teamMembers", teamMembers);
		
		// Redirect to user registration if role is not team leader. 
		// Maybe make it into an alert message?
		if (!currentUser.getRole().equals("2")) {
			System.out.println("Oops, not a team captain!");
			return "redirect:/users/new";
		}
		
		// Get tournament information for modeling
		String teamIdString = Integer.toString(userTeam.getId());
		List<Tournament> allTournaments = tournamentDAO.getAllTournaments();
		List<Tournament> teamTournaments = tournamentDAO.getTournamentByTeamID(teamIdString);
		map.addAttribute("allTournaments", allTournaments);
		map.addAttribute("teamTournaments", teamTournaments);
		System.out.println(teamTournaments.size());

		return "teamLeaderDashboard";
	}

}
