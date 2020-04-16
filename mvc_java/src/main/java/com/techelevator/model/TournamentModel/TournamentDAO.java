package com.techelevator.model.TournamentModel;

import java.util.List;

public interface TournamentDAO {
//CRUD
	public boolean create (Tournament newTournament);
	public Tournament getTournamentByID (String id);
	public List <Tournament> getAllTournaments();
	public List <Tournament> getTournamentByOrganizer (String organizerId);
	public List <Tournament> getTournamentByTeamID (String teamId);
	public List <Tournament> getTournamentByGame (String game);
	public void joinTournament(String tournamentId, String teamId);
	boolean delete(String id);

}
