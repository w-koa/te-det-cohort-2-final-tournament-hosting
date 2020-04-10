package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.TournamentModel.JDBCTournamentDAO;

@Controller
public class OrganizerController {
	
	@Autowired
	private JDBCTournamentDAO tournamentDAO;

	@RequestMapping(path="/organizerDashboard", method = RequestMethod.GET)
	public String displayOrganizerDashboard() {
		
//		List<Tournament> organizerTournaments = tournamentDAO.getTournamentByOrganizer(numberHere)
		
		return "organizerDashboard";
	}
}
