package marchMadness.db;

/**
 * March Madness
 * @author Jin and Robert
 *
 */
public class TeamAvgStatus {
	
	private String teamid;
	private double avgNorOR;
	private double avgNorDR;
	private double avgNorSTL;
	private double avgNorTO;
	private double avgNorTRDif;
	
	public TeamAvgStatus(String teamid, double avgNorOR, double avgNorDR, double avgNorSTL, double avgNorTO, double avgNorTRDif) {
		this.teamid = teamid;
		this.avgNorOR = avgNorOR;
		this.avgNorDR = avgNorDR;
		this.avgNorSTL = avgNorSTL;
		this.avgNorTO = avgNorTO;
		this.avgNorTRDif = avgNorTRDif;
	}

	public String getTeamid() {
		return teamid;
	}

	public void setTeamid(String teamid) {
		this.teamid = teamid;
	}

	public double getAvgNorOR() {
		return avgNorOR;
	}

	public void setAvgNorOR(double avgNorOR) {
		this.avgNorOR = avgNorOR;
	}

	public double getAvgNorDR() {
		return avgNorDR;
	}

	public void setAvgNorDR(double avgNorDR) {
		this.avgNorDR = avgNorDR;
	}

	public double getAvgNorSTL() {
		return avgNorSTL;
	}

	public void setAvgNorSTL(double avgNorSTL) {
		this.avgNorSTL = avgNorSTL;
	}

	public double getAvgNorTO() {
		return avgNorTO;
	}

	public void setAvgNorTO(double avgNorTO) {
		this.avgNorTO = avgNorTO;
	}

	public double getAvgNorTRDif() {
		return avgNorTRDif;
	}

	public void setAvgNorTRDif(double avgNorTRDif) {
		this.avgNorTRDif = avgNorTRDif;
	}
	
	public double teamStatus() {
		return avgNorOR + avgNorDR + avgNorSTL + avgNorTO + avgNorTRDif;
	}

}
