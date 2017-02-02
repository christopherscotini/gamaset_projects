package br.com.gamaset.tradeline.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.gamaset.tradeline.model.CompeticaoEntity;
import br.com.gamaset.tradeline.model.TimeEntity;

public class AsMelhoresApostasUtils {

	public static String PATH_IMG_TIMES = "C:/Desenvolvimento/eclipse-luna_pessoal/workspace/tradeline/src/main/webapp/resources/img/times/";
	public static String PATH_IMG_COMPETICAO = "C:/Desenvolvimento/eclipse-luna_pessoal/workspace/tradeline/src/main/webapp/resources/img/competicoes/";
	
	
	public static CompeticaoEntity lerCompeticao(String path){
		CompeticaoEntity ret = new CompeticaoEntity();
		Document doc;
		
		try {
//			TradelineUtils.authProxy();
			doc = Jsoup.connect(path).get();
			Element h1lElement = doc.select("h1[class=lighter]").get(0);
			Element imgElement = h1lElement.select("img").get(0);
			
			ret.setDescricao(h1lElement.text());
			ret.setUrlImg("resources/img/competicoes/".concat(imgElement.attr("src").substring(imgElement.attr("src").lastIndexOf("/")+1)));
			String pathImg = PATH_IMG_COMPETICAO.concat(imgElement.attr("src").substring(imgElement.attr("src").lastIndexOf("/")+1));
			try{
				TradelineUtils.saveImage(imgElement.attr("src"), pathImg);
			}catch(FileNotFoundException f){
				ret.setUrlImg(">>> NAO ENCONTRADO <<<");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return ret;
		
	}
	
	public static List<TimeEntity> lerTimes(String path){
		List<TimeEntity> ret = new ArrayList<TimeEntity>();
		Document doc;
		
		try {
//			TradelineUtils.authProxy();
			doc = Jsoup.connect(path).get();
			Element ulElement = doc.select("ul[class=teams-list]").get(0);
			Elements aElements = ulElement.select("a");
			for (Element a : aElements) {
				Element img = a.select("img").get(0);
//				System.out.println("\nsrc : " + img.attr("src"));
//				System.out.println("height : " + img.attr("height"));
//				System.out.println("width : " + img.attr("width"));
//				System.out.println("alt : " + img.attr("alt"));
//				System.out.println("destinationFile : " + PATH_IMG_PAISES.concat(img.attr("alt").concat(".png")));
				TimeEntity p = new TimeEntity();
				p.setDescricao(a.attr("title"));
				p.setUrlImg("resources/img/times/".concat(img.attr("src").substring(img.attr("src").lastIndexOf("/")+1)));
				String pathImg = PATH_IMG_TIMES.concat(img.attr("src").substring(img.attr("src").lastIndexOf("/")+1));
				try{
					TradelineUtils.saveImage(img.attr("src"), pathImg);
				}catch(FileNotFoundException f){
					p.setUrlImg(">>> NAO ENCONTRADO <<<");
				}
				ret.add(p);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return ret;
		
	}

	public static List<TimeEntity> lerTimesCalendario(String path) {
		List<TimeEntity> ret = new ArrayList<TimeEntity>();
		Document doc;
		
		try {
			TradelineUtils.authProxy();
			doc = Jsoup.connect(path).get();
			Element tableElement = doc.select("table[class=cc-matches col-6]").get(0);
			Elements trElements = tableElement.select("tr");
			
			for (int i = 1; i < trElements.size(); i++) {
				Elements tdElements = trElements.get(i).select("td");
					TimeEntity time = new TimeEntity();
					time.setUrlImg("resources/img/times/".concat(tdElements.get(0).select("img").get(0).attr("src").substring(tdElements.get(0).select("img").get(0).attr("src").lastIndexOf("/")+1)));
					time.setDescricao(tdElements.get(1).text());
					
					String pathImg = PATH_IMG_TIMES.concat(tdElements.get(0).select("img").get(0).attr("src").substring(tdElements.get(0).select("img").get(0).attr("src").lastIndexOf("/")+1));
					try{
						TradelineUtils.saveImage(tdElements.get(0).select("img").attr("src"), pathImg);
					}catch(FileNotFoundException f){
						time.setUrlImg(">>> NAO ENCONTRADO <<<");
					}
					
					ret.add(time);
					
					
					time = new TimeEntity();
					time.setDescricao(tdElements.get(4).text());
					time.setUrlImg("resources/img/times/".concat(tdElements.get(5).select("img").get(0).attr("src").substring(tdElements.get(5).select("img").get(0).attr("src").lastIndexOf("/")+1)));
					pathImg = PATH_IMG_TIMES.concat(tdElements.get(5).select("img").get(0).attr("src").substring(tdElements.get(5).select("img").get(0).attr("src").lastIndexOf("/")+1));
					try{
						TradelineUtils.saveImage(tdElements.get(5).select("img").attr("src"), pathImg);
					}catch(FileNotFoundException f){
						time.setUrlImg(">>> NAO ENCONTRADO <<<");
					}
					ret.add(time);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return ret;
	}
	
//	public static List<String> listarImages(String path) throws IOException { 
//		List<String>paths = new ArrayList<String>();
//		ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
//		String realPath = ctx.getRealPath("/");
//		File file = new File(realPath.concat(File.separator).concat(path)); 
//		File afile[] = file.listFiles(); 
//		for (int j = 0; j < afile.length; j++) {
//			File arquivos = afile[j]; 
//			paths.add(arquivos.getName());
//		}
//		return paths;
//	}
	
}
