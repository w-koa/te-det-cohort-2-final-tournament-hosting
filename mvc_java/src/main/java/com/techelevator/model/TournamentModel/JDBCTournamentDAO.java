package com.techelevator.model.TournamentModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
public class JDBCTournamentDAO implements TournamentDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCTournamentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Tournament mapTournament(SqlRowSet row) {
		Tournament tourney = new Tournament();
		tourney.setId(row.getString("tournament_id"));
		tourney.setName(row.getString("tournament_name"));
		tourney.setOrganizerId(row.getString("organizer_id"));
		tourney.setDate(LocalDate.parse(row.getString("date")));
		tourney.setLocation(row.getString("location"));
		tourney.setGame(row.getString("game"));
		tourney.setType(row.getString("tournament_type"));
		tourney.setDescription(row.getString("description"));
		tourney.setTaggedDesc(row.getString("tagged_desc"));
		return tourney;
	}

	@Override
	public boolean create(Tournament newTournament) {
		String sql = "INSERT INTO tournament (tournament_name, organizer_id, date, game, tournament_type, description)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, newTournament.getName(), Integer.parseInt(newTournament.getOrganizerId()),
				newTournament.getDate(), newTournament.getGame(), newTournament.getType(), newTournament.getDescription());
		return true;
	}

	@Override
	public List<Tournament> getAllTournaments() {
		List<Tournament> tournaments = new ArrayList<>();
		String sql = "SELECT * FROM tournament";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Tournament tournament = mapTournament(results);
			tournaments.add(tournament);
		}
		return tournaments;

	}

	@Override
	public Tournament getTournamentByID(String id) {
		Tournament tournament = null;
		String sql = "SELECT * FROM tournament WHERE tournament_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, Integer.parseInt(id));
		while (results.next()) {
			tournament = mapTournament(results);
		}
		return tournament;

	}

	@Override
	public List<Tournament> getTournamentByOrganizer(String organizerId) {
		List<Tournament> tournaments = new ArrayList<>();
		String sql = "SELECT * FROM tournament WHERE organizer_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, Integer.parseInt(organizerId));
		while (results.next()) {
			Tournament tournament = mapTournament(results);
			tournaments.add(tournament);
		}
		return tournaments;

	}

	@Override
	public List<Tournament> getTournamentByTeamID(String teamId) {
		String sql = "SELECT * FROM tournament JOIN team_tournament ON tournament.tournament_id = team_tournament.tournament_id "
		+ "WHERE team_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, Integer.parseInt(teamId));
		List<Tournament> teamTournaments = new ArrayList<>();
		while (results.next()) {
			teamTournaments.add(mapTournament(results));
		}
		return teamTournaments;
	}

	@Override
	public List<Tournament> getTournamentByGame(String game) {
		List<Tournament> tournaments = new ArrayList<>();
		String sql = "SELECT * FROM tournament WHERE game = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, game);
		while (results.next()) {
			Tournament tournament = mapTournament(results);
			tournaments.add(tournament);
		}
		return tournaments;
	}

	
	@Override
	public void joinTournament(String tournamentId, String teamId) {
		
		String sqlJoinTournament = "INSERT INTO team_tournament (tournament_id, team_id) "
				+ "VALUES (?, ?)";
		jdbcTemplate.update(sqlJoinTournament, Integer.parseInt(tournamentId), Integer.parseInt(teamId));
	}

	@Override
	public boolean delete(String id) {
		String sql = "DELETE FROM tournament WHERE tournament_id = ?";
		jdbcTemplate.update(sql, Integer.parseInt(id));
		return true;
	}

	@Override
	public boolean update(Tournament tournament) {
		return false;
	}

	@Override
	public List<Tournament> topXTournamentsByPlayerCount(String limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
