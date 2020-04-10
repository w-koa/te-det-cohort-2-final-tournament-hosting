package com.techelevator.model.MatchUpModel;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.TournamentModel.Tournament;

@Component
public class JDBCMatchUpDAO implements MatchUpDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCMatchUpDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
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
		return match;
	}

	@Override
	public boolean createMatchup(MatchUp newMatchUp) {
		String sql = "INSERT INTO match_up (match_up_id, tournament_id, "
				+ "game_id, team_id_1, team_id_2, location, date, time, winner_id, loser_id) "
				+ "VALUES (?,?,?,?,?,?,?,?,'0','0')";
		jdbcTemplate.batchUpdate(sql, newMatchUp.getMatchUpId(), newMatchUp.getTournamentId(), newMatchUp.getGameId(),
				newMatchUp.getTeamId1(), newMatchUp.getTeamId2(), newMatchUp.getLocation(), newMatchUp.getDate(),
				newMatchUp.getTime());
		return true;
	}

	@Override
	public MatchUp getMatchByMatchUpId(String MatchUpId) {
		MatchUp match = new MatchUp();
		String sql = "Select * From match_up where match_up_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, MatchUpId);
		while (results.next()) {
			match = mapMatchUp(results);
		}
		return match;
	}

	@Override
	public Integer getWinsByTeam(String teamId) {
		String sql = "SELECT COUNT(winner_id) FROM match_up WHERE winner_id = ?";
		Integer wins = jdbcTemplate.queryForObject(sql,  Integer.class, teamId);
		return wins;
	}

	@Override
	public Integer getLossesByTeam(String teamId) {
		String sql = "SELECT COUNT(loser_id) FROM match_up WHERE loser_id = ?";
		Integer losses = jdbcTemplate.queryForObject(sql,  Integer.class, teamId);
		return losses;
	}

	@Override
	public Integer getTournamentWinsByTeam(String teamId, String tournamentId) {
		String sql = "SELECT COUNT(winner_id) FROM match_up WHERE winner_id = ? and tournament_id =?";
		Integer wins = jdbcTemplate.queryForObject(sql,  Integer.class, teamId, tournamentId);
		return wins;
	}

	@Override
	public Integer getTournamentLossesByTeam(String teamId, String tournamentId) {
		String sql = "SELECT COUNT(loser_id) FROM match_up WHERE loser_id = ? and tournament_id =?";
		Integer losses = jdbcTemplate.queryForObject(sql,  Integer.class, teamId, tournamentId);
		return losses;
	}


	@Override
	public List <MatchUp> getMatchUpsByTournamentId(String tournamentId){
		List <MatchUp> matchups = new ArrayList<>();
		String sql = "SELECT * FROM match_up WHERE tournament_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, Integer.parseInt(tournamentId));
		while (results.next()) {
			MatchUp matchup = mapMatchUp(results);
			matchups.add(matchup);
		}
		return matchups;
	}

	@Override
	public boolean update(MatchUp matchUp) {
		
		return false;
	}

	@Override
	public boolean delete(MatchUp matchUp) {
		String sql = "DELETE FROM match_up WHERE match_up_id = ?";
		jdbcTemplate.update(sql, matchUp.getMatchUpId());
		return true;
	}

}