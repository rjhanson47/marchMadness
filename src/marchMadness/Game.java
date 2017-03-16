package marchMadness;

import java.util.Map;

import marchMadness.db.RankPoints;
import marchMadness.db.SqliteConnection;
import marchMadness.db.Team;

/**
 * March Madness
 * @author Jin and Robert
 *
 */
public class Game {
	
	private int round;
	private Team teamA;
	private Team teamB;
	private double teamATotalWeight;
	private double teamBTotalWeight;
	private int season;
	private Map<String, RankPoints> rankPointMap;
	
	public Game(int round, Team teamA, Team teamB, int season, Map<String, RankPoints> map) {
		this.round = round;
		this.teamA = teamA;
		this.teamB = teamB;
		this.season = season;
		rankPointMap = map;
		teamATotalWeight = 0.0;
		teamBTotalWeight = 0.0;
	}
	
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public Team getTeamA() {
		return teamA;
	}
	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}
	public Team getTeamB() {
		return teamB;
	}
	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}
	public double getTeamATotalWeight() {
		if(teamATotalWeight == 0.0) {
			double wLYear = 0.0;
			double wL2Year = 0.0;
			double wL3Year = 0.0;
			if(SqliteConnection.didATeamWinBTeamOnSeason(teamA.getTeamId(), teamB.getTeamId(), season - 1 + "")) {
				wLYear = 0.8;
			}
			
			if(SqliteConnection.didATeamWinBTeamOnSeason(teamA.getTeamId(), teamB.getTeamId(), season - 2 + "")) {
				wL2Year = 0.6;
			}
			
			if(SqliteConnection.didATeamWinBTeamOnSeason(teamA.getTeamId(), teamB.getTeamId(), season - 3 + "")) {
				wL3Year = 0.3;
			}
			
			teamATotalWeight += wLYear + wL2Year + wL3Year;
			teamATotalWeight += SqliteConnection.getTeamAverageStatusById(teamA.getTeamId()).teamStatus();
			teamATotalWeight += rankPointMap.get(teamA.getTeamId()).getNormalizedRankPoint() * 0.5;
			teamATotalWeight += SqliteConnection.getRankPointByTeamId(teamA.getTeamId());
			return teamATotalWeight;
		} else {
			return teamATotalWeight;
		}
	}
	public void setTeamATotalWeight(double teamATotalWeight) {
		this.teamATotalWeight = teamATotalWeight;
	}
	public double getTeamBTotalWeight() {
		if(teamBTotalWeight == 0.0) {
			double wLYear = 0.0;
			double wL2Year = 0.0;
			double wL3Year = 0.0;
			if(SqliteConnection.didATeamWinBTeamOnSeason(teamB.getTeamId(), teamA.getTeamId(), season - 1 + "")) {
				wLYear = 0.8;
			}
			
			if(SqliteConnection.didATeamWinBTeamOnSeason(teamB.getTeamId(), teamA.getTeamId(), season - 2 + "")) {
				wL2Year = 0.6;
			}
			
			if(SqliteConnection.didATeamWinBTeamOnSeason(teamB.getTeamId(), teamA.getTeamId(), season - 3 + "")) {
				wL3Year = 0.3;
			}
			
			teamBTotalWeight += wLYear + wL2Year + wL3Year;
			teamBTotalWeight += SqliteConnection.getTeamAverageStatusById(teamB.getTeamId()).teamStatus();
			teamBTotalWeight += rankPointMap.get(teamB.getTeamId()).getNormalizedRankPoint() * 0.5;
			teamBTotalWeight += SqliteConnection.getRankPointByTeamId(teamB.getTeamId());
			return teamBTotalWeight;
		} else {
			return teamBTotalWeight;
		}
	}
	public void setTeamBTotalWeight(double teamBTotalWeight) {
		this.teamBTotalWeight = teamBTotalWeight;
	}
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public Team winnerTeam() {
		if(getTeamATotalWeight() > getTeamBTotalWeight()) {
			return teamA;
		}
		if(getTeamBTotalWeight() > getTeamATotalWeight()) {
			return teamB;
		}
		return null;
	}
}
