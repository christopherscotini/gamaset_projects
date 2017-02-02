package br.com.gamaset.tradeline.view.controller;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.tradeline.exception.BusinessException;
import br.com.gamaset.tradeline.model.ApostaEntity;
import br.com.gamaset.tradeline.model.BetEntity;
import br.com.gamaset.tradeline.model.CompeticaoEntity;
import br.com.gamaset.tradeline.model.EventoEntity;
import br.com.gamaset.tradeline.model.MercadoApostaEntity;
import br.com.gamaset.tradeline.model.MercadoApostaSelecaoEntity;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.PalpiteEntity;
import br.com.gamaset.tradeline.model.PlanoJogoEntity;
import br.com.gamaset.tradeline.model.PlanoJogoItemEntity;
import br.com.gamaset.tradeline.model.TimeEntity;
import br.com.gamaset.tradeline.view.utils.FacesUtils;


@ManagedBean
@SessionScoped
public class ApostaBean extends AbstractController{

	private final String TELA_APOSTA_LIST= PATH_PAGES+"/aposta/aposta-list.xhtml";
	private final String TELA_APOSTA_EDIT= PATH_PAGES+"/aposta/aposta-edit.xhtml";
	
	private List<ApostaEntity>entities;
	private ApostaEntity apostaCadastrar;
	private List<PaisEntity> paisList;
	private PaisEntity paisSelecionada;
	private List<CompeticaoEntity>competicaoList;
	private List<TimeEntity> timeList;
	private List<MercadoApostaSelecaoEntity> mercadoSelecaoList;
	private MercadoApostaSelecaoEntity mercadoSelecaoSelecionado;
	private List<MercadoApostaEntity> mercadoApostaList;
	private List<PlanoJogoEntity> planoJogoList;
	private PlanoJogoEntity planoJogoSelecionado;
	private List<PlanoJogoItemEntity> planoJogoItemList;
	
	private BigDecimal valorApostaSugerido;
	
	public ApostaBean() {

	}
	
	@Override
	public String iniciarTela() {
		
		entities = apostaService.listarTodos();
		
		return TELA_APOSTA_LIST;
	}
	
	public String navegarEditar(ApostaEntity selected){
		apostaCadastrar = selected;
		
		try{
			planoJogoList = planoJogoService.listarTodosAtivos();
		}catch(BusinessException b){
			FacesUtils.addErrorMessage(b.getMessage());
			return "";
		}
		
		planoJogoSelecionado = apostaCadastrar.getPlanoJogoItem().getPlanoJogo();
		planoJogoItemList = planoJogoItemService.buscarPorPlanoJogoId(planoJogoSelecionado.getId());
		
		paisList = paisService.listarTodosComCompeticaoAssociada();
		paisSelecionada = apostaCadastrar.getBet().getCompeticao().getPais();
		carregarComboCompeticao();
		mercadoSelecaoList = mercadoApostaSelecaoService.listarTodos();
		setMercadoSelecaoSelecionado(apostaCadastrar.getBet().getEvento().getMercado().getSelecao());
		carregarComboMercadoAposta();
		apostaCadastrar.getBet().getEvento().setMercado(apostaCadastrar.getBet().getEvento().getMercado());
		apostaCadastrar.setResultado(apostaCadastrar.getResultado());
		
		return TELA_APOSTA_EDIT;
	}

	public void navegarExcluir(ApostaEntity selected){
		apostaService.excluirEntidade(selected);
		iniciarTela();
	}
	
	public String navegarCadastrar(){
		initApostaEntityObj();

		try{
			planoJogoList = planoJogoService.listarTodos();
		}catch(BusinessException b){
			FacesUtils.addErrorMessage(b.getMessage());
			return "";
		}
		
		planoJogoSelecionado = planoJogoList.get(0);
		onchangePlanojogoCombo();
		
		paisList = paisService.listarTodosComCompeticaoAssociada();
		paisSelecionada = paisList.get(0);
		carregarComboCompeticao();
		mercadoSelecaoList = mercadoApostaSelecaoService.listarTodos();
		setMercadoSelecaoSelecionado(mercadoSelecaoList.get(0));
		carregarComboMercadoAposta();
		apostaCadastrar.getBet().getEvento().setMercado(mercadoApostaList.get(0));
		apostaCadastrar.getBet().getEvento().setDataEvento(new Date());
		apostaCadastrar.setResultado(getApostaResultadoList().get(0));
		
		return TELA_APOSTA_EDIT;
	}
	
