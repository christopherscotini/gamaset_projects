package br.com.gamaset.tradeline.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.gamaset.tradeline.dto.prosoccer.JogoProsoccerDTO;
import br.com.gamaset.tradeline.dto.prosoccer.PalpiteEnun;
import br.com.gamaset.tradeline.model.depara.CompeticaoUnionEntity;
import br.com.gamaset.tradeline.model.depara.TimeUnionEntity;
import br.com.gamaset.tradeline.model.prosoccer.CompeticaoPSEntity;
import br.com.gamaset.tradeline.model.prosoccer.TimePSEntity;

public abstract class ProsoccerUtils {

	public static List<CompeticaoPSEntity> lerCompeticao(String path){
		List<CompeticaoPSEntity> ret = new ArrayList<CompeticaoPSEntity>();
		Document doc;
		Set<String> retAux = new HashSet<String>();
		try {
			TradelineUtils.authProxy();
			doc = Jsoup.connect(path).get();
			Element tbodylElement = doc.select("table[class=sortable]").get(0).select("tbody").get(0);
			Elements trElement = tbodylElement.select("tr");
			
			for (int i = 1; i < trElement.size(); i++) {
				retAux.add(StringUtils.trim(trElement.get(i).select("td").get(1).text()));
			}
			
			for (String str : retAux) {
				ret.add(new CompeticaoPSEntity(null, str, null, null));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return ret;
		
	}
	
	public static List<TimePSEntity> lerTimes(String path){
		List<TimePSEntity> ret = new ArrayList<TimePSEntity>();
		Document doc;
		Set<String> retAux = new HashSet<String>();
		try {
			TradelineUtils.authProxy();
			doc = Jsoup.connect(path).get();
			Element tbodylElement = doc.select("table[class=sortable]").get(0).select("tbody").get(0);
			Elements trElement = tbodylElement.select("tr");
			
			for (int i = 1; i < trElement.size(); i++) {
				String timeCasa = StringUtils.trim(trElement.get(i).select("td").get(2).select("pre").get(0).text()).split(" - ")[0];
				String timeVisitante = StringUtils.trim(trElement.get(i).select("td").get(2).select("pre").get(0).text()).split(" - ")[1];
				String codigoCompeticao = StringUtils.trim(trElement.get(i).select("td").get(1).text().substring(2));
				
				ret.add(new TimePSEntity(null, timeCasa , null, null, codigoCompeticao));
				ret.add(new TimePSEntity(null, timeVisitante , null, null, codigoCompeticao));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return ret;
		
	}

	public static List<JogoProsoccerDTO> lerJogosDia() {
		List<JogoProsoccerDTO> ret = new ArrayList<JogoProsoccerDTO>();
		Document doc;
		Set<String> retAux = new HashSet<String>();
		try {
			TradelineUtils.authProxy();
			StringBuilder url = new StringBuilder();
			url.append("http://www.prosoccer.gr/en/").append(DataUtils.extrairAnoData(new Date()));
			url.append("/").append(DataUtils.extrairMesData(new Date())).append("/soccer-predictions-");
			url.append(DataUtils.converterDataString(new Date(), "yyyy-MM-dd")).append(".html");
//			http://www.prosoccer.gr/en/2015/05/soccer-predictions-2015-05-11.html
			doc = Jsoup.connect(url.toString()).get();
			Element tbodylElement = doc.select("table[class=sortable]").get(0).select("tbody").get(0);
			Elements trElement = tbodylElement.select("tr");
			
			for (int i = 1; i < trElement.size(); i++) {
				TimePSEntity timeCasa = 
						new TimePSEntity(null
								, StringUtils.trim(trElement.get(i).select("td").get(2).select("pre").get(0).text()).split(" - ")[0]
										, null
										, null
										, StringUtils.trim(trElement.get(i).select("td").get(1).text().substring(2)));
				TimePSEntity timeVisitante = 
						new TimePSEntity(null
								, StringUtils.trim(trElement.get(i).select("td").get(2).select("pre").get(0).text()).split(" - ")[1]
										, null
										, null
										, StringUtils.trim(trElement.get(i).select("td").get(1).text().substring(2)));
				
				CompeticaoUnionEntity compUn = new CompeticaoUnionEntity();
				compUn.setCompeticaoProsoccer(new CompeticaoPSEntity(null, timeCasa.getCodigoCompeticao(), null, null));
				
				TimeUnionEntity tuC = new TimeUnionEntity(null, null, null, timeCasa, null);
				TimeUnionEntity tuV = new TimeUnionEntity(null, null, null, timeVisitante, null);
				
				try{
					Integer p1 = null;
					Integer p2 = null;
					Integer p3 = null;
					
					String probCasaAux1 = trElement.get(i).select("td").get(3).select("span").get(0).attr("class");
					probCasaAux1 = probCasaAux1.substring(probCasaAux1.lastIndexOf("_")+1);
					
					String probCasaAux2 = trElement.get(i).select("td").get(3).select("span").get(1).attr("class");
					probCasaAux2 = probCasaAux2.substring(probCasaAux2.lastIndexOf("_")+1);
					p1 = Integer.parseInt(verificaZeroProsoccer(probCasaAux1).concat(verificaZeroProsoccer( probCasaAux2 )));
					
					probCasaAux1 = trElement.get(i).select("td").get(4).select("span").get(0).attr("class");
					probCasaAux1 = probCasaAux1.substring(probCasaAux1.lastIndexOf("_")+1);
					probCasaAux2 = trElement.get(i).select("td").get(4).select("span").get(1).attr("class");
					probCasaAux2 = probCasaAux2.substring(probCasaAux2.lastIndexOf("_")+1);
					p2 = Integer.parseInt(verificaZeroProsoccer(probCasaAux1).concat(verificaZeroProsoccer( probCasaAux2 )));

					probCasaAux1 = trElement.get(i).select("td").get(5).select("span").get(0).attr("class");
					probCasaAux1 = probCasaAux1.substring(probCasaAux1.lastIndexOf("_")+1);
					probCasaAux2 = trElement.get(i).select("td").get(5).select("span").get(1).attr("class");
					probCasaAux2 = probCasaAux2.substring(probCasaAux2.lastIndexOf("_")+1);
					p3 = Integer.parseInt(verificaZeroProsoccer(probCasaAux1).concat(verificaZeroProsoccer( probCasaAux2 )));
					
					PalpiteEnun palpite = null;
					try{
						String palp = trElement.get(i).select("td").get(6).text().substring(1);
						palpite = verificaPalpite(palp.substring(1));
					}catch(Exception e){}
					
					ret.add(new JogoProsoccerDTO(compUn, tuC, tuV, p1, p2, p3, palpite));
				}catch(IndexOutOfBoundsException i1){
					continue;
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return ret;
		
	}
	
	
	private static PalpiteEnun verificaPalpite(String palpite){
		PalpiteEnun ret = null;
		if(palpite.equalsIgnoreCase("1")){
			return PalpiteEnun.TIME_CASA;
		}
		if(palpite.equalsIgnoreCase("1x")){
			return PalpiteEnun.TIME_CASA_EMPATE;
		}
		if(palpite.equalsIgnoreCase("x")){
			return PalpiteEnun.EMPATE;
		}
		if(palpite.equalsIgnoreCase("x2")){
			return PalpiteEnun.EMPATE_TIME_VISITANTE;
		}
		if(palpite.equalsIgnoreCase("2")){
			return PalpiteEnun.TIME_VISITANTE;
		}
		if(palpite.equalsIgnoreCase("12")){
			return PalpiteEnun.TIME_CASA_TIME_VISITANTE;
		}
		if(palpite.equalsIgnoreCase("21")){
			return PalpiteEnun.TIME_VISITANTE_TIME_CASA;
		}
		
		return PalpiteEnun.INDEFINIDO;
	}
	
	private static String verificaZeroProsoccer(String vlr){
		if(" ".equalsIgnoreCase(vlr)){
			return "0";
		}else{
			return vlr;
		}
	}
} 
