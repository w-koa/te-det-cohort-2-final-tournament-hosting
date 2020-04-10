package com.techelevator;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.model.MatchUpModel.JDBCMatchUpDAO;

public class JdbcMatchUpDaoTest {

	private static SingleConnectionDataSource dataSource;
	
	private JDBCMatchUpDAO matchUpDAO;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/capstone");
		dataSource.setUsername("capstone_appuser");
		dataSource.setPassword("capstone_appuser1");
		dataSource.setAutoCommit(false);
	}
	
	@Test
	public void testCreateMatchup() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMatchByMatchUpId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWinsByTeam() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLossesByTeam() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTournamentWinsByTeam() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTournamentLossesByTeam() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMatchUpsByTournamentId() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
