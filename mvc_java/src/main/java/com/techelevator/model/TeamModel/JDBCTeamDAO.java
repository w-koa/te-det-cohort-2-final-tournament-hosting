package com.techelevator.model.TeamModel;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JDBCTeamDAO implements TeamDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCTeamDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	// Helper method
	private Team mapRowToTeam(SqlRowSet row) {
		Team team = new Team();
		team.setId(row.getInt("team_id"));
		team.setName(row.getString("team_name"));
		team.setCaptainId(row.getInt("captain_id"));
		
		return team;
	}
	
	// Helper Just in case id is not auto-generated
	private int getNextTeamId() {
		String sqlCurrentIdMax = "SELECT NEXTVAL(team_team_id_seq)";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlCurrentIdMax);
		if (result.next()) {
			return result.getInt(1);
		} else {
			throw new RuntimeException("Oops, something went wrong getting the next team ID");
		}
	}
	
	// new teamId should be auto generated
	@Override
	public void createTeam(Team team) {
		// TODO Auto-generated method stub
		String sqlCreateTeam = "INSERT INTO team (name, captain_id) VALUES (?, ?)";
		
		jdbcTemplate.update(sqlCreateTeam, team.getName(), team.getCaptainId());
		
		
	}

	@Override
	public List<Team> getAllTeams() {
		List<Team> teamList = new ArrayList<>();
		
		String sqlGetAllTeams = "SELECT * FROM team";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllTeams);
		
		while (results.next()) {
			teamList.add(mapRowToTeam(results));
		}
		return teamList;
	}

	@Override
	public Team getTeamById(int id) {
		Team team = new Team();
		
		String sqlGetTeamById = "SELECT * FROM team WHERE team_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetTeamById, id);
		
		if (result.next()) {
			team = mapRowToTeam(result);
		}
		
		return team;
	}

	@Override
	public Team getTeamByName(String name) {

		Team team = new Team();
		
		String sqlGetTeamByName = "SELECT * FROM team WHERE team_name = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetTeamByName, name);
		
		if (result.next()) {
			team = mapRowToTeam(result);
		}
		return team;
	}

	@Override
	public void updateTeam(Team team) {

	}

	@Override
	public void deleteTeam(int id) {

		String sqlDeleteTeam = "DELETE FROM team WHERE team_id = ?";
		jdbcTemplate.update(sqlDeleteTeam, id);
	}

}
