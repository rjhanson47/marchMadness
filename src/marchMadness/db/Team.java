package marchMadness.db;

/**
 * March Madness
 * @author Jin and Robert
 *
 */
public class Team {
	
	private String teamId;
	private String teamName;
	
	public Team(String teamId, String teamName) {
		this.teamId = teamId;
		this.teamName = teamName;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + "]";
	}
}
