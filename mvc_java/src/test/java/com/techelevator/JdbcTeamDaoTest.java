package com.techelevator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.model.TeamModel.JDBCTeamDAO;
import com.techelevator.model.TeamModel.Team;
import com.techelevator.model.UserModel.User;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcTeamDaoTest {

	private static SingleConnectionDataSource dataSource;
	
	private static JDBCTeamDAO teamDAO;
	private static JdbcTemplate jdbcTemplate;
	private Team team = new Team();
	private Team injectedTeam = new Team();
	private User injectedUser = new User();
	
	
	
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/capstone");
//		dataSource.setUsername("capstone_appuser");
//		dataSource.setPassword("capstone_appuser1");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
		jdbcTemplate = new JdbcTemplate(dataSource);
		teamDAO = new JDBCTeamDAO(dataSource);
	}
	
	
	
	
	@Before
	public void setup() {
		String sqlInsertTeam = "Insert into team (team_id, team_name, captain_id) values (54321, 'Fake Team', 1)";
		String sqlInsertPlayer = "insert into player (player_id, team_id, ranking, points_scored) values (54321, 54321, 2, 56)";
		String sqlInsertAppUser = "insert into app_user (id, user_name, email, password, role, salt) values (54321, 'eingerith0', "
				+ "'plilie0@deliciousdays.com', 'kRcmsvKx', 2, '03eccb23537c30d25ac3fe15a198f9e9cca29182')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertAppUser);
		jdbcTemplate.update(sqlInsertTeam);
		jdbcTemplate.update(sqlInsertPlayer);
		injectedTeam.setId(54321);
		injectedTeam.setName("Fake Team");
		injectedTeam.setCaptainId(1);
		injectedUser.setUserID("54321");
		injectedUser.setUserName("eingerith0");
		team.setName("new fake team");
		team.setCaptainId(2);
		
	}

	@After
	public void deleteSetup() {
		String deletePlayer = "delete from player where team_id = 54321 and player_id = 54321";
		String deleteTeam = "DELETE FROM team WHERE team_id = 54321";
		String deleteUser = "delete from app_user where id = 54321";
		jdbcTemplate.update(deletePlayer);
		jdbcTemplate.update(deleteTeam);
		jdbcTemplate.update(deleteUser);
		

	}
	
	
	@Test
	public void testCreateTeam() {
		teamDAO.createTeam(team);
		Team testTeam = teamDAO.getTeamByName("new fake team");
		assertTrue(team.getName().equals(testTeam.getName()));

	}

	@Test
	public void testGetAllTeams() {
		List<Team> teamList = teamDAO.getAllTeams();
		assertEquals(teamList.size(), teamDAO.getTeamCount());
	}

	@Test
	public void testGetTeamById() {
		Team retrievedTeam = teamDAO.getTeamById(54321);
		assertTrue(retrievedTeam.getName().equals("Fake Team"));
		System.out.println(retrievedTeam);
	}
	
	@Test
	public void testGetTeamByName() {
		Team retrievedTeam = teamDAO.getTeamByName("Fake Team");
		assertEquals(retrievedTeam.getId(), 54321);
	}

	@Test
	public void testGetTeamByCaptainId() {
		
	}
	
	@Test
	public void testGetAllTeamCaptains() {
		
	}
	
	@Test
	public void testGetCaptainByTeamId() {
		
	}
	@Test
	public void testMembersByTeamId() {
		List<User> teamMembers = teamDAO.getMembersByTeamId(54321);
		for (User member : teamMembers) {
		assertTrue(member.getUserName().equals(injectedUser.getUserName()));
		}
	}

	
	@Test
	public void testDeleteTeam() {
		teamDAO.deleteTeam(injectedTeam);
		assertNull(teamDAO.getTeamById(injectedTeam.getId()).getName());
	}

}
