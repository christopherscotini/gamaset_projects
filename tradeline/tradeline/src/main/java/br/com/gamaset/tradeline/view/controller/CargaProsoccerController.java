package br.com.gamaset.tradeline.view.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.tradeline.exception.BusinessException;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.TimeEntity;
import br.com.gamaset.tradeline.model.prosoccer.CompeticaoPSEntity;
import br.com.gamaset.tradeline.model.prosoccer.TimePSEntity;
import br.com.gamaset.tradeline.utils.GoalUtils;
import br.com.gamaset.tradeline.utils.ProsoccerUtils;


@ManagedBean
@SessionScoped
public class CargaProsoccerController extends AbstractController{


	private final String TELA_CARGA_TIME = PATH_PAGES+"/cargaprosoccer/cargaprosoccer-list.xhtml";
	
	private List<PaisEntity> paisList;
	private PaisEntity paisSelecionado;
	private String urlInput;
	private List<CompeticaoPSEntity> competicaoList;
	private List<TimePSEntity> timeList;
	
	
	
	@Override
	public String iniciarTela() {
		timeList = null;
		urlInput = null;
		
//		paisList = paisService.listarTodos();
//		setPaisSelecionado(paisList.get(0));
		
		return TELA_CARGA_TIME;
	}


	public void lerCampeonatoProssocer(){
		competicaoList = ProsoccerUtils.lerCompeticao(urlInput);
		for (int i = 0; i < competicaoList.size(); i++) {
			try{
				competicaoPSService.adicionarEntidade(competicaoList.get(i));
			}catch(BusinessException b){
				System.out.println(">> "+b.getMessage()+" <<");
			}
		}
	}

	public void lerTimeProssocer(){
		
		timeList = ProsoccerUtils.lerTimes(urlInput);
		
		List<TimePSEntity> ts = new ArrayList<TimePSEntity>();
		
		for (int i = 0; i < timeList.size(); i++) {
			TimePSEntity t = timeList.get(i);
			try{
				CompeticaoPSEntity comp = competicaoPSService.buscarPorCodCompeticao(t.getCodigoCompeticao());
				if(comp != null){
					t.setPais(competicaoPSService.buscarPorCodCompeticao(t.getCodigoCompeticao()).getPais());
					timePSService.adicionarEntidade(t);
//					ts.add(t);
				}
			}catch(BusinessException b){
				System.out.println(">> "+b.getMessage()+" <<");
			}
			
		}

	}
	

	public List<PaisEntity> getPaisList() {
		return paisList;
	}

	public void setPaisList(List<PaisEntity> paisList) {
		this.paisList = paisList;
	}

	public PaisEntity getPaisSelecionado() {
		return paisSelecionado;
	}

	public void setPaisSelecionado(PaisEntity paisSelecionado) {
		this.paisSelecionado = paisSelecionado;
	}

	public String getUrlInput() {
		return urlInput;
	}

	public void setUrlInput(String urlInput) {
		this.urlInput = urlInput;
	}

	public List<TimePSEntity> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<TimePSEntity> timeList) {
		this.timeList = timeList;
	}


	public List<CompeticaoPSEntity> getCompeticaoList() {
		return competicaoList;
	}


	public void setCompeticaoList(List<CompeticaoPSEntity> competicaoList) {
		this.competicaoList = competicaoList;
	}
	
}
