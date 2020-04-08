package com.techelevator.model.TournamentModel;

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
	public Tournament getTournamentByOrganizer(String organizerId) {
		Tournament tournament = new Tournament();
		String sql = "SELECT * FROM tournament WHERE organizer_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, organizerId);
		while (results.next()) {
			tournament = mapTournament(results);
		}
		return tournament;
	
	}
	

	@Override
	public Tournament getTournamentByTeam(String teamId) {
		Tournament tournament = new Tournament();
		String sql = "SELECT * FROM tournament JOIN team_tournament ON tournament.tournament_id = team_tournament.tournament_id "
				+ "WHERE team_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, teamId);
		while (results.next()) {
			tournament = mapTournament(results);
		}
		return tournament;
		  
	}

	@Override
	public Tournament getTournamentByGameId(String gameId) {
		Tournament tournament = new Tournament();
		String sql = "SELECT * FROM tournament WHERE game_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, gameId);
		while (results.next()) {
			tournament = mapTournament(results);
		}
		return tournament;
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
