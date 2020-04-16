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

	// new teamId should be auto generated
	@Override
	public void createTeam(Team team) {
		String sqlCreateTeam = "INSERT INTO team (team_name, captain_id) VALUES (?, ?)";
		jdbcTemplate.update(sqlCreateTeam, team.getName(), team.getCaptainId());

	}
	
	public void dereferenceUserId(int userId) {
		String sql = "UPDATE team set captain_id = 1 WHERE captain_id = ?";
		jdbcTemplate.update(sql, userId);
	}
	
	public void nullifyCaptainId(int teamId) {
		String sql = "UPDATE team set captain_id = null WHERE team_id = ?";
		jdbcTemplate.update(sql, teamId);
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

	@Override
	public Team getTeamByCaptainId(int captainId) {
		Team team = new Team();
		String sqlGetTeamByCaptainId = "SELECT * FROM team WHERE captain_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetTeamByCaptainId, captainId);
		if (results.next()) {
			team.setId(results.getInt("team_id"));
			team.setName(results.getString("team_name"));
		}

		return team;

	}

	@Override
	public List<User> getMembersByTeamId(int teamId) {
		List<User> teamMembers = new ArrayList<>();

		String sqlGetTeamMembersByTeamId = "SELECT id, user_name FROM app_user JOIN player ON player.player_id = "
				+ "app_user.id WHERE player.team_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetTeamMembersByTeamId, teamId);
		while (results.next()) {
			User member = new User();
			member.setUserName(results.getString("user_name"));
			teamMembers.add(member);
		}
		return teamMembers;
	}

	public List<Team> searchTeams(String search) {
		List<Team> matchingTeams = new ArrayList<>();
		String sqlSearchTeams = "SELECT * FROM team " + "WHERE team_name ILIKE ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchTeams, "%" + search + "%");

		while (results.next()) {
			matchingTeams.add(mapRowToTeam(results));
		}
		return matchingTeams;
	}

	// Player info
	
	public void updatePlayerTeam(String playerId, String teamId) {
		String sqlUpdatePlayerTeam = "UPDATE player SET team_id = ? WHERE playerId = ?";
		jdbcTemplate.update(sqlUpdatePlayerTeam, Integer.parseInt(teamId), Integer.parseInt(playerId));
	}
	
	public void addTeamMember(String playerId, String teamId) {
		String sqlAddTeamMember = "INSERT INTO player (player_id, team_id) VALUES (?, ?) ";
		jdbcTemplate.update(sqlAddTeamMember, Integer.parseInt(playerId), Integer.parseInt(teamId));
	}
	
	public void removeTeamMember(String playerId, String teamId) {
		String sqlRemoveTeamMember = "DELETE FROM player WHERE player_id = ? AND teamid = ? ";
		jdbcTemplate.update(sqlRemoveTeamMember, Integer.parseInt(playerId), Integer.parseInt(teamId));
	}

	@Override
	public List<Team> getParticipatingTeamsByTournamentId(String tournamentId) {
		List<Team> participatingTeams = new ArrayList<>();

		String sqlGetParticipatingTeams = "SELECT * FROM team "
				+ "JOIN team_tournament ON team.team_id = team_tournament.team_id "
				+ "JOIN tournament ON tournament.tournament_id = team_tournament.tournament_id "
				+ "WHERE tournament.tournament_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetParticipatingTeams, Integer.parseInt(tournamentId));
		while (results.next()) {
			participatingTeams.add(mapRowToTeam(results));
		}
		return participatingTeams;

	}

	public List<Team> activeTeamsByTourneyId(String tournamentId) {

		List<Team> teamList = new ArrayList<>();

		String sqlGetActiveTeams = "SELECT * FROM team JOIN team_tournament ON team.team_id = team_tournament.team_id WHERE tournament_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetActiveTeams, Integer.parseInt(tournamentId));

		while (results.next()) {
			teamList.add(mapRowToTeam(results));
		}

		return teamList;
	}

	public List<Team> eliminatedTeamsByTourneyId(String tournamentId) {
		List<Team> teamList = new ArrayList<>();
		String sqlGetElimTeams = "SELECT * FROM team JOIN match_up ON team.team_id = match_up.loser_id WHERE match_up.tournament_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetElimTeams, Integer.parseInt(tournamentId));

		while (results.next()) {
			teamList.add(mapRowToTeam(results));
		}
		return teamList;
	}

	@Override
	public String idToName(String teamId) {
		String sql = "SELECT team_name FROM team WHERE team_id = ?";
		String name = jdbcTemplate.queryForObject(sql, String.class, Integer.parseInt(teamId));
		return name;
	}

	@Override
	public void updateTeam(Team team) {

	}

	@Override
	public void deleteTeam(Team team) {
//		String sqlDeleteFromPlayer = "delete from player where team_id = ?";
		String sqlDeleteTeam = "DELETE FROM team WHERE team_id = ?";
//		jdbcTemplate.update(sqlDeleteFromPlayer, team.getId());
		jdbcTemplate.update(sqlDeleteTeam, team.getId());

	}
}
