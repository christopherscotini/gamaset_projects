package gamaset.sonicboot.scrapper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AcademiaDasApostasScrapper {
	
	public static void main(String[] args) {
		AcademiaDasApostasScrapper scr = new AcademiaDasApostasScrapper();
        scr.read();
	}
	
	private String path = "https://www.academiadasapostas.com/";
	
	private Document doc;
	
	
	public void read(){
		try{
			
			doc = Jsoup.connect(path).get();
			
			Element tableGames = doc.select("table[class=competition-today dskt]").first()
									.select("tbody").first();
			Element trGame = tableGames.select("tr[type=match]").first();
			
			String link = trGame.select("td[class=score]").first()
					.select("a").first().attr("href");
					
			System.out.println(">> ".concat(link));
			
			doc = Jsoup.connect(link).post();
			
			Element tableLastResults = doc.select("div[id=ultimos_resultados]").first()
					.select("table").first();
			String test = tableLastResults.select("tr").first()
					.select("span[class=stats-title]").first().text();
			
			System.out.println(">> ".concat(test));
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
}
