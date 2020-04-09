package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeamController {

	// @Autowired
	// JDBCTeamDAO teamDAO;

	// Displays all teams
	@RequestMapping(path = "/teams", method = RequestMethod.GET)
	public String displayTeams(ModelMap map) {

		// List<Team> allTeams = teamDAO.getAllTeams();
		// map.addAttribute("allTeams", allTeams);

		return "teams";
	}
	
	// Displays team detail page
	@RequestMapping(path="/teams/detail", method = RequestMethod.GET)
	public String displayTeamDetail(@RequestParam int id, ModelMap map) {
		
		// Team team = teamDAO.getTeamById(id);
		// map.addAttribute("team", team);
		
		return "teamDetail";
	}
	
	@RequestMapping(path="/teams/dummyDetail", method = RequestMethod.GET)
	public String displayTeamDummyPage() {
		
		return "teamDetail";
	}
	
	
}

