package com.techelevator;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.model.MatchUpModel.JDBCMatchUpDAO;
import com.techelevator.model.MatchUpModel.MatchUp;
import com.techelevator.model.TeamModel.JDBCTeamDAO;
import com.techelevator.model.TeamModel.Team;
import com.techelevator.model.TournamentModel.JDBCTournamentDAO;
import com.techelevator.model.TournamentModel.Tournament;
import com.techelevator.model.TournamentModel.TournamentDAO;

public class JdbcTournamentDaoTest {
	
	private static JDBCTournamentDAO tournamentDAO;
	private static JDBCTeamDAO teamDAO;
	private static JDBCMatchUpDAO matchUpDAO;

	private static SingleConnectionDataSource dataSource;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/capstone");
//		dataSource.setUsername("capstone_appuser");
//		dataSource.setPassword("capstone_appuser1");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
		tournamentDAO = new JDBCTournamentDAO(dataSource);
		teamDAO = new JDBCTeamDAO(dataSource);
		matchUpDAO = new JDBCMatchUpDAO(dataSource);
	}
	
//	@Before
//	public void setup() {
//		String sqlInsertTournament = "insert into tournament (tournament_id, tournament_name, "
//				+ "organizer_id, date, location, game, tournament_type, description) "
//				+ "values (7654321, 'Four Sons', 5, '2020/10/30', '0 Vahlen Street', "
//				+ "'Assassins Creed', 'single', 'Sed ante. Vivamus tortor. "
//				+ "Duis mattis egestas metus.')";
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		jdbcTemplate.update(sqlInsertTournament);
//		tournamentDAO = new JDBCTournamentDAO(dataSource);
//	}
	
	
	@Test
	public void testCreate() {
		Tournament tournament = new Tournament();
		tournament.setName("Timstourney");
		tournament.setOrganizerId("1");
		tournament.setGame("54321");
		tournament.setType("call of duty");
		tournament.setDescription("tims tourney is fun");
		tournament.setDate(LocalDate.parse("2020-05-14"));
		assertTrue(tournamentDAO.create(tournament));
		List <Tournament> tournaments = tournamentDAO.getTournamentByOrganizer("1");
		for (Tournament tourney: tournaments) {
			if (tourney.getName() == tournament.getName()){
				assertEquals(tourney.getName(), tournament.getName());
				assertEquals(tourney.getOrganizerId(), tournament.getOrganizerId());
				assertEquals(tourney.getGame(), tournament.getGame());
				assertEquals(tourney.getType(), tournament.getType());
				assertEquals(tourney.getDescription(), tournament.getDescription());
			}
		}
	}

	@Test
	public void testGetTournamentByID() {
		Tournament tournament = new Tournament();
		Tournament retrievedTourney = new Tournament();
		tournament.setName("Timstourney");
		tournament.setOrganizerId("1");
		tournament.setGame("54321");
		tournament.setType("call of duty");
		tournament.setDescription("tims tourney is fun");
		tournament.setDate(LocalDate.parse("2020-05-14"));
		tournamentDAO.create(tournament);
		List <Tournament> tournaments = tournamentDAO.getTournamentByOrganizer("1");
		for (Tournament tourney: tournaments) {
			if (tourney.getName() == "Timstourney"){
				retrievedTourney = tournamentDAO.getTournamentByID(tourney.getId());
			}
		}
			
		assertEquals(tournament.getId(), retrievedTourney.getId());
	}

	@Test
	public void testGetTournamentByOrganizer() {
		Tournament tournament = new Tournament();
		Tournament retrievedTourney = new Tournament();
		tournament.setName("Timstourney");
		tournament.setOrganizerId("1");
		tournament.setGame("54321");
		tournament.setType("call of duty");
		tournament.setDescription("tims tourney is fun");
		tournament.setDate(LocalDate.parse("2020-05-14"));
		tournamentDAO.create(tournament);
		List <Tournament> tournaments = tournamentDAO.getTournamentByOrganizer("1");
		for (Tournament tourney: tournaments) {
			if (tourney.getName() == "Timstourney"){
				retrievedTourney = tournamentDAO.getTournamentByID(tourney.getId());
			}
		}
		assertEquals(tournament.getId(), retrievedTourney.getId());
	}

	@Test
	public void testGetTournamentByTeam() {
		Team team = new Team();
		team.setId(4321);
		team.setName("timstestteam");
		team.setCaptainId(54321);
		Team team2 = new Team();
		team2.setId(321321);
		team2.setName("timsteam2");
		team2.setCaptainId(12345);
		teamDAO.createTeam(team);
		teamDAO.createTeam(team2);
		team = teamDAO.getTeamByName("timstestteam");
		Tournament tournament = new Tournament();
		Tournament retrievedTourney = new Tournament();
		tournament.setName("Timstourney");
		tournament.setOrganizerId("1");
		tournament.setGame("54321");
		tournament.setType("call of duty");
		tournament.setDescription("tims tourney is fun");
		tournament.setDate(LocalDate.parse("2020-05-14"));
		tournamentDAO.create(tournament);
		MatchUp matchUp = new MatchUp(tournament.getId(), 
				"2", "4321", "321321", "1234 main st", "2020-06-03", "21:21", "4321", "321321");
		matchUpDAO.createMatchup(matchUp);
		List<Tournament> tournaments = tournamentDAO.getTournamentByTeam(String.valueOf(team.getId()));
		assertTrue(tournaments.get(0).equals(tournament));
		

	}

	@Test
	public void testGetTournamentByGame() {
		Tournament tournament = new Tournament();
		tournament.setName("Timstourney");
		tournament.setOrganizerId("1");
		tournament.setGame("Call of Duty");
		tournament.setType("single");
		tournament.setDescription("tims tourney is fun");
		tournament.setDate(LocalDate.parse("2020-05-14"));
		tournamentDAO.create(tournament);
		List<Tournament> tournaments = tournamentDAO.getTournamentByGame("Call of Duty");
		Tournament toCheck = new Tournament();
		for (Tournament tourn : tournaments) {
			if(tourn.getName().equals("Timstourney")) {
				toCheck = tourn;
				break;
			}
		}
		System.out.println("" +  toCheck);
		
		assertTrue(toCheck.equals(tournament));
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
