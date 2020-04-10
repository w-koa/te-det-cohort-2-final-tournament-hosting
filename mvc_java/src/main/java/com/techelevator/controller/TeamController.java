package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.TeamModel.JDBCTeamDAO;
import com.techelevator.model.TeamModel.Team;
import com.techelevator.model.TournamentModel.JDBCTournamentDAO;
import com.techelevator.model.TournamentModel.Tournament;
import com.techelevator.model.UserModel.User;

@Controller
public class TeamController {

	 @Autowired
	 JDBCTeamDAO teamDAO;
	 @Autowired
	 JDBCTournamentDAO tournamentDAO;

	// Displays all teams
	@RequestMapping(path = "/teams", method = RequestMethod.GET)
	public String displayTeams(ModelMap map) {

		 List<Team> allTeams = teamDAO.getAllTeams();
		 map.addAttribute("allTeams", allTeams);

		return "teams";
	}
	
	// Displays team detail page
	@RequestMapping(path="/teams/detail", method = RequestMethod.GET)
	public String displayTeamDetail(@RequestParam int id, ModelMap map) {
		
		String idString = Integer.toString(id);
		Team team = teamDAO.getTeamById(id);
		User teamLeader = teamDAO.getCaptainByTeamId(id);
		List<User> teamMembers = teamDAO.getMembersByTeamId(id);
		List<Tournament> registeredTournaments = tournamentDAO.getTournamentByTeam(idString);
		map.addAttribute("team", team);
		map.addAttribute("teamLeader", teamLeader);
		map.addAttribute("teamMembers", teamLeader);
		map.addAttribute("registeredTournaments", registeredTournaments);
		return "teamDetail";
	}
	
	@RequestMapping(path="/teams/dummyDetail", method = RequestMethod.GET)
	public String displayTeamDummyPage() {
		
		return "teamDetailDummy";
	}
	
	
}

