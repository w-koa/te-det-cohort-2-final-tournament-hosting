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
	public Team getTeamByCaptainId(int captainId);
	public User getCaptainByTeamId(int teamId);
	List<Team> getParticipatingTeamsByTournamentId(String tournamentId);
	public List<User> getMembersByTeamId(int teamId);
	public String idToName (String teamId);
	public void updateTeam(Team team);
	void deleteTeam(Team team);

	
}
