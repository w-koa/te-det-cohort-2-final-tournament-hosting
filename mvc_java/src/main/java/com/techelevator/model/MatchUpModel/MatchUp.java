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
	private String team1Name;
	private String team2Name;
	private String winnerName;
	
	
	
	public MatchUp(String tournamentId, String gameId, String teamId1, String teamId2,
			String location, String date, String time, String winnerId, String loserId) {
		this.tournamentId = tournamentId;
		this.gameId = gameId;
		this.teamId1 = teamId1;
		this.teamId2 = teamId2;
		this.location = location;
		this.date = date;
		this.time = time;
		this.winnerId = winnerId;
		this.loserId = loserId;
	}
	
	public MatchUp() {
	}
	
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
	public String getTeam1Name() {
		return team1Name;
	}

	public void setTeam1Name(String team1Name) {
		this.team1Name = team1Name;
	}

	public String getTeam2Name() {
		return team2Name;
	}

	public void setTeam2Name(String team2Name) {
		this.team2Name = team2Name;
	}

	public String getWinnerName() {
		return winnerName;
	}

	public void setWinnerName(String winnerName) {
		this.winnerName = winnerName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((gameId == null) ? 0 : gameId.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((loserId == null) ? 0 : loserId.hashCode());
		result = prime * result + ((matchUpId == null) ? 0 : matchUpId.hashCode());
		result = prime * result + ((teamId1 == null) ? 0 : teamId1.hashCode());
		result = prime * result + ((teamId2 == null) ? 0 : teamId2.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((tournamentId == null) ? 0 : tournamentId.hashCode());
		result = prime * result + ((winnerId == null) ? 0 : winnerId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatchUp other = (MatchUp) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (gameId == null) {
			if (other.gameId != null)
				return false;
		} else if (!gameId.equals(other.gameId))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (loserId == null) {
			if (other.loserId != null)
				return false;
		} else if (!loserId.equals(other.loserId))
			return false;
		if (matchUpId == null) {
			if (other.matchUpId != null)
				return false;
		} else if (!matchUpId.equals(other.matchUpId))
			return false;
		if (teamId1 == null) {
			if (other.teamId1 != null)
				return false;
		} else if (!teamId1.equals(other.teamId1))
			return false;
		if (teamId2 == null) {
			if (other.teamId2 != null)
				return false;
		} else if (!teamId2.equals(other.teamId2))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (tournamentId == null) {
			if (other.tournamentId != null)
				return false;
		} else if (!tournamentId.equals(other.tournamentId))
			return false;
		if (winnerId == null) {
			if (other.winnerId != null)
				return false;
		} else if (!winnerId.equals(other.winnerId))
			return false;
		return true;
	}
	
	
}