	public String navegarCadastrarDePalpite(PalpiteEntity palpite){
		initApostaEntityObj();
		apostaCadastrar.getBet().setCompeticao(palpite.getCompeticao());
		apostaCadastrar.getBet().getEvento().setMercado(palpite.getMercadoAposta());
		apostaCadastrar.getBet().getEvento().setTimeCasa(palpite.getTimeCasa());
		apostaCadastrar.getBet().getEvento().setTimeVisitante(palpite.getTimeVisitante());
		apostaCadastrar.getBet().getEvento().setDataEvento(palpite.getDataEvento());
		
		
		try{
			planoJogoList = planoJogoService.listarTodosAtivos();
		}catch(BusinessException b){
			FacesUtils.addErrorMessage(b.getMessage());
			return "";
		}
		
		planoJogoSelecionado = planoJogoList.get(0);
		onchangePlanojogoCombo();
		
		paisList = paisService.listarTodosComCompeticaoAssociada();
		paisSelecionada = apostaCadastrar.getBet().getCompeticao().getPais();
		carregarComboCompeticao();
		mercadoSelecaoList = mercadoApostaSelecaoService.listarTodos();
		setMercadoSelecaoSelecionado(apostaCadastrar.getBet().getEvento().getMercado().getSelecao());
		carregarComboMercadoAposta();
		apostaCadastrar.setResultado(getApostaResultadoList().get(0));

		
		
		return TELA_APOSTA_EDIT;
	}
	
	public String salvar(){
		try{
			if(apostaCadastrar.getId() == null){
				apostaCadastrar.setTicket(new Date().getTime()+"");
				apostaService.adicionarEntidade(apostaCadastrar);
			}else{
				apostaService.editarEntidade(apostaCadastrar);
			}
		}catch(BusinessException b){
			System.err.println(b.getMessage());
			return "";
		}
		
		return iniciarTela();
	}

	private void initApostaEntityObj() {
		apostaCadastrar = new ApostaEntity();
		apostaCadastrar.setBet(new BetEntity());
		apostaCadastrar.setDataAposta(new Date());
		apostaCadastrar.setStatusResolvida(false);
		apostaCadastrar.setValorAposta(null);
		apostaCadastrar.setValorRetorno(null);
		apostaCadastrar.setResultado(null);
		apostaCadastrar.getBet().setCompeticao(new CompeticaoEntity());
		apostaCadastrar.getBet().setEvento(new EventoEntity());
		apostaCadastrar.getBet().getEvento().setMercado(new MercadoApostaEntity());
//		apostaCadastrar.getBet().getEvento().setResultado(null);
		apostaCadastrar.getBet().getEvento().setOdd(null);
		apostaCadastrar.getBet().getEvento().setTimeCasa(new TimeEntity());
		apostaCadastrar.getBet().getEvento().setTimeVisitante(new TimeEntity());
	}
	
	public void calculaValorRetornoPossivel(){
//		if(!(apostaCadastrar.getBet().getEvento().getOdd() == null || apostaCadastrar.getBet().getEvento().getOdd().compareTo(BigDecimal.ZERO)==0)){
//			apostaCadastrar.setValorRetorno(apostaCadastrar.getBet().getEvento().getOdd().setScale(3, RoundingMode.UP).multiply(apostaCadastrar.getValorAposta()));
//		}
	}
	
	public void calculaValorOdd(){
		if((apostaCadastrar.getValorAposta() != null && apostaCadastrar.getValorAposta().compareTo(BigDecimal.ZERO) > 0) && apostaCadastrar.getValorRetorno() != null){
			apostaCadastrar.getBet().getEvento().setOdd(apostaCadastrar.getValorRetorno().divide(apostaCadastrar.getValorAposta(), MathContext.DECIMAL128).setScale(3, RoundingMode.CEILING));
		}else{
			apostaCadastrar.getBet().getEvento().setOdd(null);
		}
	}
	
	public void onchangePlanojogoCombo(){
		planoJogoItemList = planoJogoItemService.buscarPorPlanoJogoId(planoJogoSelecionado.getId());
		for (int i = 0; i < planoJogoItemList.size(); i++) {
			if(!planoJogoItemList.get(i).isFinalizado()){
				apostaCadastrar.setPlanoJogoItem(planoJogoItemList.get(i));
				break;
			}else{
				apostaCadastrar.setPlanoJogoItem(planoJogoItemList.get(planoJogoItemList.size()-1));
			}
		}
		
		onchangePlanojogoItemCombo();
	}

