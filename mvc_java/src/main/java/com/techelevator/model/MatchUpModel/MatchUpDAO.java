package com.techelevator.model.MatchUpModel;

import java.util.List;

public interface MatchUpDAO {
	public boolean createMatchup(MatchUp newMatchUp);
	public MatchUp getMatchByMatchUpId(String MatchUpId);	
	public Integer getWinsByTeam(String teamId);
	public Integer getLossesByTeam(String teamId);
	public Integer getTournamentWinsByTeam(String teamId, String tournamentId);
	public Integer getTournamentLossesByTeam(String teamId, String tournamentId);
	boolean delete(MatchUp matchUp);
	public List<MatchUp> getMatchUpsByTournamentId(String tournamentId);
	public List<MatchUp> getMatchUpsByTeamId(String teamId);
	public List<Integer> getTeamsForTournament(String tournamentID);
	boolean updateWinner(MatchUp matchUp, boolean isTeamOneWinning);
}
