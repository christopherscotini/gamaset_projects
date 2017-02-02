package br.com.gamaset.tradeline.view.controller;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.tradeline.exception.BusinessException;
import br.com.gamaset.tradeline.model.ApostaResultadoEnum;
import br.com.gamaset.tradeline.model.CompeticaoEntity;
import br.com.gamaset.tradeline.model.MercadoApostaEntity;
import br.com.gamaset.tradeline.model.MercadoApostaSelecaoEntity;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.PalpiteEntity;
import br.com.gamaset.tradeline.model.TimeEntity;
import br.com.gamaset.tradeline.model.TipsterEntity;
import br.com.gamaset.tradeline.view.utils.FacesUtils;


@ManagedBean
@SessionScoped
public class PalpiteController extends AbstractController{

	private final String TELA_PALPITE_LIST = "/content/palpite/palpite-list.xhtml";
	private final String TELA_PALPITE_EDIT = "/content/palpite/palpite-edit.xhtml";
	
	private List<PalpiteEntity> entities;
	private PalpiteEntity palpiteCadastrar;

	private List<PaisEntity> paisList;
	private PaisEntity paisSelecionada;
	private List<CompeticaoEntity> competicaoList;
	private CompeticaoEntity competicaoSelecionada;
	private List<TimeEntity> timeList;
	private TimeEntity timeSelecionado;
	private List<MercadoApostaSelecaoEntity> mercadoSelecaoList;
	private MercadoApostaSelecaoEntity mercadoSelecaoSelecionado;
	private List<MercadoApostaEntity> mercadoApostaList;
	private List<TipsterEntity> tipsterList;
	private ApostaResultadoEnum apostaResultadoFiltro;
	
	
	@Override
	public String iniciarTela() { 
		apostaResultadoFiltro = ApostaResultadoEnum.AINDA_POR_ACONTECER;
		
		entities = palpiteService.buscarPorApostaResultado(apostaResultadoFiltro);
		
		return TELA_PALPITE_LIST;
	}

	public void pesquisarPorResultado() { 
		entities = palpiteService.buscarPorApostaResultado(apostaResultadoFiltro);
	}

	public String navegarInserirPalpite(){
		palpiteCadastrar = new PalpiteEntity();
		palpiteCadastrar.setStatusPalpite(ApostaResultadoEnum.AINDA_POR_ACONTECER);
		paisList = paisService.listarTodosComCompeticaoAssociada();
		paisSelecionada = paisList.get(0);
		carregarComboCompeticao();
		mercadoSelecaoList = mercadoApostaSelecaoService.listarTodos();
		mercadoSelecaoSelecionado = mercadoSelecaoList.get(0);
		carregarComboMercadoAposta();
		palpiteCadastrar.setMercadoAposta(mercadoApostaList.get(0));
		palpiteCadastrar.setDataEvento(new Date());
		tipsterList = tipsterService.listarTodos();
		palpiteCadastrar.setTipster(tipsterList.get(0));
		
		return TELA_PALPITE_EDIT;
	}
	
	public String navegarDeletarPalpite(PalpiteEntity palpite){
		palpiteService.excluirEntidade(palpite);
		return iniciarTela();
	}

	public String navegarEditarPalpite(PalpiteEntity editar){
		palpiteCadastrar = editar;
		paisList = paisService.listarTodosComCompeticaoAssociada();
		paisSelecionada = editar.getCompeticao().getPais();
		carregarComboCompeticao();
		mercadoSelecaoList = mercadoApostaSelecaoService.listarTodos();
		mercadoSelecaoSelecionado = editar.getMercadoAposta().getSelecao();
		carregarComboMercadoAposta();
		palpiteCadastrar.setMercadoAposta(editar.getMercadoAposta());
		tipsterList = tipsterService.listarTodos();
		
		return TELA_PALPITE_EDIT;
	}
	
	public String salvar(){
		
		try{
			if (palpiteCadastrar.getId() == null) {
				palpiteService.adicionarEntidade(palpiteCadastrar);
			}else{
				palpiteService.editarEntidade(palpiteCadastrar);
			}
		}catch(BusinessException b){
			FacesUtils.addErrorMessage(b.getMessage());
		}
		
		return iniciarTela();
	}
	
