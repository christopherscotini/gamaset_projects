package gamaset.sonicboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gamaset.sonicboot.scrapper.AcademiaDasApostasScrapper;
import gamaset.sonicboot.service.objectpages.GamesTodayPage;

/**
 * 
 * @author chris
 * 
 * @since 0.0.1
 *
 */
@Service
public class ReadGamesTodayService {

	@Autowired
	private AcademiaDasApostasScrapper scrapper;

	public GamesTodayPage read() {

		GamesTodayPage gamesToday = scrapper.read();

		gamesToday.getGamesToday().stream().forEach(System.out::println);
		
		return gamesToday;
	}
}
