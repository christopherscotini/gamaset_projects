package br.com.gamaset.diaryboard.view.bean;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.diaryboard.exception.BusinessException;
import br.com.gamaset.diaryboard.model.ApostaEntity;
import br.com.gamaset.diaryboard.model.BetEntity;
import br.com.gamaset.diaryboard.model.CampeonatoEntity;
import br.com.gamaset.diaryboard.model.EventoEntity;
import br.com.gamaset.diaryboard.model.MercadoApostaEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoItemEntity;
import br.com.gamaset.diaryboard.model.TipsterEntity;
import br.com.gamaset.diaryboard.utils.FacesUtils;


@ManagedBean
@SessionScoped
public class ApostaBean extends BeanModel{

	private final String TELA_APOSTA_LIST= "/content/pages/aposta/aposta-list.xhtml";
	private final String TELA_APOSTA_EDIT= "/content/pages/aposta/aposta-edit.xhtml";
	
	private List<ApostaEntity>entities;
	private ApostaEntity apostaCadastrar;
	private List<CampeonatoEntity>campeonatoList;
	private List<MercadoApostaEntity> mercadosList;
	private List<TipsterEntity> tipsterList;
	private List<PlanoJogoEntity> planoJogoList;
	private PlanoJogoEntity planoJogoSelecionado;
	private List<PlanoJogoItemEntity> planoJogoItemList;
	
	public ApostaBean() {

	}
	
	@Override
	public String iniciarTela() {
		
		entities = apostaService.listarTodos();
		
		return TELA_APOSTA_LIST;
	}
	
	public String navegarEditar(ApostaEntity selected){
		apostaCadastrar = selected;
		
		campeonatoList = campeonatoService.listarTodos();
		mercadosList = mercadoApostaService.listarTodos();
		tipsterList = tipsterService.listarTodos();
		apostaCadastrar.getBet().setCampeonato(apostaCadastrar.getBet().getCampeonato());
		apostaCadastrar.getBet().getEvento().setMercado(apostaCadastrar.getBet().getEvento().getMercado());
		apostaCadastrar.setTipster(apostaCadastrar.getTipster());
		apostaCadastrar.setResultado(apostaCadastrar.getResultado());
		
		return TELA_APOSTA_EDIT;
	}

	public void navegarExcluir(ApostaEntity selected){
		apostaService.excluirEntidade(selected);
		iniciarTela();
	}
	
	public String navegarCadastrar(){
		initApostaEntityObj();
		campeonatoList = campeonatoService.listarTodos();
		mercadosList = mercadoApostaService.listarTodos();
		tipsterList = tipsterService.listarTodos();
		try{
			planoJogoList = planoJogoService.listarTodos();
		}catch(BusinessException b){
			FacesUtils.addErrorMessage(b.getMessage());
			return "";
		}
		planoJogoSelecionado = planoJogoList.get(0);
		planoJogoItemList = planoJogoItemService.buscarPorPlanoJogoId(planoJogoSelecionado);
		apostaCadastrar.getBet().setCampeonato(campeonatoList.get(0));
		apostaCadastrar.getBet().getEvento().setMercado(mercadosList.get(0));
		apostaCadastrar.setTipster(tipsterList.get(0));
		apostaCadastrar.setResultado(getResultadoApostaList().get(0));
		apostaCadastrar.setPlanoJogoItem(planoJogoItemList.get(0));
		onchangePlanojogoItemCombo();
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
			System.out.println(b.getMessage());
		}
		
		return iniciarTela();
	}

	private void initApostaEntityObj() {
		apostaCadastrar = new ApostaEntity();
		apostaCadastrar.setBet(new BetEntity());
		apostaCadastrar.setTipster(new TipsterEntity());
		apostaCadastrar.setDataAposta(new Date());
		apostaCadastrar.setStatusResolvida(false);
		apostaCadastrar.setValorAposta(null);
		apostaCadastrar.setValorRetorno(null);
		apostaCadastrar.setResultado(null);
		apostaCadastrar.getBet().setCampeonato(new CampeonatoEntity());
		apostaCadastrar.getBet().setEvento(new EventoEntity());
		apostaCadastrar.getBet().getEvento().setMercado(new MercadoApostaEntity());
//		apostaCadastrar.getBet().getEvento().setResultado(null);
		apostaCadastrar.getBet().getEvento().setOdd(null);
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
		planoJogoItemList = planoJogoItemService.buscarPorPlanoJogoId(planoJogoSelecionado);
		apostaCadastrar.setPlanoJogoItem(planoJogoItemList.get(0));
	}

	public void onchangePlanojogoItemCombo(){
		apostaCadastrar.setValorAposta(apostaCadastrar.getPlanoJogoItem().getVlrBetDia());
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

	public List<MercadoApostaEntity> getMercadosList() {
		return mercadosList;
	}

	public void setMercadosList(List<MercadoApostaEntity> mercadosList) {
		this.mercadosList = mercadosList;
	}

	public List<TipsterEntity> getTipsterList() {
		return tipsterList;
	}

	public void setTipsterList(List<TipsterEntity> tipsterList) {
		this.tipsterList = tipsterList;
	}

	public List<CampeonatoEntity> getCampeonatoList() {
		return campeonatoList;
	}

	public void setCampeonatoList(List<CampeonatoEntity> campeonatoList) {
		this.campeonatoList = campeonatoList;
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
	
	
}
