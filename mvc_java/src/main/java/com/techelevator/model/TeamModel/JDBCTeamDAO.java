package com.techelevator.model.TeamModel;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.UserModel.User;

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

	// Helper Just in case id is not auto-generated.
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

	// Helper method to set captain info
	private User mapRowToCaptain(SqlRowSet row) {
		User captain = new User();
		captain.setUserID(row.getString("id"));
		captain.setUserName(row.getString("user_name"));
		captain.setEmail(row.getString("email"));

		return captain;

	}

	@Override
	public List<User> getAllTeamCaptains() {

		List<User> allCaptains = new ArrayList<>();

		String sqlGetAllCaptains = "SELECT * FROM app_user JOIN team ON team.captain_id = app_user.id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllCaptains);
		while (results.next()) {
			allCaptains.add(mapRowToCaptain(results));
		}
		return allCaptains;
	}

	@Override
	public User getCaptainByTeamId(int teamId) {

		User captain = new User();

		String sqlGetCaptainByTeamId = "SELECT * FROM app_user JOIN team ON team.captain_id = app_user.id "
				+ "WHERE team_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCaptainByTeamId, teamId);
		if (results.next()) {
			captain = mapRowToCaptain(results);
		}

		return captain;
	}

	public int getTeamCount() {
		String sqlGetTeamCount = "select count(team_id) as cnt from team";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetTeamCount);
		int teamCount = 0;
		if (results.next()) {
			teamCount = results.getInt("cnt");
		}
		return teamCount;
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
