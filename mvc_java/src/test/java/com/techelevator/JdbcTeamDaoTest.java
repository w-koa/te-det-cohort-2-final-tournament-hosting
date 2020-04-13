package com.techelevator;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;
import com.techelevator.model.TeamModel.JDBCTeamDAO;
import com.techelevator.model.TeamModel.Team;
import com.techelevator.model.TournamentModel.Tournament;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JdbcTeamDaoTest {

	private static SingleConnectionDataSource dataSource;
	
	private JDBCTeamDAO teamDAO;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/capstone");
//		dataSource.setUsername("capstone_appuser");
//		dataSource.setPassword("capstone_appuser1");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
	
	@Before
	public void setup() {
		String sqlInsertTeam = "Insert into team (team_id, team_name, captain_id) values ('54321', 'Fake Team', '654321')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertTeam);
		teamDAO = new JDBCTeamDAO(dataSource);
	}


	@Test
	public void testCreateTeam() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllTeams() {
		List<Team> teamList = teamDAO.getAllTeams();
		assertEquals(teamList.size(), teamDAO.getTeamCount());
	}

	@Test
	public void testGetTeamById() {
		Team team = new Team();
		Team retrievedTeam = new Team();
		team.setName("Timsteam");
		team.setCaptainId(8);
		teamDAO.createTeam(team);
		assertEquals(team.getId(), retrievedTeam.getId());
		
	}


	
	
	
	
	
	
	
	
	@Test
	public void testGetTeamByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllTeamCaptains() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetTeamCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCaptainsByTeamId() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDeleteTeam() {
		fail("Not yet implemented");
	}

}
