package com.techelevator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.model.TeamModel.JDBCTeamDAO;
import com.techelevator.model.TeamModel.Team;
import com.techelevator.model.UserModel.JDBCUserDAO;
import com.techelevator.model.UserModel.User;
import com.techelevator.security.PasswordHasher;

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
	private static JDBCUserDAO userDao;
	private static JdbcTemplate jdbcTemplate;
	
	private Team team_one = null;
	private Team team = new Team();
	private Team injectedTeam = new Team();
	private User injectedUser = new User();
	private User globalUser = null;
	
	
	
	
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
		userDao = new JDBCUserDAO(dataSource, new PasswordHasher());
	}
	
	
	
	
	@Before
	public void setup() {
		User user = new User();
		user.setUserName("eingerith0");
		user.setEmail("plilie@deliciousdays.com");
		user.setPassword("kRcmsvKx");
		user.setRole("2");
		userDao.saveUser(user.getUserName(), user.getPassword(), user.getEmail(), user.getRole());
		globalUser = userDao.getUserByUserName("eingerith0");
		Team team = new Team();
		team.setName("Fake Team");
		team.setCaptainId(Integer.parseInt(globalUser.getUserID()));
		teamDAO.createTeam(team);
		List<Team> list =  teamDAO.getAllTeams();
		for (Team te : list) {
			if (te.getName().equals("Fake Team") && te.getCaptainId() == Integer.parseInt(globalUser.getUserID())) {
				team_one = te;
			}
		}
		
//		String sqlInsertTeam = "Insert into team (team_id, team_name, captain_id) values (54321, 'Fake Team', 1)";
//		String sqlInsertPlayer = "insert into player (player_id, team_id, ranking, points_scored) values (54321, 54321, 2, 56)";
//		String sqlInsertAppUser = "insert into app_user (id, user_name, email, password, role, salt) values (54321, 'eingerith0', "
//				+ "'plilie0@deliciousdays.com', 'kRcmsvKx', 2, '03eccb23537c30d25ac3fe15a198f9e9cca29182')";
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
////		jdbcTemplate.update(sqlInsertAppUser);
//		jdbcTemplate.update(sqlInsertTeam);
//		jdbcTemplate.update(sqlInsertPlayer);
//		injectedTeam.setId(54321);
//		injectedTeam.setName("Fake Team");
//		injectedTeam.setCaptainId(1);
////		injectedUser.setUserID("54321");
////		injectedUser.setUserName("eingerith0");
//		team.setName("new fake team");
//		team.setCaptainId(2);
		
	}

	@Test
	public void testGetTeamByCaptainId() {
		Team check = teamDAO.getTeamByCaptainId(team_one.getCaptainId());
		assertEquals(check.getName(), team_one.getName());
		assertTrue(team_one.getId() == check.getId());
	}
	
	@Test
	public void testGetAllTeamCaptains() {
		List<User> list = teamDAO.getAllTeamCaptains();
		System.out.println("Size: " + list.size());
		
		assertTrue(list.get(0).equals(globalUser));
	}
	
	@Test
	public void testGetCaptainByTeamId() {
		User check = teamDAO.getCaptainByTeamId(team_one.getId());
		assertEquals(check.getUserName(), globalUser.getUserName());
		assertEquals(check.getUserID(), globalUser.getUserID());
	}

	@After
	public void deleteSetup() {
		String deletePlayer = "delete from player where team_id = 54321 and player_id = 54321";
		String deleteTeam = "DELETE FROM team WHERE team_id = 54321";
		String deleteUser = "delete from app_user where id = 54321";
		teamDAO.deleteTeam(team_one);
		userDao.deleteUserbyUserName("eingerith0");
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
	public void testMembersByTeamId() {
		List<User> teamMembers = teamDAO.getMembersByTeamId(team_one.getId());
		for (User member : teamMembers) {
		assertTrue(member.getUserName().equals(globalUser.getUserName()));
		}
	}

	
	@Test
	public void testDeleteTeam() {
		teamDAO.deleteTeam(injectedTeam);
		assertNull(teamDAO.getTeamById(injectedTeam.getId()).getName());
	}

}
