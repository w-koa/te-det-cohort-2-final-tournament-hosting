package com.techelevator;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;
import com.techelevator.model.TeamModel.JDBCTeamDAO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JdbcTeamDaoTest {

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	
	private JDBCTeamDAO teamDAO;
	
	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/capstone");
		dataSource.setUsername("capstone_appuser");
		dataSource.setPassword("capstone_appuser1");
		/* The following line disables autocommit for connections 
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}
	
	@Before
	public void setup() {
		String sqlInsertTeam = "Insert into team (team_id, team_name, captain_id) values ('54321', 'Fake Team', '654321')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertTeam);
		teamDAO = new JDBCTeamDAO(dataSource);
	}
	
	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	/* This method provides access to the DataSource for subclasses so that 
	 * they can instantiate a DAO for testing */
	protected DataSource getDataSource() {
		return dataSource;
	}

	@Test
	public void testJDBCTeamDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateTeam() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllTeams() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTeamById() {

		fail("Not yet implemented");
	}

	@Test
	public void testGetTeamByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTeam() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteTeam() {
		fail("Not yet implemented");
	}

}
