package com.techelevator.model.MatchUpModel;

public class MatchUp {

	private String matchUpId;
	private String tournamentId;
	private String gameId;
	private String teamId1;
	private String teamId2;
	private String location;
	private String date;
	private String time;
	private String winnerId;
	private String loserId;
	
	public String getMatchUpId() {
		return matchUpId;
	}
	public void setMatchUpId(String matchUpId) {
		this.matchUpId = matchUpId;
	}
	public String getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public String getTeamId1() {
		return teamId1;
	}
	public void setTeamId1(String teamId1) {
		this.teamId1 = teamId1;
	}
	public String getTeamId2() {
		return teamId2;
	}
	public void setTeamId2(String teamId2) {
		this.teamId2 = teamId2;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getWinnerId() {
		return winnerId;
	}
	public void setWinnerId(String winnerId) {
		this.winnerId = winnerId;
	}
	public String getLoserId() {
		return loserId;
	}
	public void setLoserId(String loserId) {
		this.loserId = loserId;
	}
	
	
}
