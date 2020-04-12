package com.techelevator.model.MatchUpModel;

import java.util.List;

public interface MatchUpDAO {
	public boolean createMatchup(MatchUp newMatchUp);
	public MatchUp getMatchByMatchUpId(String MatchUpId);	
	public Integer getWinsByTeam(String teamId);
	public Integer getLossesByTeam(String teamId);
	public Integer getTournamentWinsByTeam(String teamId, String tournamentId);
	public Integer getTournamentLossesByTeam(String teamId, String tournamentId);
	boolean update(MatchUp matchUp);
	boolean delete(MatchUp matchUp);
	List<MatchUp> getMatchUpsByTournamentId(String tournamentId);
	List<Integer> getTeamsForTournament(String tournamentID);
}
