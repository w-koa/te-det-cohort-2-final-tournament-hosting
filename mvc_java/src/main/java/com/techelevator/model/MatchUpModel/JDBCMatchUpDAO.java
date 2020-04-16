package com.techelevator.model.MatchUpModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.TeamModel.JDBCTeamDAO;
import com.techelevator.model.TeamModel.Team;

@Component
public class JDBCMatchUpDAO implements MatchUpDAO {

	private JdbcTemplate jdbcTemplate;
	private JDBCTeamDAO teamDao;

	@Autowired
	public JDBCMatchUpDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		teamDao = new JDBCTeamDAO(dataSource);
	}

	public MatchUp mapMatchUp(SqlRowSet row) {
		MatchUp match = new MatchUp();
		match.setMatchUpId(row.getString("match_up_id"));
		match.setTournamentId(row.getString("tournament_id"));
		match.setGameId(row.getString("game_id"));
		match.setTeamId1(row.getString("team_id_1"));
		match.setTeamId2(row.getString("team_id_2"));
		match.setLocation(row.getString("location"));
		match.setDate(row.getString("date"));
		match.setTime(row.getString("time"));
		match.setWinnerId(row.getString("winner_id"));
		match.setLoserId(row.getString("loser_id"));
		Team teamOne = teamDao.getTeamById(row.getInt("team_id_1"));
		match.setTeam1Name(teamOne.getName());
		if (match.getTeamId2().equals("0")) {
			match.setTeam2Name("BYE");
		} else {
		Team teamTwo = teamDao.getTeamById(row.getInt("team_id_2"));
		match.setTeam2Name(teamTwo.getName());
		Team winner = match.getWinnerId().equals(String.valueOf(teamOne.getId())) ? teamOne : teamTwo;
		match.setWinnerName(winner.getName());
		}
		return match;
	}

	@Override
	public boolean createMatchup(MatchUp newMatchUp) {
		String sql = "INSERT INTO match_up (tournament_id, "
				+ "game_id, team_id_1, team_id_2, location, date, time, winner_id, loser_id) "
				+ "VALUES (?,?,?,?,?,?,?,?,?);";
		String winnerId = "0";
		String loserId = "0";
		if (newMatchUp.getWinnerId() != null) {
			winnerId = newMatchUp.getWinnerId();
		}
		if (newMatchUp.getLoserId() != null) {
			loserId = newMatchUp.getLoserId();
		}
		
		jdbcTemplate.update(sql, Integer.parseInt(newMatchUp.getTournamentId()), Integer.parseInt(newMatchUp.getGameId()),
				Integer.parseInt(newMatchUp.getTeamId1()), Integer.parseInt(newMatchUp.getTeamId2()), newMatchUp.getLocation(), LocalDate.parse(newMatchUp.getDate()),
				newMatchUp.getTime(), Integer.parseInt(winnerId), Integer.parseInt(loserId));
		return true;
	}

	@Override
	public MatchUp getMatchByMatchUpId(String MatchUpId) {
		MatchUp match = null;
		String sql = "Select * From match_up where match_up_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, Integer.parseInt(MatchUpId));
		while (results.next()) {
			match = mapMatchUp(results);
		}
		return match;
	}

	@Override
	public Integer getWinsByTeam(String teamId) {
		String sql = "SELECT COUNT(winner_id) FROM match_up WHERE winner_id = ?";
		Integer wins = jdbcTemplate.queryForObject(sql, Integer.class, Integer.parseInt(teamId));
		return wins;
	}

	@Override
	public Integer getLossesByTeam(String teamId) {
		String sql = "SELECT COUNT(loser_id) FROM match_up WHERE loser_id = ?";
		Integer losses = jdbcTemplate.queryForObject(sql, Integer.class, Integer.parseInt(teamId));
		return losses;
	}

	@Override
	public Integer getTournamentWinsByTeam(String teamId, String tournamentId) {
		String sql = "SELECT COUNT(winner_id) FROM match_up WHERE winner_id = ? and tournament_id =?";
		Integer wins = jdbcTemplate.queryForObject(sql, Integer.class, Integer.parseInt(teamId), Integer.parseInt(tournamentId));
		return wins;
	}

	@Override
	public Integer getTournamentLossesByTeam(String teamId, String tournamentId) {
		String sql = "SELECT COUNT(loser_id) FROM match_up WHERE loser_id = ? and tournament_id =?";
		Integer losses = jdbcTemplate.queryForObject(sql, Integer.class, Integer.parseInt(teamId), Integer.parseInt(tournamentId));
		return losses;
	}

	@Override
	public List<MatchUp> getMatchUpsByTournamentId(String tournamentId) {
		List<MatchUp> matchups = new ArrayList<>();
		String sql = "SELECT * FROM match_up WHERE tournament_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, Integer.parseInt(tournamentId));
		while (results.next()) {
			MatchUp matchup = mapMatchUp(results);
			matchups.add(matchup);
		}
		return matchups;
	}
	
	public List<MatchUp> getAllMatchups() {
		String sql = "SELECT * from match_up";
		List<MatchUp> matchups = new ArrayList<>();
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			matchups.add(mapMatchUp(results));
		}
		System.out.println("matchups: " + matchups.size());
		return matchups;
	}
	
	@Override
	public List<MatchUp> getMatchUpsByTeamId(String teamId) {
		List<MatchUp> teamMatchups = new ArrayList<>();
		String sqlGetMatchupsByTeamId = "SELECT * FROM match_up WHERE team_id_1 = ? or team_id_2 = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetMatchupsByTeamId, Integer.parseInt(teamId), Integer.parseInt(teamId));
		while (results.next()) {
			teamMatchups.add(mapMatchUp(results));
		}
		return teamMatchups;
		
	}

	@Override
	public List<Integer> getTeamsForTournament(String tournamentID){
		List<Integer> teamList = new ArrayList<>();
		String sql = "Select * from match_up where tournament_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, Integer.parseInt(tournamentID));
		while (results.next()) {
			MatchUp matchup = mapMatchUp(results);
			teamList.add(Integer.parseInt(matchup.getTeamId1()));
			teamList.add(Integer.parseInt(matchup.getTeamId2()));
		}
		return teamList;
		}

	@Override
	public boolean updateWinner(MatchUp matchUp, boolean isTeamOneWinning) {
String sql = "UPDATE match_up SET winner_id = ? , loser_id = ? WHERE match_up_id = ?";
	String winner = isTeamOneWinning ? matchUp.getTeamId1() : matchUp.getTeamId2() ;
	String loser = isTeamOneWinning ? matchUp.getTeamId2() : matchUp.getTeamId1() ;
	jdbcTemplate.update(sql, Integer.parseInt(winner), Integer.parseInt(loser), Integer.parseInt(matchUp.getMatchUpId() ));
		
		return true;
	}

	@Override
	public boolean delete(MatchUp matchUp) {
		String sql = "DELETE FROM match_up WHERE match_up_id = ?";
		jdbcTemplate.update(sql, Integer.parseInt(matchUp.getMatchUpId()));
		return true;
	}

}