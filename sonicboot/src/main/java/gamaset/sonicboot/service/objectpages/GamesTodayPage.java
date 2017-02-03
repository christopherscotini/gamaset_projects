package gamaset.sonicboot.service.objectpages;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class GamesTodayPage {

	private List<GameToday> gamesToday;

	public List<GameToday> getGamesToday() {
		return gamesToday;
	}

	public void setGamesToday(List<GameToday> gamesToday) {
		this.gamesToday = gamesToday;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