	public void onchangePlanojogoItemCombo(){
		valorApostaSugerido = apostaCadastrar.getPlanoJogoItem().getVlrBetDia();
	}
	
	public void carregarComboCompeticao(){
		competicaoList = competicaoService.buscarPorPais(paisSelecionada);
		apostaCadastrar.getBet().setCompeticao(apostaCadastrar.getBet().getCompeticao()==null?competicaoList.get(0):apostaCadastrar.getBet().getCompeticao());
		carregarComboTime();
	}
	
	public void carregarComboTime(){
		timeList = timeService.buscarPorPais(paisSelecionada);
		if(timeList != null && !timeList.isEmpty()){
			apostaCadastrar.getBet().getEvento().setTimeCasa(apostaCadastrar.getBet().getEvento().getTimeCasa()==null?timeList.get(0):apostaCadastrar.getBet().getEvento().getTimeCasa());
			apostaCadastrar.getBet().getEvento().setTimeVisitante(apostaCadastrar.getBet().getEvento().getTimeVisitante()==null?(timeList.size()>0?timeList.get(1):timeList.get(0)):apostaCadastrar.getBet().getEvento().getTimeVisitante());
		}
	}
	
	public void carregarComboMercadoAposta(){
		mercadoApostaList = mercadoApostaService.buscarPorMercadoSelecao(mercadoSelecaoSelecionado);
	}	
	
	
	/* -------------------------------------------------------- */	
	public List<ApostaEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<ApostaEntity> entities) {
		this.entities = entities;
	}

	public ApostaEntity getApostaCadastrar() {
		return apostaCadastrar;
	}

	public void setApostaCadastrar(ApostaEntity apostaCadastrar) {
		this.apostaCadastrar = apostaCadastrar;
	}

	public List<MercadoApostaEntity> getMercadoApostaList() {
		return mercadoApostaList;
	}

	public void setMercadoApostaList(List<MercadoApostaEntity> mercadoApostaList) {
		this.mercadoApostaList = mercadoApostaList;
	}

	public List<CompeticaoEntity> getCompeticaoList() {
		return competicaoList;
	}

	public void setCompeticaoList(List<CompeticaoEntity> competicaoList) {
		this.competicaoList = competicaoList;
	}

	public List<PlanoJogoEntity> getPlanoJogoList() {
		return planoJogoList;
	}

	public void setPlanoJogoList(List<PlanoJogoEntity> planoJogoList) {
		this.planoJogoList = planoJogoList;
	}

	public List<PlanoJogoItemEntity> getPlanoJogoItemList() {
		return planoJogoItemList;
	}

	public void setPlanoJogoItemList(List<PlanoJogoItemEntity> planoJogoItemList) {
		this.planoJogoItemList = planoJogoItemList;
	}

	public PlanoJogoEntity getPlanoJogoSelecionado() {
		return planoJogoSelecionado;
	}

	public void setPlanoJogoSelecionado(PlanoJogoEntity planoJogoSelecionado) {
		this.planoJogoSelecionado = planoJogoSelecionado;
	}

	public BigDecimal getValorApostaSugerido() {
		return valorApostaSugerido;
	}

	public void setValorApostaSugerido(BigDecimal valorApostaSugerido) {
		this.valorApostaSugerido = valorApostaSugerido;
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

	public List<TimeEntity> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<TimeEntity> timeList) {
		this.timeList = timeList;
	}

	public MercadoApostaSelecaoEntity getMercadoSelecaoSelecionado() {
		return mercadoSelecaoSelecionado;
	}

	public void setMercadoSelecaoSelecionado(MercadoApostaSelecaoEntity mercadoSelecaoSelecionado) {
		this.mercadoSelecaoSelecionado = mercadoSelecaoSelecionado;
	}

	public List<MercadoApostaSelecaoEntity> getMercadoSelecaoList() {
		return mercadoSelecaoList;
	}

	public void setMercadoSelecaoList(
			List<MercadoApostaSelecaoEntity> mercadoSelecaoList) {
		this.mercadoSelecaoList = mercadoSelecaoList;
	}
	
}
