package com.techelevator.model.TeamModel;

import java.util.List;

public interface TeamDAO {

	// Create
	public void createTeam(Team team);
	
	// Read
	public List<Team> getAllTeams();
	public Team getTeamById(int id);
	public Team getTeamByName(String name);
	
	// Update
	public void updateTeam(Team team);
	
	// Destroy
	public void deleteTeam(int id);
	
}
