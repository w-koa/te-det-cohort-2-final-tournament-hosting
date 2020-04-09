package com.techelevator.model.TeamModel;

import java.util.List;

import com.techelevator.model.UserModel.User;

public interface TeamDAO {

	// Create
	public void createTeam(Team team);
	
	// Read
	public List<Team> getAllTeams();
	public Team getTeamById(int id);
	public Team getTeamByName(String name);
	public List<User> getAllTeamCaptains();
	public User getCaptainByTeamId(int teamId);
	
	// Update
	public void updateTeam(Team team);
	
	// Destroy
	public void deleteTeam(int id);
	
}
