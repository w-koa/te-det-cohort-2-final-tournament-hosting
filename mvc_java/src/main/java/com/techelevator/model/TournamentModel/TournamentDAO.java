package com.techelevator.model.TournamentModel;

public interface TournamentDAO {
//CRUD
	public boolean create (Tournament newTournament);
	public Tournament getTournamentByID (String id);
	public Tournament getTournamentByOrganizer (String organizerId);
	public Tournament getTournamentByTeam (String teamId);
	public Tournament getTournamentByGameId(String gameId);
	public boolean update (Tournament tournament);
	public boolean delete (Tournament tournament);

}
