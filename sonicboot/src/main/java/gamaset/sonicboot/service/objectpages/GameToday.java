package gamaset.sonicboot.service.objectpages;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class GameToday {

	private String homeTeam;
	private String awayTeam;
	private String linkGame;

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public String getLinkGame() {
		return linkGame;
	}

	public void setLinkGame(String linkGame) {
		this.linkGame = linkGame;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
