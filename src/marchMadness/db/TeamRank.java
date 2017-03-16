package marchMadness.db;

/**
 * March Madness
 * @author Jin and Robert
 *
 */
public class TeamRank {
	
	private int id;
	private String teamName;
	private String teamId;
	private int rank;
	private String region;
	
	public TeamRank(int id, String teamName, String teamId, int rank, String region) {
		this.id = id;
		this.teamName = teamName;
		this.teamId = teamId;
		this.rank = rank;
		this.region = region;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
