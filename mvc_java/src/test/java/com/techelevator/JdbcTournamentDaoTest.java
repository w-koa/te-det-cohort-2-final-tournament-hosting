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
		List<Tournament> tournaments = tournamentDAO.getTournamentByOrganizer("1");
		for (Tournament tourney : tournaments) {
			if (tourney.getName() == tournament.getName()) {
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
		List<Tournament> tournaments = tournamentDAO.getTournamentByOrganizer("1");
		for (Tournament tourney : tournaments) {
			if (tourney.getName() == "Timstourney") {
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
		List<Tournament> tournaments = tournamentDAO.getTournamentByOrganizer("1");
		for (Tournament tourney : tournaments) {
			if (tourney.getName() == "Timstourney") {
				retrievedTourney = tournamentDAO.getTournamentByID(tourney.getId());
			}
		}
		assertEquals(tournament.getId(), retrievedTourney.getId());
	}

	@Test
	public void testGetTournamentByTeam() {
		Team team = new Team();
//		team.setId(4321);
		team.setName("Topicblab");
		team.setCaptainId(44);
		Team team2 = new Team();
//		team2.setId(321321);
		team2.setName("Photolist");
		team2.setCaptainId(35);
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
		MatchUp matchUp2 = new MatchUp();
		matchUp2.setTournamentId(tournament.getId());
		matchUp2.setGameId("6");
		matchUp2.setTeamId1(String.valueOf(team.getId()));
		matchUp2.setTeamId2(String.valueOf(team2.getId()));
		matchUp2.setLocation("456 main st");
		matchUp2.setDate("2023-04-03");
		matchUp2.setTime("20:20");
		matchUp2.setWinnerId(String.valueOf(team.getId()));
		matchUp2.setLoserId(String.valueOf(team2.getId()));
		matchUpDAO.createMatchup(matchUp2);
		List<Tournament> tournaments = tournamentDAO.getTournamentByTeam(String.valueOf(team.getId()));
		assertTrue(tournaments.get(0).getName().equals(tournament.getName()));
	}

	@Test
	public void testGetTournamentByGame() {
		Tournament tournament = new Tournament();
		tournament.setName("BobsTourney");
		tournament.setOrganizerId("11");
		tournament.setGame("Duty of Call");
		tournament.setType("tripple");
		tournament.setDescription("Fun Tourney at Tims");
		tournament.setDate(LocalDate.parse("2023-06-18"));
		tournamentDAO.create(tournament);
		List<Tournament> tournaments = tournamentDAO.getTournamentByGame("Duty of Call");
		Tournament toCheck = new Tournament();
		for (Tournament tourn : tournaments) {

			if (tourn.getName().equals("BobsTourney")) {
				toCheck = tourn;
				System.out.println(toCheck.getName());
				break;
			}
		}
		System.out.println(tournament.getName());
		assertTrue(toCheck.getName().equals(tournament.getName()));
	}

	@Test
	public void testDelete() {
		Tournament tournament = new Tournament();
		tournament.setName("Tourney one");
		tournament.setOrganizerId("1");
		tournament.setGame("2469");
		tournament.setType("Assasins Creed");
		tournament.setDate(LocalDate.parse("2025-02-02"));
		tournament.setDescription("FuntimeTourney");
		tournamentDAO.create(tournament);
		List<Tournament> tournamentList = tournamentDAO.getAllTournaments();
		String tourneyId = "";
		for (Tournament tourney : tournamentList) {
			System.out.println(tourney.getName());
			if (tourney.getName() == "Tourney one") {
				tourneyId = tourney.getId();
			}
		}
		if (tourneyId == "") {
			System.out.println("print anything");
		}
		tournamentDAO.delete(tourneyId);
		assertNull(tournamentDAO.getTournamentByID(tourneyId));
	}
	
	
	
	
	
	
	
}
