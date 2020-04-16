package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.TeamModel.JDBCTeamDAO;
import com.techelevator.model.TeamModel.Team;
import com.techelevator.model.TournamentModel.JDBCTournamentDAO;
import com.techelevator.model.TournamentModel.Tournament;
import com.techelevator.model.UserModel.User;

@CrossOrigin
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
	
	@RequestMapping(path = "/teams/search", method = RequestMethod.GET)
	public String displayMatchingTeams(ModelMap map, @RequestParam String search) {
		List<Team> matchingTeams = teamDAO.searchTeams(search);
		map.addAttribute("matchingTeams", matchingTeams);
		
		return "teams";
	}
	
	// Displays team detail page
	@RequestMapping(path="/teams/detail", method = RequestMethod.GET)
	public String displayTeamDetail(@RequestParam int id, ModelMap map) {
		
		String idString = Integer.toString(id);
		Team team = teamDAO.getTeamById(id);
		User teamLeader = teamDAO.getCaptainByTeamId(id);
		List<User> teamMembers = teamDAO.getMembersByTeamId(id);
		List<Tournament> registeredTournaments = tournamentDAO.getTournamentByTeamID(idString);
		map.addAttribute("team", team);
		map.addAttribute("teamLeader", teamLeader);
		map.addAttribute("teamMembers", teamMembers);
		map.addAttribute("registeredTournaments", registeredTournaments);
		return "teamDetail";
	}
	
	
	@RequestMapping(path="/createTeam", method = RequestMethod.GET)
	public String displayCreateTeam(HttpSession session) {
		
		User currentUser = (User) session.getAttribute("currentUser");
		
		if (currentUser == null) {
			return "redirect:/login";
		} 
		if (!currentUser.getRole().equals("2")) {
			System.out.println("Oops, not a team captain!");
			return "redirect:/newUser";
		}
		
		Team userTeam = teamDAO.getTeamByCaptainId(Integer.parseInt(currentUser.getUserID()));
		if (userTeam.getName() != null) {
			System.out.println("Already managing a team!");
			return "redirect:/teamLeaderDashboard";
		}
		
		return "createTeam";
	}
	
	@RequestMapping(path="/createTeam", method = RequestMethod.POST)
	public String processCreateTeam(HttpSession session, @RequestParam String teamName, @RequestParam int captainId) {
		
		User currentUser = (User) session.getAttribute("currentUser");
		Team newTeam = new Team();
		// team Id should be automatically generated
		newTeam.setName(teamName);
		newTeam.setCaptainId(captainId);
		
		teamDAO.createTeam(newTeam);
		Team createdTeam = teamDAO.getTeamByCaptainId(captainId);
		teamDAO.addTeamMember(Integer.toString(captainId), Integer.toString(createdTeam.getId()));
		
		return "redirect:/createTeam/success";
	}
	
	@RequestMapping(path="/createTeam/success", method = RequestMethod.GET)
	public String displayCreateTeamSuccess() {
		
		return "createTeamSuccess";
	}
	
	@RequestMapping(path="/addTeamMember", method = RequestMethod.POST)
	public String processAddTeamMember(HttpSession session, @RequestParam String playerId, @RequestParam String teamId) {

		teamDAO.addTeamMember(playerId, teamId);
		return "redirect:/teamLeaderDashboard";
	}
	
	@RequestMapping(path="/teams/dummyDetail", method = RequestMethod.GET)
	public String displayTeamDummyPage() {
		
		return "teamDetailDummy";
	}
	
	
}

