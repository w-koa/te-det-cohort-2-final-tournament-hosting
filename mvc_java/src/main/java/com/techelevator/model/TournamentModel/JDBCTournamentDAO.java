package com.techelevator.model.TournamentModel;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;




@Component
public class JDBCTournamentDAO implements TournamentDAO{

		private JdbcTemplate jdbcTemplate;

		@Autowired
		public JDBCTournamentDAO(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
	
	public Tournament mapTournament (SqlRowSet row) {
		Tournament tourney = new Tournament();
		tourney.setId(row.getString("tournament_id"));
		tourney.setName(row.getString("tournament_name"));
		tourney.setOrganizerId(row.getString("organizer_id"));
		tourney.setGameId(row.getString("game_id"));
		tourney.setType(row.getString("tournament_type"));
		tourney.setDescription(row.getString("description"));
		return tourney;
	}
		
			
	
	@Override
	public boolean create(Tournament newTournament) {
		String sql ="INSERT INTO tournament (tournament_name, organizer_id, game_id, tournament_type, description)" +
				"VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, newTournament.getName(), newTournament.getOrganizerId(),
				newTournament.getGameId(),newTournament.getType(),newTournament.getDescription()
					);
			return true;
	}

	@Override
	public Tournament getTournamentByID(String id) {
		Tournament tournament = new Tournament();
		String sql = "SELECT * FROM tournament WHERE tournament_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		while (results.next()) {
			tournament = mapTournament(results);
		}
		return tournament;
	
	}

	@Override
	public List <Tournament> getTournamentByOrganizer(String organizerId) {
		List <Tournament> tournaments= new ArrayList<>();
		String sql = "SELECT * FROM tournament WHERE organizer_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, organizerId);
		while (results.next()) {
			Tournament tournament = mapTournament(results);
			tournaments.add(tournament);
		}
		return tournaments;
	
	}
	

	@Override
	public List <Tournament> getTournamentByTeam(String teamId) {
		List <Tournament> tournaments= new ArrayList<>();
		String sql = "SELECT * FROM tournament JOIN team_tournament ON tournament.tournament_id = team_tournament.tournament_id "
				+ "WHERE team_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, teamId);
		while (results.next()) {
			Tournament tournament = mapTournament(results);
			tournaments.add(tournament);
		}
		return tournaments;
		  
	}

	@Override
	public List <Tournament> getTournamentByGameId(String gameId) {
		List <Tournament> tournaments= new ArrayList<>();
		String sql = "SELECT * FROM tournament WHERE game_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, gameId);
		while (results.next()) {
			Tournament tournament = mapTournament(results);
			tournaments.add(tournament);
		}
		return tournaments;
	}
@Override  // INCOMPLETE
public List <Tournament> topXTournamentsByPlayerCount (String limit){
	List <Tournament> tournaments= new ArrayList<>();
	String sql = "SELECT *  FROM tournament WHERE game_id = ?";
	SqlRowSet results = jdbcTemplate.queryForRowSet(sql, limit);
	while (results.next()) {
		Tournament tournament = mapTournament(results);
		tournaments.add(tournament);
	}
	return tournaments;
}
	
	
	@Override
	public boolean update(Tournament tournament) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean delete(Tournament tournament) {
		String sql = "DELETE FROM tournament WHERE tournament_id = ?";
		jdbcTemplate.update(sql, tournament.getId());
		return true;
	}

	

	
}
