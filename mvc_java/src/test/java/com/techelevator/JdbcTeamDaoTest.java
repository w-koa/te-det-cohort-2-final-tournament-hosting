package com.techelevator;

import static org.junit.Assert.*;

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

public class JdbcTeamDaoTest {

	private static SingleConnectionDataSource dataSource;

	private static JDBCTeamDAO teamDAO;
	private static JDBCUserDAO userDao;
	@SuppressWarnings("unused")
	private static JdbcTemplate jdbcTemplate;

	private Team team_one = null;
	private Team team = new Team();
	private User globalUser = null;

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/capstone");
		dataSource.setUsername("capstone_appuser");
		dataSource.setPassword("capstone_appuser1");
//		dataSource.setUsername("postgres");
//		dataSource.setPassword("postgres1");
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
		team = new Team();
		team.setName("Fake Team");
		team.setCaptainId(Integer.parseInt(globalUser.getUserID()));
		teamDAO.createTeam(team);
		List<Team> list = teamDAO.getAllTeams();
		for (Team te : list) {
			if (te.getName().equals("Fake Team") && te.getCaptainId() == Integer.parseInt(globalUser.getUserID())) {
				team_one = te;
			}
		}
	}


	@After
	public void deleteSetup() {
		teamDAO.nullifyCaptainId(team_one.getCaptainId());
		teamDAO.deleteTeam(team_one);
		teamDAO.dereferenceUserId(Integer.parseInt(globalUser.getUserID()));
		userDao.deleteUserbyUserName("eingerith0");
	}

	@Test
	public void testGetTeamByCaptainId() {
		Team check = teamDAO.getTeamByCaptainId(team_one.getCaptainId());
		assertEquals(check.getName(), team_one.getName());
		assertTrue(team_one.getId() == check.getId());
	}


	@Test
	public void testGetAllTeamCaptains() {
		Team nextTeam = new Team();
		Team nextTeamTwo = new Team();
		User nextUserTwo = new User();
		User nextUser = new User();
		
		nextUser.setUserName("engine");
		nextUserTwo.setUserName("engine2");
		nextUser.setEmail("aol@aol.com");
		nextUserTwo.setEmail("yahoo@yahoo.com");
		nextUser.setPassword("passwordyahoo");
		nextUserTwo.setPassword("passwordaol.com");
		nextUser.setRole("2");
		nextUserTwo.setRole("2");
		
		userDao.saveUser(nextUser.getUserName(), nextUser.getPassword(), nextUser.getEmail(), nextUser.getRole());
		userDao.saveUser(nextUserTwo.getUserName(), nextUserTwo.getPassword(), nextUserTwo.getEmail(), nextUserTwo.getRole());
		User user = userDao.getUserByUserName("engine");
		User userTwo = userDao.getUserByUserName("engine2");
		
		nextTeam.setName("Next Test");
		nextTeamTwo.setName("Next Test Two");
		nextTeam.setCaptainId(Integer.parseInt(user.getUserID()));
		nextTeamTwo.setCaptainId(Integer.parseInt(userTwo.getUserID()));

		teamDAO.createTeam(nextTeam);
		teamDAO.createTeam(nextTeamTwo);
		
		User captainOne = null;
		User captainTwo = null;
		User captainThree = null;
		
		List<User> list = teamDAO.getAllTeamCaptains();
		for (User use : list) {
			if (use.getUserName().equals(nextUser.getUserName())) {
				captainOne = use;
			} else if (use.getUserName().equals(nextUserTwo.getUserName())) {
				captainTwo = use;
			} else if (use.getUserName().equals(globalUser.getUserName())) {
				captainThree = use;
			}
		}
		assertTrue(captainOne.getUserName().equals(user.getUserName()));
		assertTrue(captainOne.getUserID().equals(user.getUserID()));
		
		assertTrue(captainTwo.getUserName().equals(userTwo.getUserName()));
		assertTrue(captainTwo.getUserID().equals(userTwo.getUserID()));
		
		assertTrue(captainThree.getUserName().equals(globalUser.getUserName()));
		assertTrue(captainThree.getUserID().equals(globalUser.getUserID()));
	}

	@Test
	public void testGetCaptainByTeamId() {
		User check = teamDAO.getCaptainByTeamId(team_one.getId());
		assertEquals(check.getUserName(), globalUser.getUserName());
		assertEquals(check.getUserID(), globalUser.getUserID());
	}

	@Test
	public void testCreateTeam() {
		teamDAO.createTeam(team);
		Team testTeam = teamDAO.getTeamByName("Fake Team");
		assertTrue(team.getName().equals(testTeam.getName()));

	}

	@Test
	public void testGetTeamById() {
		Team retrievedTeam = teamDAO.getTeamById(team_one.getId());
		assertTrue(retrievedTeam.getName().equals("Fake Team"));
		assertTrue(retrievedTeam.getId() == team_one.getId());
	}

	@Test
	public void testGetTeamByName() {
		Team retrievedTeam = teamDAO.getTeamByName("Fake Team");
		assertEquals(retrievedTeam.getId(), team_one.getId());
		assertTrue(retrievedTeam.getName().equals("Fake Team"));
	}


	@Test
	public void testDeleteTeam() {
		teamDAO.deleteTeam(team_one);
		assertNull(teamDAO.getTeamById(team_one.getId()).getName());
	}

}
