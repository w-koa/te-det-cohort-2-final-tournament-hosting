package com.techelevator.model.TournamentModel;

import java.util.List;

public interface TournamentDAO {
//CRUD
	public boolean create (Tournament newTournament);
	public Tournament getTournamentByID (String id);
	public List <Tournament> getAllTournaments();
	public List <Tournament> getTournamentByOrganizer (String organizerId);
	public List <Tournament> getTournamentByTeam (String teamId);
	public List <Tournament> getTournamentByGame (String game);
	public List <Tournament> topXTournamentsByPlayerCount (String limit);
	public boolean update (Tournament tournament);
	boolean delete(String id);

}
