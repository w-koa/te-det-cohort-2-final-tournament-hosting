package com.techelevator;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.model.MatchUpModel.JDBCMatchUpDAO;
import com.techelevator.model.TeamModel.JDBCTeamDAO;
import com.techelevator.model.MatchUpModel.MatchUp;
import com.techelevator.model.TeamModel.Team;
import com.techelevator.model.TournamentModel.JDBCTournamentDAO;
import com.techelevator.model.TournamentModel.Tournament;

public class JdbcMatchUpDaoTest {

	private static SingleConnectionDataSource dataSource;
	
	private static JDBCMatchUpDAO matchUpDao;
	private static JDBCTeamDAO teamDao;
	private static JDBCTournamentDAO tournamentDao;
	
	private Team team_one;
	private Team team_two;
	private Tournament tourny;
	private MatchUp matchup = new MatchUp();
	private Tournament tournament;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/capstone");
		dataSource.setUsername("capstone_appuser");
		dataSource.setPassword("capstone_appuser1");
//		dataSource.setUsername("postgres");
//		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
		teamDao = new JDBCTeamDAO(dataSource);
		matchUpDao = new JDBCMatchUpDAO(dataSource);
		tournamentDao = new JDBCTournamentDAO(dataSource);
	}
	
	@Before
	public void setupData() {
		Team teamOne = new Team();
		teamOne.setName("capstone_tim");
		teamOne.setCaptainId(44);
		Team teamTwo = new Team();
		teamTwo.setName("capstone_timTwo");
		teamTwo.setCaptainId(35);
		tournament = new Tournament();
		tournament.setName("TimvsTim");
		tournament.setOrganizerId("10");
		tournament.setDate(LocalDate.of(1999, 12, 20));
		tournament.setGame("BioShock");
		tournament.setFormat("single");
		tournament.setDescription("Tim vvs Tim");
		teamDao.createTeam(teamOne);
		teamDao.createTeam(teamTwo);
		tournamentDao.create(tournament);
		team_one = teamDao.getTeamByName("capstone_tim");
		team_two = teamDao.getTeamByName("capstone_timTwo");
		List<Tournament> list = tournamentDao.getAllTournaments();
		for (Tournament tor : list) {
			if (tor.getName().equals("TimvsTim")) {
				tourny = tor;
				break;
			}
		}
		MatchUp matchUp = new MatchUp();
		matchUp.setTeamId1(String.valueOf(team_one.getId()));
		matchUp.setTeamId2(String.valueOf(team_two.getId()));
		matchUp.setTournamentId(String.valueOf(tourny.getId()));
		matchUp.setGameId("5");
		matchUp.setLocation("Downtown");
		matchUp.setDate("1999-12-20");
		matchUp.setTime("20:11");
		matchUp.setWinnerId(String.valueOf(team_one.getId()));
		matchUp.setLoserId(String.valueOf(team_two.getId()));
		matchUpDao.createMatchup(matchUp);
		List<MatchUp> matchupList = matchUpDao.getAllMatchups();
		for (MatchUp match : matchupList) {
			if (match.getLocation().equals(matchUp.getLocation()) && match.getDate().equals(matchUp.getDate())) {
				matchup = match;
				break;
			}
		}

	}
	
	@After 
	public void afterTests() {
		teamDao.deleteTeam(team_one);
		teamDao.deleteTeam(team_two);
		matchUpDao.delete(matchup);
	}
	
	@Test
	public void testCreateMatchup() {
		List<MatchUp> toCheckList = matchUpDao.getAllMatchups();
		MatchUp toCheck = null;
		for (MatchUp m : toCheckList) {
			if (m.getLocation().equals("Downtown")) {
				toCheck = m;
			}
		}
		MatchUp check = matchUpDao.getMatchByMatchUpId(matchup.getMatchUpId());
		assertEquals(toCheck, check);
	}

	@Test
	public void testGetMatchByMatchUpId() {
		List<MatchUp> toCheckList = matchUpDao.getMatchUpsByTournamentId(tourny.getId());
		MatchUp toCheck = new MatchUp();
		for (MatchUp m : toCheckList) {
			if (m.getLocation().equals("Downtown")) {
				toCheck = m;
			}
		}
		MatchUp expected = matchUpDao.getMatchByMatchUpId(toCheck.getMatchUpId());
		assertEquals(toCheck, expected);
	}

	@Test
	public void testGetWinsByTeam() {
		int wins = matchUpDao.getWinsByTeam(String.valueOf(team_one.getId()));
		assertTrue(wins == 1);
	}

	@Test
	public void testGetLossesByTeam() {
		int losses = matchUpDao.getLossesByTeam(String.valueOf(team_two.getId()));
		assertTrue(losses == 1);
	}

	@Test
	public void testGetTournamentWinsByTeam() {
		int wins = matchUpDao.getTournamentWinsByTeam(String.valueOf(team_one.getId()), tourny.getId());
		int secondTeamWins = matchUpDao.getTournamentWinsByTeam(String.valueOf(team_two.getId()), tourny.getId());
		assertTrue(wins == 1);
		assertTrue(secondTeamWins == 0);
	}

	@Test
	public void testGetTournamentLossesByTeam() {
		int losses = matchUpDao.getTournamentLossesByTeam(String.valueOf(team_two.getId()), tourny.getId());
		int secondTeamLosses = matchUpDao.getTournamentLossesByTeam(String.valueOf(team_one.getId()), tourny.getId());
		assertTrue(losses == 1);
		assertTrue(secondTeamLosses == 0);
	}

	@Test
	public void testGetMatchUpsByTournamentId() {
		List<MatchUp> list = matchUpDao.getMatchUpsByTournamentId(tourny.getId());
		assertTrue(list.size() == 1);
		assertTrue(list.get(0).equals(matchup));
	}

	@Test
	public void testDelete() {
		matchUpDao.delete(matchup);
		MatchUp check = matchUpDao.getMatchByMatchUpId(matchup.getMatchUpId());
		assertEquals(check, null);
	}

	@Test
	public void testGetMatchUpsByTeamId() {
		List<MatchUp> list = matchUpDao.getMatchUpsByTeamId(String.valueOf(team_one.getId()));
		List<MatchUp> listTwo = matchUpDao.getMatchUpsByTeamId(String.valueOf(team_two.getId()));
		assertTrue(list.size() == 1);
		assertTrue(listTwo.size() == 1);
		assertEquals(list.get(0), matchup);
		assertEquals(listTwo.get(0), matchup);
	}
	
	@Test
	public void TestGetTeamsForTournament() {
		List<Integer> list = matchUpDao.getTeamsForTournament(tourny.getId());
		assertTrue(list.size() == 2);
		assertTrue(list.get(0) == team_one.getId());
		assertTrue(list.get(1) == team_two.getId());
	}
}
