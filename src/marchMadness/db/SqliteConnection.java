package marchMadness.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * March Madness
 * @author Jin and Robert
 *
 */
public class SqliteConnection {
	
	protected static Connection connection;
	private String url;
	
	public SqliteConnection(String path) {
		url = "jdbc:sqlite:" + path;
		connect();
	}
	
	public void connect() {
        try {
            connection = DriverManager.getConnection(url);  
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public void close() {
		try {
            if (connection != null) {
            	connection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
	}
	
	public Map<String,RankPoints> getAllTeamsRankPoint(){
        String sql = "SELECT teamid FROM TeamRank";
        List<RankPoints> trplist = new ArrayList<RankPoints>();
        try {
        	Statement stmt = connection.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
    		while(rs.next()) {
    			RankPoints team = new RankPoints(rs.getInt("teamId")+"");
    			trplist.add(team);
    		}
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
		}
        double min = 0.0;
        double max = 0.0;
        for(int i = 0; i < trplist.size(); i++) {
        	double totalPoint = getStrengthOfSchedule(trplist.get(i).getTeamid());
        	trplist.get(i).setTotalRankPoint(totalPoint);
        	if(i == 0) {
        		min = totalPoint;
        		max = totalPoint;
        	} else {
        		min = min < totalPoint? min : totalPoint;
        		max = max > totalPoint? max : totalPoint;
        	}
        }
        Map<String,RankPoints> map = new HashMap<String, RankPoints>();
        for(RankPoints rp : trplist) {
        	rp.setNormalizedRankPoint((rp.getTotalRankPoint() - min)/(max - min));
        	map.put(rp.getTeamid(), rp);
        }
        return map;
	}
	
	public List<TeamRank> getAllTeamRank() {
		String sql = "SELECT * FROM TeamRank";
        List<TeamRank> teams = new ArrayList<TeamRank>();
        try {
        	Statement stmt = connection.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
    		while(rs.next()) {
    			TeamRank team = new TeamRank(rs.getInt("id"), rs.getString("teamName"),rs.getInt("teamId") + "", rs.getInt("rank"), rs.getString("region"));
    			teams.add(team);
    		}
        } catch (SQLException e) {
        	e.printStackTrace();
		}
        return teams;
	}
	
	public Team getTeamById (String teamId) {
		String sql = "select * from teams where teamId=?";
		Team team = null;
		try {
			PreparedStatement pstmt  = connection.prepareStatement(sql);
	        pstmt.setInt(1, Integer.parseInt(teamId));
	        ResultSet rs = pstmt.executeQuery();
	        while(rs.next()) {
	        	team = new Team(rs.getInt("teamId") + "", rs.getString("teamName"));
	        }
		}  catch (SQLException e) {
        	System.out.println(e.getMessage());
		}
		return team;
	}
	
	public Team getTeamByName (String teamName) {
		String sql = "select * from teams where teamName=?";
		Team team = null;
		try {
			PreparedStatement pstmt  = connection.prepareStatement(sql);
	        pstmt.setString(1, teamName);
	        ResultSet rs = pstmt.executeQuery();
	        while(rs.next()) {
	        	team = new Team(rs.getInt("teamId") + "", rs.getString("teamName"));
	        }
		}  catch (SQLException e) {
        	System.out.println(e.getMessage());
		}
		return team;
	}
	
	public static boolean didATeamWinBTeamOnSeason(String aTeamId, String bTeamId, String season) {
		String sql = "select * from RegularSeasonResultsDetail where wteam=? and lteam=? and season=?";
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, aTeamId);
			pstmt.setString(2, bTeamId);
			pstmt.setInt(3, Integer.parseInt(season));
			rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static TeamAvgStatus getTeamAverageStatusById(String teamId){
		String sql = "select * from(select a.team, avg(a.nor) as anor, avg(a.ndr) as andr, avg(a.nstl) as anstl, avg(a.nto) as anto, avg(a.ntrdif) as antrdif " +
				"from(select *, ((wa.ordif + wa.drdif - (-31.0))/(48.0 - (-31.0))) as ntrdif " +
				"from (select season, wteam as team," +
				"(wor - ldr) as ordif," +
				"(wdr - lor) as drdif," +
				"((wor - 0.0)/(0.0 - 38.0)) as nor," +
				"((wdr - 5.0)/(5.0 - 50.0)) as ndr," +
				"((wstl - 0.0)/(0.0 - 26.0)) as nstl," +
				"((wto - 1.0)/(1.0 - 33.0)) as nto " +
				"from RegularSeasonResultsDetail) wa " +
				"union " +
				"select *, ((la.ordif + la.drdif - (-31.0))/(48.0 - (-31.0))) as ntrdif " +
				"from (select season, lteam as team," +
				"(lor - wdr) as ordif," +
				"(ldr - wor) as drdif," +
				"((lor - 0.0)/(0.0 - 38.0)) as nor," +
				"((ldr - 5.0)/(5.0 - 50.0)) as ndr," +
				"((lstl - 0.0)/(0.0 - 26.0)) as nstl," +
				"((lto - 1.0)/(1.0 - 33.0)) as nto " +
				"from RegularSeasonResultsDetail) la) a " +
				"group by a.team) " +
				"where team =?";
		ResultSet rs = null;
		TeamAvgStatus tAvgStatus = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(teamId));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tAvgStatus = new TeamAvgStatus(rs.getInt("team") + "", rs.getDouble("anor"), rs.getDouble("andr"), rs.getDouble("anstl"), rs.getDouble("anto"), rs.getDouble("antrdif"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tAvgStatus;
	}
	
	public static double getStrengthOfSchedule(String teamId) {
		double result = 0.0;
		
		String sql = "select sum(point) as totalPoints " + 
				"from(select team, Rank, " +
				"case when Rank is null then 0 else 17 - Rank end as point " + 
				"from(select * " + 
				"from(select id, wteam as team " + 
				"from(select * from RegularSeasonResultsDetail where (wteam = ? or lteam = ?) and season = 2016) " +
				"where wteam != ? " +
				"union " +
				"select id, lteam as team " +
				"from(select * from RegularSeasonResultsDetail where (wteam = ? or lteam = ?) and season = 2016) " +
				"where lteam != ?) a " +
				"left join " +
				"(select * from TeamRank) b on a.team = b.teamId))";
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(teamId));
			pstmt.setInt(2, Integer.parseInt(teamId));
			pstmt.setInt(3, Integer.parseInt(teamId));
			pstmt.setInt(4, Integer.parseInt(teamId));
			pstmt.setInt(5, Integer.parseInt(teamId));
			pstmt.setInt(6, Integer.parseInt(teamId));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getDouble("totalPoints");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static double getMinPoints(String teamid) {
		double point = 0.0;
		String sql = "select min(points) as points " + 
					"from (" + 
					"select team, Rank," +
					"case when Rank is null then 0 else 17 - Rank end as points " + 
					"from(select * " +
					"from(select id, wteam as team " + 
					"from(select * from RegularSeasonResultsDetail where (wteam = ? or lteam = ?) and season = 2016) " +
					"where wteam != ? " + 
					"union " +
					"select id, lteam as team " +
					"from(select * from RegularSeasonResultsDetail where (wteam = ? or lteam = ?) and season = 2016) " +
					"where lteam != ?) a " +
					"left join " +
					"(select * from TeamRank) b on a.team = b.teamId))";
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(teamid));
			pstmt.setInt(2, Integer.parseInt(teamid));
			pstmt.setInt(3, Integer.parseInt(teamid));
			pstmt.setInt(4, Integer.parseInt(teamid));
			pstmt.setInt(5, Integer.parseInt(teamid));
			pstmt.setInt(6, Integer.parseInt(teamid));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				point = rs.getDouble("points");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return point;
	}
	
	public static double getMaxPoints(String teamid) {
		double point = 0.0;
		String sql = "select max(points) as points " + 
					"from (" + 
					"select team, Rank," +
					"case when Rank is null then 0 else 17 - Rank end as points " + 
					"from(select * " +
					"from(select id, wteam as team " + 
					"from(select * from RegularSeasonResultsDetail where (wteam = ? or lteam = ?) and season = 2016) " +
					"where wteam != ? " + 
					"union " +
					"select id, lteam as team " +
					"from(select * from RegularSeasonResultsDetail where (wteam = ? or lteam = ?) and season = 2016) " +
					"where lteam != ?) a " +
					"left join " +
					"(select * from TeamRank) b on a.team = b.teamId))";
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(teamid));
			pstmt.setInt(2, Integer.parseInt(teamid));
			pstmt.setInt(3, Integer.parseInt(teamid));
			pstmt.setInt(4, Integer.parseInt(teamid));
			pstmt.setInt(5, Integer.parseInt(teamid));
			pstmt.setInt(6, Integer.parseInt(teamid));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				point = rs.getDouble("points");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return point;
	}
	
	public static double getRankPointByTeamId(String teamId) {
		double point = 0.0;
		String sql = "select nPoints from (select *, (points - 1) / 15.0 as nPoints from (select *, case when Rank is null then 0 else 17 - Rank end as points from TeamRank)) where teamId = ?";
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(teamId));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				point = rs.getDouble("nPoints");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return point;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String toString() {
		if(connection == null) {
			return "no sqlite db connection";
		} else {
			return url;
		}
	}
}
