package br.com.gamaset.tradeline.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.gamaset.tradeline.dto.jogosdia.JogoDiaDTO;
import br.com.gamaset.tradeline.dto.jogosdia.JogosDiaDTO;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.TimeEntity;
import br.com.gamaset.tradeline.model.depara.CompeticaoUnionEntity;
import br.com.gamaset.tradeline.model.depara.TimeUnionEntity;
import br.com.gamaset.tradeline.model.goal.CompeticaoGoalEntity;
import br.com.gamaset.tradeline.model.goal.TimeGoalEntity;

public abstract class GoalUtils {

	private static final String URL_LIVESCORE = "http://www.goal.com/br/live-scores?ICID=HP_TN_QL_3/";
	
	public static JogosDiaDTO lerJogosDia(){
		JogosDiaDTO jogosDia = new JogosDiaDTO();
		jogosDia.setJogos(new ArrayList<JogoDiaDTO>());
		Document doc;
		
		try {
			TradelineUtils.authProxy();
			doc = Jsoup.connect(URL_LIVESCORE).maxBodySize(0).timeout(10000).get();
			String divMain = doc.select("section[class=matchday]").get(0).attr("data-day");
			jogosDia.setDataJogos(new Date());
			Elements matches = doc.select("section[class=matchday]").get(0).select("table[class=matches]");
//			Element divMain = doc.select("section[class=matchday]").get(0).attr("data-day");
			for (int i = 0; i < matches.size(); i++) {
				PaisEntity pais = new PaisEntity();
				pais.setIdGoal(Long.parseLong(matches.get(i).attr("data-area-id")));
				CompeticaoGoalEntity competicaoGoal = new CompeticaoGoalEntity();
				competicaoGoal.setDescricao(matches.get(i).select("span[class=comp-title]").text());
				competicaoGoal.setPais(pais);
				
				Elements jogos = matches.get(i).select("tbody");
				for (int j = 0; j < jogos.size(); j++) {
					JogoDiaDTO dto = new JogoDiaDTO();
					dto.setCompeticao(new CompeticaoUnionEntity());
					dto.getCompeticao().setCompeticaoGoal(competicaoGoal);
					Elements detalhesJogo = jogos.get(j).select("td");
					dto.setStatus(detalhesJogo.get(0).select("span").text());//STATUS
					
					dto.setTimeCasa(new TimeUnionEntity(null, null, new TimeGoalEntity(null, detalhesJogo.get(1).select("span").text(), null, detalhesJogo.get(1).select("img").attr("src")), null, null));//TIME_CASA
					
					String vs = detalhesJogo.get(2).select("div").text();//VS
					if(!vs.contains("x")){
						String ars[] = vs.split("-");
						dto.setPlacarTimeCasa(Integer.parseInt(StringUtils.trim(ars[0])));
						dto.setPlacarTimeVisitante(Integer.parseInt(StringUtils.trim(ars[1])));
					}
					
					dto.setTimeVisitante(new TimeUnionEntity(null, null, new TimeGoalEntity(null, detalhesJogo.get(3).select("span").text(), null, detalhesJogo.get(3).select("img").attr("src")), null, null));//TIME_CASA
					dto.setUrlDetalhePartidaGoal(detalhesJogo.get(4).select("a").attr("href"));//MATCH-CENTRE
					jogosDia.getJogos().add(dto);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jogosDia;
	}

	public static List<TimeEntity> lerTimes(String path, boolean carregaImagem){
		List<TimeEntity> ret = new ArrayList<TimeEntity>();
		Document doc;
		
		
		try {
			TradelineUtils.authProxy();
			doc = Jsoup.connect(path).get();
			Element tableElement = doc.select("table[class=short]").get(doc.select("table[class=short]").size()-1).select("tbody").get(0);
//			Element tableElement = doc.select("table[class=short]").get(0).select("tbody").get(0);
			
			Elements trElements = tableElement.select("tr");
			
			for (int i = 0; i < trElements.size(); i++) {
				Element img = trElements.get(i).select("td[class=flag]").select("img").get(0);
				String descricao = trElements.get(i).select("td[class=legend team short]").select("a").get(0).text();
				TimeEntity p = new TimeEntity();
				p.setDescricao(descricao);
				p.setUrlImg("resources/img/times/".concat(img.attr("src").substring(img.attr("src").lastIndexOf("/")+1)));
				String pathImg = AsMelhoresApostasUtils.PATH_IMG_TIMES.concat(img.attr("src").substring(img.attr("src").lastIndexOf("/")+1));
				if(carregaImagem){
					try{
						TradelineUtils.saveImage(img.attr("src"), pathImg);
					}catch(FileNotFoundException f){
						p.setUrlImg(">>> NAO ENCONTRADO <<<");
					}
				}
				ret.add(p);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return ret;
		
	}
	
	public static void teste(){
		Document doc;
		
		try{
			TradelineUtils.authProxy();
			doc = Jsoup.connect("http://www.goal.com/br/competition/list/tables").get();
			Elements aElements = doc.select("div[data-tabcontent=clubs]").get(0).select("a[class=group-name]");
			for (int i = 0; i < aElements.size(); i++) {
				String id = aElements.get(i).select("span").attr("class").substring(aElements.select("span").attr("class").lastIndexOf("-")+1);
				String desc = aElements.get(i).select("strong").text();
				System.out.println(id+" - "+desc);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
} 
