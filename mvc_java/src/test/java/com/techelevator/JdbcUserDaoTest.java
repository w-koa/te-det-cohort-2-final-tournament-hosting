package com.techelevator;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.model.UserModel.JDBCUserDAO;

public class JdbcUserDaoTest {


	private static SingleConnectionDataSource dataSource;

	private JDBCUserDAO userDAO;

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/capstone");
		dataSource.setUsername("capstone_appuser");
		dataSource.setPassword("capstone_appuser1");
		dataSource.setAutoCommit(false);
	}

	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	protected DataSource getDataSource() {
		return dataSource;
	}

	@Test
	public void testJDBCUserDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchForUsernameAndPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatePassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserByUserName() {
		fail("Not yet implemented");
	}

}
