package com.techelevator;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.model.TournamentModel.JDBCTournamentDAO;

public class JdbcTournamentDaoTest {
	
	private JDBCTournamentDAO tournamentDAO;

	private static SingleConnectionDataSource dataSource;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/capstone");
		dataSource.setUsername("capstone_appuser");
		dataSource.setPassword("capstone_appuser1");
		dataSource.setAutoCommit(false);
	}
	
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTournamentByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTournamentByOrganizer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTournamentByTeam() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTournamentByGameId() {
		fail("Not yet implemented");
	}

	@Test
	public void testTopXTournamentsByPlayerCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
