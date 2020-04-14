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
	private Tournament tourny = new Tournament();
	private MatchUp matchup;
	private Tournament tournament;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/capstone");
//		dataSource.setUsername("capstone_appuser");
//		dataSource.setPassword("capstone_appuser1");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
		teamDao = new JDBCTeamDAO(dataSource);
		matchUpDao = new JDBCMatchUpDAO(dataSource);
		tournamentDao = new JDBCTournamentDAO(dataSource);
		
		
	}
	//  insert into match_up (tournament_id, game_id, team_id_1, team_id_2, location, date, time, winner_id, loser_id) values (1, 5, 2, 4, '11 E Walton St Chicago IL 60611', '2020/12/24', '20:17', 2, 4);
	@Before
	public void setupData() {
		System.out.println("setting up");
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
		System.out.println("TeamOne: " + team_one.getId());
		team_two = teamDao.getTeamByName("capstone_timTwo");
		List<Tournament> list = tournamentDao.getAllTournaments();
		System.out.println("size: " + list.size());
		for (Tournament tor : list) {
//			System.out.println(tor.getName());
			if (tor.getName().equals("TimvsTim")) {
				System.out.println("found");
				tourny = tor;
				break;
			}
		}
		System.out.println("tounry: " + tourny.getDescription());

		MatchUp matchUp = new MatchUp();
		matchUp.setTeamId1(String.valueOf(team_one.getId()));
		matchUp.setTeamId2(String.valueOf(team_two.getId()));
		matchUp.setTournamentId(String.valueOf(tourny.getId()));
		matchUp.setGameId("5");
		matchUp.setLocation("Downtown");
		matchUp.setDate("1999-12-20");
		matchUp.setTime("20:11");
		
		matchUpDao.createMatchup(matchUp);
		List<MatchUp> matchupList = matchUpDao.getAllMatchups();
		System.out.println("size: " + matchupList.size());
		for (MatchUp match : matchupList) {
			if (match.getLocation().equals(matchUp.getLocation()) && match.getDate().equals(matchUp.getDate())) {
				System.out.println("Found Matchup");
				matchup = match;
				break;
			}
		}

	}
	
	@After 
	public void afterTests() {
		teamDao.deleteTeam(team_one);
		teamDao.deleteTeam(team_two);
		tournamentDao.delete(tourny.getId());
		matchUpDao.delete(matchup);
	}
	
	@Test
	public void testCreateMatchup() {
		// 1, 5, 2, 4, '11 E Walton St Chicago IL 60611', '2020/12/24', '20:17', 2, 4

		List<MatchUp> toCheckList = matchUpDao.getMatchUpsByTournamentId(tourny.getId());
		MatchUp toCheck = new MatchUp();
		for (MatchUp m : toCheckList) {
			if (m.getLocation() == "Downtown" && m.getDate() == "1999-12-20") {
				toCheck = m;
			}
		}
		assertTrue(toCheck.getTeam1Name().equals(matchup.getTeam1Name()));
		assertTrue(toCheck.getTeam2Name().equals(matchup.getTeam2Name()));
		assertTrue(toCheck.getGameId().equals(matchup.getGameId()));
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
