package gamaset.sonicboot.scrapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import gamaset.sonicboot.service.objectpages.GameToday;
import gamaset.sonicboot.service.objectpages.GamesTodayPage;

@Component
public class AcademiaDasApostasScrapper {
	
	
	private String path = "https://www.academiadasapostas.com/";
	
	private Document doc;
	
	
	public GamesTodayPage read(){
		
		GamesTodayPage games = new GamesTodayPage();

		try{
			
			InputStream input = getClass().getResourceAsStream("/html/academia.html");
			doc = Jsoup.parse(input, "utf-8", "https://www.academiadasapostas.com");
			
			games.setGamesToday(new ArrayList<>());
			
			Element tableGames = doc.select("table[class=competition-today dskt]").first()
									.select("tbody").first();
			
			Elements trGames = tableGames.select("tr[type=match]");
			
			for (Element trGame : trGames) {
				GameToday game = new GameToday();
				game.setHomeTeam(trGame.select("td[class^=team-a]").first().text());
				game.setAwayTeam(trGame.select("td[class^=team-b]").first().text());
				game.setLinkGame(trGame.select("td[class^=score]").first().select("a").first().attr("href"));
				games.getGamesToday().add(game);
			}
			
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return games;

	}
	
}