	public void carregarComboCompeticao(){
		competicaoList = competicaoService.buscarPorPais(paisSelecionada);
		palpiteCadastrar.setCompeticao(palpiteCadastrar.getCompeticao()==null?competicaoList.get(0):palpiteCadastrar.getCompeticao());
		carregarComboTime();
	}
	public void carregarComboTime(){
		timeList = timeService.buscarPorPais(paisSelecionada);
		if(timeList != null && !timeList.isEmpty()){
			palpiteCadastrar.setTimeCasa(palpiteCadastrar.getTimeCasa()==null?timeList.get(0):palpiteCadastrar.getTimeCasa());
			palpiteCadastrar.setTimeVisitante(palpiteCadastrar.getTimeVisitante()==null?(timeList.size()>0?timeList.get(1):timeList.get(0)):palpiteCadastrar.getTimeVisitante());
		}
	}
	public void carregarComboMercadoAposta(){
		mercadoApostaList = mercadoApostaService.buscarPorMercadoSelecao(mercadoSelecaoSelecionado);
	}	
	
	public List<PalpiteEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<PalpiteEntity> entities) {
		this.entities = entities;
	}

	public PalpiteEntity getPalpiteCadastrar() {
		return palpiteCadastrar;
	}

	public void setPalpiteCadastrar(PalpiteEntity palpiteCadastrar) {
		this.palpiteCadastrar = palpiteCadastrar;
	}

	public List<CompeticaoEntity> getCompeticaoList() {
		return competicaoList;
	}

	public void setCompeticaoList(List<CompeticaoEntity> competicaoList) {
		this.competicaoList = competicaoList;
	}

	public List<TimeEntity> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<TimeEntity> timeList) {
		this.timeList = timeList;
	}

	public CompeticaoEntity getCompeticaoSelecionada() {
		return competicaoSelecionada;
	}

	public void setCompeticaoSelecionada(CompeticaoEntity competicaoSelecionada) {
		this.competicaoSelecionada = competicaoSelecionada;
	}

	public TimeEntity getTimeSelecionado() {
		return timeSelecionado;
	}

	public void setTimeSelecionado(TimeEntity timeSelecionado) {
		this.timeSelecionado = timeSelecionado;
	}

	public List<PaisEntity> getPaisList() {
		return paisList;
	}

	public void setPaisList(List<PaisEntity> paisList) {
		this.paisList = paisList;
	}

	public PaisEntity getPaisSelecionada() {
		return paisSelecionada;
	}

	public void setPaisSelecionada(PaisEntity paisSelecionada) {
		this.paisSelecionada = paisSelecionada;
	}

	public MercadoApostaSelecaoEntity getMercadoSelecaoSelecionado() {
		return mercadoSelecaoSelecionado;
	}

	public void setMercadoSelecaoSelecionado(MercadoApostaSelecaoEntity mercadoSelecaoSelecionado) {
		this.mercadoSelecaoSelecionado = mercadoSelecaoSelecionado;
	}

	public List<MercadoApostaEntity> getMercadoApostaList() {
		return mercadoApostaList;
	}

	public void setMercadoApostaList(List<MercadoApostaEntity> mercadoApostaList) {
		this.mercadoApostaList = mercadoApostaList;
	}

	public List<MercadoApostaSelecaoEntity> getMercadoSelecaoList() {
		return mercadoSelecaoList;
	}

	public void setMercadoSelecaoList(List<MercadoApostaSelecaoEntity> mercadoSelecaoList) {
		this.mercadoSelecaoList = mercadoSelecaoList;
	}

	public List<TipsterEntity> getTipsterList() {
		return tipsterList;
	}

	public void setTipsterList(List<TipsterEntity> tipsterList) {
		this.tipsterList = tipsterList;
	}

	public ApostaResultadoEnum getApostaResultadoFiltro() {
		return apostaResultadoFiltro;
	}

	public void setApostaResultadoFiltro(ApostaResultadoEnum apostaResultadoFiltro) {
		this.apostaResultadoFiltro = apostaResultadoFiltro;
	}
	
}
