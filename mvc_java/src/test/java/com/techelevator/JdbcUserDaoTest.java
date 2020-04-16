package com.techelevator;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.model.UserModel.JDBCUserDAO;
import com.techelevator.model.UserModel.User;
import com.techelevator.security.PasswordHasher;

public class JdbcUserDaoTest {

	private static SingleConnectionDataSource dataSource;

	private static JDBCUserDAO userDAO;
	

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/capstone");
		dataSource.setUsername("capstone_appuser");
		dataSource.setPassword("capstone_appuser1");
//		dataSource.setUsername("postgres");
//		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
		PasswordHasher hashMaster = new PasswordHasher();
		userDAO = new JDBCUserDAO(dataSource, hashMaster);
	}

	
	@Test
	public void testSaveUser() {
		userDAO.saveUser("timtheuser", "timspassword", "tim@email.com", "1");
		User user = (User) userDAO.getUserByUserName("timtheuser");
		assertEquals(user.getUserName(), "timtheuser");
		assertEquals(user.getRole(), "1");
	}

	@Test
	public void testSearchForUsernameAndPassword() {
		userDAO.saveUser("timtheuser", "timspassword", "tim@email.com", "1");
		assertTrue(userDAO.searchForUsernameAndPassword("timtheuser", "timspassword"));
		assertFalse(userDAO.searchForUsernameAndPassword("timtheuser", "Nottimspassword"));
		
	}

	@Test
	public void testUpdatePassword() {
		userDAO.saveUser("timtheuser", "timspassword", "tim@email.com", "1");
		userDAO.updatePassword("timtheuser", "newpassword");
		assertTrue(userDAO.searchForUsernameAndPassword("timtheuser", "newpassword"));
	}

	@Test
	public void testGetUserByUserName() {
		userDAO.saveUser("timtheuser", "timspassword", "tim@email.com", "1");
		userDAO.getUserByUserName("timtheuser");
		assertTrue(userDAO.searchForUsernameAndPassword("timtheuser", "timspassword"));
	}

	@Test
	public void testDeleteUserById() {
		userDAO.saveUser("timtheuser", "timspassword", "tim@email.com", "1");
		userDAO.deleteUserbyUserName("timtheuser");
		assertNull(userDAO.getUserByUserName("timtheuser"));
	}

}
