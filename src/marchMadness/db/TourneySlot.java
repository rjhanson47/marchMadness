package marchMadness.db;

/**
 * March Madness
 * @author Jin and Robert
 *
 */
public class TourneySlot {
	
	private String season;
	private String slot;
	private String strongseed;
	private String weakseed;
	
	public TourneySlot (String season, String slot, String strongseed, String weakseed) {
		this.season = season;
		this.slot = slot;
		this.strongseed = strongseed;
		this.weakseed = weakseed;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getStrongseed() {
		return strongseed;
	}

	public void setStrongseed(String strongseed) {
		this.strongseed = strongseed;
	}

	public String getWeakseed() {
		return weakseed;
	}

	public void setWeakseed(String weakseed) {
		this.weakseed = weakseed;
	}

}
