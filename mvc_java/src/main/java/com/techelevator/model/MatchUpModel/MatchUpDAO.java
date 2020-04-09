package com.techelevator.model.MatchUpModel;

public interface MatchUpDAO {
	public boolean createMatchup(MatchUp newMatchUp);
	public MatchUp getMatchByMatchUpId(String MatchUpId);	
	public Integer getWinsByTeam(String teamId);
	public Integer getLossesByTeam(String teamId);
	public Integer getTournamentWinsByTeam(String teamId, String tournamentId);
	public Integer getTournamentLossesByTeam(String teamId, String tournamentId);
	boolean update(MatchUp matchUp);
	boolean delete(MatchUp matchUp);
}
