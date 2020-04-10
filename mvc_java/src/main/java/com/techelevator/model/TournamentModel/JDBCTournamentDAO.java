package com.techelevator.model.TournamentModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

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
		System.out.println(row.getString("date"));
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
		Tournament tournament = new Tournament();
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
	public List<Tournament> getTournamentByTeam(String teamId) {
		List<Tournament> tournaments = new ArrayList<>();
		String sql = "SELECT * FROM tournament JOIN team_tournament ON tournament.tournament_id = team_tournament.tournament_id "
				+ "WHERE team_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, Integer.parseInt(teamId));
		while (results.next()) {
			Tournament tournament = mapTournament(results);
			tournaments.add(tournament);
		}
		return tournaments;

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

	@Override // INCOMPLETE
	public List<Tournament> topXTournamentsByPlayerCount(String limit) {
		List<Tournament> tournaments = new ArrayList<>();
		String sql = "SELECT *  FROM tournament WHERE game = ?";
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
