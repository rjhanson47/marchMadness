package marchMadness.db;

/**
 * March Madness
 * @author Jin and Robert
 *
 */
public class RankPoints {
	
	private String teamid;
	private double totalRankPoint;
	private double normalizedRankPoint;

	public RankPoints(String teamid) {
		this.teamid = teamid;
	}
	
	public String getTeamid() {
		return teamid;
	}
	public void setTeamid(String teamid) {
		this.teamid = teamid;
	}
	public double getTotalRankPoint() {
		return totalRankPoint;
	}
	public void setTotalRankPoint(double totalRankPoint) {
		this.totalRankPoint = totalRankPoint;
	}
	public double getNormalizedRankPoint() {
		return normalizedRankPoint;
	}
	public void setNormalizedRankPoint(double normalizedRankPoint) {
		this.normalizedRankPoint = normalizedRankPoint;
	}
}
